package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.member.service.MemberCardUseProductService;
import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员卡适用服务表")
@RestController
@RequestMapping(value="memberCardUseProduct")
public class MemberCardUseProductController {
       @Resource
       private MemberCardUseProductService memberCardUseProductService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberCardUseProduct> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardUseProduct memberCardUseProduct) {
              return this.memberCardUseProductService.findByPageForFront(pageNo,pageSize,memberCardUseProduct);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberCardUseProduct memberCardUseProduct) {
              return this.memberCardUseProductService.addObj(memberCardUseProduct);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberCardUseProductService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberCardUseProduct memberCardUseProduct) {
              return this.memberCardUseProductService.modifyObj(memberCardUseProduct);
       }

       @GetMapping("/queryById/{id}")
       public MemberCardUseProduct queryById(@PathVariable (value="id") int id) {
              return this.memberCardUseProductService.queryObjById(id);
       }

       /**
        * 当品牌发布得商品在品牌所属门店上架，添加会员卡支付
        */
       @PostMapping("/insertMemberCardByProductId")
       public ResponseMessage insertMemberCardByProductId(@RequestBody NewProductGroundVo newProductGroundVo) {
              return this.memberCardUseProductService.insertMemberCardByProductId(newProductGroundVo);
       }
}