package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.pc.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreService extends SpringCloudBaseService<Store> {
    /**
     * 前端分页查询门店
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param store    查询条件
     * @return
     */
    PageInfo<Store> findByPageForFront(Integer pageNo, Integer pageSize, Store store);

    /**
     * 查询门店（品牌ID）
     *
     * @param storeByBrandIdVo
     * @return
     */
    ResponseMessage<List<Store>> findListByBrandId(StoreByBrandIdVo storeByBrandIdVo);

    /**
     * 新增门店
     *
     * @param storeVo 门店vo
     * @return
     */
    ResponseMessage<StoreVo> add(StoreVo storeVo);

    /**
     * 修改门店
     *
     * @param storeVo 门店vo
     * @return
     */
    ResponseMessage modify(StoreVo storeVo);

    /**
     * 门店详情
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<StoreVo> detail(int storeId);

    /**
     * 修改门店软删除标记
     *
     * @param storeId   门店ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    ResponseMessage modifyIsEnabled(int storeId, int isEnabled);

    /**
     * 百度地图查询地点
     *
     * @param query  关键词
     * @param region 城市
     * @return
     */
    ResponseMessage<JSONArray> findListByBaiduMapLocation(String query, String region);

    /**
     * 分页查询门店（会员卡）
     *
     * @param pageNo              分页索引
     * @param pageSize            每页数量
     * @param storeByMemberCardVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreByMemberCardResultVo>> findByPageForMemberCard(Integer pageNo, Integer pageSize, StoreByMemberCardVo storeByMemberCardVo);

    /**
     * 根据门店id和经纬度来查询门店距离
     *
     * @param storeByIdVo
     * @return
     */
    Store queryDistanceById(StoreByIdVo storeByIdVo);

    /**
     * 位置搜索
     *
     * @param placeSearchVo
     * @return
     */
    ResponseMessage<JSONArray> findListByPlaceSearch(PlaceSearchVo placeSearchVo);

    /**
     * 根据ID查询门店
     *
     * @param id ID
     * @return
     */
    ResponseMessage<Store> findById(int id);

    /**
     * 根据ID查询门店（开启）
     *
     * @param id ID
     * @return
     */
    ResponseMessage<Store> findByIdForOpen(int id);

    /**
     * 根据ID查询门店（批量）
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<Store>> findListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 新增门店统计
     *
     * @param dataCountVo 条件
     * @return
     */
    ResponseMessage<Integer> addByCount(StoreByDataCountVo dataCountVo);

    /**
     * 精选门店
     *
     * @param id       门店ID
     * @param isSelect 是否精选标记，1-是，0-否
     * @return
     */
    ResponseMessage select(int id, boolean isSelect);

    /**
     * 批量精选门店
     *
     * @param selectBatchVo
     * @return
     */
    ResponseMessage selectByBatch(StoreBySelectBatchVo selectBatchVo);

    /**
     * 查询门店列表，可按开店时间区间查询
     *
     * @param pageNo      分页索引
     * @param pageSize    每页数量
     * @param storeByDate 查询条件
     * @return
     */
    PageInfo<Store> findByPageForFrontByDate(Integer pageNo, Integer pageSize, StoreByDateVo storeByDate);

    /**
     * 根据老板用户ID查询门店
     *
     * @param bossUserId 老板用户ID
     * @return
     */
    ResponseMessage<List<Store>> findListByBossUserId(int bossUserId);

    /**
     * 门店资质审核
     *
     * @param qualificationAuditVo 条件
     * @return
     */
    ResponseMessage qualificationAudit(StoreByQualificationAuditVo qualificationAuditVo);

    /**
     * 门店资质列表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param qualificationVo 条件
     * @return
     */
    ResponseMessage<PageInfo<StoreListQualificationResVo>> listQualification(Integer pageNo, Integer pageSize, StoreListQualificationVo qualificationVo);

    /**
     * 累积成长值
     *
     * @param storeId     门店ID
     * @param growthValue 成长值
     * @return
     */
    ResponseMessage accumulateGrowthValueV111(int storeId, int growthValue);

    /**
     * 门店关闭
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage close(int storeId);

    /**
     * 门店开启
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage open(int storeId);

    /**
     * 门店冻结
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage freeze(int storeId);

    /**
     * 门店数据统计
     *
     * @param dataCountVo 条件
     * @return
     */
    ResponseMessage<StoreByDataCountResVo> dataCount(StoreByDataCountVo dataCountVo);

}