package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.*;
import com.union.aimei.pc.product.service.ProductBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/26 15:00
 */
@Api(tags = "项目-美容师-关联")
@RestController
@RequestMapping(value = "productBeauticianRef")
public class ProductBeauticianRefController {
    @Resource
    private ProductBeauticianRefService productBeauticianRefService;

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.findByPageForFront(pageNo, pageSize, productBeauticianRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.addObj(productBeauticianRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productBeauticianRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.modifyObj(productBeauticianRef);
    }

    @GetMapping("/queryById/{id}")
    public ProductBeauticianRef queryById(@PathVariable(value = "id") int id) {
        return this.productBeauticianRefService.queryObjById(id);
    }

    /**
     * 根据商品ID删除项目-美容师-关联
     *
     * @param productId 商品ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据商品ID删除项目-美容师-关联")
    @DeleteMapping("/deleteByProductId/{productId}")
    public ResponseMessage deleteByProductId(@ApiParam(value = "商品ID") @PathVariable(value = "productId") int productId) {
        return this.productBeauticianRefService.deleteByProductId(productId);
    }

    /**
     * 批量添加项目-美容师-关联
     *
     * @param productBeauticianRefByBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加项目-美容师-关联")
    @PostMapping("/addBatch")
    public ResponseMessage addBatch(@ApiParam(value = "批量项目-美容师-关联") @RequestBody ProductBeauticianRefByBatchVo productBeauticianRefByBatchVo) {
        return this.productBeauticianRefService.addBatch(productBeauticianRefByBatchVo);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<ProductBeauticianRefByDetailResVo> detail(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productBeauticianRefService.detail(id);
    }

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo                 分页索引
     * @param pageSize               每页数量
     * @param productBeauticianRefVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目-美容师-关联")
    @PostMapping("/findByPage")
    public ResponseMessage<PageInfo<ProductBeauticianRefByResVo>> findByPage(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                             @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             @ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefVo productBeauticianRefVo) {
        return this.productBeauticianRefService.findByPage(pageNo, pageSize, productBeauticianRefVo);
    }

    /**
     * 项目-美容师-关联（同意）
     *
     * @param agreeVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目-美容师-关联（同意）")
    @PutMapping("/agree")
    public ResponseMessage agree(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByAgreeVo agreeVo) {
        return this.productBeauticianRefService.agree(agreeVo);
    }

    /**
     * 项目-美容师-关联（审核）
     *
     * @param authVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目-美容师-关联（审核）")
    @PutMapping("/auth")
    public ResponseMessage<ProductBeauticianRef> auth(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByAuthVo authVo) {
        return this.productBeauticianRefService.auth(authVo);
    }

    /**
     * 项目-美容师-关联（美容师状态）
     *
     * @param beauticianStatusVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目-美容师-关联（美容师状态）")
    @PutMapping("/beauticianStatus")
    public ResponseMessage beauticianStatus(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByBeauticianStatusVo beauticianStatusVo) {
        return this.productBeauticianRefService.beauticianStatus(beauticianStatusVo);
    }

    /**
     * 课程通过
     *
     * @param coursePassVo 课程条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "课程通过")
    @PostMapping("/1.1.1/coursePass")
    public ResponseMessage coursePassV111(@ApiParam(value = "条件") @RequestBody ProductBeauticianRefCoursePassVo coursePassVo) {
        return this.productBeauticianRefService.coursePass(coursePassVo);
    }

}