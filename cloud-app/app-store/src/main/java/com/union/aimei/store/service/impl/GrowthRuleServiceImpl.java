package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.BeauticianGrowthRuleEnum;
import com.union.aimei.common.constant.store.GrowthRuleConstant;
import com.union.aimei.common.constant.store.StoreGrowthRuleEnum;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.store.GrowthRule;
import com.union.aimei.common.model.store.GrowthRuleLog;
import com.union.aimei.common.vo.store.app.GrowthRuleLogVo;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.common.feign.app.learn.ActivityFeign;
import com.union.aimei.common.feign.app.learn.CourseFeign;
import com.union.aimei.store.mapper.GrowthRuleLogMapper;
import com.union.aimei.store.mapper.GrowthRuleMapper;
import com.union.aimei.store.service.GrowthRuleService;
import com.union.aimei.store.service.StoreBeauticianService;
import com.union.aimei.store.service.StoreService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Service("growthRuleService")
public class GrowthRuleServiceImpl implements GrowthRuleService {

    @Resource
    private GrowthRuleMapper growthRuleMapper;

    @Resource
    private GrowthRuleLogMapper growthRuleLogMapper;

    @Resource
    private CourseFeign courseFeign;

    @Resource
    private ActivityFeign activityFeign;

    @Resource
    private StoreBeauticianService storeBeauticianService;

    @Resource
    private StoreService storeService;


