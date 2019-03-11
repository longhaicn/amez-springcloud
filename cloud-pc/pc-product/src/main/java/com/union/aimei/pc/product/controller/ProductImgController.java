package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.pc.product.service.ProductImgService;
import com.union.aimei.common.vo.product.pc.ProductImgByBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/5 19:04
 */
@Api(tags = "商品图片")
@RestController
@RequestMapping(value = "productImg")
public class ProductImgController {
    @Resource
    private ProductImgService productImgService;

    @PostMapping("/front/findByPage")
    public PageInfo<ProductImg> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @ApiParam(value = "查询条件") @RequestBody ProductImg productImg) {
        return this.productImgService.findByPageForFront(pageNo, pageSize, productImg);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductImg productImg) {
        return this.productImgService.addObj(productImg);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productImgService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductImg productImg) {
        return this.productImgService.modifyObj(productImg);
    }

    @GetMapping("/queryById/{id}")
    public ProductImg queryById(@PathVariable(value = "id") int id) {
        return this.productImgService.queryObjById(id);
    }

    /**
     * 根据商品ID删除商品图片
     *
     * @param productId 商品ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据商品ID删除商品图片")
    @DeleteMapping("/deleteByProductId/{productId}")
    public ResponseMessage deleteByProductId(@ApiParam(value = "商品ID") @PathVariable(value = "productId") int productId) {
        return this.productImgService.deleteByProductId(productId);
    }

    /**
     * 批量新增商品图片
     *
     * @param batchVo 批量商品图片
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量新增商品图片")
    @PostMapping("/addBatch")
    public ResponseMessage addBatch(@ApiParam(value = "批量商品图片") @RequestBody ProductImgByBatchVo batchVo) {
        return this.productImgService.addBatch(batchVo);
    }

    /**
     * 新增商品图片
     *
     * @param productImg 商品图片
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增商品图片")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "商品图片") @RequestBody ProductImg productImg) {
        return this.productImgService.add(productImg);
    }

}