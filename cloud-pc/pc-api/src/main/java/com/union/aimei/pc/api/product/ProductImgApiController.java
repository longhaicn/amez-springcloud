package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.common.feign.pc.product.ProductImgFeign;
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
 * @time 2018/1/5 19:30
 */
@Api(tags = "商品图片")
@RestController
@RequestMapping(value = "productImg")
public class ProductImgApiController {
    @Resource
    private ProductImgFeign productImgFeign;

    /**
     * 分页查询商品图片
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param productImg 查询条件
     * @return ResponseMessage<ProductImg>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询商品图片")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductImg> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @ApiParam(value = "查询条件") @RequestBody ProductImg productImg) {
        return new ResponseMessage(productImgFeign.findByPageForFront(pageNo, pageSize, productImg)); 
    }

    /**
     * 添加商品图片
     *
     * @param productImg
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加商品图片")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductImg productImg) {
        return new ResponseMessage(productImgFeign.insert(productImg)); 
    }

    /**
     * 删除商品图片
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除商品图片")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productImgFeign.deleteById(id)); 
    }

    /**
     * 修改商品图片
     *
     * @param productImg
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑商品图片")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductImg productImg) {
        return new ResponseMessage(productImgFeign.edit(productImg)); 
    }

    /**
     * 根据ID查询商品图片
     *
     * @param id
     * @returnproductImg
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询商品图片")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductImg> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productImgFeign.queryById(id)); 
    }
}