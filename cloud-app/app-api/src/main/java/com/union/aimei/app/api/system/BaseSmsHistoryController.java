package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseSmsHistoryFeign;
import com.union.aimei.common.model.system.BaseSmsHistory;
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
@Api(tags="已发送的短信历史表", description = "api")
@RestController
@RequestMapping("/baseSmsHistorys")
public class BaseSmsHistoryController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseSmsHistoryFeign baseSmsHistoryFeign;

    @ApiOperation("根据ID删除已发送的短信历史表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseSmsHistoryFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加已发送的短信历史表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseSmsHistory record) {
        int resultCount = this.baseSmsHistoryFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新已发送的短信历史表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseSmsHistory record) {
        int resultCount = this.baseSmsHistoryFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询已发送的短信历史表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseSmsHistory> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseSmsHistory baseSmsHistory = this.baseSmsHistoryFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseSmsHistory);
    }

    @ApiOperation("分页和条件查询已发送的短信历史表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseSmsHistory>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseSmsHistory record) {
        PageInfo<BaseSmsHistory> result = this.baseSmsHistoryFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}