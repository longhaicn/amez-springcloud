package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.aimei.member.mapper.MemberMapper;
import com.union.aimei.member.service.MemberService;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/25,17:10
*/
@Api(tags = "美容邦用户表")
@RestController
@RequestMapping(value = "member")
public class MemberController {

    public static final Logger log= LoggerFactory.getLogger(MemberController.class);
    @Resource
    private MemberService memberService;
    @Resource
    private MemberMapper memberMapper;

    @PostMapping("/front/findByPage")
    public PageInfo<Member> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                       Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                       Integer pageSize, @ApiParam(value = "查询条件") @RequestBody Member member) {
        return this.memberService.findByPageForFront(pageNo, pageSize, member);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Member member) {
        return this.memberService.addObj(member);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.memberService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody Member member) {
        return this.memberService.modifyObj(member);
    }

    @GetMapping("/queryById/{id}")
    public Member queryById(@PathVariable(value = "id") int id) {
        return this.memberService.queryObjById(id);
    }


    /**
     * 根据条件查询会员是否存在
     *
     * @param member
     * @return
     */
    @PostMapping(value = "/queryByConditions")
    public ResponseMessage queryByConditions(@RequestBody Member member) {
        return memberService.queryByConditions(member);
    }


    @GetMapping(value = "/queryByMobile")
    public ResponseMessage<Member> queryByPhone(@RequestParam(value = "mobile")String mobile){
        ResponseMessage<Member> res=new ResponseMessage<>();
        Member member=memberMapper.queryByMobile(mobile);
        if(member!=null){
            res.setData(member);
        }else{
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }

    /**
     * 根据会员ID和会员卡ID判断是否已经购卡过
     * @param memberId
     * @param memberCardId
     * @return
     */
    @GetMapping(value = "/judgeIfHasBuyCard")
    public ResponseMessage judgeIfHasBuyCard(@RequestParam(value = "memberId")Integer memberId,
                                             @RequestParam(value = "memberCardId")Integer memberCardId){
      return memberService.judgeIfHasBuyCard(memberId,memberCardId);
    }


    /**
     * MemberImUsernameList查询会员信息
     * @param memberImUsernameListVo
     * @return
     */
    @PostMapping(value = "/queryByImUsernameList")
    ResponseMessage<List<Member>> queryByImUsernameList(@RequestBody MemberImUsernameListVo memberImUsernameListVo){
        return this.memberService.queryByImUsernameList(memberImUsernameListVo);
    }


    /**
     * 根据uuid来查询会员信息
     * @param uuid
     * @return
     */
    @GetMapping(value = "/queryMemberInfoByUuid/{uuid}")
    public ResponseMessage<Member> queryMemberInfoByUuid(@PathVariable(value = "uuid")String uuid){
        return memberService.queryMemberInfoByUuid(uuid);
    }

    /**
     * 注册艾美会员
     * 手机号，密码，IP，source，loginType必传
     * @param mrbMemberLoginVo
     * @return
     */
    @PostMapping(value = "/registerUser")
    public ResponseMessage<Member> registerAmezMember(@RequestBody MrbMemberLoginVo mrbMemberLoginVo){
        return memberService.registerUser(mrbMemberLoginVo);
    }



}