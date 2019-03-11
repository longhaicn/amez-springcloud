package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.member.StoreByRegisterVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/10 14:13
 */
public interface StoreService extends SpringCloudBaseService<Store> {
    /**
     * 分页查询门店
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param store    查询条件
     * @return
     */
    ResponseMessage<PageInfo<Store>> findByPageForFront(Integer pageNo, Integer pageSize, Store store);

    /**
     * 收藏门店
     *
     * @param storeFollower 门店粉丝
     * @return
     */
    ResponseMessage collection(StoreFollower storeFollower);

    /**
     * 批量根据cityId查询门店
     *
     * @param cityId
     * @return
     */
    ResponseMessage<List<Integer>> findListByCityId(Integer cityId);

    /**
     * 百度地图查询地点
     *
     * @param query  关键词
     * @param region 城市
     * @return
     */
    ResponseMessage<JSONArray> findListByBaiduMapLocation(String query, String region);

    /**
     * 分页查询门店（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreByNameResultVo>> findByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo);

    /**
     * 门店详情
     *
     * @param storeByDetailVo 查询条件
     * @return
     */
    ResponseMessage<StoreByDetailResultVo> detail(StoreByDetailVo storeByDetailVo);

    /**
     * 修改门店
     *
     * @param modifyVo 修改条件
     * @return
     */
    ResponseMessage modify(StoreByModifyVo modifyVo);

    /**
     * 根据商品ID查询门店（提交订单）
     *
     * @param storeByProductIdForOrderVo 查询条件
     * @param request                    请求
     * @return
     */
    ResponseMessage<List<Store>> findListByProductIdForOrder(StoreByProductIdForOrderVo storeByProductIdForOrderVo, HttpServletRequest request);

    /**
     * 批量根据ID查询门店
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<Store>> findListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 根据门店id和经纬度来查询门店距离
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
    ResponseMessage accumulateByPreIncomeAmount(StoreByPreIncomeAmountVo storeByPreIncomeAmountVo);

    /**
     * 累积预收入金额
     *
     * @param storeByAccountBalanceVo
     * @return
     */
    ResponseMessage accumulateByAccountBalance(StoreByAccountBalanceVo storeByAccountBalanceVo);

    /**
     * 累积销量
     *
     * @param storeByStoreSalesVo
     * @return
     */
    ResponseMessage accumulateByStoreSales(StoreByStoreSalesVo storeByStoreSalesVo);

    /**
     * 分页查询门店（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @param request
     * @return
     */
    ResponseMessage<PageInfo<Store>> findByPageForSelect(Integer pageNo, Integer pageSize, StoreBySelectVo selectVo, HttpServletRequest request);

    /**
     * 根据ID查询门店
     *
     * @param id ID
     * @return
     */
    ResponseMessage<Store> findById(int id);

    /**
     * 根据入驻码查询门店
     *
     * @param settledCode 入驻码
     * @return
     */
    ResponseMessage<Store> findBySettledCodeV111(String settledCode);

    /**
     * 分页查询可挂靠申请的店铺
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param affiliatedVo 条件
     * @return
     */
    ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> listAffiliatedByCanApplyV111(Integer pageNo, Integer pageSize, StoreAffiliatedByCanApplyVo affiliatedVo);

    /**
     * 注册门店
     *
     * @param registerVo 注册条件
     * @return
     */
    ResponseMessage<StoreByRegisterResVo> registerV111(StoreByRegisterVo registerVo);

    /**
     * 根据门店ID查询企业收款账号
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<StoreByEnterpriseReceivingAccountResVo> findEnterpriseReceivingAccountByStoreIdV111(int storeId);

    /**
     * 根据门店ID查询个人收款账号
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<StoreByPersonageReceivingAccountResVo> findPersonageReceivingAccountByStoreIdV111(int storeId);

    /**
     * 订单门店列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param orderVo  条件
     * @return
     */
    ResponseMessage<PageInfo<Store>> listOrderV111(Integer pageNo, Integer pageSize, StoreListOrderVo orderVo);

    /**
     * 美店筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<StoreIndexConditionResVo> getIndexConditionV111(int cityId);

    /**
     * 美店列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param indexVo  条件
     * @return
     */
    ResponseMessage<PageInfo<Store>> listIndexV111(Integer pageNo, Integer pageSize, StoreListIndexVo indexVo);

    /**
     * 累积成长值
     *
     * @param storeId     门店ID
     * @param growthValue 成长值
     * @return
     */
    ResponseMessage accumulateGrowthValueV111(int storeId, int growthValue);

    /**
     * 门店入驻
     *
     * @param settledVo 入驻条件
     * @return
     */
    ResponseMessage<Store> settledV111(StoreBySettledVo settledVo);

    /**
     * 根据店长手机号查询门店
     *
     * @param sellerPhone 店长手机号
     * @return
     */
    ResponseMessage<Store> getBySellerPhoneV111(String sellerPhone);

}