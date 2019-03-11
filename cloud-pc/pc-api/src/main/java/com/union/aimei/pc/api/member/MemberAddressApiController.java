package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberAddressFeign;
import com.union.aimei.common.model.member.MemberAddress;
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
@Api(tags="会员地址")
@RestController
@RequestMapping(value="memberAddress")
public class MemberAddressApiController {
       @Resource
       private MemberAddressFeign memberAddressFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberAddress 查询条件
     * @return ResponseMessage<MemberAddress>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员地址")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberAddress> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberAddress memberAddress) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberAddress> page=memberAddressFeign.findByPageForFront(pageNo, pageSize,memberAddress);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberAddress
        * @param memberAddress
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员地址")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberAddress memberAddress) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberAddressFeign.insert(memberAddress);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberAddress
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员地址")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberAddressFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberAddress
        * @param memberAddress
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员地址")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberAddress memberAddress) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberAddressFeign.edit(memberAddress);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberAddress
        * @param id
        * @returnmemberAddress
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员地址")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberAddress> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberAddress model=this.memberAddressFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}