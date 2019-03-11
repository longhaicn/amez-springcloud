package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.aimei.member.service.MemberCardUseRangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员卡使用范围")
@RestController
@RequestMapping(value="memberCardUseRange")
public class MemberCardUseRangeController {
       @Resource
       private MemberCardUseRangeService memberCardUseRangeService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberCardUseRange> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardUseRange memberCardUseRange) {
              return this.memberCardUseRangeService.findByPageForFront(pageNo,pageSize,memberCardUseRange);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberCardUseRange memberCardUseRange) {
              return this.memberCardUseRangeService.addObj(memberCardUseRange);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberCardUseRangeService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberCardUseRange memberCardUseRange) {
              return this.memberCardUseRangeService.modifyObj(memberCardUseRange);
       }

       @GetMapping("/queryById/{id}")
       public MemberCardUseRange queryById(@PathVariable (value="id") int id) {
              return this.memberCardUseRangeService.queryObjById(id);
       }
}