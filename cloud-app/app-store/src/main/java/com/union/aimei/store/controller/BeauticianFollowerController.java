package com.union.aimei.store.controller;

import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.aimei.store.service.BeauticianFollowerService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 美容师粉丝
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "美容师粉丝")
@RestController
@RequestMapping(value = "beauticianFollower")
public class BeauticianFollowerController {
    @Resource
    private BeauticianFollowerService beauticianFollowerService;


    /**
     * 关注美容师
     *
     * @param follower 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "关注美容师")
    @PostMapping("/1.1.1/follower")
    public ResponseMessage followerV111(@ApiParam(value = "条件") @RequestBody BeauticianFollower follower) {
        return this.beauticianFollowerService.followerV111(follower);
    }

}