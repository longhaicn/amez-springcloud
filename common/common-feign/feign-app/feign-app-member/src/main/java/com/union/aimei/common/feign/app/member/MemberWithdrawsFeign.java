package com.union.aimei.common.feign.app.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberWithdrawsApiHystrix;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="APP-MEMBER-SERVICE",fallback=MemberWithdrawsApiHystrix.class)
public interface MemberWithdrawsFeign {
       /**
        * 添加会员提现申请表
        * @param memberWithdraws
        * @return
        */
       @PostMapping(value="/memberWithdraws/insert")
       int insert(@RequestBody MemberWithdraws memberWithdraws);

       /**
        * 添加会员提现申请表
        * @param memberWithdraws
        * @return
        */
       @PostMapping(value="/memberWithdraws/insertRecord")
       ResponseMessage<MemberWithdraws> insertRecord(@RequestBody MemberWithdraws memberWithdraws);

       /**
        * 删除会员提现申请表
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberWithdraws/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员提现申请表
        * @param memberWithdraws
        * @return
        */
       @PutMapping(value="/memberWithdraws/edit")
       int edit(@RequestBody MemberWithdraws memberWithdraws);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberWithdraws
        */
       @GetMapping(value="/memberWithdraws/queryById/{id}")
       MemberWithdraws queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员提现申请表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberWithdraws 查询条件
     * @return
     */
       @PostMapping(value="/memberWithdraws/front/findByPage")
       PageInfo<MemberWithdraws> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                            Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                            Integer pageSize, @RequestBody MemberWithdraws memberWithdraws);
}