package com.union.aimei.common.constant.learn;

/**
 * 活动常量
 *
 * @author houji
 * @time 2018/5/10 13:38
 */
public class ActivityConstant {


    public interface Query {

        int ACTIVITY_NULL = 101;
        String ACTIVITY_NULL_MESSAGE = "查询活动为空";

        int ACTIVITY_SIGN_MORE = 102;
        String ACTIVITY_SIGN_MORE_MESSAGE = "活动报名人数超出限制";

        int ACTIVITY_SIGN_REPEAT = 103;
        String ACTIVITY_SIGN_REPEAT_MESSAGE = "活动报名人员重复,请重新添加报名人员";

    }

    public interface Update {
        int UPDATE_NUMBER = 201;
        String UPDATE_NUMBER_MESSAGE = "更新失败，参数错误";
    }

    public interface Insert {
        int COURSE_NULL = 301;
        String COURSE_NULL_MESSAGE = "查询活动为空";

    }

    public interface Param {
        int COURSE_NULL = 401;
        String COURSE_NULL_MESSAGE = "查询课程为空";
    }

}
