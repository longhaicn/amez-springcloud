package com.union.aimei.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.CommonConstant;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.app.im.EasemobImUsersFeign;
import com.union.aimei.common.feign.app.member.MemberFeign;
import com.union.aimei.common.feign.app.order.OrderBeauticianFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.product.ProductPhysicalBeauticianRefFeign;
import com.union.aimei.common.feign.app.product.ProductProductPhysicalRefFeign;
import com.union.aimei.common.feign.app.system.BaseDicGroupFeign;
import com.union.aimei.common.feign.app.system.BaseRegionFeign;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.model.store.*;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.common.ConditionResVo;
import com.union.aimei.common.vo.common.MapPointVo;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.order.BeauticianBusyTimeVo;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.aimei.common.vo.order.OrderTimeVo;
import com.union.aimei.common.vo.product.app.PhysicalBeauticianRefListInventoryByProductIdVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.aimei.store.mapper.*;
import com.union.aimei.store.service.StoreBeauticianLevelService;
import com.union.aimei.store.service.StoreBeauticianService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.client.model.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 门店美容师
 *
 * @author liurenkai
 * @time 2018/1/12 13:51
 */
@Service("storeBeauticianService")
public class StoreBeauticianServiceImpl implements StoreBeauticianService {

    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;
    @Resource
    private StoreMapper storeMapper;
    @Resource
    private StoreFriendMapper storeFriendMapper;
    @Resource
    private BeauticianBusyTimeMapper beauticianBusyTimeMapper;
    @Resource
    private ProductFeign productFeign;
    @Resource
    private BaseRegionFeign baseRegionFeign;
    @Resource
    private BaseDicGroupFeign baseDicGroupFeign;
    @Resource
    private BeauticianFollowerMapper beauticianFollowerMapper;
    @Resource
    private OrderBeauticianFeign orderBeauticianFeign;
    @Resource
    private EasemobImUsersFeign easemobImUsersFeign;
    @Resource
    private ProductProductPhysicalRefFeign productProductPhysicalRefFeign;
    @Resource
    private ProductPhysicalBeauticianRefFeign productPhysicalBeauticianRefFeign;
    @Resource
    private StoreBeauticianLevelService storeBeauticianLevelService;
    @Resource
    private MemberFeign memberFeign;

    /**
     * 前端分页查询门店美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeBeautician 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreBeautician> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeautician storeBeautician) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByConditions(storeBeautician);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加门店美容师
     *
     * @param storeBeautician
     * @return
     */
    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public int addObj(StoreBeautician storeBeautician) {
        int result = this.storeBeauticianMapper.insertSelective(storeBeautician);
        return result;
    }

