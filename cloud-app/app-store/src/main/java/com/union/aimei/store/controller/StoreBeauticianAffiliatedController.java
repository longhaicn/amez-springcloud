package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.product.app.AuditReasonVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.store.service.StoreBeauticianAffiliatedService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:11
 */
@Api(tags = "挂靠")
@RestController
@RequestMapping(value = "storeBeauticianAffiliated")
public class StoreBeauticianAffiliatedController {
    @Resource
    private StoreBeauticianAffiliatedService storeBeauticianAffiliatedService;

    /**
     * 保存挂靠
     *
     * @param storeBeauticianAffiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存挂靠")
    @PostMapping("/1.1.1/add")
    public ResponseMessage<StoreBeauticianAffiliated> addV111(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedService.addV111(storeBeauticianAffiliated);
    }

    /**
     * 修改挂靠
     *
     * @param storeBeauticianAffiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改挂靠")
    @PutMapping("/1.1.1/modify")
    public ResponseMessage modifyV111(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedService.modifyV111(storeBeauticianAffiliated);
    }

    /**
     * 根据ID查询挂靠
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询挂靠")
    @GetMapping("/1.1.1/findById/{id}")
    public ResponseMessage<StoreBeauticianAffiliated> findByIdV111(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeBeauticianAffiliatedService.findByIdV111(id);
    }

    /**
     * 根据美容师ID查询挂靠
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID查询挂靠")
    @GetMapping("/1.1.1/findByBeauticianId/{beauticianId}")
    public ResponseMessage<AffiliatedByBeauticianIdResVo> findByBeauticianIdV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedService.findByBeauticianIdV111(beauticianId);
    }

    /**
     * 美容师申请挂靠
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师申请挂靠（美容师-我的-门店挂靠申请-挂靠申请）")
    @PostMapping("/1.1.1/apply/{storeId}/{beauticianId}")
    public ResponseMessage applyV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                     @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedService.applyV111(storeId, beauticianId);
    }

    /**
     * 门店同意申请挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店同意申请挂靠")
    @PutMapping("/1.1.1/apply/agree/{affiliatedId}")
    public ResponseMessage agreeApplyV111(@PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedService.agreeApplyV111(affiliatedId);
    }

    /**
     * 门店拒绝申请挂靠
     *
     * @param affiliatedId  挂靠ID
     * @param auditReasonVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店拒绝申请挂靠")
    @PutMapping("/1.1.1/apply/refuse/{affiliatedId}")
    public ResponseMessage refuseApplyV111(@ApiParam(value = "挂靠ID", required = true) @PathVariable(value = "affiliatedId") int affiliatedId,
                                           @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.storeBeauticianAffiliatedService.refuseApplyV111(affiliatedId, auditReasonVo.getAuditReason());
    }

    /**
     * 门店邀请挂靠
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店邀请挂靠")
    @PostMapping("/1.1.1/invination/{storeId}/{beauticianId}")
    public ResponseMessage invinationV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                          @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedService.invinationV111(storeId, beauticianId);
    }

    /**
     * 美容师同意邀请挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师同意邀请挂靠")
    @PutMapping("/1.1.1/invitation/agree/{affiliatedId}")
    public ResponseMessage agreeInvitationV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedService.agreeInvitationV111(affiliatedId);
    }

    /**
     * 美容师拒绝邀请挂靠
     *
     * @param affiliatedId  挂靠ID
     * @param auditReasonVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师拒绝邀请挂靠")
    @PutMapping("/1.1.1/invitation/refuse/{affiliatedId}")
    public ResponseMessage refuseInvitationV111(@ApiParam(value = "挂靠ID", required = true) @PathVariable(value = "affiliatedId") int affiliatedId,
                                                @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.storeBeauticianAffiliatedService.refuseInvitationV111(affiliatedId, auditReasonVo.getAuditReason());
    }

    /**
     * 美容师解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师解除挂靠")
    @PostMapping("/1.1.1/remove/{affiliatedId}")
    public ResponseMessage removeV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedService.removeV111(affiliatedId);
    }

    /**
     * 门店同意解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店同意解除挂靠")
    @PutMapping("/1.1.1/remove/agree/{affiliatedId}")
    public ResponseMessage agreeRemoveV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedService.agreeRemoveV111(affiliatedId);
    }

    /**
     * 门店拒绝解除挂靠
     *
     * @param auditReasonVo 条件
     * @param affiliatedId  挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店拒绝解除挂靠")
    @PutMapping("/1.1.1/remove/refuse/{affiliatedId}")
    public ResponseMessage refuseRemoveV111(@ApiParam(value = "挂靠ID", required = true) @PathVariable(value = "affiliatedId") int affiliatedId,
                                            @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.storeBeauticianAffiliatedService.refuseRemoveV111(affiliatedId, auditReasonVo.getAuditReason());
    }

    /**
     * 门店解除入驻
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店解除入驻")
    @PutMapping(value = "/1.1.1/storeRemoveSettled/{affiliatedId}")
    public ResponseMessage removeSettledV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedService.removeSettledV111(affiliatedId);
    }

    /**
     * 门店解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店解除挂靠")
    @PutMapping(value = "/1.1.1/storeRemoveAffiliated/{affiliatedId}")
    public ResponseMessage removeAffiliatedV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedService.removeAffiliatedV111(affiliatedId);
    }

    /**
     * 根据美容师ID统计挂靠邀请
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID统计挂靠邀请")
    @GetMapping("/1.1.1/countByBeauticianIdForInvitation/{beauticianId}")
    public ResponseMessage<Integer> countByBeauticianIdForInvitationV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedService.countByBeauticianIdForInvitationV111(beauticianId);
    }

    /**
     * 根据美容师ID分页查询挂靠邀请
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据美容师ID分页查询挂靠邀请")
    @PostMapping("/1.1.1/findByPageByBeauticianIdForInvitation/{beauticianId}")
    public ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> findByPageByBeauticianIdForInvitationV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                                           @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedService.findByPageByBeauticianIdForInvitationV111(pageNo, pageSize, beauticianId);
    }

    /**
     * 根据门店ID统计挂靠申请
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID统计挂靠申请")
    @GetMapping("/1.1.1/countByStoreIdForApply/{storeId}")
    public ResponseMessage<Integer> countByStoreIdForApplyV111(@ApiParam(value = "美容师ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianAffiliatedService.countByStoreIdForApplyV111(storeId);
    }

    /**
     * 根据门店ID分页查询挂靠邀请列表
     *
     * @param pageNo                分页索引
     * @param pageSize              每页显示数量
     * @param affiliatedByStoreIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID分页查询挂靠邀请列表")
    @PostMapping(value = "/1.1.1/listInvitationByStoreId")
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listInvitationByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                           @RequestBody AffiliatedListInvitationByStoreIdVo invitationVo) {
        return this.storeBeauticianAffiliatedService.listInvitationByStoreIdV111(pageNo, pageSize, invitationVo);
    }

    /**
     * 根据门店ID分页查询挂靠申请列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param applyVo  条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID分页查询挂靠申请列表")
    @PostMapping(value = "/1.1.1/listApplyByStoreId")
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listApplyByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListApplyByStoreIdVo applyVo) {
        return this.storeBeauticianAffiliatedService.listApplyByStoreIdV111(pageNo, pageSize, applyVo);
    }

    /**
     * 审核挂靠
     *
     * @param auditVo 审核条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "审核挂靠")
    @PostMapping("/1.1.1/audit")
    public ResponseMessage auditV111(@ApiParam(value = "条件") @RequestBody AffiliatedByAuditVo auditVo) {
        return this.storeBeauticianAffiliatedService.auditV111(auditVo);
    }

}