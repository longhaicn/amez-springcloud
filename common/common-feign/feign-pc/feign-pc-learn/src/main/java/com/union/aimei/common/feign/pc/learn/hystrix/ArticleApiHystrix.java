package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.ArticleFeign;
import com.union.aimei.common.model.learn.Article;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component(value = "pc-ArticleFeign")
public class ArticleApiHystrix implements ArticleFeign {

       /**
        * 前端分页查询文章
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param article 查询条件
        * @return 
        */
       @Override
       public PageInfo<Article> findByPageForFront(Integer pageNo, Integer pageSize, Article article) {
              return null;
       }

       /**
        * 添加文章
        * @param article
        * @return
        */
       @Override
       public int insert(Article article) {
              return 0;
       }

       /**
        * 删除文章
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改文章
        * @param article
        * @return
        */
       @Override
       public int edit(Article article) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnarticle
        */
       @Override
       public Article queryById(int id) {
              return null;
       }
}