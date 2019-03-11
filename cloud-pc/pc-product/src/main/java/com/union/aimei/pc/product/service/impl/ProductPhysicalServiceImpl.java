package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.model.product.PhysicalCategoryRef;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryVo;
import com.union.aimei.common.vo.product.pc.PhyByDetailResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageVo;
import com.union.aimei.common.vo.product.pc.ProductPhysicalByAddVo;
import com.union.aimei.pc.product.mapper.PhysicalCategoryRefMapper;
import com.union.aimei.pc.product.mapper.ProductPhysicalBeauticianRefMapper;
import com.union.aimei.pc.product.mapper.ProductPhysicalMapper;
import com.union.aimei.pc.product.service.ProductPhysicalService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 15:52
 */
@Service("productPhysicalService")
public class ProductPhysicalServiceImpl implements ProductPhysicalService {
    @Resource
    private ProductPhysicalMapper productPhysicalMapper;
    @Resource
    private PhysicalCategoryRefMapper physicalCategoryRefMapper;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private ProductPhysicalBeauticianRefMapper productPhysicalBeauticianRefMapper;

    /**
     * 分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productPhysical 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysical productPhysical) {
        ResponseMessage<PageInfo<ProductPhysical>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductPhysical> list = this.productPhysicalMapper.selectListByConditions(productPhysical);
        PageInfo<ProductPhysical> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加产品
     *
     * @param productPhysical
     * @return
     */
    @Override
    public int addObj(ProductPhysical productPhysical) {
        return this.productPhysicalMapper.insertSelective(productPhysical);
    }

    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productPhysicalMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改产品
     *
     * @param productPhysical
     * @return
     */
    @Override
    public int modifyObj(ProductPhysical productPhysical) {
        return this.productPhysicalMapper.updateByPrimaryKeySelective(productPhysical);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysical
     */
    @Override
    public ProductPhysical queryObjById(int id) {
        ProductPhysical model = this.productPhysicalMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<ProductPhysical> add(ProductPhysicalByAddVo productPhysicalByAddVo) {
        ResponseMessage<ProductPhysical> responseMessage = new ResponseMessage<>();
        // 产品
        ProductPhysical productPhysical = productPhysicalByAddVo.getProductPhysical();
        this.productPhysicalMapper.insertSelective(productPhysical);
        // 产品-分类-关联
        PhysicalCategoryRef physicalCategoryRef = productPhysicalByAddVo.getPhysicalCategoryRef();
        physicalCategoryRef.setPhysicalId(productPhysical.getId());
        this.physicalCategoryRefMapper.insertSelective(physicalCategoryRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryCheck(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        for (PhysicalByInventoryVo physicalByInventoryVo : inventoryForBeauticianVo.getInventoryList()) {
            ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(physicalByInventoryVo.getProductPhysicalId());
            if (productPhysical.getInventoryTotal() < physicalByInventoryVo.getPhysicalNumber()) {
                responseMessage.setCode(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage inventroyStorage(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        for (PhysicalByInventoryVo physicalByInventoryVo : inventoryForBeauticianVo.getInventoryList()) {
            ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(physicalByInventoryVo.getProductPhysicalId());
            if (productPhysical.getInventoryTotal() < physicalByInventoryVo.getPhysicalNumber()) {
                responseMessage.setCode(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductPhysical> findById(int id) {
        ResponseMessage<ProductPhysical> responseMessage = new ResponseMessage<>();
        ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(id);
        if (productPhysical == null) {
            responseMessage.setCode(ProductConstant.Query.PHYSICAL_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PHYSICAL_NOT_EXIST_MSG);
            return responseMessage;
        }
        responseMessage.setData(productPhysical);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<PhyByManageResVo>> findByPageForManage(Integer pageNo, Integer pageSize, PhyByManageVo manageVo) {
        ResponseMessage<PageInfo<PhyByManageResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<PhyByManageResVo> list = this.productPhysicalMapper.selectListByManage(manageVo);
        PageInfo<PhyByManageResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PhyByDetailResVo> detail(int id) {
        ResponseMessage<PhyByDetailResVo> responseMessage = new ResponseMessage<>();
        PhyByDetailResVo resVo = new PhyByDetailResVo();
        // 产品
        ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(id);
        resVo.setProductPhysical(productPhysical);
        // 产品-分类-关联
        PhysicalCategoryRef refCond = new PhysicalCategoryRef();
        refCond.setIsEnabled(true);
        refCond.setPhysicalId(id);
        List<PhysicalCategoryRef> refList = this.physicalCategoryRefMapper.selectListByConditions(refCond);
        if (!refList.isEmpty()) {
            resVo.setPhysicalCategoryRef(refList.get(0));
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryOrderReservation(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺美容师
        ResponseMessage<StoreBeautician> storeBeauticianRes = this.storeBeauticianFeign.findById(inventoryForBeauticianVo.getBeauticianId());
        ResponseUtil.isFailThrowException(storeBeauticianRes);
        // 产品库存
        for (PhysicalByInventoryVo inventoryVo : inventoryForBeauticianVo.getInventoryList()) {
            ProductPhysical physical = this.productPhysicalMapper.selectByPrimaryKey(inventoryVo.getProductPhysicalId());
            if (null == physical) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_NOT_EXIST, ProductConstant.Query.PHYSICAL_NOT_EXIST_MSG);
            }
            if (physical.getInventoryConsumable() < inventoryVo.getPhysicalNumber()) {
                responseMessage.setCode(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
            physical.setInventoryOrderReservation(physical.getInventoryOrderReservation() + inventoryVo.getPhysicalNumber());
            physical.setInventoryConsumable(physical.getInventoryConsumable() - inventoryVo.getPhysicalNumber());
            this.productPhysicalMapper.updateByPrimaryKeySelective(physical);
            // 产品-美容师-关联
            Map<String, Object> ppbrMap = new HashMap<>(16);
            ppbrMap.put("productPhysicalId", inventoryVo.getProductPhysicalId());
            ppbrMap.put("beauticianId", inventoryForBeauticianVo.getBeauticianId());
            ProductPhysicalBeauticianRef productPhysicalBeauticianRef = this.productPhysicalBeauticianRefMapper.getByRefId(ppbrMap);
            if (null == productPhysicalBeauticianRef) {
                productPhysicalBeauticianRef = new ProductPhysicalBeauticianRef();
                productPhysicalBeauticianRef.setProductPhysicalId(physical.getId());
                // 店铺美容师
                StoreBeautician storeBeautician = storeBeauticianRes.getData();
                productPhysicalBeauticianRef.setStoreId(storeBeautician.getStoreId());
                productPhysicalBeauticianRef.setStoreName(storeBeautician.getStoreName());
                productPhysicalBeauticianRef.setBeauticianId(storeBeautician.getId());
                productPhysicalBeauticianRef.setBeauticianType(storeBeautician.getBeauticianType());
                productPhysicalBeauticianRef.setBeauticianNickName(storeBeautician.getBeauticianNickName());
                productPhysicalBeauticianRef.setBeauticianHeadImgUrl(storeBeautician.getHeadImgUrl());
                productPhysicalBeauticianRef.setInventoryPurchaseReservation(inventoryVo.getPhysicalNumber());
                this.productPhysicalBeauticianRefMapper.insertSelective(productPhysicalBeauticianRef);
            } else {
                productPhysicalBeauticianRef.setInventoryPurchaseReservation(productPhysicalBeauticianRef.getInventoryPurchaseReservation() + inventoryVo.getPhysicalNumber());
                this.productPhysicalBeauticianRefMapper.updateByPrimaryKeySelective(productPhysicalBeauticianRef);
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryCancelOrderReservation(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 产品库存
        for (PhysicalByInventoryVo inventoryVo : inventoryForBeauticianVo.getInventoryList()) {
            ProductPhysical physical = this.productPhysicalMapper.selectByPrimaryKey(inventoryVo.getProductPhysicalId());
            if (null == physical) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_NOT_EXIST, ProductConstant.Query.PHYSICAL_NOT_EXIST_MSG);
            }
            if (physical.getInventoryOrderReservation() < inventoryVo.getPhysicalNumber()) {
                responseMessage.setCode(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
            physical.setInventoryOrderReservation(physical.getInventoryOrderReservation() - inventoryVo.getPhysicalNumber());
            physical.setInventoryConsumable(physical.getInventoryConsumable() + inventoryVo.getPhysicalNumber());
            this.productPhysicalMapper.updateByPrimaryKeySelective(physical);
            // 产品-美容师-关联
            Map<String, Object> ppbrMap = new HashMap<>(16);
            ppbrMap.put("productPhysicalId", inventoryVo.getProductPhysicalId());
            ppbrMap.put("beauticianId", inventoryForBeauticianVo.getBeauticianId());
            ProductPhysicalBeauticianRef productPhysicalBeauticianRef = this.productPhysicalBeauticianRefMapper.getByRefId(ppbrMap);
            if (null == productPhysicalBeauticianRef) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
            }
            if (productPhysicalBeauticianRef.getInventoryPurchaseReservation() < inventoryVo.getPhysicalNumber()) {
                productPhysicalBeauticianRef.setInventoryPurchaseReservation(productPhysicalBeauticianRef.getInventoryPurchaseReservation() - inventoryVo.getPhysicalNumber());
                this.productPhysicalBeauticianRefMapper.updateByPrimaryKeySelective(productPhysicalBeauticianRef);
            } else {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH_MSG);
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryConsumption(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺美容师
        ResponseMessage<StoreBeautician> storeBeauticianRes = this.storeBeauticianFeign.findById(inventoryForBeauticianVo.getBeauticianId());
        ResponseUtil.isFailThrowException(storeBeauticianRes);
        // 产品库存
        for (PhysicalByInventoryVo inventoryVo : inventoryForBeauticianVo.getInventoryList()) {
            ProductPhysical physical = this.productPhysicalMapper.selectByPrimaryKey(inventoryVo.getProductPhysicalId());
            if (null == physical) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_NOT_EXIST, ProductConstant.Query.PHYSICAL_NOT_EXIST_MSG);
            }
            if (physical.getInventoryOrderReservation() < inventoryVo.getPhysicalNumber()) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_ORDER_RESERVATION_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_CANCEL_ORDER_RESERVATION_NOT_ENOUGH_MSG);
            }
            physical.setInventoryOrderReservation(physical.getInventoryOrderReservation() - inventoryVo.getPhysicalNumber());
            physical.setInventoryTotal(physical.getInventoryTotal() - inventoryVo.getPhysicalNumber());
            this.productPhysicalMapper.updateByPrimaryKeySelective(physical);
            // 产品-美容师-关联
            Map<String, Object> ppbrMap = new HashMap<>(16);
            ppbrMap.put("productPhysicalId", inventoryVo.getProductPhysicalId());
            ppbrMap.put("beauticianId", inventoryForBeauticianVo.getBeauticianId());
            ProductPhysicalBeauticianRef productPhysicalBeauticianRef = this.productPhysicalBeauticianRefMapper.getByRefId(ppbrMap);
            if (null == productPhysicalBeauticianRef) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
            }
            if (productPhysicalBeauticianRef.getInventoryPurchaseReservation() < inventoryVo.getPhysicalNumber()) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH_MSG);
            } else {
                productPhysicalBeauticianRef.setInventoryPurchaseReservation(productPhysicalBeauticianRef.getInventoryPurchaseReservation() - inventoryVo.getPhysicalNumber());
                productPhysicalBeauticianRef.setInventoryTotal(productPhysicalBeauticianRef.getInventoryTotal() + inventoryVo.getPhysicalNumber());
                this.productPhysicalBeauticianRefMapper.updateByPrimaryKeySelective(productPhysicalBeauticianRef);
            }
        }
        return responseMessage;
    }
}