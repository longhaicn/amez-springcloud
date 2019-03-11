package com.union.aimei.common.util.learn;

import com.union.aimei.common.constant.learn.LearnConditionDataEnum;
import com.union.aimei.common.constant.learn.LearnConditionNameEnum;
import com.union.aimei.common.constant.learn.LearnConstant;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.learn.app.CourseConditionMessage;
import com.union.aimei.common.vo.learn.app.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.common.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 门槛数据工具类
 *
 * @author caizhaoming
 * @create 2018-05-17 17:45
 **/
public class LearnConditionUtil {

    /**
     * 将后台learnConditionList数据转化 为 LearnConditionVoList实体类
     *
     * @param learnConditionList
     * @return
     */
    public static List<LearnConditionVo> setLearnConditionVoList(List<LearnCondition> learnConditionList) {
        List<LearnConditionVo> learnConditionVoList = new ArrayList<>(10);
        if (null != learnConditionList) {
            learnConditionList.forEach(x -> {
                LearnConditionVo learnConditionVo = new LearnConditionVo();
                switch (x.getConditionalType()) {
                    case LearnConditionVo.CERTIFIED_BEAUTICIAN:
                    case LearnConditionVo.PART_TIME_BEAUTICIAN:
                    case LearnConditionVo.FULL_TIME_BEAUTICIAN:
                    case LearnConditionVo.STAR:
                    case LearnConditionVo.STORE:
                        learnConditionVo.setType(x.getConditionalType());
                        break;
                    case LearnConditionVo.LEVEL:
                    case LearnConditionVo.CERTIFIED_STORE:
                    case LearnConditionVo.LEVEL_SOTCK:
                        learnConditionVo.setType(x.getConditionalType());
                        learnConditionVo.setValues(x.getConditionalData());
                        break;
                    default:
                        break;
                }
                learnConditionVo.setNames(x.getConditionName());
                learnConditionVoList.add(learnConditionVo);
            });
        }
        return learnConditionVoList;
    }


    /**
     * 将前台定义传递的数据 转换为 learnCondition 实体类
     *
     * @param learnConditionVoList
     * @return
     */
    public static List<LearnCondition> setLearnConditionList(List<LearnConditionVo> learnConditionVoList) {
        List<LearnCondition> learnConditionList = new ArrayList<>(10);
        if (null != learnConditionVoList) {
            learnConditionVoList.forEach(x -> {
                LearnCondition learnCondition = new LearnCondition();
                switch (x.getType()) {
                    case LearnConditionVo.CERTIFIED_BEAUTICIAN:
                    case LearnConditionVo.PART_TIME_BEAUTICIAN:
                    case LearnConditionVo.FULL_TIME_BEAUTICIAN:
                        learnCondition.setConditionalData(LearnConditionDataEnum.getName(x.getType()));
                        learnCondition.setConditionalAccording(LearnCondition.CONDITIONAL_ACCORDING_AND);
                        break;
                    case LearnConditionVo.STORE:
                        learnCondition.setConditionalData(LearnConditionDataEnum.getName(x.getType()));
                        learnCondition.setConditionalAccording(LearnCondition.CONDITIONAL_ACCORDING_NOT);
                        break;
                    case LearnConditionVo.LEVEL:
                        learnCondition.setConditionalData(x.getValues());
                        learnCondition.setConditionalAccording(LearnCondition.CONDITIONAL_ACCORDING_AND);
                        break;
                    case LearnConditionVo.STAR:
                        learnCondition.setConditionalData(String.valueOf(Integer.parseInt(x.getValues()) * 20));
                        learnCondition.setConditionalAccording(LearnCondition.CONDITIONAL_ACCORDING_AND);
                        break;
                    case LearnConditionVo.CERTIFIED_STORE:
                        learnCondition.setConditionalData(LearnConditionDataEnum.getName(x.getType()));
                        learnCondition.setConditionalAccording(LearnCondition.CONDITIONAL_ACCORDING_AND);
                        break;
                    case LearnConditionVo.LEVEL_SOTCK:
                        learnCondition.setConditionalData(x.getValues());
                        learnCondition.setConditionalAccording(LearnCondition.CONDITIONAL_ACCORDING_AND);
                        break;
                    default:
                        break;
                }
                learnCondition.setConditionalType(x.getType());
                learnCondition.setConditionName(StringUtils.trimToEmpty(x.getNames()) + LearnConditionNameEnum.getName(x.getType()));
                learnConditionList.add(learnCondition);
            });
        }
        return learnConditionList;
    }

