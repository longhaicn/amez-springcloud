package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.learn.CourseConstant;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByCourseVo;
import com.union.aimei.learn.async.CourseBeauticianRefAsyncTask;
import com.union.aimei.learn.mapper.CourseBeauticianRefMapper;
import com.union.aimei.learn.mapper.CourseMapper;
import com.union.aimei.learn.mapper.CourseProductRefMapper;
import com.union.aimei.learn.service.CourseBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Service("courseBeauticianRefService")
public class CourseBeauticianRefServiceImpl implements CourseBeauticianRefService {

    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Resource
    private CourseProductRefMapper courseProductRefMapper;

    @Resource
    private CourseMapper courseMapper;

    @Autowired
    private CourseBeauticianRefAsyncTask courseBeauticianRefAsyncTask;


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


    /**
     * 添加课程-美容师-关联
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(CourseBeauticianRef t) {
        return this.courseBeauticianRefMapper.insertSelective(t);
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
    public ResponseMessage<PageInfo<CourseBeauticianRef>> findByPageForFrontV110(Integer pageNo, Integer pageSize, BeauticianParamVo beauticianParamVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        List<CourseBeauticianRef> list = this.courseBeauticianRefMapper.selectPageListByConditions(beauticianParamVo);
        PageInfo<CourseBeauticianRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage batchUpdateByIdsTypeV110(UpdateBeauticianVo updateBeauticianVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        switch (updateBeauticianVo.getType()) {
            case UpdateBeauticianVo.TYPE_LEARNING_NO:
                updateBeauticianVo.setLearningStatus(CourseBeauticianRef.LEARNING_STATUS_NO);
                break;
            case UpdateBeauticianVo.TYPE_LEARNING_YES:
                updateBeauticianVo.setBeautiTrainingEnd(new Date());
                updateBeauticianVo.setLearningStatus(CourseBeauticianRef.LEARNING_STATUS_YES);
                break;
            case UpdateBeauticianVo.TYPE_LEARNING_SIGN_NO:
                updateBeauticianVo.setSignStatus(CourseBeauticianRef.SIGN_STATUS_NO);
                break;
            case UpdateBeauticianVo.TYPE_LEARNING_SIGN_YES:
                updateBeauticianVo.setSignStatus(CourseBeauticianRef.SIGN_STATUS_YES);
                break;
            case UpdateBeauticianVo.TYPE_LEARNING_IS_ENABLE:
                updateBeauticianVo.setIsEnabled(CourseBeauticianRef.IS_ENABLED_FALSE);
                break;
            default:
                responseMessage.setCode(CourseConstant.Update.UPDATE_NUMBER);
                responseMessage.setMessage(CourseConstant.Update.UPDATE_NUMBER_MESSAGE);
                break;
        }
        if (ResponseUtil.isFail(responseMessage)) {
            return responseMessage;
        }
        //更新状态
        this.courseBeauticianRefMapper.updateBatch(updateBeauticianVo);
        //异步推送信息
        if (updateBeauticianVo.getType() == UpdateBeauticianVo.TYPE_LEARNING_YES) {
            //保存已经通过培训的美容师项目
            this.courseBeauticianRefAsyncTask.setCoursePass(updateBeauticianVo);
            //推送已通过人员的信息
            this.courseBeauticianRefAsyncTask.sendMessageByLearYes(updateBeauticianVo);
        }
        return responseMessage;
    }


    @Override
    public ResponseMessage<List<ProductBeauticianRefByCourseVo>> selectBeauticianIsOpenService() {
        //查询 已签到，已通过培训的美容师
        CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
        courseBeauticianRef.setLearningStatus(CourseBeauticianRef.LEARNING_STATUS_YES);
        courseBeauticianRef.setSignStatus(CourseBeauticianRef.SIGN_STATUS_YES);
        courseBeauticianRef.setIsEnabled(CourseBeauticianRef.IS_ENABLED_TURE);
        courseBeauticianRef.setIsScheduling(CourseBeauticianRef.IS_SCHEDULING_NO);
        List<CourseBeauticianRef> list = this.courseBeauticianRefMapper.selectListByConditions(courseBeauticianRef);
        return new ResponseMessage<>(getProductBeauticianRefByCourseVos(list));
    }

    /**
     * 更新已经通过培训的美容师
     *
     * @param list
     * @return
     */
    private List<ProductBeauticianRefByCourseVo> getProductBeauticianRefByCourseVos(List<CourseBeauticianRef> list) {
        List<ProductBeauticianRefByCourseVo> productBeauticianRefByCourseVoList = new ArrayList<>(10);
        Map<Integer, ProductBeauticianRefByCourseVo> map = new HashMap<>(10);
        CourseProductRef courseProductRef = new CourseProductRef();
        list.forEach(x -> {
            //更新已保存状态
            CourseBeauticianRef updateCourseBeauticianRef = new CourseBeauticianRef();
            updateCourseBeauticianRef.setId(x.getId());
            updateCourseBeauticianRef.setIsScheduling(CourseBeauticianRef.IS_SCHEDULING_YES);
            this.courseBeauticianRefMapper.updateByPrimaryKeySelective(updateCourseBeauticianRef);
            //查询课程关联的服务
            courseProductRef.setCourseId(x.getCourseId());
            courseProductRef.setIsEnabled(CourseProductRef.IS_ENABLED_TURE);
            List<CourseProductRef> courseProductRefList = this.courseProductRefMapper.selectListByConditions(courseProductRef);
            Set<Integer> serviceSet = courseProductRefList.stream().map(CourseProductRef::getServerId).collect(Collectors.toSet());
            if (serviceSet.size() > 0) {
                if (map.containsKey(x.getBeauticianId())) {
                    map.get(x.getBeauticianId()).getProductIdList().addAll(serviceSet);
                } else {
                    //查询课程数据
                    Course course = this.courseMapper.selectByPrimaryKey(x.getCourseId());
                    ProductBeauticianRefByCourseVo productBeauticianRefByCourseVo = new ProductBeauticianRefByCourseVo();
                    productBeauticianRefByCourseVo.setProductIdList(serviceSet);
                    productBeauticianRefByCourseVo.setBeauticianId(x.getBeauticianId());
                    productBeauticianRefByCourseVo.setCourse(course);
                    productBeauticianRefByCourseVo.setMemberId(x.getMemberId());
                    map.put(x.getBeauticianId(), productBeauticianRefByCourseVo);
                }
            }
        });
        map.forEach((x, y) -> {
            productBeauticianRefByCourseVoList.add(y);
        });
        return productBeauticianRefByCourseVoList;
    }

}