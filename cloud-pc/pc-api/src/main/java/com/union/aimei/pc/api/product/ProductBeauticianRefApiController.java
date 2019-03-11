package com.union.aimei.pc.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.*;
import com.union.aimei.common.feign.pc.product.ProductBeauticianRefFeign;
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
 * @time 2018/2/26 15:13
 */
@Api(tags = "项目-美容师-关联")
@RestController
@RequestMapping(value = "productBeauticianRef")
public class ProductBeauticianRefApiController {
    @Resource
    private ProductBeauticianRefFeign productBeauticianRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<ProductBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return new ResponseMessage(productBeauticianRefFeign.findByPageForFront(pageNo, pageSize, productBeauticianRef)); 
    }

    /**
     * 添加ProductBeauticianRef
     *
     * @param productBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加项目-美容师-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ProductBeauticianRef productBeauticianRef) {
        return new ResponseMessage(productBeauticianRefFeign.insert(productBeauticianRef)); 
    }

    /**
     * 删除ProductBeauticianRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除项目-美容师-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productBeauticianRefFeign.deleteById(id)); 
    }

    /**
     * 修改ProductBeauticianRef
     *
     * @param productBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑项目-美容师-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ProductBeauticianRef productBeauticianRef) {
        return new ResponseMessage(productBeauticianRefFeign.edit(productBeauticianRef)); 
    }

    /**
     * 根据ID查询ProductBeauticianRef
     *
     * @param id
     * @returnproductBeauticianRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询项目-美容师-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ProductBeauticianRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(productBeauticianRefFeign.queryById(id)); 
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
        return new ResponseMessage(productBeauticianRefFeign.detail(id)); 
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
        return new ResponseMessage(productBeauticianRefFeign.findByPage(pageNo, pageSize, productBeauticianRefVo)); 
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
        return new ResponseMessage(productBeauticianRefFeign.agree(agreeVo)); 
    }

    /**
     * 项目-美容师-关联（审核）
     *
     * @param authVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目-美容师-关联（审核）")
    @PutMapping("/auth")
    public ResponseMessage auth(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByAuthVo authVo) {
        return new ResponseMessage(productBeauticianRefFeign.auth(authVo)); 
    }

}