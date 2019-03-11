package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianAffiliatedFeign;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveVo;
import com.union.aimei.common.vo.store.pc.AffiliatedPlatformAuditVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:14
 */
@Component(value = "pc-StoreBeauticianAffiliatedFeign")
public class StoreBeauticianAffiliatedApiHystrix implements StoreBeauticianAffiliatedFeign {

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(Integer pageNo, Integer pageSize, StoreBeauticianAffiliated affiliated) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> addV111(StoreBeauticianAffiliated affiliated) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyV111(StoreBeauticianAffiliated affiliated) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianAffiliated> findByIdV111(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage platformAuditV111(AffiliatedPlatformAuditVo platformAuditVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<AffiliatedListRemoveResVo>> listRemove(Integer pageNo, Integer pageSize, AffiliatedListRemoveVo removeVo) {
        return HystrixResponse.invokeFail();
    }

}