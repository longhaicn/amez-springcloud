package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.common.vo.system.BaseAppUpdateVersionVo;
/**
 * @author liufeihua
 */
public interface BaseAppUpdateVersionService {
    /**
     * 基本操作
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseAppUpdateVersion record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseAppUpdateVersion selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseAppUpdateVersion record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseAppUpdateVersion> selectListByConditions(Integer pageNo, Integer pageSize, BaseAppUpdateVersion record);

    /**
     * 查看
     * @param clientType
     * @return
     */
    BaseAppUpdateVersionVo forAndroidUpdateVersion(Integer clientType);

}