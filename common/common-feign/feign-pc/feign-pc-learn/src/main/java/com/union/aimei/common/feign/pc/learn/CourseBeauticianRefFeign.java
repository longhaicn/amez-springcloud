package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.CourseBeauticianRefApiHystrix;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByCourseVo;
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
@FeignClient(serviceId = "PC-LEARN-SERVICE", fallback = CourseBeauticianRefApiHystrix.class)
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
    PageInfo<CourseBeauticianRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestBody CourseBeauticianRef courseBeauticianRef);

    /**
     * 根据条件筛选课程-美容师-关联表(v1.1.0)
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param beauticianParamVo 查询条件
     * @return
     */
    @PostMapping("/courseBeauticianRef/1.1.0/findByPageForFrontV110")
    ResponseMessage<PageInfo<CourseBeauticianRef>> findByPageForFrontV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                          @RequestBody BeauticianParamVo beauticianParamVo);


    /**
     * 根据类型批量更新课程-美容师-关联表数据(v1.1.0)
     *
     * @param updateBeauticianVo
     * @return
     */
    @PostMapping("/courseBeauticianRef/1.1.0/batchUpdateByIdsType")
    ResponseMessage batchUpdateByIdsTypeV110(@RequestBody UpdateBeauticianVo updateBeauticianVo);

    /**
     * 查询已通过培训的美容师获取可开通的服务
     *
     * @return
     */
    @GetMapping("/courseBeauticianRef/selectBeauticianIsOpenService")
    ResponseMessage<List<ProductBeauticianRefByCourseVo>> selectBeauticianIsOpenService();
}