package com.union.aimei.financial.mapper;

import com.union.aimei.common.model.financial.NotificationNotice;
import com.union.aimei.common.model.financial.NotificationNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface NotificationNoticeMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(NotificationNoticeExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(NotificationNoticeExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insert(NotificationNotice record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(NotificationNotice record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<NotificationNotice> selectByExample(NotificationNoticeExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    NotificationNotice selectByPrimaryKey(Integer id);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") NotificationNotice record, @Param("example") NotificationNoticeExample example);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") NotificationNotice record, @Param("example") NotificationNoticeExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(NotificationNotice record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(NotificationNotice record);

    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<NotificationNotice> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<NotificationNotice> selectListByConditions(NotificationNotice record);
}