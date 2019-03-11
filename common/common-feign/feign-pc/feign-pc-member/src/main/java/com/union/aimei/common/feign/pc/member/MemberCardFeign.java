package com.union.aimei.common.feign.pc.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberCardApiHystrix;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.EditMemberCardVo;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.ReleaseMemberCardVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberCardApiHystrix.class)
public interface MemberCardFeign {
       /**
        * 发布会员卡
        * @param releaseMemberCardVo
        * @return
        */
       @PostMapping("/memberCard/releaseMemberCard")
       ResponseMessage releaseMemberCard(@RequestBody ReleaseMemberCardVo releaseMemberCardVo);

       /**
        * 查询会员卡数量
        * @param memberAndMemberCardVo
        * @return
        */
       @PostMapping("/memberCard/queryMemberCardCount")
       Integer queryMemberCardCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo);

       /**
        * 删除会员卡
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberCard/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员卡
        * @param memberCard
        * @return
        */
       @PutMapping(value="/memberCard/edit")
       int edit(@RequestBody MemberCard memberCard);

       /**
        * 根据ID查询会员卡基本信息
        * @param id
        * @returnmemberCard
        */
       @GetMapping(value="/memberCard/queryById/{id}")
       MemberCard queryById(@PathVariable(value = "id") int id);


       /**
        * 根据ID查询会员卡详细信息
        * @param id
        * @return
        */
       @GetMapping("/memberCard/queryDetails/{id}")
       ResponseMessage queryMemberCardDetail(@PathVariable(value = "id") int id);


       /**
     * 前端分页查询会员卡
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCard 查询条件
     * @return
     */
       @PostMapping(value="/memberCard/front/findByPage")
       PageInfo<MemberCard> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                       Integer pageSize, @RequestBody MemberCard memberCard);

       /**
        * 修改会员卡信息，包含会员卡基本信息、使用门店范围、适用服务
        * @param editMemberCardVo
        * @return
        */
       @PutMapping(value = "/memberCard/editMemberCardInfo")
       ResponseMessage editMemberCardInfo(@RequestBody EditMemberCardVo editMemberCardVo);
       
}