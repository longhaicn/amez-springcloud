package com.union.aimei.common.model.financial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class StoreTradeStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreTradeStatisticsExample() {
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

        public Criteria andMonthlyOrderQuantityIsNull() {
            addCriterion("monthly_order_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityIsNotNull() {
            addCriterion("monthly_order_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityEqualTo(Integer value) {
            addCriterion("monthly_order_quantity =", value, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityNotEqualTo(Integer value) {
            addCriterion("monthly_order_quantity <>", value, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityGreaterThan(Integer value) {
            addCriterion("monthly_order_quantity >", value, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthly_order_quantity >=", value, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityLessThan(Integer value) {
            addCriterion("monthly_order_quantity <", value, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("monthly_order_quantity <=", value, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityIn(List<Integer> values) {
            addCriterion("monthly_order_quantity in", values, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityNotIn(List<Integer> values) {
            addCriterion("monthly_order_quantity not in", values, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityBetween(Integer value1, Integer value2) {
            addCriterion("monthly_order_quantity between", value1, value2, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMonthlyOrderQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("monthly_order_quantity not between", value1, value2, "monthlyOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthIsNull() {
            addCriterion("total_sales_this_month is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthIsNotNull() {
            addCriterion("total_sales_this_month is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthEqualTo(Integer value) {
            addCriterion("total_sales_this_month =", value, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthNotEqualTo(Integer value) {
            addCriterion("total_sales_this_month <>", value, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthGreaterThan(Integer value) {
            addCriterion("total_sales_this_month >", value, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_sales_this_month >=", value, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthLessThan(Integer value) {
            addCriterion("total_sales_this_month <", value, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthLessThanOrEqualTo(Integer value) {
            addCriterion("total_sales_this_month <=", value, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthIn(List<Integer> values) {
            addCriterion("total_sales_this_month in", values, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthNotIn(List<Integer> values) {
            addCriterion("total_sales_this_month not in", values, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthBetween(Integer value1, Integer value2) {
            addCriterion("total_sales_this_month between", value1, value2, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andTotalSalesThisMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("total_sales_this_month not between", value1, value2, "totalSalesThisMonth");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsNull() {
            addCriterion("service_order is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsNotNull() {
            addCriterion("service_order is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEqualTo(Integer value) {
            addCriterion("service_order =", value, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNotEqualTo(Integer value) {
            addCriterion("service_order <>", value, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGreaterThan(Integer value) {
            addCriterion("service_order >", value, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order >=", value, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderLessThan(Integer value) {
            addCriterion("service_order <", value, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderLessThanOrEqualTo(Integer value) {
            addCriterion("service_order <=", value, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIn(List<Integer> values) {
            addCriterion("service_order in", values, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNotIn(List<Integer> values) {
            addCriterion("service_order not in", values, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBetween(Integer value1, Integer value2) {
            addCriterion("service_order between", value1, value2, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order not between", value1, value2, "serviceOrder");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountIsNull() {
            addCriterion("service_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountIsNotNull() {
            addCriterion("service_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountEqualTo(Integer value) {
            addCriterion("service_order_amount =", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountNotEqualTo(Integer value) {
            addCriterion("service_order_amount <>", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountGreaterThan(Integer value) {
            addCriterion("service_order_amount >", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_amount >=", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountLessThan(Integer value) {
            addCriterion("service_order_amount <", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_amount <=", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountIn(List<Integer> values) {
            addCriterion("service_order_amount in", values, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountNotIn(List<Integer> values) {
            addCriterion("service_order_amount not in", values, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_amount between", value1, value2, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_amount not between", value1, value2, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedIsNull() {
            addCriterion("order_completed is null");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedIsNotNull() {
            addCriterion("order_completed is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedEqualTo(Integer value) {
            addCriterion("order_completed =", value, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedNotEqualTo(Integer value) {
            addCriterion("order_completed <>", value, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedGreaterThan(Integer value) {
            addCriterion("order_completed >", value, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_completed >=", value, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedLessThan(Integer value) {
            addCriterion("order_completed <", value, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedLessThanOrEqualTo(Integer value) {
            addCriterion("order_completed <=", value, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedIn(List<Integer> values) {
            addCriterion("order_completed in", values, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedNotIn(List<Integer> values) {
            addCriterion("order_completed not in", values, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedBetween(Integer value1, Integer value2) {
            addCriterion("order_completed between", value1, value2, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedNotBetween(Integer value1, Integer value2) {
            addCriterion("order_completed not between", value1, value2, "orderCompleted");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountIsNull() {
            addCriterion("order_completed_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountIsNotNull() {
            addCriterion("order_completed_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountEqualTo(Integer value) {
            addCriterion("order_completed_amount =", value, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountNotEqualTo(Integer value) {
            addCriterion("order_completed_amount <>", value, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountGreaterThan(Integer value) {
            addCriterion("order_completed_amount >", value, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_completed_amount >=", value, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountLessThan(Integer value) {
            addCriterion("order_completed_amount <", value, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_completed_amount <=", value, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountIn(List<Integer> values) {
            addCriterion("order_completed_amount in", values, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountNotIn(List<Integer> values) {
            addCriterion("order_completed_amount not in", values, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_completed_amount between", value1, value2, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCompletedAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_completed_amount not between", value1, value2, "orderCompletedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderIsNull() {
            addCriterion("refund_order is null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderIsNotNull() {
            addCriterion("refund_order is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderEqualTo(Integer value) {
            addCriterion("refund_order =", value, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNotEqualTo(Integer value) {
            addCriterion("refund_order <>", value, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderGreaterThan(Integer value) {
            addCriterion("refund_order >", value, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_order >=", value, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderLessThan(Integer value) {
            addCriterion("refund_order <", value, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderLessThanOrEqualTo(Integer value) {
            addCriterion("refund_order <=", value, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderIn(List<Integer> values) {
            addCriterion("refund_order in", values, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNotIn(List<Integer> values) {
            addCriterion("refund_order not in", values, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderBetween(Integer value1, Integer value2) {
            addCriterion("refund_order between", value1, value2, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_order not between", value1, value2, "refundOrder");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountIsNull() {
            addCriterion("refund_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountIsNotNull() {
            addCriterion("refund_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountEqualTo(Integer value) {
            addCriterion("refund_order_amount =", value, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountNotEqualTo(Integer value) {
            addCriterion("refund_order_amount <>", value, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountGreaterThan(Integer value) {
            addCriterion("refund_order_amount >", value, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_order_amount >=", value, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountLessThan(Integer value) {
            addCriterion("refund_order_amount <", value, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("refund_order_amount <=", value, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountIn(List<Integer> values) {
            addCriterion("refund_order_amount in", values, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountNotIn(List<Integer> values) {
            addCriterion("refund_order_amount not in", values, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("refund_order_amount between", value1, value2, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_order_amount not between", value1, value2, "refundOrderAmount");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(Integer value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(Integer value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(Integer value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(Integer value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(Integer value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<Integer> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<Integer> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(Integer value1, Integer value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsIsNull() {
            addCriterion("sell_card_rewards is null");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsIsNotNull() {
            addCriterion("sell_card_rewards is not null");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsEqualTo(Integer value) {
            addCriterion("sell_card_rewards =", value, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsNotEqualTo(Integer value) {
            addCriterion("sell_card_rewards <>", value, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsGreaterThan(Integer value) {
            addCriterion("sell_card_rewards >", value, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_card_rewards >=", value, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsLessThan(Integer value) {
            addCriterion("sell_card_rewards <", value, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsLessThanOrEqualTo(Integer value) {
            addCriterion("sell_card_rewards <=", value, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsIn(List<Integer> values) {
            addCriterion("sell_card_rewards in", values, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsNotIn(List<Integer> values) {
            addCriterion("sell_card_rewards not in", values, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsBetween(Integer value1, Integer value2) {
            addCriterion("sell_card_rewards between", value1, value2, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andSellCardRewardsNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_card_rewards not between", value1, value2, "sellCardRewards");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeIsNull() {
            addCriterion("on_net_income is null");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeIsNotNull() {
            addCriterion("on_net_income is not null");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeEqualTo(Integer value) {
            addCriterion("on_net_income =", value, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeNotEqualTo(Integer value) {
            addCriterion("on_net_income <>", value, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeGreaterThan(Integer value) {
            addCriterion("on_net_income >", value, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("on_net_income >=", value, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeLessThan(Integer value) {
            addCriterion("on_net_income <", value, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("on_net_income <=", value, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeIn(List<Integer> values) {
            addCriterion("on_net_income in", values, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeNotIn(List<Integer> values) {
            addCriterion("on_net_income not in", values, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeBetween(Integer value1, Integer value2) {
            addCriterion("on_net_income between", value1, value2, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andOnNetIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("on_net_income not between", value1, value2, "onNetIncome");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIsNull() {
            addCriterion("play_status is null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIsNotNull() {
            addCriterion("play_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusEqualTo(Integer value) {
            addCriterion("play_status =", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotEqualTo(Integer value) {
            addCriterion("play_status <>", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusGreaterThan(Integer value) {
            addCriterion("play_status >", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_status >=", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLessThan(Integer value) {
            addCriterion("play_status <", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("play_status <=", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIn(List<Integer> values) {
            addCriterion("play_status in", values, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotIn(List<Integer> values) {
            addCriterion("play_status not in", values, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusBetween(Integer value1, Integer value2) {
            addCriterion("play_status between", value1, value2, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("play_status not between", value1, value2, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayTimeIsNull() {
            addCriterion("play_time is null");
            return (Criteria) this;
        }

        public Criteria andPlayTimeIsNotNull() {
            addCriterion("play_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTimeEqualTo(Date value) {
            addCriterion("play_time =", value, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeNotEqualTo(Date value) {
            addCriterion("play_time <>", value, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeGreaterThan(Date value) {
            addCriterion("play_time >", value, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("play_time >=", value, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeLessThan(Date value) {
            addCriterion("play_time <", value, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeLessThanOrEqualTo(Date value) {
            addCriterion("play_time <=", value, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeIn(List<Date> values) {
            addCriterion("play_time in", values, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeNotIn(List<Date> values) {
            addCriterion("play_time not in", values, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeBetween(Date value1, Date value2) {
            addCriterion("play_time between", value1, value2, "playTime");
            return (Criteria) this;
        }

        public Criteria andPlayTimeNotBetween(Date value1, Date value2) {
            addCriterion("play_time not between", value1, value2, "playTime");
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