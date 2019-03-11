package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Article;
import com.union.aimei.learn.mapper.ArticleMapper;
import com.union.aimei.learn.mapper.LearnImgMapper;
import com.union.aimei.learn.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
       @Resource
       private ArticleMapper articleMapper;

       @Resource
       private LearnImgMapper learnImgMapper;

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
              int result =  this.articleMapper.insertSelective(t);
              if(result > 0 ){
                     return t.getId();
              }else{
                     return -1;
              }
       }

       /**
        * 删除文章
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              int result =  this.articleMapper.deleteByPrimaryKey(id);
              Map<String,Integer> map = new HashMap<>(2);
              map.put("sourceId",id);
              map.put("sourceType",3);
              this.learnImgMapper.deleteBySourceIdAndSourceType(map);
              return 0;
       }

       /**
        * 修改文章
        * @param t
        * @return
        */
       @Override
       public int modifyObj(Article t) {
              if(t.getImgURLList() != null){
                     //修改活动时候，删除原来的图片，添加新的图片
                     Map<String, Integer> imgMap = new HashMap<>(2);
                     imgMap.put("sourceId",t.getId());
                     imgMap.put("sourceType",2);
                     this.learnImgMapper.deleteBySourceIdAndSourceType(imgMap);
                     Map<String, Object> map = new HashMap<>(3);
                     map.put("sourceType",2);
                     map.put("sourceId",t.getId());
                     map.put("imgUrlList",t.getImgURLList());
                     this.learnImgMapper.insertBatch(map);
              }
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