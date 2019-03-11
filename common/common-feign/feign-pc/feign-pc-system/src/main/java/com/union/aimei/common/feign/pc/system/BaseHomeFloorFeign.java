package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseHomeFloorApiHystrix;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 楼层管理表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@FeignClient(serviceId = "pc-system-service", fallback = BaseHomeFloorApiHystrix.class)
public interface BaseHomeFloorFeign {
    /**
     * 添加楼层管理表
     *
     * @param baseHomeFloor
     * @return
     */
    @PostMapping(value = "/baseHomeFloor/insert")
    int insert(@RequestBody BaseHomeFloor baseHomeFloor);

    /**
     * 删除楼层管理表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/baseHomeFloor/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改楼层管理表
     *
     * @param baseHomeFloor
     * @return
     */
    @PutMapping(value = "/baseHomeFloor/edit")
    int edit(@RequestBody BaseHomeFloor baseHomeFloor);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeFloor
     */
    @GetMapping(value = "/baseHomeFloor/queryById/{id}")
    BaseHomeFloor queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询楼层管理表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param baseHomeFloor 查询条件
     * @return
     */
    @PostMapping(value = "/baseHomeFloor/front/findByPage")
    PageInfo<BaseHomeFloor> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                       Integer pageSize, @RequestBody BaseHomeFloor baseHomeFloor);

    /**
     * 根据条件删除数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    @PostMapping("/baseHomeFloor/1.1.0/deleteByFront")
    ResponseMessage deleteByFrontV110(@RequestBody BaseHomeFloor baseHomeFloor);


    /**
     * 批量添加数据(v1.1.0)
     *
     * @param list
     * @return
     */
    @PostMapping("/baseHomeFloor/1.1.0/addBatch")
    ResponseMessage<List<BaseHomeFloor>> addBatchV110(@RequestBody List<BaseHomeFloor> list);

    /**
     * 根据条件获取列表数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    @PostMapping("/baseHomeFloor/1.1.0/findForFront")
    ResponseMessage<List<BaseHomeFloor>> findForFrontV110(@RequestBody BaseHomeFloor baseHomeFloor);

    /**
     * 获取模版页面的楼层数据(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @PostMapping("/baseHomeFloor/1.1.0/findPageFloorDate")
    ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);

    /**
     * 批量更新数据(v1.1.0)
     *
     * @param baseHomeFloorList 更新的数据
     * @return
     */
    @PutMapping("/baseHomeFloor/1.1.0/editBatch/{cityId}")
    ResponseMessage<List<BaseHomeFloor>> editBatchV110(@RequestBody List<BaseHomeFloor> baseHomeFloorList);

    /**
     * 添加模版楼层数据(v1.1.0)
     *
     * @param baseHomeFloorVo
     * @return
     */
    @PostMapping("/baseHomeFloor/1.1.0/floorDateInsertUpdate")
    ResponseMessage<List<BaseHomeFloor>> floorDateInsertV110(@RequestBody BaseHomeFloorVo baseHomeFloorVo);
}