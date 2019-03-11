package com.union.aimei.learn.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.learn.LearnConstant;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.aimei.learn.mapper.CourseBeauticianRefMapper;
import com.union.aimei.learn.mapper.CourseMapper;
import com.union.aimei.learn.service.CourseBeauticianRefService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程-美容师-关联
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseBeauticianRefService")
public class CourseBeauticianRefServiceImpl implements CourseBeauticianRefService {
    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Resource
    private CourseMapper courseMapper;


    /**
     * 前端分页查询课程-美容师-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param courseBeauticianRef 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, CourseBeauticianRef courseBeauticianRef) {
        PageHelper.startPage(pageNo, pageSize);
        List<CourseBeauticianRef> list = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
        PageInfo<CourseBeauticianRef> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<List<CourseBeauticianRef>> findByListForFrontV110(CourseBeauticianRef courseBeauticianRef) {
        ResponseMessage responseMessage = new ResponseMessage();
        courseBeauticianRef.setIsEnabled(CourseBeauticianRef.IS_ENABLED_TURE);
        List<CourseBeauticianRef> list = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> findByCountForFrontV110(CourseBeauticianRef courseBeauticianRef) {
        return new ResponseMessage<>(this.courseBeauticianRefMapper.selectCountByConditions(courseBeauticianRef));
    }

    @Override
    public ResponseMessage checkBeauticianOnlyV110(Integer beauticianId, Integer courseId) {
        ResponseMessage responseMessage = new ResponseMessage();
        CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
        courseBeauticianRef.setBeauticianId(beauticianId);
        courseBeauticianRef.setCourseId(courseId);
        //判断是否重复报名
        List<CourseBeauticianRef> list = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
        if (list.size() != 0) {
            throw new ServerException(LearnConstant.Query.COURSE_BEAUTICIAN_REF_MSG_CODE, LearnConstant.Query.COURSE_BEAUTICIAN_REF_MSG);
        }
        return responseMessage;
    }


    /**
     * 添加课程-美容师-关联
     *
     * @param t
     * @return
     */
    @Override
    @Deprecated
    public int addObj(CourseBeauticianRef t) {
        throw new ResponseException(201, "该接口已停止服务，请勿调用");
        /*int result = 0;
        int res = this.courseBeauticianRefMapper.insertSelective(t);
        if (res > 0) {
            result = t.getId();
        } else {
            result = -1;
        }
        return result;*/
    }

    /**
     * 删除课程-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.courseBeauticianRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改课程-美容师-关联
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(CourseBeauticianRef t) {
        return this.courseBeauticianRefMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseBeauticianRef
     */
    @Override
    public CourseBeauticianRef queryObjById(int id) {
        CourseBeauticianRef model = this.courseBeauticianRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage insertCourseBeauticianRefV110(CourseBeauticianRefVo courseBeauticianRefVo) {
        ResponseMessage responseMessage = new ResponseMessage();

        //判断是否有支付交易记录refid
        if (null != courseBeauticianRefVo.getTradeRefId() && courseBeauticianRefVo.getTradeRefId() != 0) {

            //判断是否重复提交数据
            CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
            courseBeauticianRef.setCourseId(courseBeauticianRefVo.getCourseId());
            courseBeauticianRef.setBeauticianId(courseBeauticianRefVo.getBeauticianId());
            List<CourseBeauticianRef> list = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
            if (list.size() != 0) {
                throw new ResponseException(LearnConstant.Query.COURSE_BEAUTICIAN_REF_MSG_CODE, LearnConstant.Query.COURSE_BEAUTICIAN_REF_MSG);
            }

            //判断是否为超出人选
            CourseResultVo course = this.courseMapper.selectByCourseId(courseBeauticianRefVo.getCourseId());
            Course cou = new Course();
            cou.setId(course.getCourseId());
            if (course.getIsRestrict() == Course.IS_RESTRICT_TRUE && course.getTrainingAllowNumber() < (course.getTrainingCountNumber() + 1)) {
                cou.setTrainingOutNumber(course.getTrainingOutNumber() + 1);
                courseBeauticianRef.setIsTrainingOut(CourseBeauticianRef.IS_TRAINING_OUT_TURE);
            }

            //基础数据
            courseBeauticianRef.setBeauticianName(courseBeauticianRefVo.getBeauticianName());
            courseBeauticianRef.setGender(courseBeauticianRefVo.getGender());
            courseBeauticianRef.setMobilePhone(courseBeauticianRefVo.getMobilePhone());
            courseBeauticianRef.setTradeRefId(courseBeauticianRefVo.getTradeRefId());
            courseBeauticianRef.setMemberId(courseBeauticianRefVo.getMemberId());

            //更新course表的数据
            cou.setTrainingCountNumber(course.getTrainingCountNumber() + 1);
            this.courseMapper.updateByPrimaryKeySelective(cou);

            //插入美容师报名表数据
            this.courseBeauticianRefMapper.insertSelective(courseBeauticianRef);
            responseMessage.setData(courseBeauticianRef.getId());


        } else {
            throw new ResponseException(LearnConstant.Query.COURSE_BEAUTICIAN_REF_MSG_CODE, LearnConstant.Query.MISSING_PAYMENT_TRANSACTION_RECORD_REFID);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<CourseBeauticianRefResultVo>> findPageCourseBeauticianRefV110(Integer pageNo, Integer pageSize, Integer beauticianId) {
        CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
        courseBeauticianRef.setBeauticianId(beauticianId);
        courseBeauticianRef.setLearningStatus(CourseBeauticianRef.LEARNING_STATUS_YES);
        courseBeauticianRef.setSignStatus(CourseBeauticianRef.SIGN_STATUS_YES);
        PageHelper.startPage(pageNo, pageSize);
        List<CourseBeauticianRefResultVo> list = this.courseBeauticianRefMapper.findPageCourseBeauticianRef(courseBeauticianRef);
        PageInfo<CourseBeauticianRefResultVo> page = new PageInfo<>(list);
        return new ResponseMessage<>(page);
    }

}