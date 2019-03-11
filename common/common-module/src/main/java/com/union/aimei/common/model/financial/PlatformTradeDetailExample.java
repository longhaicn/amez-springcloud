package com.union.aimei.common.model.financial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class PlatformTradeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatformTradeDetailExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberIsNull() {
            addCriterion("transaction_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberIsNotNull() {
            addCriterion("transaction_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberEqualTo(String value) {
            addCriterion("transaction_serial_number =", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotEqualTo(String value) {
            addCriterion("transaction_serial_number <>", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberGreaterThan(String value) {
            addCriterion("transaction_serial_number >", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_serial_number >=", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberLessThan(String value) {
            addCriterion("transaction_serial_number <", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("transaction_serial_number <=", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberLike(String value) {
            addCriterion("transaction_serial_number like", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotLike(String value) {
            addCriterion("transaction_serial_number not like", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberIn(List<String> values) {
            addCriterion("transaction_serial_number in", values, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotIn(List<String> values) {
            addCriterion("transaction_serial_number not in", values, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberBetween(String value1, String value2) {
            addCriterion("transaction_serial_number between", value1, value2, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotBetween(String value1, String value2) {
            addCriterion("transaction_serial_number not between", value1, value2, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(Integer value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(Integer value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(Integer value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(Integer value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<Integer> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<Integer> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(Integer value1, Integer value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(Integer value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(Integer value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(Integer value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(Integer value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<Integer> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<Integer> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(Integer value1, Integer value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(Integer value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(Integer value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(Integer value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(Integer value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<Integer> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<Integer> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountIsNull() {
            addCriterion("actually_amount is null");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountIsNotNull() {
            addCriterion("actually_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountEqualTo(Integer value) {
            addCriterion("actually_amount =", value, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountNotEqualTo(Integer value) {
            addCriterion("actually_amount <>", value, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountGreaterThan(Integer value) {
            addCriterion("actually_amount >", value, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("actually_amount >=", value, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountLessThan(Integer value) {
            addCriterion("actually_amount <", value, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountLessThanOrEqualTo(Integer value) {
            addCriterion("actually_amount <=", value, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountIn(List<Integer> values) {
            addCriterion("actually_amount in", values, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountNotIn(List<Integer> values) {
            addCriterion("actually_amount not in", values, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountBetween(Integer value1, Integer value2) {
            addCriterion("actually_amount between", value1, value2, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andActuallyAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("actually_amount not between", value1, value2, "actuallyAmount");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionIsNull() {
            addCriterion("beautician_commission is null");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionIsNotNull() {
            addCriterion("beautician_commission is not null");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionEqualTo(Integer value) {
            addCriterion("beautician_commission =", value, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionNotEqualTo(Integer value) {
            addCriterion("beautician_commission <>", value, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionGreaterThan(Integer value) {
            addCriterion("beautician_commission >", value, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("beautician_commission >=", value, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionLessThan(Integer value) {
            addCriterion("beautician_commission <", value, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("beautician_commission <=", value, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionIn(List<Integer> values) {
            addCriterion("beautician_commission in", values, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionNotIn(List<Integer> values) {
            addCriterion("beautician_commission not in", values, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionBetween(Integer value1, Integer value2) {
            addCriterion("beautician_commission between", value1, value2, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andBeauticianCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("beautician_commission not between", value1, value2, "beauticianCommission");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeIsNull() {
            addCriterion("store_net_income is null");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeIsNotNull() {
            addCriterion("store_net_income is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeEqualTo(Integer value) {
            addCriterion("store_net_income =", value, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeNotEqualTo(Integer value) {
            addCriterion("store_net_income <>", value, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeGreaterThan(Integer value) {
            addCriterion("store_net_income >", value, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_net_income >=", value, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeLessThan(Integer value) {
            addCriterion("store_net_income <", value, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("store_net_income <=", value, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeIn(List<Integer> values) {
            addCriterion("store_net_income in", values, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeNotIn(List<Integer> values) {
            addCriterion("store_net_income not in", values, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeBetween(Integer value1, Integer value2) {
            addCriterion("store_net_income between", value1, value2, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andStoreNetIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_net_income not between", value1, value2, "storeNetIncome");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountIsNull() {
            addCriterion("settlement_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountIsNotNull() {
            addCriterion("settlement_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountEqualTo(Integer value) {
            addCriterion("settlement_amount =", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountNotEqualTo(Integer value) {
            addCriterion("settlement_amount <>", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountGreaterThan(Integer value) {
            addCriterion("settlement_amount >", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_amount >=", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountLessThan(Integer value) {
            addCriterion("settlement_amount <", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_amount <=", value, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountIn(List<Integer> values) {
            addCriterion("settlement_amount in", values, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountNotIn(List<Integer> values) {
            addCriterion("settlement_amount not in", values, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountBetween(Integer value1, Integer value2) {
            addCriterion("settlement_amount between", value1, value2, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_amount not between", value1, value2, "settlementAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionIsNull() {
            addCriterion("platform_commission is null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionIsNotNull() {
            addCriterion("platform_commission is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionEqualTo(Integer value) {
            addCriterion("platform_commission =", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionNotEqualTo(Integer value) {
            addCriterion("platform_commission <>", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionGreaterThan(Integer value) {
            addCriterion("platform_commission >", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_commission >=", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionLessThan(Integer value) {
            addCriterion("platform_commission <", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("platform_commission <=", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionIn(List<Integer> values) {
            addCriterion("platform_commission in", values, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionNotIn(List<Integer> values) {
            addCriterion("platform_commission not in", values, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionBetween(Integer value1, Integer value2) {
            addCriterion("platform_commission between", value1, value2, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_commission not between", value1, value2, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Integer value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Integer value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Integer value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Integer value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Integer value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Integer> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Integer> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Integer value1, Integer value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayRateIsNull() {
            addCriterion("pay_rate is null");
            return (Criteria) this;
        }

        public Criteria andPayRateIsNotNull() {
            addCriterion("pay_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPayRateEqualTo(Integer value) {
            addCriterion("pay_rate =", value, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateNotEqualTo(Integer value) {
            addCriterion("pay_rate <>", value, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateGreaterThan(Integer value) {
            addCriterion("pay_rate >", value, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_rate >=", value, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateLessThan(Integer value) {
            addCriterion("pay_rate <", value, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_rate <=", value, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateIn(List<Integer> values) {
            addCriterion("pay_rate in", values, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateNotIn(List<Integer> values) {
            addCriterion("pay_rate not in", values, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateBetween(Integer value1, Integer value2) {
            addCriterion("pay_rate between", value1, value2, "payRate");
            return (Criteria) this;
        }

        public Criteria andPayRateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_rate not between", value1, value2, "payRate");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNull() {
            addCriterion("settlement_time is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNotNull() {
            addCriterion("settlement_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeEqualTo(Date value) {
            addCriterion("settlement_time =", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotEqualTo(Date value) {
            addCriterion("settlement_time <>", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThan(Date value) {
            addCriterion("settlement_time >", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settlement_time >=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThan(Date value) {
            addCriterion("settlement_time <", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThanOrEqualTo(Date value) {
            addCriterion("settlement_time <=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIn(List<Date> values) {
            addCriterion("settlement_time in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotIn(List<Date> values) {
            addCriterion("settlement_time not in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeBetween(Date value1, Date value2) {
            addCriterion("settlement_time between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotBetween(Date value1, Date value2) {
            addCriterion("settlement_time not between", value1, value2, "settlementTime");
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

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNull() {
            addCriterion("store_phone is null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNotNull() {
            addCriterion("store_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneEqualTo(String value) {
            addCriterion("store_phone =", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotEqualTo(String value) {
            addCriterion("store_phone <>", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThan(String value) {
            addCriterion("store_phone >", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_phone >=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThan(String value) {
            addCriterion("store_phone <", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThanOrEqualTo(String value) {
            addCriterion("store_phone <=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLike(String value) {
            addCriterion("store_phone like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotLike(String value) {
            addCriterion("store_phone not like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIn(List<String> values) {
            addCriterion("store_phone in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotIn(List<String> values) {
            addCriterion("store_phone not in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneBetween(String value1, String value2) {
            addCriterion("store_phone between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotBetween(String value1, String value2) {
            addCriterion("store_phone not between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStoreBbossIsNull() {
            addCriterion("store_bboss is null");
            return (Criteria) this;
        }

        public Criteria andStoreBbossIsNotNull() {
            addCriterion("store_bboss is not null");
            return (Criteria) this;
        }

        public Criteria andStoreBbossEqualTo(String value) {
            addCriterion("store_bboss =", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossNotEqualTo(String value) {
            addCriterion("store_bboss <>", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossGreaterThan(String value) {
            addCriterion("store_bboss >", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossGreaterThanOrEqualTo(String value) {
            addCriterion("store_bboss >=", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossLessThan(String value) {
            addCriterion("store_bboss <", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossLessThanOrEqualTo(String value) {
            addCriterion("store_bboss <=", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossLike(String value) {
            addCriterion("store_bboss like", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossNotLike(String value) {
            addCriterion("store_bboss not like", value, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossIn(List<String> values) {
            addCriterion("store_bboss in", values, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossNotIn(List<String> values) {
            addCriterion("store_bboss not in", values, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossBetween(String value1, String value2) {
            addCriterion("store_bboss between", value1, value2, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andStoreBbossNotBetween(String value1, String value2) {
            addCriterion("store_bboss not between", value1, value2, "storeBboss");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdIsNull() {
            addCriterion("beautician_id is null");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdIsNotNull() {
            addCriterion("beautician_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdEqualTo(Integer value) {
            addCriterion("beautician_id =", value, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdNotEqualTo(Integer value) {
            addCriterion("beautician_id <>", value, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdGreaterThan(Integer value) {
            addCriterion("beautician_id >", value, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("beautician_id >=", value, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdLessThan(Integer value) {
            addCriterion("beautician_id <", value, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdLessThanOrEqualTo(Integer value) {
            addCriterion("beautician_id <=", value, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdIn(List<Integer> values) {
            addCriterion("beautician_id in", values, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdNotIn(List<Integer> values) {
            addCriterion("beautician_id not in", values, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdBetween(Integer value1, Integer value2) {
            addCriterion("beautician_id between", value1, value2, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianIdNotBetween(Integer value1, Integer value2) {
            addCriterion("beautician_id not between", value1, value2, "beauticianId");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameIsNull() {
            addCriterion("beautician_name is null");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameIsNotNull() {
            addCriterion("beautician_name is not null");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameEqualTo(String value) {
            addCriterion("beautician_name =", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameNotEqualTo(String value) {
            addCriterion("beautician_name <>", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameGreaterThan(String value) {
            addCriterion("beautician_name >", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameGreaterThanOrEqualTo(String value) {
            addCriterion("beautician_name >=", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameLessThan(String value) {
            addCriterion("beautician_name <", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameLessThanOrEqualTo(String value) {
            addCriterion("beautician_name <=", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameLike(String value) {
            addCriterion("beautician_name like", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameNotLike(String value) {
            addCriterion("beautician_name not like", value, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameIn(List<String> values) {
            addCriterion("beautician_name in", values, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameNotIn(List<String> values) {
            addCriterion("beautician_name not in", values, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameBetween(String value1, String value2) {
            addCriterion("beautician_name between", value1, value2, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianNameNotBetween(String value1, String value2) {
            addCriterion("beautician_name not between", value1, value2, "beauticianName");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneIsNull() {
            addCriterion("beautician_phone is null");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneIsNotNull() {
            addCriterion("beautician_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneEqualTo(String value) {
            addCriterion("beautician_phone =", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneNotEqualTo(String value) {
            addCriterion("beautician_phone <>", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneGreaterThan(String value) {
            addCriterion("beautician_phone >", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("beautician_phone >=", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneLessThan(String value) {
            addCriterion("beautician_phone <", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneLessThanOrEqualTo(String value) {
            addCriterion("beautician_phone <=", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneLike(String value) {
            addCriterion("beautician_phone like", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneNotLike(String value) {
            addCriterion("beautician_phone not like", value, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneIn(List<String> values) {
            addCriterion("beautician_phone in", values, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneNotIn(List<String> values) {
            addCriterion("beautician_phone not in", values, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneBetween(String value1, String value2) {
            addCriterion("beautician_phone between", value1, value2, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBeauticianPhoneNotBetween(String value1, String value2) {
            addCriterion("beautician_phone not between", value1, value2, "beauticianPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameIsNull() {
            addCriterion("buyers_nickname is null");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameIsNotNull() {
            addCriterion("buyers_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameEqualTo(String value) {
            addCriterion("buyers_nickname =", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameNotEqualTo(String value) {
            addCriterion("buyers_nickname <>", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameGreaterThan(String value) {
            addCriterion("buyers_nickname >", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("buyers_nickname >=", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameLessThan(String value) {
            addCriterion("buyers_nickname <", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameLessThanOrEqualTo(String value) {
            addCriterion("buyers_nickname <=", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameLike(String value) {
            addCriterion("buyers_nickname like", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameNotLike(String value) {
            addCriterion("buyers_nickname not like", value, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameIn(List<String> values) {
            addCriterion("buyers_nickname in", values, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameNotIn(List<String> values) {
            addCriterion("buyers_nickname not in", values, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameBetween(String value1, String value2) {
            addCriterion("buyers_nickname between", value1, value2, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersNicknameNotBetween(String value1, String value2) {
            addCriterion("buyers_nickname not between", value1, value2, "buyersNickname");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneIsNull() {
            addCriterion("buyers_phone is null");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneIsNotNull() {
            addCriterion("buyers_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneEqualTo(String value) {
            addCriterion("buyers_phone =", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneNotEqualTo(String value) {
            addCriterion("buyers_phone <>", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneGreaterThan(String value) {
            addCriterion("buyers_phone >", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("buyers_phone >=", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneLessThan(String value) {
            addCriterion("buyers_phone <", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneLessThanOrEqualTo(String value) {
            addCriterion("buyers_phone <=", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneLike(String value) {
            addCriterion("buyers_phone like", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneNotLike(String value) {
            addCriterion("buyers_phone not like", value, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneIn(List<String> values) {
            addCriterion("buyers_phone in", values, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneNotIn(List<String> values) {
            addCriterion("buyers_phone not in", values, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneBetween(String value1, String value2) {
            addCriterion("buyers_phone between", value1, value2, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andBuyersPhoneNotBetween(String value1, String value2) {
            addCriterion("buyers_phone not between", value1, value2, "buyersPhone");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Integer value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Integer value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Integer value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Integer value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Integer> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Integer> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andCouponsIsNull() {
            addCriterion("coupons is null");
            return (Criteria) this;
        }

        public Criteria andCouponsIsNotNull() {
            addCriterion("coupons is not null");
            return (Criteria) this;
        }

        public Criteria andCouponsEqualTo(Integer value) {
            addCriterion("coupons =", value, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsNotEqualTo(Integer value) {
            addCriterion("coupons <>", value, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsGreaterThan(Integer value) {
            addCriterion("coupons >", value, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupons >=", value, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsLessThan(Integer value) {
            addCriterion("coupons <", value, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsLessThanOrEqualTo(Integer value) {
            addCriterion("coupons <=", value, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsIn(List<Integer> values) {
            addCriterion("coupons in", values, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsNotIn(List<Integer> values) {
            addCriterion("coupons not in", values, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsBetween(Integer value1, Integer value2) {
            addCriterion("coupons between", value1, value2, "coupons");
            return (Criteria) this;
        }

        public Criteria andCouponsNotBetween(Integer value1, Integer value2) {
            addCriterion("coupons not between", value1, value2, "coupons");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountIsNull() {
            addCriterion("membership_card_discount is null");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountIsNotNull() {
            addCriterion("membership_card_discount is not null");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountEqualTo(Integer value) {
            addCriterion("membership_card_discount =", value, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountNotEqualTo(Integer value) {
            addCriterion("membership_card_discount <>", value, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountGreaterThan(Integer value) {
            addCriterion("membership_card_discount >", value, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("membership_card_discount >=", value, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountLessThan(Integer value) {
            addCriterion("membership_card_discount <", value, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("membership_card_discount <=", value, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountIn(List<Integer> values) {
            addCriterion("membership_card_discount in", values, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountNotIn(List<Integer> values) {
            addCriterion("membership_card_discount not in", values, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountBetween(Integer value1, Integer value2) {
            addCriterion("membership_card_discount between", value1, value2, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andMembershipCardDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("membership_card_discount not between", value1, value2, "membershipCardDiscount");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialIsNull() {
            addCriterion("one_cartoon_preferential is null");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialIsNotNull() {
            addCriterion("one_cartoon_preferential is not null");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialEqualTo(Integer value) {
            addCriterion("one_cartoon_preferential =", value, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialNotEqualTo(Integer value) {
            addCriterion("one_cartoon_preferential <>", value, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialGreaterThan(Integer value) {
            addCriterion("one_cartoon_preferential >", value, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialGreaterThanOrEqualTo(Integer value) {
            addCriterion("one_cartoon_preferential >=", value, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialLessThan(Integer value) {
            addCriterion("one_cartoon_preferential <", value, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialLessThanOrEqualTo(Integer value) {
            addCriterion("one_cartoon_preferential <=", value, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialIn(List<Integer> values) {
            addCriterion("one_cartoon_preferential in", values, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialNotIn(List<Integer> values) {
            addCriterion("one_cartoon_preferential not in", values, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialBetween(Integer value1, Integer value2) {
            addCriterion("one_cartoon_preferential between", value1, value2, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andOneCartoonPreferentialNotBetween(Integer value1, Integer value2) {
            addCriterion("one_cartoon_preferential not between", value1, value2, "oneCartoonPreferential");
            return (Criteria) this;
        }

        public Criteria andMembershiCardIsNull() {
            addCriterion("membershi_card is null");
            return (Criteria) this;
        }

        public Criteria andMembershiCardIsNotNull() {
            addCriterion("membershi_card is not null");
            return (Criteria) this;
        }

        public Criteria andMembershiCardEqualTo(String value) {
            addCriterion("membershi_card =", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardNotEqualTo(String value) {
            addCriterion("membershi_card <>", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardGreaterThan(String value) {
            addCriterion("membershi_card >", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardGreaterThanOrEqualTo(String value) {
            addCriterion("membershi_card >=", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardLessThan(String value) {
            addCriterion("membershi_card <", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardLessThanOrEqualTo(String value) {
            addCriterion("membershi_card <=", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardLike(String value) {
            addCriterion("membershi_card like", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardNotLike(String value) {
            addCriterion("membershi_card not like", value, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardIn(List<String> values) {
            addCriterion("membershi_card in", values, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardNotIn(List<String> values) {
            addCriterion("membershi_card not in", values, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardBetween(String value1, String value2) {
            addCriterion("membershi_card between", value1, value2, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andMembershiCardNotBetween(String value1, String value2) {
            addCriterion("membershi_card not between", value1, value2, "membershiCard");
            return (Criteria) this;
        }

        public Criteria andCardContentIsNull() {
            addCriterion("card_content is null");
            return (Criteria) this;
        }

        public Criteria andCardContentIsNotNull() {
            addCriterion("card_content is not null");
            return (Criteria) this;
        }

        public Criteria andCardContentEqualTo(String value) {
            addCriterion("card_content =", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotEqualTo(String value) {
            addCriterion("card_content <>", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentGreaterThan(String value) {
            addCriterion("card_content >", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentGreaterThanOrEqualTo(String value) {
            addCriterion("card_content >=", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLessThan(String value) {
            addCriterion("card_content <", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLessThanOrEqualTo(String value) {
            addCriterion("card_content <=", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLike(String value) {
            addCriterion("card_content like", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotLike(String value) {
            addCriterion("card_content not like", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentIn(List<String> values) {
            addCriterion("card_content in", values, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotIn(List<String> values) {
            addCriterion("card_content not in", values, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentBetween(String value1, String value2) {
            addCriterion("card_content between", value1, value2, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotBetween(String value1, String value2) {
            addCriterion("card_content not between", value1, value2, "cardContent");
            return (Criteria) this;
        }

        public Criteria andFaceValueIsNull() {
            addCriterion("face_value is null");
            return (Criteria) this;
        }

        public Criteria andFaceValueIsNotNull() {
            addCriterion("face_value is not null");
            return (Criteria) this;
        }

        public Criteria andFaceValueEqualTo(Integer value) {
            addCriterion("face_value =", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotEqualTo(Integer value) {
            addCriterion("face_value <>", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueGreaterThan(Integer value) {
            addCriterion("face_value >", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("face_value >=", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueLessThan(Integer value) {
            addCriterion("face_value <", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueLessThanOrEqualTo(Integer value) {
            addCriterion("face_value <=", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueIn(List<Integer> values) {
            addCriterion("face_value in", values, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotIn(List<Integer> values) {
            addCriterion("face_value not in", values, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueBetween(Integer value1, Integer value2) {
            addCriterion("face_value between", value1, value2, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotBetween(Integer value1, Integer value2) {
            addCriterion("face_value not between", value1, value2, "faceValue");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardIsNull() {
            addCriterion("sell_card_channel_reward is null");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardIsNotNull() {
            addCriterion("sell_card_channel_reward is not null");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardEqualTo(Integer value) {
            addCriterion("sell_card_channel_reward =", value, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardNotEqualTo(Integer value) {
            addCriterion("sell_card_channel_reward <>", value, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardGreaterThan(Integer value) {
            addCriterion("sell_card_channel_reward >", value, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_card_channel_reward >=", value, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardLessThan(Integer value) {
            addCriterion("sell_card_channel_reward <", value, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardLessThanOrEqualTo(Integer value) {
            addCriterion("sell_card_channel_reward <=", value, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardIn(List<Integer> values) {
            addCriterion("sell_card_channel_reward in", values, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardNotIn(List<Integer> values) {
            addCriterion("sell_card_channel_reward not in", values, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardBetween(Integer value1, Integer value2) {
            addCriterion("sell_card_channel_reward between", value1, value2, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andSellCardChannelRewardNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_card_channel_reward not between", value1, value2, "sellCardChannelReward");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Integer value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Integer value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Integer value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Integer value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Integer value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Integer> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Integer> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Integer value1, Integer value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
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