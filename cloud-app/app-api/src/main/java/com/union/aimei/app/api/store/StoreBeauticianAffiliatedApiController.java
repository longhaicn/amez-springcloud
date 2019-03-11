package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianAffiliatedFeign;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.product.app.AuditReasonVo;
import com.union.aimei.common.vo.store.app.*;
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
public class StoreBeauticianAffiliatedApiController {

    @Resource
    private StoreBeauticianAffiliatedFeign storeBeauticianAffiliatedFeign;

    /**
     * 挂靠申请详情
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID查询挂靠（美容师-我的-门店挂靠申请-挂靠申请）")
    @GetMapping("/1.1.1/findByBeauticianId/{beauticianId}")
    public ResponseMessage<AffiliatedByBeauticianIdResVo> findByBeauticianIdV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedFeign.findByBeauticianIdV111(beauticianId);
    }

    /**
     * 根据美容师ID统计挂靠邀请（美容师-我的-门店挂靠申请-挂靠申请）
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID统计挂靠邀请（美容师-我的-门店挂靠申请-挂靠申请）")
    @GetMapping("/1.1.1/countByBeauticianIdForInvitation/{beauticianId}")
    public ResponseMessage<Integer> countByBeauticianIdForInvitationV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedFeign.countByBeauticianIdForInvitationV111(beauticianId);
    }

    /**
     * 挂靠申请
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "挂靠申请（美容师-我的-门店挂靠申请-挂靠申请）")
    @PostMapping("/1.1.1/apply/{storeId}/{beauticianId}")
    public ResponseMessage applyV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                     @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedFeign.applyV111(storeId, beauticianId);
    }

    /**
     * 根据美容师ID分页查询挂靠邀请（美容师-我的-门店挂靠申请-挂靠邀请）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据美容师ID分页查询挂靠邀请（美容师-我的-门店挂靠申请-挂靠邀请）")
    @PostMapping("/1.1.1/findByPageByBeauticianIdForInvitation/{beauticianId}")
    public ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> findByPageByBeauticianIdForInvitationV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                                           @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedFeign.findByPageByBeauticianIdForInvitationV111(pageNo, pageSize, beauticianId);
    }

    /**
     * 同意挂靠（美容师-我的-门店挂靠申请-挂靠邀请）
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "同意挂靠（美容师-我的-门店挂靠申请-挂靠邀请）")
    @PutMapping("/1.1.1/invitation/agree/{affiliatedId}")
    public ResponseMessage invitationByAgreeV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedFeign.invitationByAgreeV111(affiliatedId);
    }

    /**
     * 解除挂靠（美容师-我的-门店挂靠申请-挂靠成功-挂靠更改）
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "解除挂靠（美容师-我的-门店挂靠申请-挂靠成功-挂靠更改）")
    @PostMapping("/1.1.1/remove/{affiliatedId}")
    public ResponseMessage removeV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedFeign.removeV111(affiliatedId);
    }

    /**
     * 根据门店ID分页查询挂靠邀请（门店-首页-招募挂靠-挂靠管理-挂靠管理）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param invitationVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID分页查询挂靠邀请（门店-首页-招募挂靠-挂靠管理-挂靠管理）")
    @PostMapping(value = "/1.1.1/listInvitationByStoreId")
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listInvitationByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                           @RequestBody AffiliatedListInvitationByStoreIdVo invitationVo) {
        return this.storeBeauticianAffiliatedFeign.listInvitationByStoreIdV111(pageNo, pageSize, invitationVo);
    }

    /**
     * 根据门店ID统计挂靠申请（门店-首页-招募挂靠-挂靠管理-挂靠管理）
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID统计挂靠申请（门店-首页-招募挂靠-挂靠管理-挂靠管理）")
    @GetMapping("/1.1.1/countByStoreIdForApply/{storeId}")
    public ResponseMessage<Integer> countByStoreIdForApplyV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianAffiliatedFeign.countByStoreIdForApplyV111(storeId);
    }

    /**
     * 挂靠邀请（门店-首页-招募挂靠-挂靠管理-挂靠管理）
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "挂靠邀请（门店-首页-招募挂靠-挂靠管理-挂靠管理）")
    @PostMapping("/1.1.1/invination/{storeId}/{beauticianId}")
    public ResponseMessage invinationV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                          @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianAffiliatedFeign.invinationV111(storeId, beauticianId);
    }

    /**
     * 同意挂靠（门店-首页-招募挂靠-挂靠管理-挂靠申请）
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "同意挂靠（门店-首页-招募挂靠-挂靠管理-挂靠申请）")
    @PutMapping("/1.1.1/apply/agree/{affiliatedId}")
    public ResponseMessage applyByAgreeV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedFeign.applyByAgreeV111(affiliatedId);
    }

    /**
     * 拒绝挂靠（门店-首页-招募挂靠-挂靠管理-挂靠申请）
     *
     * @param affiliatedId  挂靠ID
     * @param auditReasonVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "拒绝挂靠（门店-首页-招募挂靠-挂靠管理-挂靠申请）")
    @PutMapping("/1.1.1/apply/refuse/{affiliatedId}")
    public ResponseMessage refuseByAgreeV111(@ApiParam(value = "挂靠ID", required = true) @PathVariable(value = "affiliatedId") int affiliatedId,
                                             @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.storeBeauticianAffiliatedFeign.refuseByAgreeV111(affiliatedId, auditReasonVo);
    }

    /**
     * 同意挂靠解除申请（门店-首页-招募挂靠-挂靠管理-挂靠申请）
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "同意挂靠解除申请（门店-首页-招募挂靠-挂靠管理-挂靠申请）")
    @PutMapping("/1.1.1/remove/agree/{affiliatedId}")
    public ResponseMessage removeByAgreeV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedFeign.removeByAgreeV111(affiliatedId);
    }

    /**
     * 拒绝挂靠解除申请（门店-首页-招募挂靠-挂靠管理-挂靠申请）
     *
     * @param auditReasonVo 条件
     * @return
     * @para m affiliatedId  挂靠ID
     */
    @ApiOperation(httpMethod = "PUT", value = "拒绝挂靠解除申请（门店-首页-招募挂靠-挂靠管理-挂靠申请）")
    @PutMapping("/1.1.1/remove/refuse/{affiliatedId}")
    public ResponseMessage refuseByRemoveV111(@ApiParam(value = "挂靠ID", required = true) @PathVariable(value = "affiliatedId") int affiliatedId,
                                              @ApiParam(value = "审核原因", required = true) @RequestBody AuditReasonVo auditReasonVo) {
        return this.storeBeauticianAffiliatedFeign.refuseByRemoveV111(affiliatedId, auditReasonVo);
    }


