package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.CourseProductRefApiHystrix;
import com.union.aimei.common.model.learn.CourseProductRef;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 课程适用的服务表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId = "PC-LEARN-SERVICE", fallback = CourseProductRefApiHystrix.class)
public interface CourseProductRefFeign {
    /**
     * 添加课程适用的服务表
     *
     * @param courseProductRef
     * @return
     */
    @PostMapping(value = "/courseProductRef/insert")
    int insert(@RequestBody CourseProductRef courseProductRef);

    /**
     * 删除课程适用的服务表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/courseProductRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改课程适用的服务表
     *
     * @param courseProductRef
     * @return
     */
    @PutMapping(value = "/courseProductRef/edit")
    int edit(@RequestBody CourseProductRef courseProductRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseProductRef
     */
    @GetMapping(value = "/courseProductRef/queryById/{id}")
    CourseProductRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询课程适用的服务表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param courseProductRef 查询条件
     * @return
     */
    @PostMapping(value = "/courseProductRef/front/findByPage")
    PageInfo<CourseProductRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                          Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                          Integer pageSize, @RequestBody CourseProductRef courseProductRef);
}