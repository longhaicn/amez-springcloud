package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.PhysicalFreightTemplateRefApiHystrix;
import com.union.aimei.common.model.product.PhysicalFreightTemplateRef;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 16:53
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = PhysicalFreightTemplateRefApiHystrix.class)
public interface PhysicalFreightTemplateRefFeign {
    /**
     * 添加产品-运费模板-关联
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @PostMapping(value = "/physicalFreightTemplateRef/insert")
    int insert(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef);

    /**
     * 删除产品-运费模板-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/physicalFreightTemplateRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改产品-运费模板-关联
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @PutMapping(value = "/physicalFreightTemplateRef/edit")
    int edit(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalFreightTemplateRef
     */
    @GetMapping(value = "/physicalFreightTemplateRef/queryById/{id}")
    PhysicalFreightTemplateRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询产品-运费模板-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param physicalFreightTemplateRef 查询条件
     * @return
     */
    @PostMapping(value = "/physicalFreightTemplateRef/front/findByPage")
    ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             @RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef);

    /**
     * 添加
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @PostMapping("/physicalFreightTemplateRef/add")
    ResponseMessage add(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef);

}