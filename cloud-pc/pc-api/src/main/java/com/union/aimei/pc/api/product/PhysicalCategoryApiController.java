package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.PhysicalCategory;
import com.union.aimei.common.feign.pc.product.PhysicalCategoryFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "产品分类")
@RestController
@RequestMapping(value = "physicalCategory")
public class PhysicalCategoryApiController {
    @Resource
    private PhysicalCategoryFeign physicalCategoryFeign;

    /**
     * 分页查询
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param physicalCategory 查询条件
     * @return ResponseMessage<PhysicalCategory>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询产品分类")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PhysicalCategory> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                        Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                        Integer pageSize, @ApiParam(value = "查询条件") @RequestBody PhysicalCategory physicalCategory) {
        return new ResponseMessage(this.physicalCategoryFeign.findByPageForFront(pageNo, pageSize, physicalCategory));
    }

    /**
     * 添加PhysicalCategory
     *
     * @param physicalCategory
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加产品分类")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody PhysicalCategory physicalCategory) {
        return new ResponseMessage(this.physicalCategoryFeign.insert(physicalCategory));
    }

    /**
     * 删除PhysicalCategory
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除产品分类")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.physicalCategoryFeign.deleteById(id));
    }

    /**
     * 修改PhysicalCategory
     *
     * @param physicalCategory
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑产品分类")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody PhysicalCategory physicalCategory) {
        return new ResponseMessage(this.physicalCategoryFeign.edit(physicalCategory));
    }

    /**
     * 根据ID查询PhysicalCategory
     *
     * @param id
     * @returnphysicalCategory
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询产品分类")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<PhysicalCategory> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.physicalCategoryFeign.queryById(id));
    }
}