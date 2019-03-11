package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreBeauticianApiHystrix;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.common.MapPointVo;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门店美容师
 *
 * @author liurenkai
 * @time 2018/1/12 14:23
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreBeauticianApiHystrix.class)
public interface StoreBeauticianFeign {

    /**
     * 前端分页查询门店美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeBeautician 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeautician/front/findByPage")
    PageInfo<StoreBeautician> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                 @RequestBody StoreBeautician storeBeautician);

    /**
     * 分页查询门店美容师（预约时间）
     *
     * @param pageNo                         分页索引
     * @param pageSize                       每页数量
     * @param storeBeauticianByAppointmentVo 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeautician/findByPageForAppointment")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForAppointment(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                        @RequestBody StoreBeauticianByAppointmentVo storeBeauticianByAppointmentVo);

    /**
     * 根据手机号查询门店美容师
     *
     * @param phone 手机号
     * @return
     */
    @GetMapping(value = "/storeBeautician/findByPhoneForStore/{phone}")
    ResponseMessage<StoreBeauticianByPhoneResultVo> findByPhoneForStore(@PathVariable(value = "phone") String phone);

    /**
     * 根据手机号查询门店美容师
     *
     * @param phone 手机号
     * @return
     */
    @GetMapping(value = "/storeBeautician/findByPhone/{phone}")
    ResponseMessage<StoreBeautician> findByPhone(@PathVariable(value = "phone") String phone);

    /**
     * 根据店铺ID设置客服
     *
     * @param storeBeauticianByStoreIdForSetServiceVo 门店美容师（设置店铺客服）
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据店铺ID设置客服")
    @PostMapping("/storeBeautician/setServiceByStoreId")
    ResponseMessage<StoreBeautician> setServiceByStoreId(@RequestBody StoreBeauticianByStoreIdForSetServiceVo storeBeauticianByStoreIdForSetServiceVo);

    /**
     * 根据店铺ID选择客服
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺ID选择客服")
    @GetMapping("/storeBeautician/chooseServiceByStoreId/{storeId}")
    ResponseMessage<StoreBeautician> chooseServiceByStoreId(@ApiParam(value = "手机号") @PathVariable(value = "storeId") int storeId);

    /**
     * 根据会员id来查询会员门店信息
     *
     * @param storeBeautician
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员id来查询店铺美容师信息")
    @PostMapping("/storeBeautician/queryByMemberId")
    ResponseMessage<StoreBeautician>  queryByMemberId(@RequestBody StoreBeautician storeBeautician);


    /**
     * 判断美容师是否属于挂靠门店
     *
     * @param beauticianId
     * @param anStoreId
     * @return
     */
    @GetMapping(value = "/storeBeautician/judgeBeauticianBelongStore")
    ResponseMessage judgeBeauticianBelongStore(
            @RequestParam(value = "beauticianId") Integer beauticianId,
            @RequestParam(value = "anStoreId") Integer anStoreId);

    /**
     * StoreBeautician
     * 累积预收入金额
     *
     * @param preIncomeAmountVo
     * @return
     */
    @PostMapping("/storeBeautician/accumulateByPreIncomeAmount")
    ResponseMessage accumulateByPreIncomeAmount(@RequestBody StoreBeaByPreIncomeAmountVo preIncomeAmountVo);

    /**
     * 累积账户余额
     *
     * @param accountBalanceVo
     * @return
     */
    @PostMapping("/storeBeautician/accumulateByAccountBalance")
    ResponseMessage accumulateByAccountBalance(@RequestBody StoreBeaByAccountBalanceVo accountBalanceVo);

    /**
     * 根据ID查询门店美容师
     *
     * @param id
     * @return
     */
    @GetMapping("/storeBeautician/findById/{id}")
    ResponseMessage<StoreBeautician> findById(@PathVariable(value = "id") int id);

    /**
     * 根据店铺ID分页查询门店美容师（订单）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    @PostMapping(value = "/storeBeautician/findByPageByStoreIdForOrder/{storeId}")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageByStoreIdForOrder(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @PathVariable(value = "storeId") int storeId);

    /**
     * 根据ID批量查询门店美容师
     *
     * @param idBatchVo
     * @return
     */
    @PostMapping(value = "/storeBeautician/findListByIdBatch")
    ResponseMessage<List<StoreBeautician>> findListByIdBatch(@RequestBody StoreBeauticianByIdBatchVo idBatchVo);

