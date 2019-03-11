package com.union.aimei.common.feign.pc.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberCardRefApiHystrix;
import com.union.aimei.common.model.member.MemberCardRef;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberCardRefApiHystrix.class)
public interface MemberCardRefFeign {
       /**
        * 添加用户会员卡表
        * @param memberCardRef
        * @return
        */
       @PostMapping(value="/memberCardRef/insert")
       int insert(@RequestBody MemberCardRef memberCardRef);

       /**
        * 删除用户会员卡表
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberCardRef/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改用户会员卡表
        * @param memberCardRef
        * @return
        */
       @PutMapping(value="/memberCardRef/edit")
       int edit(@RequestBody MemberCardRef memberCardRef);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardRef
        */
       @GetMapping(value="/memberCardRef/queryById/{id}")
       MemberCardRef queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询用户会员卡表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardRef 查询条件
     * @return
     */
       @PostMapping(value="/memberCardRef/front/findByPage")
       PageInfo<MemberCardRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                          Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                          Integer pageSize, @RequestBody MemberCardRef memberCardRef);

       /**
        * 查询失效会员卡
        */
       @GetMapping(value="/memberCardRef/setMemberCardUnEffective")
       void setMemberCardUnEffective();

       /**
        * 后台个人测试
        */
       @GetMapping("/memberCardRef/setMemberCardUnEffective")
       public void test();

}