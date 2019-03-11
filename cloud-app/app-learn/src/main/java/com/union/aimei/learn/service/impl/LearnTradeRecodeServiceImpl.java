package com.union.aimei.learn.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.learn.ActivityConstant;
import com.union.aimei.common.constant.learn.CourseConstant;
import com.union.aimei.common.constant.learn.LearnTradeRecodeConstant;
import com.union.aimei.common.constant.store.BeauticianGrowthRuleEnum;
import com.union.aimei.common.feign.app.learn.ActivityFeign;
import com.union.aimei.common.feign.app.learn.ActivityMemberRefFeign;
import com.union.aimei.common.feign.app.learn.CourseBeauticianRefFeign;
import com.union.aimei.common.feign.app.learn.CourseFeign;
import com.union.aimei.common.feign.app.store.GrowthRuleFeign;
import com.union.aimei.common.model.learn.*;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.aimei.common.vo.learn.app.SignUpUserVo;
import com.union.aimei.common.vo.learn.app.TradeRecodeCallBackVo;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.learn.mapper.ActivityMapper;
import com.union.aimei.learn.mapper.ActivityMemberRefMapper;
import com.union.aimei.learn.mapper.CourseBeauticianRefMapper;
import com.union.aimei.learn.mapper.LearnTradeRecodeMapper;
import com.union.aimei.learn.service.CourseBeauticianRefService;
import com.union.aimei.learn.service.LearnTradeRecodeService;
import com.union.common.utils.*;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.create.CreateOrderNo;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("learnTradeRecodeService")
public class LearnTradeRecodeServiceImpl implements LearnTradeRecodeService {
    @Resource
    private LearnTradeRecodeMapper learnTradeRecodeMapper;

    @Resource
    private ActivityMemberRefMapper activityMemberRefMapper;

    @Resource
    private CourseBeauticianRefMapper courseBeauticianRefMapper;

    @Resource
    private CourseBeauticianRefService courseBeauticianRefService;

    @Resource
    private GrowthRuleFeign growthRuleFeign;

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private CourseBeauticianRefFeign courseBeauticianRefFeign;

    @Resource
    private ActivityMemberRefFeign activityMemberRefFeign;

    @Resource
    private CourseFeign courseFeign;

    @Resource
    private ActivityFeign activityFeign;


