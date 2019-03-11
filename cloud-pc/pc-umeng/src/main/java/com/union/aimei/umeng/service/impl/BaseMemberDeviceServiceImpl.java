package com.union.aimei.umeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.aimei.umeng.mapper.BaseMemberDeviceMapper;
import com.union.aimei.umeng.service.BaseMemberDeviceService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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

       /**
        * 根据memberId来查询数据
        * @param memberId
        * @return
        */
       @Override
       public BaseMemberDevice queryByMemberId(Integer memberId) {
              return this.baseMemberDeviceMapper.queryByMemberId(memberId);
       }

       @Override
       public String queryDeviceTokenByMemberId(Integer memberId) {
              return this.baseMemberDeviceMapper.queryDeviceTokenByMemberId(memberId);
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
                     BaseMemberDevice baseMemberDevice = new BaseMemberDevice();
                     baseMemberDevice.setMemberId(t.getMemberId());
                     List<BaseMemberDevice> list = this.baseMemberDeviceMapper.selectListByConditions(baseMemberDevice);
                     if (CollectionUtils.isEmpty(list)) {
                            res = this.baseMemberDeviceMapper.insertSelective(t);
                     } else {
                            t.setId(list.get(0).getId());
                            t.setUpdateTime(new Date());
                            res = this.baseMemberDeviceMapper.updateByPrimaryKeySelective(t);
                     }
              }
              return  res;
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
}