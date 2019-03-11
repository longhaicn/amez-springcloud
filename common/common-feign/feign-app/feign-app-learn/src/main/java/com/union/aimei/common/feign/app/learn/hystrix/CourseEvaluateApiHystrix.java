package com.union.aimei.common.feign.app.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.CourseEvaluateFeign;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.aimei.common.vo.learn.app.CourseEvaluateResultVo;
import com.union.aimei.common.vo.learn.app.CourseEvaluateVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 课程试题
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "app-CourseEvaluateFeign")
public class CourseEvaluateApiHystrix implements CourseEvaluateFeign {

    /**
     * 前端分页查询课程试题
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param courseEvaluate 查询条件
     * @return
     */
    @Override
    public PageInfo<CourseEvaluateResultVo> findByPageForFrontV110(Integer pageNo, Integer pageSize, CourseEvaluate courseEvaluate) {
        return null;
    }

    @Override
    public ResponseMessage<CourseBeauticianRefVo> checkEvaluateByAnswerV110(CourseEvaluateVo courseEvaluateVo) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加课程试题
     *
     * @param courseEvaluate
     * @return
     */
    @Override
    public int insert(CourseEvaluate courseEvaluate) {
        return 0;
    }

    /**
     * 删除课程试题
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改课程试题
     *
     * @param courseEvaluate
     * @return
     */
    @Override
    public int edit(CourseEvaluate courseEvaluate) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourseEvaluate
     */
    @Override
    public CourseEvaluate queryById(int id) {
        return null;
    }
}