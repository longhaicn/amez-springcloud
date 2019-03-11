package com.union.aimei.common.feign.app.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberCardUseRangeApiHystrix;
import com.union.aimei.common.model.member.MemberCardUseRange;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,10:53
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberCardUseRangeApiHystrix.class)
public interface MemberCardUseRangeFeign {
    /**
     * 添加会员卡使用范围
     *
     * @param memberCardUseRange
     * @return
     */
    @PostMapping(value = "/memberCardUseRange/insert")
    int insert(@RequestBody MemberCardUseRange memberCardUseRange);

    /**
     * 删除会员卡使用范围
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/memberCardUseRange/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改会员卡使用范围
     *
     * @param memberCardUseRange
     * @return
     */
    @PutMapping(value = "/memberCardUseRange/edit")
    int edit(@RequestBody MemberCardUseRange memberCardUseRange);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCardUseRange
     */
    @GetMapping(value = "/memberCardUseRange/queryById/{id}")
    MemberCardUseRange queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询会员卡使用范围
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberCardUseRange 查询条件
     * @return
     */
    @PostMapping(value = "/memberCardUseRange/front/findByPage")
    PageInfo<MemberCardUseRange> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                            Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                            Integer pageSize, @RequestBody MemberCardUseRange memberCardUseRange);
}