package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:10
 */
public interface StoreBeauticianAffiliatedService {

    /**
     * 新增挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    ResponseMessage<StoreBeauticianAffiliated> addV111(StoreBeauticianAffiliated affiliated);

    /**
     * 修改挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    ResponseMessage modifyV111(StoreBeauticianAffiliated affiliated);

    /**
     * 根据ID查询挂靠
     *
     * @param id ID
     * @return
     */
    ResponseMessage<StoreBeauticianAffiliated> findByIdV111(int id);

    /**
     * 根据美容师ID查询挂靠（美容师-我的-门店挂靠申请-挂靠申请）
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<AffiliatedByBeauticianIdResVo> findByBeauticianIdV111(int beauticianId);

    /**
     * 美容师申请挂靠
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage applyV111(int storeId, int beauticianId);

    /**
     * 门店同意申请挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    ResponseMessage agreeApplyV111(int affiliatedId);

    /**
     * 门店拒绝申请挂靠
     *
     * @param affiliatedId 挂靠ID
     * @param auditReason  审核原因
     * @return
     */
    ResponseMessage refuseApplyV111(int affiliatedId, String auditReason);

    /**
     * 门店邀请挂靠
     *
     * @param storeId      门店ID
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage invinationV111(int storeId, int beauticianId);

    /**
     * 美容师同意邀请挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    ResponseMessage agreeInvitationV111(int affiliatedId);

    /**
     * 美容师拒绝邀请挂靠
     *
     * @param affiliatedId 挂靠ID
     * @param auditReason  审核原因
     * @return
     */
    ResponseMessage refuseInvitationV111(int affiliatedId, String auditReason);

    /**
     * 美容师解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    ResponseMessage removeV111(int affiliatedId);

    /**
     * 门店同意解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    ResponseMessage agreeRemoveV111(int affiliatedId);

    /**
     * 门店拒绝解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @param auditReason  审核原因
     * @return
     */
    ResponseMessage refuseRemoveV111(int affiliatedId, String auditReason);

    /**
     * 门店解除入驻
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    ResponseMessage removeSettledV111(int affiliatedId);

    /**
     * 门店解除挂靠
     *
     * @param affiliatedId 挂靠ID
     * @return
     */
    ResponseMessage removeAffiliatedV111(int affiliatedId);

    /**
     * 根据美容师ID统计挂靠邀请
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<Integer> countByBeauticianIdForInvitationV111(int beauticianId);

    /**
     * 根据美容师ID分页查询挂靠邀请
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> findByPageByBeauticianIdForInvitationV111(Integer pageNo, Integer pageSize, int beauticianId);

    /**
     * 根据门店ID统计挂靠申请
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<Integer> countByStoreIdForApplyV111(int storeId);

    /**
     * 根据门店ID分页查询挂靠邀请列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param invitationVo 条件
     * @return
     */
    ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listInvitationByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListInvitationByStoreIdVo invitationVo);

    /**
     * 根据门店ID分页查询挂靠申请列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param applyVo  条件
     * @return
     */
    ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listApplyByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListApplyByStoreIdVo applyVo);

    /**
     * 审核挂靠
     *
     * @param auditVo 审核条件
     * @return
     */
    ResponseMessage auditV111(AffiliatedByAuditVo auditVo);

}