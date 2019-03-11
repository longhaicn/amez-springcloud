package com.union.aimei.pc.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.model.product.FreightTemplateParam;
import com.union.aimei.common.vo.product.pc.FreightTemplateByAddVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDetailResVo;
import com.union.aimei.common.feign.pc.product.FreightTemplateFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:56
 */
@Api(tags = "运费模板")
@RestController
@RequestMapping(value = "freightTemplate")
public class FreightTemplateApiController {
    @Resource
    private FreightTemplateFeign freightTemplateFeign;

    /**
     * 分页查询运费模板
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询运费模板")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<FreightTemplate>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody FreightTemplate freightTemplate) {
        return this.freightTemplateFeign.findByPageForFront(pageNo, pageSize, freightTemplate);
    }

    /**
     * 添加FreightTemplate
     *
     * @param freightTemplate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加运费模板")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody FreightTemplate freightTemplate) {
        return new ResponseMessage(this.freightTemplateFeign.insert(freightTemplate));
    }

    /**
     * 删除FreightTemplate
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除运费模板")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.freightTemplateFeign.deleteById(id));
    }

    /**
     * 修改FreightTemplate
     *
     * @param freightTemplate
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑运费模板")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody FreightTemplate freightTemplate) {
        return new ResponseMessage(this.freightTemplateFeign.edit(freightTemplate));
    }

    /**
     * 根据ID查询FreightTemplate
     *
     * @param id
     * @returnfreightTemplate
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询运费模板")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<FreightTemplate> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.freightTemplateFeign.queryById(id));
    }

    /**
     * 分页查询运费模板（模板）
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询运费模板（模板）")
    @PostMapping("/findByPageForDefault")
    public ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> findByPageForDefault(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                         @ApiParam(value = "查询条件") @RequestBody FreightTemplate freightTemplate) {
        return this.freightTemplateFeign.findByPageForDefault(pageNo, pageSize, freightTemplate);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<FreightTemplateByDetailResVo> detail(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return new ResponseMessage(this.freightTemplateFeign.detail(id));
    }


    /**
     * 添加
     *
     * @param addVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam("添加") @RequestBody FreightTemplateByAddVo addVo) {
        return new ResponseMessage(this.freightTemplateFeign.add(addVo));
    }

    /**
     * 修改
     *
     * @param addVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改")
    @PostMapping("/modify")
    public ResponseMessage modify(@ApiParam("修改") @RequestBody FreightTemplateByAddVo addVo) {
        return new ResponseMessage(this.freightTemplateFeign.modify(addVo));
    }


    /**
     * 根据条件统计模版数量
     *
     * @param freightTemplateParam
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据条件统计模版数量")
    @PostMapping("/selectCountByTemplateName")
    public ResponseMessage selectCountByTemplateName(@ApiParam("修改") @RequestBody FreightTemplateParam freightTemplateParam) {
        return this.freightTemplateFeign.selectCountByTemplateName(freightTemplateParam.getTemplateName(), freightTemplateParam.getNotId());
    }

}