package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.LearnConditionApiHystrix;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.app.CheckConditionVo;
import com.union.aimei.common.vo.learn.app.LearnAuthorityVo;
import com.union.aimei.common.vo.learn.app.LearnBeforeVo;
import com.union.aimei.common.vo.learn.app.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门槛条件表
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId = "APP-LEARN-SERVICE", fallback = LearnConditionApiHystrix.class)
public interface LearnConditionFeign {
    /**
     * 添加门槛条件表
     *
     * @param learnCondition
     * @return
     */
    @PostMapping(value = "/learnCondition/insert")
    int insert(@RequestBody LearnCondition learnCondition);

    /**
     * 删除门槛条件表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/learnCondition/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改门槛条件表
     *
     * @param learnCondition
     * @return
     */
    @PutMapping(value = "/learnCondition/edit")
    int edit(@RequestBody LearnCondition learnCondition);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnCondition
     */
    @GetMapping(value = "/learnCondition/queryById/{id}")
    LearnCondition queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询门槛条件表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param learnCondition 查询条件
     * @return
     */
    @PostMapping(value = "/learnCondition/front/findByPage")
    PageInfo<LearnCondition> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                        Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                        Integer pageSize, @RequestBody LearnCondition learnCondition);

    /**
     * 根据条件获取门槛条件(V1.1.0)
     *
     * @param learnCondition
     * @return
     */
    @PostMapping("/learnCondition/1.1.0/findByListForFrontV110")
    ResponseMessage<List<LearnCondition>> findByListForFrontV110(@RequestBody LearnCondition learnCondition);


    /**
     * 将后台learnConditionList数据转化 为 LearnConditionVoList实体类(v1.1.0)
     *
     * @param learnConditionList
     * @return
     */
    @PostMapping("/learnCondition/1.1.0/setLearnConditionVoList")
    ResponseMessage<List<LearnConditionVo>> setLearnConditionVoListV110(@RequestBody List<LearnCondition> learnConditionList);

    /**
     * 将前台定义传递的数据 转换为 learnCondition 实体类(v1.1.0)
     *
     * @param learnConditionVoList
     * @return
     */
    @PostMapping("/learnCondition/1.1.0/setLearnConditionList")
    ResponseMessage<List<LearnCondition>> setLearnConditionListV110(@RequestBody List<LearnConditionVo> learnConditionVoList);

    /**
     * 根据美容师、店铺 数据以及门口数据 校验是否具备报名资格(v1.1.0)
     *
     * @param checkConditionVo
     * @return
     */
    @PostMapping("/learnCondition/1.1.0/checkConditionBeautician")
    ResponseMessage<LearnConditionMessageVo> checkConditionBeauticianV110(@RequestBody CheckConditionVo checkConditionVo);


    /**
     * 判断前置课程是否满足(v1.1.0)
     *
     * @param learnBeforeVo
     * @return
     */
    @PostMapping("/learnCondition/1.1.0/learnBeforePermission")
    ResponseMessage<LearnConditionMessageVo> learnBeforePermissionV110(@RequestBody LearnBeforeVo learnBeforeVo);

    /**
     * 查询美容师允许报名的课程(v1.1.0)
     *
     * @param learnAuthorityVo
     * @return
     */
    @PostMapping("/learnCondition/1.1.0/selectLearnCourseIdAuthority")
    ResponseMessage<List<Integer>> selectLearnCourseIdAuthorityV110(@RequestBody LearnAuthorityVo learnAuthorityVo);


    /**
     * 校验活动或课程的报名提交v1.1.1
     *
     * @param targetId   对象id（美容师id、店铺id）
     * @param sourceId   来源id（课程、活动）
     * @param sourceType 来源类型（0-课程、1-活动）
     * @return
     */
    @GetMapping("/learnCondition/1.1.1/checkConditionBeautician/{targetId}/{sourceId}/{sourceType}")
    ResponseMessage checkConditionBeauticianV111(@ApiParam(value = "对象id（美容师id、店铺id）") @PathVariable(value = "targetId") int targetId,
                                                 @ApiParam(value = "来源id（课程、活动）") @PathVariable(value = "sourceId") int sourceId,
                                                 @ApiParam(value = "来源类型 0-课程 1-活动(美容师) 2-(店铺)") @PathVariable(value = "sourceType") byte sourceType);
}