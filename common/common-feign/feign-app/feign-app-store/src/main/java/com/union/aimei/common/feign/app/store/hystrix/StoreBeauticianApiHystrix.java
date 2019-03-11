package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.common.MapPointVo;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 门店美容师
 *
 * @author liurenkai
 * @time 2018/1/12 14:25
 */
@Component(value = "app-StoreBeauticianFeign")
public class StoreBeauticianApiHystrix implements StoreBeauticianFeign {

    @Override
    public PageInfo<StoreBeautician> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeautician storeBeautician) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForAppointment(Integer pageNo, Integer pageSize, StoreBeauticianByAppointmentVo storeBeauticianByAppointmentVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianByPhoneResultVo> findByPhoneForStore(String phone) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findByPhone(String phone) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> setServiceByStoreId(StoreBeauticianByStoreIdForSetServiceVo storeBeauticianByStoreIdForSetServiceVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> chooseServiceByStoreId(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> queryByMemberId(StoreBeautician storeBeautician) {
        return null;
    }

    @Override
    public ResponseMessage judgeBeauticianBelongStore(Integer beauticianId, Integer anStoreId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateByPreIncomeAmount(StoreBeaByPreIncomeAmountVo preIncomeAmountVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateByAccountBalance(StoreBeaByAccountBalanceVo accountBalanceVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByStoreIdForOrder(Integer pageNo, Integer pageSize, int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreBeautician>> findListByIdBatch(StoreBeauticianByIdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreBeautician>> findListByImUsernameBatch(StoreBeauticianByImUsernameBatchVo imUsernameBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> queryMemberIdByPhone(String phone) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(Integer pageNo, Integer pageSize, int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(Integer pageNo, Integer pageSize, int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForStar(Integer pageNo, Integer pageSize, BeauticianByStarVo starVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> add(StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyRealName(StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForAffiliatedV111(Integer pageNo, Integer pageSize, BeauticianByCanInvitationForAffiliatedVo affiliatedCanInvitationVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByCanInvitationForRecruitVo recruitVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianByInvitationForRecruitResVo>> findByPageByInvitationForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByInvitationForRecruitVo recruitVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByRecruitVo recruitVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianByNearbyResVo>> listNearbyV111(int limit, MapPointVo pointVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> getDistanceV111(int beauticianId, MapPointVo pointVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findManagerByBeauticianIdV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> listGrowthValueRankingV111(int beauticianId, int limit) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> listActivityByStoreIdV111(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianByBusinessHourResVo> getBusinessHourByIdV111(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianNearestByProductIdResVo>> listNearestByProductIdV111(BeauticianListNearestByProductIdVo productIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianNearestByProductIdResVo> getNearestByProductIdV111(BeauticianNearestByProductIdVo productIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianNearestByProductIdResVo> getStoreNearestByProductIdV111(BeauticianNearestByProductIdVo productIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianListManageResVo>> listManageByStoreIdV111(Integer pageNo, Integer pageSize, BeauticianListManageVo manageVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianRecruitConditionResVo> getRecruitConditionV111(int cityId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProductV111(Integer pageNo, Integer pageSize, BeauticianListSelectOnSaleProductVo productVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianDetailResVo> getDetailV111(BeauticianDetailVo detailVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage accumulateGrowthValueV111(int beauticianId, int growthValue) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianServiceTimeOrderResVo> getServiceTimeOrderV111(int beauticianId, String orderDate) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> register(BeauticianByRegisterVo registerVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> info(StoreBeautician beautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage isOrder(int id, boolean isOrder) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage isHome(int id, boolean isHome) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage isStore(int id, boolean isStore) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> listFullTimeByStoreIdV111(Integer pageNo, Integer pageSize, int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> getManagerByStoreIdV111(int storeId) {
        return HystrixResponse.invokeFail();
    }

}