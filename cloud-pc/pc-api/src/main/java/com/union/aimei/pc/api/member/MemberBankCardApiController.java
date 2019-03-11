package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberBankCardFeign;
import com.union.aimei.common.model.member.MemberBankCard;
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
 */
@Api(tags="会员银行卡表")
@RestController
@RequestMapping(value="memberBankCard")
public class MemberBankCardApiController {
       @Resource
       private MemberBankCardFeign memberBankCardFeign;
       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberBankCard 查询条件
     * @return ResponseMessage<MemberBankCard>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员银行卡表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberBankCard> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberBankCard memberBankCard) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberBankCard> page=memberBankCardFeign.findByPageForFront(pageNo, pageSize,memberBankCard);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberBankCard
        * @param memberBankCard
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员银行卡表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberBankCard memberBankCard) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberBankCardFeign.insert(memberBankCard);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberBankCard
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员银行卡表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberBankCardFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberBankCard
        * @param memberBankCard
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员银行卡表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberBankCard memberBankCard) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberBankCardFeign.edit(memberBankCard);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberBankCard
        * @param id
        * @returnmemberBankCard
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员银行卡表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberBankCard> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberBankCard model=this.memberBankCardFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}