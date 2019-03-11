package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberAddress;
import com.union.aimei.member.service.MemberAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

       @PostMapping("/front/findByPage")
       public PageInfo<MemberAddress> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberAddress memberAddress) {
              return this.memberAddressService.findByPageForFront(pageNo,pageSize,memberAddress);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberAddress memberAddress) {
              return this.memberAddressService.addObj(memberAddress);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberAddressService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberAddress memberAddress) {
              return this.memberAddressService.modifyObj(memberAddress);
       }

       @GetMapping("/queryById/{id}")
       public MemberAddress queryById(@PathVariable (value="id") int id) {
              return this.memberAddressService.queryObjById(id);
       }
}