    /**
     * 根据美容师、店铺 数据以及门口数据 校验是否具备报名资格
     *
     * @param learnConditionList
     * @param storeBeautician
     * @param store
     * @return
     */
    public static LearnConditionMessageVo checkConditionBeautician(List<LearnCondition> learnConditionList, StoreBeautician storeBeautician, Store store) {
        LearnConditionMessageVo learnConditionMessageVo = new LearnConditionMessageVo();
        boolean result = false;
        for (LearnCondition x : learnConditionList) {
            switch (x.getConditionalType()) {
                case LearnConditionVo.CERTIFIED_BEAUTICIAN:
                    result = checkConditionByAccording(x.getConditionalAccording(),
                            LearnConditionDataEnum.getName(LearnConditionVo.CERTIFIED_BEAUTICIAN),
                            String.valueOf(storeBeautician.getRealNameStatus()));
                    break;
                case LearnConditionVo.PART_TIME_BEAUTICIAN:
                    if (storeBeautician.getBeauticianType() == StoreBeautician.BeauticianType.FULL_TIME) {
                        result = checkConditionByAccording(x.getConditionalAccording(),
                                LearnConditionDataEnum.getName(LearnConditionVo.PART_TIME_BEAUTICIAN),
                                String.valueOf(storeBeautician.getBeauticianType()));
                    } else {
                        result = true;
                    }
                    break;
                case LearnConditionVo.FULL_TIME_BEAUTICIAN:
                    if (storeBeautician.getBeauticianType() == StoreBeautician.BeauticianType.PART_TIME) {
                        result = checkConditionByAccording(x.getConditionalAccording(),
                                LearnConditionDataEnum.getName(LearnConditionVo.FULL_TIME_BEAUTICIAN),
                                String.valueOf(storeBeautician.getBeauticianType()));
                    } else {
                        result = true;
                    }
                    break;
                case LearnConditionVo.STORE:
                    result = checkConditionByAccording(x.getConditionalAccording(),
                            LearnConditionDataEnum.getName(LearnConditionVo.STORE),
                            String.valueOf(storeBeautician.getStoreId()));
                    break;
                case LearnConditionVo.LEVEL:
                    result = checkConditionByAccording(x.getConditionalAccording(),
                            x.getConditionalData(),
                            String.valueOf(storeBeautician.getLevelId()));
                    break;
                case LearnConditionVo.STAR:
                    result = checkConditionByAccording(x.getConditionalAccording(),
                            x.getConditionalData(),
                            String.valueOf(storeBeautician.getBeauticianStar()));
                    break;
                case LearnConditionVo.CERTIFIED_STORE:
                    result = checkConditionByAccording(x.getConditionalAccording(),
                            x.getConditionalData(),
                            String.valueOf(store.getStoreState()));
                    break;
                case LearnConditionVo.LEVEL_SOTCK:
                    result = checkConditionByAccording(x.getConditionalAccording(),
                            x.getConditionalData(),
                            String.valueOf(store.getLevelId()));
                    break;
                default:
                    break;
            }
            if (!result) {
                learnConditionMessageVo.setConditionName(CourseConditionMessage.MESSAGE_NO_BEFORE + StringUtil.trimNull(x.getConditionName()) + CourseConditionMessage.CONDITION_BEFORE);
                break;
            }
        }
        learnConditionMessageVo.setResult(result);
        return learnConditionMessageVo;
    }

    /**
     * 根据门槛判断类型、来源、目标 判断条件
     *
     * @param according 门槛判断类型
     * @param src       来源
     * @param target    目标
     * @return
     */
    private static boolean checkConditionByAccording(Byte according, String src, String target) {
        boolean result = false;
        switch (according) {
            case LearnCondition.CONDITIONAL_ACCORDING_AND:
                result = StringUtils.trimToEmpty(src).equals(StringUtils.trimToEmpty(target));
                break;
            case LearnCondition.CONDITIONAL_ACCORDING_OR:

                break;
            case LearnCondition.CONDITIONAL_ACCORDING_NOT:
                target = LearnConstant.NULL.equalsIgnoreCase(target) ? null : target;
                result = !StringUtils.trimToEmpty(src).equals(StringUtils.trimToEmpty(target));
                break;
            case LearnCondition.CONDITIONAL_ACCORDING_UP:

                break;
            case LearnCondition.CONDITIONAL_ACCORDING_DOWN:

                break;
            default:
                break;
        }
        return result;
    }


    /**
     * 判断前置课程是否满足
     *
     * @param srcMap 源集集合
     * @param target 目标集合
     * @return
     */
    public static LearnConditionMessageVo learnBeforePermission(Map<Integer, String> srcMap, List<Integer> target) {
        LearnConditionMessageVo learnConditionMessageVo = new LearnConditionMessageVo();
        boolean result = false;
        for (Map.Entry<Integer, String> ent : srcMap.entrySet()) {
            if (!target.contains(ent.getKey())) {
                result = false;
                learnConditionMessageVo.setConditionName(ent.getValue());
                break;
            } else {
                result = true;
            }
        }
        learnConditionMessageVo.setResult(result);
        return learnConditionMessageVo;
    }


}
