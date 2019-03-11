package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeResultVo;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/4/11 14:33
 */
public interface StoreFollowerMapper extends BaseMapper<StoreFollower> {

    /**
     * 根据用户id和经纬度查询收藏的店铺
     * @param storeByMemberIdLongitudeLatitudeVo
     * @return
     */
    List<StoreByMemberIdLongitudeLatitudeResultVo> selectListPageByMemberIdAndLongitudeLatitude(StoreByMemberIdLongitudeLatitudeVo storeByMemberIdLongitudeLatitudeVo);

}