    /**
     * 删除门店美容师
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBeauticianMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门店美容师
     *
     * @param storeBeautician
     * @return
     */
    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public int modifyObj(StoreBeautician storeBeautician) {
        return this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeautician
     */
    @Override
    public StoreBeautician queryObjById(int id) {
        StoreBeautician model = this.storeBeauticianMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<StoreBeauticianByPhoneResultVo> findByPhoneForStore(String phone) {
        ResponseMessage<StoreBeauticianByPhoneResultVo> responseMessage = new ResponseMessage<>();
        StoreBeautician storeBeautician = this.storeBeauticianMapper.selectByPhone(phone);
        if (storeBeautician == null) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        Store store = new Store();
        if (storeBeautician.getStoreId() != null) {
            store = this.storeMapper.selectByPrimaryKey(storeBeautician.getStoreId());
            if (store == null) {
                store.setSellerPhone(phone);
                List<Store> storeList = this.storeMapper.selectListByConditions(store);
                if (!CollectionUtils.isEmpty(storeList)) {
                    store = storeList.get(0);
                }
            }
        }
        StoreBeauticianByPhoneResultVo storeBeauticianByPhoneResultVo = new StoreBeauticianByPhoneResultVo();
        storeBeauticianByPhoneResultVo.setStoreBeautician(storeBeautician);
        storeBeauticianByPhoneResultVo.setStore(store);
        responseMessage.setData(storeBeauticianByPhoneResultVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByPhone(String phone) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician storeBeautician = this.storeBeauticianMapper.selectByPhone(phone);
        if (storeBeautician == null) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(storeBeautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage setServiceByStoreId(StoreBeauticianByStoreIdForSetServiceVo storeBeauticianByStoreIdForSetServiceVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 根据店铺ID清空客服
        this.storeBeauticianMapper.updateByStoreIdForEmptyService(storeBeauticianByStoreIdForSetServiceVo.getStoreId());
        // 设置客服
        storeBeauticianByStoreIdForSetServiceVo.getIdLsit().forEach(id -> {
            StoreBeautician storeBeautician = new StoreBeautician();
            storeBeautician.setId(id);
            storeBeautician.setIsService(true);
            this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
        });
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> chooseServiceByStoreId(int storeId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        // 门店美容师
        StoreBeautician storeBeauticianConditions = new StoreBeautician();
        storeBeauticianConditions.setStoreId(storeId);
        storeBeauticianConditions.setIsService(true);
        storeBeauticianConditions.setIsEnabled(true);
        List<StoreBeautician> storeBeauticianList = this.storeBeauticianMapper.selectListByConditions(storeBeauticianConditions);
        if (storeBeauticianList.isEmpty()) {
            responseMessage.setCode(StoreConstant.Query.STORE_SERVICE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_SERVICE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(storeBeauticianList.get(0));
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> queryByMemberId(StoreBeautician storeBeautician) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByConditions(storeBeautician);
        if (CollectionUtils.isEmpty(list)) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(list.get(0));
        return responseMessage;
    }

    @Override
    public ResponseMessage judgeBeauticianBelongStore(Integer beauticianId, Integer anStoreId) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        Map<String, Object> map = new HashMap<>(2);
        map.put("beauticianId", beauticianId);
        map.put("anStoreId", anStoreId);
        StoreBeautician storeBeautician = storeBeauticianMapper.selectByBeauticianIdAndAnStoreId(map);
        if (storeBeautician == null) {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage accumulateByPreIncomeAmount(StoreBeaByPreIncomeAmountVo preIncomeAmountVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeBeauticianMapper.accumulateByPreIncomeAmount(preIncomeAmountVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage accumulateByAccountBalance(StoreBeaByAccountBalanceVo accountBalanceVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeBeauticianMapper.accumulateByAccountBalance(accountBalanceVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findById(int id) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician storeBeautician = this.storeBeauticianMapper.selectByPrimaryKey(id);
        if (storeBeautician == null) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(storeBeautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreBeautician>> findListByIdBatch(StoreBeauticianByIdBatchVo idBatchVo) {
        ResponseMessage<List<StoreBeautician>> responseMessage = new ResponseMessage<>();
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByIdBatch(idBatchVo);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreBeautician>> findListByImUsernameBatch(StoreBeauticianByImUsernameBatchVo imUsernameBatchVo) {
        ResponseMessage<List<StoreBeautician>> responseMessage = new ResponseMessage<>();
        List<StoreBeautician> storeBeauticianList = this.storeBeauticianMapper.selectListByImUsernameBatch(imUsernameBatchVo);
        responseMessage.setData(storeBeauticianList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> queryMemberIdByPhone(String phone) {
        ResponseMessage<Integer> res = new ResponseMessage<>();
        Integer memberId = storeBeauticianMapper.queryMemberIdByPhone(phone);
        if (memberId != null) {
            res.setData(memberId);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(Integer pageNo, Integer pageSize, int storeId) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", StoreBeautician.AuditStatus.PASS);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("storeId", storeId);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByAllowedRecruit(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(Integer pageNo, Integer pageSize, int storeId) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = ConditionUtil.fullpartTimeBeautician();
        condMap.put("storeId", storeId);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByBeautician(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForStar(Integer pageNo, Integer pageSize, BeauticianByStarVo starVo) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(starVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.fullpartTimeBeautician();
        condMap.putAll(voMap);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByStar(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<StoreBeautician> add(StoreBeautician beautician) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeautician phoneBeautician = this.storeBeauticianMapper.selectByPhone(beautician.getPhone());
        if (null != phoneBeautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_PHONE_EXIST, StoreConstant.Query.BEAUTICIAN_PHONE_EXIST_MSG);
        }
        this.storeBeauticianMapper.insertSelective(beautician);
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(StoreBeautician storeBeautician) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForAffiliatedV111(Integer pageNo, Integer pageSize, BeauticianByCanInvitationForAffiliatedVo affiliatedVo) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(affiliatedVo), Map.class);
        condMap.put("affiliatedStatus", StoreBeautician.AffiliatedStatus.PENGING);
        condMap.put("affiliatedType", StoreBeauticianAffiliated.AffiliatedType.APPLY);
        condMap.put("sponsor", StoreBeauticianAffiliated.Sponsor.STORE);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        List<Integer> sbaAuditStatusList = new ArrayList<>(10);
        sbaAuditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PENDING);
        sbaAuditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PASS);
        condMap.put("sbaAuditStatusList", sbaAuditStatusList);
        condMap.putAll(ConditionUtil.passBeautician());
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByCanInvitationForAffiliated(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByCanInvitationForRecruitVo recruitVo) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(recruitVo), Map.class);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("realNameStatus", StoreBeautician.RealNameStatus.PASS);
        condMap.put("storeSponsor", ProductBeauticianRef.Sponsor.STORE);
        List<Integer> storePbrAuditStatusList = new ArrayList<>(10);
        storePbrAuditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
        storePbrAuditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
        condMap.put("storePbrAuditStatusList", storePbrAuditStatusList);
        condMap.put("beauticianSponsor", ProductBeauticianRef.Sponsor.BEAUTICIAN);
        List<Integer> beauticianPbrAuditStatusList = new ArrayList<>(10);
        beauticianPbrAuditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
        condMap.put("beauticianPbrAuditStatusList", beauticianPbrAuditStatusList);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByCanInvitationForRecruit(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianByInvitationForRecruitResVo>> findByPageByInvitationForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByInvitationForRecruitVo recruitVo) {
        ResponseMessage<PageInfo<BeauticianByInvitationForRecruitResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<Integer> sponsorList = new ArrayList<>(10);
        List<Integer> auditStatusList = new ArrayList<>(10);
        switch (recruitVo.getListType()) {
            case BeauticianByInvitationForRecruitVo.ListType.WAIT_CONFIRM:
                sponsorList.add(ProductBeauticianRef.Sponsor.STORE);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PENDING);
                break;
            case BeauticianByInvitationForRecruitVo.ListType.AFFILATED_RESULT:
                sponsorList.add(ProductBeauticianRef.Sponsor.STORE);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.PASS);
                auditStatusList.add(ProductBeauticianRef.AuditStatus.NOT_PASS);
                break;
            case BeauticianByInvitationForRecruitVo.ListType.PRODUCT_APPLY:
                sponsorList.add(ProductBeauticianRef.Sponsor.BEAUTICIAN);
                break;
            default:
                break;
        }
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(recruitVo), Map.class);
        condMap.put("sponsorList", sponsorList);
        condMap.put("auditStatusList", auditStatusList);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        List<BeauticianByInvitationForRecruitResVo> list = this.storeBeauticianMapper.selectListByInvitationForRecruit(condMap);
        PageInfo<BeauticianByInvitationForRecruitResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByRecruitVo recruitVo) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(recruitVo), Map.class);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByRecruit(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BeauticianByNearbyResVo>> listNearbyV111(int limit, MapPointVo pointVo) {
        ResponseMessage<List<BeauticianByNearbyResVo>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(pointVo), Map.class);
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("fulltimeBeauticianType", StoreBeautician.BeauticianType.FULL_TIME);
        condMap.put("managerBeauticianType", StoreBeautician.BeauticianType.MANAGER);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.put("homeServerType", Product.ServerType.HOME);
        List<Integer> beauticianTypeList = new ArrayList<>(10);
        beauticianTypeList.add(StoreBeautician.BeauticianType.FULL_TIME);
        beauticianTypeList.add(StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("beauticianTypeList", beauticianTypeList);
        condMap.put("limit", limit);
        condMap.putAll(ConditionUtil.onSaleProduct());
        List<BeauticianByNearbyResVo> list = this.storeBeauticianMapper.listNearby(condMap);
        if (CollectionUtils.isEmpty(list)) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NEARBY_NULL, StoreConstant.Query.BEAUTICIAN_NEARBY_NULL_MSG);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> getDistanceV111(int beauticianId, MapPointVo pointVo) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(pointVo), Map.class);
        condMap.put("beauticianId", beauticianId);
        int distance = this.storeBeauticianMapper.getDistance(condMap);
        responseMessage.setData(distance);
        return responseMessage;
    }

    /**
     * 获取开始服务时间
     *
     * @return
     */
    private String getStartServiceTime() {
        String currentTime = DateFormatUtils.format(System.currentTimeMillis(), "HH:mm");
        String[] serviceTimeArr = currentTime.split(":");
        int serviceTimeHh = Integer.valueOf(serviceTimeArr[0]);
        int serviceTimeMm = Integer.valueOf(serviceTimeArr[1]);
        int serviceTimeMm0 = 0;
        int serviceTimeMm10 = 10;
        int serviceTimeMm30 = 30;
        int serviceTimeHh0 = 0;
        int serviceTimeHh10 = 10;
        int serviceTimeHh23 = 23;
        if (serviceTimeMm0 == serviceTimeMm || serviceTimeMm == serviceTimeMm30) {

        } else if (serviceTimeMm30 < serviceTimeMm) {
            serviceTimeMm = serviceTimeMm0;
            if (serviceTimeHh23 == serviceTimeHh) {
                serviceTimeHh = serviceTimeHh0;
            } else {
                serviceTimeHh = serviceTimeHh + 1;
            }
        } else {
            serviceTimeMm = serviceTimeMm30;
        }
        StringBuffer serviceTime = new StringBuffer();
        if (serviceTimeHh0 == serviceTimeHh) {
            serviceTime.append("00");
        } else {
            if (serviceTimeHh < serviceTimeHh10) {
                serviceTime.append("0");
            }
            serviceTime.append(serviceTimeHh);
        }
        serviceTime.append(":");
        if (serviceTimeMm0 == serviceTimeMm) {
            serviceTime.append("00");
        } else {
            if (serviceTimeMm < serviceTimeMm10) {
                serviceTime.append("0");
            }
            serviceTime.append(serviceTimeMm);
        }
        return serviceTime.toString();
    }

    /**
     * 获取服务时间节点
     *
     * @param startServiceTime   开始服务时间
     * @param serviceTimeNodeNum 服务时间节点数
     * @return
     */
    private List<String> getServiceTimeNode(String startServiceTime, int serviceTimeNodeNum) {
        List<String> endServiceTimeList = new ArrayList<>(10);
        String[] startServiceTimeArr = startServiceTime.split(":");
        int startServiceTimeHh = Integer.valueOf(startServiceTimeArr[0]);
        int startServiceTimeMm = Integer.valueOf(startServiceTimeArr[1]);
        StringBuffer endServiceTime = new StringBuffer();
        int serviceTimeMm0 = 0;
        int serviceTimeMm30 = 30;
        int serviceTimeHh0 = 0;
        int serviceTimeHh23 = 23;
        if (serviceTimeMm0 == startServiceTimeMm || serviceTimeMm30 == startServiceTimeMm) {
        } else if (startServiceTimeMm > serviceTimeMm30) {
            startServiceTimeMm = serviceTimeMm0;
            if (serviceTimeHh23 == startServiceTimeHh) {
                startServiceTimeHh = serviceTimeHh0;
            } else {
                startServiceTimeHh = startServiceTimeHh + 1;
            }
        } else {
            startServiceTimeMm = serviceTimeMm30;
        }
        for (int i = 0; i < serviceTimeNodeNum; i++) {
            endServiceTime.setLength(0);
            if (serviceTimeHh0 == startServiceTimeHh) {
                endServiceTime.append("00");
            } else {
                endServiceTime.append(startServiceTimeHh);
            }
            endServiceTime.append(":");
            if (serviceTimeMm0 == startServiceTimeMm) {
                endServiceTime.append("00");
            } else {
                endServiceTime.append(startServiceTimeMm);
            }
            endServiceTimeList.add(endServiceTime.toString());
            if (serviceTimeMm0 == startServiceTimeMm) {
                startServiceTimeMm = serviceTimeMm30;
            } else {
                startServiceTimeMm = serviceTimeMm0;
                if (serviceTimeHh23 == startServiceTimeHh) {
                    startServiceTimeHh = serviceTimeHh0;
                } else {
                    startServiceTimeHh = startServiceTimeHh + 1;
                }
            }
        }
        return endServiceTimeList;
    }

    /**
     * 获取服务时间节点
     *
     * @param startServiceTime 开始服务时间
     * @param endServiceTime   结束服务时间
     * @return
     */
    public List<String> getServiceTimeNode(String startServiceTime, String endServiceTime) {
        List<String> serviceTimeList = new ArrayList<>(10);
        String[] startServiceTimeArr = startServiceTime.split(":");
        String[] endServiceTimeArr = endServiceTime.split(":");
        int startServiceTimeHh = Integer.valueOf(startServiceTimeArr[0]);
        int startServiceTimeMm = Integer.valueOf(startServiceTimeArr[1]);
        int endServiceTimeHh = Integer.valueOf(endServiceTimeArr[0]);
        int endServiceTimeMm = Integer.valueOf(endServiceTimeArr[1]);
        if (startServiceTimeHh >= endServiceTimeHh && startServiceTimeMm >= endServiceTimeMm) {
            return serviceTimeList;
        }
        int serviceTimeMm0 = 0;
        int serviceTimeMm30 = 30;
        if (serviceTimeMm0 == startServiceTimeMm || serviceTimeMm30 == startServiceTimeMm) {

        } else if (startServiceTimeMm > serviceTimeMm30) {
            startServiceTimeMm = serviceTimeMm0;
            startServiceTimeHh = startServiceTimeHh + 1;
        } else {
            startServiceTimeMm = serviceTimeMm30;
        }
        if (serviceTimeMm0 == endServiceTimeMm || serviceTimeMm30 == endServiceTimeMm) {
        } else if (endServiceTimeMm >= serviceTimeMm30) {
            endServiceTimeMm = serviceTimeMm30;
        } else {
            endServiceTimeMm = serviceTimeMm0;
        }
        boolean timeFlag = true;
        while (timeFlag) {
            if (startServiceTimeMm == serviceTimeMm0) {
                serviceTimeList.add(startServiceTimeHh + ":00");
                startServiceTimeMm = serviceTimeMm30;
            } else if (startServiceTimeMm == serviceTimeMm30) {
                serviceTimeList.add(startServiceTimeHh + ":30");
                startServiceTimeMm = serviceTimeMm0;
                startServiceTimeHh = startServiceTimeHh + 1;
            }
            if (startServiceTimeHh > endServiceTimeHh) {
                timeFlag = false;
            }
            if (startServiceTimeHh == endServiceTimeHh && startServiceTimeMm == endServiceTimeMm) {
                timeFlag = false;
            }
        }
        return serviceTimeList;
    }

    /**
     * 添加服务时间
     *
     * @param serviceTime 服务时间
     * @param addNodeNum  添加节点数
     * @return
     */
    private String addServiceTime(String serviceTime, int addNodeNum) {
        String[] serviceTimeArr = serviceTime.split(":");
        int serviceTimeHh = Integer.valueOf(serviceTimeArr[0]);
        int serviceTimeMm = Integer.valueOf(serviceTimeArr[1]);
        int serviceTimeMm0 = 0;
        int serviceTimeMm30 = 30;
        int serviceTimeHh0 = 0;
        int serviceTimeHh23 = 23;
        if (serviceTimeMm0 == serviceTimeMm || serviceTimeMm30 == serviceTimeMm) {
        } else if (serviceTimeMm > serviceTimeMm30) {
            serviceTimeMm = serviceTimeMm0;
            serviceTimeHh = serviceTimeHh + 1;
        } else {
            serviceTimeMm = serviceTimeMm30;
        }
        for (int i = 0; i < addNodeNum; i++) {
            if (serviceTimeMm0 == serviceTimeMm) {
                serviceTimeMm = serviceTimeMm30;
            } else {
                serviceTimeMm = serviceTimeMm0;
                if (serviceTimeHh23 == serviceTimeHh) {
                    serviceTimeHh = serviceTimeHh0;
                } else {
                    serviceTimeHh = serviceTimeHh + 1;
                }
            }
        }
        StringBuffer serviceTimeBuffer = new StringBuffer();
        if (serviceTimeHh0 == serviceTimeHh) {
            serviceTimeBuffer.append("00");
        } else {
            serviceTimeBuffer.append(serviceTimeHh);
        }
        serviceTimeBuffer.append(":");
        if (serviceTimeMm0 == serviceTimeMm) {
            serviceTimeBuffer.append("00");
        } else {
            serviceTimeBuffer.append(serviceTimeMm);
        }
        return serviceTimeBuffer.toString();
    }

    /**
     * 美容师库存
     *
     * @param productIdVo      项目条件
     * @param beauticianList   美容师集合
     * @param beauticianIdList 美容师ID集合
     */
    private List<BeauticianListOrderByHomeProductResVo> nearestByInventory(BeauticianNearestByProductIdVo productIdVo, List<BeauticianListOrderByHomeProductResVo> beauticianList, List<Integer> beauticianIdList) {
        if (null == productIdVo.getStoreId()) {
            ResponseMessage<ProductProductPhysicalRef> productProductPhysicalRefRes = this.productProductPhysicalRefFeign.getByProductIdV111(productIdVo.getProductId());
            if (ResponseUtil.isSuccess(productProductPhysicalRefRes)) {
                PhysicalBeauticianRefListInventoryByProductIdVo inventoryByProductIdVo = new PhysicalBeauticianRefListInventoryByProductIdVo();
                inventoryByProductIdVo.setProductId(productIdVo.getProductId());
                inventoryByProductIdVo.setBeauticanIdList(beauticianIdList);
                ResponseMessage<List<ProductPhysicalBeauticianRef>> productPhysicalBeauticianRefRes = this.productPhysicalBeauticianRefFeign.listInventoryByProductIdV111(inventoryByProductIdVo);
                ResponseUtil.isFailThrowException(productPhysicalBeauticianRefRes);
                List<ProductPhysicalBeauticianRef> productPhysicalBeauticianRefList = productPhysicalBeauticianRefRes.getData();
                beauticianIdList = productPhysicalBeauticianRefList.stream().map(ProductPhysicalBeauticianRef::getBeauticianId).collect(Collectors.toList());
            }
        }
        List<BeauticianListOrderByHomeProductResVo> inventoryBeauticianList;
        if (CollectionUtils.isNotEmpty(beauticianIdList)) {
            inventoryBeauticianList = new ArrayList<>(10);
            for (BeauticianListOrderByHomeProductResVo beautician : beauticianList) {
                if (beauticianIdList.contains(beautician.getBeauticianId())) {
                    inventoryBeauticianList.add(beautician);
                }
            }
        } else {
            throw new ResponseException(StoreConstant.Query.PRODUCT_NOT_BEANUTICIAN_SERVICE, StoreConstant.Query.PRODUCT_NOT_BEANUTICIAN_SERVICE_MSG);
        }
        return inventoryBeauticianList;
    }

    /**
     * 美容师服务时间
     *
     * @param inventoryBeauticianList     库存美容师集合
     * @param beauticianBusyTimeList      美容师忙碌时间集合
     * @param orderBeauticianBusyTimeList 美容师订单预约时间集合
     * @return
     */
    private Map<Integer, List<String>> nearestByServiceTime(List<BeauticianListOrderByHomeProductResVo> inventoryBeauticianList, List<BeauticianBusyTime> beauticianBusyTimeList, List<BeauticianBusyTimeVo> orderBeauticianBusyTimeList) {
        Map<Integer, List<String>> serviceTimeMap = new HashMap<>(16);
        List<String> serviceTimeList;
        for (BeauticianListOrderByHomeProductResVo beautician : inventoryBeauticianList) {
            serviceTimeList = serviceTimeMap.get(beautician.getBeauticianId());
            if (CollectionUtils.isEmpty(serviceTimeList)) {
                serviceTimeList = this.getServiceTimeNode(beautician.getStartBusinessHour(), beautician.getEndBusinessHour());
            }
            // 移除美容师忙碌时间
            if (CollectionUtils.isNotEmpty(beauticianBusyTimeList)) {
                for (BeauticianBusyTime beauticianBusyTime : beauticianBusyTimeList) {
                    if (beautician.getBeauticianId().equals(beauticianBusyTime.getBeauticianId())) {
                        String[] busyTimeArr = beauticianBusyTime.getBusyTime().split(",");
                        for (String busyTime : busyTimeArr) {
                            serviceTimeList.remove(busyTime);
                        }
                    }
                }
            }
            // 移除美容师订单预约时间
            if (CollectionUtils.isNotEmpty(orderBeauticianBusyTimeList)) {
                for (BeauticianBusyTimeVo orderBeauticianBusyTime : orderBeauticianBusyTimeList) {
                    if (beautician.getBeauticianId().equals(orderBeauticianBusyTime.getBeauticianId())) {
                        Set<OrderTimeVo> orderTimeSet = orderBeauticianBusyTime.getOrderTimeVoSet();
                        for (OrderTimeVo orderTime : orderTimeSet) {
                            String orderStartTime = DateFormatUtils.format(orderTime.getServerStartTime(), "HH:mm");
                            String orderEndTime = DateFormatUtils.format(orderTime.getServerEndTime(), "HH:mm");
                            List<String> busyTimeList = this.getServiceTimeNode(orderStartTime, orderEndTime);
                            if (CollectionUtils.isNotEmpty(busyTimeList)) {
                                for (String busyTime : busyTimeList) {
                                    serviceTimeList.remove(busyTime);
                                }
                            }
                        }
                    }
                }
            }
            serviceTimeMap.put(beautician.getBeauticianId(), serviceTimeList);
        }
        return serviceTimeMap;
    }

    /**
     * 服务时间处理
     *
     * @param resVoList               结果集合
     * @param responseMessage         响应消息
     * @param inventoryBeauticianList 库存美容师集合
     * @param serviceTimeMap          服务时间
     * @param serviceDate             服务日期
     * @param startServiceTime        开始服务时间
     * @param serviceTimeNodeNum      服务时间节点数
     * @param resLimit                结果限制
     * @return
     */
    private List<BeauticianNearestByProductIdResVo> nearestByServiceTimeHandler(List<BeauticianNearestByProductIdResVo> resVoList, List<BeauticianListOrderByHomeProductResVo> inventoryBeauticianList, Map<Integer, List<String>> serviceTimeMap, String serviceDate, String startServiceTime, int serviceTimeNodeNum, int resLimit) {
        try {
            long startServiceTimeLong;
            long endServiceTimeLong = DateUtils.parseDate("23:30", "HH:mm").getTime();
            boolean whileFlag = true;
            while (whileFlag) {
                startServiceTimeLong = DateUtils.parseDate(startServiceTime, "HH:mm").getTime();
                List<String> orderServiceTimeList = this.getServiceTimeNode(startServiceTime, serviceTimeNodeNum);
                for (Map.Entry<Integer, List<String>> entry : serviceTimeMap.entrySet()) {
                    if (entry.getValue().containsAll(orderServiceTimeList)) {
                        for (BeauticianListOrderByHomeProductResVo beautician : inventoryBeauticianList) {
                            List<Integer> resBeauticianId = resVoList.stream().map(BeauticianNearestByProductIdResVo::getBeauticianId).collect(Collectors.toList());
                            if (entry.getKey().equals(beautician.getBeauticianId()) && !resBeauticianId.contains(beautician.getBeauticianId())) {
                                BeauticianNearestByProductIdResVo resVo = new BeauticianNearestByProductIdResVo();
                                resVo.setBeauticianId(beautician.getBeauticianId());
                                resVo.setStoreId(beautician.getStoreId());
                                resVo.setAffiliatedStoreId(beautician.getAffiliatedStoreId());
                                resVo.setBeauticianNickName(beautician.getBeauticianNickName());
                                resVo.setBeauticianType(beautician.getBeauticianType());
                                resVo.setHeadImgUrl(beautician.getHeadImgUrl());
                                resVo.setBeauticianStar(beautician.getBeauticianStar());
                                resVo.setSatisfaction(beautician.getSatisfaction());
                                resVo.setLabel(beautician.getLabel());
                                resVo.setDistance(beautician.getDistance());
                                resVo.setServiceDate(serviceDate);
                                resVo.setServiceTime(startServiceTime);
                                resVoList.add(resVo);
                                if (resLimit <= resVoList.size()) {
                                    return resVoList;
                                }
                            }
                        }
                    }
                }
                if (startServiceTimeLong == endServiceTimeLong) {
                    whileFlag = false;
                } else {
                    startServiceTime = addServiceTime(startServiceTime, 1);
                }
            }
        } catch (ParseException e) {
            throw new ResponseException(StoreConstant.Param.PARSE_DATE_TIME_ERROR, StoreConstant.Param.PARSE_DATE_TIME_ERROR_MSG);
        }
        return resVoList;
    }

    @Override
    public ResponseMessage<BeauticianNearestByProductIdResVo> getNearestByProductIdV111(BeauticianNearestByProductIdVo productIdVo) {
        ResponseMessage<BeauticianNearestByProductIdResVo> responseMessage = new ResponseMessage<>();
        // 项目
        ResponseMessage<Product> productRes = this.productFeign.findById(productIdVo.getProductId());
        ResponseUtil.isFailThrowException(productRes);
        Product product = productRes.getData();
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productIdVo), Map.class);
        if (null == productIdVo.getStoreId()) {
            condMap.put("serverType", Product.ServerType.HOME);
        } else {
            condMap.put("serverType", Product.ServerType.STORE);
        }
        // 服务日期
        String serviceDate;
        // 开始服务时间
        String startServiceTime = this.getStartServiceTime();
        // 服务时间节点数
        int serviceTimeNodeNum = (int) Math.ceil((double) product.getServerNeedTime() / 30);
        // 最近三天
        int day = 0;
        int maxDay = 3;
        while (maxDay >= day) {
            serviceDate = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addDays(new Date(), day));
            condMap.put("serviceDate", serviceDate);
            if (0 == day) {
                condMap.put("serviceTime", startServiceTime);
            } else {
                condMap.remove("serviceTime");
            }
            condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
            condMap.put("parttimeBeauticianType", StoreBeautician.BeauticianType.PART_TIME);
            condMap.put("storeServerType", Product.ServerType.STORE);
            // 美容师/营业时间
            List<BeauticianListOrderByHomeProductResVo> beauticianList = this.storeBeauticianMapper.listOrderByProduct(condMap);
            if (CollectionUtils.isNotEmpty(beauticianList)) {
                // 美容师库存
                List<Integer> beauticianIdList = beauticianList.stream().map(BeauticianListOrderByHomeProductResVo::getBeauticianId).collect(Collectors.toList());
                List<BeauticianListOrderByHomeProductResVo> inventoryBeauticianList = this.nearestByInventory(productIdVo, beauticianList, beauticianIdList);
                // 美容师忙碌时间
                List<BeauticianBusyTime> beauticianBusyTimeList = this.listBeauticianBusyTime(beauticianIdList, serviceDate);
                // 美容师订单预约时间
                ChooseBeauticianListVo chooseBeauticianListVo = new ChooseBeauticianListVo();
                chooseBeauticianListVo.setChooseTime(serviceDate);
                chooseBeauticianListVo.setBeauticianIdList(beauticianIdList);
                ResponseMessage<List<BeauticianBusyTimeVo>> orderBeauticianBusyTimeRes;
                try {
                    orderBeauticianBusyTimeRes = this.orderBeauticianFeign.queryBeauticianBusyTime(chooseBeauticianListVo);
                } catch (ParseException e) {
                    throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
                }
                ResponseUtil.isFailThrowException(orderBeauticianBusyTimeRes);
                List<BeauticianBusyTimeVo> orderBeauticianBusyTimeList = orderBeauticianBusyTimeRes.getData();
                // 美容师服务时间
                Map<Integer, List<String>> serviceTimeMap = this.nearestByServiceTime(inventoryBeauticianList, beauticianBusyTimeList, orderBeauticianBusyTimeList);
                // 服务时间节点
                int resLimit = 1;
                List<BeauticianNearestByProductIdResVo> resVoList = new ArrayList<>(10);
                this.nearestByServiceTimeHandler(resVoList, inventoryBeauticianList, serviceTimeMap, serviceDate, startServiceTime, serviceTimeNodeNum, resLimit);
                if (resLimit <= resVoList.size()) {
                    responseMessage.setData(resVoList.get(0));
                    return responseMessage;
                }
            }
            startServiceTime = "00:30";
            day++;
        }
        if (null == responseMessage.getData()) {
            throw new ResponseException(StoreConstant.Query.PRODUCT_NOT_BEANUTICIAN_SERVICE, StoreConstant.Query.PRODUCT_NOT_BEANUTICIAN_SERVICE_MSG);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeauticianNearestByProductIdResVo> getStoreNearestByProductIdV111(BeauticianNearestByProductIdVo productIdVo) {
        ResponseMessage<StoreBeauticianNearestByProductIdResVo> responseMessage = new ResponseMessage<>();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(productIdVo.getStoreId());
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        // 美容师
        ResponseMessage<BeauticianNearestByProductIdResVo> beauticianRes = this.getNearestByProductIdV111(productIdVo);
        ResponseUtil.isFailThrowException(beauticianRes);
        BeauticianNearestByProductIdResVo beautician = beauticianRes.getData();
        // 结果
        StoreBeauticianNearestByProductIdResVo resVo = new StoreBeauticianNearestByProductIdResVo();
        resVo.setStore(store);
        resVo.setStoreBeautician(beautician);
        responseMessage.setData(resVo);
        return responseMessage;
    }

    /**
     * 美容师忙碌时间
     *
     * @param beauticianIdList 美容师ID集合
     * @param busyDate         忙碌日期
     * @return
     */
    private List<BeauticianBusyTime> listBeauticianBusyTime(List<Integer> beauticianIdList, String busyDate) {
        Map<String, Object> beauticianBusyTimeMap = new HashMap<>(16);
        beauticianBusyTimeMap.put("beauticianIdList", beauticianIdList);
        beauticianBusyTimeMap.put("busyDate", busyDate);
        // 美容师忙碌时间
        return this.beauticianBusyTimeMapper.listBeauticianListByBusyDate(beauticianBusyTimeMap);
    }

    @Override
    public ResponseMessage<List<BeauticianNearestByProductIdResVo>> listNearestByProductIdV111(BeauticianListNearestByProductIdVo productIdVo) {
        ResponseMessage<List<BeauticianNearestByProductIdResVo>> responseMessage = new ResponseMessage<>();
        // 项目
        ResponseMessage<Product> productRes = this.productFeign.findById(productIdVo.getProductId());
        ResponseUtil.isFailThrowException(productRes);
        Product product = productRes.getData();
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productIdVo), Map.class);
        if (null == productIdVo.getStoreId()) {
            condMap.put("serverType", Product.ServerType.HOME);
        } else {
            condMap.put("serverType", Product.ServerType.STORE);
        }
        String serviceDate;
        // 开始服务时间
        String startServiceTime = this.getStartServiceTime();
        // 服务时间节点数
        int serviceTimeNodeNum = (int) Math.ceil((double) product.getServerNeedTime() / 30);
        // 最近三天
        int day = 0;
        int maxDay = 3;
        while (day < maxDay) {
            serviceDate = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addDays(new Date(), day));
            condMap.put("serviceDate", serviceDate);
            if (0 == day) {
                condMap.put("serviceTime", startServiceTime);
            } else {
                condMap.remove("serviceTime");
            }
            condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
            condMap.put("parttimeBeauticianType", StoreBeautician.BeauticianType.PART_TIME);
            condMap.put("storeServerType", Product.ServerType.STORE);
            // 美容师/营业时间
            List<BeauticianListOrderByHomeProductResVo> beauticianList = this.storeBeauticianMapper.listOrderByProduct(condMap);
            if (CollectionUtils.isNotEmpty(beauticianList)) {
                // 美容师库存
                List<Integer> beauticianIdList = beauticianList.stream().map(BeauticianListOrderByHomeProductResVo::getBeauticianId).collect(Collectors.toList());
                BeauticianNearestByProductIdVo inventoryVo = new BeauticianNearestByProductIdVo();
                inventoryVo.setProductId(productIdVo.getProductId());
                inventoryVo.setStoreId(productIdVo.getStoreId());
                inventoryVo.setPoint(productIdVo.getPoint());
                List<BeauticianListOrderByHomeProductResVo> inventoryBeauticianList = this.nearestByInventory(inventoryVo, beauticianList, beauticianIdList);
                // 美容师忙碌时间
                List<BeauticianBusyTime> beauticianBusyTimeList = this.listBeauticianBusyTime(beauticianIdList, serviceDate);
                // 美容师订单预约时间
                ChooseBeauticianListVo chooseBeauticianListVo = new ChooseBeauticianListVo();
                chooseBeauticianListVo.setChooseTime(serviceDate);
                chooseBeauticianListVo.setBeauticianIdList(beauticianIdList);
                ResponseMessage<List<BeauticianBusyTimeVo>> orderBeauticianBusyTimeRes;
                try {
                    orderBeauticianBusyTimeRes = this.orderBeauticianFeign.queryBeauticianBusyTime(chooseBeauticianListVo);
                } catch (ParseException e) {
                    throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
                }
                ResponseUtil.isFailThrowException(orderBeauticianBusyTimeRes);
                List<BeauticianBusyTimeVo> orderBeauticianBusyTimeList = orderBeauticianBusyTimeRes.getData();
                // 美容师服务时间
                Map<Integer, List<String>> serviceTimeMap = this.nearestByServiceTime(inventoryBeauticianList, beauticianBusyTimeList, orderBeauticianBusyTimeList);
                // 服务时间节点
                int resLimit = 10;
                List<BeauticianNearestByProductIdResVo> resVoList = responseMessage.getData();
                if (CollectionUtils.isEmpty(resVoList)) {
                    resVoList = new ArrayList<>();
                }
                this.nearestByServiceTimeHandler(resVoList, inventoryBeauticianList, serviceTimeMap, serviceDate, startServiceTime, serviceTimeNodeNum, resLimit);
                responseMessage.setData(resVoList);
                if (resLimit <= resVoList.size()) {
                    return responseMessage;
                }
            }
            startServiceTime = "00:30";
            day++;
        }
        if (null == responseMessage.getData()) {
            throw new ResponseException(StoreConstant.Query.PRODUCT_NOT_BEANUTICIAN_SERVICE, StoreConstant.Query.PRODUCT_NOT_BEANUTICIAN_SERVICE_MSG);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findManagerByBeauticianIdV111(int beauticianId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.MANAGER);
        condMap.put("storeId", beautician.getStoreId());
        StoreBeautician managerBeautician = this.storeBeauticianMapper.getManagerByStoreId(condMap);
        if (null == managerBeautician) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(managerBeautician);
        return responseMessage;
    }


    @Override
    public ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> listGrowthValueRankingV111(int beauticianId, int limit) {
        ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> responseMessage = new ResponseMessage<>();
        Map<String, Object> beauticianCondMap = new HashMap<>(16);
        beauticianCondMap.put("beauticianId", beauticianId);
        beauticianCondMap.put("limit", 1);
        List<BeauticianByListGrowthValueRankingResVo> beauticianlist = this.storeBeauticianMapper.listGrowthValueRanking(beauticianCondMap);
        if (CollectionUtils.isEmpty(beauticianlist)) {
            throw new ResponseException(ResponseContants.QUERY_RESULT_EMPTY, ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        beauticianlist.forEach(beautician -> {
            beautician.setIsOneself(true);
        });
        Map<String, Object> rankingCondMap = new HashMap<>(16);
        rankingCondMap.put("limit", limit);
        List<BeauticianByListGrowthValueRankingResVo> rankingList = this.storeBeauticianMapper.listGrowthValueRanking(rankingCondMap);
        if (CollectionUtils.isEmpty(beauticianlist)) {
            throw new ResponseException(ResponseContants.QUERY_RESULT_EMPTY, ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        beauticianlist.forEach(beautician -> {
            beautician.setIsOneself(false);
        });
        beauticianlist.addAll(rankingList);
        responseMessage.setData(beauticianlist);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> listActivityByStoreIdV111(int storeId) {
        ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = ConditionUtil.passBeautician();
        condMap.put("storeId", storeId);
        List<StoreBeautician> beauticianList = this.storeBeauticianMapper.selectListByBeautician(condMap);
        StoreFriend storeFriend = new StoreFriend();
        storeFriend.setStoreId(storeId);
        List<StoreFriend> friendList = this.storeFriendMapper.selectListByConditions(storeFriend);
        List<BeauticianByStoreIdForActivityResVo> resVoList = new ArrayList<>(10);
        if (CollectionUtils.isNotEmpty(beauticianList)) {
            beauticianList.forEach(beautician -> {
                BeauticianByStoreIdForActivityResVo resVo = new BeauticianByStoreIdForActivityResVo();
                resVo.setBeauticianId(beautician.getId());
                resVo.setBeauticianNickName(beautician.getBeauticianNickName());
                resVo.setPhone(beautician.getPhone());
                resVo.setBeauticianType(beautician.getBeauticianType());
                resVoList.add(resVo);
            });
        }
        if (CollectionUtils.isNotEmpty(friendList)) {
            friendList.forEach(friend -> {
                BeauticianByStoreIdForActivityResVo resVo = new BeauticianByStoreIdForActivityResVo();
                resVo.setBeauticianId(friend.getId());
                resVo.setBeauticianNickName(friend.getFriendName());
                resVo.setPhone(friend.getPhone());
                resVo.setBeauticianType(StoreBeautician.BeauticianType.FRIEND);
                resVoList.add(resVo);
            });
        }
        responseMessage.setData(resVoList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BeauticianByBusinessHourResVo> getBusinessHourByIdV111(int id) {
        ResponseMessage<BeauticianByBusinessHourResVo> responseMessage = new ResponseMessage<>();
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(id);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        BeauticianByBusinessHourResVo resVo = new BeauticianByBusinessHourResVo();
        resVo.setStartBusinessHour(beautician.getStartBusinessHour());
        resVo.setEndBusinessHour(beautician.getEndBusinessHour());
        resVo.setWorkday(beautician.getWorkday());
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianListManageResVo>> listManageByStoreIdV111(Integer pageNo, Integer pageSize, BeauticianListManageVo storeIdVo) {
        ResponseMessage<PageInfo<BeauticianListManageResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(storeIdVo), Map.class);
        condMap.putAll(ConditionUtil.passBeautician());
        List<Integer> beauticianTypeList = new ArrayList<>(10);
        switch (storeIdVo.getEmployeeType()) {
            case BeauticianListManageVo.EmployeeType.STORE:
                beauticianTypeList.add(StoreBeautician.BeauticianType.MANAGER);
                beauticianTypeList.add(StoreBeautician.BeauticianType.FULL_TIME);
                break;
            case BeauticianListManageVo.EmployeeType.AFFILIATED:
                beauticianTypeList.add(StoreBeautician.BeauticianType.PART_TIME);
                break;
            default:
                break;
        }
        condMap.put("beauticianTypeList", beauticianTypeList);
        List<BeauticianListManageResVo> list = this.storeBeauticianMapper.listManageByStoreId(condMap);
        PageInfo<BeauticianListManageResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BeauticianRecruitConditionResVo> getRecruitConditionV111(int cityId) {
        ResponseMessage<BeauticianRecruitConditionResVo> responseMessage = new ResponseMessage<>();
        BeauticianRecruitConditionResVo resVo = new BeauticianRecruitConditionResVo();
        // 标签
        List<String> labelList = this.storeBeauticianMapper.listLabel();
        if (CollectionUtils.isNotEmpty(labelList)) {
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            labelList.forEach(label -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(label);
                condition.setValue(label);
                conditionList.add(condition);
            });
            resVo.setLabelList(conditionList);
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
        // 美容师星级
        ResponseMessage<BaseDicGroupDeatilResVo> beauticianStarRes = this.baseDicGroupFeign.detailByCodeV111("BEAUTICIAN_STAR");
        if (ResponseUtil.isSuccess(beauticianStarRes)) {
            BaseDicGroupDeatilResVo deatilResVo = beauticianStarRes.getData();
            BaseDicGroup dicGroup = deatilResVo.getDicGroup();
            List<BaseDicGroupItem> itemList = deatilResVo.getItemList();
            List<ConditionResVo> conditionList = new ArrayList<>(10);
            itemList.forEach(item -> {
                ConditionResVo condition = new ConditionResVo();
                condition.setText(item.getName());
                condition.setValue(item.getValue());
                conditionList.add(condition);
            });
            resVo.setBeauticianStarList(conditionList);
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProductV111(Integer pageNo, Integer pageSize, BeauticianListSelectOnSaleProductVo productVo) {
        ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productVo), Map.class);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("fulltimeBeauticianType", StoreBeautician.BeauticianType.FULL_TIME);
        List<BeauticianListSelectOnSaleProductResVo> list = null;
        switch (productVo.getServerType()) {
            case Product.ServerType.STORE:
                list = this.storeBeauticianMapper.listSelectOnSaleStoreProduct(condMap);
                break;
            case Product.ServerType.HOME:
                list = this.storeBeauticianMapper.listSelectOnSaleHomeProduct(condMap);
                break;
            default:
                break;
        }
        PageInfo<BeauticianListSelectOnSaleProductResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BeauticianDetailResVo> getDetailV111(BeauticianDetailVo detailVo) {
        ResponseMessage<BeauticianDetailResVo> responseMessage = new ResponseMessage<>();
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(detailVo.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        // 是否关注
        boolean isFollower = false;
        if (null != detailVo.getMemberId()) {
            Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(detailVo), Map.class);
            isFollower = this.beauticianFollowerMapper.isFollower(condMap);
        }
        // 结果
        BeauticianDetailResVo resVo = new BeauticianDetailResVo();
        resVo.setBeautician(beautician);
        resVo.setIsFollower(isFollower);
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage accumulateGrowthValueV111(int beauticianId, int growthValue) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        Integer growth = beautician.getGrowupValue() + growthValue;
        //查询当前等级
        ResponseMessage<StoreBeauticianLevel> storeBeauticianLevelResponseMessage = this.storeBeauticianLevelService.getLevelBySetionGrowup(growth);
        ResponseUtil.isFailThrowException(storeBeauticianLevelResponseMessage);
        StoreBeauticianLevel storeBeauticianLevel = storeBeauticianLevelResponseMessage.getData();
        if (null == storeBeauticianLevel) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_LEVEL_EXIST, StoreConstant.Query.BEAUTICIAN_LEVEL_EXIST_MSG);
        }
        beautician.setBeauticianStar(storeBeauticianLevel.getStarValue());
        beautician.setLevelId(storeBeauticianLevel.getId());
        beautician.setLevelLogo(storeBeauticianLevel.getLevelLogo());
        beautician.setLevelName(storeBeauticianLevel.getLevelName());
        beautician.setGrowupValue(growth);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        responseMessage.setData(beautician.getGrowupValue());
        return responseMessage;
    }

    /**
     * 美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @param orderDate    订单日期
     * @return
     */
    private StoreBeautician serviceTimeOrderByBeauticianBusinessHour(int beauticianId, String orderDate) {
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StringUtils.isEmpty(beautician.getWorkday()) || StringUtils.isEmpty(beautician.getStartBusinessHour()) || StringUtils.isEmpty(beautician.getEndBusinessHour())) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_BUSINESS_HOUR_NULL, StoreConstant.Query.BEAUTICIAN_BUSINESS_HOUR_NULL_MSG);
        }
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(DateUtils.parseDate(orderDate, "yyyy-MM-dd"));
        } catch (ParseException e) {
            throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
        }
        String[] workDayArr = beautician.getWorkday().split(",");
        Integer[] workDayIntArr = new Integer[workDayArr.length];
        for (int i = 0; i < workDayArr.length; i++) {
            workDayIntArr[i] = Integer.valueOf(workDayArr[i]);
        }
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            dayWeek = 7;
        } else {
            dayWeek--;
        }
        if (!Arrays.asList(workDayIntArr).contains(dayWeek)) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_BUSINESS_HOUR_THAT_DAY_RESTED, StoreConstant.Query.BEAUTICIAN_BUSINESS_HOUR_THAT_DAY_RESTED_MSG);
        }
        return beautician;
    }


    @Override
    public ResponseMessage<BeauticianServiceTimeOrderResVo> getServiceTimeOrderV111(int beauticianId, String orderDate) {
        ResponseMessage<BeauticianServiceTimeOrderResVo> responseMessage = new ResponseMessage<>();
        // 美容师
        StoreBeautician beautician = this.serviceTimeOrderByBeauticianBusinessHour(beauticianId, orderDate);
        Date startBusinessHour;
        Date endBusinessHour;
        try {
            startBusinessHour = DateUtils.parseDate(orderDate + " " + beautician.getStartBusinessHour(), "yyyy-MM-dd HH:mm");
            endBusinessHour = DateUtils.parseDate(orderDate + " " + beautician.getEndBusinessHour(), "yyyy-MM-dd HH:mm");
        } catch (ParseException e) {
            throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
        }
        // 忙碌时间集合
        List<Integer> beauticianIdList = new ArrayList<>(10);
        beauticianIdList.add(beauticianId);
        List<BeauticianBusyTime> beauticianBusyTimeList = this.listBeauticianBusyTime(beauticianIdList, orderDate);
        Set<OrderTimeVo> busyTimeSet = new HashSet<>();
        beauticianBusyTimeList.forEach(beauticianBusyTime -> {
            try {
                if (StringUtils.isNotEmpty(beauticianBusyTime.getBusyTime())) {
                    String[] busyTimeArr = beauticianBusyTime.getBusyTime().split(",");
                    for (String busyTime : busyTimeArr) {
                        Date startBusyTime = DateUtils.parseDate(orderDate + " " + busyTime, "yyyy-MM-dd HH:mm");
                        Date endBusyTime = DateUtils.addMinutes(startBusyTime, 1);
                        OrderTimeVo orderTimeVo = new OrderTimeVo();
                        orderTimeVo.setServerStartTime(startBusyTime);
                        orderTimeVo.setServerEndTime(endBusyTime);
                        busyTimeSet.add(orderTimeVo);
                    }
                }
            } catch (ParseException e) {
                throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
            }
        });
        // 订单预约时间
        ChooseBeauticianListVo chooseBeauticianListVo = new ChooseBeauticianListVo();
        chooseBeauticianListVo.setChooseTime(orderDate);
        chooseBeauticianListVo.setBeauticianIdList(beauticianIdList);
        ResponseMessage<List<BeauticianBusyTimeVo>> beauticianBusyTimeRes = null;
        try {
            beauticianBusyTimeRes = this.orderBeauticianFeign.queryBeauticianBusyTime(chooseBeauticianListVo);
        } catch (ParseException e) {
            throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
        }
        ResponseUtil.isFailThrowException(beauticianBusyTimeRes);
        List<BeauticianBusyTimeVo> orderBeauticianBusyTimeList = beauticianBusyTimeRes.getData();
        if (CollectionUtils.isNotEmpty(orderBeauticianBusyTimeList)) {
            orderBeauticianBusyTimeList.forEach(orderBeauticianBusyTime -> {
                busyTimeSet.addAll(orderBeauticianBusyTime.getOrderTimeVoSet());
            });
        }
        // 结果
        BeauticianServiceTimeOrderResVo resVo = new BeauticianServiceTimeOrderResVo();
        resVo.setBeauticianId(beauticianId);
        resVo.setStartBusinessHour(startBusinessHour);
        resVo.setEndBusinessHour(endBusinessHour);
        resVo.setBusyTimeSet(busyTimeSet);
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> register(BeauticianByRegisterVo registerVo) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        // 根据手机号查询美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPhone(registerVo.getPhone());
        if (null != beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_PHONE_EXIST, StoreConstant.Query.BEAUTICIAN_PHONE_EXIST_MSG);
        }
        // 会员
        MrbMemberLoginVo mrbMemberLoginVo = new MrbMemberLoginVo();
        mrbMemberLoginVo.setLoginCustomer(2);
        mrbMemberLoginVo.setLoginType(1);
        mrbMemberLoginVo.setIp("192.168.1.1");
        mrbMemberLoginVo.setMobile(registerVo.getPhone());
        mrbMemberLoginVo.setPassword(registerVo.getPassword());
        mrbMemberLoginVo.setSource("2");
        mrbMemberLoginVo.setUserName(registerVo.getPhone());
        ResponseMessage<Member> memberRes = this.memberFeign.registerAmezMember(mrbMemberLoginVo);
        if (ResponseUtil.isFail(memberRes) && ResponseContants.QUERY_RESULT_EMPTY != memberRes.getCode()) {
            throw new ResponseException(memberRes);
        }
        Member member = memberRes.getData();
        // 环信
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(CommonConstant.ImUser.PASSWORD);
        ResponseMessage<ImUsers> imUsersRes = this.easemobImUsersFeign.registerSingle(user);
        if (ResponseUtil.isFail(imUsersRes)) {
            return (ResponseMessage) imUsersRes;
        }
        // 会员-环信-关联
        ImUsers imUsers = imUsersRes.getData();
        member.setImUserId(imUsers.getId());
        member.setImUsername(imUsers.getUsername());
        this.memberFeign.edit(member);
        // 美容师
        beautician = new StoreBeautician();
        beautician.setBeauticianNickName(CommonConstant.Beautician.NICK_NAME);
        beautician.setPhone(registerVo.getPhone());
        beautician.setMemberId(member.getId());
        beautician.setImUserId(imUsers.getId());
        beautician.setImUsername(imUsers.getUsername());
        beautician.setBeauticianType(StoreBeautician.BeauticianType.PART_TIME);
        beautician.setRegisterStatus(StoreBeautician.RegisterStatus.WAIT_IMPROVE);
        this.storeBeauticianMapper.insertSelective(beautician);
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> info(StoreBeautician beautician) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        beautician.setRegisterStatus(StoreBeautician.RegisterStatus.PENGDING);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage isOrder(int id, boolean isOrder) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeautician beautician = new StoreBeautician();
        beautician.setId(id);
        beautician.setIsOrder(isOrder);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage isHome(int id, boolean isHome) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeautician beautician = new StoreBeautician();
        beautician.setId(id);
        beautician.setIsOrder(isHome);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage isStore(int id, boolean isStore) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeautician beautician = new StoreBeautician();
        beautician.setId(id);
        beautician.setIsOrder(isStore);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> listFullTimeByStoreIdV111(Integer pageNo, Integer pageSize, int storeId) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = ConditionUtil.passBeautician();
        condMap.put("beauticianType", StoreBeautician.BeauticianType.FULL_TIME);
        condMap.put("storeId", storeId);
        List<StoreBeautician> list = this.storeBeauticianMapper.listFullTimeByStoreId(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> getManagerByStoreIdV111(int storeId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.MANAGER);
        condMap.put("storeId", storeId);
        StoreBeautician beautician = this.storeBeauticianMapper.getManagerByStoreId(condMap);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL, StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL_MSG);
        }
        responseMessage.setData(beautician);
        return responseMessage;
    }

}