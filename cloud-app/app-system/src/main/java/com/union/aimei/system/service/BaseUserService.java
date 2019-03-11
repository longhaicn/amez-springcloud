package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.common.utils.ResponseMessage;
/**
 * @author liufeihua
 */
public interface BaseUserService {
    /**
     * 基本操作
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    ResponseMessage<BaseUser> insertSelective(BaseUser record);
    /**
     * 基本操作
     * @param userId
     * @return
     */
    BaseUser selectByPrimaryKey(Integer userId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseUser record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseUser> selectListByConditions(Integer pageNo, Integer pageSize, BaseUser record);

    /**
     * 添加老板,店长,者员工
     *
     * @param record
     * @return
     */
    ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(BaseUserVo record);


}