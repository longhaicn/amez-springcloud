package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.app.CheckConditionVo;
import com.union.aimei.common.vo.learn.app.LearnAuthorityVo;
import com.union.aimei.common.vo.learn.app.LearnBeforeVo;
import com.union.aimei.common.vo.learn.app.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.aimei.learn.service.LearnConditionService;
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
@Api(tags = "门槛条件表")
@RestController
@RequestMapping(value = "learnCondition")
public class LearnConditionController {
    @Resource
    private LearnConditionService learnConditionService;

    @PostMapping("/front/findByPage")
    public PageInfo<LearnCondition> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                               Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                               Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.findByPageForFront(pageNo, pageSize, learnCondition);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.addObj(learnCondition);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.learnConditionService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.modifyObj(learnCondition);
    }

    @GetMapping("/queryById/{id}")
    public LearnCondition queryById(@PathVariable(value = "id") int id) {
        return this.learnConditionService.queryObjById(id);
    }


    /**
     * 根据条件获取门槛条件(V1.1.0)
     *
     * @param learnCondition
     * @return
     */
    @PostMapping("/1.1.0/findByListForFrontV110")
    @ApiOperation(httpMethod = "POST", value = "根据条件获取门槛条件(V1.1.0)")
    public ResponseMessage<List<LearnCondition>> findByListForFrontV110(@RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.findByListForFrontV110(learnCondition);
    }


    /**
     * 将后台learnConditionList数据转化 为 LearnConditionVoList实体类(v1.1.0)
     *
     * @param learnConditionList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "将后台learnConditionList数据转化 为 LearnConditionVoList实体类(v1.1.0)")
    @PostMapping("/1.1.0/setLearnConditionVoList")
    public ResponseMessage<List<LearnConditionVo>> setLearnConditionVoListV110(@ApiParam(value = "参数") @RequestBody List<LearnCondition> learnConditionList) {
        return this.learnConditionService.setLearnConditionVoListV110(learnConditionList);
    }

    /**
     * 将前台定义传递的数据 转换为 learnCondition 实体类(v1.1.0)
     *
     * @param learnConditionVoList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "将前台定义传递的数据 转换为 learnCondition 实体类(v1.1.0)")
    @PostMapping("/1.1.0/setLearnConditionList")
    public ResponseMessage<List<LearnCondition>> setLearnConditionListV110(@ApiParam(value = "参数") @RequestBody List<LearnConditionVo> learnConditionVoList) {
        return this.learnConditionService.setLearnConditionListV110(learnConditionVoList);
    }

    /**
     * 根据美容师、店铺 数据以及门口数据 校验是否具备报名资格(v1.1.0)
     *
     * @param checkConditionVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据美容师、店铺 数据以及门口数据 校验是否具备报名资格(v1.1.0)")
    @PostMapping("/1.1.0/checkConditionBeautician")
    public ResponseMessage<LearnConditionMessageVo> checkConditionBeauticianV110(@ApiParam(value = "参数") @RequestBody CheckConditionVo checkConditionVo) {
        return this.learnConditionService.checkConditionBeauticianV110(checkConditionVo);
    }


    /**
     * 判断前置课程是否满足(v1.1.0)
     *
     * @param learnBeforeVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "判断前置课程是否满足(v1.1.0)")
    @PostMapping("/1.1.0/learnBeforePermission")
    public ResponseMessage<LearnConditionMessageVo> learnBeforePermissionV110(@ApiParam(value = "参数") @RequestBody LearnBeforeVo learnBeforeVo) {
        return this.learnConditionService.learnBeforePermissionV110(learnBeforeVo);
    }

    /**
     * 查询美容师允许报名的课程id(v1.1.0)
     *
     * @param learnAuthorityVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询美容师允许报名的课程id(v1.1.0)")
    @PostMapping("/1.1.0/selectLearnCourseIdAuthority")
    public ResponseMessage<List<Integer>> selectLearnCourseIdAuthorityV110(@ApiParam(value = "参数") @RequestBody LearnAuthorityVo learnAuthorityVo) {
        return this.learnConditionService.selectLearnCourseIdAuthorityV110(learnAuthorityVo);
    }

    /**
     * 校验活动或课程的报名提交v1.1.1
     *
     * @param targetId   对象id（美容师id、店铺id）
     * @param sourceId   来源id（课程、活动）
     * @param sourceType 来源类型（0-课程、1-活动）
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "校验活动或课程的报名提交v1.1.1")
    @GetMapping("/1.1.1/checkConditionBeautician/{targetId}/{sourceId}/{sourceType}")
    public ResponseMessage checkConditionBeauticianV111(@ApiParam(value = "对象id（美容师id、店铺id）") @PathVariable(value = "targetId") int targetId,
                                                        @ApiParam(value = "来源id（课程、活动）") @PathVariable(value = "sourceId") int sourceId,
                                                        @ApiParam(value = "来源类型 0-课程 1-活动(美容师) 2-(店铺)") @PathVariable(value = "sourceType") byte sourceType) {
        return this.learnConditionService.checkConditionBeauticianV111(targetId, sourceId, sourceType);
    }


}