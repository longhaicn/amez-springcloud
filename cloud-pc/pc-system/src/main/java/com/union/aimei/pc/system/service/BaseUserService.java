package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.UserVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;
import java.util.Map;

/**
 * @author liufeihua
 */

public interface BaseUserService {

    /**
     * 根据id删除
     *
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    ResponseMessage<BaseUser> insertSelective(BaseUser record);

    /**
     * 查询
     *
     * @param userId
     * @return
     */
    BaseUser selectByPrimaryKey(Integer userId);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseUser record);

    /**
     * 查询
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseUser> selectListByConditions(Integer pageNo, Integer pageSize, BaseUser record);

    /**
     * 用户登录
     *
     * @param vo
     * @return
     */
    ResponseMessage<Map<String, Object>> userLogin(UserVo vo);

    /**
     * 添加老板
     *
     * @param record
     * @return
     */
    ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(BaseUserVo record);

    /**
     * 查询
     *
     * @return
     */
    List<Map<String, Object>> selectNewByPage();

    /**
     * 关闭店铺的时候禁用用户登录--0启用 1禁用
     *
     * @param userId
     * @param flag
     * @return
     */
    ResponseMessage<Integer> updateUserSatuts(String userId, Integer flag);
}