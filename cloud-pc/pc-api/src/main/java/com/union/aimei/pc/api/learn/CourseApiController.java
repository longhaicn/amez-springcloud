package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.learn.LearnConstant;
import com.union.aimei.common.feign.pc.learn.CourseFeign;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.pc.CourseDataVo;
import com.union.aimei.common.vo.learn.pc.CourseDetailVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

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
        Course model = this.courseFeign.queryByIdV110(id);
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
    public ResponseMessage<Course> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @ApiParam(value = "查询条件") @RequestBody Course course) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<Course> page = courseFeign.findByPageForFrontV110(pageNo, pageSize, course);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }


    /**
     * 判断课程编号是否重复(1.1.0)
     *
     * @param courseCode 课程编号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "判断课程编号是否重复(1.1.0)")
    @GetMapping("/1.1.0/selectCountByCourseCode/{courseCode}")
    public ResponseMessage selectCountByCourseCodeV110(@ApiParam(value = "课程编号") @PathVariable(value = "courseCode") String courseCode) {
        return this.courseFeign.selectCountByCourseCodeV110(courseCode);
    }

    /**
     * 根据课程id与更新类型更新数据(1.1.0)
     *
     * @param courseId 课程id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据课程id与更新类型更新数据(1.1.0)")
    @GetMapping("/1.1.0/updateStatusEnabledById/{courseId}/{type}")
    public ResponseMessage updateStatusEnabledByIdV110(@ApiParam(value = "课程id") @PathVariable(value = "courseId") Integer courseId,
                                                       @ApiParam(value = "更新类型，1删除 2非删除 3未发布 4已发布 5撤回") @PathVariable(value = "type") Integer type) {
        return this.courseFeign.updateStatusEnabledByIdV110(courseId, type);
    }


    /**
     * 根据条件查询课程列表 (1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param courseParamVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "课程列表(1.1.0)")
    @PostMapping("/1.1.0/selectPageByCourseV110")
    public ResponseMessage<PageInfo<Course>> selectPageByCourseV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @ApiParam(value = "查询条件") @RequestBody CourseParamVo courseParamVo) {
        return this.courseFeign.selectPageByCourseV110(pageNo, pageSize, courseParamVo);
    }


    /**
     * 根据courseId查询课程详情(1.1.0)
     *
     * @param courseId 课程id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据courseId查询课程详情(1.1.0)")
    @GetMapping("/1.1.0/queryBySourceId/{courseId}")
    public ResponseMessage<CourseDetailVo> selectCourseDetailByIdV110(@PathVariable(value = "courseId") int courseId) {
        return this.courseFeign.selectCourseDetailByIdV110(courseId);
    }

    /**
     * 发布课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发布课程(1.1.0)")
    @PostMapping("/1.1.0/insertCourse")
    public ResponseMessage insertCourseV110(@RequestBody CourseDataVo courseDataVo) {
        Optional.ofNullable(courseDataVo).filter(x -> x.getCourse().getProvinceId() != null && x.getCourse().getProvinceId() != 0).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_PROVINCE));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getProvinceName())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_PROVINCE));
        Optional.ofNullable(courseDataVo).filter(x -> x.getCourse().getCityId() != null && x.getCourse().getCityId() != 0).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_CITY));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getCityName())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_CITY));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getAreaName())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_AREA));
        Optional.ofNullable(courseDataVo).filter(x -> x.getCourse().getAreaId() != null && x.getCourse().getAreaId() != 0).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_AREA));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getStoreAddress())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_DETAIL_ADDRESS));
        return this.courseFeign.insertCourseV110(courseDataVo);
    }


    /**
     * 修改课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改课程(1.1.0)")
    @PostMapping("/1.1.0/editCourseV110")
    public ResponseMessage editCourseV110(@RequestBody CourseDataVo courseDataVo) {
        Optional.ofNullable(courseDataVo).filter(x -> x.getCourse().getProvinceId() != null && x.getCourse().getProvinceId() != 0).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_PROVINCE));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getProvinceName())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_PROVINCE));
        Optional.ofNullable(courseDataVo).filter(x -> x.getCourse().getCityId() != null && x.getCourse().getCityId() != 0).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_CITY));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getCityName())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_CITY));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getAreaName())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_AREA));
        Optional.ofNullable(courseDataVo).filter(x -> x.getCourse().getAreaId() != null && x.getCourse().getAreaId() != 0).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_AREA));
        Optional.ofNullable(courseDataVo).filter(x -> StringUtils.isNotEmpty(x.getCourse().getStoreAddress())).orElseThrow(() -> new ServerException(LearnConstant.ERROR_CODE_NOT_PARAM, LearnConstant.Insert.NOT_DETAIL_ADDRESS));
        return this.courseFeign.editCourseV110(courseDataVo);
    }


}