package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;

/**
 * @author liufeihua
 */

public interface BaseHomepageGuidePageService {

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseHomepageGuidePage record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseHomepageGuidePage selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseHomepageGuidePage record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseHomepageGuidePage> selectListByConditions(Integer pageNo, Integer pageSize, BaseHomepageGuidePage record);
}