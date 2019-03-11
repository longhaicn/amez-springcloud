package com.union.aimei.common.feign.pc.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberBankCardApiHystrix;
import com.union.aimei.common.model.member.MemberBankCard;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberBankCardApiHystrix.class)
public interface MemberBankCardFeign {
       /**
        * 添加会员银行卡表
        * @param memberBankCard
        * @return
        */
       @PostMapping(value="/memberBankCard/insert")
       int insert(@RequestBody MemberBankCard memberBankCard);

       /**
        * 删除会员银行卡表
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberBankCard/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员银行卡表
        * @param memberBankCard
        * @return
        */
       @PutMapping(value="/memberBankCard/edit")
       int edit(@RequestBody MemberBankCard memberBankCard);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberBankCard
        */
       @GetMapping(value="/memberBankCard/queryById/{id}")
       MemberBankCard queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员银行卡表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberBankCard 查询条件
     * @return
     */
       @PostMapping(value="/memberBankCard/front/findByPage")
       PageInfo<MemberBankCard> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                           Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                           Integer pageSize, @RequestBody MemberBankCard memberBankCard);
}