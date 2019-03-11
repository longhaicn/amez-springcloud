package com.union.aimei.app.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberCardRefFeign;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Api(tags = "用户会员卡表")
@RestController
@RequestMapping(value = "memberCardRef")
public class MemberCardRefApiController {

    @Resource
    private MemberCardRefFeign memberCardRefFeign;
    /**
     * 分页查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param memberCardRef 查询条件
     * @return ResponseMessage<MemberCardRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询用户会员卡表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<MemberCardRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody MemberCardRef memberCardRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<MemberCardRef> page = memberCardRefFeign.findByPageForFront(pageNo, pageSize, memberCardRef);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加MemberCardRef
     *
     * @param memberCardRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加用户会员卡表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody MemberCardRef memberCardRef) {
        ResponseMessage res=new ResponseMessage();
        int result=this.memberCardRefFeign.insert(memberCardRef);
        if(result!=1){
            res.setCode(ResponseContants.ADD);
            res.setMessage(ResponseContants.ADD_MESSAGE);
        }
        return res;
    }

//    @ApiOperation(httpMethod = "POST", value = "通过ID查询用户会员卡表")
//    @PostMapping(value = "/queryByMemberIdAndCardId")
//    public ResponseMessage<MemberCardRef> queryByMemberIdAndCardId(@RequestBody Map<String,Object> map) {
//        return this.memberCardRefFeign.queryByIdAndCardId(map);
//    }

    /**
     * 根据ID查询MemberCardRef
     *
     * @param id
     * @returnmemberCardRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询用户会员卡与累计节省金额")
    @GetMapping("/queryById/{id}")
    public ResponseMessage queryById(@PathVariable(value = "id") int id) {
        return this.memberCardRefFeign.queryById(id);
    }

    /**
     * 根据ID查询MemberCardRef
     *
     * @param id
     * @returnmemberCardRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询用户会员卡表")
    @GetMapping("/queryByRefId/{id}")
    public  ResponseMessage<MemberCardRef> queryByRefId(@PathVariable(value = "id") int id) {
        return this.memberCardRefFeign.queryByRefId(id);
    }

    /**
     * 查询我的会员卡列表
     * @param memberId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询我的会员卡列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "pageNo",value = "分页开始",defaultValue = "1",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "pageSize",value = "每页多少条",defaultValue="10",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "memberId",required = true,value = "会员ID",defaultValue = "16",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "isEnabled",required = true,value = "使用状态(0：正常，1：被冻结，2：已作废) ",defaultValue = "0",paramType = "query")
    })
    @GetMapping(value = "queryByMemberId")
    public ResponseMessage<PageInfo<Map<String,Object>>> queryByMemberId(
            @RequestParam(value = "pageNo")Integer pageNo,
            @RequestParam(value = "pageSize")Integer pageSize,
            @RequestParam(value = "memberId")Integer memberId,
            @RequestParam(value = "isEnabled")Byte isEnabled){
        return memberCardRefFeign.queryByMemberId(pageNo,pageSize,memberId,isEnabled);
    }

    /**
     * 查询我的会员卡列表
     * @param memberId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "提交订单查询我可以使用的会员卡列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "pageNo",value = "分页开始",defaultValue = "1",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "pageSize",value = "每页多少条",defaultValue="10",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "memberId",required = true,value = "会员ID",defaultValue = "16",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "productId",required = true,value = "商品或者服务Id",paramType = "query"),
    })
    @GetMapping(value = "queryUserdByMemberId")
    public ResponseMessage<PageInfo<Map<String,Object>>> queryUserdByMemberId(
            @RequestParam(value = "pageNo")Integer pageNo,
            @RequestParam(value = "pageSize")Integer pageSize,
            @RequestParam(value = "memberId")Integer memberId,
            @RequestParam(value = "productId")Integer productId){
        return memberCardRefFeign.queryUserdByMemberId(pageNo,pageSize,memberId,productId);
    }


    /**
     * 查询用户最新购买的会员卡信息
     * @param memberId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询用户最新购买的会员卡信息")
    @GetMapping(value = "/queryMemberNewestCard/{memberId}")
    public ResponseMessage queryMemberNewestCard(@PathVariable(value = "memberId")Integer memberId){
        return memberCardRefFeign.queryMemberNewestCard(memberId);
    }

}