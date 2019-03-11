package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.FreightTemplateCityApiHystrix;
import com.union.aimei.common.model.product.FreightTemplateCity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:53
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = FreightTemplateCityApiHystrix.class)
public interface FreightTemplateCityFeign {
    /**
     * 添加运费模板城市
     *
     * @param freightTemplateCity
     * @return
     */
    @PostMapping(value = "/freightTemplateCity/insert")
    int insert(@RequestBody FreightTemplateCity freightTemplateCity);

    /**
     * 删除运费模板城市
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/freightTemplateCity/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改运费模板城市
     *
     * @param freightTemplateCity
     * @return
     */
    @PutMapping(value = "/freightTemplateCity/edit")
    int edit(@RequestBody FreightTemplateCity freightTemplateCity);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnfreightTemplateCity
     */
    @GetMapping(value = "/freightTemplateCity/queryById/{id}")
    FreightTemplateCity queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询运费模板城市
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param freightTemplateCity 查询条件
     * @return
     */
    @PostMapping(value = "/freightTemplateCity/front/findByPage")
    PageInfo<FreightTemplateCity> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestBody FreightTemplateCity freightTemplateCity);
}