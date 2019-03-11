package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.pc.CheckConditionVo;
import com.union.aimei.common.vo.learn.pc.LearnBeforeVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 门槛条件
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnConditionService extends SpringCloudBaseService<LearnCondition> {
    /**
     * 前端分页查询门槛条件表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param learnCondition 查询条件
     * @return
     */
    PageInfo<LearnCondition> findByPageForFront(Integer pageNo, Integer pageSize, LearnCondition learnCondition);

    /**
     * 将后台learnConditionList数据转化 为 LearnConditionVoList实体类(v1.1.0)
     *
     * @param learnConditionList
     * @return
     */
    ResponseMessage<List<LearnConditionVo>> setLearnConditionVoListV110(List<LearnCondition> learnConditionList);

    /**
     * 将前台定义传递的数据 转换为 learnCondition 实体类(v1.1.0)
     *
     * @param learnConditionVoList
     * @return
     */
    ResponseMessage<List<LearnCondition>> setLearnConditionListV110(List<LearnConditionVo> learnConditionVoList);

    /**
     * 根据美容师、店铺 数据以及门口数据 校验是否具备报名资格(v1.1.0)
     *
     * @param checkConditionVo
     * @return
     */
    ResponseMessage<LearnConditionMessageVo> checkConditionBeauticianV110(CheckConditionVo checkConditionVo);


    /**
     * 判断前置课程是否满足(v1.1.0)
     *
     * @param learnBeforeVo
     * @return
     */
    ResponseMessage<LearnConditionMessageVo> learnBeforePermissionV110(LearnBeforeVo learnBeforeVo);

    /**
     * 根据条件查询门槛集合
     * @param learnCondition
     * @return
     */
    List<LearnCondition> queryListByLearnCondition(LearnCondition learnCondition);
}