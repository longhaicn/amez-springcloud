package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductBeauticianRefApiHystrix;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.app.productbeauticianref.RemoveStoreByBeauticianIdVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:35
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductBeauticianRefApiHystrix.class)
public interface ProductBeauticianRefFeign {

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @PostMapping(value = "/productBeauticianRef/front/findByPage")
    ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       @RequestBody ProductBeauticianRef productBeauticianRef);


    /**
     * 随机查询项目-美容师-关联
     *
     * @param productBeauticianRefByRandomVo
     * @return
     */
    @PostMapping("/productBeauticianRef/findByRandom")
    ResponseMessage<ProductBeauticianRef> findByRandom(@RequestBody ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo);

    /**
     * 查询项目-美容师-关联（订单）
     *
     * @param orderVo
     * @return
     */
    @PostMapping("/productBeauticianRef/findListByOrder")
    ResponseMessage<List<ProductBeauticianRef>> findListByOrder(@RequestBody StoreBeauticianByOrderVo orderVo);

    /**
     * 分页查询项目-美容师-关联（招募）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @PostMapping("/productBeauticianRef/findByPageForRecruit")
    ResponseMessage<PageInfo<ProductBeauticianRefByRecruitResVo>> findByPageForRecruit(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 同意
     *
     * @param agreeVo
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/agree")
    ResponseMessage agree(@RequestBody ProductBeauticianRefByAgreeVo agreeVo);

    /**
     * 审核
     *
     * @param authVo
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/auth")
    ResponseMessage auth(@RequestBody ProductBeauticianRefByAuthVo authVo);

    /**
     * 新增项目-美容师-关联
     *
     * @param productBeauticianRef 项目-美容师-关联
     * @return
     */
    @PostMapping(value = "/productBeauticianRef/add")
    ResponseMessage add(@RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 修改项目-美容师-关联
     *
     * @param productBeauticianRef 项目-美容师-关联
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/modify")
    ResponseMessage modify(@RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 根据ID查询项目-美容师-关联
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/productBeauticianRef/findById/{id}")
    ResponseMessage<ProductBeauticianRef> findById(@PathVariable(value = "id") int id);

    /**
     * 根据关联ID查询项目-美容师-关联
     *
     * @param refIdVo 条件
     * @return
     */
    @PostMapping("/productBeauticianRef/1.1.1/findByRefId")
    ResponseMessage<ProductBeauticianRef> findByRefIdV111(@RequestBody ProductBeauticianRefByRefIdVo refIdVo);

    /**
     * 更新审核状态
     *
     * @param productBeauticianRef 条件
     * @return
     */
    @PostMapping("/productBeauticianRef/1.1.1/updateAuditStatus")
    ResponseMessage updateAuditStatusV111(@RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 根据id修改为不显示状态(V1.1.1)
     *
     * @param id
     * @return
     */
    @GetMapping("/productBeauticianRef/1.1.1/deleteShowById/{id}")
    ResponseMessage deleteShowByIdV111(@PathVariable(value = "id") int id);

    /**
     * 根据美容师ID删除门店项目条件
     *
     * @param beauticianIdVo 条件
     * @return
     */
    @PutMapping("/productBeauticianRef/1.1.1/removeStoreByBeauticianId")
    ResponseMessage removeStoreByBeauticianIdV111(@RequestBody RemoveStoreByBeauticianIdVo beauticianIdVo);

}