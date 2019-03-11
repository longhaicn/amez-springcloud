package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.learn.CourseConstant;
import com.union.aimei.common.model.learn.*;
import com.union.aimei.common.vo.learn.pc.CourseDataVo;
import com.union.aimei.common.vo.learn.pc.CourseDetailVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.aimei.common.vo.learn.pc.LearnImgParamVo;
import com.union.aimei.learn.async.CourseBeauticianRefAsyncTask;
import com.union.aimei.learn.mapper.*;
import com.union.aimei.learn.service.CourseService;
import com.union.aimei.learn.service.LearnConditionService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private CourseProductRefMapper courseProductRefMapper;

    @Resource
    private LearnImgMapper learnImgMapper;

    @Resource
    private CourseEvaluateMapper courseEvaluateMapper;

    @Resource
    private LearnConditionMapper learnConditionMapper;

    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Autowired
    private CourseBeauticianRefAsyncTask courseBeauticianRefAsyncTask;

    @Resource
    private LearnConditionService learnConditionService;


    /**
     * 添加课程表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(Course t) {
        return this.courseMapper.insertSelective(t);
    }

    /**
     * 删除课程表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.courseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改课程表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(Course t) {
        return this.courseMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourse
     */
    @Override
    public Course queryObjById(int id) {
        Course model = this.courseMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public PageInfo<Course> findByPageForFrontV110(Integer pageNo, Integer pageSize, Course course) {
        PageHelper.startPage(pageNo, pageSize);
        course.setIsEnabled(Course.IS_ENABLED_TURE);
        List<Course> list = this.courseMapper.selectListByConditions(course);
        PageInfo<Course> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage insertCourseV110(CourseDataVo courseDataVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        //门槛数据设置
        courseDataVo.setLearnConditionList(this.learnConditionService.setLearnConditionListV110(courseDataVo.getLearnConditionVoList()).getData());
        //校验课程编号
        Course course = new Course();
        course.setCourseCode(courseDataVo.getCourse().getCourseCode());
        course.setIsEnabled(Course.IS_ENABLED_TURE);
        Integer total = this.courseMapper.countByConditions(course);
        if (total > 0) {
            responseMessage.setMessage(CourseConstant.Query.DUPLICATE_COURSE_NUMBER_MESSAGE);
            responseMessage.setCode(CourseConstant.Query.DUPLICATE_COURSE_NUMBER);
            return responseMessage;
        }
        //保存逻辑
        courseDataVo.getCourse().setId(null);
        insertCourse(courseDataVo);

        return responseMessage;
    }

    @Override
    public ResponseMessage editCourseV110(CourseDataVo courseDataVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        //门槛数据设置
        courseDataVo.setLearnConditionList(this.learnConditionService.setLearnConditionListV110(courseDataVo.getLearnConditionVoList()).getData());
        Course course = this.courseMapper.selectByPrimaryKey(courseDataVo.getCourse().getId());
        if (null != course) {

            /**
             * 如果课程为 未发布或已撤回 状态，则删除 门槛、评测、图片、服务、课程 等相关的数据 ，获取课程的创建时间 然后重新添加。
             * 如果课程为 已发布 状态，则删除 评测、服务 相关的数据 ，更新成长值和项目详情
             * 如果课程为 已结束 状态，trainingStatus = 2 则提示无法修改
             */
            if (Course.TRAINING_STATUS_ENDED == course.getTrainingStatus()) {
                throw new ServerException(CourseConstant.Query.DUPLICATE_COURSE_NUMBER, CourseConstant.Query.COURSE_IS_CLOSE);
            }

            if (course.getCourseStatus() == Course.COURSE_STATUS_CLOSE || course.getCourseStatus() == Course.COURSE_STATUS_WITHDRAWN) {
                //批量删除前置操作获取相关的ids
                Map<String, List<Integer>> deleteMap = deleteCourseBefore(course);
                //删除课程
                this.courseMapper.deleteByPrimaryKey(course.getId());
                //保存逻辑
                courseDataVo.getCourse().setCreateTime(course.getCreateTime());
                insertCourse(courseDataVo);
                //批量删除相关数据
                deleteCourseByConditionAndImg(deleteMap);
            } else if (course.getCourseStatus() == Course.COURSE_STATUS_OPEN) {
                //处理 评测、服务 相关的数据
                //批量删除前置操作获取相关的ids
                Map<String, List<Integer>> deleteMap = deleteCourseBefore(course);
                insertCourseByEvalAndProduct(courseDataVo);
                deleteCourseByEvalAndProduct(deleteMap);
                //更新 更新成长值和项目详情
                Course updateCourse = new Course();
                updateCourse.setId(courseDataVo.getCourse().getId());
                updateCourse.setGrowthValue(courseDataVo.getCourse().getGrowthValue());
                updateCourse.setCourseContent(courseDataVo.getCourse().getCourseContent());
                this.courseMapper.updateByPrimaryKeySelective(updateCourse);
            }
        } else {
            throw new ServerException(CourseConstant.Update.UPDATE_NUMBER, CourseConstant.Update.UPDATE_NUMBER_MESSAGE);
        }
        return responseMessage;
    }


    @Override
    public ResponseMessage selectCountByCourseCodeV110(String courseCode) {
        ResponseMessage responseMessage = new ResponseMessage();
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setIsEnabled(Course.IS_ENABLED_TURE);
        Integer total = this.courseMapper.countByConditions(course);
        if (total > 0) {
            responseMessage.setMessage(CourseConstant.Query.DUPLICATE_COURSE_NUMBER_MESSAGE);
            responseMessage.setCode(CourseConstant.Query.DUPLICATE_COURSE_NUMBER);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateStatusEnabledByIdV110(Integer courseId, Integer type) {
        ResponseMessage responseMessage = new ResponseMessage();
        Course course = new Course();
        course.setId(courseId);
        switch (type) {
            case 1:
                course.setIsEnabled(Course.IS_ENABLED_FALSE);
                break;
            case 2:
                course.setIsEnabled(Course.IS_ENABLED_TURE);
                break;
            case 3:
                course.setCourseStatus(Course.COURSE_STATUS_CLOSE);
                break;
            case 4:
                course.setCourseStatus(Course.COURSE_STATUS_OPEN);
                break;
            case 5:
                //判断是否有报名的美容师，有的话则不可以撤回
                CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
                courseBeauticianRef.setCourseId(courseId);
                courseBeauticianRef.setIsEnabled(CourseBeauticianRef.IS_ENABLED_TURE);
                List<CourseBeauticianRef> courseBeauticianRefList = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
                if (!courseBeauticianRefList.isEmpty()) {
                    throw new ServerException(CourseConstant.Query.DUPLICATE_COURSE_NUMBER, CourseConstant.Query.COURSE_IS_SIGNED_NO_WITHDRAWN);
                }
                course.setCourseStatus(Course.COURSE_STATUS_WITHDRAWN);
                break;
            default:
                responseMessage.setCode(CourseConstant.Update.UPDATE_NUMBER);
                responseMessage.setMessage(CourseConstant.Update.UPDATE_NUMBER_MESSAGE);
                return responseMessage;
        }
        this.courseMapper.updateByPrimaryKeySelective(course);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<Course>> selectPageByCourseV110(Integer pageNo, Integer pageSize, CourseParamVo courseParamVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        courseParamVo.setIsEnabled(Course.IS_ENABLED_TURE);
        List<Course> list = this.courseMapper.selectListPageByCourse(courseParamVo);
        PageInfo<Course> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<CourseDetailVo> selectCourseDetailByIdV110(Integer courseId) {
        ResponseMessage responseMessage = new ResponseMessage();
        CourseDetailVo courseDetailVo = new CourseDetailVo();
        //课程数据
        Course course = this.courseMapper.selectByPrimaryKey(courseId);
        courseDetailVo.setCourse(course);
        //获取图片
        LearnImgParamVo learnImgParamVo = new LearnImgParamVo();
        learnImgParamVo.setSourceId(courseId);
        learnImgParamVo.setSourceType(LearnImgParamVo.SOURCE_TYPE_COURSE);
        learnImgParamVo.setMainStatusSort(LearnImgParamVo.MAIN_STATUS_SORT_DESC);
        courseDetailVo.setLearnImgList(this.learnImgMapper.selectImgByConditions(learnImgParamVo).stream().map(LearnImg::getImgUrl).collect(Collectors.toList()));
        //获取服务
        CourseProductRef courseProductRef = new CourseProductRef();
        courseProductRef.setIsEnabled(CourseProductRef.IS_ENABLED_TURE);
        courseProductRef.setCourseId(course.getId());
        courseDetailVo.setCourseProductRefList(this.courseProductRefMapper.selectListByConditions(courseProductRef));
        //获取门槛
        LearnCondition learnCondition = new LearnCondition();
        learnCondition.setIsEnabled(LearnCondition.IS_ENABLED_TURE);
        learnCondition.setSourceId(course.getId());
        learnCondition.setSourceType(LearnCondition.SOURCE_TYPE_COURSE);
        List<LearnCondition> learnConditionList = this.learnConditionMapper.selectListByConditions(learnCondition);
        courseDetailVo.setLearnConditionList(learnConditionList);
        courseDetailVo.setLearnConditionVoList(this.learnConditionService.setLearnConditionVoListV110(learnConditionList).getData());
        //获取评测
        CourseEvaluate courseEvaluate = new CourseEvaluate();
        courseEvaluate.setCourseId(course.getId());
        courseEvaluate.setIsEnabled(CourseEvaluate.IS_ENABLED_TURE);
        courseEvaluate.setSort(0);
        courseDetailVo.setCourseEvaluateList(this.courseEvaluateMapper.selectListByConditions(courseEvaluate));
        responseMessage.setData(courseDetailVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage updateByOngoingCourse() {
        ResponseMessage responseMessage = new ResponseMessage();
        Course course = new Course();
        course.setCourseStatus(Course.COURSE_STATUS_OPEN);
        course.setTrainingStatus(Course.TRAINING_STATUS_ONGOING);
        this.courseMapper.updateByOngoingCourse(course);
        return responseMessage;
    }

    @Override
    public ResponseMessage updateByEndedCourse() {
        ResponseMessage responseMessage = new ResponseMessage();
        Course course = new Course();
        course.setCourseStatus(Course.COURSE_STATUS_OPEN);
        course.setTrainingStatus(Course.TRAINING_STATUS_ENDED);
        this.courseMapper.updateByEndedCourse(course);
        return responseMessage;
    }

    @Override
    public ResponseMessage findIsAboutToBeginCourse() {
        //异步发送短信、信息推送
        this.courseBeauticianRefAsyncTask.findIsAboutToBeginCourseSendMessage();
        return new ResponseMessage<>();
    }

    @Override
    public ResponseMessage updateScheduling() {
        //更新即将开始的课程
        ResponseMessage responseMessage = this.updateByOngoingCourse();
        if (ResponseUtil.isFail(responseMessage)) {
            return responseMessage;
        }
        //更新已经结束的课程
        responseMessage = this.updateByEndedCourse();
        return responseMessage;
    }


    /**
     * 删除的后续操作，去到指定数据表里面删除 处理门槛、图片
     *
     * @param deleteMap
     */
    private void deleteCourseByConditionAndImg(Map<String, List<Integer>> deleteMap) {
        deleteCourseByEvalAndProduct(deleteMap);
        List<Integer> learnConditionIds = deleteMap.get(CourseConstant.Param.LEARN_CONDITION_IDS);
        List<Integer> learnImgIds = deleteMap.get(CourseConstant.Param.LEARN_IMG_IDS);
        if (null != learnImgIds) {
            learnImgMapper.deleteByPrimaryKeyList(learnImgIds);
        }
        if (null != learnConditionIds) {
            learnConditionMapper.deleteByPrimaryKeyList(learnConditionIds);
        }
    }

    /**
     * 删除的后续操作，去到指定数据表里面删除 处理课程测评、关联项目
     *
     * @param deleteMap
     */
    private void deleteCourseByEvalAndProduct(Map<String, List<Integer>> deleteMap) {
        List<Integer> courseProductRefIds = deleteMap.get(CourseConstant.Param.COURSE_PRODUCT_REF_IDS);
        List<Integer> courseEvaluateIds = deleteMap.get(CourseConstant.Param.COURSE_EVALUATE_IDS);
        if (null != courseProductRefIds) {
            courseProductRefMapper.deleteByPrimaryKeyList(courseProductRefIds);
        }
        if (null != courseEvaluateIds) {
            courseEvaluateMapper.deleteByPrimaryKeyList(courseEvaluateIds);
        }
    }


    /**
     * 删除的前置操作，获取所有课程相关数据的id
     *
     * @param course
     * @return
     */
    public Map<String, List<Integer>> deleteCourseBefore(Course course) {
        Map<String, List<Integer>> map = new HashMap<>(4);

        LearnCondition learnCondition = new LearnCondition();
        learnCondition.setSourceId(course.getId());
        learnCondition.setSourceType(LearnCondition.SOURCE_TYPE_COURSE);
        learnCondition.setIsEnabled(LearnCondition.IS_ENABLED_TURE);
        List<LearnCondition> learnConditionList = learnConditionMapper.selectListByConditions(learnCondition);
        List<Integer> learnConditionIds = null;
        if (null != learnConditionList && learnConditionList.size() != 0) {
            learnConditionIds = learnConditionList.stream().map(LearnCondition::getId).collect(Collectors.toList());
        }

        CourseEvaluate courseEvaluate = new CourseEvaluate();
        courseEvaluate.setCourseId(course.getId());
        courseEvaluate.setIsEnabled(CourseEvaluate.IS_ENABLED_TURE);
        List<CourseEvaluate> courseEvaluateList = courseEvaluateMapper.selectListByConditions(courseEvaluate);
        List<Integer> courseEvaluateIds = null;
        if (null != courseEvaluateList && courseEvaluateList.size() != 0) {
            courseEvaluateIds = courseEvaluateList.stream().map(CourseEvaluate::getId).collect(Collectors.toList());
        }

        LearnImg learnImg = new LearnImg();
        learnImg.setSourceId(course.getId());
        learnImg.setSourceType(LearnImg.SOURCE_TYPE_COURSE);
        List<LearnImg> learnImgList = learnImgMapper.selectListByConditions(learnImg);
        List<Integer> learnImgIds = null;
        if (null != learnImgList && learnImgList.size() != 0) {
            learnImgIds = learnImgList.stream().map(LearnImg::getId).collect(Collectors.toList());
        }

        CourseProductRef courseProductRef = new CourseProductRef();
        courseProductRef.setCourseId(course.getId());
        courseProductRef.setIsEnabled(CourseProductRef.IS_ENABLED_TURE);
        List<CourseProductRef> courseProductRefList = courseProductRefMapper.selectListByConditions(courseProductRef);
        List<Integer> courseProductRefIds = null;
        if (null != courseProductRefList && courseProductRefList.size() != 0) {
            courseProductRefIds = courseProductRefList.stream().map(CourseProductRef::getId).collect(Collectors.toList());
        }
        map.put(CourseConstant.Param.LEARN_CONDITION_IDS, learnConditionIds);
        map.put(CourseConstant.Param.COURSE_EVALUATE_IDS, courseEvaluateIds);
        map.put(CourseConstant.Param.LEARN_IMG_IDS, learnImgIds);
        map.put(CourseConstant.Param.COURSE_PRODUCT_REF_IDS, courseProductRefIds);
        return map;
    }


    /**
     * 保存课程数据公共方法
     *
     * @param courseDataVo
     */
    private void insertCourse(CourseDataVo courseDataVo) {
        Course insertCourse = courseDataVo.getCourse();
        //是否免费
        if (insertCourse.getTrainingExpenses() != 0) {
            insertCourse.setIsFree(Course.IS_FREE_TRUE);
        } else {
            insertCourse.setIsFree(Course.IS_FREE_FALSE);
        }
        //是否有人数限定
        if (insertCourse.getTrainingAllowNumber() != 0) {
            insertCourse.setIsRestrict(Course.IS_RESTRICT_TRUE);
        } else {
            insertCourse.setIsRestrict(Course.IS_RESTRICT_FALSE);
        }
        //结束时间计算
        insertCourse.setTrainingEnd(DateUtil.getStrByDate(DateUtil.getNewDateByDelay(DateUtil.getDateByStr(insertCourse.getTrainingBegin()), insertCourse.getTrainingDay(), insertCourse.getTrainingHours(), 0)));
        //判断是否有门槛
        if (null != courseDataVo.getLearnConditionList() && courseDataVo.getLearnConditionList().size() > 0) {
            insertCourse.setIsCondition(Course.IS_CONDITION_TRUE);
        } else {
            insertCourse.setIsCondition(Course.IS_CONDITION_FALSE);
        }

        //课程发布
        courseMapper.insertSelective(insertCourse);
        Integer courseId = insertCourse.getId();

        //课程图片
        List<LearnImg> learnImgList = new ArrayList<LearnImg>();
        for (int i = 0, len = courseDataVo.getLearnImgList().size(); i < len; i++) {
            LearnImg learnImg = new LearnImg();
            if (i == 0) {
                learnImg.setMainStatus(LearnImg.MAIN_STATUS_MAIN);
            } else {
                learnImg.setMainStatus(LearnImg.MAIN_STATUS_SLAVE);
            }
            learnImg.setSourceType(LearnImg.SOURCE_TYPE_COURSE);
            learnImg.setSourceId(courseId);
            learnImg.setImgUrl(courseDataVo.getLearnImgList().get(i));
            learnImg.setSort(i);
            learnImgList.add(learnImg);
        }
        if (learnImgList.size() != 0) {
            learnImgMapper.addBatch(learnImgList);
        }

        //门槛
        List<LearnCondition> learnConditionList = courseDataVo.getLearnConditionList();
        if (null != learnConditionList && learnConditionList.size() > 0) {
            for (LearnCondition learnCondition : learnConditionList) {
                learnCondition.setSourceId(courseId);
                learnCondition.setSourceType(LearnCondition.SOURCE_TYPE_COURSE);
            }
            learnConditionMapper.addBatch(learnConditionList);
        }
        //保存课程的 课程测评、关联项目
        insertCourseByEvalAndProduct(courseDataVo);
    }

    /**
     * 保存课程的 课程测评、关联项目
     *
     * @param courseDataVo
     */
    private void insertCourseByEvalAndProduct(CourseDataVo courseDataVo) {
        Integer courseId = courseDataVo.getCourse().getId();

        //课程对应的服务发布
        if (null != courseDataVo.getInsertCourseProductVo() && courseDataVo.getInsertCourseProductVo().size() > 0) {
            List<CourseProductRef> courseProductRefList = new ArrayList<>(10);
            courseDataVo.getInsertCourseProductVo().forEach(x -> {
                courseProductRefList.add(new CourseProductRef(null, courseId, x.getServiceId(), x.getServiceName(), x.getServerTypeName(), null, x.getIsSupportHome() == 1 ? true : false, null, null));
            });
            courseProductRefMapper.addBatch(courseProductRefList);
        }

        //评测
        List<CourseEvaluate> courseEvaluateList = courseDataVo.getCourseEvaluateList();
        if (null != courseEvaluateList && courseEvaluateList.size() > 0) {
            for (int i = 0, len = courseEvaluateList.size(); i < len; i++) {
                courseEvaluateList.get(i).setCourseId(courseId);
                courseEvaluateList.get(i).setSort(i);
            }
            courseEvaluateMapper.addBatch(courseEvaluateList);
        }
    }

}