    /**
     * 前端分页查询成长规则
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param growthRule 查询条件
     * @return
     */
    @Override
    public PageInfo<GrowthRule> findByPageForFront(Integer pageNo, Integer pageSize, GrowthRule growthRule) {
        PageHelper.startPage(pageNo, pageSize);
        List<GrowthRule> list = this.growthRuleMapper.selectListByConditions(growthRule);
        PageInfo<GrowthRule> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage saveGrowthRuleV111(GrowthRuleVo growthRuleVo) {

        //根据code获取数据
        GrowthRule growthRule = new GrowthRule();
        growthRule.setCode(growthRuleVo.getCode());
        growthRule.setRuleType(growthRuleVo.getRuleType());
        growthRule.setStatus(GrowthRule.Status.EFFECTIVE);
        growthRule.setIsEnabled(GrowthRule.IS_ENABLED_TURE);
        List<GrowthRule> list = this.growthRuleMapper.selectListByConditions(growthRule);
        if (list.size() != 1) {
            throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.THE_CODE_WAS_NOT_FOUND);
        }
        growthRule = list.get(0);

        //保存记录对象
        GrowthRuleLog saveGrowthRuleLog = new GrowthRuleLog();
        BeanUtils.copyProperties(growthRule, saveGrowthRuleLog);
        saveGrowthRuleLog.setRelId(growthRule.getId());
        saveGrowthRuleLog.setSourceType(growthRuleVo.getRuleType());
        saveGrowthRuleLog.setSourceId(growthRuleVo.getSourceId());
        saveGrowthRuleLog.setId(null);
        saveGrowthRuleLog.setIsEnabled(null);
        saveGrowthRuleLog.setCreateTime(null);
        saveGrowthRuleLog.setUpdateTime(null);

        //获取间接取值的成长值
        if (growthRule.getGrowthType() == GrowthRule.GrowthType.INDIRECTCRAWL) {
            //间接
            growthType(growthRuleVo, growthRule, saveGrowthRuleLog);
        }

        //判断条件
        conditionType(growthRuleVo, growthRule, saveGrowthRuleLog);

        //保存到记录表
        int total = this.growthRuleLogMapper.insertSelective(saveGrowthRuleLog);

        //更新门店、美容师成长值
        ResponseMessage responseMessage = new ResponseMessage();
        if (total == 1) {
            if (GrowthRuleVo.RuleTypes.STORE == growthRuleVo.getRuleType()) {
                responseMessage = this.storeService.accumulateGrowthValueV111(growthRuleVo.getSourceId(),
                        saveGrowthRuleLog.getGrowthCalculateType() == GrowthRuleLog.GrowthCalculateType.LESS ?
                                -saveGrowthRuleLog.getGrowthValue() : saveGrowthRuleLog.getGrowthValue());
            } else if (GrowthRuleVo.RuleTypes.BEAUTICIAN == growthRuleVo.getRuleType()) {
                responseMessage = this.storeBeauticianService.accumulateGrowthValueV111(growthRuleVo.getSourceId(),
                        saveGrowthRuleLog.getGrowthCalculateType() == GrowthRuleLog.GrowthCalculateType.LESS ?
                                -saveGrowthRuleLog.getGrowthValue() : saveGrowthRuleLog.getGrowthValue());
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage saveBatchGrowthRuleV111(List<GrowthRuleVo> growthRuleVoList) {
        growthRuleVoList.forEach(x -> saveGrowthRuleV111(x));
        return new ResponseMessage();
    }


    /**
     * 添加成长规则
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(GrowthRule t) {
        return this.growthRuleMapper.insertSelective(t);
    }

    /**
     * 删除成长规则
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.growthRuleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改成长规则
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(GrowthRule t) {
        return this.growthRuleMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returngrowthRule
     */
    @Override
    public GrowthRule queryObjById(int id) {
        GrowthRule model = this.growthRuleMapper.selectByPrimaryKey(id);
        return model;
    }

    /**
     * 成长值条件
     *
     * @param growthRuleVo
     * @param growthRule
     * @param growthRuleLog
     */
    private void growthRuleByCondition(GrowthRuleVo growthRuleVo, GrowthRule growthRule, GrowthRuleLog growthRuleLog) {
        if (null != growthRuleVo.getConnditionId() && 0 != growthRuleVo.getConnditionId()) {
            GrowthRuleLog growthRuleLogConndition = new GrowthRuleLog();
            growthRuleLogConndition.setIsEnabled(GrowthRuleLog.IS_ENABLED_TURE);
            growthRuleLogConndition.setSourceId(growthRuleVo.getSourceId());
            growthRuleLogConndition.setSourceType(growthRule.getRuleType());
            growthRuleLogConndition.setRelId(growthRule.getId());
            growthRuleLogConndition.setConnditionId(growthRuleVo.getConnditionId());
            List<GrowthRuleLog> growthRuleLogConnditionList = this.growthRuleLogMapper.selectListByConditions(growthRuleLogConndition);
            if (growthRuleLogConnditionList.size() != 0) {
                throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.THIS_DATA_HAS_BEEN_ADDED_TO_THE_GROWTH);
            }
            growthRuleLog.setConnditionId(growthRuleVo.getConnditionId());
        }
    }

    /**
     * 次数查询
     *
     * @param growthRuleVo
     * @param growthRule
     */
    private List<GrowthRuleLog> growthRuleLogNext(GrowthRuleVo growthRuleVo, GrowthRule growthRule) {
        GrowthRuleLog growthRuleLogNext = new GrowthRuleLog();
        growthRuleLogNext.setSourceId(growthRuleVo.getSourceId());
        growthRuleLogNext.setSourceType(growthRule.getRuleType());
        growthRuleLogNext.setRelId(growthRule.getId());
        growthRuleLogNext.setIsEnabled(GrowthRuleLog.IS_ENABLED_TURE);
        List<GrowthRuleLog> growthRuleLogList = this.growthRuleLogMapper.selectListByConditions(growthRuleLogNext);
        return growthRuleLogList;
    }

    /**
     * 天数查询
     *
     * @param growthRuleVo
     * @param growthRule
     * @return
     */
    private Integer growthRuleLogDay(GrowthRuleVo growthRuleVo, GrowthRule growthRule) {
        GrowthRuleLogVo growthRuleLogDayVo = new GrowthRuleLogVo();
        growthRuleLogDayVo.setRelId(growthRule.getId());
        growthRuleLogDayVo.setSourceId(growthRuleVo.getSourceId());
        growthRuleLogDayVo.setSourceType(growthRule.getRuleType());
        growthRuleLogDayVo.setIsEnabled(GrowthRuleLog.IS_ENABLED_TURE);
        growthRuleLogDayVo.setStartCreateTime(DateUtil.todayFirstCurrentDate());
        growthRuleLogDayVo.setEndCreateTime(DateUtil.todayLastCurrentDate());
        Map<String, Object> growthRuleLogDayVoMap = this.growthRuleLogMapper.selectListByVo(growthRuleLogDayVo);
        Integer totalGrowthValueDay = Integer.valueOf(String.valueOf(growthRuleLogDayVoMap.get(GrowthRuleConstant.Param.TOTAL_GROWTH_VALUE)));
        return totalGrowthValueDay;
    }

    /**
     * 月数查询
     *
     * @param growthRuleVo
     * @param growthRule
     * @return
     */
    private Integer growthRuleLogMonth(GrowthRuleVo growthRuleVo, GrowthRule growthRule) {
        GrowthRuleLogVo growthRuleLogMonthVo = new GrowthRuleLogVo();
        growthRuleLogMonthVo.setRelId(growthRule.getId());
        growthRuleLogMonthVo.setSourceId(growthRuleVo.getSourceId());
        growthRuleLogMonthVo.setSourceType(growthRule.getRuleType());
        growthRuleLogMonthVo.setIsEnabled(GrowthRuleLog.IS_ENABLED_TURE);
        growthRuleLogMonthVo.setStartCreateTime(DateUtil.getCurrentStartMonth());
        growthRuleLogMonthVo.setEndCreateTime(DateUtil.getCurrentEndMonth());
        Map<String, Object> growthRuleLogMonthVoMap = this.growthRuleLogMapper.selectListByVo(growthRuleLogMonthVo);
        Integer totalGrowthValueMonth = Integer.valueOf(String.valueOf(growthRuleLogMonthVoMap.get(GrowthRuleConstant.Param.TOTAL_GROWTH_VALUE)));
        return totalGrowthValueMonth;
    }


    /**
     * 根据类型条件判断
     *
     * @param growthRuleVo
     * @param growthRule
     */
    private void conditionType(GrowthRuleVo growthRuleVo, GrowthRule growthRule, GrowthRuleLog growthRuleLog) {
        // 判断是否有条件id，有则先查询是否存在 存在则不增加成长值
        this.growthRuleByCondition(growthRuleVo, growthRule, growthRuleLog);
        // 次数查询
        List<GrowthRuleLog> growthRuleLogList = this.growthRuleLogNext(growthRuleVo, growthRule);
        // 天数查询
        Integer totalGrowthValueDay = this.growthRuleLogDay(growthRuleVo, growthRule);
        // 月数查询
        Integer totalGrowthValueMonth = this.growthRuleLogMonth(growthRuleVo, growthRule);
        switch (growthRule.getConditionType()) {
            case GrowthRule.ConditionType.TIMESLIMIT:
                if (growthRule.getConditionValueNumber() <= growthRuleLogList.size()) {
                    //限制次数已满，无法增加成长值
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.THE_NUMBER_OF_LIMITS_IS_FULL);
                }
                break;
            case GrowthRule.ConditionType.NUMERICALLIMIT_DAY_MONTH:
                if (growthRule.getConditionValueMonth() <= totalGrowthValueMonth) {
                    //限制每月上限已满，无法增加成长值
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.LIMIT_MONTHLY_LIMIT_IS_FULL);
                } else if (growthRule.getConditionValueDay() <= totalGrowthValueDay) {
                    //限制每日上限已满，无法增加成长值
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.LIMIT_DAILY_LIMIT_IS_FULL);
                }
                //补齐成长值总数
                if (totalGrowthValueDay + growthRuleLog.getGrowthValue() > growthRule.getConditionValueDay()) {
                    growthRuleLog.setGrowthValue(growthRule.getConditionValueDay() - totalGrowthValueDay);
                }
                break;
            case GrowthRule.ConditionType.NUMERICALLIMIT_DAY:
                if (growthRule.getConditionValueDay() <= totalGrowthValueDay) {
                    //限制每日上限已满，无法增加成长值
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.LIMIT_DAILY_LIMIT_IS_FULL);
                }
                //补齐成长值总数
                if (totalGrowthValueDay + growthRuleLog.getGrowthValue() > growthRule.getConditionValueDay()) {
                    growthRuleLog.setGrowthValue(growthRule.getConditionValueDay() - totalGrowthValueDay);
                }
                break;
            case GrowthRule.ConditionType.NUMERICALLIMIT_MONTH:
                if (growthRule.getConditionValueMonth() <= totalGrowthValueMonth) {
                    //限制每月上限已满，无法增加成长值
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.LIMIT_MONTHLY_LIMIT_IS_FULL);
                }
                //补齐成长值总数
                if (totalGrowthValueMonth + growthRuleLog.getGrowthValue() > growthRule.getConditionValueMonth()) {
                    growthRuleLog.setGrowthValue(growthRule.getConditionValueMonth() - totalGrowthValueMonth);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 获取间接取值的成长值
     *
     * @param growthRuleVo
     * @param growthRule
     * @param saveGrowthRuleLog
     */
    private void growthType(GrowthRuleVo growthRuleVo, GrowthRule growthRule, GrowthRuleLog saveGrowthRuleLog) {
        switch (growthRule.getRuleType()) {
            case GrowthRule.RuleType.STORE:
                if (StoreGrowthRuleEnum.SIGN_ACTIVITY.getCode().equals(growthRule.getCode())) {
                    //活动
                    Activity activity = this.activityFeign.queryById(growthRuleVo.getObtainId());
                    saveGrowthRuleLog.setGrowthValue(activity.getGrowthValue());
                } else {
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.GROWTH_RULE_DATA_GET_ERROR);
                }
                break;
            case GrowthRule.RuleType.BEAUTICIAN:
                if (BeauticianGrowthRuleEnum.SIGN_COURSE.getCode().equals(growthRule.getCode())) {
                    //课程
                    Course course = this.courseFeign.queryById(growthRuleVo.getObtainId());
                    saveGrowthRuleLog.setGrowthValue(course.getGrowthValue());
                } else if (BeauticianGrowthRuleEnum.SIGN_ACTIVITY.getCode().equals(growthRule.getCode())) {
                    //活动
                    Activity activity = this.activityFeign.queryById(growthRuleVo.getObtainId());
                    saveGrowthRuleLog.setGrowthValue(activity.getGrowthValue());
                } else {
                    throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.GROWTH_RULE_DATA_GET_ERROR);
                }
                break;
            default:
                throw new ServerException(GrowthRuleConstant.Save.GROWTH_RULE_CODE, GrowthRuleConstant.Save.LACK_GROWTH_TYPE_MESSAGE);
        }
    }
}