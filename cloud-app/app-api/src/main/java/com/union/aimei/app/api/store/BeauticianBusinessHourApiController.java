package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.BeauticianBusinessHourFeign;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByAddVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:07
 */
@Api(tags = "美容师营业时间")
@RestController
@RequestMapping(value = "beauticianBusinessHour")
public class BeauticianBusinessHourApiController {
    @Resource
    private BeauticianBusinessHourFeign beauticianBusinessHourFeign;

    /**
     * 新增美容师营业时间（美容师-我的-服务设置-营业时间）
     *
     * @param addVo 新增条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师营业时间（美容师-我的-服务设置-营业时间）")
    @PostMapping("/1.1.1/add")
    public ResponseMessage addV111(@ApiParam(value = "新增条件") @RequestBody BeauticianBusinessHourByAddVo addVo) {
        return this.beauticianBusinessHourFeign.addV111(addVo);
    }

}