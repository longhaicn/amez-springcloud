package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnImgService extends SpringCloudBaseService<LearnImg> {
       /**
        * 前端分页查询学习图片
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param learnImg 查询条件
        * @return 
        */
       PageInfo<LearnImg> findByPageForFront(Integer pageNo, Integer pageSize, LearnImg learnImg);
       /**
        * 根据LearnImg的信息查询图片
        * @param learnImg
        * @return
        */
       List<String> queryListByLearnImg(LearnImg learnImg);
}