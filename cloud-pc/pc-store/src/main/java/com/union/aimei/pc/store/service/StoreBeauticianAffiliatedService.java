package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveVo;
import com.union.aimei.common.vo.store.pc.AffiliatedPlatformAuditVo;
import com.union.common.utils.ResponseMessage;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:10
 */
public interface StoreBeauticianAffiliatedService {

    /**
     * 分页查询挂靠
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param affiliated 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianAffiliated affiliated);

    /**
     * 新增挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    ResponseMessage<StoreBeauticianAffiliated> add(StoreBeauticianAffiliated affiliated);

    /**
     * 修改挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    ResponseMessage modify(StoreBeauticianAffiliated affiliated);

    /**
     * 根据ID查询挂靠
     *
     * @param id ID
     * @return
     */
    ResponseMessage<StoreBeauticianAffiliated> findById(int id);

    /**
     * 平台审核挂靠
     *
     * @param platformAuditVo 平台审核条件
     * @return
     */
    ResponseMessage platformAudit(AffiliatedPlatformAuditVo platformAuditVo);

    /**
     * 解除挂靠列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param removeVo 条件
     * @return
     */
    ResponseMessage<PageInfo<AffiliatedListRemoveResVo>> listRemove(Integer pageNo, Integer pageSize, AffiliatedListRemoveVo removeVo);

}