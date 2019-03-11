package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.member.service.MemberCardRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="用户会员卡表")
@RestController
@RequestMapping(value="memberCardRef")
public class MemberCardRefController {
       private final static Logger log= LoggerFactory.getLogger(MemberCardRefController.class);
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
       public ResponseMessage queryById(@PathVariable (value="id") int id) {
              return this.memberCardRefService.queryMyCardInfo(id);
       }

       @GetMapping("/queryByRefId/{id}")
       public  ResponseMessage<MemberCardRef> queryByRefId(@PathVariable (value="id") int id) {
              return this.memberCardRefService.queryByRefId(id);
       }

       @PostMapping(value = "/queryMemberCardInfo")
       public ResponseMessage<MemberCardRef> queryByIdAndcardId(@RequestBody Map<String,Object> map){
              return memberCardRefService.queryByIdAndCardId(map);
       }

       @GetMapping(value = "/queryByMemberId")
       public ResponseMessage<PageInfo<Map<String,Object>>> queryByMemberId(
               @RequestParam(value = "pageNo")Integer pageNo,
               @RequestParam(value = "pageSize")Integer pageSize,
               @RequestParam(value = "memberId")Integer memberId,
               @RequestParam(value = "isEnabled")Byte isEnabled){
           return memberCardRefService.queryByMemberId(pageNo,pageSize,memberId,isEnabled);
       }

       @GetMapping(value = "/queryUserdByMemberId")
       public ResponseMessage<PageInfo<Map<String,Object>>> queryUserdByMemberId(
               @RequestParam(value = "pageNo")Integer pageNo,
               @RequestParam(value = "pageSize")Integer pageSize,
               @RequestParam(value = "memberId")Integer memberId,
               @RequestParam(value = "productId")Integer productId){
              return memberCardRefService.queryUserdByMemberId(pageNo,pageSize,memberId,productId);
       }


       @GetMapping(value = "getMyCardCount")
       public ResponseMessage getMyCardCount(@RequestParam(value = "memberId")Integer memberId ){
              return memberCardRefService.getMyCardCount(memberId);
       }

       /**
        * 会员卡支付
        * @param amount
        * @param memberId
        * @param memberCardRefId
        * @return
        */
       @PostMapping(value = "/memberCardConsume")
       public ResponseMessage memberCardConsume(@RequestParam(value = "amount") Integer amount,
                                                @RequestParam(value = "memberId") Integer memberId,
                                                @RequestParam(value = "memberCardRefId") Integer memberCardRefId){
              return memberCardRefService.memberCardConsume(amount,memberId,memberCardRefId);
       }

       /**
        * 查询用户最新购买的会员卡信息
        * @param memberId
        * @return
        */
       @GetMapping(value = "queryMemberNewestCard/{memberId}")
       public ResponseMessage queryMemberNewestCard(@PathVariable(value = "memberId")Integer memberId){
              return memberCardRefService.queryMemberNewestCard(memberId);
       }

        /**
         * 添加用户购卡记录
         * @param memberCardTradeRecode
         * @return
         */
        @PostMapping(value = "/insertBuyCardRecord")
       public ResponseMessage insertBuyCardRecord(@RequestBody MemberCardTradeRecode memberCardTradeRecode){
              return  memberCardRefService.insertBuyCardRecord(memberCardTradeRecode);
       }

        /**
         * 更新会员卡余额
         * @param memberCardTradeRecode
         * @return
         */
        @PostMapping(value = "/updateMemberCardBalance")
       public ResponseMessage updateMemberCardBalance(@RequestBody MemberCardTradeRecode memberCardTradeRecode){
              return memberCardRefService.updateMemberCardBalance(memberCardTradeRecode);
       }

}