package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianAffiliatedFeign;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.product.app.AuditReasonVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 门店-美容师-挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:14
 */
@Component(value = "app-StoreBeauticianAffiliatedFeign")
public class StoreBeauticianAffiliatedApiHystrix implements StoreBeauticianAffiliatedFeign {

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(Integer pageNo, Integer pageSize, StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> addV111(StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyV111(StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> findByIdV111(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> countByBeauticianIdForInvitationV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedByBeauticianIdForInvitationResVo>> findByPageByBeauticianIdForInvitationV111(Integer pageNo, Integer pageSize, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> countByStoreIdForApplyV111(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listInvitationByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListInvitationByStoreIdVo invitationVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedByStoreIdResVo>> listApplyByStoreIdV111(Integer pageNo, Integer pageSize, AffiliatedListApplyByStoreIdVo applyVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage storeRemoveSettledV111(int affiliatedId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage storeRemoveAffiliatedV111(int affiliatedId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<AffiliatedByBeauticianIdResVo> findByBeauticianIdV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage applyV111(int storeId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage invitationByAgreeV111(int affiliatedId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeV111(int affiliatedId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage invinationV111(int storeId, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage applyByAgreeV111(int affiliatedId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage refuseByAgreeV111(int affiliatedId, AuditReasonVo auditReasonVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeByAgreeV111(int affiliatedId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage refuseByRemoveV111(int affiliatedId, AuditReasonVo auditReasonVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage auditV111(AffiliatedByAuditVo auditVo) {
        return HystrixResponse.invokeFail();
    }
}