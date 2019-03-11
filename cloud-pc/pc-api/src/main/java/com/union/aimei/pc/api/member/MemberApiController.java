package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberFeign;
import com.union.aimei.common.model.member.Member;
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
@Api(tags="美容邦用户表")
@RestController
@RequestMapping(value="member")
public class MemberApiController {
       @Resource
       private MemberFeign memberFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param member 查询条件
     * @return ResponseMessage<Member>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询美容邦用户表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<Member> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody Member member) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<Member> page=memberFeign.findByPageForFront(pageNo, pageSize,member);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加Member
        * @param member
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加美容邦用户表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody Member member) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberFeign.insert(member);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除Member
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除美容邦用户表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改Member
        * @param member
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑美容邦用户表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody Member member) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberFeign.edit(member);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询Member
        * @param id
        * @returnmember
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询美容邦用户表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<Member> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              Member model=this.memberFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}