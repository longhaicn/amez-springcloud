package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeTemplateFeign;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.util.system.BaseHomeTemplateUtil;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 首页模板(净化版接口)
 *
 * @author caizhaoming
 * @time 2018/08/20 19:31
 */
@Api(tags = "首页模板(净化版接口)")
@RestController
@RequestMapping(value = "baseHomeTemplateData")
@CommonsLog
public class BaseHomeTemplateDataApiController {

    @Autowired
    private BaseHomeTemplateUtil baseHomeTemplateUtil;

    @Resource
    private BaseHomeTemplateFeign baseHomeTemplateFeign;

    /**
     * 获取模版页面的基础数据(v1.1.1)(get请求)
     *
     * @param cityId
     * @param useType
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "获取模版页面的基础数据(v1.1.1)(get请求)")
    @GetMapping("/1.1.1/getTemplateData")
    public ResponseMessage<BaseHomeTemplateRo> getTemplateDataV111(
            @ApiParam(value = "城市id", defaultValue = "0") @RequestParam(value = "cityId", defaultValue = "0") Integer cityId,
            @ApiParam(value = "使用类型 0-用户端，1-帮女郎，2-门店端") @RequestParam(value = "useType") Integer useType) {
        SelectBaseHomeTemplateVo selectBaseHomeTemplateVo = new SelectBaseHomeTemplateVo();
        BaseHomeArea baseHomeArea = new BaseHomeArea();
        baseHomeArea.setCityId(cityId);
        selectBaseHomeTemplateVo.setUseType(useType);
        selectBaseHomeTemplateVo.setBaseHomeArea(baseHomeArea);
        BaseHomeTemplateRo baseHomeTemplateRo = null;
        try {
            log.info("--------------- redis get data start --------------- ");
            long start = System.currentTimeMillis();
            baseHomeTemplateRo = this.baseHomeTemplateUtil.getBaseHomeTemplateByRedis(selectBaseHomeTemplateVo);
            long end = System.currentTimeMillis();
            log.info("get data total time = " + (end - start));
            log.info("--------------- redis get data end --------------- ");
        } catch (Exception e) {
            log.info("获取首页基本数据时，redis异常。", e);
        }
        if (null == baseHomeTemplateRo) {
            try {
                return this.baseHomeTemplateFeign.getTemplateDateV111(selectBaseHomeTemplateVo);
            } catch (Exception e) {
                log.info("获取首页基本数据是，下层异常。", e);
            }
        }
        return new ResponseMessage<>(baseHomeTemplateRo);
    }

    /**
     * 获取模版页面的楼层数据(v1.1.1)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param cityId   城市id
     */
    @ApiOperation(httpMethod = "GET", value = "获取模版页面的楼层数据(v1.1.1)")
    @GetMapping("/1.1.1/findPageFloorData")
    public ResponseMessage<PageInfo<BaseHomeFloorPageRo>> findPageFloorDataV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @ApiParam(value = "城市id", defaultValue = "0") @RequestParam(value = "cityId", defaultValue = "0") Integer cityId) {
        log.info("--------------- mongo get data start --------------- ");
        Long start = System.currentTimeMillis();
        PageInfo<BaseHomeFloorPageRo> page = this.baseHomeTemplateUtil.getBaseHomeFloorDataByMongo(pageNo, pageSize, cityId);
        Long end = System.currentTimeMillis();
        log.info("get data total time = " + (end - start));
        log.info("--------------- mongo get data end --------------- ");
        return new ResponseMessage<>(page);
    }

}