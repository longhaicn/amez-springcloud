package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeTemplateFeign;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.util.system.BaseHomeTemplateUtil;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:31
 */
@Api(tags = "首页模板")
@Scope(value = "prototype")
@RestController
@RequestMapping(value = "baseHomeTemplate")
public class BaseHomeTemplateApiController {

    private static final Logger log = LoggerFactory.getLogger(BaseHomeTemplateApiController.class);

    @Resource
    private BaseHomeTemplateFeign baseHomeTemplateFeign;


    @Autowired
    private BaseHomeTemplateUtil baseHomeTemplateUtil;

    /**
     * 前端分页查询首页模板
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseHomeTemplate 查询条件
     * @return ResponseMessage<BaseHomeTemplate>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询首页模板")
    @PostMapping("/front/findByPage")
    public ResponseMessage<BaseHomeTemplate> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                @ApiParam(value = "查询条件") @RequestBody BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<BaseHomeTemplate> page = baseHomeTemplateFeign.findByPageForFront(pageNo, pageSize, baseHomeTemplate);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加首页模板")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeTemplateFeign.insert(baseHomeTemplate);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除首页模板
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除首页模板")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeTemplateFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 编辑首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑首页模板")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeTemplateFeign.edit(baseHomeTemplate);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 通过ID查询首页模板
     *
     * @param id
     * @returnbaseHomeTemplate
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询首页模板")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<BaseHomeTemplate> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        BaseHomeTemplate model = this.baseHomeTemplateFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }


    /**
     * 更新首页模板软删除标记
     *
     * @param id        ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "更新首页模板软删除标记")
    @PutMapping("/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@ApiParam(value = "ID") @PathVariable(value = "id") int id, @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.baseHomeTemplateFeign.isEnabled(id, isEnabled);
    }

    /**
     * 获取模版页面的基础数据(v1.1.0)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取模版页面的基础数据(v1.1.0)")
    @PostMapping("/1.1.0/getTemplateDate")
    public ResponseMessage<BaseHomeTemplateRo> getTemplateDateV110(@ApiParam(value = "数据") @RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        BaseHomeTemplateRo baseHomeTemplateRo = null;
        try {
            baseHomeTemplateRo = this.baseHomeTemplateUtil.getBaseHomeTemplateByRedis(selectBaseHomeTemplateVo);
        } catch (Exception e) {
            log.info("获取首页基本数据时，redis异常。" + e.getMessage());
        }
        if (null == baseHomeTemplateRo) {
            return this.baseHomeTemplateFeign.getTemplateDateV111(selectBaseHomeTemplateVo);
        }
        return new ResponseMessage<>(baseHomeTemplateRo);
    }

    /**
     * 获取模版页面的基础数据(v1.1.1)(get请求)
     *
     * @param cityId
     * @param useType
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "获取模版页面的基础数据(v1.1.1)(get请求)")
    @GetMapping("/1.1.1/getTemplateDate")
    @Cacheable(value = "BaseHomeTemplateRo")
    public ResponseMessage<BaseHomeTemplateRo> getTemplateDateV111(
            @ApiParam(value = "城市id", defaultValue = "0") @RequestParam(value = "cityId", defaultValue = "0") Integer cityId,
            @ApiParam(value = "使用类型 0-用户端，1-帮女郎，2-门店端") @RequestParam(value = "useType") Integer useType) {
        SelectBaseHomeTemplateVo selectBaseHomeTemplateVo = new SelectBaseHomeTemplateVo();
        BaseHomeArea baseHomeArea = new BaseHomeArea();
        baseHomeArea.setCityId(cityId);
        selectBaseHomeTemplateVo.setUseType(useType);
        selectBaseHomeTemplateVo.setBaseHomeArea(baseHomeArea);
        BaseHomeTemplateRo baseHomeTemplateRo = null;
        try {
            baseHomeTemplateRo = this.baseHomeTemplateUtil.getBaseHomeTemplateByRedis(selectBaseHomeTemplateVo);
        } catch (Exception e) {
            log.info("获取首页基本数据时，redis异常。", e);
        }
        if (null == baseHomeTemplateRo) {
            try {
                return this.baseHomeTemplateFeign.getTemplateDateV111(selectBaseHomeTemplateVo);
            } catch (Exception e) {
                log.info("获取首页基本数据是，下层异常。", e);
            }
        }
        return new ResponseMessage<>(baseHomeTemplateRo);
    }


}