package com.union.aimei.pc.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.common.feign.pc.product.FreightTemplateCityFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:56
 */
@Api(tags = "运费模板城市")
@RestController
@RequestMapping(value = "freightTemplateCity")
public class FreightTemplateCityApiController {
    @Resource
    private FreightTemplateCityFeign freightTemplateCityFeign;

    /**
     * 分页查询
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param freightTemplateCity 查询条件
     * @return ResponseMessage<FreightTemplateCity>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询运费模板城市")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<FreightTemplateCity>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @ApiParam(value = "查询条件") @RequestBody FreightTemplateCity freightTemplateCity) {
        return new ResponseMessage<>(this.freightTemplateCityFeign.findByPageForFront(pageNo, pageSize, freightTemplateCity));
    }
}