package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.aimei.learn.service.CourseBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "课程-美容师-关联")
@RestController
@RequestMapping(value = "courseBeauticianRef")
public class CourseBeauticianRefController {
    @Resource
    private CourseBeauticianRefService courseBeauticianRefService;

    @PostMapping("/front/findByPage")
    public PageInfo<CourseBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseBeauticianRef courseBeauticianRef) {
        return this.courseBeauticianRefService.findByPageForFront(pageNo, pageSize, courseBeauticianRef);
    }

    @PostMapping("/insert")
    @Deprecated
    public int insert(@RequestBody CourseBeauticianRef courseBeauticianRef) {
        return this.courseBeauticianRefService.addObj(courseBeauticianRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.courseBeauticianRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody CourseBeauticianRef courseBeauticianRef) {
        return this.courseBeauticianRefService.modifyObj(courseBeauticianRef);
    }

    @GetMapping("/queryById/{id}")
    public CourseBeauticianRef queryById(@PathVariable(value = "id") int id) {
        return this.courseBeauticianRefService.queryObjById(id);
    }

    /**
     * 根据条件查询美容师-课程集合数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据条件查询美容师-课程集合数据(1.1.0)")
    @PostMapping("/1.1.0/findByListForFront")
    public ResponseMessage<List<CourseBeauticianRef>> findByListForFrontV110(@ApiParam(value = "查询条件") @RequestBody CourseBeauticianRef courseBeauticianRef) {
        return this.courseBeauticianRefService.findByListForFrontV110(courseBeauticianRef);
    }

    /**
     * 根据条件查询美容师-课程 统计数据(1.1.0)
     *
     * @param courseBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据条件查询美容师-课程 统计数据(1.1.0)")
    @PostMapping("/1.1.0/findByCountForFront")
    public ResponseMessage<Integer> findByCountForFrontV110(@ApiParam(value = "查询条件") @RequestBody CourseBeauticianRef courseBeauticianRef) {
        return this.courseBeauticianRefService.findByCountForFrontV110(courseBeauticianRef);
    }


    /**
     * 根据美容师id 跟课程id判断是否已报名(1.1.0)
     *
     * @param beauticianId 美容师id
     * @param courseId     课程id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师id 跟课程id判断是否已报名")
    @GetMapping("/1.1.0/checkBeauticianOnly/{beauticianId}/{courseId}")
    public ResponseMessage checkBeauticianOnlyV110(@ApiParam(value = "美容师id") @PathVariable(value = "beauticianId") int beauticianId,
                                                   @ApiParam(value = "课程id") @PathVariable(value = "courseId") int courseId) {
        return this.courseBeauticianRefService.checkBeauticianOnlyV110(beauticianId, courseId);
    }

    /**
     * 美容师报名课程的数据添加(1.1.0)
     *
     * @param courseBeauticianRefVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师报名课程的数据添加(1.1.0)")
    @PostMapping("/1.1.0/insertCourseBeauticianRef")
    public ResponseMessage insertCourseBeauticianRefV110(@ApiParam(value = "查询条件") @RequestBody CourseBeauticianRefVo courseBeauticianRefVo) {
        return this.courseBeauticianRefService.insertCourseBeauticianRefV110(courseBeauticianRefVo);
    }


    /**
     * 查询美容师学习培训记录(v1.1.0)
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param beauticianId 美容师id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询美容师学习培训记录(v1.1.0)")
    @GetMapping("/1.1.0/findPageCourseBeauticianRef/{beauticianId}")
    public ResponseMessage<PageInfo<CourseBeauticianRefResultVo>> findPageCourseBeauticianRefV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10", value = "pageSize") int pageSize,
                                                                                                  @ApiParam(value = "美容师id") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.courseBeauticianRefService.findPageCourseBeauticianRefV110(pageNo, pageSize, beauticianId);
    }


}