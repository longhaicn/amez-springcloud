package com.union.aimei.pc.im.mapper;

import com.union.aimei.common.model.im.ImChatGroups;
import com.union.common.utils.base.BaseMapper;

/**
 * IM群组 mapper
 *
 * @author liurenkai
 * @time 2017/11/30 11:05
 */
public interface ImChatGroupsMapper extends BaseMapper<ImChatGroups> {

    /**
     * 修改群组
     *
     * @param easemobGroupId 环信群组ID
     * @param name           群组名称
     * @param description    群组描述
     * @param maxusers       群成员上限
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:27
     */
    int modify(String easemobGroupId, String name, String description, int maxusers);

    /**
     * 删除群组
     *
     * @param easemobGroupId 环信群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:49
     */
    int deleteByEasemobGroupId(String easemobGroupId);
}