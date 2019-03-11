package com.union.aimei.app.api.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberFeign;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;


/**
 * @author GaoWei
 * @describe 美容邦对接艾美实现会员注册，登录，修改密码等功能
 * @time 2017/12/12,17:16
 */
@Api(tags = "美容邦会员")
@RestController
@RequestMapping(value = "member")
public class MemberController {

    @Resource
    private MemberFeign memberFeign;


    /**
     * 修改Member
     * @param member
     * @return
     */
    @ApiOperation(httpMethod="PUT", value="编辑美容邦用户")
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



    /**
     * 根据ImUsernameList来查询会员信息
     * @param memberImUsernameListVo
     * @return
     * @throws IOException
     */
    @ApiOperation(httpMethod = "POST", value = "根据ImUsername查询会员信息")
    @PostMapping(value = "queryByImUsernameList")
    public ResponseMessage queryByImUsernameList(@RequestBody MemberImUsernameListVo memberImUsernameListVo){
        return memberFeign.queryByImUsernameList(memberImUsernameListVo);
    }


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



}
