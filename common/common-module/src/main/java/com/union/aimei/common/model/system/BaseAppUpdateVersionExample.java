package com.union.aimei.common.model.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class BaseAppUpdateVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseAppUpdateVersionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andVersionCodeIsNull() {
            addCriterion("version_code is null");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIsNotNull() {
            addCriterion("version_code is not null");
            return (Criteria) this;
        }

        public Criteria andVersionCodeEqualTo(Integer value) {
            addCriterion("version_code =", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotEqualTo(Integer value) {
            addCriterion("version_code <>", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeGreaterThan(Integer value) {
            addCriterion("version_code >", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_code >=", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeLessThan(Integer value) {
            addCriterion("version_code <", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("version_code <=", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIn(List<Integer> values) {
            addCriterion("version_code in", values, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotIn(List<Integer> values) {
            addCriterion("version_code not in", values, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeBetween(Integer value1, Integer value2) {
            addCriterion("version_code between", value1, value2, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("version_code not between", value1, value2, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNull() {
            addCriterion("version_name is null");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNotNull() {
            addCriterion("version_name is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNameEqualTo(String value) {
            addCriterion("version_name =", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotEqualTo(String value) {
            addCriterion("version_name <>", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThan(String value) {
            addCriterion("version_name >", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThanOrEqualTo(String value) {
            addCriterion("version_name >=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThan(String value) {
            addCriterion("version_name <", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThanOrEqualTo(String value) {
            addCriterion("version_name <=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLike(String value) {
            addCriterion("version_name like", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotLike(String value) {
            addCriterion("version_name not like", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameIn(List<String> values) {
            addCriterion("version_name in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotIn(List<String> values) {
            addCriterion("version_name not in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameBetween(String value1, String value2) {
            addCriterion("version_name between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotBetween(String value1, String value2) {
            addCriterion("version_name not between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andUpdateContentIsNull() {
            addCriterion("update_content is null");
            return (Criteria) this;
        }

        public Criteria andUpdateContentIsNotNull() {
            addCriterion("update_content is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateContentEqualTo(String value) {
            addCriterion("update_content =", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotEqualTo(String value) {
            addCriterion("update_content <>", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentGreaterThan(String value) {
            addCriterion("update_content >", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentGreaterThanOrEqualTo(String value) {
            addCriterion("update_content >=", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentLessThan(String value) {
            addCriterion("update_content <", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentLessThanOrEqualTo(String value) {
            addCriterion("update_content <=", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentLike(String value) {
            addCriterion("update_content like", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotLike(String value) {
            addCriterion("update_content not like", value, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentIn(List<String> values) {
            addCriterion("update_content in", values, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotIn(List<String> values) {
            addCriterion("update_content not in", values, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentBetween(String value1, String value2) {
            addCriterion("update_content between", value1, value2, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateContentNotBetween(String value1, String value2) {
            addCriterion("update_content not between", value1, value2, "updateContent");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlIsNull() {
            addCriterion("update_url is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlIsNotNull() {
            addCriterion("update_url is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlEqualTo(String value) {
            addCriterion("update_url =", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotEqualTo(String value) {
            addCriterion("update_url <>", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlGreaterThan(String value) {
            addCriterion("update_url >", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("update_url >=", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlLessThan(String value) {
            addCriterion("update_url <", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlLessThanOrEqualTo(String value) {
            addCriterion("update_url <=", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlLike(String value) {
            addCriterion("update_url like", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotLike(String value) {
            addCriterion("update_url not like", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlIn(List<String> values) {
            addCriterion("update_url in", values, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotIn(List<String> values) {
            addCriterion("update_url not in", values, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlBetween(String value1, String value2) {
            addCriterion("update_url between", value1, value2, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotBetween(String value1, String value2) {
            addCriterion("update_url not between", value1, value2, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeIsNull() {
            addCriterion("app_system_type is null");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeIsNotNull() {
            addCriterion("app_system_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeEqualTo(Integer value) {
            addCriterion("app_system_type =", value, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeNotEqualTo(Integer value) {
            addCriterion("app_system_type <>", value, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeGreaterThan(Integer value) {
            addCriterion("app_system_type >", value, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_system_type >=", value, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeLessThan(Integer value) {
            addCriterion("app_system_type <", value, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("app_system_type <=", value, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeIn(List<Integer> values) {
            addCriterion("app_system_type in", values, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeNotIn(List<Integer> values) {
            addCriterion("app_system_type not in", values, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeBetween(Integer value1, Integer value2) {
            addCriterion("app_system_type between", value1, value2, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppSystemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_system_type not between", value1, value2, "appSystemType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeIsNull() {
            addCriterion("app_client_type is null");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeIsNotNull() {
            addCriterion("app_client_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeEqualTo(Integer value) {
            addCriterion("app_client_type =", value, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeNotEqualTo(Integer value) {
            addCriterion("app_client_type <>", value, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeGreaterThan(Integer value) {
            addCriterion("app_client_type >", value, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_client_type >=", value, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeLessThan(Integer value) {
            addCriterion("app_client_type <", value, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeLessThanOrEqualTo(Integer value) {
            addCriterion("app_client_type <=", value, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeIn(List<Integer> values) {
            addCriterion("app_client_type in", values, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeNotIn(List<Integer> values) {
            addCriterion("app_client_type not in", values, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeBetween(Integer value1, Integer value2) {
            addCriterion("app_client_type between", value1, value2, "appClientType");
            return (Criteria) this;
        }

        public Criteria andAppClientTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_client_type not between", value1, value2, "appClientType");
            return (Criteria) this;
        }

        public Criteria andForcedIsNull() {
            addCriterion("forced is null");
            return (Criteria) this;
        }

        public Criteria andForcedIsNotNull() {
            addCriterion("forced is not null");
            return (Criteria) this;
        }

        public Criteria andForcedEqualTo(Integer value) {
            addCriterion("forced =", value, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedNotEqualTo(Integer value) {
            addCriterion("forced <>", value, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedGreaterThan(Integer value) {
            addCriterion("forced >", value, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedGreaterThanOrEqualTo(Integer value) {
            addCriterion("forced >=", value, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedLessThan(Integer value) {
            addCriterion("forced <", value, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedLessThanOrEqualTo(Integer value) {
            addCriterion("forced <=", value, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedIn(List<Integer> values) {
            addCriterion("forced in", values, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedNotIn(List<Integer> values) {
            addCriterion("forced not in", values, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedBetween(Integer value1, Integer value2) {
            addCriterion("forced between", value1, value2, "forced");
            return (Criteria) this;
        }

        public Criteria andForcedNotBetween(Integer value1, Integer value2) {
            addCriterion("forced not between", value1, value2, "forced");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateIsNull() {
            addCriterion("ignore_update is null");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateIsNotNull() {
            addCriterion("ignore_update is not null");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateEqualTo(Integer value) {
            addCriterion("ignore_update =", value, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateNotEqualTo(Integer value) {
            addCriterion("ignore_update <>", value, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateGreaterThan(Integer value) {
            addCriterion("ignore_update >", value, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ignore_update >=", value, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateLessThan(Integer value) {
            addCriterion("ignore_update <", value, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("ignore_update <=", value, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateIn(List<Integer> values) {
            addCriterion("ignore_update in", values, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateNotIn(List<Integer> values) {
            addCriterion("ignore_update not in", values, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateBetween(Integer value1, Integer value2) {
            addCriterion("ignore_update between", value1, value2, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andIgnoreUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("ignore_update not between", value1, value2, "ignoreUpdate");
            return (Criteria) this;
        }

        public Criteria andMd5IsNull() {
            addCriterion("md5 is null");
            return (Criteria) this;
        }

        public Criteria andMd5IsNotNull() {
            addCriterion("md5 is not null");
            return (Criteria) this;
        }

        public Criteria andMd5EqualTo(String value) {
            addCriterion("md5 =", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotEqualTo(String value) {
            addCriterion("md5 <>", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThan(String value) {
            addCriterion("md5 >", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThanOrEqualTo(String value) {
            addCriterion("md5 >=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThan(String value) {
            addCriterion("md5 <", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThanOrEqualTo(String value) {
            addCriterion("md5 <=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Like(String value) {
            addCriterion("md5 like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotLike(String value) {
            addCriterion("md5 not like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5In(List<String> values) {
            addCriterion("md5 in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotIn(List<String> values) {
            addCriterion("md5 not in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Between(String value1, String value2) {
            addCriterion("md5 between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotBetween(String value1, String value2) {
            addCriterion("md5 not between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
    }
}