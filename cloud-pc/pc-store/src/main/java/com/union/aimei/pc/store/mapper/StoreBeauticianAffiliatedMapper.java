package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:09
 */
public interface StoreBeauticianAffiliatedMapper extends BaseMapper<StoreBeauticianAffiliated> {

    /**
     * 解除挂靠列表
     *
     * @param condMap 条件
     * @return
     */
    List<AffiliatedListRemoveResVo> listRemove(Map<String, Object> condMap);

}