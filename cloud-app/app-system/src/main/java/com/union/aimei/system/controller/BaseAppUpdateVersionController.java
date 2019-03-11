package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.common.vo.system.BaseAppUpdateVersionVo;
import com.union.aimei.system.service.BaseAppUpdateVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author liufeihua
 */
@Api(tags = "app版本升级", description = "api")
@RestController
@RequestMapping("/baseAppUpdateVersions")
public class BaseAppUpdateVersionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseAppUpdateVersionService baseAppUpdateVersionService;

    @ApiOperation("根据ID删除base_app_update_version")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseAppUpdateVersionService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加base_app_update_version")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseAppUpdateVersion record) {
        int resultCount = this.baseAppUpdateVersionService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新base_app_update_version")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseAppUpdateVersion record) {
        int resultCount = this.baseAppUpdateVersionService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询base_app_update_version")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseAppUpdateVersion selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseAppUpdateVersion baseAppUpdateVersion = this.baseAppUpdateVersionService.selectByPrimaryKey(id);
        return baseAppUpdateVersion;
    }

    @ApiOperation("分页和条件查询base_app_update_version")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseAppUpdateVersion> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseAppUpdateVersion record) {
        PageInfo<BaseAppUpdateVersion> result = this.baseAppUpdateVersionService.selectListByConditions(pageNo, pageSize, record);
        logger.info("结果为"+result.getList().toString());
        return result;
    }

    @ApiOperation("升级android的app")
    @RequestMapping(value = "/forAndroidUpdateVersion/{clientType}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseAppUpdateVersionVo forAndroidUpdateVersion(@PathVariable("clientType") Integer clientType) {
        BaseAppUpdateVersionVo result = this.baseAppUpdateVersionService.forAndroidUpdateVersion(clientType);
        return result;
    }
}