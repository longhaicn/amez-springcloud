package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.member.service.MemberRealNameAuthService;
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
@Api(tags="会员卡实名认证表")
@RestController
@RequestMapping(value="memberRealNameAuth")
public class MemberRealNameAuthController {
       @Resource
       private MemberRealNameAuthService memberRealNameAuthService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberRealNameAuth> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.findByPageForFront(pageNo,pageSize,memberRealNameAuth);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.addObj(memberRealNameAuth);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberRealNameAuthService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.modifyObj(memberRealNameAuth);
       }

       @GetMapping("/queryById/{id}")
       public MemberRealNameAuth queryById(@PathVariable (value="id") int id) {
              return this.memberRealNameAuthService.queryObjById(id);
       }
}