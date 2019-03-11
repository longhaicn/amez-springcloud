package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.member.service.MemberCardService;
import com.union.aimei.common.vo.member.EditMemberCardVo;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.ReleaseMemberCardVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags = "会员卡")
@RestController
@RequestMapping(value = "memberCard")
public class MemberCardController {
    @Resource
    private MemberCardService memberCardService;

    @PostMapping("/front/findByPage")
    public PageInfo<MemberCard> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody MemberCard memberCard) {
        return this.memberCardService.findByPageForFront(pageNo, pageSize, memberCard);
    }

    /**
     * 发布会员卡
     *
     * @param releaseMemberCardVo
     * @return
     */
    @PostMapping("/releaseMemberCard")
    public ResponseMessage releaseMemberCard(@RequestBody ReleaseMemberCardVo releaseMemberCardVo) {
        return this.memberCardService.releaseMemberCard(releaseMemberCardVo);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.memberCardService.deleteObjById(id);
    }

    /**
     * 编辑会员卡基本信息
     * @param memberCard
     * @return
     */
    @PutMapping("/edit")
    public int edit(@RequestBody MemberCard memberCard) {
        return this.memberCardService.modifyObj(memberCard);
    }

    @GetMapping("/queryById/{id}")
    public MemberCard queryById(@PathVariable(value = "id") int id) {
        return this.memberCardService.queryObjById(id);
    }

    @GetMapping("/queryDetails/{id}")
    public ResponseMessage queryMemberCardDetail(@PathVariable(value = "id") int id){
        return memberCardService.queryCardDetail(id);
    }
    /**
     * 修改会员卡信息，包含会员卡基本信息、使用门店范围、适用服务
     * @return
     */
    @PutMapping(value = "/editMemberCardInfo")
    public ResponseMessage editMemberCardInfo(@RequestBody EditMemberCardVo editMemberCardVo){
         return memberCardService.editMemberCardInfo(editMemberCardVo);
    }

    /**
     * 查询会员和会员卡新增统计
     */
    @ApiOperation(httpMethod="POST", value="根据时间段查询会员和会员卡新增统计")
    @PostMapping("/queryMemberCardCount")
    public Integer queryMemberCardCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo){
        return memberCardService.queryMemberCardCount(memberAndMemberCardVo);
    }

}