package com.union.aimei.app.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberBankCardFeign;
import com.union.aimei.common.feign.app.member.MemberWithdrawsFeign;
import com.union.aimei.common.model.member.MemberBankCard;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.vo.member.MemberWithdrawsDetailVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Api(tags="会员提现申请表")
@RestController
@RequestMapping(value="memberWithdraws")
public class MemberWithdrawsApiController {
       @Resource
       private MemberWithdrawsFeign memberWithdrawsFeign;

       @Resource
       private MemberBankCardFeign memberBankCardFeign;


       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberWithdraws 查询条件
     * @return ResponseMessage<MemberWithdraws>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员提现申请表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberWithdraws> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberWithdraws memberWithdraws) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberWithdraws> page=memberWithdrawsFeign.findByPageForFront(pageNo, pageSize,memberWithdraws);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }



       /** 
        * 修改MemberWithdraws
        * @param memberWithdraws
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员提现申请表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberWithdraws memberWithdraws) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberWithdrawsFeign.edit(memberWithdraws);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

//       /**
//        * 根据ID查询MemberWithdraws
//        * @param id
//        * @returnmemberWithdraws
//        */
//       @ApiOperation(httpMethod="GET", value="通过ID查询会员提现申请表")
//       @GetMapping("/queryById/{id}")
//       public ResponseMessage<MemberWithdraws> queryById(@PathVariable (value="id") int id) {
//              return this.memberWithdrawsApiService.queryObjById(id);
//       }

       /**
        * 会员(美容师或店长)提现到银行卡
        * @return
        */
       @ApiOperation(httpMethod = "POST",value = "会员(美容师或店长)提现到银行卡",notes = "传递会员ID,银行卡ID以及提现申请金额即可（以分为单位）")
       @PostMapping("/withdrawalsByMember")
       public ResponseMessage withdrawalsByMember(@RequestBody MemberWithdraws memberWithdraws){
              return this.memberWithdrawsFeign.insertRecord(memberWithdraws);
       }

       /**
        * 根据提现申请id来查询会员提现详情信息
        * @param memberWithdrawsDetailVo
        * @return
        */
       @ApiOperation(httpMethod="POST", value="通过ID查询会员提现申请表")
       @PostMapping("/queryDetailById")
       public ResponseMessage<MemberWithdrawsDetailVo> queryDetailById(@RequestBody MemberWithdrawsDetailVo memberWithdrawsDetailVo) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              //第一步：根据id来查询会员申请提款基本信息
              MemberWithdraws memberWithdraws = this.memberWithdrawsFeign.queryById(memberWithdrawsDetailVo.getId());
              memberWithdrawsDetailVo = new MemberWithdrawsDetailVo(memberWithdraws);
              //第二步：根据银行卡id来进行查询会员银行卡信息
              MemberBankCard memberBankCard =  this.memberBankCardFeign.queryById(memberWithdraws.getBankCardId());
              memberWithdrawsDetailVo.setAccountName(memberBankCard.getRealName());
              memberWithdrawsDetailVo.setAccountBank(memberBankCard.getBankname());
              memberWithdrawsDetailVo.setAccountBranchBank(memberBankCard.getBankname());
              result.setData(memberWithdrawsDetailVo);
              return result;
       }

}