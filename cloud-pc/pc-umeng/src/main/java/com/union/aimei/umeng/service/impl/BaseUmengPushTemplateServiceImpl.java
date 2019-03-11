package com.union.aimei.umeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.aimei.umeng.mapper.BaseMemberDeviceMapper;
import com.union.aimei.umeng.mapper.BaseUmengPushTemplateMapper;
import com.union.aimei.umeng.service.BaseMemberDeviceService;
import com.union.aimei.umeng.service.BaseUmengPushTemplateService;
import com.union.aimei.umeng.service.PushAndroidService;
import com.union.aimei.umeng.service.PushIosService;
import com.union.common.utils.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("baseUmengPushTemplateService")
public class BaseUmengPushTemplateServiceImpl implements BaseUmengPushTemplateService {
       @Resource
       private BaseUmengPushTemplateMapper baseUmengPushTemplateMapper;

       @Resource
       private BaseMemberDeviceMapper baseMemberDeviceMapper;

       @Resource
       private PushIosService pushIosService;

       @Resource
       private PushAndroidService pushAndroidService;

       @Resource
       private BaseMemberDeviceService baseMemberDeviceService;


       /**
        * 前端分页查询U盟第三方推送记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseUmengPushTemplate 查询条件
        * @return 
        */
       @Override
       public PageInfo<BaseUmengPushTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BaseUmengPushTemplate baseUmengPushTemplate) {
              PageHelper.startPage(pageNo,pageSize);
              List<BaseUmengPushTemplate> list = this.baseUmengPushTemplateMapper.selectListByConditions(baseUmengPushTemplate);
              PageInfo<BaseUmengPushTemplate> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public void sendMessage(BaseUmengPushTemplate baseUmengPushTemplate) {
              BaseMemberDevice baseMemberDevice = new BaseMemberDevice();
              baseMemberDevice.setMemberId(baseUmengPushTemplate.getMemberId());
              baseMemberDevice.setTokenOnline(1);
              List<BaseMemberDevice> list = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
              this.push(list,baseUmengPushTemplate);
       }

       @Override
       public void sendMessageBatch(BaseUmengPushTemplate baseUmengPushTemplate) {
              List<Integer> memberList = baseUmengPushTemplate.getMemberIdList();
              if (CollectionUtils.isEmpty(memberList)) {
                     for (Integer memberId : memberList) {
                            BaseMemberDevice baseMemberDevice = new BaseMemberDevice();
                            baseMemberDevice.setMemberId(baseUmengPushTemplate.getMemberId());
                            baseMemberDevice.setTokenOnline(1);
                            baseUmengPushTemplate.setMemberId(memberId);
                            List<BaseMemberDevice> list = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
                            this.push(list,baseUmengPushTemplate);
                     }
              }
       }

       @Override
       public void sendMessageDiffBatch(List<BaseUmengPushTemplate> listTemplate) {
              if(!CollectionUtils.isEmpty(listTemplate)){
                     for (BaseUmengPushTemplate baseUmengPushTemplate : listTemplate){
                            BaseMemberDevice baseMemberDevice = new BaseMemberDevice();
                            baseMemberDevice.setMemberId(baseUmengPushTemplate.getMemberId());
                            baseMemberDevice.setTokenOnline(1);
                            List<BaseMemberDevice> list = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
                            this.push(list,baseUmengPushTemplate);
                     }
              }
       }

       public void push(List<BaseMemberDevice> list,BaseUmengPushTemplate baseUmengPushTemplate){

       }

       @Override
       public void testIOSBeautician(BaseUmengPushTemplate baseUmengPushTemplate) {
              this.pushIosService.testIOSBeautician(baseUmengPushTemplate);
       }


       /**
        * 添加U盟第三方推送记录表
        * @param t
        * @return
        */
       @Override
       public int addObj(BaseUmengPushTemplate t) {
              return this.baseUmengPushTemplateMapper.insertSelective(t);
       }

       /**
        * 删除U盟第三方推送记录表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.baseUmengPushTemplateMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改U盟第三方推送记录表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(BaseUmengPushTemplate t) {
              return this.baseUmengPushTemplateMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbaseUmengPushTemplate
        */
       @Override
       public BaseUmengPushTemplate queryObjById(int id) {
              BaseUmengPushTemplate model=this.baseUmengPushTemplateMapper.selectByPrimaryKey(id);
              return model;
       }
}