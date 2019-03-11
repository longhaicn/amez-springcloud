package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.util.learn.LearnConditionUtil;
import com.union.aimei.common.vo.learn.pc.CheckConditionVo;
import com.union.aimei.common.vo.learn.pc.LearnBeforeVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.aimei.learn.mapper.LearnConditionMapper;
import com.union.aimei.learn.service.LearnConditionService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("learnConditionService")
public class LearnConditionServiceImpl implements LearnConditionService {
    @Resource
    private LearnConditionMapper learnConditionMapper;

    /**
     * 前端分页查询门槛条件表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param learnCondition 查询条件
     * @return
     */
    @Override
    public PageInfo<LearnCondition> findByPageForFront(Integer pageNo, Integer pageSize, LearnCondition learnCondition) {
        PageHelper.startPage(pageNo, pageSize);
        List<LearnCondition> list = this.learnConditionMapper.selectListByConditions(learnCondition);
        PageInfo<LearnCondition> page = new PageInfo<>(list);
        return page;
    }


    /**
     * 添加门槛条件表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(LearnCondition t) {
        return this.learnConditionMapper.insertSelective(t);
    }

    /**
     * 删除门槛条件表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.learnConditionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门槛条件表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(LearnCondition t) {
        return this.learnConditionMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnCondition
     */
    @Override
    public LearnCondition queryObjById(int id) {
        LearnCondition model = this.learnConditionMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<List<LearnConditionVo>> setLearnConditionVoListV110(List<LearnCondition> learnConditionList) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(LearnConditionUtil.setLearnConditionVoList(learnConditionList));
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<LearnCondition>> setLearnConditionListV110(List<LearnConditionVo> learnConditionVoList) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(LearnConditionUtil.setLearnConditionList(learnConditionVoList));
        return responseMessage;
    }

    @Override
    public ResponseMessage<LearnConditionMessageVo> checkConditionBeauticianV110(CheckConditionVo checkConditionVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(LearnConditionUtil.checkConditionBeautician(checkConditionVo.getLearnConditionList(), checkConditionVo.getStoreBeautician(), checkConditionVo.getStore()));
        return responseMessage;
    }

    @Override
    public ResponseMessage<LearnConditionMessageVo> learnBeforePermissionV110(LearnBeforeVo learnBeforeVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(LearnConditionUtil.learnBeforePermission(learnBeforeVo.getSrcMap(), learnBeforeVo.getTarget()));
        return responseMessage;
    }

    @Override
    public List<LearnCondition> queryListByLearnCondition(LearnCondition learnCondition) {
        return this.learnConditionMapper.selectListByConditions(learnCondition);
    }


}