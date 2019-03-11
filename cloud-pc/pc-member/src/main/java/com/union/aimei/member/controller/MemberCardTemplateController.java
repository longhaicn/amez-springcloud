package com.union.aimei.member.controller;

import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.aimei.member.service.MemberCardTemplateService;
import com.union.aimei.common.vo.member.MemberCardTemplateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员卡卡面模板表")
@RestController
@RequestMapping(value="memberCardTemplate")
public class MemberCardTemplateController {
       @Resource
       private MemberCardTemplateService memberCardTemplateService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberCardTemplate> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardTemplate memberCardTemplate) {
              return this.memberCardTemplateService.findByPageForFront(pageNo,pageSize,memberCardTemplate);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberCardTemplate memberCardTemplate) {
              return this.memberCardTemplateService.addObj(memberCardTemplate);
       }

       @PostMapping("/insertByBatch")
       public void insertByBatch(@RequestBody MemberCardTemplateVo memberCardTemplateVo) {
              this.memberCardTemplateService.insertByBatch(memberCardTemplateVo);
       }


       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberCardTemplateService.deleteObjById(id);
       }
       @DeleteMapping("/deleteByGroupId/{id}")
       public int deleteByGroupId(@PathVariable (value="id") int id) {
              return this.memberCardTemplateService.deleteByGroupId(id);
       }


       @PutMapping("/edit")
       public int edit(@RequestBody MemberCardTemplate memberCardTemplate) {
              return this.memberCardTemplateService.modifyObj(memberCardTemplate);
       }

       @GetMapping("/queryById/{id}")
       public MemberCardTemplate queryById(@PathVariable (value="id") int id) {
              return this.memberCardTemplateService.queryObjById(id);
       }
}