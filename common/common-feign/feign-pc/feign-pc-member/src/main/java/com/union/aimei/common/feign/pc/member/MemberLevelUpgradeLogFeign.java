package com.union.aimei.common.feign.pc.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberLevelUpgradeLogApiHystrix;
import com.union.aimei.common.model.member.MemberLevelUpgradeLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberLevelUpgradeLogApiHystrix.class)
public interface MemberLevelUpgradeLogFeign {
       /**
        * 添加会员成长值记录
        * @param memberLevelUpgradeLog
        * @return
        */
       @PostMapping(value="/memberLevelUpgradeLog/insert")
       int insert(@RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog);

       /**
        * 删除会员成长值记录
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberLevelUpgradeLog/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员成长值记录
        * @param memberLevelUpgradeLog
        * @return
        */
       @PutMapping(value="/memberLevelUpgradeLog/edit")
       int edit(@RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevelUpgradeLog
        */
       @GetMapping(value="/memberLevelUpgradeLog/queryById/{id}")
       MemberLevelUpgradeLog queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员成长值记录
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberLevelUpgradeLog 查询条件
     * @return
     */
       @PostMapping(value="/memberLevelUpgradeLog/front/findByPage")
       PageInfo<MemberLevelUpgradeLog> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                  Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                  Integer pageSize, @RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog);
}