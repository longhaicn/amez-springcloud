package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.aimei.learn.mapper.CourseBeauticianRefMapper;
import com.union.aimei.learn.mapper.CourseMapper;
import com.union.aimei.learn.mapper.LearnImgMapper;
import com.union.aimei.learn.service.CourseService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程表
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private LearnImgMapper learnImgMapper;

    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    /**
     * 前端分页查询课程表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    @Override
    public PageInfo<Course> findByPageForFrontV110(Integer pageNo, Integer pageSize, Course course) {
        course.setIsEnabled(Course.IS_ENABLED_TURE);
        PageHelper.startPage(pageNo, pageSize);
        List<Course> list = this.courseMapper.selectListByConditions(course);
        PageInfo<Course> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<PageInfo<CourseResultVo>> selectCourseListByBeauticV110(Integer pageNo, Integer pageSize, CourseParamVo courseParamVo) {
        if (courseParamVo.getType() == CourseParamVo.TYPE_LIST) {
            ResponseMessage<StoreBeautician> responseMessage = this.storeBeauticianFeign.findById(courseParamVo.getBeauticianId());
            ResponseUtil.isFailThrowException(responseMessage);
            courseParamVo.setStoreBeautician(responseMessage.getData());
        }
        ResponseMessage responseMessage = new ResponseMessage();
        courseParamVo.setCourseStatus(CourseParamVo.COURSE_STATUS_OPEN);
        courseParamVo.setTrainingStatus(CourseParamVo.TRAINING_STATUS_ENDED);
        PageHelper.startPage(pageNo, pageSize);
        List<CourseResultVo> list = this.courseMapper.selectCourseListByBeautic(courseParamVo);
        PageInfo<CourseResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<CourseResultVo> selectByCourseIdV110(Integer id, Integer beauticianId) {
        ResponseMessage responseMessage = new ResponseMessage();
        CourseResultVo courseResultVo = this.courseMapper.selectByCourseId(id);

        //获取图片
        LearnImg learnImg = new LearnImg();
        learnImg.setSourceId(courseResultVo.getCourseId());
        learnImg.setSourceType(LearnImg.SOURCE_TYPE_COURSE);
        learnImg.setSort(0);
        courseResultVo.setLearnImgList(learnImgMapper.selectListByConditions(learnImg));

        //美容师试题信息
        CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
        courseBeauticianRef.setCourseId(id);
        courseBeauticianRef.setBeauticianId(beauticianId);
        courseBeauticianRef.setIsEnabled(CourseBeauticianRef.IS_ENABLED_TURE);
        List<CourseBeauticianRef> courseBeauticianRefList = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
        if (null != courseBeauticianRefList && courseBeauticianRefList.size() == 1) {
            courseResultVo.setCourseBeauticianRef(courseBeauticianRefList.get(0));
        }

        //判断详情页面显示的按钮
        if (isSignButton(courseResultVo)) {
            //报名按钮
            courseResultVo.setButtonStatus(CourseResultVo.BUTTON_STATUS_SING_UP);
        } else if (isNoEvaluating(courseResultVo)) {
            //评测按钮（提示课程还未结束，不能进行评测）
            courseResultVo.setButtonStatus(CourseResultVo.BUTTON_STATUS_REVIEW_NO);
        } else if (isEvaluating(courseResultVo)) {
            //评测按钮（可以进行评测操作）
            courseResultVo.setButtonStatus(CourseResultVo.BUTTON_STATUS_REVIEW_YES);
        } else if (isShowEvaluating(courseResultVo)) {
            //查看评测结果
            courseResultVo.setButtonStatus(CourseResultVo.BUTTON_STATUS_RESULTS);
        }

        //设置培训地点
        courseResultVo.setStoreAddress(courseResultVo.getProvinceName() + courseResultVo.getCityName() + courseResultVo.getAreaName() + courseResultVo.getStoreAddress());
        responseMessage.setData(courseResultVo);
        return responseMessage;
    }


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

    /**
     * 判断是否在进行中 或者 未开始的培训状态
     *
     * @param courseResultVo
     * @return
     */
    private boolean isOngoingOrForThe(CourseResultVo courseResultVo) {
        return courseResultVo.getTrainingStatus() == Course.TRAINING_STATUS_ONGOING || courseResultVo.getTrainingStatus() == Course.TRAINING_STATUS_FOR_THE;
    }

    /**
     * 判断课程美容师关联表是否为空
     *
     * @param courseResultVo
     * @return
     */
    private boolean isCourseBeauticianRef(CourseResultVo courseResultVo) {
        return null == courseResultVo.getCourseBeauticianRef();
    }

    /**
     * 判断是否有 报名按钮
     *
     * @param courseResultVo
     * @return
     */
    private boolean isSignButton(CourseResultVo courseResultVo) {
        return courseResultVo.getCourseStatus() == Course.COURSE_STATUS_OPEN && isOngoingOrForThe(courseResultVo) && isCourseBeauticianRef(courseResultVo);
    }

    /**
     * 评测按钮（提示课程还未结束，不能进行评测）
     *
     * @param courseResultVo
     * @return
     */
    private boolean isNoEvaluating(CourseResultVo courseResultVo) {
        return !isCourseBeauticianRef(courseResultVo) && isOngoingOrForThe(courseResultVo);
    }

    /**
     * 评测按钮（可以进行评测操作）
     *
     * @param courseResultVo
     * @return
     */
    private boolean isEvaluating(CourseResultVo courseResultVo) {
        return !isCourseBeauticianRef(courseResultVo) && courseResultVo.getTrainingStatus() == Course.TRAINING_STATUS_ENDED && null == courseResultVo.getCourseBeauticianRef().getEvaluateTime();
    }

    /**
     * 查看评测结果
     *
     * @param courseResultVo
     * @return
     */
    private boolean isShowEvaluating(CourseResultVo courseResultVo) {
        return !isCourseBeauticianRef(courseResultVo) && null != courseResultVo.getCourseBeauticianRef().getEvaluateTime();
    }

}


