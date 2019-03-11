package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.common.utils.base.BaseMapper;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
import java.util.List;

public interface MemberCardTemplateMapper extends BaseMapper<MemberCardTemplate> {

    /**
     * 批量添加会员卡模板
     * @param list
     */
    void insertByBatch(List<MemberCardTemplate> list);

    /**
     * 根据groupId来删除会员卡模板图片
     * @param id
     * @return
     */
    int deleteByGroupId(int id);

}