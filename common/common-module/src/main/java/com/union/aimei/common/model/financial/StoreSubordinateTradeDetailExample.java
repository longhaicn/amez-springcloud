package com.union.aimei.common.model.financial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class StoreSubordinateTradeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreSubordinateTradeDetailExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Integer value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Integer value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Integer value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Integer value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Integer> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Integer> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountIsNull() {
            addCriterion("discounts_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountIsNotNull() {
            addCriterion("discounts_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountEqualTo(Integer value) {
            addCriterion("discounts_amount =", value, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountNotEqualTo(Integer value) {
            addCriterion("discounts_amount <>", value, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountGreaterThan(Integer value) {
            addCriterion("discounts_amount >", value, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("discounts_amount >=", value, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountLessThan(Integer value) {
            addCriterion("discounts_amount <", value, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("discounts_amount <=", value, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountIn(List<Integer> values) {
            addCriterion("discounts_amount in", values, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountNotIn(List<Integer> values) {
            addCriterion("discounts_amount not in", values, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountBetween(Integer value1, Integer value2) {
            addCriterion("discounts_amount between", value1, value2, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("discounts_amount not between", value1, value2, "discountsAmount");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(Integer value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(Integer value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(Integer value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(Integer value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(Integer value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<Integer> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<Integer> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(Integer value1, Integer value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductDiscountIsNull() {
            addCriterion("product_discount is null");
            return (Criteria) this;
        }

        public Criteria andProductDiscountIsNotNull() {
            addCriterion("product_discount is not null");
            return (Criteria) this;
        }

        public Criteria andProductDiscountEqualTo(Integer value) {
            addCriterion("product_discount =", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountNotEqualTo(Integer value) {
            addCriterion("product_discount <>", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountGreaterThan(Integer value) {
            addCriterion("product_discount >", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_discount >=", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountLessThan(Integer value) {
            addCriterion("product_discount <", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("product_discount <=", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountIn(List<Integer> values) {
            addCriterion("product_discount in", values, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountNotIn(List<Integer> values) {
            addCriterion("product_discount not in", values, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountBetween(Integer value1, Integer value2) {
            addCriterion("product_discount between", value1, value2, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_discount not between", value1, value2, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andCardPriceIsNull() {
            addCriterion("card_price is null");
            return (Criteria) this;
        }

        public Criteria andCardPriceIsNotNull() {
            addCriterion("card_price is not null");
            return (Criteria) this;
        }

        public Criteria andCardPriceEqualTo(Integer value) {
            addCriterion("card_price =", value, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceNotEqualTo(Integer value) {
            addCriterion("card_price <>", value, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceGreaterThan(Integer value) {
            addCriterion("card_price >", value, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_price >=", value, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceLessThan(Integer value) {
            addCriterion("card_price <", value, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceLessThanOrEqualTo(Integer value) {
            addCriterion("card_price <=", value, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceIn(List<Integer> values) {
            addCriterion("card_price in", values, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceNotIn(List<Integer> values) {
            addCriterion("card_price not in", values, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceBetween(Integer value1, Integer value2) {
            addCriterion("card_price between", value1, value2, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("card_price not between", value1, value2, "cardPrice");
            return (Criteria) this;
        }

        public Criteria andCardDiscountIsNull() {
            addCriterion("card_discount is null");
            return (Criteria) this;
        }

        public Criteria andCardDiscountIsNotNull() {
            addCriterion("card_discount is not null");
            return (Criteria) this;
        }

        public Criteria andCardDiscountEqualTo(Integer value) {
            addCriterion("card_discount =", value, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountNotEqualTo(Integer value) {
            addCriterion("card_discount <>", value, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountGreaterThan(Integer value) {
            addCriterion("card_discount >", value, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_discount >=", value, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountLessThan(Integer value) {
            addCriterion("card_discount <", value, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("card_discount <=", value, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountIn(List<Integer> values) {
            addCriterion("card_discount in", values, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountNotIn(List<Integer> values) {
            addCriterion("card_discount not in", values, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountBetween(Integer value1, Integer value2) {
            addCriterion("card_discount between", value1, value2, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("card_discount not between", value1, value2, "cardDiscount");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNull() {
            addCriterion("card_name is null");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNotNull() {
            addCriterion("card_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardNameEqualTo(String value) {
            addCriterion("card_name =", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotEqualTo(String value) {
            addCriterion("card_name <>", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThan(String value) {
            addCriterion("card_name >", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("card_name >=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThan(String value) {
            addCriterion("card_name <", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThanOrEqualTo(String value) {
            addCriterion("card_name <=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLike(String value) {
            addCriterion("card_name like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotLike(String value) {
            addCriterion("card_name not like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameIn(List<String> values) {
            addCriterion("card_name in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotIn(List<String> values) {
            addCriterion("card_name not in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameBetween(String value1, String value2) {
            addCriterion("card_name between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotBetween(String value1, String value2) {
            addCriterion("card_name not between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andActualPayIsNull() {
            addCriterion("actual_pay is null");
            return (Criteria) this;
        }

        public Criteria andActualPayIsNotNull() {
            addCriterion("actual_pay is not null");
            return (Criteria) this;
        }

        public Criteria andActualPayEqualTo(Integer value) {
            addCriterion("actual_pay =", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotEqualTo(Integer value) {
            addCriterion("actual_pay <>", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayGreaterThan(Integer value) {
            addCriterion("actual_pay >", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_pay >=", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayLessThan(Integer value) {
            addCriterion("actual_pay <", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayLessThanOrEqualTo(Integer value) {
            addCriterion("actual_pay <=", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayIn(List<Integer> values) {
            addCriterion("actual_pay in", values, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotIn(List<Integer> values) {
            addCriterion("actual_pay not in", values, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayBetween(Integer value1, Integer value2) {
            addCriterion("actual_pay between", value1, value2, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_pay not between", value1, value2, "actualPay");
            return (Criteria) this;
        }

        public Criteria andIncentiveIsNull() {
            addCriterion("incentive is null");
            return (Criteria) this;
        }

        public Criteria andIncentiveIsNotNull() {
            addCriterion("incentive is not null");
            return (Criteria) this;
        }

        public Criteria andIncentiveEqualTo(Integer value) {
            addCriterion("incentive =", value, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveNotEqualTo(Integer value) {
            addCriterion("incentive <>", value, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveGreaterThan(Integer value) {
            addCriterion("incentive >", value, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("incentive >=", value, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveLessThan(Integer value) {
            addCriterion("incentive <", value, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveLessThanOrEqualTo(Integer value) {
            addCriterion("incentive <=", value, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveIn(List<Integer> values) {
            addCriterion("incentive in", values, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveNotIn(List<Integer> values) {
            addCriterion("incentive not in", values, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveBetween(Integer value1, Integer value2) {
            addCriterion("incentive between", value1, value2, "incentive");
            return (Criteria) this;
        }

        public Criteria andIncentiveNotBetween(Integer value1, Integer value2) {
            addCriterion("incentive not between", value1, value2, "incentive");
            return (Criteria) this;
        }

        public Criteria andMemberDeductIsNull() {
            addCriterion("member_deduct is null");
            return (Criteria) this;
        }

        public Criteria andMemberDeductIsNotNull() {
            addCriterion("member_deduct is not null");
            return (Criteria) this;
        }

        public Criteria andMemberDeductEqualTo(Integer value) {
            addCriterion("member_deduct =", value, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductNotEqualTo(Integer value) {
            addCriterion("member_deduct <>", value, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductGreaterThan(Integer value) {
            addCriterion("member_deduct >", value, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_deduct >=", value, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductLessThan(Integer value) {
            addCriterion("member_deduct <", value, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductLessThanOrEqualTo(Integer value) {
            addCriterion("member_deduct <=", value, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductIn(List<Integer> values) {
            addCriterion("member_deduct in", values, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductNotIn(List<Integer> values) {
            addCriterion("member_deduct not in", values, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductBetween(Integer value1, Integer value2) {
            addCriterion("member_deduct between", value1, value2, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andMemberDeductNotBetween(Integer value1, Integer value2) {
            addCriterion("member_deduct not between", value1, value2, "memberDeduct");
            return (Criteria) this;
        }

        public Criteria andNetAmountIsNull() {
            addCriterion("net_amount is null");
            return (Criteria) this;
        }

        public Criteria andNetAmountIsNotNull() {
            addCriterion("net_amount is not null");
            return (Criteria) this;
        }

        public Criteria andNetAmountEqualTo(Integer value) {
            addCriterion("net_amount =", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountNotEqualTo(Integer value) {
            addCriterion("net_amount <>", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountGreaterThan(Integer value) {
            addCriterion("net_amount >", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_amount >=", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountLessThan(Integer value) {
            addCriterion("net_amount <", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountLessThanOrEqualTo(Integer value) {
            addCriterion("net_amount <=", value, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountIn(List<Integer> values) {
            addCriterion("net_amount in", values, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountNotIn(List<Integer> values) {
            addCriterion("net_amount not in", values, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountBetween(Integer value1, Integer value2) {
            addCriterion("net_amount between", value1, value2, "netAmount");
            return (Criteria) this;
        }

        public Criteria andNetAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("net_amount not between", value1, value2, "netAmount");
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

        public Criteria andSettleAmountIsNull() {
            addCriterion("settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNotNull() {
            addCriterion("settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountEqualTo(Integer value) {
            addCriterion("settle_amount =", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotEqualTo(Integer value) {
            addCriterion("settle_amount <>", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThan(Integer value) {
            addCriterion("settle_amount >", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("settle_amount >=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThan(Integer value) {
            addCriterion("settle_amount <", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThanOrEqualTo(Integer value) {
            addCriterion("settle_amount <=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIn(List<Integer> values) {
            addCriterion("settle_amount in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotIn(List<Integer> values) {
            addCriterion("settle_amount not in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountBetween(Integer value1, Integer value2) {
            addCriterion("settle_amount between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("settle_amount not between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountIsNull() {
            addCriterion("reimburse_amount is null");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountIsNotNull() {
            addCriterion("reimburse_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountEqualTo(Integer value) {
            addCriterion("reimburse_amount =", value, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountNotEqualTo(Integer value) {
            addCriterion("reimburse_amount <>", value, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountGreaterThan(Integer value) {
            addCriterion("reimburse_amount >", value, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reimburse_amount >=", value, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountLessThan(Integer value) {
            addCriterion("reimburse_amount <", value, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountLessThanOrEqualTo(Integer value) {
            addCriterion("reimburse_amount <=", value, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountIn(List<Integer> values) {
            addCriterion("reimburse_amount in", values, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountNotIn(List<Integer> values) {
            addCriterion("reimburse_amount not in", values, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountBetween(Integer value1, Integer value2) {
            addCriterion("reimburse_amount between", value1, value2, "reimburseAmount");
            return (Criteria) this;
        }

        public Criteria andReimburseAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("reimburse_amount not between", value1, value2, "reimburseAmount");
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

        public Criteria andReimburseTimeIsNull() {
            addCriterion("reimburse_time is null");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeIsNotNull() {
            addCriterion("reimburse_time is not null");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeEqualTo(Date value) {
            addCriterion("reimburse_time =", value, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeNotEqualTo(Date value) {
            addCriterion("reimburse_time <>", value, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeGreaterThan(Date value) {
            addCriterion("reimburse_time >", value, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reimburse_time >=", value, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeLessThan(Date value) {
            addCriterion("reimburse_time <", value, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeLessThanOrEqualTo(Date value) {
            addCriterion("reimburse_time <=", value, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeIn(List<Date> values) {
            addCriterion("reimburse_time in", values, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeNotIn(List<Date> values) {
            addCriterion("reimburse_time not in", values, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeBetween(Date value1, Date value2) {
            addCriterion("reimburse_time between", value1, value2, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andReimburseTimeNotBetween(Date value1, Date value2) {
            addCriterion("reimburse_time not between", value1, value2, "reimburseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNull() {
            addCriterion("withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNotNull() {
            addCriterion("withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountEqualTo(Integer value) {
            addCriterion("withdraw_amount =", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotEqualTo(Integer value) {
            addCriterion("withdraw_amount <>", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThan(Integer value) {
            addCriterion("withdraw_amount >", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_amount >=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThan(Integer value) {
            addCriterion("withdraw_amount <", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_amount <=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIn(List<Integer> values) {
            addCriterion("withdraw_amount in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotIn(List<Integer> values) {
            addCriterion("withdraw_amount not in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_amount between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_amount not between", value1, value2, "withdrawAmount");
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