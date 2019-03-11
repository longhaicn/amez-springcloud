package com.union.aimei.common.constant.learn;


import com.union.aimei.common.model.learn.LearnCondition;

/**
 * 条件名称枚举
 *
 * @author caizhaoming
 * @create 2018-05-17 17:57
 **/
public enum LearnConditionNameEnum {

    /**
     * 认证美容师
     */
    CERTIFIED_BEAUTICIAN ("认证美容师", LearnCondition.CERTIFIED_BEAUTICIAN),
    /**
     * 兼职美容师
     */
    PART_TIME_BEAUTICIAN ("兼职美容师", LearnCondition.PART_TIME_BEAUTICIAN),
    /**
     * 全职美容师
     */
    FULL_TIME_BEAUTICIAN ("全职美容师", LearnCondition.FULL_TIME_BEAUTICIAN),
    /**
     * 有挂靠门店
     */
    STORE ("有挂靠门店", LearnCondition.STORE),
    /**
     * 等级
     */
    LEVEL ("等级", LearnCondition.LEVEL),
    /**
     * 星级
     */
    STAR ("星级", LearnCondition.STAR),
    /**
     * 认证门店
     */
    CERTIFIED_STORE ("认证门店", LearnCondition.CERTIFIED_STORE),
    /**
     * 等级
     */
    LEVEL_SOTCK ("等级", LearnCondition.LEVEL_SOTCK);

    private String name;
    private int index;

    public static String getName(int index) {
        for (LearnConditionNameEnum c : LearnConditionNameEnum.values ()) {
            if (c.getIndex () == index) {
                return c.name;
            }
        }
        return null;
    }

    LearnConditionNameEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

}

