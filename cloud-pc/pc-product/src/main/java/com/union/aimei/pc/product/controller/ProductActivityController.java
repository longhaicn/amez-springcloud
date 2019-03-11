package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.pc.product.service.ProductActivityService;
import com.union.aimei.common.vo.product.pc.ProductActivityByAddVo;
import com.union.aimei.common.vo.product.pc.ProductActivityByDetailResVo;
import com.union.aimei.common.vo.product.pc.ProductActivityBySelectBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 11:13
 */
@Api(tags = "项目活动")
@RestController
@RequestMapping(value = "productActivity")
public class ProductActivityController {
    @Resource
    private ProductActivityService productActivityService;

    /**
     * 分页查询项目活动
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productActivity 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目活动")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductActivity>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ProductActivity productActivity) {
        return this.productActivityService.findByPageForFront(pageNo, pageSize, productActivity);
    }

    /**
     * 查询精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询精选项目活动")
    @GetMapping("/findListBySelect/{cityId}")
    public ResponseMessage<List<ProductActivity>> findListBySelect(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId) {
        return this.productActivityService.findListBySelect(cityId);
    }

    /**
     * 项目活动详情
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目活动详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<ProductActivityByDetailResVo> detail(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productActivityService.detail(id);
    }

    /**
     * 新增项目活动
     *
     * @param addVo 新增条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增项目活动")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "新增条件") @RequestBody ProductActivityByAddVo addVo) {
        return this.productActivityService.add(addVo);
    }

    /**
     * 批量精选项目活动
     *
     * @param selectBatchVo 批量精选条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量精选项目活动")
    @PutMapping("/select/batch")
    public ResponseMessage selectByBatch(@ApiParam("批量精选条件") @RequestBody ProductActivityBySelectBatchVo selectBatchVo) {
        return this.productActivityService.selectByBatch(selectBatchVo);
    }

}