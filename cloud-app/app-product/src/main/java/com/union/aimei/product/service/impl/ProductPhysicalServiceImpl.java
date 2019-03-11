package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.product.mapper.FreightTemplateCityMapper;
import com.union.aimei.product.mapper.FreightTemplateMapper;
import com.union.aimei.product.mapper.ProductPhysicalBeauticianRefMapper;
import com.union.aimei.product.mapper.ProductPhysicalMapper;
import com.union.aimei.product.service.ProductPhysicalService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    private FreightTemplateMapper freightTemplateMapper;
    @Resource
    private FreightTemplateCityMapper freightTemplateCityMapper;
    @Resource
    private ProductPhysicalBeauticianRefMapper productPhysicalBeauticianRefMapper;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    /**
     * 前端分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
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
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForCategory(Integer pageNo, Integer pageSize, ProductPhysicalByCategoryVo productPhysicalByCategoryVo) {
        ResponseMessage<PageInfo<ProductPhysical>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductPhysical> list = this.productPhysicalMapper.selectListByCategory(productPhysicalByCategoryVo);
        PageInfo<ProductPhysical> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductPhysical> detail(int id) {
        ResponseMessage<ProductPhysical> responseMessage = new ResponseMessage<>();
        ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(id);
        responseMessage.setData(productPhysical);
        return responseMessage;
    }

    @Override
    public ResponseMessage inventoryCheck(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage<>();
        for (PhysicalByInventoryVo inventoryVo : inventoryForBeauticianVo.getInventoryList()) {
            ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(inventoryVo.getProductPhysicalId());
            if (productPhysical.getInventoryConsumable() < inventoryVo.getPhysicalNumber()) {
                responseMessage.setCode(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH);
                responseMessage.setMessage(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
                return responseMessage;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductPhysical>> findListByIdBatch(ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo) {
        ResponseMessage<List<ProductPhysical>> responseMessage = new ResponseMessage<>();
        List<ProductPhysical> productPhysicalList = this.productPhysicalMapper.selectListByIdBatch(productPhysicalByIdBatchVo);
        responseMessage.setData(productPhysicalList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> calcFreight(ProductPhysicalByCalcFreightVo calcFreightVo) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        int totalFreigth = 0;
        for (PhysicalByInventoryVo inventoryVo : calcFreightVo.getInventoryList()) {
            ResponseMessage<Integer> physicalRes = calcFreightByPhysical(calcFreightVo.getCityId(), inventoryVo.getProductPhysicalId(), inventoryVo.getPhysicalNumber());
            if (physicalRes.getCode() == 200) {
                totalFreigth += physicalRes.getData();
            } else {
                return physicalRes;
            }
        }
        responseMessage.setData(totalFreigth);
        return responseMessage;
    }

    /**
     * 计算运费（产品）
     *
     * @param cityId            城市ID
     * @param productPhysicalId 产品ID
     * @param physicalNumber    产品数量
     * @return
     */
    private ResponseMessage<Integer> calcFreightByPhysical(int cityId, int productPhysicalId, int physicalNumber) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        int totalFreigth = 0;
        ProductPhysical productPhysical = this.productPhysicalMapper.selectByPrimaryKey(productPhysicalId);
        // 邮费类型，1-买家承担
        if (productPhysical.getPostageType() == ProductPhysical.PostageType.BUYER) {
            // 运费模板ID
            int templateId = productPhysical.getTemplateId();
            // 运费模板
            FreightTemplate freightTemplate = this.freightTemplateMapper.selectByPrimaryKey(templateId);
            if (freightTemplate == null || freightTemplate.getIsEnabled() == false) {
                responseMessage.setCode(ProductConstant.Query.FREIGHT_TEMPLATE_NOT_EXIST);
                responseMessage.setMessage(ProductConstant.Query.FREIGHT_TEMPLATE_NOT_EXIST_MSG);
                return responseMessage;
            }
            // 运费模板城市
            FreightTemplateCityByCityIdVo cityIdVo = new FreightTemplateCityByCityIdVo();
            cityIdVo.setTemplateId(templateId);
            cityIdVo.setCityId(cityId);
            FreightTemplateCity freightTemplateCity = this.freightTemplateCityMapper.selectByCityId(cityIdVo);
            if (freightTemplateCity == null) {
                freightTemplateCity = this.freightTemplateCityMapper.selectByDefault(templateId);
                if (freightTemplateCity == null) {
                    responseMessage.setCode(ProductConstant.Query.FREIGHT_TEMPLATE_CITY_NOT_EXIST);
                    responseMessage.setMessage(ProductConstant.Query.FREIGHT_TEMPLATE_CITY_NOT_EXIST_MSG);
                    return responseMessage;
                }
            }
            // 计价方式，1-按件数，2-按重量
            switch (freightTemplate.getPricingMethod()) {
                case FreightTemplate.PricingMethod.NUMBER:
                    // 续件数
                    int continuedNumber = physicalNumber - freightTemplateCity.getFirstNumber();
                    int continuedPrice = 0;
                    if (continuedNumber > 0) {
                        continuedPrice = (continuedNumber / freightTemplateCity.getContinuedNumber()) * freightTemplateCity.getContinuedPrice();
                    }
                    totalFreigth = continuedPrice + freightTemplateCity.getFirstPrice();
                    break;
                case FreightTemplate.PricingMethod.WEIGHT:
                    BigDecimal totalWeight = productPhysical.getWeight().multiply(new BigDecimal(physicalNumber));
                    // 续重数
                    BigDecimal continuedWeight = totalWeight.subtract(new BigDecimal(freightTemplateCity.getFirstNumber()));
                    continuedPrice = 0;
                    if (continuedWeight.compareTo(BigDecimal.ZERO) > 0) {
                        continuedPrice = (continuedWeight.subtract(new BigDecimal(freightTemplateCity.getContinuedNumber())).multiply(new BigDecimal(freightTemplateCity.getContinuedPrice()))).intValue();
                    }
                    totalFreigth = continuedPrice + freightTemplateCity.getFirstPrice();
                    break;
                default:
                    responseMessage.setCode(ProductConstant.Query.PRICING_METHOD_NOT_EXIST);
                    responseMessage.setMessage(ProductConstant.Query.PRICING_METHOD_NOT_EXIST_MSG);
                    break;
            }
        }
        responseMessage.setData(totalFreigth);
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
    public ResponseMessage inventoryPurchaseCheckV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<PhysicalByInventoryVo> inventoryList = inventoryForBeauticianVo.getInventoryList();
        for (PhysicalByInventoryVo inventory : inventoryList) {
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(inventory.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(inventory.getPhysicalNumber());
            boolean inventoryFlag = this.productPhysicalMapper.inventoryPurchaseCheck(inventoryVo);
            if (!inventoryFlag) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseMessage inventoryPurchaseReservationV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 库存归属
        int beauticianId = this.inventoryOwnershipV111(inventoryForBeauticianVo.getBeauticianId());
        // 产品
        List<PhysicalByInventoryVo> inventoryList = inventoryForBeauticianVo.getInventoryList();
        for (PhysicalByInventoryVo inventory : inventoryList) {
            // 库存检查
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(inventory.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(inventory.getPhysicalNumber());
            inventoryVo.setBeauticianId(beauticianId);
            boolean inventoryFlag = this.productPhysicalMapper.inventoryPurchaseCheck(inventoryVo);
            if (!inventoryFlag) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_NOT_ENOUGH_MSG);
            }
            // 产品库存采购预约
            int result = this.productPhysicalMapper.inventoryPurchaseReservation(inventoryVo);
            if (0 == result) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_NOT_ENOUGH_MSG);
            }
            // 产品库存美容师采购预约
            Map<String, Object> condMap = new HashMap<>(16);
            condMap.put("productPhysicalId", inventoryVo.getProductPhysicalId());
            condMap.put("beauticianId", beauticianId);
            ProductPhysicalBeauticianRef productPhysicalBeauticianRef = this.productPhysicalBeauticianRefMapper.getByRefId(condMap);
            if (null == productPhysicalBeauticianRef) {
                productPhysicalBeauticianRef = new ProductPhysicalBeauticianRef();
                productPhysicalBeauticianRef.setProductPhysicalId(inventory.getProductPhysicalId());
                productPhysicalBeauticianRef.setBeauticianId(beauticianId);
                productPhysicalBeauticianRef.setInventoryTotal(inventory.getPhysicalNumber());
                productPhysicalBeauticianRef.setInventoryConsumable(0);
                productPhysicalBeauticianRef.setInventoryOrderReservation(0);
                productPhysicalBeauticianRef.setInventoryPurchaseReservation(inventory.getPhysicalNumber());
                this.productPhysicalBeauticianRefMapper.insertSelective(productPhysicalBeauticianRef);
            } else {
                result = this.productPhysicalBeauticianRefMapper.inventoryPurchaseReservation(inventoryVo);
                if (0 == result) {
                    throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_ERROR, ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_ERROR_MSG);
                }
            }
        }
        return responseMessage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseMessage inventoryCancelPurchaseReservationV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 库存归属
        int beauticianId = this.inventoryOwnershipV111(inventoryForBeauticianVo.getBeauticianId());
        // 产品
        List<PhysicalByInventoryVo> inventoryList = inventoryForBeauticianVo.getInventoryList();
        for (PhysicalByInventoryVo inventory : inventoryList) {
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(inventory.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(inventory.getPhysicalNumber());
            inventoryVo.setBeauticianId(beauticianId);
            int result = this.productPhysicalBeauticianRefMapper.inventoryCancelPurchaseReservation(inventoryVo);
            if (0 == result) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_CANCEL_PURCHASE_RESERVATION_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_CANCEL_PURCHASE_RESERVATION_NOT_ENOUGH_MSG);
            }
        }
        return responseMessage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseMessage inventroyPurchaseStorageV111(PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 库存归属
        int beauticianId = this.inventoryOwnershipV111(inventoryForBeauticianVo.getBeauticianId());
        // 产品
        List<PhysicalByInventoryVo> inventoryList = inventoryForBeauticianVo.getInventoryList();
        for (PhysicalByInventoryVo inventory : inventoryList) {
            ProductPhysicalByInventoryVo inventoryVo = new ProductPhysicalByInventoryVo();
            inventoryVo.setProductPhysicalId(inventory.getProductPhysicalId());
            inventoryVo.setPhysicalNumber(inventory.getPhysicalNumber());
            inventoryVo.setBeauticianId(beauticianId);
            int result = this.productPhysicalBeauticianRefMapper.inventoryPurchaseStorage(inventoryVo);
            if (0 == result) {
                throw new ResponseException(ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_STORAGE_NOT_ENOUGH, ProductConstant.Query.PHYSICAL_INVENTORY_PURCHASE_RESERVATION_STORAGE_NOT_ENOUGH_MSG);
            }
        }
        return responseMessage;
    }
}