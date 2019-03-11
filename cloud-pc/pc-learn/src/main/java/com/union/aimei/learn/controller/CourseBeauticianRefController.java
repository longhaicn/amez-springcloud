package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByCourseVo;
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
        return this.courseBeauticianRefService.findByPageForFrontV110(pageNo, pageSize, beauticianParamVo);
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
        return this.courseBeauticianRefService.batchUpdateByIdsTypeV110(updateBeauticianVo);
    }

    /**
     * 查询已通过培训的美容师获取可开通的服务
     *
     * @return
     */
    @GetMapping("/selectBeauticianIsOpenService")
    @ApiOperation(httpMethod = "GET", value = "查询已通过培训的美容师获取可开通的服务")
    public ResponseMessage<List<ProductBeauticianRefByCourseVo>> selectBeauticianIsOpenService() {
        return this.courseBeauticianRefService.selectBeauticianIsOpenService();
    }

}