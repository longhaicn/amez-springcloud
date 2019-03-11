package com.union.aimei.app.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberRealNameAuthFeign;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.vo.member.IDNumberAuthVo;
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
@Api(tags="会员实名认证表")
@RestController
@RequestMapping(value="memberRealNameAuth")
public class MemberRealNameAuthApiController {
       @Resource
       private MemberRealNameAuthFeign memberRealNameAuthFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberRealNameAuth 查询条件
     * @return ResponseMessage<MemberRealNameAuth>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员实名认证表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberRealNameAuth> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberRealNameAuth memberRealNameAuth) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberRealNameAuth> page=memberRealNameAuthFeign.findByPageForFront(pageNo, pageSize,memberRealNameAuth);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberRealNameAuth
        * @param memberRealNameAuth
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员实名认证表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthFeign.addObj(memberRealNameAuth);
       }

       /** 
        * 修改MemberRealNameAuth
        * @param memberRealNameAuth
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡实名认证表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberRealNameAuthFeign.edit(memberRealNameAuth);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberRealNameAuth
        * @param id
        * @returnmemberRealNameAuth
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员实名认证表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberRealNameAuth> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberRealNameAuth model=this.memberRealNameAuthFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       @ApiOperation(httpMethod="POST", value="查询会员实名认证表",notes = "只需要传会员ID")
       @PostMapping("/queryByMemberId")
       public ResponseMessage queryByMemberId(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
              //ResponseMessage responseMessage = new ResponseMessage();
              memberRealNameAuth = this.memberRealNameAuthFeign.queryByMemberId(memberRealNameAuth);
              if(memberRealNameAuth == null){
                     responseMessage.setCode(ResponseContants.QUERY_EMPTY);
                     responseMessage.setMessage("未认证");
              }else{
                     responseMessage.setData(memberRealNameAuth);
              }
              return responseMessage;
       }

       @ApiOperation(httpMethod="POST", value="会员(美容师)提现第三方实名认证")
       @PostMapping("/authIDNumber")
       public ResponseMessage authIDNumber(@RequestBody IDNumberAuthVo idNumberAuthVo) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res = this.memberRealNameAuthFeign.authIDNumber(idNumberAuthVo);
              if(res != 0){
                     result.setCode(90099);
                     result.setMessage("实名认证失败");
              }
              return result;
       }


}