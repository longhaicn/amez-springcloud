package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseNotificationNoticeFeign;
import com.union.aimei.common.model.system.BaseNotificationNotice;
import com.union.common.utils.ResponseMessage;
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
@Api(tags="通知公告", description = "api")
@RestController
@RequestMapping("/baseNotificationNotices")
public class BaseNotificationNoticeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseNotificationNoticeFeign baseNotificationNoticeFeign;

    @ApiOperation("根据ID删除通知公告")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseNotificationNoticeFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加通知公告")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseNotificationNotice record) {
        int resultCount = this.baseNotificationNoticeFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新通知公告")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseNotificationNotice record) {
        int resultCount = this.baseNotificationNoticeFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询通知公告")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseNotificationNotice> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseNotificationNotice baseNotificationNotice = this.baseNotificationNoticeFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseNotificationNotice);
    }

    @ApiOperation("分页和条件查询通知公告")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseNotificationNotice>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseNotificationNotice record) {
        PageInfo<BaseNotificationNotice> result = this.baseNotificationNoticeFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}