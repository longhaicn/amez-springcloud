package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberAddress;
import com.union.aimei.member.service.MemberAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员地址")
@RestController
@RequestMapping(value="memberAddress")
public class MemberAddressController {
       @Resource
       private MemberAddressService memberAddressService;

       @ApiOperation(httpMethod="POST", value="前端分页查询会员地址")
       @PostMapping("/front/findByPage")
       public PageInfo<MemberAddress> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberAddress memberAddress) {
              return this.memberAddressService.findByPageForFront(pageNo,pageSize,memberAddress);
       }

       @ApiOperation(httpMethod="POST", value="添加会员地址")
       @PostMapping("/insert")
       public int insert(@RequestBody MemberAddress memberAddress) {
              return this.memberAddressService.addObj(memberAddress);
       }

       @ApiOperation(httpMethod="DELETE", value="删除会员地址")
       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable int id) {
              return this.memberAddressService.deleteObjById(id);
       }

       @ApiOperation(httpMethod="PUT", value="编辑会员地址")
       @PutMapping("/edit")
       public int edit(@RequestBody MemberAddress memberAddress) {
              return this.memberAddressService.modifyObj(memberAddress);
       }

       @ApiOperation(httpMethod="GET", value="通过ID查询会员地址")
       @GetMapping("/queryById/{id}")
       public MemberAddress queryById(@PathVariable int id) {
              return this.memberAddressService.queryObjById(id);
       }


       /**
        * 设置默认地址值
        * @return
        */
       @PutMapping("/setDefalutAddress")
       public int setDefaultAddress(@RequestBody MemberAddress memberAddress){
              return memberAddressService.setDefalutAddress(memberAddress);
       }
}