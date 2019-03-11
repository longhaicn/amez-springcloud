package com.union.aimei.common.feign.app.umeng.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.umeng.BaseMemberDeviceFeign;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "app-BaseMemberDeviceFeign")
public class BaseMemberDeviceApiHystrix implements BaseMemberDeviceFeign {

       /**
        * 前端分页查询会员设备码表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseMemberDevice 查询条件
        * @return 
        */
       @Override
       public PageInfo<BaseMemberDevice> findByPageForFront(Integer pageNo, Integer pageSize, BaseMemberDevice baseMemberDevice) {
              return null;
       }

       @Override
       public ResponseMessage queryByInfo(BaseMemberDevice baseMemberDevice) {
              return null;
       }

       /**
        * 添加会员设备码表
        * @param baseMemberDevice
        * @return
        */
       @Override
       public int insert(BaseMemberDevice baseMemberDevice) {
              return 0;
       }

       /**
        * 删除会员设备码表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员设备码表
        * @param baseMemberDevice
        * @return
        */
       @Override
       public int edit(BaseMemberDevice baseMemberDevice) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbaseMemberDevice
        */
       @Override
       public BaseMemberDevice queryById(int id) {
              return null;
       }
}