package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevelUpgrade;
import com.union.aimei.member.service.MemberLevelUpgradeService;
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
@Api(tags="会员成长值规则设置")
@RestController
@RequestMapping(value="memberLevelUpgrade")
public class MemberLevelUpgradeController {
       @Resource
       private MemberLevelUpgradeService memberLevelUpgradeService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberLevelUpgrade> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberLevelUpgrade memberLevelUpgrade) {
              return this.memberLevelUpgradeService.findByPageForFront(pageNo,pageSize,memberLevelUpgrade);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberLevelUpgrade memberLevelUpgrade) {
              return this.memberLevelUpgradeService.addObj(memberLevelUpgrade);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberLevelUpgradeService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberLevelUpgrade memberLevelUpgrade) {
              return this.memberLevelUpgradeService.modifyObj(memberLevelUpgrade);
       }

       @GetMapping("/queryById/{id}")
       public MemberLevelUpgrade queryById(@PathVariable (value="id") int id) {
              return this.memberLevelUpgradeService.queryObjById(id);
       }
}