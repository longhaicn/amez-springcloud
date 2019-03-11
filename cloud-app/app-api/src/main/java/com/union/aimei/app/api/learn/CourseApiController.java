package com.union.aimei.app.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.CourseFeign;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "课程表")
@RestController
@RequestMapping(value = "course")
public class CourseApiController {

    @Resource
    private CourseFeign courseFeign;

    /**
     * 根据ID查询课程(1.1.0)
     *
     * @param id
     * @returncourse
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询课程表(1.1.0)")
    @GetMapping("/1.1.0/queryById/{id}")
    public ResponseMessage<Course> queryByIdV110(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        Course model = this.courseFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }


    /**
     * 分页查询(1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return ResponseMessage<Course>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询课程表(1.1.0)")
    @PostMapping("/1.1.0/front/findByPage")
    public ResponseMessage<Course> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                  Integer pageSize, @ApiParam(value = "查询条件") @RequestBody Course course) {
        ResponseMessage result = new ResponseMessage();
        PageInfo<Course> page = courseFeign.findByPageForFrontV110(pageNo, pageSize, course);
        if (page == null) {
            throw new ServerException(ResponseContants.QUERY_EMPTY, ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        result.setData(page);
        return result;
    }


    /**
     * 查询培训课程列表(1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页数量
     * @param courseParamVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询培训课程列表(1.1.0)")
    @PostMapping("/1.1.0/selectCourseListByBeautic")
    public ResponseMessage<PageInfo<CourseResultVo>> selectCourseListByBeauticV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseParamVo courseParamVo) {
        return this.courseFeign.selectCourseListByBeauticV110(pageNo, pageSize, courseParamVo);
    }

    /**
     * 根据courseId、美容师id查询课程详情(1.1.0)
     *
     * @param id
     * @param beauticianId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据courseId、美容师id查询课程详情(1.1.0)")
    @GetMapping("/1.1.0/queryCourseResultVoById/{id}/{beauticianId}")
    public ResponseMessage<CourseResultVo> selectByCourseIdV110(@PathVariable(value = "id") int id,
                                                                @PathVariable(value = "beauticianId") int beauticianId) {
        return this.courseFeign.selectByCourseIdV110(id, beauticianId);
    }

    /**
     * 测试接口超时
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "测试接口超时")
    @GetMapping("/testSleep")
    public ResponseMessage testSleep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseMessage<>();
    }


}