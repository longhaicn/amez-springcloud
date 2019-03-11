package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.LearnImgFeign;
import com.union.aimei.common.model.learn.LearnImg;
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
@Api(tags = "学习图片")
@RestController
@RequestMapping(value = "learnImg")
public class LearnImgApiController {

    @Resource
    private LearnImgFeign learnImgFeign;

    /**
     * 分页查询
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param learnImg 查询条件
     * @return ResponseMessage<LearnImg>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询学习图片")
    @PostMapping("/front/findByPage")
    public ResponseMessage<LearnImg> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnImg learnImg) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<LearnImg> page = learnImgFeign.findByPageForFront(pageNo, pageSize, learnImg);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加LearnImg
     *
     * @param learnImg
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加学习图片")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody LearnImg learnImg) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.learnImgFeign.insert(learnImg);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除LearnImg
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除学习图片")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.learnImgFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改LearnImg
     *
     * @param learnImg
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑学习图片")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody LearnImg learnImg) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.learnImgFeign.edit(learnImg);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询LearnImg
     *
     * @param id
     * @returnlearnImg
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询学习图片")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<LearnImg> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        LearnImg model = this.learnImgFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}