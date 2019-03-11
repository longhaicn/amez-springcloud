package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.common.utils.ResponseMessage;
/**
 * @author liufeihua
 */
public interface BaseDicGroupService {
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
    int insertSelective(BaseDicGroup record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseDicGroup selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroup record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseDicGroup> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroup record);

    /**
     * 根据数据字典代码查询数据字典详情
     *
     * @param code 数据字典代码
     * @return
     */
    ResponseMessage<BaseDicGroupDeatilResVo> detailByCodeV111(String code);

}