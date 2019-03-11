package com.union.aimei.pc.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.aimei.pc.financial.service.CommissionSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dell
 */
@Api(tags = "佣金设置", description = "api")
@RestController
@RequestMapping("/commissionSettings")
public class CommissionSettingController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommissionSettingService commissionSettingService;

    @ApiOperation("根据ID删除佣金设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.commissionSettingService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加佣金设置")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody CommissionSetting record) {
        int resultCount = this.commissionSettingService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新佣金设置")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody CommissionSetting record) {
        int resultCount = this.commissionSettingService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("批量根据ID更新佣金设置")
    @RequestMapping(value = "/updateList", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelectiveByList(@RequestBody List<CommissionSetting> record) {
        int resultCount = this.commissionSettingService.updateByPrimaryKeySelectiveByList(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询佣金设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public CommissionSetting selectByPrimaryKey(@PathVariable("id") Integer id) {
        CommissionSetting commissionSetting = this.commissionSettingService.selectByPrimaryKey(id);
        return commissionSetting;
    }

    @ApiOperation("分页和条件查询佣金设置")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<CommissionSetting> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody CommissionSetting record) {
        PageInfo<CommissionSetting> result = this.commissionSettingService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}