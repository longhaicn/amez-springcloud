package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardTradeRecodeFeign;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardSaleRecodeVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author houji
 */
@Api(tags="会员卡交易记录")
@RestController
@RequestMapping(value="memberCardTradeRecode")
public class MemberCardTradeRecodeApiController {
       @Resource
       private MemberCardTradeRecodeFeign memberCardTradeRecodeFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardTradeRecode 查询条件
     * @return ResponseMessage<MemberCardTradeRecode>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员卡交易记录")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberCardTradeRecode> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardTradeRecode> page=memberCardTradeRecodeFeign.findByPageForFront(pageNo, pageSize,memberCardTradeRecode);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 后台根据条件查询售卡记录汇总
        * @param pageNo
        * @param pageSize
        * @param memberCardSaleRecodeVo
        * @return
        */
       @ApiOperation(httpMethod="POST", value="后台根据条件筛选售卡记录汇总")
       @PostMapping("/bg/queryListCardSaleRecode")
       public ResponseMessage<MemberCardSaleRecodeVo> queryListCardSaleRecode(
               @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")Integer pageNo,
               @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")Integer pageSize,
               @ApiParam(value="查询条件") @RequestBody MemberCardSaleRecodeVo memberCardSaleRecodeVo) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardSaleRecodeVo> page=memberCardTradeRecodeFeign.queryListCardSaleRecode(pageNo, pageSize,memberCardSaleRecodeVo);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }



       /**
        * 后台分页查询会员卡售卡记录
        * @param pageNo
        * @param pageSize
        * @param memberCardTradeRecode
        * @return
        */
       @ApiOperation(httpMethod="POST", value="后台分页查询会员卡售卡记录")
       @PostMapping("/bg/findByPageForBg")
       public ResponseMessage<MemberCardTradeRecode> findByPageForBg(
               @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")Integer pageNo,
               @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")Integer pageSize,
               @ApiParam(value="查询条件") @RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardTradeRecode> page=memberCardTradeRecodeFeign.findByPageForFront(pageNo, pageSize,memberCardTradeRecode);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberCardTradeRecode
        * @param memberCardTradeRecode
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员卡交易记录")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardTradeRecodeFeign.insert(memberCardTradeRecode);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberCardTradeRecode
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员卡交易记录")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardTradeRecodeFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberCardTradeRecode
        * @param memberCardTradeRecode
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡交易记录")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardTradeRecodeFeign.edit(memberCardTradeRecode);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberCardTradeRecode
        * @param id
        * @returnmemberCardTradeRecode
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员卡交易记录")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberCardTradeRecode> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCardTradeRecode model=this.memberCardTradeRecodeFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 通过ID查询会员卡售卡详情记录
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员卡售卡详情记录")
       @GetMapping("/queryCardSaleDetailById/{id}")
       public ResponseMessage<MemberCardSaleRecodeVo> queryCardSaleDetailById(@PathVariable (value="id") int id){
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCardSaleRecodeVo model=this.memberCardTradeRecodeFeign.queryCardSaleDetailById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 查询会员和会员卡新增统计
        */
       @ApiOperation(httpMethod="POST", value="根据时间段查询售卡和充值统计")
       @PostMapping("/queryRechargeCountAndSaleCardCount")
       public ResponseMessage queryRechargeCountAndSaleCardCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo){
              ResponseMessage result = ResponseMessageFactory.newInstance();
              Integer rechargeCount = this.memberCardTradeRecodeFeign.queryRechargeCount(memberAndMemberCardVo);
              Integer saleCardCount = this.memberCardTradeRecodeFeign.querySaleCardCount(memberAndMemberCardVo);
              Map<String,Integer> map = new HashMap<>(2);
              map.put("rechargeCount",rechargeCount);
              map.put("saleCardCount",saleCardCount);
              result.setData(map);
              return result;
       }
}