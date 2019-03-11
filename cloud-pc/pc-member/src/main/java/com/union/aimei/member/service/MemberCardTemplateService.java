package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.aimei.common.vo.member.MemberCardTemplateVo;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberCardTemplateService extends SpringCloudBaseService<MemberCardTemplate> {
       /**
        * 前端分页查询会员卡卡面模板表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTemplate 查询条件
        * @return 
        */
       PageInfo<MemberCardTemplate> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTemplate memberCardTemplate);

       /**
        * 批量添加
        * @param memberCardTemplateVo
        */
       void insertByBatch(MemberCardTemplateVo memberCardTemplateVo);

       /**
        * 分组删除
        * @param id
        * @return
        */
       int deleteByGroupId(int id);
}