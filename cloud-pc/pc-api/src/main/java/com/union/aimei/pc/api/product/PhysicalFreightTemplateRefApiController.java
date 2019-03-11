package com.union.aimei.pc.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalFreightTemplateRef;
import com.union.aimei.common.feign.pc.product.PhysicalFreightTemplateRefFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 16:57
 */
@Api(tags = "产品-运费模板-关联")
@RestController
@RequestMapping(value = "physicalFreightTemplateRef")
public class PhysicalFreightTemplateRefApiController {
    @Resource
    private PhysicalFreightTemplateRefFeign physicalFreightTemplateRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页数量
     * @param physicalFreightTemplateRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品-运费模板-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return new ResponseMessage(physicalFreightTemplateRefFeign.findByPageForFront(pageNo, pageSize, physicalFreightTemplateRef)); 
    }

    /**
     * 添加PhysicalFreightTemplateRef
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加产品-运费模板-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return new ResponseMessage(physicalFreightTemplateRefFeign.insert(physicalFreightTemplateRef)); 
    }

    /**
     * 删除PhysicalFreightTemplateRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除产品-运费模板-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(physicalFreightTemplateRefFeign.deleteById(id)); 
    }

    /**
     * 修改PhysicalFreightTemplateRef
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑产品-运费模板-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return new ResponseMessage(physicalFreightTemplateRefFeign.edit(physicalFreightTemplateRef)); 
    }

    /**
     * 根据ID查询PhysicalFreightTemplateRef
     *
     * @param id
     * @returnphysicalFreightTemplateRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询产品-运费模板-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<PhysicalFreightTemplateRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(physicalFreightTemplateRefFeign.queryById(id)); 
    }

    /**
     * 添加
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "产品-运费模板-关联") @RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return new ResponseMessage(physicalFreightTemplateRefFeign.add(physicalFreightTemplateRef)); 
    }

}