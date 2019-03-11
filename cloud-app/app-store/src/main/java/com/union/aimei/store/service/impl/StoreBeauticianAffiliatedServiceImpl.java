package com.union.aimei.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.app.product.ProductBeauticianRefFeign;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.product.app.productbeauticianref.RemoveStoreByBeauticianIdVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import com.union.aimei.store.mapper.StoreBeauticianAffiliatedMapper;
import com.union.aimei.store.mapper.StoreBeauticianMapper;
import com.union.aimei.store.mapper.StoreMapper;
import com.union.aimei.store.service.StoreBeauticianAffiliatedService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:10
 */
@Service("storeBeauticianAffiliatedService")
public class StoreBeauticianAffiliatedServiceImpl implements StoreBeauticianAffiliatedService {
    @Resource
    private StoreBeauticianAffiliatedMapper storeBeauticianAffiliatedMapper;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;
    @Resource
    private StoreMapper storeMapper;
    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;
    @Resource
    private ProductBeauticianRefFeign productBeauticianRefFeign;

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> addV111(StoreBeauticianAffiliated affiliated) {
        ResponseMessage<StoreBeauticianAffiliated> responseMessage = new ResponseMessage<>();
        this.storeBeauticianAffiliatedMapper.insertSelective(affiliated);
        responseMessage.setData(affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyV111(StoreBeauticianAffiliated affiliated) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> findByIdV111(int id) {
        ResponseMessage<StoreBeauticianAffiliated> responseMessage = new ResponseMessage<>();
        StoreBeauticianAffiliated storeBeauticianAffiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(id);
        if (null == storeBeauticianAffiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        responseMessage.setData(storeBeauticianAffiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage<AffiliatedByBeauticianIdResVo> findByBeauticianIdV111(int beauticianId) {
        ResponseMessage<AffiliatedByBeauticianIdResVo> responseMessage = new ResponseMessage<>();
        AffiliatedByBeauticianIdResVo beauticianIdResVo = new AffiliatedByBeauticianIdResVo();
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        beauticianIdResVo.setAffiliatedStatus(beautician.getAffiliatedStatus());
        // 挂靠
        if (null != beautician.getAffiliatedId()) {
            int affiliatedId;
            if (StoreBeautician.AffiliatedStatus.APPLY_REMOVE_AFFILIATED == beautician.getAffiliatedStatus() || StoreBeautician.AffiliatedStatus.PENDING_PLATFORM_AUDIT == beautician.getAffiliatedStatus()) {
                affiliatedId = beautician.getRemoveAffiliatedId();
            } else {
                affiliatedId = beautician.getAffiliatedId();
            }
            beauticianIdResVo.setAffiliatedId(affiliatedId);
            StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
            if (null == affiliated) {
                throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
            }
            // 门店
            Store store = this.storeMapper.selectByPrimaryKey(affiliated.getStoreId());
            if (null != store) {
                beauticianIdResVo.setStoreId(store.getId());
                beauticianIdResVo.setStoreName(store.getStoreName());
                beauticianIdResVo.setStoreAddress(store.getProvinceName() + store.getCityName() + store.getAreaName() + store.getStoreAddress() + store.getHouseNumber());
            }
        }
        responseMessage.setData(beauticianIdResVo);
        return responseMessage;
    }

    /**
     * 申请发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void applySendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
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
        AffiliatedListInvitationByStoreIdVo storeIdVo = new AffiliatedListInvitationByStoreIdVo();
        storeIdVo.setStoreId(affiliated.getStoreId());
        storeIdVo.setListType(AffiliatedListInvitationByStoreIdVo.ListType.AFFILATED_APPLY);
        Map<String, Object> paramMap = JSONObject.parseObject(JSON.toJSONString(storeIdVo), Map.class);
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
    public ResponseMessage applyV111(int storeId, int beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.PENGING != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 挂靠
        StoreBeauticianAffiliated affiliated = new StoreBeauticianAffiliated();
        affiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.APPLY);
        affiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.BEAUTICIAN);
        affiliated.setBeauticianType(StoreBeautician.BeauticianType.PART_TIME);
        affiliated.setStoreId(store.getId());
        affiliated.setStoreName(store.getStoreName());
        affiliated.setBeauticianId(beauticianId);
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PENDING);
        this.storeBeauticianAffiliatedMapper.insertSelective(affiliated);
        // 美容师更新 挂靠状态=3-申请挂靠
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.APPLY_AFFILIATED);
        beautician.setAffiliatedId(affiliated.getId());
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        // 发送消息
        this.applySendMsg(SystemPushCodeEnum.BEAUTICIAN_HAND_APPLY_TO_STORE, SendMsgParamVo.BEAUTICIAN_HAND_APPLY_TO_STORE, beautician, affiliated);
        return responseMessage;
    }

    /**
     * 申请同意发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     */
    @Async
    public void applyAgreeSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("id", beautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", beautician.getStoreName());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage agreeApplyV111(int affiliatedId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.APPLY_AFFILIATED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 挂靠全部更新为不通过
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", StoreBeauticianAffiliated.AuditStatus.NOT_PASS);
        condMap.put("affiliatedType", affiliated.getAffiliatedType());
        condMap.put("storeId", affiliated.getStoreId());
        condMap.put("beauticianId", affiliated.getBeauticianId());
        this.storeBeauticianAffiliatedMapper.updateAuditStatus(condMap);
        // 挂靠更新 审核状态=1-审核通过
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        // 美容师更新 挂靠状态=2-已挂靠
        beautician.setStoreId(affiliated.getStoreId());
        beautician.setStoreName(affiliated.getStoreName());
        beautician.setAffiliatedId(affiliated.getId());
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.AFFILIATED);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        // 发送消息
        this.applyAgreeSendMsg(SystemPushCodeEnum.STORE_AGREE_APPLY_TO_BEAUTICIAN, SendMsgParamVo.STORE_AGREE_APPLY_TO_BEAUTICIAN, beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage refuseApplyV111(int affiliatedId, String auditReason) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.APPLY_AFFILIATED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        //获取店铺名称
        Store store = this.storeMapper.selectByPrimaryKey(affiliated.getStoreId());
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.EMPTY, StoreConstant.Query.EMPTY_MSG);
        }
        // 挂靠更新 审核状态=2-审核不通过
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.NOT_PASS);
        affiliated.setAuditReason(auditReason);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        // 美容师更新 挂靠状态=0-未入驻挂靠
        beautician.setId(affiliated.getBeauticianId());
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.PENGING);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        beautician.setStoreName(store.getStoreName());
        // 发送消息
        this.applyAgreeSendMsg(SystemPushCodeEnum.STORE_NOAGREE_APPLY_TO_BEAUTICIAN, SendMsgParamVo.STORE_NOAGREE_APPLY_TO_BEAUTICIAN, beautician);
        return responseMessage;
    }

    /**
     * 门店邀请挂靠发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param store        门店
     */
    @Async
    public void invinationSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, Store store) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("id", beautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", store.getStoreName());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage invinationV111(int storeId, int beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.PENGING != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_CANNOT_INVINATION, StoreConstant.Query.BEAUTICIAN_CANNOT_INVINATION_MSG);
        }
        // 挂靠
        StoreBeauticianAffiliated affiliated = new StoreBeauticianAffiliated();
        affiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.APPLY);
        affiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.STORE);
        affiliated.setBeauticianType(StoreBeautician.BeauticianType.PART_TIME);
        affiliated.setStoreId(storeId);
        affiliated.setBeauticianId(beauticianId);
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PENDING);
        List<StoreBeauticianAffiliated> affiliatedList = this.storeBeauticianAffiliatedMapper.selectListByConditions(affiliated);
        if (CollectionUtils.isNotEmpty(affiliatedList)) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_INVINATION_EXIST, StoreConstant.Query.BEAUTICIAN_INVINATION_EXIST_MSG);
        }
        affiliated.setStoreName(store.getStoreName());
        this.storeBeauticianAffiliatedMapper.insertSelective(affiliated);
        // 发送消息
        this.invinationSendMsg(SystemPushCodeEnum.STORE_APPLY_HAND_TO_BEAUTICIAN, SendMsgParamVo.STORE_APPLY_HAND_TO_BEAUTICIAN, beautician, store);
        return responseMessage;
    }

    /**
     * 美容师同意邀请挂靠发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void agreeInvitationSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
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
        AffiliatedListInvitationByStoreIdVo storeIdVo = new AffiliatedListInvitationByStoreIdVo();
        storeIdVo.setStoreId(affiliated.getStoreId());
        storeIdVo.setListType(AffiliatedListInvitationByStoreIdVo.ListType.INVITATION_RESULT);
        Map<String, Object> paramMap = JSONObject.parseObject(JSON.toJSONString(storeIdVo), Map.class);
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", affiliated.getStoreName());
        customMap.put("id", affiliated.getStoreId());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage agreeInvitationV111(int affiliatedId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.PENGING != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 挂靠全部更新为不通过
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", StoreBeauticianAffiliated.AuditStatus.NOT_PASS);
        condMap.put("affiliatedType", affiliated.getAffiliatedType());
        condMap.put("storeId", affiliated.getStoreId());
        condMap.put("beauticianId", affiliated.getBeauticianId());
        this.storeBeauticianAffiliatedMapper.updateAuditStatus(condMap);
        // 挂靠更新 审核状态=1-审核通过
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        // 美容师更新 挂靠状态=2-已挂靠
        beautician.setStoreId(affiliated.getStoreId());
        beautician.setStoreName(affiliated.getStoreName());
        beautician.setAffiliatedId(affiliated.getId());
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.AFFILIATED);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        // 发送消息
        this.agreeInvitationSendMsg(SystemPushCodeEnum.BEAUTICIAN_AGREE_HAND_TO_STORE, SendMsgParamVo.BEAUTICIAN_AGREE_HAND_TO_STORE, beautician, affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage refuseInvitationV111(int affiliatedId, String auditReason) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        // 挂靠更新 审核状态=2-审核不通过
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.NOT_PASS);
        affiliated.setAuditReason(auditReason);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        // 发送消息
        this.agreeInvitationSendMsg(SystemPushCodeEnum.BEAUTICIAN_NOT_AGREE_HAND_TO_STORE, SendMsgParamVo.BEAUTICIAN_NOT_AGREE_HAND_TO_STORE, beautician, affiliated);
        return responseMessage;
    }

    /**
     * 美容师解除挂靠发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void removeSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
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
        AffiliatedListInvitationByStoreIdVo storeIdVo = new AffiliatedListInvitationByStoreIdVo();
        storeIdVo.setStoreId(affiliated.getStoreId());
        storeIdVo.setListType(AffiliatedListInvitationByStoreIdVo.ListType.AFFILATED_REMOVE_APPLY);
        Map<String, Object> paramMap = JSONObject.parseObject(JSON.toJSONString(storeIdVo), Map.class);
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = JSONObject.parseObject(JSON.toJSONString(storeIdVo), Map.class);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", beautician.getBeauticianName());
        customMap.put("id", beautician.getId());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage removeV111(int affiliatedId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.AFFILIATED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 解除挂靠
        StoreBeauticianAffiliated removeAffiliated = affiliated;
        removeAffiliated.setId(null);
        removeAffiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.REMOVE);
        removeAffiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.BEAUTICIAN);
        removeAffiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PENDING);
        removeAffiliated.setCreateTime(new Date());
        this.storeBeauticianAffiliatedMapper.insertSelective(removeAffiliated);
        // 美容师更新 挂靠状态=4-申请解除挂靠
        beautician.setRemoveAffiliatedId(removeAffiliated.getId());
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.APPLY_REMOVE_AFFILIATED);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        // 发送消息
        this.removeSendMsg(SystemPushCodeEnum.BEAUTICIAN_CHANGE_HAND_TO_STORE, SendMsgParamVo.BEAUTICIAN_CHANGE_HAND_TO_STORE, beautician, affiliated);
        return responseMessage;
    }

    /**
     * 门店同意解除挂靠发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void agreeRemoveSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("id", beautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", affiliated.getStoreName());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage agreeRemoveV111(int affiliatedId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.APPLY_REMOVE_AFFILIATED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 挂靠更新 审核状态=1-审核通过
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        // 美容师更新 挂靠状态=5-待平台审核
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.PENDING_PLATFORM_AUDIT);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        // 发送消息
        this.agreeRemoveSendMsg(SystemPushCodeEnum.STORE_AGREE_CHANGE_HAND_TO_BEAUTICIAN, SendMsgParamVo.STORE_AGREE_CHANGE_HAND_TO_BEAUTICIAN, beautician, affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage refuseRemoveV111(int affiliatedId, String auditReason) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.APPLY_REMOVE_AFFILIATED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 挂靠更新 挂靠状态=2-审核不通过
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.NOT_PASS);
        affiliated.setAuditReason(auditReason);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        // 发送消息
        this.agreeRemoveSendMsg(SystemPushCodeEnum.STORE_NOTAGREE_CHANGE_HAND_TO_BEAUTICIAN, SendMsgParamVo.STORE_NOTAGREE_CHANGE_HAND_TO_BEAUTICIAN, beautician, affiliated);
        return responseMessage;
    }

    /**
     * 门店解除入驻发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void removeSettledSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("id", beautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", affiliated.getStoreName());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage removeSettledV111(int affiliatedId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 入驻
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.SETTLED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 解除入驻
        StoreBeauticianAffiliated removeAffiliated = affiliated;
        removeAffiliated.setId(null);
        removeAffiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.REMOVE);
        removeAffiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.STORE);
        removeAffiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        removeAffiliated.setAuditTime(new Date());
        removeAffiliated.setCreateTime(new Date());
        this.storeBeauticianAffiliatedMapper.insertSelective(removeAffiliated);
        // 美容师更新 挂靠状态=0-未入驻挂靠
        Map<String, Object> map = new HashMap<>(16);
        map.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        map.put("affiliatedStatus", StoreBeautician.AffiliatedStatus.PENGING);
        map.put("removeAffiliatedId", removeAffiliated.getId());
        map.put("beauticianId", beautician.getId());
        this.storeBeauticianMapper.removeAffiliated(map);
        // 项目-美容师-关联（门店项目权限移除）
        RemoveStoreByBeauticianIdVo beauticianIdVo = new RemoveStoreByBeauticianIdVo();
        beauticianIdVo.setStoreId(affiliated.getStoreId());
        beauticianIdVo.setBeauticianId(affiliated.getBeauticianId());
        ResponseMessage productBeauticianRefRes = this.productBeauticianRefFeign.removeStoreByBeauticianIdV111(beauticianIdVo);
        ResponseUtil.isFailThrowException(productBeauticianRefRes);
        // 发送消息
        this.agreeRemoveSendMsg(SystemPushCodeEnum.STORE_RELIEVE_ENTER_TO_BEAUTICIAN, SendMsgParamVo.STORE_RELIEVE_ENTER_TO_BEAUTICIAN, beautician, affiliated);
        return responseMessage;
    }

    /**
     * 门店解除挂靠发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param affiliated   挂靠
     */
    @Async
    public void removeAffiliatedSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, StoreBeauticianAffiliated affiliated) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        // 页面参数
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("id", beautician.getId());
        sendMsgParam.setParam(paramMap);
        // 消息参数
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("name", affiliated.getStoreName());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage removeAffiliatedV111(int affiliatedId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(affiliatedId);
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (StoreBeautician.AffiliatedStatus.AFFILIATED != beautician.getAffiliatedStatus()) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_STATUS_CHANGED, StoreConstant.Query.AFFILIATED_STATUS_CHANGED_MSG);
        }
        // 解除挂靠
        StoreBeauticianAffiliated removeAffiliated = affiliated;
        removeAffiliated.setId(null);
        removeAffiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.REMOVE);
        removeAffiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.STORE);
        removeAffiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        removeAffiliated.setAuditTime(new Date());
        removeAffiliated.setCreateTime(new Date());
        this.storeBeauticianAffiliatedMapper.insertSelective(removeAffiliated);
        // 美容师更新
        beautician.setRemoveAffiliatedId(removeAffiliated.getId());
        beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.APPLY_REMOVE_AFFILIATED);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        // 发送消息
        this.agreeRemoveSendMsg(SystemPushCodeEnum.STORE_RELIEVE_HAND_TO_BEAUTICIAN, SendMsgParamVo.STORE_RELIEVE_HAND_TO_BEAUTICIAN, beautician, affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> countByBeauticianIdForInvitationV111(int beauticianId) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("affiliatedType", StoreBeauticianAffiliated.AffiliatedType.APPLY);
        condMap.put("sponsor", StoreBeauticianAffiliated.Sponsor.STORE);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("auditStatus", StoreBeauticianAffiliated.AuditStatus.PENDING);
        condMap.put("beauticianId", beauticianId);
        int count = this.storeBeauticianAffiliatedMapper.countByBeauticianIdForInvitation(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> findByPageByBeauticianIdForInvitationV111(Integer pageNo, Integer pageSize, int beauticianId) {
        ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        StoreBeauticianAffiliated sbaCond = new StoreBeauticianAffiliated();
        sbaCond.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.APPLY);
        sbaCond.setSponsor(StoreBeauticianAffiliated.Sponsor.STORE);
        sbaCond.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PENDING);
        sbaCond.setBeauticianType(StoreBeautician.BeauticianType.PART_TIME);
        sbaCond.setBeauticianId(beauticianId);
        List<AffiliatedByBeauticianIdForInvitationResVo> list = this.storeBeauticianAffiliatedMapper.selectListByBeauticianIdForInvitation(sbaCond);
        PageInfo<AffiliatedByBeauticianIdForInvitationResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> countByStoreIdForApplyV111(int storeId) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("affiliatedType", StoreBeauticianAffiliated.AffiliatedType.APPLY);
        condMap.put("sponsor", StoreBeauticianAffiliated.Sponsor.BEAUTICIAN);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("auditStatus", StoreBeauticianAffiliated.AuditStatus.PENDING);
        condMap.put("storeId", storeId);
        int count = this.storeBeauticianAffiliatedMapper.countByStoreIdForApply(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listInvitationByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListInvitationByStoreIdVo invitationVo) {
        ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Integer affiliatedType = null;
        Integer sponsor = null;
        List<Integer> auditStatusList = new ArrayList<>(10);
        switch (invitationVo.getListType()) {
            case AffiliatedListInvitationByStoreIdVo.ListType.WAIT_CONFIRM:
                affiliatedType = StoreBeauticianAffiliated.AffiliatedType.APPLY;
                sponsor = StoreBeauticianAffiliated.Sponsor.STORE;
                auditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PENDING);
                break;
            case AffiliatedListInvitationByStoreIdVo.ListType.INVITATION_RESULT:
                affiliatedType = StoreBeauticianAffiliated.AffiliatedType.APPLY;
                sponsor = StoreBeauticianAffiliated.Sponsor.STORE;
                auditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PASS);
                auditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PLATFORM_PASS);
                break;
            case AffiliatedListInvitationByStoreIdVo.ListType.AFFILATED_APPLY:
                affiliatedType = StoreBeauticianAffiliated.AffiliatedType.APPLY;
                sponsor = StoreBeauticianAffiliated.Sponsor.BEAUTICIAN;
                auditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PENDING);
                break;
            case AffiliatedListInvitationByStoreIdVo.ListType.AFFILATED_REMOVE_APPLY:
                affiliatedType = StoreBeauticianAffiliated.AffiliatedType.REMOVE;
                sponsor = StoreBeauticianAffiliated.Sponsor.BEAUTICIAN;
                auditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PENDING);
                break;
            default:
                break;
        }
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeId", invitationVo.getStoreId());
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        condMap.put("affiliatedType", affiliatedType);
        condMap.put("sponsor", sponsor);
        condMap.put("auditStatusList", auditStatusList);
        List<AffiliatedByStoreIdResVo> list = this.storeBeauticianAffiliatedMapper.selectListByStoreId(condMap);
        PageInfo<AffiliatedByStoreIdResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listApplyByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListApplyByStoreIdVo applyVo) {
        ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(applyVo), Map.class);
        condMap.put("sponsor", StoreBeauticianAffiliated.Sponsor.BEAUTICIAN);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        List<Integer> auditStatusList = new ArrayList<>(10);
        auditStatusList.add(StoreBeauticianAffiliated.AuditStatus.PENDING);
        condMap.put("auditStatusList", auditStatusList);
        List<AffiliatedByStoreIdResVo> list = this.storeBeauticianAffiliatedMapper.selectListByStoreId(condMap);
        PageInfo<AffiliatedByStoreIdResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage auditV111(AffiliatedByAuditVo auditVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeauticianAffiliated affiliated = new StoreBeauticianAffiliated();
        affiliated.setId(auditVo.getAffiliatedId());
        affiliated.setAuditStatus(auditVo.getAuditStatus());
        affiliated.setAuditReason(auditVo.getAuditReason());
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        return responseMessage;
    }

}