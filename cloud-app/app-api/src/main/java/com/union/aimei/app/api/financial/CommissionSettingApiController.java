package com.union.aimei.app.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.CommissionSettingFeign;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags = "佣金设置", description = "api")
@RestController
@RequestMapping("/commissionSettings")
public class CommissionSettingApiController {

    @Autowired
    private CommissionSettingFeign commissionSettingFeign;

    @ApiOperation("根据ID删除佣金设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.commissionSettingFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加佣金设置")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody CommissionSetting record) {
        int resultCount = this.commissionSettingFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新佣金设置")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody CommissionSetting record) {
        int resultCount = this.commissionSettingFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询佣金设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<CommissionSetting> selectByPrimaryKey(@PathVariable("id") Integer id) {
        CommissionSetting commissionSetting = this.commissionSettingFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(commissionSetting);
    }

    @ApiOperation("分页和条件查询佣金设置")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<CommissionSetting>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                               @RequestBody CommissionSetting record) {
        PageInfo<CommissionSetting> result = this.commissionSettingFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}