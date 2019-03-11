package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardRefFeign;
import com.union.aimei.common.model.member.MemberCardRef;
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
@Api(tags="用户会员卡表")
@RestController
@RequestMapping(value="memberCardRef")
public class MemberCardRefApiController {
       @Resource
       private MemberCardRefFeign memberCardRefFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardRef 查询条件
     * @return ResponseMessage<MemberCardRef>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询用户会员卡表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberCardRef> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardRef memberCardRef) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardRef> page=memberCardRefFeign.findByPageForFront(pageNo, pageSize,memberCardRef);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberCardRef
        * @param memberCardRef
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加用户会员卡表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberCardRef memberCardRef) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardRefFeign.insert(memberCardRef);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberCardRef
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除用户会员卡表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardRefFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberCardRef
        * @param memberCardRef
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑用户会员卡表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberCardRef memberCardRef) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardRefFeign.edit(memberCardRef);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberCardRef
        * @param id
        * @returnmemberCardRef
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询用户会员卡表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberCardRef> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCardRef model=this.memberCardRefFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 后台个人测试
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询用户会员卡表")
       @GetMapping("/test")
       public void test() {
               this.memberCardRefFeign.test();
       }

}