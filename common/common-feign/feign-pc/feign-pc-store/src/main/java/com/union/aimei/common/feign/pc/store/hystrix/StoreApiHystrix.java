package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.pc.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "pc-StoreFeign")
public class StoreApiHystrix implements StoreFeign {

    /**
     * 前端分页查询门店
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param store    查询条件
     * @return
     */
    @Override
    public PageInfo<Store> findByPageForFront(Integer pageNo, Integer pageSize, Store store) {
        return null;
    }

    /**
     * 添加门店
     *
     * @param store
     * @return
     */
    @Override
    public int insert(Store store) {
        return 0;
    }

    /**
     * 删除门店
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改门店
     *
     * @param store
     * @return
     */
    @Override
    public int edit(Store store) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstore
     */
    @Override
    public Store queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<List<Store>> findListByBrandId(StoreByBrandIdVo storeByBrandIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreVo> add(StoreVo storeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(StoreVo storeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreVo> detail(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyIsEnabled(int storeId, int isEnabled) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<JSONArray> findListByBaiduMapLocation(String query, String region) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreByMemberCardResultVo>> findByPageForMemberCard(Integer pageNo, Integer pageSize, StoreByMemberCardVo storeByMemberCardVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public Store queryDistanceById(StoreByIdVo storeByIdVo) {
        return null;
    }

    @Override
    public ResponseMessage<Store> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Store> findByIdForOpen(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<Store>> findListByIdBatch(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> addByCount(StoreByDataCountVo dataCountVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage select(int id, boolean isSelect) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage selectByBatch(StoreBySelectBatchVo selectBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public PageInfo<Store> findByPageForFrontByDate(Integer pageNo, Integer pageSize, StoreByDateVo storeByDateVo) {
        return null;
    }

    @Override
    public ResponseMessage<List<Store>> findListByBossUserId(int boosUserId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage qualificationAudit(StoreByQualificationAuditVo qualificationAuditVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreListQualificationResVo>> listQualification(Integer pageNo, Integer pageSize, StoreListQualificationVo qualificationVo) {
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
    public ResponseMessage<StoreByDataCountResVo> dataCount(StoreByDataCountVo dataCountVo) {
        return HystrixResponse.invokeFail();
    }

}