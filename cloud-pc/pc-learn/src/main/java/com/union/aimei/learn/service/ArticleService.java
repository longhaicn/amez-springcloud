package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Article;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ArticleService extends SpringCloudBaseService<Article> {
       /**
        * 前端分页查询文章
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param article 查询条件
        * @return 
        */
       PageInfo<Article> findByPageForFront(Integer pageNo, Integer pageSize, Article article);
}