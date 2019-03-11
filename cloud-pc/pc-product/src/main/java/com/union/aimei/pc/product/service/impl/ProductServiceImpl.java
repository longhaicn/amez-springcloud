package com.union.aimei.pc.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.constant.store.StoreGrowthRuleEnum;
import com.union.aimei.common.feign.pc.store.*;
import com.union.aimei.common.model.product.*;
import com.union.aimei.common.model.store.*;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.*;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.common.vo.store.pc.StoreByBrandIdVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.aimei.pc.product.mapper.*;
import com.union.aimei.pc.product.service.ProductService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/5 14:43
 */
@SuppressWarnings("ALL")
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductImgMapper productImgMapper;
    @Resource
    private ProductStoreRefMapper productStoreRefMapper;
    @Resource
    private ProductCategoryRefMapper productCategoryRefMapper;
    @Resource
    private ProductCityMapper productCityMapper;
    @Resource
    private ProductProductPhysicalRefMapper productProductPhysicalRefMapper;
    @Resource
    private ProductBeauticianRefMapper productBeauticianRefMapper;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private StoreCouponsFeign storeCouponsFeign;
    @Resource
    private StoreCouponsProductFeign storeCouponsProductFeign;
    @Resource
    private StoreChainBrandFeign storeChainBrandFeign;
    @Resource
    private GrowthRuleFeign growthRuleFeign;

    @Override
    public PageInfo<Product> findByPageForFront(Integer pageNo, Integer pageSize, Product product) {
        PageHelper.startPage(pageNo, pageSize);
        List<Product> list = this.productMapper.selectListByConditions(product);
        PageInfo<Product> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<Product> add(Product product) {
        ResponseMessage<Product> responseMessage = new ResponseMessage<>();
        this.productMapper.insertSelective(product);
        responseMessage.setData(product);
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(Product product) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productMapper.updateByPrimaryKeySelective(product);
        return responseMessage;
    }

    /**
     * 保存项目（项目，项目图片，项目-分类-关联，项目-门店-关联）
     *
     * @param product                       项目
     * @param productImg                    项目图片
     * @param productCategoryRef            项目-分类-关联
     * @param storeList                     门店集合
     * @param productCityList               项目城市集合
     * @param storeProductBeauticianRefList 到店美容师集合
     * @param homeProductBeauticianRefList  上门美容师集合
     * @param productProductPhysicalRef     项目-产品-关联
     * @return
     */
    private Product saveProduct(Product product, ProductImg productImg, ProductCategoryRef productCategoryRef, List<Store> storeList, List<ProductCity> productCityList,
                                List<ProductBeauticianRef> storeProductBeauticianRefList, List<ProductBeauticianRef> homeProductBeauticianRefList, ProductProductPhysicalRef productProductPhysicalRef) {
        // 项目
        product.setSaleStatus(Product.SaleStatus.ON_SALE);
        if (Product.ProductType.STORE_SELF == product.getProductType()) {
            product.setAuditStatus(Product.AuditStatus.PENDING);
        } else {
            product.setAuditStatus(Product.AuditStatus.PASS);
        }
        this.productMapper.insertSelective(product);
        // 项目图片
        productImg.setProductId(product.getId());
        this.productImgMapper.insertSelective(productImg);
        // 项目-分类-关联
        productCategoryRef.setProductId(product.getId());
        this.productCategoryRefMapper.insertSelective(productCategoryRef);
        // 项目-门店-关联
        if (Product.ProductType.STORE_SELF == product.getProductType() || Product.ProductType.BRAND == product.getProductType()) {
            List<ProductStoreRef> productStoreRefList = new ArrayList<>(10);
            int storeSaleStatus = Product.ProductType.STORE_SELF == product.getProductType() ? Product.SaleStatus.ON_SALE : Product.SaleStatus.OFF_SHELVES;
            storeList.forEach(store -> {
                ProductStoreRef productStoreRef = new ProductStoreRef();
                productStoreRef.setProductId(product.getId());
                productStoreRef.setStoreId(store.getId());
                productStoreRef.setStoreName(store.getStoreName());
                productStoreRef.setSaleStatus(storeSaleStatus);
                productStoreRefList.add(productStoreRef);
            });
            this.productStoreRefMapper.addBatch(new ProductStoreRefByBatchVo(productStoreRefList));
        }
        // 项目城市
        productCityList.forEach(productCity -> {
            productCity.setProductId(product.getId());
        });
        this.productCityMapper.addBatch(new ProductCityByBatchVo(productCityList));
        // 项目-美容师-关联
        if (Product.ProductType.STORE_SELF == product.getProductType() || Product.ProductType.BRAND == product.getProductType()) {
            this.saveProductBeauticianRef(product, storeList, storeProductBeauticianRefList, homeProductBeauticianRefList);
        }
        // 项目-优惠券-关联
        if (Product.ProductType.STORE_SELF == product.getProductType() || Product.ProductType.BRAND == product.getProductType()) {
            this.saveCoupons(product, storeList);
        }
        // 项目-产品-关联
        if (Product.ProductType.PLATFORM_SELF == product.getProductType()) {
            if (null != productProductPhysicalRef) {
                productProductPhysicalRef.setProductId(product.getId());
                this.productProductPhysicalRefMapper.insertSelective(productProductPhysicalRef);
            }
        }
        return product;
    }

    /**
     * 保存项目-美容师-关联
     *
     * @param product                       项目
     * @param storeList                     门店集合
     * @param storeProductBeauticianRefList 到店美容师集合
     * @param homeProductBeauticianRefList  上门美容师集合
     * @return
     */
    private void saveProductBeauticianRef(Product product, List<Store> storeList, List<ProductBeauticianRef> storeProductBeauticianRefList, List<ProductBeauticianRef> homeProductBeauticianRefList) {
        List<ProductBeauticianRef> productBeauticianRefList = new ArrayList<>(10);
        storeList.forEach(store -> {
            // 是否支持到店
            if (product.getIsSupportStore() && CollectionUtils.isNotEmpty(storeProductBeauticianRefList)) {
                storeProductBeauticianRefList.forEach(productBeauticianRef -> {
                    productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
                    productBeauticianRef.setProductId(product.getId());
                    productBeauticianRef.setStoreId(store.getId());
                    productBeauticianRef.setStoreName(store.getStoreName());
                    productBeauticianRef.setServerType(Product.ServerType.STORE);
                    productBeauticianRef.setIsRecruit(false);
                    productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                    productBeauticianRef.setIsSelect(true);
                    productBeauticianRef.setIsOrder(true);
                    productBeauticianRefList.add(productBeauticianRef);
                });
            }
            // 是否支持上门
            if (product.getIsSupportHome() && CollectionUtils.isNotEmpty(homeProductBeauticianRefList)) {
                homeProductBeauticianRefList.forEach(productBeauticianRef -> {
                    productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
                    productBeauticianRef.setProductId(product.getId());
                    productBeauticianRef.setStoreId(store.getId());
                    productBeauticianRef.setStoreName(store.getStoreName());
                    productBeauticianRef.setServerType(Product.ServerType.HOME);
                    productBeauticianRef.setIsRecruit(false);
                    productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                    productBeauticianRef.setIsSelect(true);
                    productBeauticianRef.setIsOrder(true);
                    productBeauticianRefList.add(productBeauticianRef);
                });
            }
        });
        if (CollectionUtils.isNotEmpty(productBeauticianRefList)) {
            this.productBeauticianRefMapper.addBatch(productBeauticianRefList);
        }
    }

    /**
     * 保存项目-美容师-关联（默认选中，作废）
     *
     * @param product                       项目
     * @param storeList                     门店集合
     * @param storeProductBeauticianRefList 到店美容师集合
     * @param homeProductBeauticianRefList  上门美容师集合
     * @return
     */
    private void saveProductBeauticianRefSelect(Product product, List<Store> storeList, List<ProductBeauticianRef> storeProductBeauticianRefList, List<ProductBeauticianRef> homeProductBeauticianRefList) {
        List<ProductBeauticianRef> productBeauticianRefList = new ArrayList<>(10);
        List<Integer> storeBeauticianIdList = CollectionUtils.isNotEmpty(storeProductBeauticianRefList) ? storeProductBeauticianRefList.stream().map(ProductBeauticianRef::getBeauticianId).collect(Collectors.toList()) : null;
        List<Integer> homeBeauticianIdList = CollectionUtils.isNotEmpty(homeProductBeauticianRefList) ? homeProductBeauticianRefList.stream().map(ProductBeauticianRef::getBeauticianId).collect(Collectors.toList()) : null;
        storeList.forEach(store -> {
            ResponseMessage<List<StoreBeautician>> beauticianRes = this.storeBeauticianFeign.listFullTimeByStoreId(store.getId());
            if (ResponseUtil.isSuccess(beauticianRes)) {
                List<StoreBeautician> beauticianList = beauticianRes.getData();
                // 是否支持到店
                if (product.getIsSupportStore()) {
                    beauticianList.forEach(beautician -> {
                        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
                        productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
                        productBeauticianRef.setProductId(product.getId());
                        productBeauticianRef.setStoreId(store.getId());
                        productBeauticianRef.setStoreName(store.getStoreName());
                        productBeauticianRef.setBeauticianId(beautician.getId());
                        productBeauticianRef.setServerType(Product.ServerType.STORE);
                        productBeauticianRef.setIsRecruit(false);
                        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                        boolean isSelect = CollectionUtils.isNotEmpty(storeBeauticianIdList) ? storeBeauticianIdList.contains(beautician.getId()) : false;
                        productBeauticianRef.setIsSelect(isSelect);
                        productBeauticianRef.setIsOrder(true);
                        productBeauticianRefList.add(productBeauticianRef);
                    });
                }
                // 是否支持上门
                if (product.getIsSupportHome()) {
                    beauticianList.forEach(beautician -> {
                        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
                        productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
                        productBeauticianRef.setProductId(product.getId());
                        productBeauticianRef.setStoreId(store.getId());
                        productBeauticianRef.setStoreName(store.getStoreName());
                        productBeauticianRef.setBeauticianId(beautician.getId());
                        productBeauticianRef.setServerType(Product.ServerType.HOME);
                        productBeauticianRef.setIsRecruit(false);
                        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                        boolean isSelect = CollectionUtils.isNotEmpty(homeBeauticianIdList) ? homeBeauticianIdList.contains(beautician.getId()) : false;
                        productBeauticianRef.setIsSelect(isSelect);
                        productBeauticianRef.setIsOrder(true);
                        productBeauticianRefList.add(productBeauticianRef);
                    });
                }
            } else {
                if (StoreConstant.Query.BEAUTICIAN_STORE_FULL_TIME_NULL != beauticianRes.getCode()) {
                    throw new ResponseException(beauticianRes);
                }
            }
        });
        if (CollectionUtils.isNotEmpty(productBeauticianRefList)) {
            this.productBeauticianRefMapper.addBatch(productBeauticianRefList);
        }
    }

    /**
     * 保存优惠券
     *
     * @param product   项目
     * @param storeList 门店集合
     */
    private void saveCoupons(Product product, List<Store> storeList) {
        List<Integer> storeIdList = storeList.stream().map(Store::getId).collect(Collectors.toList());
        ResponseMessage<List<StoreCoupons>> couponsRes = this.storeCouponsFeign.listAllServiceByStoreIdBatch(new IdBatchVo(storeIdList));
        if (ResponseUtil.isSuccess(couponsRes)) {
            List<StoreCoupons> storeCouponsList = couponsRes.getData();
            List<StoreCouponsProduct> couponsProductList = new ArrayList<>(10);
            storeCouponsList.forEach(coupons -> {
                StoreCouponsProduct couponsProduct = new StoreCouponsProduct();
                couponsProduct.setStoreCouponsId(coupons.getId());
                couponsProduct.setStoreId(coupons.getStoreId());
                couponsProduct.setStoreName(coupons.getStoreName());
                couponsProduct.setProductId(product.getId());
                couponsProduct.setProductName(product.getServerName());
                couponsProductList.add(couponsProduct);
            });
            ResponseMessage couponsProductRes = this.storeCouponsProductFeign.addBatch(new StoreCouponsProductByBatchVo(couponsProductList));
            ResponseUtil.isFailThrowException(couponsProductRes);
        } else {
            if (StoreConstant.Query.COUPONS_STORE_NULL != couponsRes.getCode()) {
                throw new ResponseException(couponsRes);
            }
        }
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    public ResponseMessage addStoreSelf(ProductStoreSelfAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        ProductStoreRef productStoreRef = addVo.getProductStoreRef();
        List<Store> storeList = new ArrayList<>(10);
        ResponseMessage<Store> storeRes = this.storeFeign.findById(productStoreRef.getStoreId());
        ResponseUtil.isFailThrowException(storeRes);
        Store store = storeRes.getData();
        storeList.add(store);
        // 城市
        List<ProductCity> productCityList = new ArrayList<>(10);
        ProductCity productCity = new ProductCity();
        productCity.setCityId(store.getCityId());
        productCity.setCityName(store.getCityName());
        productCityList.add(productCity);
        // 保存项目
        this.saveProduct(addVo.getProduct(), addVo.getProductImg(), addVo.getProductCategoryRef(), storeList, productCityList, addVo.getStoreProductBeauticianRefList(), addVo.getHomeProductBeauticianRefList(), null);
        return responseMessage;
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    public ResponseMessage addBrand(ProductBrandAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        StoreByBrandIdVo brandIdVo = new StoreByBrandIdVo();
        brandIdVo.setBrandId(addVo.getProduct().getBrandId());
        List<ProductCity> productCityList = addVo.getProductCityList();
        List<Integer> cityIdList = productCityList.stream().map(ProductCity::getCityId).collect(Collectors.toList());
        brandIdVo.setCityIdList(cityIdList);
        ResponseMessage<List<Store>> storeRes = this.storeFeign.findListByBrandId(brandIdVo);
        List<Store> storeList = storeRes.getData();
        // 保存项目
        Product product = this.saveProduct(addVo.getProduct(), addVo.getProductImg(), addVo.getProductCategoryRef(), storeList, addVo.getProductCityList(), null, null, null);
        // 更新店铺连锁品牌服务项目总数
        if (null != product.getId()) {
            this.storeChainBrandFeign.accumProductTotalByBrandId(product.getBrandId(), StoreChainBrand.TOTAL_ADD);
        }
        return responseMessage;
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    public ResponseMessage addPlatformSelf(ProductPlatformSelfAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 保存项目
        this.saveProduct(addVo.getProduct(), addVo.getProductImg(), addVo.getProductCategoryRef(), null, addVo.getProductCityList(), null, null, addVo.getProductProductPhysicalRef());
        return responseMessage;
    }

    /**
     * 修改项目（项目，项目图片，项目-分类-关联，项目-门店-关联，项目城市，项目-美容师-关联）
     *
     * @param product            项目
     * @param productImg         项目图片
     * @param productCategoryRef 项目-分类-关联
     * @param storeList          门店集合
     * @param productCityList    项目城市集合
     * @return
     */

    private Product modifyByProduct(Product product, ProductImg productImg, ProductCategoryRef productCategoryRef, List<Store> storeList, List<ProductCity> productCityList,
                                    List<ProductBeauticianRef> storeProductBeauticianRefList, List<ProductBeauticianRef> homeProductBeauticianRefList, ProductProductPhysicalRef productProductPhysicalRef) {
        // 项目
        this.productMapper.updateByPrimaryKeySelective(product);
        // 项目图片
        this.productImgMapper.deleteByProductId(product.getId());
        productImg.setProductId(product.getId());
        this.productImgMapper.insertSelective(productImg);
        // 项目-分类-关联
        this.productCategoryRefMapper.deleteByProductId(product.getId());
        productCategoryRef.setProductId(product.getId());
        this.productCategoryRefMapper.insertSelective(productCategoryRef);
        // 品牌项目
        if (Product.ProductType.BRAND == product.getProductType()) {
            // 项目-门店-关联
            this.productStoreRefMapper.deleteByProductId(product.getId());
            List<ProductStoreRef> productStoreRefList = new ArrayList<>(10);
            storeList.forEach(store -> {
                ProductStoreRef productStoreRef = new ProductStoreRef();
                productStoreRef.setProductId(product.getId());
                productStoreRef.setStoreId(store.getId());
                productStoreRef.setStoreName(store.getStoreName());
                productStoreRef.setSaleStatus(Product.SaleStatus.OFF_SHELVES);
                productStoreRefList.add(productStoreRef);
            });
            this.productStoreRefMapper.addBatch(new ProductStoreRefByBatchVo(productStoreRefList));
            // 项目城市
            this.productCityMapper.deleteByProductId(product.getId());
            productCityList.forEach(productCity -> {
                productCity.setProductId(product.getId());
            });
            this.productCityMapper.addBatch(new ProductCityByBatchVo(productCityList));
            // 项目-优惠券-关联
            this.storeCouponsProductFeign.updateByIsEnabledByProductId(product.getId(), false);
            this.saveCoupons(product, storeList);
        }
        // 项目-美容师-关联
        if (Product.ProductType.STORE_SELF == product.getProductType() || Product.ProductType.BRAND == product.getProductType()) {
            this.productBeauticianRefMapper.deleteByProductId(product.getId());
            this.saveProductBeauticianRef(product, storeList, storeProductBeauticianRefList, homeProductBeauticianRefList);
        }
        // 平台自营项目
        if (Product.ProductType.PLATFORM_SELF == product.getProductType()) {
            // 项目-产品-关联
            this.productProductPhysicalRefMapper.deleteByProductId(product.getId());
            if (null != productProductPhysicalRef) {
                productProductPhysicalRef.setProductId(product.getId());
                this.productProductPhysicalRefMapper.insertSelective(productProductPhysicalRef);
            }
        }
        return product;
    }

    @Override
    public ResponseMessage modifyStoreSelf(ProductStoreSelfModifyVo modifyVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        ProductStoreRef productStoreRef = modifyVo.getProductStoreRef();
        List<Store> storeList = new ArrayList<>(10);
        ResponseMessage<Store> storeRes = this.storeFeign.findById(productStoreRef.getStoreId());
        ResponseUtil.isFailThrowException(storeRes);
        Store store = storeRes.getData();
        storeList.add(store);
        // 项目
        Product product = this.modifyByProduct(modifyVo.getProduct(), modifyVo.getProductImg(), modifyVo.getProductCategoryRef(), storeList, null, modifyVo.getStoreProductBeauticianRefList(), modifyVo.getHomeProductBeauticianRefList(), null);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyBrand(ProductBrandModifyVo modifyVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        StoreByBrandIdVo brandIdVo = new StoreByBrandIdVo();
        brandIdVo.setBrandId(modifyVo.getProduct().getBrandId());
        brandIdVo.setCityIdList(modifyVo.getProductCityList().stream().map(ProductCity::getCityId).collect(Collectors.toList()));
        ResponseMessage<List<Store>> storeRes = this.storeFeign.findListByBrandId(brandIdVo);
        List<Store> storeList = storeRes.getData();
        // 项目
        Product product = this.modifyByProduct(modifyVo.getProduct(), modifyVo.getProductImg(), modifyVo.getProductCategoryRef(), storeList, modifyVo.getProductCityList(), null, null, null);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyPlatformSelf(ProductPlatformSelfModifyVo modifyVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目
        Product product = this.modifyByProduct(modifyVo.getProduct(), modifyVo.getProductImg(), modifyVo.getProductCategoryRef(), null, modifyVo.getProductCityList(), null, null, modifyVo.getProductProductPhysicalRef());
        return responseMessage;
    }

    /**
     * 项目详情
     *
     * @param productId 项目ID
     * @param storeId   门店ID
     * @return
     */
    private ResponseMessage<ProductByDetailResVo> detail(int productId, Integer storeId) {
        ResponseMessage<ProductByDetailResVo> responseMessage = new ResponseMessage<>();
        ProductByDetailResVo resVo = new ProductByDetailResVo();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productId);
        resVo.setProduct(product);
        // 项目图片
        ProductImg productImg = this.productImgMapper.selectByProductId(productId);
        resVo.setProductImg(productImg);
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productId);
        resVo.setProductCategoryRef(productCategoryRef);
        // 项目-城市-关联
        ProductCity productCityCond = new ProductCity();
        productCityCond.setProductId(product.getId());
        List<ProductCity> productCityList = this.productCityMapper.selectListByConditions(productCityCond);
        resVo.setProductCityList(productCityList);
        // 项目-门店-关联
        // 项目-产品-关联
        if (Product.ProductType.PLATFORM_SELF == product.getProductType()) {
            ProductProductPhysicalRef productProductPhysicalRef = this.productProductPhysicalRefMapper.getByProductId(productId);
            resVo.setProductProductPhysicalRef(productProductPhysicalRef);
        }
        // 项目-美容师-关联集合
        if (Product.ProductType.STORE_SELF == product.getProductType() || Product.ProductType.BRAND == product.getProductType()) {
            // 到店
            List<ProductBeauticianRef> storeProductBeauticianRefList = new ArrayList<>(10);
            // 上门
            List<ProductBeauticianRef> homeProductBeauticianRefList = new ArrayList<>(10);
            ProductBeauticianRef productBeauticianRefCond = new ProductBeauticianRef();
            productBeauticianRefCond.setProductId(productId);
            productBeauticianRefCond.setStoreId(storeId);
            productBeauticianRefCond.setIsRecruit(false);
            List<ProductBeauticianRef> productBeauticianRefList = this.productBeauticianRefMapper.selectListByConditions(productBeauticianRefCond);
            if (CollectionUtils.isNotEmpty(productBeauticianRefList)) {
                productBeauticianRefList.forEach(productBeauticianRef -> {
                    switch (productBeauticianRef.getServerType()) {
                        case Product.ServerType.STORE:
                            storeProductBeauticianRefList.add(productBeauticianRef);
                            break;
                        case Product.ServerType.HOME:
                            homeProductBeauticianRefList.add(productBeauticianRef);
                            break;
                        default:
                            break;
                    }
                });
                resVo.setStoreProductBeauticianRefList(storeProductBeauticianRefList);
                resVo.setHomeProductBeauticianRefList(homeProductBeauticianRefList);
            }
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductByDetailResVo> detailByStoreSelf(int productId, int storeId) {
        return this.detail(productId, storeId);
    }

    @Override
    public ResponseMessage<ProductByDetailResVo> detailByBrand(int productId) {
        return this.detail(productId, null);
    }

    @Override
    public ResponseMessage<ProductByDetailResVo> detailByPlatformSelf(int productId) {
        return this.detail(productId, null);
    }

    @Override
    public ResponseMessage storeByOnSale(ProductByOnSaleVo productByOnSaleVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productByOnSaleVo.getProductId());
        // 门店自营，直接上架
        if (product.getIsBrand() == false && product.getIsPlatform() == false) {
            // 项目-门店-关联
            Map<String, Object> condMap = new HashMap<>(16);
            condMap.put("productId", productByOnSaleVo.getProductId());
            condMap.put("storeId", productByOnSaleVo.getStoreId());
            condMap.put("saleStatus", Product.SaleStatus.ON_SALE);
            this.productStoreRefMapper.updateSaleStatusByProductId(condMap);
            return responseMessage;
        }
        product.setHomeFee(productByOnSaleVo.getHomeFee());
        this.productMapper.updateByPrimaryKeySelective(product);
        // 项目-门店-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", productByOnSaleVo.getProductId());
        condMap.put("storeId", productByOnSaleVo.getStoreId());
        condMap.put("saleStatus", Product.SaleStatus.ON_SALE);
        this.productStoreRefMapper.updateSaleStatusByProductId(condMap);
        // 项目-美容师-关联
        List<ProductBeauticianRef> productBeauticianRefList = new ArrayList<>(10);
        // 根据项目ID删除项目-美容师-关联
        this.productBeauticianRefMapper.deleteByProductId(productByOnSaleVo.getProductId());
        // 支持到店标记
        List<ProductBeauticianRef> storeProductBeauticianRefList = productByOnSaleVo.getStoreProductBeauticianRefList();
        if (product.getIsSupportStore() && storeProductBeauticianRefList.size() > 0) {
            storeProductBeauticianRefList.forEach(productBeauticianRef -> {
                productBeauticianRef.setServerType(Product.ServerType.STORE);
                productBeauticianRef.setIsRecruit(false);
                productBeauticianRefList.add(productBeauticianRef);
            });
        }
        // 支付上门标记
        List<ProductBeauticianRef> homeProductBeauticianRefList = productByOnSaleVo.getHomeProductBeauticianRefList();
        if (product.getIsSupportHome() && homeProductBeauticianRefList.size() > 0) {
            homeProductBeauticianRefList.forEach(productBeauticianRef -> {
                productBeauticianRef.setServerType(Product.ServerType.HOME);
                productBeauticianRef.setIsRecruit(false);
                productBeauticianRefList.add(productBeauticianRef);
            });
        }
        // 自营
        if (product.getIsBrand() == false && product.getIsPlatform() == false) {
            // 招募
            List<ProductBeauticianRef> recruitProductBeauticianRefList = productByOnSaleVo.getRecruitProductBeauticianRefList();
            if (recruitProductBeauticianRefList.size() > 0) {
                recruitProductBeauticianRefList.forEach(productBeauticianRef -> {
                    // 支持到店标记
                    if (product.getIsSupportStore()) {
                        ProductBeauticianRef storeProductBeauticianRef = new ProductBeauticianRef(productBeauticianRef);
                        storeProductBeauticianRef.setServerType(Product.ServerType.STORE);
                        storeProductBeauticianRef.setIsRecruit(true);
                        productBeauticianRefList.add(storeProductBeauticianRef);
                    }
                    // 支付上门标记
                    if (product.getIsSupportHome()) {
                        ProductBeauticianRef homeProductBeauticianRef = new ProductBeauticianRef(productBeauticianRef);
                        homeProductBeauticianRef.setServerType(Product.ServerType.HOME);
                        homeProductBeauticianRef.setIsRecruit(true);
                        productBeauticianRefList.add(homeProductBeauticianRef);
                    }
                });
            }
        }
        productBeauticianRefList.forEach(productBeauticianRef -> {
            productBeauticianRef.setProductId(productByOnSaleVo.getProductId());
            productBeauticianRef.setStoreId(productByOnSaleVo.getStoreId());
            productBeauticianRef.setStoreName(productByOnSaleVo.getStoreName());
            productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
            productBeauticianRef.setIsSelect(true);
            productBeauticianRef.setIsOrder(true);
            productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
        });
        this.productBeauticianRefMapper.addBatch(productBeauticianRefList);
        return responseMessage;
    }

    @Override
    public ResponseMessage storeByOffShelves(ProductByOffShelvesVo offShelvesVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", offShelvesVo.getProductId());
        condMap.put("storeId", offShelvesVo.getStoreId());
        condMap.put("saleStatus", Product.SaleStatus.OFF_SHELVES);
        this.productStoreRefMapper.updateSaleStatusByProductId(condMap);
        return responseMessage;
    }

    @Override
    public ResponseMessage onSale(int id) {
        ResponseMessage responseMessage = new ResponseMessage();
        Product product = new Product();
        product.setId(id);
        product.setSaleStatus(Product.SaleStatus.ON_SALE);
        this.productMapper.updateByPrimaryKeySelective(product);
        return responseMessage;
    }

    @Override
    public ResponseMessage offShelves(int id) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目
        Product product = new Product();
        product.setId(id);
        product.setSaleStatus(Product.SaleStatus.OFF_SHELVES);
        this.productMapper.updateByPrimaryKeySelective(product);
        // 项目-门店-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", id);
        condMap.put("saleStatus", Product.SaleStatus.OFF_SHELVES);
        this.productStoreRefMapper.updateSaleStatusByProductId(condMap);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyAuditStatus(int id, int auditStatus, String auditReason) {
        //查询商品
        Product productSelect = this.productMapper.selectByPrimaryKey(id);
        if (null == productSelect) {
            throw new ServerException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        ResponseMessage responseMessage = new ResponseMessage();
        Product product = new Product();
        product.setId(id);
        product.setAuditStatus(auditStatus);
        product.setAuditReason(auditReason);
        this.productMapper.updateByPrimaryKeySelective(product);
        if (Product.AuditStatus.PASS == auditStatus) {
            // 成长值
            GrowthRuleVo growthRuleVo = new GrowthRuleVo();
            growthRuleVo.setCode(StoreGrowthRuleEnum.SELF_SUPPORT.getCode());
            growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.STORE);
            growthRuleVo.setSourceId(productSelect.getStoreId());
            growthRuleVo.setConnditionId(id);
            this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForBrand(Integer pageNo, Integer pageSize, ProductByBrandVo productByBrandVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<Product> list = this.productMapper.selectListByBrand(productByBrandVo);
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Product>> findListByBrandId(Integer brandId) {
        ResponseMessage<List<Product>> responseMessage = new ResponseMessage<>();
        Product productCond = new Product();
        productCond.setBrandId(brandId);
        productCond.setProductType(Product.ProductType.BRAND);
        productCond.setIsEnabled(true);
        List<Product> productList = this.productMapper.selectListByConditions(productCond);
        responseMessage.setData(productList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductByMemberCardResultVo>> findByPageForMemberCard(Integer pageNo, Integer pageSize, ProductByMemberCardVo productByMemberCardVo) {
        ResponseMessage<PageInfo<ProductByMemberCardResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductByMemberCardResultVo> list = this.productMapper.selectListByMemberCard(productByMemberCardVo);
        PageInfo<ProductByMemberCardResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForStore(Integer pageNo, Integer pageSize, ProByStoreVo storeVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<Product> list;
        if (null == storeVo.getStoreId()) {
            // 品牌，平台自营
            list = this.productMapper.selectListByMultipleStore(storeVo);
        } else {
            // 自营
            storeVo.setProductSaleStatus(ProByStoreVo.SALE_STATUS_ON_SALE);
            list = this.productMapper.selectListByStore(storeVo);
        }
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);

        return responseMessage;

    }

    @Override
    public ResponseMessage<Integer> pendingByCount(StoreByDataCountVo dataCountVo) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(dataCountVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", Product.AuditStatus.PENDING);
        condMap.putAll(voMap);
        int count = this.productMapper.pendingByCount(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addByCount(StoreByDataCountVo dataCountVo) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(dataCountVo), Map.class);
        int count = this.productMapper.addByCount(voMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Product>> findListByStoreId(int storeId) {
        ResponseMessage<List<Product>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", Product.AuditStatus.PASS);
        condMap.put("saleStatus", Product.SaleStatus.ON_SALE);
        condMap.put("storeId", storeId);
        List<Product> list = this.productMapper.selectListByStoreIdForSort(condMap);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Product>> findListByIdBatch(IdBatchVo idBatchVo) {
        ResponseMessage<List<Product>> responseMessage = new ResponseMessage<>();
        List<Product> list = this.productMapper.selectListByIdBatch(idBatchVo);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage labelByBatch(ProByLabelBatchVo labelBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productLabel", ProductCity.ProductLabel.DEFAUTL);
        condMap.put("cityId", labelBatchVo.getCityId());
        this.productCityMapper.labelByCityId(condMap);
        this.productCityMapper.addBatch(new ProductCityByBatchVo(labelBatchVo.getProductCityList()));
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForLabel(Integer pageNo, Integer pageSize, ProByLabelVo labelVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(labelVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.putAll(voMap);
        List<Product> list = this.productMapper.selectListByLabel(condMap);
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(ProductByStoreCouponsVo productByStoreCouponsVo) {
        ResponseMessage<ProductByStoreCouponsResultVo> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(productByStoreCouponsVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.onSaleStoreProduct();
        condMap.putAll(voMap);
        condMap.put("productType", Product.ProductType.BRAND);
        List<ProductByStoreCouponsForBrandResultVo> productByStoreCouponsForBrandResultVoList = this.productMapper.selectListByStoreCouponsForBrand(condMap);
        condMap.put("productType", Product.ProductType.STORE_SELF);
        List<ProductByStoreCouponsForSelfResultVo> productByStoreCouponsForSelfResultVoList = this.productMapper.selectListByStoreCouponsForSelf(condMap);
        // 返回结果（店铺优惠券）
        ProductByStoreCouponsResultVo productByStoreCouponsResultVo = new ProductByStoreCouponsResultVo();
        productByStoreCouponsResultVo.setProductByStoreCouponsForBrandResultVoList(productByStoreCouponsForBrandResultVoList);
        productByStoreCouponsResultVo.setProductByStoreCouponsForSelfResultVoList(productByStoreCouponsForSelfResultVoList);
        responseMessage.setData(productByStoreCouponsResultVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(IdBatchVo idBatchVo) {
        ResponseMessage<List<ProductByCategoryRefVo>> responseMessage = new ResponseMessage<>();
        List<ProductByCategoryRefVo> productByCategoryRefVoList = this.productMapper.findProductCategoryRefListByIdBatch(idBatchVo);
        responseMessage.setData(productByCategoryRefVoList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Integer>> findIsEnableIdListByIdBatchV110(IdBatchVo idBatchVo) {
        return new ResponseMessage<>(this.productMapper.findIsEnableIdListByIdBatch(idBatchVo));
    }

    @Override
    public ResponseMessage<PageInfo<Product>> listManage(Integer pageNo, Integer pageSize, ProductByManageVo manageVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(manageVo), Map.class);
        condMap.put("productSaleStatus", Product.SaleStatus.ON_SALE);
        List<Product> list = null;
        // 门店ID为空，管理员
        if (null == manageVo.getStoreId()) {
            switch (manageVo.getProductType()) {
                case Product.ProductType.STORE_SELF:
                    list = this.productMapper.listManageByStore(condMap);
                    break;
                case Product.ProductType.BRAND:
                    list = this.productMapper.listManage(condMap);
                    break;
                case Product.ProductType.PLATFORM_SELF:
                    list = this.productMapper.listManage(condMap);
                    break;
                default:
                    break;
            }
        } else {
            switch (manageVo.getProductType()) {
                case Product.ProductType.STORE_SELF:
                    list = this.productMapper.listManageByStore(condMap);
                    break;
                case Product.ProductType.BRAND:
                    list = this.productMapper.listManageByStore(condMap);
                    break;
                case Product.ProductType.PLATFORM_SELF:
                    break;
                default:
                    break;
            }
        }
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage removeById(int id) {
        ResponseMessage responseMessage = new ResponseMessage();
        //标识为删除
        Product product = new Product();
        product.setId(id);
        product.setIsEnabled(false);
        this.productMapper.updateByPrimaryKeySelective(product);
        // 更新 店铺连锁品牌 数量
        Product product1 = this.productMapper.selectByPrimaryKey(id);
        if (Product.ProductType.BRAND == product1.getProductType() && null != product1.getBrandId()) {
            responseMessage = this.storeChainBrandFeign.accumProductTotalByBrandId(product1.getBrandId(), StoreChainBrand.TOTAL_SUBTRACT);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Product>> listByStoreId(int storeId) {
        ResponseMessage<List<Product>> responseMessage = new ResponseMessage<>();
        List<Product> list = this.productMapper.listByStoreId(storeId);
        if (null == list) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_STORE_NULL, ProductConstant.Query.PRODUCT_STORE_NULL_MSG);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> listStoreHomeFloor(Integer pageNo, Integer pageSize, ProductListStoreHomeFloorVo homeFloorVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(homeFloorVo), Map.class);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        List<Integer> productTypeList = new ArrayList<>(10);
        productTypeList.add(Product.ProductType.STORE_SELF);
        productTypeList.add(Product.ProductType.BRAND);
        condMap.put("productTypeList", productTypeList);
        List<Product> list = this.productMapper.listStoreHomeFloor(condMap);
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForCouponsId(Integer pageNo, Integer pageSize, int couponsId) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        StoreCouponsProduct scpCond = new StoreCouponsProduct();
        scpCond.setIsEnabled(true);
        scpCond.setStoreCouponsId(couponsId);
        ResponseMessage<PageInfo<StoreCouponsProduct>> scpRes = this.storeCouponsProductFeign.findByPageForFront(pageNo, pageSize, scpCond);
        ResponseUtil.isFailThrowException(scpRes);
        PageInfo<StoreCouponsProduct> scpPage = scpRes.getData();
        List<StoreCouponsProduct> scpList = scpPage.getList();
        List<Product> productList = null;
        if (!scpList.isEmpty()) {
            List<Integer> productIdList = scpList.stream().map(StoreCouponsProduct::getProductId).collect(Collectors.toList());
            productList = this.productMapper.selectListByIdBatch(new IdBatchVo(productIdList));
            if (CollectionUtils.isEmpty(productList)) {
                throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
            }
        }
        PageInfo<Product> page = (PageInfo) scpPage;
        page.setList(productList);
        responseMessage.setData(page);
        return responseMessage;
    }


}