package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductVo;
import com.union.aimei.common.vo.store.pc.BeauticianByStarBatchVo;
import com.union.aimei.common.vo.store.pc.StoreBeaByFullTimeAndPartTimeVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByAuditVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByRecruitVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "pc-StoreBeauticianFeign")
public class StoreBeauticianApiHystrix implements StoreBeauticianFeign {

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @Override
    public int insert(StoreBeautician storeBeautician) {
        return 0;
    }

    /**
     * 删除店铺美容师
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @Override
    public int edit(StoreBeautician storeBeautician) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeautician
     */
    @Override
    public StoreBeautician queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByUserId(int userId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findByUserIdForNormal(int userId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findByPhone(String phone) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage workCardNoByStoreIdCount(Integer storeId, String workCardNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findByMemberId(Integer memberId) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(Integer pageNo, Integer pageSize, StoreBeauticianByRecruitVo storeBeauticianByRecruitVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeautician> findByStoreIdForManager(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(Integer pageNo, Integer pageSize, StoreBeaByFullTimeAndPartTimeVo fullTimeAndPartTimeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> pendingByCount(StoreByDataCountVo dataCountVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage star(int id, boolean isStar) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage starByBatch(BeauticianByStarBatchVo starBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage editLimitWorkCardNoByStoreId(StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage add(StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(StoreBeautician storeBeautician) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProduct(Integer pageNo, Integer pageSize, BeauticianListSelectOnSaleProductVo productVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreBeautician>> listFullTimeByStoreId(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage audit(StoreBeauticianByAuditVo auditVo) {
        return HystrixResponse.invokeFail();
    }

}