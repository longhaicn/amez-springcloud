package com.union.aimei.pc.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.PlatformTradeDetailFeign;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.vo.financial.PlatformTradeDetailVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags = "平台交易流水", description = "api")
@RestController
@RequestMapping("/platformTradeDetails")
public class PlatformTradeDetailApiController {

    @Autowired
    private PlatformTradeDetailFeign platformTradeDetailFeign;

    @ApiOperation("根据ID删除平台交易流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.platformTradeDetailFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加平台交易流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody PlatformTradeDetail record) {
        int resultCount = this.platformTradeDetailFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新平台交易流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody PlatformTradeDetail record) {
        int resultCount = this.platformTradeDetailFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询平台交易流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PlatformTradeDetail> selectByPrimaryKey(@PathVariable("id") Integer id) {
        PlatformTradeDetail platformTradeDetail = this.platformTradeDetailFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(platformTradeDetail);
    }

    @ApiOperation("分页和条件查询平台交易流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<PlatformTradeDetail>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody PlatformTradeDetail record) {
        PageInfo<PlatformTradeDetail> result = this.platformTradeDetailFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("分页和条件查询平台交易流水-后台管理")
    @RequestMapping(value = "/selectPlatformListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<PlatformTradeDetail>> selectPlatformListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody PlatformTradeDetailVo record) {
        PageInfo<PlatformTradeDetail> result = this.platformTradeDetailFeign.selectPlatformListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}