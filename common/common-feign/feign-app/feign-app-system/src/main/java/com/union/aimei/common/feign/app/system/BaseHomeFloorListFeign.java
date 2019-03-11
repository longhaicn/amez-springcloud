package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseHomeFloorListApiHystrix;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 楼层列表数据表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@FeignClient(serviceId = "app-system-service", fallback = BaseHomeFloorListApiHystrix.class)
public interface BaseHomeFloorListFeign {
    /**
     * 添加楼层列表数据表
     *
     * @param baseHomeFloorList
     * @return
     */
    @PostMapping(value = "/baseHomeFloorList/insert")
    int insert(@RequestBody BaseHomeFloorList baseHomeFloorList);

    /**
     * 删除楼层列表数据表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/baseHomeFloorList/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改楼层列表数据表
     *
     * @param baseHomeFloorList
     * @return
     */
    @PutMapping(value = "/baseHomeFloorList/edit")
    int edit(@RequestBody BaseHomeFloorList baseHomeFloorList);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeFloorList
     */
    @GetMapping(value = "/baseHomeFloorList/queryById/{id}")
    BaseHomeFloorList queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询楼层列表数据表
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param baseHomeFloorList 查询条件
     * @return
     */
    @PostMapping(value = "/baseHomeFloorList/front/findByPage")
    PageInfo<BaseHomeFloorList> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                           Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                           Integer pageSize, @RequestBody BaseHomeFloorList baseHomeFloorList);

    /**
     * 获取 BaseHomeFloorListVo 分页列表数据
     *
     * @param pageNo
     * @param pageSize
     * @param baseHomeFloorListVo
     * @return
     */
    @PostMapping("/baseHomeFloorList/1.1.0/findByVoPageForFront")
    ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @RequestBody BaseHomeFloorListVo baseHomeFloorListVo);

}