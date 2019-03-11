package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.member.StoreByRegisterVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺
 *
 * @author liurenkai
 * @time 2018/1/22 15:05
 */
@Component(value = "app-StoreFeign")
public class StoreApiHystrix implements StoreFeign {

    @Override
    public ResponseMessage<PageInfo<Store>> findByPageForFront(Integer pageNo, Integer pageSize, Store store) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public Store queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage collection(StoreFollower storeFollower) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<JSONArray> findListByBaiduMapLocation(String query, String region) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage close(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage open(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage freeze(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreByNameResultVo>> findByPageForName(Integer pageNo, Integer pageSize, ProductStoreByNameVo productStoreByNameVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreByDetailResultVo> detail(StoreByDetailVo storeByDetailVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(StoreByModifyVo modifyVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Store>> findListByProductIdForOrder(StoreByProductIdForOrderVo storeByProductIdForOrderVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreByProductIdForRecentForOrderResultVo> findListByProductIdForRecentForOrder(StoreByProductIdForOrderVo storeByProductIdForOrderVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Store>> findListByIdBatch(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Integer>> findListByCityId(Integer cityId) {
        return null;
    }


    @Override
    public Store queryDistanceById(StoreByIdVo storeByIdVo) {
        return null;
    }

    @Override
    public ResponseMessage accumulateByPreIncomeAmount(StoreByPreIncomeAmountVo storeByPreIncomeAmountVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateByAccountBalance(StoreByAccountBalanceVo storeByAccountBalanceVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateByStoreSales(StoreByStoreSalesVo storeByStoreSalesVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Store>> findByPageForSelect(Integer pageNo, Integer pageSize, StoreBySelectVo selectVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Store> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Store> findBySettledCodeV111(String settledCode) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Store>> findByPageForAffiliatedInvitationV111(Integer pageNo, Integer pageSize, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> listAffiliatedByCanApplyV111(Integer pageNo, Integer pageSize, StoreAffiliatedByCanApplyVo affiliatedVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreByRegisterResVo> registerV111(StoreByRegisterVo registerVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreByEnterpriseReceivingAccountResVo> findEnterpriseReceivingAccountByStoreIdV111(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreByPersonageReceivingAccountResVo> findPersonageReceivingAccountByStoreIdV111(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Store>> listOrderV111(Integer pageNo, Integer pageSize, StoreListOrderVo orderVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreIndexConditionResVo> getIndexConditionV111(int cityId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Store>> listIndexV111(Integer pageNo, Integer pageSize, StoreListIndexVo indexVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateGrowthValueV111(int storeId, int growthValue) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Store> settledV111(StoreBySettledVo settledVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Store> getBySellerPhoneV111(String sellerPhone) {
        return HystrixResponse.invokeFail();
    }

}