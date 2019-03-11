package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseBeauticianRefFeign;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
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
@Api(tags = "课程-美容师-关联")
@RestController
@RequestMapping(value = "courseBeauticianRef")
public class CourseBeauticianRefApiController {


    @Resource
    private CourseBeauticianRefFeign courseBeauticianRefFeign;


    /**
     * 分页查询
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param courseBeauticianRef 查询条件
     * @return ResponseMessage<CourseBeauticianRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询课程-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<CourseBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseBeauticianRef courseBeauticianRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<CourseBeauticianRef> page = courseBeauticianRefFeign.findByPageForFront(pageNo, pageSize, courseBeauticianRef);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加CourseBeauticianRef
     *
     * @param courseBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加课程-美容师-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody CourseBeauticianRef courseBeauticianRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseBeauticianRefFeign.insert(courseBeauticianRef);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除CourseBeauticianRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除课程-美容师-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseBeauticianRefFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改CourseBeauticianRef
     *
     * @param courseBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑课程-美容师-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody CourseBeauticianRef courseBeauticianRef) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.courseBeauticianRefFeign.edit(courseBeauticianRef);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询CourseBeauticianRef
     *
     * @param id
     * @returncourseBeauticianRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询课程-美容师-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<CourseBeauticianRef> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        CourseBeauticianRef model = this.courseBeauticianRefFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }

    /**
     * 根据条件筛选课程-美容师-关联表(v1.1.0)
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param beauticianParamVo 查询条件
     * @return
     */
    @PostMapping("/1.1.0/findByPageForFrontV110")
    @ApiOperation(httpMethod = "POST", value = "根据条件筛选课程-美容师-关联表(v1.1.0)")
    public ResponseMessage<PageInfo<CourseBeauticianRef>> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                 @ApiParam(value = "查询条件") @RequestBody BeauticianParamVo beauticianParamVo) {
        return this.courseBeauticianRefFeign.findByPageForFrontV110(pageNo, pageSize, beauticianParamVo);
    }


    /**
     * 根据类型批量更新课程-美容师-关联表数据(v1.1.0)
     *
     * @param updateBeauticianVo
     * @return
     */
    @PostMapping("/1.1.0/batchUpdateByIdsType")
    @ApiOperation(httpMethod = "POST", value = "根据类型批量更新课程-美容师-关联表数据(v1.1.0)")
    public ResponseMessage batchUpdateByIdsTypeV110(@RequestBody UpdateBeauticianVo updateBeauticianVo) {
        return this.courseBeauticianRefFeign.batchUpdateByIdsTypeV110(updateBeauticianVo);
    }

}