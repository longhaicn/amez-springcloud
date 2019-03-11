package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/15 17:17
 */
public interface StoreMapper extends BaseMapper<Store> {

    /**
     * 累积粉丝数
     *
     * @param condMap
     * @return
     */
    int accumulateByFollower(Map<String, Object> condMap);

    /**
     * 批量根据cityId查询门店
     *
     * @param cityId
     * @return
     */
    List<Integer> findListByCityId(@Param("cityId") Integer cityId);

    /**
     * 根据名称查询门店
     *
     * @param condMap 条件
     * @return
     */
    List<StoreByNameResultVo> selectListByName(Map<String, Object> condMap);

    /**
     * 美店列表
     *
     * @param condMap 条件
     * @return
     */
    List<Store> listIndex(Map<String, Object> condMap);

    /**
     * 根据商品ID查询门店（提交订单）
     *
     * @param condMap 条件
     * @return
     */
    List<Store> selectListByProductIdForOrder(Map<String, Object> condMap);

    /**
     * 批量根据ID查询门店
     *
     * @param idBatchVo
     * @return
     */
    List<Store> selectListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 查询最近的门店
     *
     * @param storeByIdVo
     * @return
     */
    Store queryDistanceById(StoreByIdVo storeByIdVo);

    /**
     * 累积预收入金额
     *
     * @param storeByPreIncomeAmountVo
     * @return
     */
    int accumulateByPreIncomeAmount(StoreByPreIncomeAmountVo storeByPreIncomeAmountVo);

    /**
     * 累积账户余额
     *
     * @param storeByAccountBalanceVo
     * @return
     */
    int accumulateByAccountBalance(StoreByAccountBalanceVo storeByAccountBalanceVo);

    /**
     * 累积销量
     *
     * @param storeByStoreSalesVo
     * @return
     */
    int accumulateByStoreSales(StoreByStoreSalesVo storeByStoreSalesVo);

    /**
     * 查询门店（精选）
     *
     * @param condMap 条件
     * @return
     */
    List<Store> selectListBySelect(Map<String, Object> condMap);

    /**
     * 根据入住码查询门店
     *
     * @param settledCode 入驻码
     * @return
     */
    Store selectBySettledCode(@Param(value = "settledCode") String settledCode);

    /**
     * 查询可挂靠申请的门店
     *
     * @param condMap 条件
     * @return
     */
    List<StoreAffiliatedByCanApplyResVo> listAffiliatedByCanApply(Map<String, Object> condMap);

    /**
     * 订单门店列表
     *
     * @param condMap 条件
     * @return
     */
    List<Store> listOrder(Map<String, Object> condMap);

    /**
     * 根据店长手机号查询门店
     *
     * @param sellerPhone 店长手机号
     * @return
     */
    Store getBySellerPhone(@Param(value = "sellerPhone") String sellerPhone);

}