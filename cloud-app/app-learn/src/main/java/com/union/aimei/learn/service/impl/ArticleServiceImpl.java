package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Article;
import com.union.aimei.learn.mapper.ArticleMapper;
import com.union.aimei.learn.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
       @Resource
       private ArticleMapper articleMapper;

       /**
        * 前端分页查询文章
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param article 查询条件
        * @return 
        */
       @Override
       public PageInfo<Article> findByPageForFront(Integer pageNo, Integer pageSize, Article article) {
              PageHelper.startPage(pageNo,pageSize);
              List<Article> list = this.articleMapper.selectListByConditions(article);
              PageInfo<Article> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加文章
        * @param t
        * @return
        */
       @Override
       public int addObj(Article t) {
              return this.articleMapper.insertSelective(t);
       }

       /**
        * 删除文章
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.articleMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改文章
        * @param t
        * @return
        */
       @Override
       public int modifyObj(Article t) {
              return this.articleMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnarticle
        */
       @Override
       public Article queryObjById(int id) {
              Article model=this.articleMapper.selectByPrimaryKey(id);
              return model;
       }
}