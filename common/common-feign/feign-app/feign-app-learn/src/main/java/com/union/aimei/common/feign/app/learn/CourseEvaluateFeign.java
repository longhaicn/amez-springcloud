package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.CourseEvaluateApiHystrix;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.aimei.common.vo.learn.app.CourseEvaluateResultVo;
import com.union.aimei.common.vo.learn.app.CourseEvaluateVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 课程试题
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId = "APP-LEARN-SERVICE", fallback = CourseEvaluateApiHystrix.class)
public interface CourseEvaluateFeign {
    /**
     * 添加课程试题
     *
     * @param courseEvaluate
     * @return
     */
    @PostMapping(value = "/courseEvaluate/insert")
    int insert(@RequestBody CourseEvaluate courseEvaluate);

    /**
     * 删除课程试题
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/courseEvaluate/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改课程试题
     *
     * @param courseEvaluate
     * @return
     */
    @PutMapping(value = "/courseEvaluate/edit")
    int edit(@RequestBody CourseEvaluate courseEvaluate);

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseEvaluate
     */
    @GetMapping(value = "/courseEvaluate/queryById/{id}")
    CourseEvaluate queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询课程试题
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param courseEvaluate 查询条件
     * @return
     */
    @PostMapping(value = "/courseEvaluate/1.1.0/front/findByPage")
    PageInfo<CourseEvaluateResultVo> findByPageForFrontV110(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @RequestBody CourseEvaluate courseEvaluate);

    /**
     * 提交评测答案(v1.1.0)
     *
     * @param courseEvaluateVo
     * @return
     */
    @PostMapping("/courseEvaluate/1.1.0/checkEvaluateByAnswer")
    ResponseMessage<CourseBeauticianRefVo> checkEvaluateByAnswerV110(@RequestBody CourseEvaluateVo courseEvaluateVo);
}