package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.member.service.MemberCardTradeRecodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,14:42
*/
@Api(tags="会员卡交易记录")
@RestController
@RequestMapping(value="memberCardTradeRecode")
public class MemberCardTradeRecodeController {
       @Resource
       private MemberCardTradeRecodeService memberCardTradeRecodeService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberCardTradeRecode> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              return this.memberCardTradeRecodeService.findByPageForFront(pageNo,pageSize,memberCardTradeRecode);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              return this.memberCardTradeRecodeService.addObj(memberCardTradeRecode);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberCardTradeRecodeService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              return this.memberCardTradeRecodeService.modifyObj(memberCardTradeRecode);
       }

       @GetMapping("/queryById/{id}")
       public MemberCardTradeRecode queryById(@PathVariable (value="id") int id) {
              return this.memberCardTradeRecodeService.queryObjById(id);
       }

       @GetMapping(value = "getByOrderNo")
       public MemberCardTradeRecode queryByOrderNo(@RequestParam(value = "orderNo") String orderNo){
              return memberCardTradeRecodeService.queryByOrderNo(orderNo);
       }
}