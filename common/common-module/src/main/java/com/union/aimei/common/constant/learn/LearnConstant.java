package com.union.aimei.common.constant.learn;

/**
 * 学习常量
 *
 * @author caizhaoming
 * @create 2018-05-18 10:00
 **/
public class LearnConstant {

    public static final int ERROR_CODE = 201;
    public static final int ERROR_CODE_NOT_PARAM = 202;

    public static final String NULL = "null";

    public interface Insert {
        String COSMETOLOGIST_DATA_ERROR = "美容师数据错误";
        String COURSE_DATA_ERROR = "课程数据错误";
        String ACTIVITY_DATA_ERROR = "活动数据错误";
        String STORE_DATA_ERROR = "店铺数据错误";
        String ERROR = "数据类型错误";
        String ERROR_SOURCE = "来源类型错误";
        String NOT_PROVINCE = "省份不能为空";
        String NOT_CITY = "城市不能为空";
        String NOT_AREA = "区不能为空";
        String NOT_DETAIL_ADDRESS = "详情地址不能为空";
    }

    public interface Check {
        String INSUFFICIENT_THRESHOLD_CONDITIONS = "门槛条件不足";
        String INSUFFICIENT_PRE_COURSE_CONDITIONS = "前置课程条件不足";
    }


    public interface Delete {
        int FAIL = 3001;
        String FAIL_MSG = "删除店铺失败";
    }

    public interface Update {
        int FAIL = 4001;
        String FAIL_MSG = "更新店铺失败";
    }


    public static class Query {
        public static final int PAPER_NOT_EXIST = 5000;
        public static final String PAPER_NOT_EXIST_MSG = "试卷不存在";
        public static final int FQA_NOT_EXIST = 5001;
        public static final String FQA_NOT_EXIST_MSG = "常见问题不存在";
        public static final int CATEGORY_FQA_NULL = 5002;
        public static final String CATEGORY_FQA_NULL_MSG = "该分类下常见问题为空";
        public static final int COURSE_BEAUTICIAN_REF_MSG_CODE = 201;
        public static final String COURSE_BEAUTICIAN_REF_MSG = "已报名该课程";
        public static final String MISSING_PAYMENT_TRANSACTION_RECORD_REFID = "缺少支付交易记录refid";
        public static final String COURSE_ENROLLED = "该课程已下架，不可报名";
        public static final String ACTIVITY_ENROLLED = "该活动已下架，不可报名";
        public static final String COURSE_NUMBER_BEYOND = "课程报名的人数超出，不可报名";
        public static final String ACTIVITY_NUMBER_BEYOND = "活动报名的人数超出，不可报名";

    }


}
