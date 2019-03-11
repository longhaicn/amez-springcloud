package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgInsertBatchVo;
import com.union.aimei.learn.mapper.LearnImgMapper;
import com.union.aimei.learn.service.LearnImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("learnImgService")
public class LearnImgServiceImpl implements LearnImgService {
    @Resource
    private LearnImgMapper learnImgMapper;

    /**
     * 前端分页查询学习图片
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param learnImg 查询条件
     * @return
     */
    @Override
    public PageInfo<LearnImg> findByPageForFront(Integer pageNo, Integer pageSize, LearnImg learnImg) {
        PageHelper.startPage(pageNo, pageSize);
        List<LearnImg> list = this.learnImgMapper.selectListByConditions(learnImg);
        PageInfo<LearnImg> page = new PageInfo<>(list);
        return page;
    }


    @Override
    public void insertBatch(LearnImgInsertBatchVo learnImgInsertBatchVo) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("sourceType", learnImgInsertBatchVo.getSourceType());
        map.put("sourceId", learnImgInsertBatchVo.getSourceId());
        map.put("imgUrlList", learnImgInsertBatchVo.getImgUrlList());
        this.learnImgMapper.insertBatch(map);
    }

    @Override
    public List<String> queryImgListByLearnImg(LearnImg learnImg) {
        return this.learnImgMapper.findUrlListByLearnImg(learnImg);
    }

    /**
     * 添加学习图片
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(LearnImg t) {
        return this.learnImgMapper.insertSelective(t);
    }

    /**
     * 删除学习图片
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.learnImgMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改学习图片
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(LearnImg t) {
        return this.learnImgMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnImg
     */
    @Override
    public LearnImg queryObjById(int id) {
        LearnImg model = this.learnImgMapper.selectByPrimaryKey(id);
        return model;
    }
}