package com.union.aimei.common.constant.learn;

/**
 * 课程常量
 *
 * @author caizhaoming
 * @time 2018/5/10 13:38
 */
public class CourseConstant {


    public interface Query {
        int DUPLICATE_COURSE_NUMBER = 201;
        String DUPLICATE_COURSE_NUMBER_MESSAGE = "课程编号不可重复";

        String DUPLICATE_ARRANG_COURSE_NUMBER_MESSAGE = "排课编号不可重复";
        String COURSE_IS_SIGNED_NO_WITHDRAWN = "该课程已有美容师报名，无法撤回";
        String COURSE_IS_CLOSE = "该课程已结束，修改无效";

        int COURSE_NULL = 202;
        String COURSE_NULL_MESSAGE = "查询课程为空";

        int COURSE_SIGN_MORE = 203;
        String COURSE_SIGN_MORE_MESSAGE = "课程报名人数超出限制";

    }

    public interface Update {
        int UPDATE_NUMBER = 201;
        String UPDATE_NUMBER_MESSAGE = "更新失败，参数错误";
    }

    public interface Insert {
        int INSERT_NUMBER = 201;
        String INSERT_NUMBER_MESSAGE = "新增失败";
        String INSERT_NUMBER_MESSAGE_NOT_COURSE_ID = "新增失败,未传递courseId";

    }

    public interface Param {
        String LEARN_CONDITION_IDS = "learnConditionIds";
        String COURSE_EVALUATE_IDS = "courseEvaluateIds";
        String COURSE_PRODUCT_REF_IDS = "courseProductRefIds";
        String LEARN_IMG_IDS = "learnImgIds";
    }

}
