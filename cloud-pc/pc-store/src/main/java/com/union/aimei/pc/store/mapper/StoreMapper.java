package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.store.pc.*;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 店铺
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreMapper extends BaseMapper<Store> {

    /**
     * 查询店铺（会员卡）
     *
     * @param storeByMemberCardVo
     * @return
     */
    List<StoreByMemberCardResultVo> selectListByMemberCard(StoreByMemberCardVo storeByMemberCardVo);

    /**
     * 查询店铺（品牌ID）
     *
     * @param storeByBrandIdVo
     * @return
     */
    List<Store> selectListByBrandId(StoreByBrandIdVo storeByBrandIdVo);

    /**
     * 根据门店ID查询距离
     *
     * @param storeByIdVo 条件
     * @return
     */
    Store queryDistanceById(StoreByIdVo storeByIdVo);

    /**
     * 根据ID查询店铺（批量）
     *
     * @param condMap
     * @return
     */
    List<Store> selectListByIdBatch(Map<String, Object> condMap);

    /**
     * 新增店铺统计
     *
     * @param condMap 条件
     * @return
     */
    int addByCount(Map<String, Object> condMap);

    /**
     * 根据城市ID取消精选店铺
     *
     * @param cityId 城市ID
     * @return
     */
    int cancelSelectByCityId(@Param(value = "cityId") int cityId);

    /**
     * 批量更新精选店铺
     *
     * @param storeList 店铺集合
     * @return
     */
    void updateBatchBySelect(@Param(value = "storeList") List<StoreBySelectVo> storeList);

    /**
     * 查询店铺列表，可按开店时间区间查询
     *
     * @param storeByDate
     * @return
     */
    List<Store> findByPageForFrontByDate(StoreByDateVo storeByDate);

    /**
     * 门店资质列表
     *
     * @param qualificationVo 条件
     * @return
     */
    List<StoreListQualificationResVo> listQualification(StoreListQualificationVo qualificationVo);

    /**
     * 根据店长手机号查询门店
     *
     * @param sellerPhone 店长手机号
     * @return
     */
    Store getBySellerPhone(@Param(value = "sellerPhone") String sellerPhone);

}