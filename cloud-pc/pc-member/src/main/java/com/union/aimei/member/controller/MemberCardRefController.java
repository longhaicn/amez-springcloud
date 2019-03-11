package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.member.service.MemberCardRefService;
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
@Api(tags="用户会员卡表")
@RestController
@RequestMapping(value="memberCardRef")
public class MemberCardRefController {
       @Resource
       private MemberCardRefService memberCardRefService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberCardRef> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardRef memberCardRef) {
              return this.memberCardRefService.findByPageForFront(pageNo,pageSize,memberCardRef);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberCardRef memberCardRef) {
              return this.memberCardRefService.addObj(memberCardRef);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberCardRefService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberCardRef memberCardRef) {
              return this.memberCardRefService.modifyObj(memberCardRef);
       }

       @GetMapping("/queryById/{id}")
       public MemberCardRef queryById(@PathVariable (value="id") int id) {
              return this.memberCardRefService.queryObjById(id);
       }

    /**
     * 设置会员卡失效
     */
    @GetMapping(value = "/setMemberCardUnEffective")
    public void setMemberCardUnEffective(){
        this.memberCardRefService.setMemberCardUnEffective();
    }
}