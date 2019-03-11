package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.app.AffiliatedByBeauticianIdForInvitationResVo;
import com.union.aimei.common.vo.store.app.AffiliatedByStoreIdResVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 门店-美容师-挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:09
 */
public interface StoreBeauticianAffiliatedMapper extends BaseMapper<StoreBeauticianAffiliated> {

    /**
     * 根据美容师ID统计挂靠邀请
     *
     * @param condMap 条件
     * @return
     */
    int countByBeauticianIdForInvitation(Map<String, Object> condMap);

    /**
     * 根据美容师ID分页查询门店-美容师-挂靠邀请
     *
     * @param storeBeauticianAffiliated 门店-美容师-挂靠
     * @return
     */
    List<AffiliatedByBeauticianIdForInvitationResVo> selectListByBeauticianIdForInvitation(StoreBeauticianAffiliated storeBeauticianAffiliated);

    /**
     * 根据门店ID统计挂靠申请
     *
     * @param condMap 条件
     * @return
     */
    int countByStoreIdForApply(Map<String, Object> condMap);

    /**
     * 根据门店ID查询挂靠
     *
     * @param condMap 条件
     * @return
     */
    List<AffiliatedByStoreIdResVo> selectListByStoreId(Map<String, Object> condMap);

    /**
     * 更新审核状态
     *
     * @param condMap 条件
     * @return
     */
    int updateAuditStatus(Map<String, Object> condMap);

}