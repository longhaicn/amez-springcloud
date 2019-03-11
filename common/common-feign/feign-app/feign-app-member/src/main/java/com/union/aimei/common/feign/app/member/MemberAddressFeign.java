package com.union.aimei.common.feign.app.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberAddressApiHystrix;
import com.union.aimei.common.model.member.MemberAddress;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/8,10:37
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberAddressApiHystrix.class)
public interface MemberAddressFeign {
    /**
     * 添加会员地址
     *
     * @param memberAddress
     * @return
     */
    @PostMapping(value = "/memberAddress/insert")
    int insert(@RequestBody MemberAddress memberAddress);

    /**
     * 删除会员地址
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/memberAddress/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改会员地址
     *
     * @param memberAddress
     * @return
     */
    @PutMapping(value = "/memberAddress/edit")
    int edit(@RequestBody MemberAddress memberAddress);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberAddress
     */
    @GetMapping(value = "/memberAddress/queryById/{id}")
    MemberAddress queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询会员地址
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param memberAddress 查询条件
     * @return
     */
    @PostMapping(value = "/memberAddress/front/findByPage")
    PageInfo<MemberAddress> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                       Integer pageSize, @RequestBody MemberAddress memberAddress);

    /**
     * 设置默认地址值
     *
     * @param memberAddress
     * @return
     */
    @PutMapping("/memberAddress/setDefalutAddress")
    int setDefaultAddress(@RequestBody MemberAddress memberAddress);


}