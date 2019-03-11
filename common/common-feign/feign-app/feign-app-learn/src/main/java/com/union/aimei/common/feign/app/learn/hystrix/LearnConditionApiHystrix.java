package com.union.aimei.common.feign.app.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.LearnConditionFeign;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.app.CheckConditionVo;
import com.union.aimei.common.vo.learn.app.LearnAuthorityVo;
import com.union.aimei.common.vo.learn.app.LearnBeforeVo;
import com.union.aimei.common.vo.learn.app.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 询门槛条件表
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "app-LearnConditionFeign")
public class LearnConditionApiHystrix implements LearnConditionFeign {

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
        return null;
    }

    @Override
    public ResponseMessage<List<LearnCondition>> findByListForFrontV110(LearnCondition learnCondition) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<LearnConditionVo>> setLearnConditionVoListV110(List<LearnCondition> learnConditionList) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<LearnCondition>> setLearnConditionListV110(List<LearnConditionVo> learnConditionVoList) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<LearnConditionMessageVo> checkConditionBeauticianV110(CheckConditionVo checkConditionVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<LearnConditionMessageVo> learnBeforePermissionV110(LearnBeforeVo learnBeforeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Integer>> selectLearnCourseIdAuthorityV110(LearnAuthorityVo learnAuthorityVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage checkConditionBeauticianV111(int targetId, int sourceId, byte sourceType) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加门槛条件表
     *
     * @param learnCondition
     * @return
     */
    @Override
    public int insert(LearnCondition learnCondition) {
        return 0;
    }

    /**
     * 删除门槛条件表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改门槛条件表
     *
     * @param learnCondition
     * @return
     */
    @Override
    public int edit(LearnCondition learnCondition) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnCondition
     */
    @Override
    public LearnCondition queryById(int id) {
        return null;
    }
}