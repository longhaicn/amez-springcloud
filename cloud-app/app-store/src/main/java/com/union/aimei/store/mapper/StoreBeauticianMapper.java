package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 美容师
 *
 * @author liurenkai
 * @time 2018/1/12 13:48
 */
public interface StoreBeauticianMapper extends BaseMapper<StoreBeautician> {

    /**
     * 根据手机号查询美容师
     *
     * @param phone 手机号
     * @return
     */
    StoreBeautician selectByPhone(String phone);

    /**
     * 根据店铺ID清空客服
     *
     * @param storeId 店铺ID
     * @return
     */
    int updateByStoreIdForEmptyService(int storeId);

    /**
     * 根据店铺ID和美容师ID查询
     *
     * @param map
     * @return
     */
    StoreBeautician selectByBeauticianIdAndAnStoreId(Map<String, Object> map);

    /**
     * 累积预收入金额
     *
     * @param preIncomeAmountVo
     * @return
     */
    int accumulateByPreIncomeAmount(StoreBeaByPreIncomeAmountVo preIncomeAmountVo);

    /**
     * 累积账户余额
     *
     * @param accountBalanceVo
     * @return
     */
    int accumulateByAccountBalance(StoreBeaByAccountBalanceVo accountBalanceVo);

    /**
     * 根据ID批量查询美容师
     *
     * @param idBatchVo
     * @return
     */
    List<StoreBeautician> selectListByIdBatch(StoreBeauticianByIdBatchVo idBatchVo);

    /**
     * 根据IM用户名批量查询美容师
     *
     * @param imUsernameBatchVo
     * @return
     */
    List<StoreBeautician> selectListByImUsernameBatch(StoreBeauticianByImUsernameBatchVo imUsernameBatchVo);

    /**
     * 通过手机号码查询会员ID
     *
     * @param phone
     * @return
     */
    Integer queryMemberIdByPhone(String phone);

    /**
     * 查询美容师（允许招募）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByAllowedRecruit(Map<String, Object> condMap);

    /**
     * 查询美容师（美容师）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByBeautician(Map<String, Object> condMap);

    /**
     * 查询美容师（明星）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByStar(Map<String, Object> condMap);

    /**
     * 查询可挂靠邀请的美容师
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByCanInvitationForAffiliated(Map<String, Object> condMap);

    /**
     * 查询招募项目可邀请的美容师（包含课程）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByCanInvitationForRecruitForCourse(Map<String, Object> condMap);

    /**
     * 查询招募项目可邀请的美容师
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByCanInvitationForRecruit(Map<String, Object> condMap);

    /**
     * 查询招募项目的美容师
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianByInvitationForRecruitResVo> selectListByInvitationForRecruit(Map<String, Object> condMap);

    /**
     * 查询招募项目的美容师
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByRecruit(Map<String, Object> condMap);

    /**
     * 查询附近的美容师
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianByNearbyResVo> listNearby(Map<String, Object> condMap);

    /**
     * 查询美容师距离
     *
     * @param condMap 条件
     * @return
     */
    Integer getDistance(Map<String, Object> condMap);

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师
     *
     * @param condMap 条件
     * @return
     */
    BeauticianNearestByProductIdResVo getNearestByProductId(Map<String, Object> condMap);

    /**
     * 根据门店ID查询店长
     *
     * @param condMap 条件
     * @return
     */
    StoreBeautician getManagerByStoreId(Map<String, Object> condMap);

    /**
     * 查询美容师成长值排行榜
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianByListGrowthValueRankingResVo> listGrowthValueRanking(Map<String, Object> condMap);

    /**
     * 查询服务接单中的美容师列表
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianListOrderByHomeProductResVo> listOrderByProduct(Map<String, Object> condMap);

    /**
     * 根据门店ID查询美容师管理列表
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianListManageResVo> listManageByStoreId(Map<String, Object> condMap);

    /**
     * 标签列表
     *
     * @return
     */
    List<String> listLabel();

    /**
     * 上架到店项目选择美容师列表
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianListSelectOnSaleProductResVo> listSelectOnSaleStoreProduct(Map<String, Object> condMap);

    /**
     * 上架上门项目选择美容师列表
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianListSelectOnSaleProductResVo> listSelectOnSaleHomeProduct(Map<String, Object> condMap);

    /**
     * 更新粉丝数量
     *
     * @param condMap 条件
     * @return
     */
    int updateFollowerNumber(Map<String, Object> condMap);

    /**
     * 根据条件统计美容师表数据
     *
     * @param storeBeautician
     * @return
     */
    int selectCountByConditions(StoreBeautician storeBeautician);

    /**
     * 更新解除入驻美容师数据
     *
     * @param condMap
     * @return
     */
    int removeAffiliated(Map<String, Object> condMap);

    /**
     * 根据门店ID查询全职美容师
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> listFullTimeByStoreId(Map<String, Object> condMap);

    /**
     * 根据门店ID集合查询店长
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> listManagerByStoreIdList(Map<String, Object> condMap);

}