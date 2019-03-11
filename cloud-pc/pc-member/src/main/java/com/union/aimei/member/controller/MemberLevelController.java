package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevel;
import com.union.aimei.member.service.MemberLevelService;
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
@Api(tags="会员级别")
@RestController
@RequestMapping(value="memberLevel")
public class MemberLevelController {
       @Resource
       private MemberLevelService memberLevelService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberLevel> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberLevel memberLevel) {
              return this.memberLevelService.findByPageForFront(pageNo,pageSize,memberLevel);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberLevel memberLevel) {
              return this.memberLevelService.addObj(memberLevel);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberLevelService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberLevel memberLevel) {
              return this.memberLevelService.modifyObj(memberLevel);
       }

       @GetMapping("/queryById/{id}")
       public MemberLevel queryById(@PathVariable (value="id") int id) {
              return this.memberLevelService.queryObjById(id);
       }
}