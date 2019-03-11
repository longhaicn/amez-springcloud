package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberLevelFeign;
import com.union.aimei.common.model.member.MemberLevel;
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
@Api(tags="会员级别")
@RestController
@RequestMapping(value="memberLevel")
public class MemberLevelApiController {
       @Resource
       private MemberLevelFeign memberLevelFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberLevel 查询条件
     * @return ResponseMessage<MemberLevel>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员级别")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberLevel> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberLevel memberLevel) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberLevel> page=memberLevelFeign.findByPageForFront(pageNo, pageSize,memberLevel);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberLevel
        * @param memberLevel
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员级别")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberLevel memberLevel) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberLevelFeign.insert(memberLevel);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberLevel
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员级别")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberLevelFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberLevel
        * @param memberLevel
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员级别")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberLevel memberLevel) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberLevelFeign.edit(memberLevel);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberLevel
        * @param id
        * @returnmemberLevel
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员级别")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberLevel> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberLevel model=this.memberLevelFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}