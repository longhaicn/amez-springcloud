package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.member.service.MemberCardTradeRecodeService;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardSaleRecodeVo;
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

       /**
        * 后台根据条件查询售卡记录汇总
        * @param pageNo
        * @param pageSize
        * @param memberCardSaleRecodeVo
        * @return
        */
       @PostMapping("/bg/queryListCardSaleRecode")
       public PageInfo<MemberCardSaleRecodeVo> queryListCardSaleRecode(
               @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")Integer pageNo,
               @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")Integer pageSize,
               @ApiParam(value="查询条件") @RequestBody MemberCardSaleRecodeVo memberCardSaleRecodeVo) {
              return this.memberCardTradeRecodeService.queryListCardSaleRecode(pageNo,pageSize,memberCardSaleRecodeVo);
       }

       @GetMapping("/queryCardSaleDetailById/{id}")
       public MemberCardSaleRecodeVo queryCardSaleDetailById(@PathVariable (value="id") int id) {
              return this.memberCardTradeRecodeService.queryCardSaleDetailById(id);
       }

       /**
        * 根据时间查询会员卡充值订单数量
        * @param memberAndMemberCardVo
        * @return
        */
       @PostMapping("/queryRechargeCount")
       Integer queryRechargeCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo){
              return this.memberCardTradeRecodeService.queryRechargeCount(memberAndMemberCardVo);
       }

       /**
        * 根据时间查询会员卡售卡订单数量
        * @param memberAndMemberCardVo
        * @return
        */
       @PostMapping("/querySaleCardCount")
       Integer querySaleCardCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo){
              return this.memberCardTradeRecodeService.querySaleCardCount(memberAndMemberCardVo);
       }

}