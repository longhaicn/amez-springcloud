package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.common.vo.learn.app.*;
import com.union.aimei.learn.mapper.CourseBeauticianRefMapper;
import com.union.aimei.learn.mapper.CourseEvaluateMapper;
import com.union.aimei.learn.mapper.CourseMapper;
import com.union.aimei.learn.service.CourseEvaluateService;
import com.union.common.utils.ResponseMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 查询课程试题
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseEvaluateService")
public class CourseEvaluateServiceImpl implements CourseEvaluateService {

    @Resource
    private CourseEvaluateMapper courseEvaluateMapper;

    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Resource
    private CourseMapper courseMapper;

    /**
     * 前端分页查询课程试题(v1.1.0)
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param courseEvaluate 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseEvaluateResultVo> findByPageForFrontV110(Integer pageNo, Integer pageSize, CourseEvaluate courseEvaluate) {
        List<CourseEvaluateResultVo> beforeList = this.courseEvaluateMapper.selectListByConditionsVo(courseEvaluate);
        for (int i = 0, j = beforeList.size(); i < j; i++) {
            beforeList.get(i).setIndex(i);
        }
        Map<Integer, CourseEvaluateResultVo> map = beforeList.stream().collect(Collectors.toMap(CourseEvaluateResultVo::getId, Function.identity()));

        PageHelper.startPage(pageNo, pageSize);
        courseEvaluate.setIsEnabled(CourseEvaluate.IS_ENABLED_TURE);
        courseEvaluate.setSort(0);
        List<CourseEvaluateResultVo> result = this.courseEvaluateMapper.selectListByConditionsVo(courseEvaluate);
        for (int i = 0, j = result.size(); i < j; i++) {
            if (map.containsKey(result.get(i).getId())) {
                result.get(i).setIndex(map.get(result.get(i).getId()).getIndex());
            }
        }
        PageInfo<CourseEvaluateResultVo> page = new PageInfo<>(result);
        return page;
    }


    /**
     * 添加课程试题
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(CourseEvaluate t) {
        return this.courseEvaluateMapper.insertSelective(t);
    }

    /**
     * 删除课程试题
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.courseEvaluateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改课程试题
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(CourseEvaluate t) {
        return this.courseEvaluateMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseEvaluate
     */
    @Override
    public CourseEvaluate queryObjById(int id) {
        CourseEvaluate model = this.courseEvaluateMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<CourseBeauticianRefVo> checkEvaluateByAnswerV110(CourseEvaluateVo courseEvaluateVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        //查询美容师-试题关联数据
        CourseBeauticianRef courseBeauticianRef1 = this.courseBeauticianRefMapper.selectByPrimaryKey(courseEvaluateVo.getCourseBeauticianId());
        //判断是否已经提交试题
        if (null == courseBeauticianRef1.getEvaluateScore() || null == courseBeauticianRef1.getEvaluateTime()) {
            //美容师提交的 试题-答案
            List<CourseAnswerVo> courseAnswerVoList = courseEvaluateVo.getCourseAnswerVoList();
            Map<Integer, Byte> answerMap = courseAnswerVoList.stream().collect(Collectors.toMap(CourseAnswerVo::getId, CourseAnswerVo::getAnswer, (key1, key2) -> key1));
            //标准答案 试题-答案
            CourseEvaluate courseEvaluate = new CourseEvaluate();
            courseEvaluate.setIsEnabled(CourseEvaluateParamVo.IS_ENABLED_TURE);
            courseEvaluate.setCourseId(courseEvaluateVo.getCourseId());
            List<CourseEvaluate> courseEvaluateList = this.courseEvaluateMapper.selectListByConditions(courseEvaluate);
            //试题答案校对
            double score = 100.0D / courseEvaluateList.size();
            Integer trueEvaluate = 0;
            StringBuffer anwerBuffer = new StringBuffer();
            for (CourseEvaluate x : courseEvaluateList) {
                if (answerMap.get(x.getId()).equals(x.getAnswer())) {
                    trueEvaluate++;
                }
                anwerBuffer.append(answerMap.get(x.getId())).append(",");
            }
            if (anwerBuffer.length() > 0) {
                anwerBuffer.delete(anwerBuffer.length() - 1, anwerBuffer.length());
            }
            int total = Integer.parseInt(new DecimalFormat("0").format(100 * Double.parseDouble(new DecimalFormat("0.00").format(trueEvaluate * score))));
            //美容师报名表数据
            Date evaluateTime = new Date();
            CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
            courseBeauticianRef.setId(courseEvaluateVo.getCourseBeauticianId());
            courseBeauticianRef.setEvaluateScore(total);
            courseBeauticianRef.setEvaluateAnswer(anwerBuffer.toString());
            courseBeauticianRef.setEvaluateTime(evaluateTime);
            this.courseBeauticianRefMapper.updateByPrimaryKeySelective(courseBeauticianRef);
            //更新course数据
            UpdateCourseVo updateCourseVo = new UpdateCourseVo();
            updateCourseVo.setId(courseEvaluateVo.getCourseId());
            updateCourseVo.setType(UpdateCourseVo.TYPE_REVIEW);
            this.courseMapper.updateCourseById(updateCourseVo);
            //设置最后的分数
            courseBeauticianRef1.setEvaluateScore(total);
            courseBeauticianRef1.setEvaluateAnswer(anwerBuffer.toString());
            courseBeauticianRef1.setEvaluateTime(evaluateTime);
        }
        CourseBeauticianRefVo courseBeauticianRefVo = new CourseBeauticianRefVo();
        BeanUtils.copyProperties(courseBeauticianRef1, courseBeauticianRefVo);
        //查询课程名字
        Course course = this.courseMapper.selectByPrimaryKey(courseEvaluateVo.getCourseId());
        courseBeauticianRefVo.setCourseName(course.getCourseName());
        responseMessage.setData(courseBeauticianRefVo);
        return responseMessage;
    }

}