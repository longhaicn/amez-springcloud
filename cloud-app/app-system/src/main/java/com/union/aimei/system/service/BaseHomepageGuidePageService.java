package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;
/**
 * @author liufeihua
 */
public interface BaseHomepageGuidePageService {
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
    int insertSelective(BaseHomepageGuidePage record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseHomepageGuidePage selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseHomepageGuidePage record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseHomepageGuidePage> selectListByConditions(Integer pageNo, Integer pageSize, BaseHomepageGuidePage record);
}