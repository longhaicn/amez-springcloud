package com.union.aimei.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.app.system.BaseDicGroupFeign;
import com.union.aimei.common.feign.app.system.BaseRegionFeign;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.model.store.*;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.util.BaiDuMapUtil;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.common.ConditionResVo;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.member.StoreByRegisterVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import com.union.aimei.store.mapper.*;
import com.union.aimei.store.service.StoreService;
import com.union.common.baidumap.util.BaiDuMapApi;
import com.union.common.baidumap.util.MapUtil;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 店铺
 *
 * @author liurenkai
 * @time 2018/1/13 15:55
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreMapper storeMapper;
    @Resource
    private StoreFollowerMapper storeFollowerMapper;
    @Resource
    private StoreExtendMapper storeExtendMapper;
    @Resource
    private StoreChainBrandMapper storeChainBrandMapper;
    @Resource
    private StoreExtendOperationLogMapper storeExtendOperationLogMapper;
    @Resource
    private StoreLevelMapper storeLevelMapper;
    @Resource
    private BaseRegionFeign baseRegionFeign;
    @Resource
    private BaseDicGroupFeign baseDicGroupFeign;
    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;
    @Resource
    private StoreBeauticianAffiliatedMapper storeBeauticianAffiliatedMapper;

    /**
     * 添加店铺
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(Store t) {
        return this.storeMapper.insertSelective(t);
    }

    /**
     * 删除店铺
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(Store t) {
        return this.storeMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstore
     */
    @Override
    public Store queryObjById(int id) {
        Store model = this.storeMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<PageInfo<Store>> findByPageForFront(Integer pageNo, Integer pageSize, Store store) {
        ResponseMessage<PageInfo<Store>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<Store> list = this.storeMapper.selectListByConditions(store);
        if (list.isEmpty()) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        PageInfo<Store> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage collection(StoreFollower storeFollower) {
        ResponseMessage responseMessage = new ResponseMessage();
        //查询店铺是否已经关闭或冻结
        Store store = this.queryObjById(storeFollower.getStoreId());
        if (null == store) {
            throw new ServerException(StoreConstant.Save.COLLECTION_NULL_STORE, StoreConstant.Save.COLLECTION_NULL_STORE_MSG);
        } else if (Store.StoreState.OPEN != store.getStoreState()) {
            throw new ServerException(StoreConstant.Save.COLLECTION_STORE, StoreConstant.Save.COLLECTION_STORE_MSG);
        }
        // 店铺粉丝
        StoreFollower storeFollowerCond = new StoreFollower();
        storeFollowerCond.setStoreId(storeFollower.getStoreId());
        storeFollowerCond.setMemberId(storeFollower.getMemberId());
        List<StoreFollower> storeFollowerList = this.storeFollowerMapper.selectListByConditions(storeFollowerCond);
        // 粉丝数
        int followerNumber = storeFollower.getIsEnabled() ? 1 : -1;
        if (storeFollowerList.isEmpty()) {
            this.storeFollowerMapper.insertSelective(storeFollower);
        } else {
            StoreFollower oldStoreFollower = storeFollowerList.get(0);
            if (oldStoreFollower.getIsEnabled()) {
                if (storeFollower.getIsEnabled()) {
                    responseMessage.setCode(StoreConstant.Query.FOCUS);
                    responseMessage.setMessage(StoreConstant.Query.FOCUS_MSG);
                    return responseMessage;
                }
            } else {
                if (!storeFollower.getIsEnabled()) {
                    responseMessage.setCode(StoreConstant.Query.CANCELLED_FOCUS);
                    responseMessage.setMessage(StoreConstant.Query.CANCELLED_FOCUS_MSG);
                    return responseMessage;
                }
            }
            oldStoreFollower.setIsEnabled(storeFollower.getIsEnabled());
            this.storeFollowerMapper.updateByPrimaryKeySelective(oldStoreFollower);
        }
        // 累积粉丝数
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeId", storeFollower.getStoreId());
        condMap.put("followerNumber", followerNumber);
        this.storeMapper.accumulateByFollower(condMap);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Integer>> findListByCityId(Integer cityId) {
        ResponseMessage res = new ResponseMessage();
        List<Integer> storeIdList = this.storeMapper.findListByCityId(cityId);
        if (storeIdList.size() > 0) {
            res.setData(storeIdList);
        } else {
            res.setData(null);
        }
        return res;
    }

    @Override
    public ResponseMessage<JSONArray> findListByBaiduMapLocation(String query, String region) {
        ResponseMessage<JSONArray> responseMessage = new ResponseMessage<>();
        responseMessage.setData(MapUtil.searchLocation(query, region));
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreByNameResultVo>> findByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo) {
        ResponseMessage<PageInfo<StoreByNameResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productStoreByNameVo), Map.class);
        condMap.putAll(ConditionUtil.openStore());
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("storeServerType", Product.ServerType.STORE);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        List<StoreByNameResultVo> list = this.storeMapper.selectListByName(condMap);
        PageInfo<StoreByNameResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreByDetailResultVo> detail(StoreByDetailVo storeByDetailVo) {
        ResponseMessage<StoreByDetailResultVo> responseMessage = new ResponseMessage<>();
        // 店铺
        StoreByIdVo storeByIdVo = new StoreByIdVo();
        storeByIdVo.setId(storeByDetailVo.getStoreId());
        storeByIdVo.setPoint(storeByDetailVo.getPoint());
        Store store = this.storeMapper.queryDistanceById(storeByIdVo);
        if (store == null) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        // 门店扩展
        StoreExtend storeExtend = this.storeExtendMapper.selectByStoreId(storeByDetailVo.getStoreId());
        if (storeExtend == null) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        // 收藏店铺
        StoreFollower storeFollowerCond = new StoreFollower();
        storeFollowerCond.setStoreId(storeByDetailVo.getStoreId());
        storeFollowerCond.setMemberId(storeByDetailVo.getMemberId());
        storeFollowerCond.setIsEnabled(true);
        List<StoreFollower> storeFollowerList = this.storeFollowerMapper.selectListByConditions(storeFollowerCond);
        // 店铺结果
        StoreByDetailResultVo storeByDetailResultVo = new StoreByDetailResultVo();
        storeByDetailResultVo.setStore(store);
        storeByDetailResultVo.setStoreExtend(storeExtend);
        storeByDetailResultVo.setIsCollection(storeFollowerList.isEmpty() ? false : true);
        responseMessage.setData(storeByDetailResultVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(StoreByModifyVo modifyVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        Store store = modifyVo.getStore();
        BaseRegionIdByNameVo nameVo = new BaseRegionIdByNameVo();
        nameVo.setProvinceName(store.getProvinceName());
        nameVo.setCityName(store.getCityName());
        nameVo.setAreaName(store.getAreaName());
        ResponseMessage<BaseRegionIdByNameResVo> baseRegionRes = this.baseRegionFeign.getNameByIdV111(nameVo);
        ResponseUtil.isFailThrowException(baseRegionRes);
        BaseRegionIdByNameResVo nameResVo = baseRegionRes.getData();
        store.setProductId(nameResVo.getProvinceId());
        store.setCityId(nameResVo.getCityId());
        store.setAreaId(nameResVo.getAreaId());
        StoreExtend storeExtend = modifyVo.getStoreExtend();
        // 原来的门店，门店扩展
        StoreByModifyVo oldModifyVo = new StoreByModifyVo();
        Store oldStore = this.storeMapper.selectByPrimaryKey(store.getId());
        StoreExtend oldStoreExtend = this.storeExtendMapper.selectByStoreId(store.getId());
        oldModifyVo.setStore(oldStore);
        oldModifyVo.setStoreExtend(oldStoreExtend);
        // 更新门店，门店扩展
        storeExtend.setId(oldStoreExtend.getId());
        this.storeMapper.updateByPrimaryKeySelective(store);
        this.storeExtendMapper.updateByPrimaryKeySelective(storeExtend);
        // 门店扩展操作日志
        StoreExtendOperationLog storeExtendOperationLog = new StoreExtendOperationLog();
        storeExtendOperationLog.setStoreId(store.getId());
        storeExtendOperationLog.setContent("修改\"" + store.getStoreName() + "\"");
        storeExtendOperationLog.setOldValue(oldModifyVo.toString());
        storeExtendOperationLog.setNewValue(modifyVo.toString());
        this.storeExtendOperationLogMapper.insertSelective(storeExtendOperationLog);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Store>> findListByProductIdForOrder(StoreByProductIdForOrderVo storeByProductIdForOrderVo, HttpServletRequest request) {
        ResponseMessage<List<Store>> responseMessage = new ResponseMessage<>();
        BaiDuMapApi.Point point = storeByProductIdForOrderVo.getPoint();
        if (null == point || StringUtils.isBlank(point.getX()) || StringUtils.isBlank(point.getY())) {
            storeByProductIdForOrderVo.setPoint(BaiDuMapUtil.getPoint(request));
        }
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(storeByProductIdForOrderVo), Map.class);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("distance", 20000);
        List<Store> list = this.storeMapper.selectListByProductIdForOrder(condMap);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Store>> findListByIdBatch(IdBatchVo idBatchVo) {
        ResponseMessage<List<Store>> responseMessage = new ResponseMessage<>();
        List<Store> storeList = this.storeMapper.selectListByIdBatch(idBatchVo);
        responseMessage.setData(storeList);
        return responseMessage;
    }

    @Override
    public Store queryDistanceById(StoreByIdVo storeByIdVo) {
        return this.storeMapper.queryDistanceById(storeByIdVo);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage accumulateByPreIncomeAmount(StoreByPreIncomeAmountVo storeByPreIncomeAmountVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeMapper.accumulateByPreIncomeAmount(storeByPreIncomeAmountVo);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage accumulateByAccountBalance(StoreByAccountBalanceVo storeByAccountBalanceVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeMapper.accumulateByAccountBalance(storeByAccountBalanceVo);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage accumulateByStoreSales(StoreByStoreSalesVo storeByStoreSalesVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeMapper.accumulateByStoreSales(storeByStoreSalesVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Store>> findByPageForSelect(Integer pageNo, Integer pageSize, StoreBySelectVo selectVo, HttpServletRequest request) {
        ResponseMessage<PageInfo<Store>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        if (null == selectVo.getPoint()) {
            selectVo.setPoint(BaiDuMapUtil.getPoint(request));
        }
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(selectVo), Map.class);
        condMap.put("storeState", Store.StoreState.OPEN);
        List<Store> list = this.storeMapper.selectListBySelect(condMap);
        PageInfo<Store> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Store> findById(int id) {
        ResponseMessage<Store> responseMessage = new ResponseMessage<>();
        Store store = this.storeMapper.selectByPrimaryKey(id);
        if (null == store) {
            responseMessage.setCode(StoreConstant.Query.STORE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(store);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Store> findBySettledCodeV111(String settledCode) {
        ResponseMessage<Store> responseMessage = new ResponseMessage<>();
        Store store = this.storeMapper.selectBySettledCode(settledCode);
        if (null == store) {
            responseMessage.setCode(StoreConstant.Query.STORE_SETTLED_CODE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_SETTLED_CODE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(store);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> listAffiliatedByCanApplyV111(Integer pageNo, Integer pageSize, StoreAffiliatedByCanApplyVo affiliatedVo) {
        ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(affiliatedVo), Map.class);
        condMap.putAll(ConditionUtil.openStore());
        List<StoreAffiliatedByCanApplyResVo> list = this.storeMapper.listAffiliatedByCanApply(condMap);
        PageInfo<StoreAffiliatedByCanApplyResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 生成入驻码
     *
     * @return
     */
    public String getSettledCode() {
        String settledCode = "";
        boolean flag = true;
        while (flag) {
            settledCode = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
            Store store = new Store();
            store.setSettledCode(settledCode);
            List<Store> storeList = this.storeMapper.selectListByConditions(store);
            if (CollectionUtils.isEmpty(storeList)) {
                flag = false;
            }
        }
        return settledCode;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<StoreByRegisterResVo> registerV111(StoreByRegisterVo registerVo) {
        ResponseMessage<StoreByRegisterResVo> responseMessage = new ResponseMessage<>();
        StoreByRegisterResVo resVo = new StoreByRegisterResVo();
        // 根据店长手机号查询门店
        Store store = this.storeMapper.getBySellerPhone(registerVo.getSellerPhone());
        if (null != store) {
            StoreExtend storeExtend = this.storeExtendMapper.selectByStoreId(store.getId());
            resVo.setStore(store);
            resVo.setStoreExtend(storeExtend);
        } else {
            // 门店
            store = new Store();
            store.setStoreName("门店" + RandomStringUtils.randomNumeric(6));
            store.setSellerUserId(registerVo.getSellerUserId());
            store.setSellerPhone(registerVo.getSellerPhone());
            store.setSellerName(registerVo.getSellerName());
            store.setSettledCode(this.getSettledCode());
            store.setSettledStatus(Store.SettledStatus.WAIT_IMPROVE);
            store.setQualificationStatus(Store.QualificationStatus.WAIT_COMMIT);
            this.storeMapper.insertSelective(store);
            // 门店扩展
            StoreExtend storeExtend = new StoreExtend();
            storeExtend.setStoreId(store.getId());
            this.storeExtendMapper.insertSelective(storeExtend);
            resVo.setStore(store);
            resVo.setStoreExtend(storeExtend);
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreByEnterpriseReceivingAccountResVo> findEnterpriseReceivingAccountByStoreIdV111(int storeId) {
        ResponseMessage<StoreByEnterpriseReceivingAccountResVo> responseMessage = new ResponseMessage<>();
        StoreExtend storeExtend = this.storeExtendMapper.selectByStoreId(storeId);
        if (null == storeExtend) {
            responseMessage.setCode(StoreConstant.Query.STORE_EXTEND_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_EXTEND_NULL_MSG);
            return responseMessage;
        }
        StoreByEnterpriseReceivingAccountResVo resVo = new StoreByEnterpriseReceivingAccountResVo();
        resVo.setEraArea(storeExtend.getEraArea());
        resVo.setEraBank(storeExtend.getEraBank());
        resVo.setEraBankBranch(storeExtend.getEraBankBranch());
        resVo.setEraBankCardNumber(storeExtend.getEraBankCardNumber());
        resVo.setEraCompanyName(storeExtend.getEraCompanyName());
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreByPersonageReceivingAccountResVo> findPersonageReceivingAccountByStoreIdV111(int storeId) {
        ResponseMessage<StoreByPersonageReceivingAccountResVo> responseMessage = new ResponseMessage<>();
        StoreExtend storeExtend = this.storeExtendMapper.selectByStoreId(storeId);
        if (null == storeExtend) {
            responseMessage.setCode(StoreConstant.Query.STORE_EXTEND_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_EXTEND_NULL_MSG);
            return responseMessage;
        }
        StoreByPersonageReceivingAccountResVo resVo = new StoreByPersonageReceivingAccountResVo();
        BeanUtils.copyProperties(storeExtend, resVo);
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Store>> listOrderV111(Integer pageNo, Integer pageSize, StoreListOrderVo orderVo) {
        ResponseMessage<PageInfo<Store>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        switch (orderVo.getSortType()) {
            case StoreListOrderVo.SortType.DISTANCE:
                break;
            case StoreListOrderVo.SortType.SALE_VOLUME:
                break;
            case StoreListOrderVo.SortType.SALE_PRICE:
                break;
            default:
                break;
        }
        if (null == orderVo.getSort()) {
            orderVo.setSort(true);
        }
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(orderVo), Map.class);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        condMap.putAll(ConditionUtil.openStore());
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        List<Store> list = this.storeMapper.listOrder(condMap);
        PageInfo<Store> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreIndexConditionResVo> getIndexConditionV111(int cityId) {
        ResponseMessage<StoreIndexConditionResVo> responseMessage = new ResponseMessage<>();
        StoreIndexConditionResVo resVo = new StoreIndexConditionResVo();
        // 区
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
            resVo.setAreaIdList(conditionList);
        }
        // 门店星级
        List<StoreLevel> storeLevelList = this.storeLevelMapper.listAll();
        if (CollectionUtils.isNotEmpty(storeLevelList)) {
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            storeLevelList.forEach(storeLevel -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(storeLevel.getLevelName());
                condition.setValue(storeLevel.getId().toString());
                conditionList.add(condition);
            });
            resVo.setStoreLevelList(conditionList);
        }
        // 连锁品牌
        List<StoreChainBrand> storeChainBrandList = this.storeChainBrandMapper.listAll();
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
        // 经营年限
        ResponseMessage<BaseDicGroupDeatilResVo> manageYearRes = this.baseDicGroupFeign.detailByCodeV111("STORE_INDEX_CONDITION_MANAGE_YEAR");
        if (ResponseUtil.isSuccess(manageYearRes)) {
            BaseDicGroupDeatilResVo deatilResVo = manageYearRes.getData();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setManageYearList(conditionList);
        }
        // 特色项目
        ResponseMessage<BaseDicGroupDeatilResVo> specialProjectRes = this.baseDicGroupFeign.detailByCodeV111("STORE_SPECIAL_PROJECT");
        if (ResponseUtil.isSuccess(specialProjectRes)) {
            BaseDicGroupDeatilResVo deatilResVo = specialProjectRes.getData();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setSpecialProjectList(conditionList);
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Store>> listIndexV111(Integer pageNo, Integer pageSize, StoreListIndexVo indexVo) {
        ResponseMessage<PageInfo<Store>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(indexVo), Map.class);
        condMap.putAll(ConditionUtil.openStore());
        if (StringUtils.isNotEmpty(indexVo.getManageYear())) {
            String[] manageYearArr = indexVo.getManageYear().split("-");
            condMap.put("minManageYear", StringUtils.isNotEmpty(manageYearArr[0]) ? manageYearArr[0] : 0);
            if (manageYearArr.length > 0) {
                condMap.put("maxManageYear", StringUtils.isNotEmpty(manageYearArr[1]) ? manageYearArr[1] : 0);
            }
        }
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("storeServerType", Product.ServerType.STORE);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.putAll(ConditionUtil.onSaleStoreProduct());
        List<Store> list = this.storeMapper.listIndex(condMap);
        PageInfo<Store> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage accumulateGrowthValueV111(int storeId, int growthValue) {
        ResponseMessage responseMessage = new ResponseMessage();
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        store.setGrowupValue(store.getGrowupValue() + growthValue);
        this.storeMapper.updateByPrimaryKeySelective(store);
        responseMessage.setData(store.getGrowupValue());
        return responseMessage;
    }

    /**
     * 入驻发送消息
     *
     * @param pushCodeEnum 消息代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void settledSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
        // 店长
        Map<String, Object> managerMap = new HashMap<>(16);
        managerMap.put("beauticianType", StoreBeautician.BeauticianType.MANAGER);
        managerMap.put("storeId", affiliated.getStoreId());
        StoreBeautician managerBeautician = this.storeBeauticianMapper.getManagerByStoreId(managerMap);
        if (null == managerBeautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL, StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL_MSG);
        }
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(managerBeautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        BeauticianListManageVo manageVo = new BeauticianListManageVo();
        manageVo.setStoreId(beautician.getStoreId());
        manageVo.setEmployeeType(BeauticianListManageVo.EmployeeType.STORE);
        Map<String, Object> paramMap = JSONObject.parseObject(JSON.toJSONString(manageVo), Map.class);
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", beautician.getBeauticianName());
        customMap.put("id", beautician.getId());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage<Store> settledV111(StoreBySettledVo settledVo) {
        ResponseMessage<Store> responseMessage = new ResponseMessage<>();
        // 门店
        Store store = this.storeMapper.selectBySettledCode(settledVo.getSettledCode());
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(settledVo.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        // 门店-美容师-挂靠
        StoreBeauticianAffiliated affiliated = new StoreBeauticianAffiliated();
        affiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.APPLY);
        affiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.BEAUTICIAN);
        affiliated.setBeauticianType(StoreBeautician.BeauticianType.FULL_TIME);
        affiliated.setStoreId(store.getId());
        affiliated.setStoreName(store.getStoreName());
        affiliated.setBeauticianId(beautician.getId());
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.insertSelective(affiliated);
        // 更新美容师信息
        beautician.setStoreId(store.getId());
        beautician.setStoreName(store.getStoreName());
        beautician.setBeauticianType(StoreBeautician.BeauticianType.FULL_TIME);
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.SETTLED);
        beautician.setAffiliatedId(affiliated.getId());
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        responseMessage.setData(store);
        // 发送消息
        this.settledSendMsg(SystemPushCodeEnum.BEAUTICIAN_ENTER_SUCCESS_TO_STORE, SendMsgParamVo.BEAUTICIAN_ENTER_SUCCESS_TO_STORE, beautician, affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Store> getBySellerPhoneV111(String sellerPhone) {
        ResponseMessage<Store> responseMessage = new ResponseMessage<>();
        Store store = this.storeMapper.getBySellerPhone(sellerPhone);
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        responseMessage.setData(store);
        return responseMessage;
    }

}