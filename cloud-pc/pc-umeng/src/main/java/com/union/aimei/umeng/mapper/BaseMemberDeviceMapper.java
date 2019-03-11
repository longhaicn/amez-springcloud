package com.union.aimei.umeng.mapper;


import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BaseMemberDeviceMapper extends BaseMapper<BaseMemberDevice> {
    /**
     * 根据memberId来查询信息
     * @param memberId
     * @return
     */
    BaseMemberDevice queryByMemberId(Integer memberId);

    /**
     * 根据memberId来查询deviceToken
     * @param memberId
     * @return
     */
    String queryDeviceTokenByMemberId(Integer memberId);


    /**
     * 根据memberId来查询deviceToken
     * @param memberId
     * @return
     */
    String queryTokenByMemberId(@Param("memberId") Integer memberId);
}