package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberBankCard;
import com.union.aimei.member.service.MemberBankCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员银行卡表")
@RestController
@RequestMapping(value="memberBankCard")
public class MemberBankCardController {
       @Resource
       private MemberBankCardService memberBankCardService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberBankCard> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberBankCard memberBankCard) {
              return this.memberBankCardService.findByPageForFront(pageNo,pageSize,memberBankCard);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberBankCard memberBankCard) {
              return this.memberBankCardService.addObj(memberBankCard);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberBankCardService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberBankCard memberBankCard) {
              return this.memberBankCardService.modifyObj(memberBankCard);
       }

       @GetMapping("/queryById/{id}")
       public MemberBankCard queryById(@PathVariable (value="id") int id) {
              return this.memberBankCardService.queryObjById(id);
       }
}