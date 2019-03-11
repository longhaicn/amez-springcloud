package com.union.aimei.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.app.productbeauticianref.RemoveStoreByBeauticianIdVo;
import com.union.aimei.product.service.ProductBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:28
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
    public ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.findByPageForFront(pageNo, pageSize, productBeauticianRef);
    }

    /**
     * 随机查询项目-美容师-关联
     *
     * @param productBeauticianRefByRandomVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "随机查询项目-美容师-关联")
    @PostMapping("/findByRandom")
    public ResponseMessage<ProductBeauticianRef> findByRandom(@ApiParam("查询条件") @RequestBody ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo) {
        return this.productBeauticianRefService.findByRandom(productBeauticianRefByRandomVo);
    }

    /**
     * 分页查询项目-美容师-关联（招募）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目-美容师-关联（招募）")
    @PostMapping("/findByPageForRecruit")
    public ResponseMessage<PageInfo<ProductBeauticianRefByRecruitResVo>> findByPageForRecruit(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                              @ApiParam(value = "查询条件") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.findByPageForRecruit(pageNo, pageSize, productBeauticianRef);
    }

    /**
     * 项目-美容师-关联详情（招募）
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目-美容师-关联详情（招募）")
    @GetMapping("/detailByRecruit/{id}")
    public ResponseMessage<ProductBeauticianRefByDetailForRecruitResVo> detailByRecruit(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productBeauticianRefService.detailByRecruit(id);
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
    public ResponseMessage auth(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByAuthVo authVo) {
        return this.productBeauticianRefService.auth(authVo);
    }

    /**
     * 查询美容师（订单）
     *
     * @param orderVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询美容师（订单）")
    @PostMapping("/findListByOrder")
    public ResponseMessage<List<ProductBeauticianRef>> findListByOrder(@ApiParam("查询条件") @RequestBody StoreBeauticianByOrderVo orderVo) {
        return this.productBeauticianRefService.findListByOrder(orderVo);
    }

    /**
     * 新增项目-美容师-关联
     *
     * @param productBeauticianRef 项目-美容师-关联
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增项目-美容师-关联")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "项目-美容师-关联") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.add(productBeauticianRef);
    }

    /**
     * 修改项目-美容师-关联
     *
     * @param productBeauticianRef 项目-美容师-关联
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改项目-美容师-关联")
    @PutMapping("/modify")
    public ResponseMessage modify(@ApiParam(value = "项目-美容师-关联") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.modify(productBeauticianRef);
    }

    /**
     * 根据ID查询项目-美容师-关联
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询项目-美容师-关联")
    @GetMapping("/findById/{id}")
    public ResponseMessage<ProductBeauticianRef> findById(@PathVariable(value = "id") int id) {
        return this.productBeauticianRefService.findById(id);
    }

    /**
     * 根据关联ID查询项目-美容师-关联
     *
     * @param refIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据关联ID查询项目-美容师-关联")
    @PostMapping("/1.1.1/findByRefId")
    public ResponseMessage<ProductBeauticianRef> findByRefIdV111(@ApiParam(value = "关联ID条件") @RequestBody ProductBeauticianRefByRefIdVo refIdVo) {
        return this.productBeauticianRefService.findByRefIdV111(refIdVo);
    }

    /**
     * 更新审核状态
     *
     * @param productBeauticianRef 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "更新审核状态")
    @PostMapping("/1.1.1/updateAuditStatus")
    public ResponseMessage updateAuditStatusV111(@ApiParam(value = "条件") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefService.updateAuditStatusV111(productBeauticianRef);
    }

    /**
     * 根据id修改为不显示状态(V1.1.1)
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据id修改为不显示状态(V1.1.1)")
    @GetMapping("/1.1.1/deleteShowById/{id}")
    public ResponseMessage deleteShowByIdV111(@ApiParam(value = "productBeauticianRefId") @PathVariable(value = "id") int id) {
        return this.productBeauticianRefService.deleteShowByIdV111(id);
    }

    /**
     * 根据美容师ID删除门店项目条件
     *
     * @param beauticianIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "根据美容师ID删除门店项目")
    @PutMapping("/1.1.1/removeStoreByBeauticianId")
    public ResponseMessage removeStoreByBeauticianIdV111(@RequestBody RemoveStoreByBeauticianIdVo beauticianIdVo) {
        return this.productBeauticianRefService.removeStoreByBeauticianIdV111(beauticianIdVo);
    }

}