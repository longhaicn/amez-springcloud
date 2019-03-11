package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseHomeFloorListApiHystrix;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 楼层列表数据表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@FeignClient(serviceId = "pc-system-service", fallback = BaseHomeFloorListApiHystrix.class)
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
     * @param floorId
     * @return
     */
    @PostMapping("/baseHomeFloorList/1.1.0/findByVoPageForFront/{floorId}")
    ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @PathVariable(value = "floorId") Integer floorId);

    /**
     * 根据floorId更新数据(v1.1.0)
     *
     * @param baseHomeFloorList
     * @return
     */
    @PutMapping("/baseHomeFloorList/1.1.0/updateByFloorId")
    ResponseMessage updateByFloorIdV110(@RequestBody BaseHomeFloorList baseHomeFloorList);

    /**
     * 批量添加楼层商品数据(v1.1.0)
     *
     * @param baseHomeFloorListList
     * @return
     */
    @PostMapping("/baseHomeFloorList/1.1.0/addBatch")
    ResponseMessage addBatchV110(@ApiParam(value = "数据") @RequestBody List<BaseHomeFloorList> baseHomeFloorListList);

    /**
     * 根据楼层id获取已选择的产品(v1.1.0)
     * @param floorId
     * @param productType
     * @return
     */
    @PostMapping("/baseHomeFloorList/1.1.0/findByFloorId/{floorId}/{productType}")
    ResponseMessage<List<BaseHomeFloorList>> findByFloorIdV110(@PathVariable(value = "floorId") int floorId,
                                                               @PathVariable(value = "productType") int productType);
}