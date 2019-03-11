package com.union.aimei.app.api.order.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.aimei.app.api.order.mapper.ExpressCompanyMapper;
import com.union.aimei.app.api.order.service.ExpressCompanyService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:48
  * @description
  */
@Service("expressCompanyService")
public class ExpressCompanyServiceImpl implements ExpressCompanyService {
       @Resource
       private ExpressCompanyMapper expressCompanyMapper;

       /**
        * 前端分页查询快递公司信息表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param expressCompany 查询条件
        * @return 
        */
       @Override
       public ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(Integer pageNo, Integer pageSize, ExpressCompany expressCompany) {
              PageHelper.startPage(pageNo,pageSize);
              List<ExpressCompany> list = this.expressCompanyMapper.selectListByConditions(expressCompany);
              PageInfo<ExpressCompany> page = new PageInfo<>(list);
              ResponseMessage<PageInfo<ExpressCompany>> res=new ResponseMessage<>();
              res.setData(page);
              return res;
       }

       /**
        * 添加快递公司信息表
        * @param
        * @return
        */
       @Override
       public int addObj(ExpressCompany t) {
              return this.expressCompanyMapper.insertSelective(t);
       }

       /**
        * 删除快递公司信息表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.expressCompanyMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改快递公司信息表
        * @param
        * @return
        */
       @Override
       public int modifyObj(ExpressCompany t) {
              return this.expressCompanyMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnexpressCompany
        */
       @Override
       public ExpressCompany queryObjById(int id) {
              ExpressCompany model=this.expressCompanyMapper.selectByPrimaryKey(id);
              return model;
       }
}