package com.union.aimei.common.feign.app.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.umeng.hystrix.BaseMemberDeviceApiHystrix;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId = "APP-UMENG-SERVICE", fallback = BaseMemberDeviceApiHystrix.class)
public interface BaseMemberDeviceFeign {
    /**
     * 添加会员设备码表
     *
     * @param baseMemberDevice
     * @return
     */
    @PostMapping(value = "/baseMemberDevice/insert")
    int insert(@RequestBody BaseMemberDevice baseMemberDevice);

    /**
     * 删除会员设备码表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/baseMemberDevice/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改会员设备码表
     *
     * @param baseMemberDevice
     * @return
     */
    @PutMapping(value = "/baseMemberDevice/edit")
    int edit(@RequestBody BaseMemberDevice baseMemberDevice);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseMemberDevice
     */
    @GetMapping(value = "/baseMemberDevice/queryById/{id}")
    BaseMemberDevice queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询会员设备码表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseMemberDevice 查询条件
     * @return
     */
    @PostMapping(value = "/baseMemberDevice/front/findByPage")
    PageInfo<BaseMemberDevice> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                          Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                          Integer pageSize, @RequestBody BaseMemberDevice baseMemberDevice);

    /**
     * 查询会员设备码
     *
     * @param baseMemberDevice
     * @return
     */
    @PostMapping("/baseMemberDevice/queryByInfo")
    ResponseMessage queryByInfo(@RequestBody BaseMemberDevice baseMemberDevice);
    
}