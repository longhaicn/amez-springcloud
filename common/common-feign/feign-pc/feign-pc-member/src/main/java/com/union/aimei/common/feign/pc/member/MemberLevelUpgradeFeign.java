package com.union.aimei.common.feign.pc.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberLevelUpgradeApiHystrix;
import com.union.aimei.common.model.member.MemberLevelUpgrade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberLevelUpgradeApiHystrix.class)
public interface MemberLevelUpgradeFeign {
       /**
        * 添加会员成长值规则设置
        * @param memberLevelUpgrade
        * @return
        */
       @PostMapping(value="/memberLevelUpgrade/insert")
       int insert(@RequestBody MemberLevelUpgrade memberLevelUpgrade);

       /**
        * 删除会员成长值规则设置
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberLevelUpgrade/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员成长值规则设置
        * @param memberLevelUpgrade
        * @return
        */
       @PutMapping(value="/memberLevelUpgrade/edit")
       int edit(@RequestBody MemberLevelUpgrade memberLevelUpgrade);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevelUpgrade
        */
       @GetMapping(value="/memberLevelUpgrade/queryById/{id}")
       MemberLevelUpgrade queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员成长值规则设置
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberLevelUpgrade 查询条件
     * @return
     */
       @PostMapping(value="/memberLevelUpgrade/front/findByPage")
       PageInfo<MemberLevelUpgrade> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                               Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                               Integer pageSize, @RequestBody MemberLevelUpgrade memberLevelUpgrade);
}