    /**
     * 根据IM用户名批量查询门店美容师
     *
     * @param imUsernameBatchVo
     * @return
     */
    @PostMapping("/storeBeautician/findListByImUsernameBatch")
    ResponseMessage<List<StoreBeautician>> findListByImUsernameBatch(@ApiParam(value = "批量IM用户名") @RequestBody StoreBeauticianByImUsernameBatchVo imUsernameBatchVo);


    /**
     * 通过手机号码查询会员ID
     *
     * @param phone
     * @return
     */
    @GetMapping("/storeBeautician/queryMemberId/{phone}")
    ResponseMessage<Integer> queryMemberIdByPhone(@PathVariable(value = "phone") String phone);

    /**
     * 分页查询门店美容师（招募）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    @PostMapping("/storeBeautician/findByPageForRecruit")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(value = "storeId") int storeId);

    /**
     * 分页查询门店美容师（正式与兼职）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    @PostMapping("/storeBeautician/findByPageForFullTimeAndPartTime")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @RequestParam(value = "storeId") int storeId);

    /**
     * 分页查询美容师（明星）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param starVo   条件
     * @return
     */
    @PostMapping("/storeBeautician/findByPageForStar")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForStar(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @RequestBody BeauticianByStarVo starVo);

    /**
     * 新增美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @PostMapping(value = "/storeBeautician/add")
    ResponseMessage<StoreBeautician> add(@RequestBody StoreBeautician storeBeautician);

    /**
     * 修改美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @PutMapping(value = "/storeBeautician/modify")
    ResponseMessage modify(@RequestBody StoreBeautician storeBeautician);

    /**
     * 修改美容师实名
     *
     * @param storeBeautician 美容师
     * @return
     */
    @PutMapping(value = "/storeBeautician/modify/realName")
    ResponseMessage modifyRealName(@RequestBody StoreBeautician storeBeautician);

    /**
     * 根据门店ID分页查询可挂靠邀请的美容师
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param affiliatedVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/findByPageByCanInvitationForAffiliated")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForAffiliatedV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                          @RequestBody BeauticianByCanInvitationForAffiliatedVo affiliatedVo);

    /**
     * 分页查询招募项目可邀请的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/findByPageByCanInvitationForRecruit")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForRecruitV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @RequestBody BeauticianByCanInvitationForRecruitVo recruitVo);

    /**
     * 分页查询招募项目邀请的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/findByPageByInvitationForRecruit")
    ResponseMessage<PageInfo<BeauticianByInvitationForRecruitResVo>> findByPageByInvitationForRecruitV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                          @RequestBody BeauticianByInvitationForRecruitVo recruitVo);

    /**
     * 分页查询招募项目的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/findByPageForRecruit")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruitV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                        @RequestBody BeauticianByRecruitVo recruitVo);

    /**
     * 查询附近的美容师
     *
     * @param limit   限制数
     * @param pointVo 地图坐标条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/listNearby/{limit}")
    ResponseMessage<List<BeauticianByNearbyResVo>> listNearbyV111(@PathVariable(value = "limit") int limit,
                                                                  @RequestBody MapPointVo pointVo);

    /**
     * 查询美容师的距离
     *
     * @param beauticianId 美容师ID
     * @param pointVo      地图坐标条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/getDistance/{beauticianId}")
    ResponseMessage<Integer> getDistanceV111(@PathVariable(value = "beauticianId") int beauticianId,
                                             @RequestBody MapPointVo pointVo);

    /**
     * 根据美容师ID查询店长
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/storeBeautician/1.1.1/findManagerByBeauticianId/{beauticianId}")
    ResponseMessage<StoreBeautician> findManagerByBeauticianIdV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 美容师成长值排行榜
     *
     * @param beauticianId 美容师ID
     * @param limit        限制数
     * @return
     */
    @GetMapping("/storeBeautician/1.1.1/listGrowthValueRanking/{beauticianId}/{limit}")
    ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> listGrowthValueRankingV111(@PathVariable(value = "beauticianId") int beauticianId,
                                                                                              @PathVariable(value = "limit") int limit);

