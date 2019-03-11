package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseBtnMenus;
import com.union.aimei.common.model.system.BaseBtnMenusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseBtnMenusMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseBtnMenusExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseBtnMenusExample example);

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
    int insert(BaseBtnMenus record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseBtnMenus record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseBtnMenus> selectByExample(BaseBtnMenusExample example);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseBtnMenus selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseBtnMenus record, @Param("example") BaseBtnMenusExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseBtnMenus record, @Param("example") BaseBtnMenusExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseBtnMenus record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseBtnMenus record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseBtnMenus> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseBtnMenus> selectListByConditions(BaseBtnMenus record);
}