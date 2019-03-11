package com.union.aimei.common.feign.pc.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberRealNameAuthApiHystrix;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberRealNameAuthApiHystrix.class)
public interface MemberRealNameAuthFeign {
       /**
        * 添加会员卡实名认证表
        * @param memberRealNameAuth
        * @return
        */
       @PostMapping(value="/memberRealNameAuth/insert")
       int insert(@RequestBody MemberRealNameAuth memberRealNameAuth);

       /**
        * 删除会员卡实名认证表
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberRealNameAuth/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员卡实名认证表
        * @param memberRealNameAuth
        * @return
        */
       @PutMapping(value="/memberRealNameAuth/edit")
       int edit(@RequestBody MemberRealNameAuth memberRealNameAuth);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberRealNameAuth
        */
       @GetMapping(value="/memberRealNameAuth/queryById/{id}")
       MemberRealNameAuth queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员卡实名认证表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberRealNameAuth 查询条件
     * @return
     */
       @PostMapping(value="/memberRealNameAuth/front/findByPage")
       PageInfo<MemberRealNameAuth> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                               Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                               Integer pageSize, @RequestBody MemberRealNameAuth memberRealNameAuth);
}