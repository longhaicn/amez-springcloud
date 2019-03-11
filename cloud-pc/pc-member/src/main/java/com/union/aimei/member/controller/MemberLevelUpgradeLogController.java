package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevelUpgradeLog;
import com.union.aimei.member.service.MemberLevelUpgradeLogService;
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
@Api(tags="会员成长值记录")
@RestController
@RequestMapping(value="memberLevelUpgradeLog")
public class MemberLevelUpgradeLogController {
       @Resource
       private MemberLevelUpgradeLogService memberLevelUpgradeLogService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberLevelUpgradeLog> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog) {
              return this.memberLevelUpgradeLogService.findByPageForFront(pageNo,pageSize,memberLevelUpgradeLog);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog) {
              return this.memberLevelUpgradeLogService.addObj(memberLevelUpgradeLog);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberLevelUpgradeLogService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog) {
              return this.memberLevelUpgradeLogService.modifyObj(memberLevelUpgradeLog);
       }

       @GetMapping("/queryById/{id}")
       public MemberLevelUpgradeLog queryById(@PathVariable (value="id") int id) {
              return this.memberLevelUpgradeLogService.queryObjById(id);
       }
}