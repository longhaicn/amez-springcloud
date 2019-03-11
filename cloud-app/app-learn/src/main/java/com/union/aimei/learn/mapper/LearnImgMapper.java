package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.LearnImg;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnImgMapper extends BaseMapper<LearnImg> {

    /**
     * 根据LearnImg实体类的参数获取图片集合
     *
     * @param learnImg 集合参数
     * @return
     */
    List<String> queryListByLearnImg(LearnImg learnImg);
}