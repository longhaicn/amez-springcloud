package com.union.aimei.pc.api.product;

import com.union.aimei.common.model.product.PhysicalCategoryRef;
import com.union.aimei.common.feign.pc.product.PhysicalCategoryRefFeign;
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
@Api(tags = "产品-产品分类-关联")
@RestController
@RequestMapping(value = "physicalCategoryRef")
public class PhysicalCategoryRefApiController {
    @Resource
    private PhysicalCategoryRefFeign physicalCategoryRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param physicalCategoryRef 查询条件
     * @return ResponseMessage<PhysicalCategoryRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询产品-产品分类-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PhysicalCategoryRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody PhysicalCategoryRef physicalCategoryRef) {
        return new ResponseMessage(this.physicalCategoryRefFeign.findByPageForFront(pageNo, pageSize, physicalCategoryRef));
    }

    /**
     * 添加PhysicalCategoryRef
     *
     * @param physicalCategoryRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加产品-产品分类-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody PhysicalCategoryRef physicalCategoryRef) {
        return new ResponseMessage(this.physicalCategoryRefFeign.insert(physicalCategoryRef));
    }

    /**
     * 删除PhysicalCategoryRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除产品-产品分类-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.physicalCategoryRefFeign.deleteById(id));
    }

    /**
     * 修改PhysicalCategoryRef
     *
     * @param physicalCategoryRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑产品-产品分类-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody PhysicalCategoryRef physicalCategoryRef) {
        return new ResponseMessage(this.physicalCategoryRefFeign.edit(physicalCategoryRef));
    }

    /**
     * 根据ID查询PhysicalCategoryRef
     *
     * @param id
     * @returnphysicalCategoryRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询产品-产品分类-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<PhysicalCategoryRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.physicalCategoryRefFeign.queryById(id));
    }
}