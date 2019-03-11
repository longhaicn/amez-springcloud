package com.union.aimei.common.feign.app.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberLevelApiHystrix;
import com.union.aimei.common.model.member.MemberLevel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/8,10:37
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberLevelApiHystrix.class)
public interface MemberLevelFeign {
    /**
     * 添加会员级别
     *
     * @param memberLevel
     * @return
     */
    @PostMapping(value = "/memberLevel/insert")
    int insert(@RequestBody MemberLevel memberLevel);

    /**
     * 删除会员级别
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/memberLevel/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改会员级别
     *
     * @param memberLevel
     * @return
     */
    @PutMapping(value = "/memberLevel/edit")
    int edit(@RequestBody MemberLevel memberLevel);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberLevel
     */
    @GetMapping(value = "/memberLevel/queryById/{id}")
    MemberLevel queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询会员级别
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param memberLevel 查询条件
     * @return
     */
    @PostMapping(value = "/memberLevel/front/findByPage")
    PageInfo<MemberLevel> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody MemberLevel memberLevel);
}