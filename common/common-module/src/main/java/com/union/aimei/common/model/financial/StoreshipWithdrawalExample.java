package com.union.aimei.common.model.financial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class StoreshipWithdrawalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreshipWithdrawalExample() {
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(Double value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(Double value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(Double value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(Double value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(Double value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(Double value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<Double> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<Double> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(Double value1, Double value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(Double value1, Double value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipIsNull() {
            addCriterion("number_bank_slip is null");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipIsNotNull() {
            addCriterion("number_bank_slip is not null");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipEqualTo(Integer value) {
            addCriterion("number_bank_slip =", value, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipNotEqualTo(Integer value) {
            addCriterion("number_bank_slip <>", value, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipGreaterThan(Integer value) {
            addCriterion("number_bank_slip >", value, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_bank_slip >=", value, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipLessThan(Integer value) {
            addCriterion("number_bank_slip <", value, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipLessThanOrEqualTo(Integer value) {
            addCriterion("number_bank_slip <=", value, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipIn(List<Integer> values) {
            addCriterion("number_bank_slip in", values, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipNotIn(List<Integer> values) {
            addCriterion("number_bank_slip not in", values, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipBetween(Integer value1, Integer value2) {
            addCriterion("number_bank_slip between", value1, value2, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andNumberBankSlipNotBetween(Integer value1, Integer value2) {
            addCriterion("number_bank_slip not between", value1, value2, "numberBankSlip");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIsNull() {
            addCriterion("account_number is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIsNotNull() {
            addCriterion("account_number is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberEqualTo(String value) {
            addCriterion("account_number =", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotEqualTo(String value) {
            addCriterion("account_number <>", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberGreaterThan(String value) {
            addCriterion("account_number >", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("account_number >=", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLessThan(String value) {
            addCriterion("account_number <", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("account_number <=", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLike(String value) {
            addCriterion("account_number like", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotLike(String value) {
            addCriterion("account_number not like", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIn(List<String> values) {
            addCriterion("account_number in", values, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotIn(List<String> values) {
            addCriterion("account_number not in", values, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberBetween(String value1, String value2) {
            addCriterion("account_number between", value1, value2, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotBetween(String value1, String value2) {
            addCriterion("account_number not between", value1, value2, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusIsNull() {
            addCriterion("withdrawal_status is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusIsNotNull() {
            addCriterion("withdrawal_status is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusEqualTo(Byte value) {
            addCriterion("withdrawal_status =", value, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusNotEqualTo(Byte value) {
            addCriterion("withdrawal_status <>", value, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusGreaterThan(Byte value) {
            addCriterion("withdrawal_status >", value, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("withdrawal_status >=", value, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusLessThan(Byte value) {
            addCriterion("withdrawal_status <", value, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusLessThanOrEqualTo(Byte value) {
            addCriterion("withdrawal_status <=", value, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusIn(List<Byte> values) {
            addCriterion("withdrawal_status in", values, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusNotIn(List<Byte> values) {
            addCriterion("withdrawal_status not in", values, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusBetween(Byte value1, Byte value2) {
            addCriterion("withdrawal_status between", value1, value2, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawalStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("withdrawal_status not between", value1, value2, "withdrawalStatus");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceIsNull() {
            addCriterion("remaining_balance is null");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceIsNotNull() {
            addCriterion("remaining_balance is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceEqualTo(Double value) {
            addCriterion("remaining_balance =", value, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceNotEqualTo(Double value) {
            addCriterion("remaining_balance <>", value, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceGreaterThan(Double value) {
            addCriterion("remaining_balance >", value, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("remaining_balance >=", value, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceLessThan(Double value) {
            addCriterion("remaining_balance <", value, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceLessThanOrEqualTo(Double value) {
            addCriterion("remaining_balance <=", value, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceIn(List<Double> values) {
            addCriterion("remaining_balance in", values, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceNotIn(List<Double> values) {
            addCriterion("remaining_balance not in", values, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceBetween(Double value1, Double value2) {
            addCriterion("remaining_balance between", value1, value2, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andRemainingBalanceNotBetween(Double value1, Double value2) {
            addCriterion("remaining_balance not between", value1, value2, "remainingBalance");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearIsNull() {
            addCriterion("statistics_year is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearIsNotNull() {
            addCriterion("statistics_year is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearEqualTo(String value) {
            addCriterion("statistics_year =", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearNotEqualTo(String value) {
            addCriterion("statistics_year <>", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearGreaterThan(String value) {
            addCriterion("statistics_year >", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearGreaterThanOrEqualTo(String value) {
            addCriterion("statistics_year >=", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearLessThan(String value) {
            addCriterion("statistics_year <", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearLessThanOrEqualTo(String value) {
            addCriterion("statistics_year <=", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearLike(String value) {
            addCriterion("statistics_year like", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearNotLike(String value) {
            addCriterion("statistics_year not like", value, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearIn(List<String> values) {
            addCriterion("statistics_year in", values, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearNotIn(List<String> values) {
            addCriterion("statistics_year not in", values, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearBetween(String value1, String value2) {
            addCriterion("statistics_year between", value1, value2, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearNotBetween(String value1, String value2) {
            addCriterion("statistics_year not between", value1, value2, "statisticsYear");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthIsNull() {
            addCriterion("statistics_year_month is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthIsNotNull() {
            addCriterion("statistics_year_month is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthEqualTo(String value) {
            addCriterion("statistics_year_month =", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthNotEqualTo(String value) {
            addCriterion("statistics_year_month <>", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthGreaterThan(String value) {
            addCriterion("statistics_year_month >", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthGreaterThanOrEqualTo(String value) {
            addCriterion("statistics_year_month >=", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthLessThan(String value) {
            addCriterion("statistics_year_month <", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthLessThanOrEqualTo(String value) {
            addCriterion("statistics_year_month <=", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthLike(String value) {
            addCriterion("statistics_year_month like", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthNotLike(String value) {
            addCriterion("statistics_year_month not like", value, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthIn(List<String> values) {
            addCriterion("statistics_year_month in", values, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthNotIn(List<String> values) {
            addCriterion("statistics_year_month not in", values, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthBetween(String value1, String value2) {
            addCriterion("statistics_year_month between", value1, value2, "statisticsYearMonth");
            return (Criteria) this;
        }

        public Criteria andStatisticsYearMonthNotBetween(String value1, String value2) {
            addCriterion("statistics_year_month not between", value1, value2, "statisticsYearMonth");
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