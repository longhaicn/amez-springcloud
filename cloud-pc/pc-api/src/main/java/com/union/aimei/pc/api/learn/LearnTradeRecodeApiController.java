package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
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
 * @author houji
 */
@Api(tags = "交易记录表")
@RestController
@RequestMapping(value = "learnTradeRecode")
public class LearnTradeRecodeApiController {
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;

    /**
     * 分页查询
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param learnTradeRecode 查询条件
     * @return ResponseMessage<LearnTradeRecode>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询交易记录表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<LearnTradeRecode> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                        Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                        Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnTradeRecode learnTradeRecode) {
        ResponseMessage result = ResponseMessageFactory.newInstance ();
        PageInfo<LearnTradeRecode> page = learnTradeRecodeFeign.findByPageForFront (pageNo, pageSize, learnTradeRecode);
        if (page != null) {
            result.setData (page);
        } else {
            result.setCode (ResponseContants.QUERY_EMPTY);
            result.setMessage (ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加CourseOrder
     *
     * @param learnTradeRecode
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加交易记录表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody LearnTradeRecode learnTradeRecode) {
        ResponseMessage result = ResponseMessageFactory.newInstance ();
        int res = this.learnTradeRecodeFeign.insert (learnTradeRecode);
        AssertUtil.numberGtZero (res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除CourseOrder
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除交易记录表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance ();
        int res = this.learnTradeRecodeFeign.deleteById (id);
        AssertUtil.numberGtZero (res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改CourseOrder
     *
     * @param learnTradeRecode
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑交易记录表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody LearnTradeRecode learnTradeRecode) {
        ResponseMessage result = ResponseMessageFactory.newInstance ();
        int res = this.learnTradeRecodeFeign.edit (learnTradeRecode);
        AssertUtil.numberGtZero (res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询CourseOrder
     *
     * @param id
     * @returnlearnTradeRecode
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询交易记录表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<LearnTradeRecode> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance ();
        LearnTradeRecode model = this.learnTradeRecodeFeign.queryById (id);
        AssertUtil.notNull (model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData (model);
        return result;
    }
}