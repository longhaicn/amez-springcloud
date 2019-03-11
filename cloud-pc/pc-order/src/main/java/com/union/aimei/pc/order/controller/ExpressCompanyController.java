package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.aimei.pc.order.service.ExpressCompanyService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
@Api(tags="快递公司信息表")
@RestController
@RequestMapping(value="expressCompany")
public class ExpressCompanyController {
       @Resource
       private ExpressCompanyService expressCompanyService;

       @PostMapping("/front/findByPage")
       public ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(
               @RequestParam(value = "pageNo",defaultValue="0") Integer pageNo,
               @RequestParam(value = "pageSize",defaultValue="10") Integer pageSize,
               @RequestBody ExpressCompany expressCompany) {
              return this.expressCompanyService.findByPageForFront(pageNo,pageSize,expressCompany);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody ExpressCompany expressCompany) {
              return this.expressCompanyService.addObj(expressCompany);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.expressCompanyService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody ExpressCompany expressCompany) {
              return this.expressCompanyService.modifyObj(expressCompany);
       }

       @GetMapping("/queryById/{id}")
       public ExpressCompany queryById(@PathVariable (value="id") int id) {
              return this.expressCompanyService.queryObjById(id);
       }
}