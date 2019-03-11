package com.union.aimei.app.api.order.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:47
  * @description
  */
public interface ExpressCompanyService extends SpringCloudBaseService<ExpressCompany> {
       /**
        * 前端分页查询快递公司信息表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param expressCompany 查询条件
        * @return 
        */
       ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(Integer pageNo, Integer pageSize, ExpressCompany expressCompany);
}