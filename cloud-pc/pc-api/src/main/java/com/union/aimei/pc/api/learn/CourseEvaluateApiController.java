package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseEvaluateFeign;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "课程试题")
@RestController
@RequestMapping(value = "courseEvaluate")
public class CourseEvaluateApiController {

    @Resource
    private CourseEvaluateFeign courseEvaluateFeign;


    /**
     * 前端分页查询课程试题(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param courseEvaluate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询课程试题(v1.1.0)")
    @PostMapping("/1.1.0/front/findByPage")
    public ResponseMessage<CourseEvaluate> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                          Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                          Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseEvaluate courseEvaluate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<CourseEvaluate> page = courseEvaluateFeign.findByPageForFront(pageNo, pageSize, courseEvaluate);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加CourseEvaluate
     *
     * @param courseEvaluate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加课程试题")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody CourseEvaluate courseEvaluate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseEvaluateFeign.insert(courseEvaluate);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除CourseEvaluate
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除课程试题")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseEvaluateFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改CourseEvaluate
     *
     * @param courseEvaluate
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑课程试题")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody CourseEvaluate courseEvaluate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseEvaluateFeign.edit(courseEvaluate);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询CourseEvaluate
     *
     * @param id
     * @returncourseEvaluate
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询课程试题")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<CourseEvaluate> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        CourseEvaluate model = this.courseEvaluateFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}