    /**
     * 前端分页查询交易记录表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param learnTradeRecode 查询条件
     * @return
     */
    @Override
    public PageInfo<LearnTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, LearnTradeRecode learnTradeRecode) {
        PageHelper.startPage(pageNo, pageSize);
        List<LearnTradeRecode> list = this.learnTradeRecodeMapper.selectListByConditions(learnTradeRecode);
        PageInfo<LearnTradeRecode> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<LearnTradeRecode> queryTradeRecode(LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeMapper.selectListByConditions(learnTradeRecode);
    }

    @Override
    public ResponseMessage<LearnTradeRecode> queryTradeRecodeByOrderNo(String orderNo) {
        ResponseMessage result = new ResponseMessage();
        LearnTradeRecode model = this.learnTradeRecodeMapper.queryTradeRecodeByOrderNo(orderNo);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }

    /**
     * 订单回调交易记录
     *
     * @param tradeRecodeCallBackVo
     * @param learnTradeRecode
     */
    private void callBackByTradeRecode(TradeRecodeCallBackVo tradeRecodeCallBackVo, LearnTradeRecode learnTradeRecode) {
        //如果订单类型为活动，要更新活动支付状态
        learnTradeRecode = this.learnTradeRecodeMapper.queryTradeRecodeByOrderNo(tradeRecodeCallBackVo.getOrderNo());
        if (learnTradeRecode.getSourceType() == 1) {
            //根据支付id来修改活动报名状态
            int aRef = this.activityMemberRefMapper.updateStatusByTradeRefId(learnTradeRecode.getId());
            if (aRef > 0) {
                //根据支付id查询用户报名的活动
                ActivityMemberRef amr = new ActivityMemberRef();
                amr.setTradeRefId(learnTradeRecode.getId());
                List<ActivityMemberRef> refList = this.activityMemberRefMapper.selectListByConditions(amr);
                if (!CollectionUtils.isEmpty(refList)) {
                    //如果活动报名状态修改完毕，则更新活动已经报名的人数
                    Activity activity = this.activityMapper.selectByPrimaryKey(refList.get(0).getActivityId());
                    activity.setEnteredSum(activity.getEnteredSum() + refList.size());
                    this.activityMapper.updateByPrimaryKeySelective(activity);

                    //如果参加活动是门店，则添加门店成长值
                    ActivityMemberRef storeRef = refList.get(0);
                    if (storeRef.getStoreId() != null) {
                        GrowthRuleVo growthRuleVo = new GrowthRuleVo();
                        growthRuleVo.setCode(BeauticianGrowthRuleEnum.SIGN_ACTIVITY.getCode());
                        growthRuleVo.setRuleType((byte) 0);
                        growthRuleVo.setSourceId(storeRef.getStoreId());
                        growthRuleVo.setObtainId(storeRef.getActivityId());
                        this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
                    }
                    //如果门店美容师参加活动，则添加美容师成长值
                    List<GrowthRuleVo> growthRuleVoList = new ArrayList<>(10);
                    refList.forEach((ActivityMemberRef beauticianRef) -> {
                        //如果它报名人的标签是朋友，朋友是没有成长值的
                        if (!Objects.equals(beauticianRef.getTag(), ActivityMemberRef.Tag.FRIEND)) {
                            GrowthRuleVo growthRuleVo = new GrowthRuleVo();
                            growthRuleVo.setCode(BeauticianGrowthRuleEnum.SIGN_ACTIVITY.getCode());
                            growthRuleVo.setRuleType((byte) 1);
                            growthRuleVo.setSourceId(beauticianRef.getBeauticianId());
                            growthRuleVo.setObtainId(beauticianRef.getActivityId());
                            growthRuleVoList.add(growthRuleVo);
                        }
                    });
                    //批量添加
                    this.growthRuleFeign.saveBatchGrowthRuleV111(growthRuleVoList);
                }
            } else {
                throw new ServerException(5003, "修改活动报名支付状态失败");
            }
        } else if (learnTradeRecode.getSourceType() == 0) {
            CourseBeauticianRefVo cbrv = new CourseBeauticianRefVo();
            cbrv.setBeauticianId(learnTradeRecode.getBeauticianId());
            cbrv.setBeauticianName(learnTradeRecode.getBeauticianName());
            cbrv.setCourseId(learnTradeRecode.getSourceId());
            cbrv.setGender(learnTradeRecode.getGender());
            cbrv.setMobilePhone(learnTradeRecode.getMobilePhone());
            cbrv.setTradeRefId(learnTradeRecode.getId());
            cbrv.setMemberId(learnTradeRecode.getMemberId());
            ResponseMessage courseRs = this.courseBeauticianRefService.insertCourseBeauticianRefV110(cbrv);
            //参加课程报名美容师成长值
            if (courseRs.getCode() == LearnTradeRecodeConstant.SUCCESS_CODE) {
                GrowthRuleVo growthRuleVo = new GrowthRuleVo();
                growthRuleVo.setCode(BeauticianGrowthRuleEnum.SIGN_COURSE.getCode());
                growthRuleVo.setRuleType((byte) 1);
                growthRuleVo.setSourceId(learnTradeRecode.getBeauticianId());
                growthRuleVo.setObtainId(learnTradeRecode.getSourceId());
                this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
            } else {
                throw new ServerException(5002, "添加课程关联数据失败");
            }
        }
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage tradeRecodeCallBack(TradeRecodeCallBackVo tradeRecodeCallBackVo) {
        ResponseMessage result = new ResponseMessage();
        if (tradeRecodeCallBackVo.getOrderNo() != null) {
            LearnTradeRecode learnTradeRecode = new LearnTradeRecode();
            learnTradeRecode.setOrderNo(tradeRecodeCallBackVo.getOrderNo());
            learnTradeRecode.setTradeNo(tradeRecodeCallBackVo.getTradeNo());
            learnTradeRecode.setPayType(tradeRecodeCallBackVo.getPayType());
            learnTradeRecode.setActualTradeAmount(tradeRecodeCallBackVo.getTradeAmount());
            learnTradeRecode.setPayStatus(true);
            learnTradeRecode.setUpdateTime(new Date());
            //更新订单与交易状态
            int res = this.learnTradeRecodeMapper.updateByOrderNo(learnTradeRecode);
            if (res > 0) {
                this.callBackByTradeRecode(tradeRecodeCallBackVo, learnTradeRecode);
            } else {
                throw new ServerException(5002, "订单状态修改失败");
            }
            AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        } else {
            throw new ServerException(5001, "订单编号为空");
        }
        return result;
    }

    /**
     * 课程
     *
     * @param result
     * @param learnTradeRecode
     */
    private ResponseMessage<LearnTradeRecode> saveCourse(ResponseMessage<LearnTradeRecode> result, LearnTradeRecode learnTradeRecode) {
        //课程报名
        learnTradeRecode.setSourceId(learnTradeRecode.getSourceId());
        learnTradeRecode.setOrderNo(CreateOrderNo.getInstance().GenerateOrder());
        learnTradeRecode.setBeauticianName(learnTradeRecode.getCourseBeauticianRefVo().getBeauticianName());
        learnTradeRecode.setBeauticianId(learnTradeRecode.getCourseBeauticianRefVo().getBeauticianId());
        learnTradeRecode.setGender(learnTradeRecode.getCourseBeauticianRefVo().getGender());
        learnTradeRecode.setMobilePhone(learnTradeRecode.getCourseBeauticianRefVo().getMobilePhone());
        learnTradeRecode.setMemberId(learnTradeRecode.getCourseBeauticianRefVo().getMemberId());
        //查询课程活动费用
        Course course = this.courseFeign.queryById(learnTradeRecode.getSourceId());
        //判断是否超出人数
        if (course.getIsRestrict()) {
            CourseBeauticianRef courseBeauticianRef = new CourseBeauticianRef();
            courseBeauticianRef.setCourseId(course.getId());
            courseBeauticianRef.setIsEnabled(CourseBeauticianRef.IS_ENABLED_TURE);
            ResponseMessage<Integer> responseMessage = this.courseBeauticianRefFeign.findByCountForFrontV110(courseBeauticianRef);
            if (ResponseUtil.isFail(responseMessage)) {
                result.setCode(CourseConstant.Query.COURSE_NULL);
                result.setMessage(CourseConstant.Query.COURSE_NULL_MESSAGE);
                return result;
            }
            //已报名人数
            Integer signTotal = responseMessage.getData();
            if (course.getTrainingAllowNumber() <= signTotal) {
                result.setCode(CourseConstant.Query.COURSE_SIGN_MORE);
                result.setMessage(CourseConstant.Query.COURSE_SIGN_MORE_MESSAGE);
                return result;
            }
        }
        learnTradeRecode.setTradeAmount(course.getTrainingExpenses());
        int recode = this.learnTradeRecodeMapper.insertSelective(learnTradeRecode);
        if (recode > 0) {
            learnTradeRecode = this.learnTradeRecodeMapper.selectByPrimaryKey(learnTradeRecode.getId());
            //当课程报名费用为0，直接报名成功
            if (course.getIsFree() == false) {
                CourseBeauticianRefVo cbrVo = learnTradeRecode.getCourseBeauticianRefVo();
                this.courseBeauticianRefFeign.insertCourseBeauticianRefV110(cbrVo);
            }
            result.setData(learnTradeRecode);
        }
        return result;
    }

    /**
     * 课程
     *
     * @param result
     * @param learnTradeRecode
     */
    private ResponseMessage<LearnTradeRecode> saveActivity(ResponseMessage<LearnTradeRecode> result, LearnTradeRecode learnTradeRecode) {
        Activity activity = this.activityFeign.queryById(learnTradeRecode.getSourceId());
        //当报名人数量和已经报名人的数量之和大于活动限制人数，则报名失败
        if (activity.getEnteredSum() + learnTradeRecode.getSignUpUserVosList().size() > activity.getLimited()) {
            result.setCode(ActivityConstant.Query.ACTIVITY_SIGN_MORE);
            StringBuffer sbTal = new StringBuffer();
            sbTal.append("活动报名人数超出限制，该活动还可报名").append(activity.getLimited() - activity.getEnteredSum()).append("人");
            result.setMessage(sbTal.toString());
        } else {
            //根据活动id和报名人的beauticianId来查询会员是否报名
            ActivityMemberRefVo activityMemberRefVo = new ActivityMemberRefVo();
            activityMemberRefVo.setActivityId(learnTradeRecode.getSourceId());
            List<Integer> beauticianIdList = new ArrayList<>(10);
            for (int i = 0; i < learnTradeRecode.getSignUpUserVosList().size(); i++) {
                if (!Objects.equals(learnTradeRecode.getSignUpUserVosList().get(i).getTag(), SignUpUserVo.Tag.FRIEND)) {
                    beauticianIdList.add(learnTradeRecode.getSignUpUserVosList().get(i).getBeauticianId());
                }
            }
            activityMemberRefVo.setBeauticianIdList(beauticianIdList);
            //判断美容师id的list是否为null，null就不去查询
            if (beauticianIdList.size() > 0) {
                ResponseMessage isBru = this.activityMemberRefFeign.selectRepeatBeauticianIdBatch(activityMemberRefVo);
                if (isBru.getCode() == LearnTradeRecodeConstant.SUCCESS_CODE) {
                    result.setCode(ActivityConstant.Query.ACTIVITY_SIGN_REPEAT);
                    result.setMessage(ActivityConstant.Query.ACTIVITY_SIGN_REPEAT_MESSAGE);
                    return result;
                }
            }
            //活动报名
            //第一步，先添加交易记录
            this.saveLearnTradeRecode(result, learnTradeRecode, activity);
        }
        return result;
    }

    /**
     * 保存交易记录
     *
     * @param result
     * @param learnTradeRecode
     * @param activity
     * @return
     */
    private ResponseMessage<LearnTradeRecode> saveLearnTradeRecode(ResponseMessage<LearnTradeRecode> result, LearnTradeRecode learnTradeRecode, Activity activity) {
        learnTradeRecode.setOrderNo(CreateOrderNo.getInstance().GenerateOrder());
        learnTradeRecode.setTradeAmount(activity.getCosts() * learnTradeRecode.getSignUpUserVosList().size());
        learnTradeRecode.setSourceId(learnTradeRecode.getSourceId());
        int atTra = this.learnTradeRecodeMapper.insertSelective(learnTradeRecode);
        //交易记录添加成功添加活动报名人员的信息
        if (atTra > 0) {
            List<SignUpUserVo> list = learnTradeRecode.getSignUpUserVosList();
            List<ActivityMemberRef> activityMemberRefList = new ArrayList<>(10);
            //批量成长值添加
            List<GrowthRuleVo> growthRuleVoList = new ArrayList<>(10);
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    SignUpUserVo signUpUserVo = list.get(i);
                    ActivityMemberRef activityMemberRef = new ActivityMemberRef();
                    activityMemberRef.setActivityId(learnTradeRecode.getSourceId());
                    activityMemberRef.setTradeRefId(learnTradeRecode.getId());
                    activityMemberRef.setContactPhone(signUpUserVo.getContactPhone());
                    activityMemberRef.setPhone(signUpUserVo.getPhone());
                    activityMemberRef.setName(signUpUserVo.getName());
                    activityMemberRef.setSex(signUpUserVo.getSex());
                    activityMemberRef.setMemeberId(signUpUserVo.getMemberId());
                    activityMemberRef.setStoreId(signUpUserVo.getStoreId());
                    activityMemberRef.setStoreName(signUpUserVo.getStoreName());
                    activityMemberRef.setBeauticianId(signUpUserVo.getBeauticianId());
                    activityMemberRef.setTag(signUpUserVo.getTag());
                    if (activity.getCosts() == 0) {
                        activityMemberRef.setStatus((byte) 0);
                        //当活动报名花费为0，则添加成长值
                        //门店报名只能添加一次成长值
                        if (i == 0) {
                            if (signUpUserVo.getStoreId() != null) {
                                GrowthRuleVo growthRuleVo = new GrowthRuleVo();
                                growthRuleVo.setCode(BeauticianGrowthRuleEnum.SIGN_ACTIVITY.getCode());
                                growthRuleVo.setRuleType((byte) 0);
                                growthRuleVo.setSourceId(signUpUserVo.getStoreId());
                                growthRuleVo.setObtainId(learnTradeRecode.getSourceId());
                                this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
                            }
                        }
                        //添加美容师成长值
                        //朋友是没有成长值的，做一个条件判断
                        if (!Objects.equals(signUpUserVo.getTag(), ActivityMemberRef.Tag.FRIEND)) {
                            GrowthRuleVo growthRuleVo = new GrowthRuleVo();
                            growthRuleVo.setCode(BeauticianGrowthRuleEnum.SIGN_ACTIVITY.getCode());
                            growthRuleVo.setRuleType((byte) 1);
                            growthRuleVo.setSourceId(signUpUserVo.getBeauticianId());
                            growthRuleVo.setObtainId(learnTradeRecode.getSourceId());
                            growthRuleVoList.add(growthRuleVo);
                        }
                    } else {
                        activityMemberRef.setStatus((byte) 2);
                    }
                    activityMemberRefList.add(activityMemberRef);
                }
            }
            //批量添加用户参加活动的信息
            this.activityMemberRefFeign.insertBatch(activityMemberRefList);
            //批量添加美容师成长值
            this.growthRuleFeign.saveBatchGrowthRuleV111(growthRuleVoList);
            //当活动报名的金额0时，用户直接报名成功，不走回掉接口,需要更新活动的人数+N
            if (activity.getCosts() == 0) {
                Activity upSum = new Activity();
                upSum.setId(learnTradeRecode.getSourceId());
                upSum.setEnteredSum(list.size() + activity.getEnteredSum());
                this.activityFeign.edit(upSum);
            }
            //查询出交易记录的信息
            learnTradeRecode = this.learnTradeRecodeMapper.selectByPrimaryKey(learnTradeRecode.getId());
            result.setData(learnTradeRecode);
        }
        return result;
    }

    @Override
    public ResponseMessage<LearnTradeRecode> insert(LearnTradeRecode learnTradeRecode) {
        ResponseMessage<LearnTradeRecode> result = new ResponseMessage<>();
        if (learnTradeRecode.getSourceType() == 0) {
            this.saveCourse(result, learnTradeRecode);
        } else if (learnTradeRecode.getSourceType() == 1) {
            this.saveActivity(result, learnTradeRecode);
        }
        return result;
    }

    /**
     * 添加交易记录表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(LearnTradeRecode t) {
        int res = this.learnTradeRecodeMapper.insertSelective(t);
        if (res > 0) {
            return t.getId();
        } else {
            return -1;
        }
    }


    /**
     * 删除交易记录表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.learnTradeRecodeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改交易记录表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(LearnTradeRecode t) {
        return this.learnTradeRecodeMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnTradeRecode
     */
    @Override
    public LearnTradeRecode queryObjById(int id) {
        LearnTradeRecode model = this.learnTradeRecodeMapper.selectByPrimaryKey(id);
        return model;
    }
}