package com.union.aimei.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.CommissionEnum;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.constant.store.BeauticianGrowthRuleEnum;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.constant.store.StoreGrowthRuleEnum;
import com.union.aimei.common.feign.app.financial.CommissionSettingFeign;
import com.union.aimei.common.feign.app.store.GrowthRuleFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreChainBrandFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.feign.app.system.BaseDicGroupFeign;
import com.union.aimei.common.feign.app.system.BaseRegionFeign;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.aimei.common.model.product.*;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.common.ConditionResVo;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.ProjectPushCodeEnum;
import com.union.aimei.product.mapper.*;
import com.union.aimei.product.service.ProductService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/10 15:42
 */
@SuppressWarnings("ALL")
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductStoreRefMapper productStoreRefMapper;
    @Resource
    private ProductImgMapper productImgMapper;
    @Resource
    private ProductCategoryRefMapper productCategoryRefMapper;
    @Resource
    private ProductCollectionMapper productCollectionMapper;
    @Resource
    private ProductPhysicalBeauticianRefMapper productPhysicalBeauticianRefMapper;
    @Resource
    private ProductProductPhysicalRefMapper productProductPhysicalRefMapper;
    @Resource
    private ProductBeauticianRefMapper productBeauticianRefMapper;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private ProductCategoryMapper productCategoryMapper;
    @Resource
    private BaseRegionFeign baseRegionFeign;
    @Resource
    private BaseDicGroupFeign baseDicGroupFeign;
    @Resource
    private StoreChainBrandFeign storeChainBrandFeign;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private CommissionSettingFeign commissionSettingFeign;
    @Resource
    private GrowthRuleFeign growthRuleFeign;
    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForFront(Integer pageNo, Integer pageSize, Product product) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<Product> list = this.productMapper.selectListByConditions(product);
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public int addObj(Product product) {
        return this.productMapper.insertSelective(product);
    }

    @Override
    public int deleteObjById(int id) {
        return this.productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int modifyObj(Product product) {
        return this.productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Product queryObjById(int id) {
        Product product = this.productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public ResponseMessage<PageInfo<ProductByNameResultVo>> findByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo) {
        ResponseMessage<PageInfo<ProductByNameResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productStoreByNameVo), Map.class);
        List<Integer> productTypeList = new ArrayList<>(10);
        productTypeList.add(Product.ProductType.STORE_SELF);
        productTypeList.add(Product.ProductType.BRAND);
        condMap.put("productTypeList", productTypeList);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        List<ProductByNameResultVo> list = this.productMapper.selectListByName(condMap);
        PageInfo<ProductByNameResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(ProductByStoreCouponsVo productByStoreCouponsVo) {
        ResponseMessage<ProductByStoreCouponsResultVo> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(productByStoreCouponsVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.putAll(ConditionUtil.onSaleProduct());
        condMap.putAll(voMap);
        List<ProductByStoreCouponsForBrandResultVo> productByStoreCouponsForBrandResultVoList = this.productMapper.selectListByStoreCouponsForBrand(condMap);
        List<ProductByStoreCouponsForSelfResultVo> productByStoreCouponsForSelfResultVoList = this.productMapper.selectListByStoreCouponsForSelf(condMap);
        // 返回结果（店铺优惠券）
        ProductByStoreCouponsResultVo productByStoreCouponsResultVo = new ProductByStoreCouponsResultVo();
        productByStoreCouponsResultVo.setProductByStoreCouponsForBrandResultVoList(productByStoreCouponsForBrandResultVoList);
        productByStoreCouponsResultVo.setProductByStoreCouponsForSelfResultVoList(productByStoreCouponsForSelfResultVoList);
        responseMessage.setData(productByStoreCouponsResultVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForStoreIdForSort(Integer pageNo, Integer pageSize, ProductByStoreIdForSortVo productByStoreIdForSortVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(productByStoreIdForSortVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.putAll(voMap);
        List<Product> list = this.productMapper.selectListByStoreIdForSort(condMap);
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage onSaleV111(ProductOnSaleVo onSaleVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-门店-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", onSaleVo.getProductId());
        condMap.put("storeId", onSaleVo.getStoreId());
        ProductStoreRef productStoreRef = this.productStoreRefMapper.getByRefId(condMap);
        productStoreRef.setSaleStatus(Product.SaleStatus.ON_SALE);
        this.productStoreRefMapper.updateByPrimaryKeySelective(productStoreRef);
        // 移除选择项目-美容师-关联
        Map<String, Object> cancelMap = new HashMap<>(16);
        cancelMap.put("productId", onSaleVo.getProductId());
        cancelMap.put("storeId", onSaleVo.getStoreId());
        this.productBeauticianRefMapper.cancelSelect(cancelMap);
        // 项目-美容师-关联
        List<ProductBeauticianRef> productBeauticianRefList = new ArrayList<>(10);
        // 到店美容师
        List<Integer> storeBeauticianIdList = onSaleVo.getStoreBeauticianIdList();
        if (CollectionUtils.isNotEmpty(storeBeauticianIdList)) {
            // 删除到店项目-美容师-关联
            Map<String, Object> removeMap = new HashMap<>(16);
            removeMap.put("productId", onSaleVo.getProductId());
            removeMap.put("storeId", onSaleVo.getStoreId());
            removeMap.put("serverType", Product.ServerType.STORE);
            removeMap.put("beauticianIdList", storeBeauticianIdList);
            this.productBeauticianRefMapper.removeStoreByProductId(removeMap);
            // 选择到店项目-美容师-关联
            storeBeauticianIdList.forEach(beauticianId -> {
                ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
                productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
                productBeauticianRef.setProductId(productStoreRef.getProductId());
                productBeauticianRef.setStoreId(productStoreRef.getStoreId());
                productBeauticianRef.setStoreName(productStoreRef.getStoreName());
                productBeauticianRef.setBeauticianId(beauticianId);
                productBeauticianRef.setServerType(Product.ServerType.STORE);
                productBeauticianRef.setIsRecruit(false);
                productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                productBeauticianRef.setIsSelect(true);
                productBeauticianRef.setIsOrder(true);
                productBeauticianRefList.add(productBeauticianRef);
            });
        }
        // 上门美容师
        List<Integer> homeBeauticianIdList = onSaleVo.getHomeBeauticianIdList();
        if (CollectionUtils.isNotEmpty(homeBeauticianIdList)) {
            // 删除上门项目-美容师-关联
            Map<String, Object> removeMap = new HashMap<>(16);
            removeMap.put("productId", onSaleVo.getProductId());
            removeMap.put("storeId", onSaleVo.getStoreId());
            removeMap.put("serverType", Product.ServerType.HOME);
            removeMap.put("beauticianIdList", homeBeauticianIdList);
            this.productBeauticianRefMapper.removeStoreByProductId(removeMap);
            // 选择上门项目-美容师-关联
            homeBeauticianIdList.forEach(beauticianId -> {
                ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
                productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
                productBeauticianRef.setProductId(productStoreRef.getProductId());
                productBeauticianRef.setStoreId(productStoreRef.getStoreId());
                productBeauticianRef.setStoreName(productStoreRef.getStoreName());
                productBeauticianRef.setBeauticianId(beauticianId);
                productBeauticianRef.setServerType(Product.ServerType.HOME);
                productBeauticianRef.setIsRecruit(false);
                productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                productBeauticianRef.setIsSelect(true);
                productBeauticianRef.setIsOrder(true);
                productBeauticianRefList.add(productBeauticianRef);
            });
        }
        if (CollectionUtils.isNotEmpty(productBeauticianRefList)) {
            this.productBeauticianRefMapper.addBatch(new ProductBeauticianRefByBatchVo(productBeauticianRefList));
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage offShelvesV111(ProductOffShelvesVo offShelvesVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", offShelvesVo.getProductId());
        condMap.put("storeId", offShelvesVo.getStoreId());
        ProductStoreRef productStoreRef = this.productStoreRefMapper.getByRefId(condMap);
        productStoreRef.setSaleStatus(Product.SaleStatus.OFF_SHELVES);
        this.productStoreRefMapper.updateByPrimaryKeySelective(productStoreRef);
        return responseMessage;
    }

    @SuppressWarnings("AlibabaAvoidComplexCondition")
    @Override
    public ResponseMessage<ProductByDetailByResultVo> detail(ProductByDetailVo productByDetailVo) {
        ResponseMessage<ProductByDetailByResultVo> responseMessage = new ResponseMessage<>();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productByDetailVo.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目图片
        ProductImg productImg = this.productImgMapper.selectByProductId(productByDetailVo.getProductId());
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productByDetailVo.getProductId());
        // 项目收藏
        Map<String, Object> collectionMap = new HashMap<>(16);
        collectionMap.put("productId", productByDetailVo.getProductId());
        collectionMap.put("memberId", productByDetailVo.getMemberId());
        boolean isCollection = this.productCollectionMapper.isCollection(collectionMap);
        // 项目详情结果
        ProductByDetailByResultVo productByDetailByResultVo = new ProductByDetailByResultVo();
        productByDetailByResultVo.setProduct(product);
        productByDetailByResultVo.setProductImg(productImg);
        productByDetailByResultVo.setProductCategoryRef(productCategoryRef);
        productByDetailByResultVo.setIsCollection(isCollection);
        responseMessage.setData(productByDetailByResultVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Product> findBySaleStatus(int storeId, int productId) {
        ResponseMessage<Product> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.put("storeId", storeId);
        condMap.put("productId", productId);
        Product product = this.productMapper.selectBySaleStatusForStore(condMap);
        if (product != null) {
            responseMessage.setData(product);
        } else {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
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
    public ResponseMessage collection(ProductCollection productCollection) {
        //判断服务是否上架
        Product productValication = this.productMapper.selectByPrimaryKey(productCollection.getProductId());
        if (null == productValication) {
            throw new ServerException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        } else if (Product.SaleStatus.ON_SALE != productValication.getSaleStatus()) {
            throw new ServerException(ProductConstant.Query.PRODUCT_OFF_SHELVES, ProductConstant.Query.PRODUCT_OFF_SHELVES_MSG);
        }
        ResponseMessage responseMessage = new ResponseMessage();
        ProductCollection productCollectionCond = new ProductCollection();
        productCollectionCond.setProductId(productCollection.getProductId());
        productCollectionCond.setMemberId(productCollection.getMemberId());
        List<ProductCollection> productCollectionList = this.productCollectionMapper.selectListByMemberIdProductId(productCollectionCond);
        Product product = new Product();
        product.setId(productCollection.getProductId());
        if (productCollectionList.isEmpty()) {
            this.productCollectionMapper.insertSelective(productCollection);
            product.setCollectionTotal(1);
        } else {
            ProductCollection existProductCollection = productCollectionList.get(0);
            if (existProductCollection.getIsEnabled()) {
                if (productCollection.getIsEnabled()) {
                    responseMessage.setCode(ProductConstant.Save.PRODUCT_COLLECTION_COLLECTIONED);
                    responseMessage.setMessage(ProductConstant.Save.PRODUCT_COLLECTION_COLLECTIONED_MSG);
                    return responseMessage;
                }
                product.setCollectionTotal(1);
            } else {
                if (!productCollection.getIsEnabled()) {
                    responseMessage.setCode(ProductConstant.Save.PRODUCT_COLLECTION_CANCELED);
                    responseMessage.setMessage(ProductConstant.Save.PRODUCT_COLLECTION_CANCELED_MSG);
                    return responseMessage;
                }
                product.setCollectionTotal(-1);
            }
            existProductCollection.setIsEnabled(productCollection.getIsEnabled());
            this.productCollectionMapper.updateByPrimaryKeySelective(existProductCollection);
        }
        this.productMapper.updateByCollectionTotal(product);
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryCheck(ProductByInventoryVo inventoryVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = 0;
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(inventoryVo), Map.class);
        if (result == 0) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
            return responseMessage;
        }
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage inventoryOrderReservation(ProductByInventoryVo inventoryVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ProductProductPhysicalRef> productProductPhysicalRefList = this.productProductPhysicalRefMapper.selectListByProductId(inventoryVo.getProductId());
        if (!productProductPhysicalRefList.isEmpty()) {
            // 库存检查
            responseMessage = this.inventoryCheck(inventoryVo);
            if (ResponseUtil.isFail(responseMessage)) {
                return responseMessage;
            }
            productProductPhysicalRefList.forEach(productProductPhysicalRef -> {
                ProductPhysicalBeauticianRefByInventoryVo productPhysicalBeauticianRefByInventoryVo = new ProductPhysicalBeauticianRefByInventoryVo();
                productPhysicalBeauticianRefByInventoryVo.setProductPhysicalId(productProductPhysicalRef.getProductPhysicalId());
                productPhysicalBeauticianRefByInventoryVo.setPhysicalNumber(productProductPhysicalRef.getPhysicalNumber());
                if (inventoryVo.getIsBeauticianInventory()) {
                    productPhysicalBeauticianRefByInventoryVo.setBeauticianId(inventoryVo.getBeauticianId());
                    this.productPhysicalBeauticianRefMapper.inventoryOrderReservationByBeautician(productPhysicalBeauticianRefByInventoryVo);
                } else {
                    productPhysicalBeauticianRefByInventoryVo.setStoreId(inventoryVo.getStoreId());
                    this.productPhysicalBeauticianRefMapper.inventoryOrderReservationByStore(productPhysicalBeauticianRefByInventoryVo);
                }
            });
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryCancelOrderReservation(ProductByInventoryCancelOrderReservationVo inventoryCancelOrderReservationVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ProductByInventoryForProductPhysicalVo> productPhysicalList = inventoryCancelOrderReservationVo.getProductPhysicalList();
        if (!productPhysicalList.isEmpty()) {
            ProductByInventoryVo inventoryVo = inventoryCancelOrderReservationVo.getInventory();
            productPhysicalList.forEach(productPhysical -> {
                ProductPhysicalBeauticianRefByInventoryVo productPhysicalBeauticianRefByInventoryVo = new ProductPhysicalBeauticianRefByInventoryVo();
                productPhysicalBeauticianRefByInventoryVo.setProductPhysicalId(productPhysical.getProductPhysicalId());
                productPhysicalBeauticianRefByInventoryVo.setPhysicalNumber(productPhysical.getPhysicalNumber());
                if (inventoryVo.getIsBeauticianInventory()) {
                    productPhysicalBeauticianRefByInventoryVo.setBeauticianId(inventoryVo.getBeauticianId());
                    this.productPhysicalBeauticianRefMapper.inventoryCancelOrderReservationByBeautician(productPhysicalBeauticianRefByInventoryVo);
                } else {
                    productPhysicalBeauticianRefByInventoryVo.setStoreId(inventoryVo.getStoreId());
                    this.productPhysicalBeauticianRefMapper.inventoryCancelOrderReservationByStore(productPhysicalBeauticianRefByInventoryVo);
                }
            });
        }
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage inventoryConsumption(ProductByInventoryVo inventoryVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ProductProductPhysicalRef> productProductPhysicalRefList = this.productProductPhysicalRefMapper.selectListByProductId(inventoryVo.getProductId());
        if (!productProductPhysicalRefList.isEmpty()) {
            productProductPhysicalRefList.forEach(productProductPhysicalRef -> {
                ProductPhysicalBeauticianRefByInventoryVo productPhysicalBeauticianRefByInventoryVo = new ProductPhysicalBeauticianRefByInventoryVo();
                productPhysicalBeauticianRefByInventoryVo.setProductPhysicalId(productProductPhysicalRef.getProductPhysicalId());
                productPhysicalBeauticianRefByInventoryVo.setPhysicalNumber(productProductPhysicalRef.getPhysicalNumber());
                if (inventoryVo.getIsBeauticianInventory()) {
                    productPhysicalBeauticianRefByInventoryVo.setBeauticianId(inventoryVo.getBeauticianId());
                    this.productPhysicalBeauticianRefMapper.inventoryConsumptionByBeautician(productPhysicalBeauticianRefByInventoryVo);
                } else {
                    productPhysicalBeauticianRefByInventoryVo.setStoreId(inventoryVo.getStoreId());
                    this.productPhysicalBeauticianRefMapper.inventoryConsumptionByStore(productPhysicalBeauticianRefByInventoryVo);
                }
            });
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<Product> findById(int id) {
        ResponseMessage<Product> responseMessage = new ResponseMessage<>();
        Product product = this.productMapper.selectByPrimaryKey(id);
        if (product == null) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_NULL);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(product);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<ProductBySaleVolumeVo> accumulateBySaleVolume(ProductBySaleVolumeVo productBySaleVolumeVo) {
        ResponseMessage<ProductBySaleVolumeVo> responseMessage = new ResponseMessage<>();
        this.productMapper.accumulateBySaleVolume(productBySaleVolumeVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Product>> findByPageForSelect(Integer pageNo, Integer pageSize, ProductBySelectVo selectVo) {
        ResponseMessage<PageInfo<Product>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(selectVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.put("productLabel", ProductCity.ProductLabel.SELECT);
        condMap.putAll(voMap);
        List<Product> list = this.productMapper.selectListBySelect(condMap);
        PageInfo<Product> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Product>> findListByStoreId(int storeId) {
        ResponseMessage<List<Product>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.put("storeId", storeId);
        List<Product> list = this.productMapper.selectListByStoreIdForSort(condMap);
        responseMessage.setData(list);
        return responseMessage;
    }

    /**
     * 招募列表类型
     *
     * @param recruitVo       招募条件
     * @param sponsorList     发起方集合
     * @param auditStatusList 审核状态集合
     * @param productTypeList 项目类型集合
     */
    private void recruitByListType(ProductByRecruitVo recruitVo, List<Integer> sponsorList, List<Integer> auditStatusList, List<Integer> productTypeList) {
        switch (recruitVo.getListType()) {
            case ProductByRecruitVo.ListType.PRODUCT_MANAGE:
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
                break;
            case ProductByRecruitVo.ListType.PRODUCT_APPLY:
                sponsorList.add(ProductBeauticianRef.Sponsor.BEAUTICIAN);
                productTypeList.add(Product.ProductType.STORE_SELF);
                productTypeList.add(Product.ProductType.BRAND);
                recruitVo.setSaleStatus(Product.SaleStatus.ON_SALE);
                break;
            case ProductByRecruitVo.ListType.WAIT_STORE_AUDIT:
                sponsorList.add(ProductBeauticianRef.Sponsor.BEAUTICIAN);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
                productTypeList.add(Product.ProductType.STORE_SELF);
                productTypeList.add(Product.ProductType.BRAND);
                recruitVo.setSaleStatus(Product.SaleStatus.ON_SALE);
                break;
            case ProductByRecruitVo.ListType.APPLY_RESULT:
                sponsorList.add(ProductBeauticianRef.Sponsor.BEAUTICIAN);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.NOT_PASS);
                productTypeList.add(Product.ProductType.STORE_SELF);
                productTypeList.add(Product.ProductType.BRAND);
                recruitVo.setSaleStatus(Product.SaleStatus.ON_SALE);
                break;
            case ProductByRecruitVo.ListType.PRODUCT_INVINATION:
                sponsorList.add(ProductBeauticianRef.Sponsor.STORE);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
                productTypeList.add(Product.ProductType.STORE_SELF);
                productTypeList.add(Product.ProductType.BRAND);
                recruitVo.setSaleStatus(Product.SaleStatus.ON_SALE);
                break;
            case ProductByRecruitVo.ListType.ACCEPTED_INVINATION:
                sponsorList.add(ProductBeauticianRef.Sponsor.STORE);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.NOT_PASS);
                productTypeList.add(Product.ProductType.STORE_SELF);
                productTypeList.add(Product.ProductType.BRAND);
                recruitVo.setSaleStatus(Product.SaleStatus.ON_SALE);
                break;
            default:
                break;
        }
    }

    @Override
    public ResponseMessage<PageInfo<ProductByRecruitResVo>> findByPageForRecruitV111(Integer pageNo, Integer pageSize, ProductByRecruitVo recruitVo) {
        ResponseMessage<PageInfo<ProductByRecruitResVo>> responseMessage = new ResponseMessage<>();
        // 查询美容师类型
        Integer beauticianType = this.productMapper.selectBeauticianTypeByBeauticianId(recruitVo.getBeauticianId());
        if (null == beauticianType) {
            throw new ResponseException(ProductConstant.Query.BEAUTICIAN_NULL, ProductConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        //平台抽佣比例
        ResponseMessage<CommissionSetting> commissionSettingRes = this.commissionSettingFeign.selectByCommissionCode(CommissionEnum.PLATFORM.getType());
        ResponseUtil.isFailThrowException(commissionSettingRes);
        // 分页
        PageHelper.startPage(pageNo, pageSize);
        // 列表类型，1-项目管理，2-项目申请，3-待门店审核，4-申请结果，5-项目邀请，6-已接收的邀请
        List<Integer> sponsorList = new ArrayList<>(10);
        List<Integer> auditStatusList = new ArrayList<>(10);
        List<Integer> productTypeList = new ArrayList<>(10);
        this.recruitByListType(recruitVo, sponsorList, auditStatusList, productTypeList);
        if (StringUtils.isNotEmpty(recruitVo.getCommissionRatio())) {
            String[] arr = recruitVo.getCommissionRatio().split("-");
            recruitVo.setMinCommissionRatio(StringUtils.isEmpty(arr[0]) ? 0 : Integer.valueOf(arr[0]));
            if (arr.length > 1) {
                recruitVo.setMaxCommissionRatio(StringUtils.isEmpty(arr[1]) ? 0 : Integer.valueOf(arr[1]));
            }
        }
        if (StringUtils.isNotEmpty(recruitVo.getPriceRange())) {
            String[] arr = recruitVo.getPriceRange().split("-");
            recruitVo.setMinSalePirce(StringUtils.isEmpty(arr[0]) ? 0 : Integer.valueOf(arr[0]));
            if (arr.length > 1) {
                recruitVo.setMaxSalePrice(StringUtils.isEmpty(arr[1]) ? 0 : Integer.valueOf(arr[1]));
            }
        }
        //封装数据
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(recruitVo), Map.class);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        condMap.put("sponsorList", sponsorList);
        condMap.put("auditStatusList", auditStatusList);
        condMap.put("productTypeList", productTypeList);
        condMap.put("isOrder", (null == recruitVo.getSaleStatus()) ? true : recruitVo.getSaleStatus());
        condMap.put("beauticianType", beauticianType);
        condMap.put("commissionRate", commissionSettingRes.getData().getCommissionRate());
        condMap.put("isShow", ProductBeauticianRef.IsShow.SHOW);
        List<ProductByRecruitResVo> list;
        if (ProductByRecruitVo.ListType.PRODUCT_APPLY == recruitVo.getListType()) {
            List<Integer> applyAuditStatusList = new ArrayList<>(10);
            applyAuditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
            applyAuditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
            condMap.put("applyAuditStatusList", applyAuditStatusList);
            condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
            // 美容师条件
            List<Integer> beauticianAuditStatusList = new ArrayList<>(10);
            beauticianAuditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
            beauticianAuditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
            condMap.put("beauticianAuditStatusList", beauticianAuditStatusList);
            condMap.put("beauticianSponsor", ProductBeauticianRef.Sponsor.BEAUTICIAN);
            // 门店条件
            List<Integer> storeAuditStatusList = new ArrayList<>(10);
            storeAuditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
            condMap.put("storeAuditStatusList", storeAuditStatusList);
            condMap.put("storeSponsor", ProductBeauticianRef.Sponsor.STORE);
            list = this.productMapper.selectListByCanApplyForRecruit(condMap);
        } else {
            condMap.put("beauticianTypeFullTime", StoreBeautician.BeauticianType.FULL_TIME);
            if (ProductByRecruitVo.ListType.PRODUCT_MANAGE == recruitVo.getListType()) {
                condMap.put("platformSelfProductType", Product.ProductType.PLATFORM_SELF);
                condMap.put("platformSelfProductTypeValue", Product.productTypeMap.get(Product.ProductType.PLATFORM_SELF));
                list = this.productMapper.listRecruitManage(condMap);
            } else {
                condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
                list = this.productMapper.selectListByRecruit(condMap);
            }
        }
        PageInfo<ProductByRecruitResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> countByRecruitForInvinationV111(int beauticianId) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("sponsor", ProductBeauticianRef.Sponsor.STORE);
        condMap.put("auditStatus", ProductBeauticianRef.AuditStatus.PENDING);
        condMap.put("beauticianId", beauticianId);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        int count = this.productMapper.countByRecruitForInvination(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductByStoreIdForRecruitResVo>> findByPageByStoreIdForRecruitV111(Integer pageNo, Integer pageSize, int storeId) {
        ResponseMessage<PageInfo<ProductByStoreIdForRecruitResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = ConditionUtil.onSaleStoreProduct();
        condMap.put("sponsor", ProductBeauticianRef.Sponsor.BEAUTICIAN);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PENDING);
        condMap.put("storeId", storeId);
        List<ProductByStoreIdForRecruitResVo> list = this.productMapper.selectListByStoreIdForRecruit(condMap);
        PageInfo<ProductByStoreIdForRecruitResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> countByRecruitForApplyV111(int storeId, int productId) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("sponsor", ProductBeauticianRef.Sponsor.BEAUTICIAN);
        condMap.put("auditStatus", ProductBeauticianRef.AuditStatus.PENDING);
        condMap.put("storeId", storeId);
        condMap.put("productId", productId);
        int count = this.productMapper.countByRecruitForApply(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductListByBeauticianIdResVo>> listByBeauticianIdV111(Integer pageNo, Integer pageSize, ProductListByBeauticianIdVo beauticianIdVo) {
        ResponseMessage<PageInfo<ProductListByBeauticianIdResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(beauticianIdVo), Map.class);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        List<ProductListByBeauticianIdResVo> list = null;
        switch (beauticianIdVo.getListType()) {
            case ProductListByBeauticianIdVo.ListType.STORE:
                condMap.put("storeServerType", Product.ServerType.STORE);
                list = this.productMapper.listStoreByBeauticianId(condMap);
                break;
            case ProductListByBeauticianIdVo.ListType.HOME:
                condMap.put("homeServerType", Product.ServerType.HOME);
                condMap.put("fulltimeBeauticianType", StoreBeautician.BeauticianType.FULL_TIME);
                condMap.put("managerBeauticianType", StoreBeautician.BeauticianType.MANAGER);
                list = this.productMapper.listHomeByBeauticianId(condMap);
                break;
            default:
                break;
        }
        PageInfo<ProductListByBeauticianIdResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
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
    public ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchForStoreBeauticianV110(IdBatchVo idBatchVo) {
        ResponseMessage<List<ProductByCategoryRefVo>> responseMessage = new ResponseMessage<>();
        List<ProductByCategoryRefVo> productByCategoryRefVoList = this.productMapper.findProductCategoryRefListByIdBatchForStoreBeautician(idBatchVo);
        responseMessage.setData(productByCategoryRefVoList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductCategoryConditionResVo> getCategoryConditionV111(int cityId) {
        ResponseMessage<ProductCategoryConditionResVo> responseMessage = new ResponseMessage<>();
        ProductCategoryConditionResVo resVo = new ProductCategoryConditionResVo();
        // 连锁品牌
        ResponseMessage<List<StoreChainBrand>> storeChainBrandRes = this.storeChainBrandFeign.listAll();
        if (ResponseUtil.isSuccess(storeChainBrandRes)) {
            List<StoreChainBrand> storeChainBrandList = storeChainBrandRes.getData();
            if (CollectionUtils.isNotEmpty(storeChainBrandList)) {
                List<ConditionResVo> conditionList = new ArrayList<>(10);
                storeChainBrandList.forEach(storeChainBrand -> {
                    ConditionResVo condition = new ConditionResVo();
                    condition.setText(storeChainBrand.getBrandName());
                    condition.setValue(storeChainBrand.getId().toString());
                    conditionList.add(condition);
                });
                resVo.setBrandIdList(conditionList);
            }
        }
        // 服务时长
        ResponseMessage<BaseDicGroupDeatilResVo> serverNeedTimeRes = this.baseDicGroupFeign.detailByCodeV111("SERVER_NEED_TIME");
        if (ResponseUtil.isSuccess(serverNeedTimeRes)) {
            BaseDicGroupDeatilResVo deatilResVo = serverNeedTimeRes.getData();
            BaseDicGroup dicGroup = deatilResVo.getDicGroup();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setServerNeedTimeList(conditionList);
        }
        // 功效
        ResponseMessage<BaseDicGroupDeatilResVo> serverEffectRes = this.baseDicGroupFeign.detailByCodeV111("PRODUCT_SERVER_EFFECT");
        if (ResponseUtil.isSuccess(serverEffectRes)) {
            BaseDicGroupDeatilResVo deatilResVo = serverEffectRes.getData();
            BaseDicGroup dicGroup = deatilResVo.getDicGroup();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setServerEffectList(conditionList);
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductListDisplayResVo>> listByCategoryIdV111(Integer pageNo, Integer pageSize, ProductListByCategoryIdVo categoryIdVo) {
        ResponseMessage<PageInfo<ProductListDisplayResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(categoryIdVo), Map.class);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        // 服务所需耗时
        if (StringUtils.isNotEmpty(categoryIdVo.getServerNeedTime())) {
            String[] serverNeedTimeArr = categoryIdVo.getServerNeedTime().split("-");
            String minServerNeedTime = serverNeedTimeArr[0];
            String maxServerNeedTime = serverNeedTimeArr.length > 1 ? serverNeedTimeArr[1] : "";
            if (StringUtils.isNotEmpty(minServerNeedTime)) {
                condMap.put("minServerNeedTime", minServerNeedTime);
            }
            if (StringUtils.isNotEmpty(maxServerNeedTime)) {
                condMap.put("maxServerNeedTime", maxServerNeedTime);
            }
        }
        // 排序类型
        String sortType = "";
        if (null == categoryIdVo.getSortType()) {
            sortType = ProductListByCategoryIdVo.SortType.SALE_VOLUME_FIELD;
        } else {
            switch (categoryIdVo.getSortType()) {
                case ProductListByCategoryIdVo.SortType.SALE_VOLUME:
                    sortType = ProductListByCategoryIdVo.SortType.SALE_VOLUME_FIELD;
                    condMap.put("sort", false);
                    break;
                case ProductListByCategoryIdVo.SortType.NEW_PRODUCT:
                    sortType = ProductListByCategoryIdVo.SortType.NEW_PRODUCT_FIELD;
                    condMap.put("sort", false);
                    break;
                case ProductListByCategoryIdVo.SortType.PRICE:
                    sortType = ProductListByCategoryIdVo.SortType.PRICE_FIELD;
                    break;
                default:
                    sortType = ProductListByCategoryIdVo.SortType.SALE_VOLUME_FIELD;
                    break;
            }
        }
        condMap.put("sortType", sortType);
        List<Integer> productTypeList = new ArrayList<>(10);
        List<ProductListDisplayResVo> list = null;
        if (null == categoryIdVo.getServerType()) {
            categoryIdVo.setServerType(Product.ServerType.STORE);
        }
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.putAll(ConditionUtil.passBeautician());
        switch (categoryIdVo.getServerType()) {
            case Product.ServerType.STORE:
                productTypeList.add(Product.ProductType.STORE_SELF);
                productTypeList.add(Product.ProductType.BRAND);
                condMap.put("productTypeList", productTypeList);
                list = this.productMapper.listStoreByCategoryId(condMap);
                break;
            case Product.ServerType.HOME:
                productTypeList.add(Product.ProductType.PLATFORM_SELF);
                condMap.put("productTypeList", productTypeList);
                condMap.put("fulltimeBeauticianType", StoreBeautician.BeauticianType.FULL_TIME);
                condMap.put("managerBeauticianType", StoreBeautician.BeauticianType.MANAGER);
                list = this.productMapper.listHomeByCategoryId(condMap);
                break;
            default:
                break;
        }
        PageInfo<ProductListDisplayResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductListDisplayResVo>> listStoreByStoreIdV111(Integer pageNo, Integer pageSize, ProductListStoreByStoreIdVo storeIdVo) {
        ResponseMessage<PageInfo<ProductListDisplayResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        // 排序字段
        String sortType = "";
        if (null == storeIdVo.getSortType()) {
            sortType = ProductListStoreByStoreIdVo.SortType.SALE_VOLUME_FIELD;
        } else {
            switch (storeIdVo.getSortType()) {
                case ProductListStoreByStoreIdVo.SortType.SALE_VOLUME:
                    sortType = ProductListStoreByStoreIdVo.SortType.SALE_VOLUME_FIELD;
                    break;
                case ProductListStoreByStoreIdVo.SortType.NEW_PRODUCT:
                    sortType = ProductListStoreByStoreIdVo.SortType.NEW_PRODUCT_FIELD;
                    break;
                case ProductListStoreByStoreIdVo.SortType.PRICE:
                    sortType = ProductListStoreByStoreIdVo.SortType.PRICE_FIELD;
                    break;
                default:
                    sortType = ProductListStoreByStoreIdVo.SortType.SALE_VOLUME_FIELD;
                    break;
            }
        }
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(storeIdVo), Map.class);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("storeServerType", Product.ServerType.STORE);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.put("sortType", sortType);
        List<ProductListDisplayResVo> list = this.productMapper.listStoreByStoreId(condMap);
        PageInfo<ProductListDisplayResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryCheckV111(int productId) {
        ResponseMessage responseMessage = new ResponseMessage();
        ProductProductPhysicalRef productProductPhysicalRef = this.productProductPhysicalRefMapper.getByProductId(productId);
        if (null != productProductPhysicalRef) {
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(productProductPhysicalRef.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(productProductPhysicalRef.getPhysicalNumber());
            boolean inventoryFlag = this.productPhysicalBeauticianRefMapper.inventoryCheck(inventoryVo);
            if (!inventoryFlag) {
                responseMessage.setCode(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    /**
     * 库存归属
     *
     * @param beauticianId 美容师ID
     * @return
     */
    private Integer inventoryOwnershipV111(int beauticianId) {
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(beauticianId);
        ResponseUtil.isFailThrowException(beauticianRes);
        StoreBeautician beautician = beauticianRes.getData();
        // 全职美容师，消耗门店库存
        if (StoreBeautician.BeauticianType.FULL_TIME == beautician.getBeauticianType()) {
            ResponseMessage<StoreBeautician> managerBeauticianRes = this.storeBeauticianFeign.findManagerByBeauticianIdV111(beauticianId);
            ResponseUtil.isFailThrowException(managerBeauticianRes);
            StoreBeautician managerBeautician = managerBeauticianRes.getData();
            beauticianId = managerBeautician.getId();
        }
        return beauticianId;
    }

    @Override
    public ResponseMessage inventoryCheckByBeauticianIdV111(int productId, int beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 产品
        ProductProductPhysicalRef productProductPhysicalRef = this.productProductPhysicalRefMapper.getByProductId(productId);
        if (null != productProductPhysicalRef) {
            // 库存归属
            beauticianId = this.inventoryOwnershipV111(beauticianId);
            // 库存检查
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(productProductPhysicalRef.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(productProductPhysicalRef.getPhysicalNumber());
            inventoryVo.setBeauticianId(beauticianId);
            boolean inventoryFlag = this.productPhysicalBeauticianRefMapper.inventoryCheck(inventoryVo);
            if (!inventoryFlag) {
                responseMessage.setCode(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryOrderReservationV111(int productId, int beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 产品
        ProductProductPhysicalRef productProductPhysicalRef = this.productProductPhysicalRefMapper.getByProductId(productId);
        if (null != productProductPhysicalRef) {
            // 库存归属
            beauticianId = this.inventoryOwnershipV111(beauticianId);
            // 库存检查
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(productProductPhysicalRef.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(productProductPhysicalRef.getPhysicalNumber());
            inventoryVo.setBeauticianId(beauticianId);
            boolean inventoryFlag = this.productPhysicalBeauticianRefMapper.inventoryCheck(inventoryVo);
            if (!inventoryFlag) {
                responseMessage.setCode(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
            // 库存订单预约
            this.productPhysicalBeauticianRefMapper.inventoryOrderReservation(inventoryVo);
        }
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional
    public ResponseMessage inventoryCancelOrderReservationV111(ProductPhysicalByInventoryVo inventoryVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 产品
        if (null != inventoryVo.getProductPhysicalId()) {
            // 库存归属
            int beauticianId = this.inventoryOwnershipV111(inventoryVo.getBeauticianId());
            inventoryVo.setBeauticianId(beauticianId);
            int result = this.productPhysicalBeauticianRefMapper.inventoryCancelOrderReservation(inventoryVo);
            if (0 == result) {
                responseMessage.setCode(ProductConstant.Query.PHYSICAL_INVENTORY_CANCEL_ORDER_RESERVATION_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PHYSICAL_INVENTORY_CANCEL_ORDER_RESERVATION_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryConsumptionV111(ProductPhysicalByInventoryVo inventoryVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 产品
        if (null != inventoryVo.getProductPhysicalId()) {
            // 库存归属
            int beauticianId = this.inventoryOwnershipV111(inventoryVo.getBeauticianId());
            inventoryVo.setBeauticianId(beauticianId);
            int result = this.productPhysicalBeauticianRefMapper.inventoryConsumption(inventoryVo);
            if (0 == result) {
                responseMessage.setCode(ProductConstant.Query.PHYSICAL_INVENTORY_ORDER_CONSUMPTION_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PHYSICAL_INVENTORY_ORDER_CONSUMPTION_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductByDetailByManageForBeauticianResVo> detailByManageForBeauticianV111(int productBeauticianRefId, int beauticianId) {
        ResponseMessage<ProductByDetailByManageForBeauticianResVo> responseMessage = new ResponseMessage<>();
        // 美容师
        Integer beauticianType = this.productMapper.selectBeauticianTypeByBeauticianId(beauticianId);
        if (null == beauticianType) {
            responseMessage.setCode(ProductConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(ProductConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        //平台抽佣比例
        ResponseMessage<CommissionSetting> responseMessage1 = this.commissionSettingFeign.selectByCommissionCode(CommissionEnum.PLATFORM.getType());
        ResponseUtil.isFailThrowException(responseMessage1);
        // 项目-美容师-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("beauticianTypeFullTime", StoreBeautician.BeauticianType.FULL_TIME);
        condMap.put("productBeauticianRefId", productBeauticianRefId);
        condMap.put("beauticianType", beauticianType);
        condMap.put("commissionRate", responseMessage1.getData().getCommissionRate());
        ProductByDetailByManageForBeauticianResVo resVo = this.productMapper.getByProductBeauticianRefId(condMap);
        if (null == resVo) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductByDetailByApplyForBeauticianResVo> detailByApplyForBeauticianV111(int productStoreRefId, int beauticianId) {
        ResponseMessage<ProductByDetailByApplyForBeauticianResVo> responseMessage = new ResponseMessage<>();
        // 美容师
        Integer beauticianType = this.productMapper.selectBeauticianTypeByBeauticianId(beauticianId);
        if (null == beauticianType) {
            responseMessage.setCode(ProductConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(ProductConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        if (StoreBeautician.BeauticianType.PART_TIME != beauticianType) {
            responseMessage.setCode(ProductConstant.Query.BEAUTICIAN_STORE_SELF_NOT_RIGHT);
            responseMessage.setMessage(ProductConstant.Query.BEAUTICIAN_STORE_SELF_NOT_RIGHT_MSG);
            return responseMessage;
        }
        // 项目-门店-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productStoreRefId", productStoreRefId);
        ProductRecruitDetailResVo detailResVo = this.productMapper.getByProductStoreRefId(condMap);
        if (null == detailResVo) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_NULL);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(new ProductByDetailByApplyForBeauticianResVo(detailResVo));
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductRecruitDetailResVo> getRecruitDetailByStoreV111(int productStoreRefId, int beauticianId) {
        ResponseMessage<ProductRecruitDetailResVo> responseMessage = new ResponseMessage<>();
        // 美容师
        Integer beauticianType = this.productMapper.selectBeauticianTypeByBeauticianId(beauticianId);
        if (null == beauticianType) {
            responseMessage.setCode(ProductConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(ProductConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        if (StoreBeautician.BeauticianType.MANAGER != beauticianType) {
            responseMessage.setCode(ProductConstant.Query.BEAUTICIAN_STORE_SELF_NOT_RIGHT);
            responseMessage.setMessage(ProductConstant.Query.BEAUTICIAN_STORE_SELF_NOT_RIGHT_MSG);
            return responseMessage;
        }
        // 项目-门店-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productStoreRefId", productStoreRefId);
        ProductRecruitDetailResVo resVo = this.productMapper.getByProductStoreRefId(condMap);
        if (null == resVo) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_NULL);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductHomeDetailResVo> getHomeDetailV111(ProductHomeDetailVo detailVo) {
        ResponseMessage<ProductHomeDetailResVo> responseMessage = new ResponseMessage<>();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(detailVo.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目图片
        ProductImg productImg = this.productImgMapper.selectByProductId(detailVo.getProductId());
        if (null == productImg) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_IMG_NULL, ProductConstant.Query.PRODUCT_IMG_NULL_MSG);
        }
        // 美容师
        BeauticianNearestByProductIdVo productIdVo = new BeauticianNearestByProductIdVo();
        productIdVo.setProductId(detailVo.getProductId());
        productIdVo.setBeauticianId(detailVo.getBeauticianId());
        productIdVo.setCityId(detailVo.getCityId());
        productIdVo.setPoint(detailVo.getPoint());
        productIdVo.setServerNeedTime(product.getServerNeedTime());
        ResponseMessage<BeauticianNearestByProductIdResVo> beauticianRes = this.storeBeauticianFeign.getNearestByProductIdV111(productIdVo);
        if (ResponseUtil.isFail(beauticianRes)) {
            return (ResponseMessage) beauticianRes;
        }
        BeauticianNearestByProductIdResVo productIdForNearestResVo = beauticianRes.getData();
        // 是否收藏
        Map<String, Object> isCollectionMap = new HashMap<>(16);
        isCollectionMap.put("productId", detailVo.getProductId());
        isCollectionMap.put("memberId", detailVo.getMemberId());
        boolean isCollection = this.productCollectionMapper.isCollection(isCollectionMap);
        // 是否存在库存
        ResponseMessage inventoryRes = this.inventoryCheckV111(detailVo.getProductId());
        if (ResponseUtil.isFail(inventoryRes)) {
            return (ResponseMessage) inventoryRes;
        }
        // 结果
        ProductHomeDetailResVo resVo = new ProductHomeDetailResVo();
        resVo.setProduct(product);
        resVo.setProductImg(productImg);
        resVo.setBeautician(productIdForNearestResVo);
        resVo.setIsCollection(isCollection);
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> getCommissionRatioV111(int productId, int beauticianId) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productId);
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(beauticianId);
        ResponseUtil.isFailThrowException(beauticianRes);
        StoreBeautician beautician = beauticianRes.getData();
        // 美容师类型
        int commission = 0;
        switch (beautician.getBeauticianType()) {
            case StoreBeautician.BeauticianType.FULL_TIME:
                commission = product.getFulltimeCommissionRatio();
                break;
            case StoreBeautician.BeauticianType.PART_TIME:
                commission = product.getParttimeCommissionRatio();
                break;
            default:
                break;
        }
        responseMessage.setData(commission);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductRecruitConditionResVo> getRecruitConditionV111(int cityId) {
        ResponseMessage<ProductRecruitConditionResVo> responseMessage = new ResponseMessage<>();
        ProductRecruitConditionResVo resVo = new ProductRecruitConditionResVo();
        // 项目分类
        List<ProductCategory> productCategoryList = this.productCategoryMapper.listTop();
        if (CollectionUtils.isNotEmpty(productCategoryList)) {
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            productCategoryList.forEach(productCategory -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(productCategory.getCategoryName());
                condition.setValue(productCategory.getId().toString());
                conditionList.add(condition);
            });
            resVo.setCategoryList(conditionList);
        }
        // 地区位置
        ResponseMessage<List<BaseRegion>> regionRes = this.baseRegionFeign.listAreaByCityIdV111(cityId);
        if (ResponseUtil.isSuccess(regionRes)) {
            List<BaseRegion> regionList = regionRes.getData();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            regionList.forEach(region -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(region.getRegionName());
                condition.setValue(region.getRegionId().toString());
                conditionList.add(condition);
            });
            resVo.setAreaList(conditionList);
        }
        // 分成比例
        ResponseMessage<BaseDicGroupDeatilResVo> commissionRatioRes = this.baseDicGroupFeign.detailByCodeV111("PRODUCT_RECRUIT_CONDITION_COMMISSION_RATIO");
        if (ResponseUtil.isSuccess(commissionRatioRes)) {
            BaseDicGroupDeatilResVo deatilResVo = commissionRatioRes.getData();
            BaseDicGroup dicGroup = deatilResVo.getDicGroup();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setCommissionRatioList(conditionList);
        }
        // 价格范围
        ResponseMessage<BaseDicGroupDeatilResVo> priceRangeRes = this.baseDicGroupFeign.detailByCodeV111("PRODUCT_RECRUIT_CONDITION_PRICE_RANGE");
        if (ResponseUtil.isSuccess(priceRangeRes)) {
            BaseDicGroupDeatilResVo deatilResVo = priceRangeRes.getData();
            BaseDicGroup dicGroup = deatilResVo.getDicGroup();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setPriceRangeList(conditionList);
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductListManageResVo>> listManageV111(Integer pageNo, Integer pageSize, ProductListManageVo manageVo) {
        ResponseMessage<PageInfo<ProductListManageResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Integer auditStatus = null;
        Integer storeSaleStatus = null;
        switch (manageVo.getListType()) {
            case ProductListManageVo.ListType.ON_SALE:
                auditStatus = Product.AuditStatus.PASS;
                storeSaleStatus = Product.SaleStatus.ON_SALE;
                break;
            case ProductListManageVo.ListType.OFF_SHELVES:
                auditStatus = Product.AuditStatus.PASS;
                storeSaleStatus = Product.SaleStatus.OFF_SHELVES;
                break;
            case ProductListManageVo.ListType.PENDING:
                auditStatus = Product.AuditStatus.PENDING;
                break;
            case ProductListManageVo.ListType.NOT_PASS:
                auditStatus = Product.AuditStatus.NOT_PASS;
                break;
            default:
                break;
        }
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productSaleStatus", Product.SaleStatus.ON_SALE);
        condMap.put("auditStatus", auditStatus);
        condMap.put("storeSaleStatus", storeSaleStatus);
        condMap.put("storeId", manageVo.getStoreId());
        List<ProductListManageResVo> list = this.productMapper.listManage(condMap);
        PageInfo<ProductListManageResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage appointmentV111(int productId, boolean isAppointment) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", productId);
        if (isAppointment) {
            condMap.put("appointmentNumber", 1);
        } else {
            condMap.put("appointmentNumber", -1);
        }
        this.productMapper.appointment(condMap);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateOrderPayV111(ProductUpdateOrderPayVo orderPayVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(orderPayVo.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        product.setSaleVolume(product.getSaleVolume() + 1);
        product.setAppointment(product.getAppointment() + 1);
        this.productMapper.updateByPrimaryKeySelective(product);
        // 门店
        return responseMessage;
    }

    @Override
    public ResponseMessage<Product> isOnSaleV111(ProductIsOnSaleVo saleStatusVo) {
        ResponseMessage<Product> responseMessage = new ResponseMessage<>();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(saleStatusVo.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        if (Product.SaleStatus.OFF_SHELVES == product.getSaleStatus()) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_OFF_SHELVES, ProductConstant.Query.PRODUCT_OFF_SHELVES_MSG);
        }
        // 项目-门店-关联
        switch (product.getProductType()) {
            case Product.ProductType.STORE_SELF:
            case Product.ProductType.BRAND:
                Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(saleStatusVo), Map.class);
                ProductStoreRef productStoreRef = this.productStoreRefMapper.getByRefId(condMap);
                if (null == productStoreRef) {
                    throw new ResponseException(ProductConstant.Query.PRODUCT_STORE_NULL, ProductConstant.Query.PRODUCT_STORE_NULL_MSG);
                }
                if (Product.SaleStatus.OFF_SHELVES == product.getSaleStatus()) {
                    throw new ResponseException(ProductConstant.Query.PRODUCT_OFF_SHELVES, ProductConstant.Query.PRODUCT_OFF_SHELVES_MSG);
                }
                break;
            case Product.ProductType.PLATFORM_SELF:
                break;
            default:
                break;
        }
        responseMessage.setData(product);
        return responseMessage;
    }

    @Override
    public ResponseMessage isOrderByRecruitV111(int productBeauticianRefId, boolean isOrder) {
        ResponseMessage responseMessage = new ResponseMessage();
        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
        productBeauticianRef.setId(productBeauticianRefId);
        productBeauticianRef.setIsOrder(isOrder);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteByRecruitV111(int productBeauticianRefId) {
        ResponseMessage responseMessage = new ResponseMessage();
        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
        productBeauticianRef.setId(productBeauticianRefId);
        productBeauticianRef.setIsEnabled(false);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage applyByRecruitV111(ProductByApplyForRecruitVo applyForRecruitVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-门店-关联
        ProductStoreRef productStoreRef = this.productStoreRefMapper.selectByPrimaryKey(applyForRecruitVo.getProductStoreRefId());
        if (null == productStoreRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_STORE_NULL, ProductConstant.Query.PRODUCT_STORE_NULL_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(applyForRecruitVo.getBeauticianId());
        ResponseUtil.isFailThrowException(beauticianRes);
        StoreBeautician beautician = beauticianRes.getData();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productStoreRef.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productStoreRef.getProductId());
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        // 项目-美容师-关联
        ProductBeauticianRefByRefIdVo refIdVo = new ProductBeauticianRefByRefIdVo();
        refIdVo.setSponsor(ProductBeauticianRef.Sponsor.BEAUTICIAN);
        refIdVo.setBeauticianId(applyForRecruitVo.getBeauticianId());
        refIdVo.setProductId(productStoreRef.getProductId());
        refIdVo.setStoreId(productStoreRef.getStoreId());
        refIdVo.setServerType(Product.ServerType.STORE);
        List<Integer> auditStatusList = new ArrayList<>(10);
        auditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
        auditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
        refIdVo.setAuditStatusList(auditStatusList);
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByRefId(refIdVo);
        if (null != productBeauticianRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_APPLYED, ProductConstant.Query.PRODUCT_APPLYED_MSG);
        } else {
            productBeauticianRef = new ProductBeauticianRef();
            productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.BEAUTICIAN);
            productBeauticianRef.setProductId(productStoreRef.getProductId());
            productBeauticianRef.setStoreId(productStoreRef.getStoreId());
            productBeauticianRef.setStoreName(productStoreRef.getStoreName());
            productBeauticianRef.setBeauticianId(applyForRecruitVo.getBeauticianId());
            productBeauticianRef.setServerType(Product.ServerType.STORE);
            productBeauticianRef.setIsRecruit(true);
            productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PENDING);
            productBeauticianRef.setIsSelect(false);
            productBeauticianRef.setIsOrder(true);
            this.productBeauticianRefMapper.insertSelective(productBeauticianRef);
            // 发送消息
            this.applySendMsg(ProjectPushCodeEnum.BEAUTICIAN_APPLY_PROJECT_TO_STORE, SendMsgParamVo.BEAUTICIAN_APPLY_PROJECT_TO_STORE, beautician, productStoreRef, product, productCategoryRef);
        }
        return responseMessage;
    }

    /**
     * 申请发送消息
     *
     * @param pushCodeEnum       推送代码
     * @param type               消息类型
     * @param beautician         美容师
     * @param productStoreRef    项目-门店-关联
     * @param product            项目
     * @param productCategoryRef 项目-分类-关联
     */
    @Async
    public void applySendMsg(ProjectPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, ProductStoreRef productStoreRef, Product product, ProductCategoryRef productCategoryRef) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        // 店长
        ResponseMessage<StoreBeautician> managerBeauticianRes = this.storeBeauticianFeign.getManagerByStoreIdV111(productStoreRef.getStoreId());
        ResponseUtil.isFailThrowException(managerBeauticianRes);
        StoreBeautician managerBeautician = managerBeauticianRes.getData();
        sendMsgParam.setMemberId(managerBeautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("listType", BeauticianByInvitationForRecruitVo.ListType.PRODUCT_APPLY);
        paramMap.put("productId", productStoreRef.getProductId());
        paramMap.put("storeId", productStoreRef.getStoreId());
        paramMap.put("productStoreRefId", productStoreRef.getId());
        paramMap.put("beauticianId", managerBeautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("productName", product.getServerName());
        customMap.put("categoryName", productCategoryRef.getCategoryName());
        customMap.put("storeName", productStoreRef.getStoreName());
        customMap.put("productPrice", product.getSalePrice());
        customMap.put("commission", StoreBeautician.BeauticianType.FULL_TIME == beautician.getBeauticianType() ? product.getFulltimeCommission() : product.getParttimeCommission());
        customMap.put("productType", Product.productTypeMap.get(product.getProductType()));
        customMap.put("serverType", Product.serverTypeMap.get(Product.ServerType.STORE));
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    /**
     * 同意项目邀请发送消息
     *
     * @param pushCodeEnum         推送代码
     * @param type                 消息类型
     * @param beautician           美容师
     * @param productBeauticianRef 项目-美容师-关联
     * @param product              项目
     * @param productCategoryRef   项目-分类-关联
     */
    @Async
    public void acceptSendMsg(ProjectPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, ProductBeauticianRef productBeauticianRef, Product product, ProductCategoryRef productCategoryRef) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        // 店长
        ResponseMessage<StoreBeautician> managerBeauticianRes = this.storeBeauticianFeign.getManagerByStoreIdV111(productBeauticianRef.getStoreId());
        ResponseUtil.isFailThrowException(managerBeauticianRes);
        StoreBeautician managerBeautician = managerBeauticianRes.getData();
        sendMsgParam.setMemberId(managerBeautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("productBeauticianRefId", productBeauticianRef.getId());
        paramMap.put("productId", productBeauticianRef.getProductId());
        paramMap.put("storeId", productBeauticianRef.getStoreId());
        paramMap.put("listType", BeauticianByInvitationForRecruitVo.ListType.PRODUCT_APPLY);
        paramMap.put("beauticianId", beautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("productName", product.getServerName());
        customMap.put("categoryName", productCategoryRef.getCategoryName());
        customMap.put("storeName", productBeauticianRef.getStoreName());
        customMap.put("productPrice", product.getSalePrice());
        customMap.put("commission", StoreBeautician.BeauticianType.FULL_TIME == beautician.getBeauticianType() ? product.getFulltimeCommission() : product.getParttimeCommission());
        customMap.put("productType", Product.productTypeMap.get(product.getProductType()));
        customMap.put("serverType", Product.serverTypeMap.get(Product.ServerType.STORE));
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage acceptByRecruitForInvitationV111(int productBeauticianRefId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(productBeauticianRefId);
        if (null == productBeauticianRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST, ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(productBeauticianRef.getBeauticianId());
        if (null == beauticianRes) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        StoreBeautician beautician = beauticianRes.getData();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productBeauticianRef.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productBeauticianRef.getProductId());
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        // 项目-美容师-关联 批量更新为拒绝状态
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.NOT_PASS);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", productBeauticianRef.getAuditStatus());
        condMap.put("productId", productBeauticianRef.getProductId());
        condMap.put("storeId", productBeauticianRef.getStoreId());
        condMap.put("beauticianId", productBeauticianRef.getBeauticianId());
        this.productBeauticianRefMapper.updateAuditStatus(condMap);
        // 项目-美容师-关联更新
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        // 发送消息
        this.acceptSendMsg(ProjectPushCodeEnum.BEAUTICIAN_AGREE_PROJECT_TO_STORE, SendMsgParamVo.BEAUTICIAN_AGREE_PROJECT_TO_STORE, beautician, productBeauticianRef, product, productCategoryRef);
        // 成长值
        GrowthRuleVo growthRuleVo = new GrowthRuleVo();
        growthRuleVo.setCode(StoreGrowthRuleEnum.SUCCESS_RECRUIT.getCode());
        growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.STORE);
        growthRuleVo.setSourceId(productBeauticianRef.getStoreId());
        this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage refuseByRecruitForInvitationV111(int productBeauticianRefId, String auditReason) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(productBeauticianRefId);
        if (null == productBeauticianRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST, ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(productBeauticianRef.getBeauticianId());
        if (null == beauticianRes) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        StoreBeautician beautician = beauticianRes.getData();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productBeauticianRef.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productBeauticianRef.getProductId());
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        // 项目-美容师-关联更新
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.NOT_PASS);
        productBeauticianRef.setAuditReason(auditReason);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        // 发送消息
        this.acceptSendMsg(ProjectPushCodeEnum.BEAUTICIAN_NOT_AGREE_PROJECT_TO_STORE, SendMsgParamVo.BEAUTICIAN_NOT_AGREE_PROJECT_TO_STORE, beautician, productBeauticianRef, product, productCategoryRef);
        return responseMessage;
    }

    /**
     * 招募项目邀请发送消息
     *
     * @param pushCodeEnum         推送代码
     * @param type                 消息类型
     * @param beautician           美容师
     * @param productBeauticianRef 项目-美容师-关联
     * @param product              项目
     * @param productCategoryRef   项目-分类-关联
     */
    @Async
    public void invinationSendMsg(ProjectPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, ProductBeauticianRef productBeauticianRef, Product product, ProductCategoryRef productCategoryRef) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("beauticianId", beautician.getId());
        paramMap.put("cityId", beautician.getServiceCityId());
        paramMap.put("listType", ProductByRecruitVo.ListType.PRODUCT_INVINATION);
        paramMap.put("productBeauticianRefId", productBeauticianRef.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("productName", product.getServerName());
        customMap.put("categoryName", productCategoryRef.getCategoryName());
        customMap.put("storeName", productBeauticianRef.getStoreName());
        customMap.put("productPrice", product.getSalePrice());
        customMap.put("commission", StoreBeautician.BeauticianType.FULL_TIME == beautician.getBeauticianType() ? product.getFulltimeCommission() : product.getParttimeCommission());
        customMap.put("productType", Product.productTypeMap.get(product.getProductType()));
        customMap.put("serverType", Product.serverTypeMap.get(Product.ServerType.STORE));
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage invinationByRecruitV111(int productStoreRefId, int beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-门店-关联
        ProductStoreRef productStoreRef = this.productStoreRefMapper.selectByPrimaryKey(productStoreRefId);
        if (null == productStoreRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_STORE_NULL, ProductConstant.Query.PRODUCT_STORE_NULL_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(beauticianId);
        ResponseUtil.isFailThrowException(beauticianRes);
        StoreBeautician beautician = beauticianRes.getData();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productStoreRef.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productStoreRef.getProductId());
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
        productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.STORE);
        productBeauticianRef.setProductId(productStoreRef.getProductId());
        productBeauticianRef.setStoreId(productStoreRef.getStoreId());
        productBeauticianRef.setStoreName(productStoreRef.getStoreName());
        productBeauticianRef.setBeauticianId(beauticianId);
        productBeauticianRef.setServerType(Product.ServerType.STORE);
        productBeauticianRef.setIsRecruit(true);
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PENDING);
        productBeauticianRef.setIsSelect(true);
        productBeauticianRef.setIsOrder(true);
        this.productBeauticianRefMapper.insertSelective(productBeauticianRef);
        // 发送消息
        this.invinationSendMsg(ProjectPushCodeEnum.STORE_INVITES_TO_BEAUTICIAN, SendMsgParamVo.STORE_INVITES_TO_BEAUTICIAN, beautician, productBeauticianRef, product, productCategoryRef);
        return responseMessage;
    }

    /**
     * 同意项目申请发送消息
     *
     * @param pushCodeEnum         推送代码
     * @param type                 消息类型
     * @param beautician           美容师
     * @param productBeauticianRef 项目-美容师-关联
     * @param product              项目
     * @param productCategoryRef   项目-分类-关联
     */
    @Async
    public void agreeApplySendMsg(ProjectPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, ProductBeauticianRef productBeauticianRef, Product product, ProductCategoryRef productCategoryRef) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("beauticianId", beautician.getId());
        paramMap.put("cityId", beautician.getServiceCityId());
        paramMap.put("listType", ProductByRecruitVo.ListType.APPLY_RESULT);
        paramMap.put("productBeauticianRefId", productBeauticianRef.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("productName", product.getServerName());
        customMap.put("categoryName", productCategoryRef.getCategoryName());
        customMap.put("storeName", productBeauticianRef.getStoreName());
        customMap.put("productPrice", product.getSalePrice());
        customMap.put("commission", StoreBeautician.BeauticianType.FULL_TIME == beautician.getBeauticianType() ? product.getFulltimeCommission() : product.getParttimeCommission());
        customMap.put("productType", Product.productTypeMap.get(product.getProductType()));
        customMap.put("serverType", Product.serverTypeMap.get(Product.ServerType.STORE));
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage agreeByApplyForRecruitV111(int productBeauticianRefId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(productBeauticianRefId);
        if (null == productBeauticianRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST, ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(productBeauticianRef.getBeauticianId());
        if (null == beauticianRes) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        StoreBeautician beautician = beauticianRes.getData();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productBeauticianRef.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productBeauticianRef.getProductId());
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        // 项目-美容师-关联 批量更新为拒绝状态
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.NOT_PASS);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", productBeauticianRef.getAuditStatus());
        condMap.put("productId", productBeauticianRef.getProductId());
        condMap.put("storeId", productBeauticianRef.getStoreId());
        condMap.put("beauticianId", productBeauticianRef.getBeauticianId());
        this.productBeauticianRefMapper.updateAuditStatus(condMap);
        // 项目-美容师-关联更新
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        // 发送消息
        this.agreeApplySendMsg(ProjectPushCodeEnum.STORE_AGREE_APPLY_TO_STORE, SendMsgParamVo.STORE_AGREE_APPLY_TO_STORE, beautician, productBeauticianRef, product, productCategoryRef);
        // 成长值
        GrowthRuleVo growthRuleVo = new GrowthRuleVo();
        growthRuleVo.setCode(BeauticianGrowthRuleEnum.SUCCESS_PRODUCT.getCode());
        growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.BEAUTICIAN);
        growthRuleVo.setSourceId(beautician.getId());
        this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage refuseByApplyForRecruitV111(int productBeauticianRefId, String auditReason) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(productBeauticianRefId);
        if (null == productBeauticianRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST, ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
        }
        // 美容师
        ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findById(productBeauticianRef.getBeauticianId());
        if (null == beauticianRes) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        StoreBeautician beautician = beauticianRes.getData();
        // 项目
        Product product = this.productMapper.selectByPrimaryKey(productBeauticianRef.getProductId());
        if (null == product) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_NULL, ProductConstant.Query.PRODUCT_NULL_MSG);
        }
        // 项目-分类-关联
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productBeauticianRef.getProductId());
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        // 项目-美容师-关联更新
        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.NOT_PASS);
        productBeauticianRef.setAuditReason(auditReason);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        // 发送消息
        this.agreeApplySendMsg(ProjectPushCodeEnum.STORE_NOT_AGREE_APPLY_TO_STORE, SendMsgParamVo.STORE_NOT_AGREE_APPLY_TO_STORE, beautician, productBeauticianRef, product, productCategoryRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductStoreByNameResultVo> findProductStoreByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo) {
        ResponseMessage<ProductStoreByNameResultVo> responseMessage = new ResponseMessage<>();
        ResponseMessage<PageInfo<ProductByNameResultVo>> productResponseMessage = this.findByPageForName(pageNo, pageSize, productStoreByNameVo);
        ResponseMessage<PageInfo<StoreByNameResultVo>> storeResponseMessage = this.storeFeign.findByPageForName(pageNo, pageSize, productStoreByNameVo);
        // 商品与店铺结果
        ProductStoreByNameResultVo productStoreByNameResultVo = new ProductStoreByNameResultVo();
        productStoreByNameResultVo.setProductResponseMessage(productResponseMessage);
        productStoreByNameResultVo.setStoreResponseMessage(storeResponseMessage);
        responseMessage.setData(productStoreByNameResultVo);
        return responseMessage;
    }

}