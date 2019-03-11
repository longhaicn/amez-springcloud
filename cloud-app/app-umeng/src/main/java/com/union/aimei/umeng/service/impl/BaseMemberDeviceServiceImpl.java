package com.union.aimei.umeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.aimei.umeng.mapper.BaseMemberDeviceMapper;
import com.union.aimei.umeng.service.BaseMemberDeviceService;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("baseMemberDeviceService")
public class BaseMemberDeviceServiceImpl implements BaseMemberDeviceService {
       @Resource
       private BaseMemberDeviceMapper baseMemberDeviceMapper;

       /**
        * 前端分页查询会员设备码表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseMemberDevice 查询条件
        * @return 
        */
       @Override
       public PageInfo<BaseMemberDevice> findByPageForFront(Integer pageNo, Integer pageSize, BaseMemberDevice baseMemberDevice) {
              PageHelper.startPage(pageNo,pageSize);
              List<BaseMemberDevice> list = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
              PageInfo<BaseMemberDevice> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public String queryDeviceTokenByMemberId(Integer memberId) {
              return this.baseMemberDeviceMapper.queryDeviceTokenByMemberId(memberId);
       }

       /**
        * 根据设备参数查询设备信息
        * @param baseMemberDevice
        * @return
        */
       @Override
       public ResponseMessage queryByInfo(BaseMemberDevice baseMemberDevice) {
              ResponseMessage res = new ResponseMessage();
              List<BaseMemberDevice> bmdList = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
              if(!CollectionUtils.isEmpty(bmdList)){
                     baseMemberDevice = bmdList.get(0);
                     res.setData(baseMemberDevice);
                     return res;
              }else{
                     res.setCode(3001);
                     res.setMessage("查询数据为空");
                     return res;
              }
       }


       /**
        * 添加会员设备码表
        * @param t
        * @return
        */
       @Override
       public int addObj(BaseMemberDevice t) {
              int res = 0;
              if (t.getDeviceToken() != null) {
                     //根据会员id查询会员设备信息
                     BaseMemberDevice baseMem = new BaseMemberDevice();
                     baseMem.setMemberId(t.getMemberId());
                     List<BaseMemberDevice> listMem = this.baseMemberDeviceMapper.selectListByConditions(baseMem);
                     //如果不存在，则根据设备token查询数据
                     if (CollectionUtils.isEmpty(listMem)) {
                            BaseMemberDevice baseToken = new BaseMemberDevice();
                            baseToken.setDeviceToken(t.getDeviceToken());
                            List<BaseMemberDevice> listToken = this.baseMemberDeviceMapper.selectListByConditions(baseMem);
                            //如果设备数据也不存在，则添加会员设备信息
                            if (CollectionUtils.isEmpty(listToken)) {
                                   res = this.baseMemberDeviceMapper.insertSelective(t);
                            } else {
                                   //如果设备数据存在，则根据设备号和系统权限所属(用户，美容师，店长)进行查询
                                   BaseMemberDevice baseSys = new BaseMemberDevice();
                                   baseSys.setDeviceToken(t.getDeviceToken());
                                   baseSys.setDeviceSystem(t.getDeviceSystem());
                                   List<BaseMemberDevice> listSys = this.baseMemberDeviceMapper.selectListByConditions(baseSys);
                                   //如果为空，添加会员设备信息
                                   if (CollectionUtils.isEmpty(listSys)) {
                                          res = this.baseMemberDeviceMapper.insertSelective(t);
                                   }else{
                                          //如果存在，则让这个会员设备登录状态显示为下线
                                          BaseMemberDevice sysDevice = new BaseMemberDevice();
                                          sysDevice.setId(listSys.get(0).getId());
                                          sysDevice.setTokenOnline(0);
                                          this.baseMemberDeviceMapper.updateByPrimaryKeySelective(sysDevice);
                                          //添加会员设备，并且标注为上线
                                          res = this.baseMemberDeviceMapper.insertSelective(t);
                                   }
                            }
                     }else{
                            //如果会员设备存在，则更新会员设备并设置会员设备上线状态
                            t.setId(listMem.get(0).getId());
                            t.setUpdateTime(new Date());
                            t.setTokenOnline(1);
                            res = this.baseMemberDeviceMapper.updateByPrimaryKeySelective(t);
                     }
              }
              return res;
       }

       /**
        * 删除会员设备码表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.baseMemberDeviceMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员设备码表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(BaseMemberDevice t) {
              return this.baseMemberDeviceMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbaseMemberDevice
        */
       @Override
       public BaseMemberDevice queryObjById(int id) {
              BaseMemberDevice model=this.baseMemberDeviceMapper.selectByPrimaryKey(id);
              return model;
       }
}