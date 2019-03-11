package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.BeauticianFollowerFeign;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

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
public class BeauticianFollowerApiController {
    @Resource
    private BeauticianFollowerFeign beauticianFollowerFeign;

    /**
     * 关注美容师
     *
     * @param beauticianFollower
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "关注美容师", notes = "{\n" +
            "  \"beauticianId\": 655,\n" +
            "  \"isFollower\": true,\n" +
            "  \"memberId\": 655\n" +
            "}")
    @PostMapping("/1.1.1/follower")
    public ResponseMessage followerV111(@ApiParam(value = "数据") @RequestBody BeauticianFollower beauticianFollower) {
        Optional.of(beauticianFollower)
                .filter(vo -> vo.getMemberId() != null)
                .filter(vo -> vo.getBeauticianId() != null)
                .filter(vo -> vo.getIsFollower() != null)
                .orElseThrow(() -> new ClientException(500, "必传参数缺失，请仔细检查"));
        return this.beauticianFollowerFeign.followerV111(beauticianFollower);
    }

}