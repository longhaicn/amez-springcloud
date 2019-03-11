package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseProductRefFeign;
import com.union.aimei.common.model.learn.CourseProductRef;
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
@Api(tags = "课程适用的服务表")
@RestController
@RequestMapping(value = "courseProductRef")
public class CourseProductRefApiController {

    @Resource
    private CourseProductRefFeign courseProductRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param courseProductRef 查询条件
     * @return ResponseMessage<CourseProductRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询课程适用的服务表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<CourseProductRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                        Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                        Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseProductRef courseProductRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<CourseProductRef> page = this.courseProductRefFeign.findByPageForFront(pageNo, pageSize, courseProductRef);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加CourseProductRef
     *
     * @param courseProductRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加课程适用的服务表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody CourseProductRef courseProductRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseProductRefFeign.insert(courseProductRef);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除CourseProductRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除课程适用的服务表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseProductRefFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改CourseProductRef
     *
     * @param courseProductRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑课程适用的服务表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody CourseProductRef courseProductRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseProductRefFeign.edit(courseProductRef);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询CourseProductRef
     *
     * @param id
     * @returncourseProductRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询课程适用的服务表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<CourseProductRef> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        CourseProductRef model = this.courseProductRefFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}