package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreBeauticianAffiliatedApiHystrix;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.product.app.AuditReasonVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 门店-美容师-挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:14
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreBeauticianAffiliatedApiHystrix.class)
public interface StoreBeauticianAffiliatedFeign {

    /**
     * 分页查询门店-美容师-挂靠
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param storeBeauticianAffiliated 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianAffiliated/1.1.1/front/findByPage")
    ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated);

    /**
     * 新增门店-美容师-挂靠
     *
     * @param storeBeauticianAffiliated 门店-美容师-挂靠
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/1.1.1/add")
    ResponseMessage<StoreBeauticianAffiliated> addV111(@RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated);

    /**
     * 修改门店-美容师-挂靠
     *
     * @param storeBeauticianAffiliated 门店-美容师-挂靠
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/1.1.1/modify")
    ResponseMessage modifyV111(@RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated);

    /**
     * 根据ID查询门店-美容师-挂靠
     *
     * @param id ID
     * @return
     */
    @GetMapping("/storeBeauticianAffiliated/1.1.1/findById/{id}")
    ResponseMessage<StoreBeauticianAffiliated> findByIdV111(@PathVariable(value = "id") int id);

    /**
     * 根据美容师ID统计挂靠邀请
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/storeBeauticianAffiliated/1.1.1/countByBeauticianIdForInvitation/{beauticianId}")
    ResponseMessage<Integer> countByBeauticianIdForInvitationV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 根据美容师ID分页查询门店-美容师-挂靠邀请
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/1.1.1/findByPageByBeauticianIdForInvitation/{beauticianId}")
    ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> findByPageByBeauticianIdForInvitationV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                                    @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 根据门店ID统计挂靠申请
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/storeBeauticianAffiliated/1.1.1/countByStoreIdForApply/{storeId}")
    ResponseMessage<Integer> countByStoreIdForApplyV111(@PathVariable(value = "storeId") int storeId);

    /**
     * 根据门店ID分页查询挂靠邀请列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param invitationVo 条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianAffiliated/1.1.1/listInvitationByStoreId")
    ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listInvitationByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                    @RequestBody AffiliatedListInvitationByStoreIdVo invitationVo);

    /**
     * 根据门店ID分页查询挂靠申请列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param applyVo  条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianAffiliated/1.1.1/listApplyByStoreId")
    ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listApplyByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                               @RequestBody AffiliatedListApplyByStoreIdVo applyVo);

    /**
     * 门店解除入驻
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @PutMapping(value = "/storeBeauticianAffiliated/1.1.1/storeRemoveSettled/{affiliatedId}")
    ResponseMessage storeRemoveSettledV111(@PathVariable(value = "affiliatedId") int affiliatedId);

    /**
     * 门店解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @PutMapping(value = "/storeBeauticianAffiliated/1.1.1/storeRemoveAffiliated/{affiliatedId}")
    ResponseMessage storeRemoveAffiliatedV111(@PathVariable(value = "affiliatedId") int affiliatedId);

    /**
     * 挂靠申请详情
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/storeBeauticianAffiliated/1.1.1/findByBeauticianId/{beauticianId}")
    ResponseMessage<AffiliatedByBeauticianIdResVo> findByBeauticianIdV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 挂靠申请
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/1.1.1/apply/{storeId}/{beauticianId}")
    ResponseMessage applyV111(@PathVariable(value = "storeId") int storeId,
                              @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 同意挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/1.1.1/invitation/agree/{affiliatedId}")
    ResponseMessage invitationByAgreeV111(@PathVariable(value = "affiliatedId") int affiliatedId);

    /**
     * 解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/1.1.1/remove/{affiliatedId}")
    ResponseMessage removeV111(@PathVariable(value = "affiliatedId") int affiliatedId);

    /**
     * 挂靠邀请
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/1.1.1/invination/{storeId}/{beauticianId}")
    ResponseMessage invinationV111(@PathVariable(value = "storeId") int storeId,
                                   @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 同意挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/1.1.1/apply/agree/{affiliatedId}")
    ResponseMessage applyByAgreeV111(@PathVariable(value = "affiliatedId") int affiliatedId);

    /**
     * 拒绝挂靠
     *
     * @param affiliatedId  挂靠ID
     * @param auditReasonVo 条件
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/1.1.1/apply/refuse/{affiliatedId}")
    ResponseMessage refuseByAgreeV111(@PathVariable(value = "affiliatedId") int affiliatedId,
                                      @RequestBody AuditReasonVo auditReasonVo);

    /**
     * 同意挂靠解除申请
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/1.1.1/remove/agree/{affiliatedId}")
    ResponseMessage removeByAgreeV111(@PathVariable(value = "affiliatedId") int affiliatedId);

    /**
     * 拒绝挂靠解除申请
     * @param affiliatedId 挂靠ID
     * @param auditReasonVo 条件
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/1.1.1/remove/refuse/{affiliatedId}")
    ResponseMessage refuseByRemoveV111(@PathVariable(value = "affiliatedId") int affiliatedId,
                                       @RequestBody AuditReasonVo auditReasonVo);

    /**
     * 审核挂靠
     *
     * @param auditVo 审核条件
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/1.1.1/audit")
    ResponseMessage auditV111(@RequestBody AffiliatedByAuditVo auditVo);

}