    /**
     * 分页查询挂靠
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页数量
     * @param storeBeauticianAffiliated 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询挂靠")
    @PostMapping("/1.1.1/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @ApiParam(value = "查询条件") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedFeign.findByPageForFrontV111(pageNo, pageSize, storeBeauticianAffiliated);
    }

    /**
     * 新增挂靠
     *
     * @param storeBeauticianAffiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增挂靠")
    @PostMapping("/1.1.1/add")
    public ResponseMessage addV111(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedFeign.addV111(storeBeauticianAffiliated);
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
        return this.storeBeauticianAffiliatedFeign.modifyV111(storeBeauticianAffiliated);
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
        return this.storeBeauticianAffiliatedFeign.findByIdV111(id);
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
        return this.storeBeauticianAffiliatedFeign.auditV111(auditVo);
    }


    /**
     * 根据门店ID分页查询挂靠申请
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param applyVo  条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID分页查询挂靠申请")
    @PostMapping(value = "/1.1.1/listApplyByStoreId")
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listApplyByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                      @RequestBody AffiliatedListApplyByStoreIdVo applyVo) {
        return this.storeBeauticianAffiliatedFeign.listApplyByStoreIdV111(pageNo, pageSize, applyVo);
    }

    /**
     * 门店解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店解除入驻（门店-首页-员工管理-员工管理（门店员工））")
    @PutMapping(value = "/1.1.1/storeRemoveSettled/{affiliatedId}")
    public ResponseMessage storeRemoveSettledV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedFeign.storeRemoveSettledV111(affiliatedId);
    }

    /**
     * 门店解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店解除挂靠（门店-首页-员工管理-员工管理（挂靠员工））")
    @PutMapping(value = "/1.1.1/storeRemoveAffiliated/{affiliatedId}")
    public ResponseMessage storeRemoveAffiliatedV111(@ApiParam(value = "挂靠ID") @PathVariable(value = "affiliatedId") int affiliatedId) {
        return this.storeBeauticianAffiliatedFeign.storeRemoveAffiliatedV111(affiliatedId);
    }

}