package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.pc.product.service.FreightTemplateCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:37
 */
@Api(tags = "运费模板城市")
@RestController
@RequestMapping(value = "freightTemplateCity")
public class FreightTemplateCityController {
    @Resource
    private FreightTemplateCityService freightTemplateCityService;

    @PostMapping("/front/findByPage")
    public PageInfo<FreightTemplateCity> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @ApiParam(value = "查询条件") @RequestBody FreightTemplateCity freightTemplateCity) {
        return this.freightTemplateCityService.findByPageForFront(pageNo, pageSize, freightTemplateCity);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody FreightTemplateCity freightTemplateCity) {
        return this.freightTemplateCityService.addObj(freightTemplateCity);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.freightTemplateCityService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody FreightTemplateCity freightTemplateCity) {
        return this.freightTemplateCityService.modifyObj(freightTemplateCity);
    }

    @GetMapping("/queryById/{id}")
    public FreightTemplateCity queryById(@PathVariable(value = "id") int id) {
        return this.freightTemplateCityService.queryObjById(id);
    }
}