    /**
     * 根据门店ID查询活动美容师
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/storeBeautician/1.1.1/listActivityByStoreId/{storeId}")
    ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> listActivityByStoreIdV111(@PathVariable(value = "storeId") int storeId);

    /**
     * 根据ID查询美容师营业时间
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/storeBeautician/1.1.1/getBusinessHourById/{id}")
    ResponseMessage<BeauticianByBusinessHourResVo> getBusinessHourByIdV111(@PathVariable(value = "id") int id);

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师列表
     *
     * @param productIdVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/listNearestByProductId")
    ResponseMessage<List<BeauticianNearestByProductIdResVo>> listNearestByProductIdV111(@RequestBody BeauticianListNearestByProductIdVo productIdVo);

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师
     *
     * @param productIdVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/getNearestByProductId")
    ResponseMessage<BeauticianNearestByProductIdResVo> getNearestByProductIdV111(@RequestBody BeauticianNearestByProductIdVo productIdVo);

    /**
     * 根据项目ID查询最近时间，服务星级最高的到店美容师
     *
     * @param productIdVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/getStoreNearestByProductId")
    ResponseMessage<StoreBeauticianNearestByProductIdResVo> getStoreNearestByProductIdV111(@RequestBody BeauticianNearestByProductIdVo productIdVo);

    /**
     * 分页查询管理美容师列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/listManageByStoreId")
    ResponseMessage<PageInfo<BeauticianListManageResVo>> listManageByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                 @RequestBody BeauticianListManageVo manageVo);

    /**
     * 美容师招募筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping("/storeBeautician/1.1.1/getRecruitCondition/{cityId}")
    ResponseMessage<BeauticianRecruitConditionResVo> getRecruitConditionV111(@PathVariable(value = "cityId") int cityId);

    /**
     * 上架项目选择美容师列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param productVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/listSelectOnSaleProduct")
    ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProductV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @RequestBody BeauticianListSelectOnSaleProductVo productVo);

    /**
     * 美容师详情
     *
     * @param detailVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/getDetail")
    ResponseMessage<BeauticianDetailResVo> getDetailV111(@RequestBody BeauticianDetailVo detailVo);

    /**
     * 累积成长值
     *
     * @param beauticianId 美容师ID
     * @param growthValue  成长值
     * @return
     */
    @PutMapping("/storeBeautician/1.1.1/accumulateGrowthValue/{beauticianId}/{growthValue}")
    ResponseMessage accumulateGrowthValueV111(@PathVariable(value = "beauticianId") int beauticianId,
                                              @PathVariable(value = "growthValue") int growthValue);

    /**
     * 下单美容师服务时间
     *
     * @param beauticianId 美容师ID
     * @param orderDate    下单日期
     * @return
     */
    @GetMapping("/storeBeautician/1.1.1/getOrderServiceTime/{beauticianId}/{orderDate}")
    ResponseMessage<BeauticianServiceTimeOrderResVo> getServiceTimeOrderV111(@PathVariable(value = "beauticianId") int beauticianId,
                                                                             @PathVariable(value = "orderDate") String orderDate);

    /**
     * 美容师注册
     *
     * @param registerVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/register")
    ResponseMessage<StoreBeautician> register(@RequestBody BeauticianByRegisterVo registerVo);

    /**
     * 美容师资料
     *
     * @param beautician 美容师
     * @return
     */
    @PutMapping("/storeBeautician/info")
    ResponseMessage<StoreBeautician> info(@RequestBody StoreBeautician beautician);

    /**
     * 美容师是否接单
     *
     * @param id      ID
     * @param isOrder 是否接单
     * @return
     */
    @PutMapping("/storeBeautician/isOrder/{id}/{isOrder}")
    ResponseMessage isOrder(@PathVariable(value = "id") int id,
                            @PathVariable(value = "isOrder") boolean isOrder);

    /**
     * 美容师是否上门
     *
     * @param id     ID
     * @param isHome 是否上门
     * @return
     */
    @PutMapping("/storeBeautician/isHome/{id}/{isHome}")
    ResponseMessage isHome(@PathVariable(value = "id") int id,
                           @PathVariable(value = "isHome") boolean isHome);

    /**
     * 美容师是否到店
     *
     * @param id      ID
     * @param isStore 是否到店
     * @return
     */
    @PutMapping("/storeBeautician/isStore/{id}/{isStore}")
    ResponseMessage isStore(@PathVariable(value = "id") int id,
                            @PathVariable(value = "isStore") boolean isStore);

    /**
     * 根据门店ID查询全职美容师列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  门店ID
     * @return
     */
    @PostMapping("/storeBeautician/1.1.1/listFullTimeByStoreId/{storeId}")
    ResponseMessage<PageInfo<StoreBeautician>> listFullTimeByStoreIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @PathVariable(value = "storeId") int storeId);

    /**
     * 根据门店ID查询店长
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/storeBeautician/1.1.1/getManagerByStoreId/{storeId}")
    ResponseMessage<StoreBeautician> getManagerByStoreIdV111(@PathVariable(value = "storeId") int storeId);

}