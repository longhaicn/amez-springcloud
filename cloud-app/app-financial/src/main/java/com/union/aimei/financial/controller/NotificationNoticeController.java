package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.NotificationNotice;
import com.union.aimei.financial.service.NotificationNoticeService;
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
@RequestMapping("/notificationNotices")
public class NotificationNoticeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NotificationNoticeService notificationNoticeService;

    @ApiOperation("根据ID删除通知公告")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.notificationNoticeService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加通知公告")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody NotificationNotice record) {
        int resultCount = this.notificationNoticeService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新通知公告")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody NotificationNotice record) {
        int resultCount = this.notificationNoticeService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询通知公告")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public NotificationNotice selectByPrimaryKey(@PathVariable("id") Integer id) {
        NotificationNotice notificationNotice = this.notificationNoticeService.selectByPrimaryKey(id);
        return notificationNotice;
    }

    @ApiOperation("分页和条件查询通知公告")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<NotificationNotice> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody NotificationNotice record) {
        PageInfo<NotificationNotice> result = this.notificationNoticeService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}