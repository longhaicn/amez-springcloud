package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgInsertBatchVo;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnImgService extends SpringCloudBaseService<LearnImg> {
    /**
     * 前端分页查询学习图片
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param learnImg 查询条件
     * @return
     */
    PageInfo<LearnImg> findByPageForFront(Integer pageNo, Integer pageSize, LearnImg learnImg);

    /**
     * 批量添加图片主图
     *
     * @param learnImgInsertBatchVo
     */
    void insertBatch(LearnImgInsertBatchVo learnImgInsertBatchVo);

    /**
     * 根据LearnImg查询活动，课程，文章的主图片
     *
     * @param learnImg
     * @return
     */
    List<String> queryImgListByLearnImg(LearnImg learnImg);
}