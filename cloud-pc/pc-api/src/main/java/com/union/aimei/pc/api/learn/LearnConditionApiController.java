package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.LearnConditionFeign;
import com.union.aimei.common.model.learn.LearnCondition;
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
 * @create 2018-05-10 10:49
 **/
@Api(tags = "门槛条件表")
@RestController
@RequestMapping(value = "learnCondition")
public class LearnConditionApiController {

    @Resource
    private LearnConditionFeign learnConditionFeign;

    /**
     * 分页查询
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param learnCondition 查询条件
     * @return ResponseMessage<LearnCondition>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询门槛条件表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<LearnCondition> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                      Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                      Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnCondition learnCondition) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<LearnCondition> page = learnConditionFeign.findByPageForFront(pageNo, pageSize, learnCondition);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加LearnCondition
     *
     * @param learnCondition
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加门槛条件表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody LearnCondition learnCondition) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.learnConditionFeign.insert(learnCondition);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除LearnCondition
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除门槛条件表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.learnConditionFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改LearnCondition
     *
     * @param learnCondition
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑门槛条件表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody LearnCondition learnCondition) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.learnConditionFeign.edit(learnCondition);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询LearnCondition
     *
     * @param id
     * @returnlearnCondition
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询门槛条件表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<LearnCondition> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        LearnCondition model = this.learnConditionFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}