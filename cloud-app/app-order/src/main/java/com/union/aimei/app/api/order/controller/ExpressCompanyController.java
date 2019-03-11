package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.aimei.app.api.order.service.ExpressCompanyService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午12:14
  * @description
  */
@Api(tags="快递公司信息表")
@RestController
@RequestMapping(value="expressCompany")
public class ExpressCompanyController {
       @Resource
       private ExpressCompanyService expressCompanyService;

       @PostMapping("/front/findByPage")
       public ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody ExpressCompany expressCompany) {
              return this.expressCompanyService.findByPageForFront(pageNo,pageSize,expressCompany);
       }

       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody ExpressCompany expressCompany) {
              ResponseMessage res=ResponseMessageFactory.newInstance();
              res.setData(this.expressCompanyService.addObj(expressCompany));
              return res;
       }

       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage res=ResponseMessageFactory.newInstance();
              res.setData(this.expressCompanyService.deleteObjById(id));
              return res;
       }

       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody ExpressCompany expressCompany) {
           ResponseMessage res=ResponseMessageFactory.newInstance();
           res.setData(this.expressCompanyService.modifyObj(expressCompany));
           return res;
       }

       @GetMapping("/queryById/{id}")
       public ResponseMessage<ExpressCompany> queryById(@PathVariable (value="id") int id) {
               ResponseMessage res=ResponseMessageFactory.newInstance();
               res.setData(this.expressCompanyService.queryObjById(id));
              return res;
       }
}