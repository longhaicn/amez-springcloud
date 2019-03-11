package com.union.aimei.common.constant.learn;


import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;

/**
 * 条件类型对应的数据
 *
 * @author caizhaoming
 * @create 2018-05-17 17:57
 **/
public enum LearnConditionDataEnum {

    //认证美容师
    CERTIFIED_BEAUTICIAN (String.valueOf (StoreBeautician.RealNameStatus.PASS), LearnCondition.CERTIFIED_BEAUTICIAN),
    //兼职美容师
    PART_TIME_BEAUTICIAN (String.valueOf (StoreBeautician.BeauticianType.PART_TIME), LearnCondition.PART_TIME_BEAUTICIAN),
    //全职美容师
    FULL_TIME_BEAUTICIAN (String.valueOf (StoreBeautician.BeauticianType.FULL_TIME), LearnCondition.FULL_TIME_BEAUTICIAN),
    //有挂靠门店
    STORE ("", LearnCondition.STORE),
    //认证门店
    CERTIFIED_STORE (String.valueOf (Store.StoreState.OPEN), LearnCondition.CERTIFIED_STORE);


    private String name;
    private int index;

    public static String getName(int index) {
        for (LearnConditionDataEnum c : LearnConditionDataEnum.values ()) {
            if (c.getIndex () == index) {
                return c.name;
            }
        }
        return "";
    }

    LearnConditionDataEnum(String name, int index) {
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

