package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.learn.LearnConstant;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.util.learn.LearnConditionUtil;
import com.union.aimei.common.vo.learn.app.*;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.aimei.learn.mapper.LearnConditionMapper;
import com.union.aimei.learn.service.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 门槛条件表
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("learnConditionService")
public class LearnConditionServiceImpl implements LearnConditionService {

    @Resource
    private LearnConditionMapper learnConditionMapper;

    @Resource
    private CourseService courseService;

    @Resource
    private ActivityService activityService;

    @Resource
    private ActivityMemberRefService activityMemberRefService;

    @Resource
    private CourseBeauticianRefService courseBeauticianRefService;

    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    @Resource
    private StoreFeign storeFeign;

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

    @Override
    public ResponseMessage<List<LearnCondition>> findByListForFrontV110(LearnCondition learnCondition) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<LearnCondition> list = this.learnConditionMapper.selectListByConditions(learnCondition);
        responseMessage.setData(list);
        return responseMessage;
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
    public ResponseMessage<List<Integer>> selectLearnCourseIdAuthorityV110(LearnAuthorityVo learnAuthorityVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<Integer> data = this.learnConditionMapper.selectLearnCourseIdAuthority(learnAuthorityVo).stream().filter(x -> x != null).collect(Collectors.toList());
        responseMessage.setData(data.size() == 0 ? null : data);
        return responseMessage;
    }

