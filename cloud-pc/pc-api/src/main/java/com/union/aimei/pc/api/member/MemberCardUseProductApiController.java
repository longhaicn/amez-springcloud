package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardFeign;
import com.union.aimei.common.feign.pc.member.MemberCardUseProductFeign;
import com.union.aimei.common.feign.pc.member.MemberCardUseRangeFeign;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.vo.member.NewProductGroundVo;
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
@Api(tags="会员卡适用服务表")
@RestController
@RequestMapping(value="memberCardUseProduct")
public class MemberCardUseProductApiController {
       @Resource
       private MemberCardUseProductFeign memberCardUseProductFeign;

       @Resource
       private MemberCardUseRangeFeign memberCardUseRangeFeign;

       @Resource
       private MemberCardFeign memberCardFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardUseProduct 查询条件
     * @return ResponseMessage<MemberCardUseProduct>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员卡适用服务表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberCardUseProduct> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardUseProduct memberCardUseProduct) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardUseProduct> page=memberCardUseProductFeign.findByPageForFront(pageNo, pageSize,memberCardUseProduct);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberCardUseProduct
        * @param memberCardUseProduct
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员卡适用服务表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberCardUseProduct memberCardUseProduct) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardUseProductFeign.insert(memberCardUseProduct);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberCardUseProduct
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员卡适用服务表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardUseProductFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberCardUseProduct
        * @param memberCardUseProduct
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡适用服务表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberCardUseProduct memberCardUseProduct) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardUseProductFeign.edit(memberCardUseProduct);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberCardUseProduct
        * @param id
        * @returnmemberCardUseProduct
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员卡适用服务表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberCardUseProduct> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCardUseProduct model=this.memberCardUseProductFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 当品牌发布得商品在品牌所属门店上架，添加会员卡支付
        */
       @ApiOperation(httpMethod="POST", value="当品牌发布的在商品，添加会员卡支付")
       @PostMapping("/insertMemberCardByProductId")
       public ResponseMessage insertMemberCardByProductId(@RequestBody NewProductGroundVo newProductGroundVo) {
              return memberCardUseProductFeign.insertMemberCardByProductId(newProductGroundVo);
       }
}