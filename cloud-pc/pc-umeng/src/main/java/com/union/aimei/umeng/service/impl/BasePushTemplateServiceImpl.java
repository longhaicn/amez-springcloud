package com.union.aimei.umeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.aimei.common.util.umeng.PushClient;
import com.union.aimei.common.util.umeng.UmengPushMsg;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.umeng.config.*;
import com.union.aimei.umeng.mapper.BaseMemberDeviceMapper;
import com.union.aimei.umeng.mapper.BasePushTemplateMapper;
import com.union.aimei.umeng.mapper.BaseUmengPushHistoryMapper;
import com.union.aimei.umeng.service.BasePushTemplateService;

import java.util.List;
import javax.annotation.Resource;

import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("basePushTemplateService")
public class BasePushTemplateServiceImpl implements BasePushTemplateService {

    @Value(value="${push.umeng.profiles}")
    private String profiles;

       @Resource
       private BasePushTemplateMapper basePushTemplateMapper;
        @Resource
        private BaseMemberDeviceMapper baseMemberDeviceMapper;
        @Resource
        private BaseUmengPushHistoryMapper baseUmengPushHistoryMapper;
        @Autowired
        private ConsumerAndroidProperties consumerAndroidProperties;
        @Autowired
        private BeauticianAndroidProperties beauticianAndroidProperties;
        @Autowired
        private ManagerAndroidProperties managerAndroidProperties;

        @Autowired
        private ConsumerIosProperties consumerIosProperties;
        @Autowired
        private BeauticianIosProperties beauticianIosProperties;
        @Autowired
        private ManagerIosProperties managerIosProperties;




    private PushClient client = new PushClient();

       /**
        * 前端分页查询友盟推送消息模板(新)
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param basePushTemplate 查询条件
        * @return 
        */
       @Override
       public PageInfo<BasePushTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BasePushTemplate basePushTemplate) {
              PageHelper.startPage(pageNo,pageSize);
              List<BasePushTemplate> list = this.basePushTemplateMapper.selectListByConditions(basePushTemplate);
              PageInfo<BasePushTemplate> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加友盟推送消息模板(新)
        * @param t
        * @return
        */
       @Override
       public int addObj(BasePushTemplate t) {
              return this.basePushTemplateMapper.insertSelective(t);
       }

       /**
        * 删除友盟推送消息模板(新)
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.basePushTemplateMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改友盟推送消息模板(新)
        * @param t
        * @return
        */
       @Override
       public int modifyObj(BasePushTemplate t) {
              return this.basePushTemplateMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbasePushTemplate
        */
       @Override
       public BasePushTemplate queryObjById(int id) {
              BasePushTemplate model=this.basePushTemplateMapper.selectByPrimaryKey(id);
              return model;
       }

    @Override
    public ResponseMessage sendMessage(List<SendMsgParamVo> sendMsgParamVoList) {
        ResponseMessage res = new ResponseMessage();
        for(int i = 0;i<sendMsgParamVoList.size();i++){
            SendMsgParamVo sendMsgParamVo = sendMsgParamVoList.get(i);
            BasePushTemplate basePushTemplate = this.caseParam(sendMsgParamVo);
            if(basePushTemplate == null){
                res.setCode(30001);
                res.setMessage("请检查参数的完整性");
                break;
            }else{
                //第一步：
                BaseMemberDevice baseMemberDevice = new BaseMemberDevice();
                baseMemberDevice.setDeviceSystem(basePushTemplate.getPushObject());
                baseMemberDevice.setTokenOnline(1);
                baseMemberDevice.setMemberId(basePushTemplate.getMemberId());
                //根据会员id + 会员所属权限 + 会员上线查询会员设备Token
                List<BaseMemberDevice> bmdList  = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
                if(!CollectionUtils.isEmpty(bmdList)){
                    baseMemberDevice = bmdList.get(0);
                    UmengPushMsg umengPushMsg = new UmengPushMsg();
                    String appKey =  null;
                    String appMasterSecret =  null;
                    if(basePushTemplate.getPushObject().equals(BasePushTemplate.PushObject.OWNER)){
                        if(baseMemberDevice.getDeviceToken().length() ==44){
                            appKey = managerAndroidProperties.getAppKey();
                            appMasterSecret =  managerAndroidProperties.getAppMasterSecret();
                        }else if(baseMemberDevice.getDeviceToken().length() ==64){
                            appKey = managerIosProperties.getAppKey();
                            appMasterSecret =  managerIosProperties.getAppMasterSecret();
                        }
                    }else if(basePushTemplate.getPushObject().equals(BasePushTemplate.PushObject.BEAUTICIAN)){
                        if(baseMemberDevice.getDeviceToken().length() ==44){
                            appKey =  beauticianAndroidProperties.getAppKey();
                            appMasterSecret = beauticianAndroidProperties.getAppMasterSecret();
                        }else if(baseMemberDevice.getDeviceToken().length() ==64){
                            appKey = beauticianIosProperties.getAppKey();
                            appMasterSecret =  beauticianIosProperties.getAppMasterSecret();
                        }
                    }else if(basePushTemplate.getPushObject().equals(BasePushTemplate.PushObject.USER)){
                        if(baseMemberDevice.getDeviceToken().length() ==44){
                            appKey =  consumerAndroidProperties.getAppKey();
                            appMasterSecret =  consumerAndroidProperties.getAppMasterSecret();
                        }else if(baseMemberDevice.getDeviceToken().length() ==64){
                            appKey = consumerIosProperties.getAppKey();
                            appMasterSecret =  consumerIosProperties.getAppMasterSecret();
                        }
                    }
                    BaseUmengPushHistory baseUmengPushHistory =  umengPushMsg.pushMsg(basePushTemplate,appKey,appMasterSecret,profiles,baseMemberDevice);
                    if(baseUmengPushHistory != null){
                        this.baseUmengPushHistoryMapper.insertSelective(baseUmengPushHistory);
                    }
                }else{

                }
            }
        }
        return res;
    }

    @Override
    public ResponseMessage testNotificat(Integer role,String token,Integer deviceType) {
           //role推送消息者(0--用户 1--美容师 2--店长)
            //deviceType 设备类型：0--android 1-ios
           ResponseMessage res = new ResponseMessage();
        return  res;

    }



    public BasePushTemplate caseParam(SendMsgParamVo sendMsgParamVo){
        //查出模板数据
        BasePushTemplate basePushTemplate = new BasePushTemplate();
        basePushTemplate.setTemplateCode(sendMsgParamVo.getTemplateCode());
        List<BasePushTemplate> list = this.basePushTemplateMapper.selectListByConditions(basePushTemplate);
        basePushTemplate = list.get(0);
        UmengPushMsg umengPushMsg =  new UmengPushMsg();
        return umengPushMsg.caseParam(sendMsgParamVo,basePushTemplate);
    }
}