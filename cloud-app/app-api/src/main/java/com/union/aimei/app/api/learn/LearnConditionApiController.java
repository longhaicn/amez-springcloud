package com.union.aimei.app.api.learn;

import com.union.aimei.common.feign.app.learn.LearnConditionFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "门槛条件表")
@RestController
@RequestMapping(value = "learnCondition")
public class LearnConditionApiController {

    @Resource
    private LearnConditionFeign learnConditionFeign;

    /**
     * 校验活动或课程的报名提交v1.1.1
     *
     * @param targetId   对象id（美容师id、店铺id）
     * @param sourceId   来源id（课程、活动）
     * @param sourceType 来源类型（0-课程、1-活动）
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "校验活动或课程的报名提交v1.1.0")
    @GetMapping("/1.1.1/checkConditionBeautician/{targetId}/{sourceId}/{sourceType}")
    public ResponseMessage checkConditionBeauticianV111(@ApiParam(value = "对象id（美容师id、店铺id）") @PathVariable(value = "targetId") int targetId,
                                                        @ApiParam(value = "来源id（课程、活动）") @PathVariable(value = "sourceId") int sourceId,
                                                        @ApiParam(value = "来源类型 0-课程 1-活动(美容师) 2-(店铺)") @PathVariable(value = "sourceType") byte sourceType) {
        return this.learnConditionFeign.checkConditionBeauticianV111(targetId, sourceId, sourceType);
    }


}