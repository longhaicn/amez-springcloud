package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseNotificationNotice;
import com.union.aimei.pc.system.service.BaseNotificationNoticeService;
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
@Api(tags = "通知公告", description = "api")
@RestController
@RequestMapping("/baseNotificationNotices")
public class BaseNotificationNoticeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseNotificationNoticeService baseNotificationNoticeService;

    @ApiOperation("根据ID删除通知公告")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseNotificationNoticeService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加通知公告")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseNotificationNotice record) {
        int resultCount = this.baseNotificationNoticeService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新通知公告")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseNotificationNotice record) {
        int resultCount = this.baseNotificationNoticeService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询通知公告")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseNotificationNotice selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseNotificationNotice baseNotificationNotice = this.baseNotificationNoticeService.selectByPrimaryKey(id);
        return baseNotificationNotice;
    }

    @ApiOperation("分页和条件查询通知公告")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseNotificationNotice> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseNotificationNotice record) {
        PageInfo<BaseNotificationNotice> result = this.baseNotificationNoticeService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}