package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeAreaFeign;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Api(tags = "首页区域表")
@RestController
@RequestMapping(value = "baseHomeArea")
public class BaseHomeAreaApiController {

    @Resource
    private BaseHomeAreaFeign baseHomeAreaFeign;

    /**
     * 分页查询
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param baseHomeArea 查询条件
     * @return ResponseMessage<BaseHomeArea>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询首页区域表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<BaseHomeArea> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody BaseHomeArea baseHomeArea) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<BaseHomeArea> page = baseHomeAreaFeign.findByPageForFront(pageNo, pageSize, baseHomeArea);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加BaseHomeArea
     *
     * @param baseHomeArea
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加首页区域表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody BaseHomeArea baseHomeArea) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeAreaFeign.insert(baseHomeArea);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除BaseHomeArea
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除首页区域表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeAreaFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改BaseHomeArea
     *
     * @param baseHomeArea
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑首页区域表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody BaseHomeArea baseHomeArea) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeAreaFeign.edit(baseHomeArea);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询BaseHomeArea
     *
     * @param id
     * @returnbaseHomeArea
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询首页区域表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<BaseHomeArea> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        BaseHomeArea model = this.baseHomeAreaFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}