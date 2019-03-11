package com.union.aimei.umeng.mapper;

import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BaseMemberDeviceMapper extends BaseMapper<BaseMemberDevice> {

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
    String queryTokenByMemberId(Integer memberId);

    /**
     * 根据token来查询所有的id
     * @param token
     * @return
     */
    List<Integer> queryIdListByToken(@Param("token") String token);

    /**
     * 批量删除数据
     * @param idlist
     */
    void deleteBatch(List<Integer> idlist);
}