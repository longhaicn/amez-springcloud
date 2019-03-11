package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.common.MapPointVo;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 美容师
 *
 * @author liurenkai
 * @time 2018/1/12 13:50
 */
public interface StoreBeauticianService extends SpringCloudBaseService<StoreBeautician> {
    /**
     * 前端分页查询美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeBeautician 查询条件
     * @return
     */
    PageInfo<StoreBeautician> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeautician storeBeautician);

    /**
     * 根据手机号查询美容师
     *
     * @param phone 手机号
     * @return
     */
    ResponseMessage<StoreBeauticianByPhoneResultVo> findByPhoneForStore(String phone);

    /**
     * 根据手机号查询美容师
     *
     * @param phone 手机号
     * @return
     */
    ResponseMessage<StoreBeautician> findByPhone(String phone);

    /**
     * 根据店铺ID设置客服
     *
     * @param storeBeauticianByStoreIdForSetServiceVo 美容师（设置店铺客服）
     * @return
     */
    ResponseMessage setServiceByStoreId(StoreBeauticianByStoreIdForSetServiceVo storeBeauticianByStoreIdForSetServiceVo);

    /**
     * 根据店铺ID选择客服
     *
     * @param storeId 店铺ID
     * @return
     */
    ResponseMessage<StoreBeautician> chooseServiceByStoreId(int storeId);

    /**
     * 根据会员ID查询美容师
     *
     * @param storeBeautician
     * @return
     */
    ResponseMessage<StoreBeautician> queryByMemberId(StoreBeautician storeBeautician);

    /**
     * 判断美容师是否属于挂靠门店ID
     *
     * @param beauticianId
     * @param anStoreId
     * @return
     */
    ResponseMessage judgeBeauticianBelongStore(Integer beauticianId, Integer anStoreId);

    /**
     * 累积预收入金额
     *
     * @param preIncomeAmountVo
     * @return
     */
    ResponseMessage accumulateByPreIncomeAmount(StoreBeaByPreIncomeAmountVo preIncomeAmountVo);

    /**
     * 累积账户金额
     *
     * @param accountBalanceVo
     * @return
     */
    ResponseMessage accumulateByAccountBalance(StoreBeaByAccountBalanceVo accountBalanceVo);

    /**
     * 根据ID查询美容师
     *
     * @param id
     * @return
     */
    ResponseMessage<StoreBeautician> findById(int id);

    /**
     * 根据ID批量查询美容师
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<StoreBeautician>> findListByIdBatch(StoreBeauticianByIdBatchVo idBatchVo);

    /**
     * 根据IM用户名批量查询美容师
     *
     * @param imUsernameBatchVo
     * @return
     */
    ResponseMessage<List<StoreBeautician>> findListByImUsernameBatch(StoreBeauticianByImUsernameBatchVo imUsernameBatchVo);

    /**
     * 通过手机号码查询会员ID
     *
     * @param phone
     * @return
     */
    ResponseMessage<Integer> queryMemberIdByPhone(String phone);

    /**
     * 分页查询美容师（招募）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(Integer pageNo, Integer pageSize, int storeId);

    /**
     * 分页查询美容师（正式与兼职）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(Integer pageNo, Integer pageSize, int storeId);

    /**
     * 分页查询美容师（明星）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param starVo   条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForStar(Integer pageNo, Integer pageSize, BeauticianByStarVo starVo);

    /**
     * 新增美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    ResponseMessage<StoreBeautician> add(StoreBeautician storeBeautician);

    /**
     * 修改美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    ResponseMessage modify(StoreBeautician storeBeautician);

    /**
     * 分页查询可挂靠邀请的美容师
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param canInvitationForAffiliatedVo 条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForAffiliatedV111(Integer pageNo, Integer pageSize, BeauticianByCanInvitationForAffiliatedVo canInvitationForAffiliatedVo);

    /**
     * 分页查询招募项目可邀请的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByCanInvitationForRecruitVo recruitVo);

    /**
     * 分页查询招募项目的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    ResponseMessage<PageInfo<BeauticianByInvitationForRecruitResVo>> findByPageByInvitationForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByInvitationForRecruitVo recruitVo);

    /**
     * 分页查询招募项目的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruitV111(Integer pageNo, Integer pageSize, BeauticianByRecruitVo recruitVo);

    /**
     * 查询附近的美容师
     *
     * @param limit   限制数
     * @param pointVo 地图坐标条件
     * @return
     */
    ResponseMessage<List<BeauticianByNearbyResVo>> listNearbyV111(int limit, MapPointVo pointVo);

    /**
     * 查询美容师距离
     *
     * @param beauticianId 美容师ID
     * @param pointVo      地图坐标条件
     * @return
     */
    ResponseMessage<Integer> getDistanceV111(int beauticianId, MapPointVo pointVo);

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师
     *
     * @param productIdVo 条件
     * @return
     */
    ResponseMessage<BeauticianNearestByProductIdResVo> getNearestByProductIdV111(BeauticianNearestByProductIdVo productIdVo);

    /**
     * 根据项目ID查询最近时间，服务星级最高的到店美容师
     *
     * @param productIdVo 条件
     * @return
     */
    ResponseMessage<StoreBeauticianNearestByProductIdResVo> getStoreNearestByProductIdV111(BeauticianNearestByProductIdVo productIdVo);

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师列表
     *
     * @param productIdVo 条件
     * @return
     */
    ResponseMessage<List<BeauticianNearestByProductIdResVo>> listNearestByProductIdV111(BeauticianListNearestByProductIdVo productIdVo);

    /**
     * 根据美容师ID查询店长
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<StoreBeautician> findManagerByBeauticianIdV111(int beauticianId);

    /**
     * 美容师成长值排行榜
     *
     * @param beauticianId 美容师ID
     * @param limit        限制数
     * @return
     */
    ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> listGrowthValueRankingV111(int beauticianId, int limit);

    /**
     * 根据门店ID查询活动美容师
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> listActivityByStoreIdV111(int storeId);

    /**
     * 根据ID查询美容师营业时间
     *
     * @param id ID
     * @return
     */
    ResponseMessage<BeauticianByBusinessHourResVo> getBusinessHourByIdV111(int id);

    /**
     * 分页查询管理美容师列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeIdVo 条件
     * @return
     */
    ResponseMessage<PageInfo<BeauticianListManageResVo>> listManageByStoreIdV111(Integer pageNo, Integer pageSize, BeauticianListManageVo storeIdVo);

    /**
     * 美容师招募筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<BeauticianRecruitConditionResVo> getRecruitConditionV111(int cityId);

    /**
     * 上架项目选择美容师列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param productVo 条件
     * @return
     */
    ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProductV111(Integer pageNo, Integer pageSize, BeauticianListSelectOnSaleProductVo productVo);

    /**
     * 美容师详情
     *
     * @param detailVo 条件
     * @return
     */
    ResponseMessage<BeauticianDetailResVo> getDetailV111(BeauticianDetailVo detailVo);

    /**
     * 累积成长值
     *
     * @param beauticianId 美容师ID
     * @param growthValue  成长值
     * @return
     */
    ResponseMessage accumulateGrowthValueV111(int beauticianId, int growthValue);

    /**
     * 下单美容师服务时间
     *
     * @param beauticianId 美容师ID
     * @param orderDate    下单日期
     * @return
     */
    ResponseMessage<BeauticianServiceTimeOrderResVo> getServiceTimeOrderV111(int beauticianId, String orderDate);

    /**
     * 美容师注册
     *
     * @param registerVo 注册条件
     * @return
     */
    ResponseMessage<StoreBeautician> register(BeauticianByRegisterVo registerVo);

    /**
     * 美容师资料
     *
     * @param beautician 美容师
     * @return
     */
    ResponseMessage<StoreBeautician> info(StoreBeautician beautician);

    /**
     * 美容师是否接单
     *
     * @param id      ID
     * @param isOrder 是否接单
     * @return
     */
    ResponseMessage isOrder(int id, boolean isOrder);

    /**
     * 美容师是否上门
     *
     * @param id     ID
     * @param isHome 是否上门
     * @return
     */
    ResponseMessage isHome(int id, boolean isHome);

    /**
     * 美容师是否到店
     *
     * @param id      ID
     * @param isStore 是否到店
     * @return
     */
    ResponseMessage isStore(int id, boolean isStore);

    /**
     * 根据门店ID查询全职美容师
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  门店ID
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> listFullTimeByStoreIdV111(Integer pageNo, Integer pageSize, int storeId);

    /**
     * 根据门店ID查询店长
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<StoreBeautician> getManagerByStoreIdV111(int storeId);

}