    /**
     * 课程
     *
     * @param learnConditionMessageVo
     * @param sourceId
     * @param targetId
     * @param learnConditionList
     */
    private void checkCourse(LearnConditionMessageVo learnConditionMessageVo, Integer sourceId, Integer targetId, List<LearnCondition> learnConditionList) {
        //校验是否可报名
        checkCourseStatus(sourceId);
        //美容师信息
        ResponseMessage<StoreBeautician> beauticianResCourse = this.storeBeauticianFeign.findById(targetId);
        if (ResponseUtil.isFail(beauticianResCourse)) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Insert.COSMETOLOGIST_DATA_ERROR);
        }
        //重复报名判断
        ResponseMessage courseBeauticianRefResponse = this.courseBeauticianRefService.checkBeauticianOnlyV110(targetId, sourceId);
        ResponseUtil.isFailThrowException(courseBeauticianRefResponse);
        //美容师数据
        StoreBeautician courseBeautician = beauticianResCourse.getData();
        //门槛判断
        if (null != learnConditionList && learnConditionList.size() > 0) {
            learnConditionMessageVo = checkCondition(learnConditionList, courseBeautician, null);
        }
    }

    /**
     * 活动
     *
     * @param learnConditionMessageVo
     * @param sourceId
     * @param targetId
     * @param learnConditionList
     */
    private void checkActivity(LearnConditionMessageVo learnConditionMessageVo, Integer sourceId, Integer targetId, List<LearnCondition> learnConditionList) {
        //校验是否可报名
        checkActivityStatus(sourceId);
        //美容师信息
        ResponseMessage<StoreBeautician> beauticianResActive = this.storeBeauticianFeign.findById(targetId);
        if (ResponseUtil.isFail(beauticianResActive)) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Insert.COSMETOLOGIST_DATA_ERROR);
        }
        //重复报名判断
        CheckRepeatActivityVo checkRepeatActivityVoBeautician = new CheckRepeatActivityVo();
        checkRepeatActivityVoBeautician.setMemberId(targetId);
        checkRepeatActivityVoBeautician.setActivityId(sourceId);
        ResponseMessage activityMemberRefReponseBeautician = this.activityMemberRefService.checkRepeatActivity(checkRepeatActivityVoBeautician);
        ResponseUtil.isFailThrowException(activityMemberRefReponseBeautician);
        //美容师数据
        StoreBeautician activityBeautician = beauticianResActive.getData();
        //门槛判断
        if (null != learnConditionList && learnConditionList.size() > 0) {
            learnConditionMessageVo = checkCondition(learnConditionList, activityBeautician, null);
        }
    }

    /**
     * 门店活动
     *
     * @param learnConditionMessageVo
     * @param sourceId
     * @param targetId
     * @param learnConditionList
     */
    private void checkStoreActivity(LearnConditionMessageVo learnConditionMessageVo, Integer sourceId, Integer targetId, List<LearnCondition> learnConditionList) {
        //校验是否可报名
        checkActivityStatus(sourceId);
        //店铺信息
        Store store = this.storeFeign.queryById(targetId);
        if (null == store) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Insert.STORE_DATA_ERROR);
        }
        //重复报名判断
        CheckRepeatActivityVo checkRepeatActivityVo = new CheckRepeatActivityVo();
        checkRepeatActivityVo.setStoreId(targetId);
        checkRepeatActivityVo.setActivityId(sourceId);
        ResponseMessage activityMemberRefReponse = this.activityMemberRefService.checkRepeatActivity(checkRepeatActivityVo);
        ResponseUtil.isFailThrowException(activityMemberRefReponse);
        //门槛判断
        if (null != learnConditionList && learnConditionList.size() > 0) {
            learnConditionMessageVo = checkCondition(learnConditionList, null, store);
        }
    }

    @Override
    public ResponseMessage checkConditionBeauticianV111(Integer targetId, Integer sourceId, Byte sourceType) {
        ResponseMessage responseMessage = new ResponseMessage();
        //校验门槛(活动和美容师)
        LearnCondition learnCondition = new LearnCondition();
        learnCondition.setSourceId(sourceId);
        learnCondition.setSourceType(sourceType);
        learnCondition.setIsEnabled(LearnCondition.IS_ENABLED_TURE);
        List<LearnCondition> learnConditionList = this.findByListForFrontV110(learnCondition).getData();
        LearnConditionMessageVo learnConditionMessageVo = new LearnConditionMessageVo();
        learnConditionMessageVo.setResult(true);
        switch (sourceType) {
            case LearnCondition.SOURCE_TYPE_COURSE:
                //课程学习
                this.checkCourse(learnConditionMessageVo, sourceId, targetId, learnConditionList);
                break;
            case LearnCondition.SOURCE_TYPE_ACTIVE:
                //美容师活动
                this.checkActivity(learnConditionMessageVo, sourceId, targetId, learnConditionList);
                break;
            case LearnCondition.SOURCE_TYPE_ACTIVE_STOCK:
                //门店的活动
                this.checkStoreActivity(learnConditionMessageVo, sourceId, targetId, learnConditionList);
                break;
            default:
                throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Insert.ERROR_SOURCE);
        }
        if (!learnConditionMessageVo.getResult()) {
            responseMessage.setCode(LearnConstant.ERROR_CODE);
            responseMessage.setMessage(learnConditionMessageVo.getConditionName());
        }
        return responseMessage;
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

    /**
     * 判断门槛
     *
     * @param learnConditionList 门槛集合
     * @param storeBeautician    美容师数据
     * @param store              店铺数据
     * @return
     */
    private LearnConditionMessageVo checkCondition(List<LearnCondition> learnConditionList,
                                                   StoreBeautician storeBeautician,
                                                   Store store) {
        CheckConditionVo checkConditionVo = new CheckConditionVo();
        checkConditionVo.setLearnConditionList(learnConditionList);
        checkConditionVo.setStoreBeautician(storeBeautician);
        checkConditionVo.setStore(store);
        return checkConditionBeauticianV110(checkConditionVo).getData();
    }

    /**
     * 判断课程是否可以参与
     *
     * @param courseId
     */
    private void checkCourseStatus(Integer courseId) {
        Course course = this.courseService.queryObjById(courseId);
        if (null == course) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Insert.COURSE_DATA_ERROR);
        } else if (course.getCourseStatus() != Course.COURSE_STATUS_OPEN) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Query.COURSE_ENROLLED);
        }
    }

    /**
     * 判断活动是否可以参与
     *
     * @param activityId
     */
    private void checkActivityStatus(Integer activityId) {
        Activity activity = activityService.queryObjById(activityId);
        if (null == activity) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Insert.ACTIVITY_DATA_ERROR);
        } else if (activity.getStatus() != Activity.Status.ACTIVITY_SIGN && activity.getStatus() != Activity.Status.ACTIVITY_RUNING) {
            throw new ServerException(LearnConstant.ERROR_CODE, LearnConstant.Query.ACTIVITY_ENROLLED);
        }
    }

}