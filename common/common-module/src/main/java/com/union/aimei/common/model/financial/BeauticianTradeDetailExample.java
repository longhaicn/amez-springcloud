package com.union.aimei.common.model.financial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class BeauticianTradeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BeauticianTradeDetailExample() {
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

        public Criteria andBeauticianTypeIsNull() {
            addCriterion("beautician_type is null");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeIsNotNull() {
            addCriterion("beautician_type is not null");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeEqualTo(Byte value) {
            addCriterion("beautician_type =", value, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeNotEqualTo(Byte value) {
            addCriterion("beautician_type <>", value, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeGreaterThan(Byte value) {
            addCriterion("beautician_type >", value, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("beautician_type >=", value, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeLessThan(Byte value) {
            addCriterion("beautician_type <", value, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeLessThanOrEqualTo(Byte value) {
            addCriterion("beautician_type <=", value, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeIn(List<Byte> values) {
            addCriterion("beautician_type in", values, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeNotIn(List<Byte> values) {
            addCriterion("beautician_type not in", values, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeBetween(Byte value1, Byte value2) {
            addCriterion("beautician_type between", value1, value2, "beauticianType");
            return (Criteria) this;
        }

        public Criteria andBeauticianTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("beautician_type not between", value1, value2, "beauticianType");
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

        public Criteria andProductNumberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(Integer value) {
            addCriterion("product_number =", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(Integer value) {
            addCriterion("product_number <>", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(Integer value) {
            addCriterion("product_number >", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_number >=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(Integer value) {
            addCriterion("product_number <", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(Integer value) {
            addCriterion("product_number <=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<Integer> values) {
            addCriterion("product_number in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<Integer> values) {
            addCriterion("product_number not in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(Integer value1, Integer value2) {
            addCriterion("product_number between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("product_number not between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountIsNull() {
            addCriterion("platform_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountIsNotNull() {
            addCriterion("platform_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountEqualTo(Integer value) {
            addCriterion("platform_amount =", value, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountNotEqualTo(Integer value) {
            addCriterion("platform_amount <>", value, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountGreaterThan(Integer value) {
            addCriterion("platform_amount >", value, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_amount >=", value, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountLessThan(Integer value) {
            addCriterion("platform_amount <", value, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountLessThanOrEqualTo(Integer value) {
            addCriterion("platform_amount <=", value, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountIn(List<Integer> values) {
            addCriterion("platform_amount in", values, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountNotIn(List<Integer> values) {
            addCriterion("platform_amount not in", values, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountBetween(Integer value1, Integer value2) {
            addCriterion("platform_amount between", value1, value2, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_amount not between", value1, value2, "platformAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmounIsNull() {
            addCriterion("store_amoun is null");
            return (Criteria) this;
        }

        public Criteria andStoreAmounIsNotNull() {
            addCriterion("store_amoun is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAmounEqualTo(Integer value) {
            addCriterion("store_amoun =", value, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounNotEqualTo(Integer value) {
            addCriterion("store_amoun <>", value, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounGreaterThan(Integer value) {
            addCriterion("store_amoun >", value, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_amoun >=", value, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounLessThan(Integer value) {
            addCriterion("store_amoun <", value, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounLessThanOrEqualTo(Integer value) {
            addCriterion("store_amoun <=", value, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounIn(List<Integer> values) {
            addCriterion("store_amoun in", values, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounNotIn(List<Integer> values) {
            addCriterion("store_amoun not in", values, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounBetween(Integer value1, Integer value2) {
            addCriterion("store_amoun between", value1, value2, "storeAmoun");
            return (Criteria) this;
        }

        public Criteria andStoreAmounNotBetween(Integer value1, Integer value2) {
            addCriterion("store_amoun not between", value1, value2, "storeAmoun");
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

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Integer value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Integer value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Integer value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Integer value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Integer> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Integer> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Integer value1, Integer value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andVisitAmountIsNull() {
            addCriterion("visit_amount is null");
            return (Criteria) this;
        }

        public Criteria andVisitAmountIsNotNull() {
            addCriterion("visit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andVisitAmountEqualTo(Integer value) {
            addCriterion("visit_amount =", value, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountNotEqualTo(Integer value) {
            addCriterion("visit_amount <>", value, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountGreaterThan(Integer value) {
            addCriterion("visit_amount >", value, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_amount >=", value, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountLessThan(Integer value) {
            addCriterion("visit_amount <", value, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountLessThanOrEqualTo(Integer value) {
            addCriterion("visit_amount <=", value, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountIn(List<Integer> values) {
            addCriterion("visit_amount in", values, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountNotIn(List<Integer> values) {
            addCriterion("visit_amount not in", values, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountBetween(Integer value1, Integer value2) {
            addCriterion("visit_amount between", value1, value2, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andVisitAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_amount not between", value1, value2, "visitAmount");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIsNull() {
            addCriterion("net_income is null");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIsNotNull() {
            addCriterion("net_income is not null");
            return (Criteria) this;
        }

        public Criteria andNetIncomeEqualTo(Integer value) {
            addCriterion("net_income =", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotEqualTo(Integer value) {
            addCriterion("net_income <>", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeGreaterThan(Integer value) {
            addCriterion("net_income >", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_income >=", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeLessThan(Integer value) {
            addCriterion("net_income <", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("net_income <=", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIn(List<Integer> values) {
            addCriterion("net_income in", values, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotIn(List<Integer> values) {
            addCriterion("net_income not in", values, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeBetween(Integer value1, Integer value2) {
            addCriterion("net_income between", value1, value2, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("net_income not between", value1, value2, "netIncome");
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

        public Criteria andTaxationIsNull() {
            addCriterion("taxation is null");
            return (Criteria) this;
        }

        public Criteria andTaxationIsNotNull() {
            addCriterion("taxation is not null");
            return (Criteria) this;
        }

        public Criteria andTaxationEqualTo(Integer value) {
            addCriterion("taxation =", value, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationNotEqualTo(Integer value) {
            addCriterion("taxation <>", value, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationGreaterThan(Integer value) {
            addCriterion("taxation >", value, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationGreaterThanOrEqualTo(Integer value) {
            addCriterion("taxation >=", value, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationLessThan(Integer value) {
            addCriterion("taxation <", value, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationLessThanOrEqualTo(Integer value) {
            addCriterion("taxation <=", value, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationIn(List<Integer> values) {
            addCriterion("taxation in", values, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationNotIn(List<Integer> values) {
            addCriterion("taxation not in", values, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationBetween(Integer value1, Integer value2) {
            addCriterion("taxation between", value1, value2, "taxation");
            return (Criteria) this;
        }

        public Criteria andTaxationNotBetween(Integer value1, Integer value2) {
            addCriterion("taxation not between", value1, value2, "taxation");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNull() {
            addCriterion("actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNotNull() {
            addCriterion("actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualAmountEqualTo(Integer value) {
            addCriterion("actual_amount =", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotEqualTo(Integer value) {
            addCriterion("actual_amount <>", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThan(Integer value) {
            addCriterion("actual_amount >", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_amount >=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThan(Integer value) {
            addCriterion("actual_amount <", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThanOrEqualTo(Integer value) {
            addCriterion("actual_amount <=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIn(List<Integer> values) {
            addCriterion("actual_amount in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotIn(List<Integer> values) {
            addCriterion("actual_amount not in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountBetween(Integer value1, Integer value2) {
            addCriterion("actual_amount between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_amount not between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankBranchIsNull() {
            addCriterion("bank_branch is null");
            return (Criteria) this;
        }

        public Criteria andBankBranchIsNotNull() {
            addCriterion("bank_branch is not null");
            return (Criteria) this;
        }

        public Criteria andBankBranchEqualTo(String value) {
            addCriterion("bank_branch =", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotEqualTo(String value) {
            addCriterion("bank_branch <>", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchGreaterThan(String value) {
            addCriterion("bank_branch >", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchGreaterThanOrEqualTo(String value) {
            addCriterion("bank_branch >=", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchLessThan(String value) {
            addCriterion("bank_branch <", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchLessThanOrEqualTo(String value) {
            addCriterion("bank_branch <=", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchLike(String value) {
            addCriterion("bank_branch like", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotLike(String value) {
            addCriterion("bank_branch not like", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchIn(List<String> values) {
            addCriterion("bank_branch in", values, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotIn(List<String> values) {
            addCriterion("bank_branch not in", values, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchBetween(String value1, String value2) {
            addCriterion("bank_branch between", value1, value2, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotBetween(String value1, String value2) {
            addCriterion("bank_branch not between", value1, value2, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNull() {
            addCriterion("bank_card_no is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNotNull() {
            addCriterion("bank_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoEqualTo(String value) {
            addCriterion("bank_card_no =", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotEqualTo(String value) {
            addCriterion("bank_card_no <>", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThan(String value) {
            addCriterion("bank_card_no >", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_no >=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThan(String value) {
            addCriterion("bank_card_no <", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("bank_card_no <=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLike(String value) {
            addCriterion("bank_card_no like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotLike(String value) {
            addCriterion("bank_card_no not like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIn(List<String> values) {
            addCriterion("bank_card_no in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotIn(List<String> values) {
            addCriterion("bank_card_no not in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoBetween(String value1, String value2) {
            addCriterion("bank_card_no between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotBetween(String value1, String value2) {
            addCriterion("bank_card_no not between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeIsNull() {
            addCriterion("ready_play_amount_time is null");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeIsNotNull() {
            addCriterion("ready_play_amount_time is not null");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeEqualTo(Date value) {
            addCriterion("ready_play_amount_time =", value, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeNotEqualTo(Date value) {
            addCriterion("ready_play_amount_time <>", value, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeGreaterThan(Date value) {
            addCriterion("ready_play_amount_time >", value, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ready_play_amount_time >=", value, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeLessThan(Date value) {
            addCriterion("ready_play_amount_time <", value, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeLessThanOrEqualTo(Date value) {
            addCriterion("ready_play_amount_time <=", value, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeIn(List<Date> values) {
            addCriterion("ready_play_amount_time in", values, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeNotIn(List<Date> values) {
            addCriterion("ready_play_amount_time not in", values, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeBetween(Date value1, Date value2) {
            addCriterion("ready_play_amount_time between", value1, value2, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andReadyPlayAmountTimeNotBetween(Date value1, Date value2) {
            addCriterion("ready_play_amount_time not between", value1, value2, "readyPlayAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeIsNull() {
            addCriterion("play_amount_time is null");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeIsNotNull() {
            addCriterion("play_amount_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeEqualTo(Date value) {
            addCriterion("play_amount_time =", value, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeNotEqualTo(Date value) {
            addCriterion("play_amount_time <>", value, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeGreaterThan(Date value) {
            addCriterion("play_amount_time >", value, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("play_amount_time >=", value, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeLessThan(Date value) {
            addCriterion("play_amount_time <", value, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeLessThanOrEqualTo(Date value) {
            addCriterion("play_amount_time <=", value, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeIn(List<Date> values) {
            addCriterion("play_amount_time in", values, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeNotIn(List<Date> values) {
            addCriterion("play_amount_time not in", values, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeBetween(Date value1, Date value2) {
            addCriterion("play_amount_time between", value1, value2, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountTimeNotBetween(Date value1, Date value2) {
            addCriterion("play_amount_time not between", value1, value2, "playAmountTime");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusIsNull() {
            addCriterion("play_amount_status is null");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusIsNotNull() {
            addCriterion("play_amount_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusEqualTo(Byte value) {
            addCriterion("play_amount_status =", value, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusNotEqualTo(Byte value) {
            addCriterion("play_amount_status <>", value, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusGreaterThan(Byte value) {
            addCriterion("play_amount_status >", value, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("play_amount_status >=", value, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusLessThan(Byte value) {
            addCriterion("play_amount_status <", value, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusLessThanOrEqualTo(Byte value) {
            addCriterion("play_amount_status <=", value, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusIn(List<Byte> values) {
            addCriterion("play_amount_status in", values, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusNotIn(List<Byte> values) {
            addCriterion("play_amount_status not in", values, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusBetween(Byte value1, Byte value2) {
            addCriterion("play_amount_status between", value1, value2, "playAmountStatus");
            return (Criteria) this;
        }

        public Criteria andPlayAmountStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("play_amount_status not between", value1, value2, "playAmountStatus");
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