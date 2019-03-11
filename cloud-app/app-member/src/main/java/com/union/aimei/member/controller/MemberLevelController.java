package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevel;
import com.union.aimei.member.service.MemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员级别")
@RestController
@RequestMapping(value="memberLevel")
public class MemberLevelController {
       @Resource
       private MemberLevelService memberLevelService;

       @ApiOperation(httpMethod="POST", value="前端分页查询会员级别")
       @PostMapping("/front/findByPage")
       public PageInfo<MemberLevel> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberLevel memberLevel) {
              return this.memberLevelService.findByPageForFront(pageNo,pageSize,memberLevel);
       }

       @ApiOperation(httpMethod="POST", value="添加会员级别")
       @PostMapping("/insert")
       public int insert(@RequestBody MemberLevel memberLevel) {
              return this.memberLevelService.addObj(memberLevel);
       }

       @ApiOperation(httpMethod="DELETE", value="删除会员级别")
       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable int id) {
              return this.memberLevelService.deleteObjById(id);
       }

       @ApiOperation(httpMethod="POST", value="编辑会员级别")
       @PutMapping("/edit")
       public int edit(@RequestBody MemberLevel memberLevel) {
              return this.memberLevelService.modifyObj(memberLevel);
       }

       @ApiOperation(httpMethod="GET", value="通过ID查询会员级别")
       @GetMapping("/queryById/{id}")
       public MemberLevel queryById(@PathVariable int id) {
              return this.memberLevelService.queryObjById(id);
       }
}