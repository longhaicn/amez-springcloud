package com.union.aimei.common.model.financial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class NotificationNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationNoticeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class AbstractGeneratedCriteria {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNull() {
            addCriterion("notice_content is null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNotNull() {
            addCriterion("notice_content is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentEqualTo(String value) {
            addCriterion("notice_content =", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotEqualTo(String value) {
            addCriterion("notice_content <>", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThan(String value) {
            addCriterion("notice_content >", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThanOrEqualTo(String value) {
            addCriterion("notice_content >=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThan(String value) {
            addCriterion("notice_content <", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThanOrEqualTo(String value) {
            addCriterion("notice_content <=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLike(String value) {
            addCriterion("notice_content like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotLike(String value) {
            addCriterion("notice_content not like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIn(List<String> values) {
            addCriterion("notice_content in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotIn(List<String> values) {
            addCriterion("notice_content not in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentBetween(String value1, String value2) {
            addCriterion("notice_content between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotBetween(String value1, String value2) {
            addCriterion("notice_content not between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNull() {
            addCriterion("notice_status is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNotNull() {
            addCriterion("notice_status is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusEqualTo(Integer value) {
            addCriterion("notice_status =", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotEqualTo(Integer value) {
            addCriterion("notice_status <>", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThan(Integer value) {
            addCriterion("notice_status >", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_status >=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThan(Integer value) {
            addCriterion("notice_status <", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("notice_status <=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIn(List<Integer> values) {
            addCriterion("notice_status in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotIn(List<Integer> values) {
            addCriterion("notice_status not in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusBetween(Integer value1, Integer value2) {
            addCriterion("notice_status between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_status not between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeIsNull() {
            addCriterion("notice_start_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeIsNotNull() {
            addCriterion("notice_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeEqualTo(Date value) {
            addCriterion("notice_start_time =", value, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeNotEqualTo(Date value) {
            addCriterion("notice_start_time <>", value, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeGreaterThan(Date value) {
            addCriterion("notice_start_time >", value, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_start_time >=", value, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeLessThan(Date value) {
            addCriterion("notice_start_time <", value, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_start_time <=", value, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeIn(List<Date> values) {
            addCriterion("notice_start_time in", values, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeNotIn(List<Date> values) {
            addCriterion("notice_start_time not in", values, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeBetween(Date value1, Date value2) {
            addCriterion("notice_start_time between", value1, value2, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_start_time not between", value1, value2, "noticeStartTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andUsedTypeIsNull() {
            addCriterion("used_type is null");
            return (Criteria) this;
        }

        public Criteria andUsedTypeIsNotNull() {
            addCriterion("used_type is not null");
            return (Criteria) this;
        }

        public Criteria andUsedTypeEqualTo(Integer value) {
            addCriterion("used_type =", value, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeNotEqualTo(Integer value) {
            addCriterion("used_type <>", value, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeGreaterThan(Integer value) {
            addCriterion("used_type >", value, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("used_type >=", value, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeLessThan(Integer value) {
            addCriterion("used_type <", value, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("used_type <=", value, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeIn(List<Integer> values) {
            addCriterion("used_type in", values, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeNotIn(List<Integer> values) {
            addCriterion("used_type not in", values, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeBetween(Integer value1, Integer value2) {
            addCriterion("used_type between", value1, value2, "usedType");
            return (Criteria) this;
        }

        public Criteria andUsedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("used_type not between", value1, value2, "usedType");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeIsNull() {
            addCriterion("notice_end_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeIsNotNull() {
            addCriterion("notice_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeEqualTo(Date value) {
            addCriterion("notice_end_time =", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeNotEqualTo(Date value) {
            addCriterion("notice_end_time <>", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeGreaterThan(Date value) {
            addCriterion("notice_end_time >", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_end_time >=", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeLessThan(Date value) {
            addCriterion("notice_end_time <", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_end_time <=", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeIn(List<Date> values) {
            addCriterion("notice_end_time in", values, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeNotIn(List<Date> values) {
            addCriterion("notice_end_time not in", values, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeBetween(Date value1, Date value2) {
            addCriterion("notice_end_time between", value1, value2, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_end_time not between", value1, value2, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends AbstractGeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}