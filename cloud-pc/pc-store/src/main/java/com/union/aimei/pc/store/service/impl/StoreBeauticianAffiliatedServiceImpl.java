package com.union.aimei.pc.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveVo;
import com.union.aimei.common.vo.store.pc.AffiliatedPlatformAuditVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.SystemPushCodeEnum;
import com.union.aimei.pc.store.mapper.StoreBeauticianAffiliatedMapper;
import com.union.aimei.pc.store.mapper.StoreBeauticianMapper;
import com.union.aimei.pc.store.mapper.StoreMapper;
import com.union.aimei.pc.store.service.StoreBeauticianAffiliatedService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private BasePushTemplateFeign basePushTemplateFeign;
    @Resource
    private StoreMapper storeMapper;

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianAffiliated affiliated) {
        ResponseMessage<PageInfo<StoreBeauticianAffiliated>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBeauticianAffiliated> list = this.storeBeauticianAffiliatedMapper.selectListByConditions(affiliated);
        PageInfo<StoreBeauticianAffiliated> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> add(StoreBeauticianAffiliated affiliated) {
        ResponseMessage<StoreBeauticianAffiliated> responseMessage = new ResponseMessage<>();
        this.storeBeauticianAffiliatedMapper.insertSelective(affiliated);
        responseMessage.setData(affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(StoreBeauticianAffiliated affiliated) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> findById(int id) {
        ResponseMessage<StoreBeauticianAffiliated> responseMessage = new ResponseMessage<>();
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(id);
        if (null == affiliated) {
            responseMessage.setCode(StoreConstant.Query.AFFILIATED_NULL);
            responseMessage.setMessage(StoreConstant.Query.AFFILIATED_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(affiliated);
        return responseMessage;
    }

    /**
     * 申请同意发送消息
     *
     * @param pushCodeEnum 推送代码
     * @param type         消息类型
     * @param beautician   美容师
     * @param store        门店
     */
    @Async
    public void platformAuditSendMsg(SystemPushCodeEnum pushCodeEnum, int type, StoreBeautician beautician, Store store) {
        List<SendMsgParamVo> sendMsgParamList = new ArrayList<>(10);
        SendMsgParamVo sendMsgParam = new SendMsgParamVo();
        sendMsgParam.setTemplateCode(pushCodeEnum.getValue());
        sendMsgParam.setMemberId(beautician.getMemberId());
        sendMsgParam.setBeauticianName(beautician.getBeauticianNickName());
        Map<String, Object> customMap = new HashMap<>(16);
        customMap.put("templateCode", pushCodeEnum.getValue());
        customMap.put("type", type);
        customMap.put("id", beautician.getId());
        customMap.put("name", store.getStoreName());
        sendMsgParam.setCustoms(customMap);
        sendMsgParamList.add(sendMsgParam);
        this.basePushTemplateFeign.sendMessage(sendMsgParamList);
    }

    @Override
    public ResponseMessage platformAudit(AffiliatedPlatformAuditVo platformAuditVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 挂靠
        StoreBeauticianAffiliated affiliated = this.storeBeauticianAffiliatedMapper.selectByPrimaryKey(platformAuditVo.getAffiliatedId());
        if (null == affiliated) {
            throw new ResponseException(StoreConstant.Query.AFFILIATED_NULL, StoreConstant.Query.AFFILIATED_NULL_MSG);
        }
        // 类型=移除
        if (StoreBeauticianAffiliated.AffiliatedType.REMOVE != affiliated.getAffiliatedType()) {
            responseMessage.setCode(StoreConstant.Query.AFFILIATED_TYPE_ERROR);
            responseMessage.setMessage(StoreConstant.Query.AFFILIATED_TYPE_ERROR_MSG);
            return responseMessage;
        }
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(affiliated.getBeauticianId());
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(affiliated.getStoreId());
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        if (platformAuditVo.getAuditStatus()) {
            //更新之前挂靠关联数据
            StoreBeauticianAffiliated beforeAffiliated = new StoreBeauticianAffiliated();
            beforeAffiliated.setId(beautician.getAffiliatedId());
            beforeAffiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.NOT_PASS);
            this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(beforeAffiliated);
            // 美容师更新
            affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PLATFORM_PASS);
            Map<String, Object> removeMap = new HashMap<>(16);
            removeMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
            removeMap.put("affiliatedStatus", StoreBeautician.AffiliatedStatus.PENGING);
            removeMap.put("beauticianId", beautician.getId());
            this.storeBeauticianMapper.removeAffiliated(removeMap);
            // 发送消息
            this.platformAuditSendMsg(SystemPushCodeEnum.PLATFORM_AGREE_REMOVE_TO_BEAUTICIAN, SendMsgParamVo.PLATFORM_AGREE_REMOVE_TO_BEAUTICIAN, beautician, store);
        } else {
            affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PLATFORM_NOT_PASS);
            affiliated.setAuditReason(platformAuditVo.getAuditReason());
            beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.AFFILIATED);
            this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
            // 发送消息
            this.platformAuditSendMsg(SystemPushCodeEnum.PLATFORM_NOAGREE_REMOVE_TO_BEAUTICIAN, SendMsgParamVo.PLATFORM_NOAGREE_REMOVE_TO_BEAUTICIAN, beautician, store);
        }
        //更新单前挂靠关联数据
        this.storeBeauticianAffiliatedMapper.updateByPrimaryKeySelective(affiliated);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedListRemoveResVo>> listRemove(Integer pageNo, Integer pageSize, AffiliatedListRemoveVo removeVo) {
        ResponseMessage<PageInfo<AffiliatedListRemoveResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(removeVo), Map.class);
        condMap.put("affiliatedType", StoreBeauticianAffiliated.AffiliatedType.REMOVE);
        condMap.put("beauticianType", StoreBeautician.BeauticianType.PART_TIME);
        List<AffiliatedListRemoveResVo> list = this.storeBeauticianAffiliatedMapper.listRemove(condMap);
        PageInfo<AffiliatedListRemoveResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

}