package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardUseRangeFeign;
import com.union.aimei.common.model.member.MemberCardUseRange;
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
@Api(tags="会员卡门店使用范围")
@RestController
@RequestMapping(value="memberCardUseRange")
public class MemberCardUseRangeApiController {
       @Resource
       private MemberCardUseRangeFeign memberCardUseRangeFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardUseRange 查询条件
     * @return ResponseMessage<MemberCardUseRange>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员卡使用范围")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberCardUseRange> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardUseRange memberCardUseRange) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardUseRange> page=memberCardUseRangeFeign.findByPageForFront(pageNo, pageSize,memberCardUseRange);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberCardUseRange
        * @param memberCardUseRange
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员卡使用范围")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberCardUseRange memberCardUseRange) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardUseRangeFeign.insert(memberCardUseRange);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberCardUseRange
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员卡使用范围")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardUseRangeFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberCardUseRange
        * @param memberCardUseRange
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡使用范围")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberCardUseRange memberCardUseRange) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardUseRangeFeign.edit(memberCardUseRange);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberCardUseRange
        * @param id
        * @returnmemberCardUseRange
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员卡使用范围")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberCardUseRange> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCardUseRange model=this.memberCardUseRangeFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}