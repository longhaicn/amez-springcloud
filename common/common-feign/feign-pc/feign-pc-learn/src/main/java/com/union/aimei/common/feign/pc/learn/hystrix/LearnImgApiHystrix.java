package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.LearnImgFeign;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgInsertBatchVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "pc-LearnImgFeign")
public class LearnImgApiHystrix implements LearnImgFeign {

       /**
        * 前端分页查询学习图片
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param learnImg 查询条件
        * @return 
        */
       @Override
       public PageInfo<LearnImg> findByPageForFront(Integer pageNo, Integer pageSize, LearnImg learnImg) {
              return null;
       }

       @Override
       public List<String> queryImgListByLearnImg(LearnImg learnImg) {
              return null;
       }

       /**
        * 添加学习图片
        * @param learnImg
        * @return
        */
       @Override
       public int insert(LearnImg learnImg) {
              return 0;
       }

       @Override
       public void insertBatch(LearnImgInsertBatchVo learnImgInsertBatchVo) {

       }

       /**
        * 删除学习图片
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改学习图片
        * @param learnImg
        * @return
        */
       @Override
       public int edit(LearnImg learnImg) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnlearnImg
        */
       @Override
       public LearnImg queryById(int id) {
              return null;
       }
}