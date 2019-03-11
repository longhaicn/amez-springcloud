package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.CourseBeauticianRefApiHystrix;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程-美容师-关联
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId = "APP-LEARN-SERVICE", fallback = CourseBeauticianRefApiHystrix.class)
public interface CourseBeauticianRefFeign {
    /**
     * 添加课程-美容师-关联
     *
     * @param courseBeauticianRef
     * @return
     */
    @PostMapping(value = "/courseBeauticianRef/insert")
    int insert(@RequestBody CourseBeauticianRef courseBeauticianRef);

    /**
     * 删除课程-美容师-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/courseBeauticianRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改课程-美容师-关联
     *
     * @param courseBeauticianRef
     * @return
     */
    @PutMapping(value = "/courseBeauticianRef/edit")
    int edit(@RequestBody CourseBeauticianRef courseBeauticianRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseBeauticianRef
     */
    @GetMapping(value = "/courseBeauticianRef/queryById/{id}")
    CourseBeauticianRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询课程-美容师-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param courseBeauticianRef 查询条件
     * @return
     */
    @PostMapping(value = "/courseBeauticianRef/front/findByPage")
    PageInfo<CourseBeauticianRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                             Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                             Integer pageSize, @RequestBody CourseBeauticianRef courseBeauticianRef);


    /**
     * 根据条件查询美容师-课程集合数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    @PostMapping("/courseBeauticianRef/1.1.0/findByListForFront")
    ResponseMessage<List<CourseBeauticianRef>> findByListForFrontV110(@RequestBody CourseBeauticianRef courseBeauticianRef);

    /**
     * 根据条件查询美容师-课程 统计数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    @PostMapping("/courseBeauticianRef/1.1.0/findByCountForFront")
    ResponseMessage<Integer> findByCountForFrontV110(@RequestBody CourseBeauticianRef courseBeauticianRef);


    /**
     * 根据美容师id 跟课程id判断是否已报名(1.1.0)
     *
     * @param beauticianId 美容师id
     * @param courseId     课程id
     * @return
     */
    @GetMapping("/courseBeauticianRef/1.1.0/checkBeauticianOnly/{beauticianId}/{courseId}")
    ResponseMessage checkBeauticianOnlyV110(@PathVariable(value = "beauticianId") int beauticianId, @PathVariable(value = "courseId") int courseId);


    /**
     * 美容师报名课程的数据添加(1.1.0)
     *
     * @param courseBeauticianRefVo
     * @return
     */
    @PostMapping("/courseBeauticianRef/1.1.0/insertCourseBeauticianRef")
    ResponseMessage insertCourseBeauticianRefV110(@RequestBody CourseBeauticianRefVo courseBeauticianRefVo);


    /**
     * 查询美容师学习培训记录(v1.1.0)
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param beauticianId 美容师id
     * @return
     */
    @GetMapping("/courseBeauticianRef/1.1.0/findPageCourseBeauticianRef/{beauticianId}")
    ResponseMessage<PageInfo<CourseBeauticianRefResultVo>> findPageCourseBeauticianRefV110(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
                                                                                           @RequestParam(defaultValue = "10", value = "pageSize") int pageSize,
                                                                                           @PathVariable(value = "beauticianId") int beauticianId);


}

