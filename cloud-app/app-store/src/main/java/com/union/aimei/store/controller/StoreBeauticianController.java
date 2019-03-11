package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.common.MapPointVo;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.store.service.StoreBeauticianService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师
 *
 * @author liurenkai
 * @time 2018/1/12 13:52
 */
@Api(tags = "美容师")
@RestController
@RequestMapping(value = "storeBeautician")
public class StoreBeauticianController {
    @Resource
    private StoreBeauticianService storeBeauticianService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreBeautician> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @ApiParam(value = "查询条件") @RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.findByPageForFront(pageNo, pageSize, storeBeautician);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.addObj(storeBeautician);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.modifyObj(storeBeautician);
    }

    @GetMapping("/queryById/{id}")
    public StoreBeautician queryById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianService.queryObjById(id);
    }

    /**
     * 根据手机号查询美容师
     *
     * @param phone 手机号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据手机号查询美容师")
    @GetMapping("/findByPhoneForStore/{phone}")
    public ResponseMessage<StoreBeauticianByPhoneResultVo> findByPhoneForStore(@ApiParam(value = "手机号") @PathVariable(value = "phone") String phone) {
        return this.storeBeauticianService.findByPhoneForStore(phone);
    }

    /**
     * 根据手机号查询美容师
     *
     * @param phone 手机号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据手机号查询美容师")
    @GetMapping("/findByPhone/{phone}")
    public ResponseMessage<StoreBeautician> findByPhone(@ApiParam(value = "手机号") @PathVariable(value = "phone") String phone) {
        return this.storeBeauticianService.findByPhone(phone);
    }

    /**
     * 通过手机号码查询会员ID
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryMemberId/{phone}")
    public ResponseMessage<Integer> queryMemberIdByPhone(@PathVariable(value = "phone") String phone) {
        return storeBeauticianService.queryMemberIdByPhone(phone);
    }

    /**
     * 根据店铺ID设置客服
     *
     * @param storeBeauticianByStoreIdForSetServiceVo 美容师（设置店铺客服）
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据店铺ID设置客服")
    @PostMapping("/setServiceByStoreId")
    public ResponseMessage<StoreBeautician> setServiceByStoreId(@ApiParam(value = "美容师（设置店铺客服）") @RequestBody StoreBeauticianByStoreIdForSetServiceVo storeBeauticianByStoreIdForSetServiceVo) {
        return this.storeBeauticianService.setServiceByStoreId(storeBeauticianByStoreIdForSetServiceVo);
    }

    /**
     * 根据店铺ID选择客服
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺ID选择客服")
    @GetMapping("/chooseServiceByStoreId/{storeId}")
    public ResponseMessage<StoreBeautician> chooseServiceByStoreId(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianService.chooseServiceByStoreId(storeId);
    }

    @ApiOperation(httpMethod = "POST", value = "根据会员id来查询会员所属店铺信息")
    @PostMapping("/queryByMemberId")
    public ResponseMessage<StoreBeautician> queryByMemberId(@RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.queryByMemberId(storeBeautician);
    }

    /**
     * 判断美容师是否属于挂靠门店
     *
     * @param beauticianId
     * @param anStoreId
     * @return
     */
    @GetMapping(value = "judgeBeauticianBelongStore")
    public ResponseMessage judgeBeauticianBelongStore(
            @RequestParam(value = "beauticianId") Integer beauticianId,
            @RequestParam(value = "anStoreId") Integer anStoreId) {
        return storeBeauticianService.judgeBeauticianBelongStore(beauticianId, anStoreId);
    }

    /**
     * 累积预收入金额
     *
     * @param preIncomeAmountVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积预收入金额")
    @PostMapping("/accumulateByPreIncomeAmount")
    public ResponseMessage accumulateByPreIncomeAmount(@ApiParam(value = "预收入金额") @RequestBody StoreBeaByPreIncomeAmountVo preIncomeAmountVo) {
        return this.storeBeauticianService.accumulateByPreIncomeAmount(preIncomeAmountVo);
    }

    /**
     * 累积账户余额
     *
     * @param accountBalanceVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积账户余额")
    @PostMapping("/accumulateByAccountBalance")
    public ResponseMessage accumulateByAccountBalance(@ApiParam(value = "账户余额") @RequestBody StoreBeaByAccountBalanceVo accountBalanceVo) {
        return this.storeBeauticianService.accumulateByAccountBalance(accountBalanceVo);
    }

    /**
     * 根据ID查询美容师
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询美容师")
    @GetMapping("/findById/{id}")
    public ResponseMessage<StoreBeautician> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeBeauticianService.findById(id);
    }

    /**
     * 根据ID批量查询美容师
     *
     * @param idBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据ID批量查询美容师")
    @PostMapping("/findListByIdBatch")
    public ResponseMessage<List<StoreBeautician>> findListByIdBatch(@ApiParam(value = "批量ID") @RequestBody StoreBeauticianByIdBatchVo idBatchVo) {
        return this.storeBeauticianService.findListByIdBatch(idBatchVo);
    }

    /**
     * 根据IM用户名批量查询美容师
     *
     * @param imUsernameBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据IM用户名批量查询美容师")
    @PostMapping("/findListByImUsernameBatch")
    public ResponseMessage<List<StoreBeautician>> findListByImUsernameBatch(@ApiParam(value = "批量IM用户名") @RequestBody StoreBeauticianByImUsernameBatchVo imUsernameBatchVo) {
        return this.storeBeauticianService.findListByImUsernameBatch(imUsernameBatchVo);
    }

    /**
     * 分页查询美容师（招募）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师（招募）")
    @PostMapping("/findByPageForRecruit")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @ApiParam(value = "店铺ID") @RequestParam(value = "storeId") int storeId) {
        return this.storeBeauticianService.findByPageForRecruit(pageNo, pageSize, storeId);
    }

    /**
     * 分页查询美容师（正式与兼职）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师（正式与兼职）")
    @PostMapping("/findByPageForFullTimeAndPartTime")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @ApiParam(value = "店铺ID") @RequestParam(value = "storeId") int storeId) {
        return this.storeBeauticianService.findByPageForFullTimeAndPartTime(pageNo, pageSize, storeId);
    }

    /**
     * 分页查询美容师（明星）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param starVo   条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师（明星）")
    @PostMapping("/findByPageForStar")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForStar(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                        @ApiParam(value = "条件") @RequestBody BeauticianByStarVo starVo) {
        return this.storeBeauticianService.findByPageForStar(pageNo, pageSize, starVo);
    }

    /**
     * 新增美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师")
    @PostMapping("/add")
    public ResponseMessage<StoreBeautician> add(@ApiParam(value = "美容师") @RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.add(storeBeautician);
    }

    /**
     * 修改美容师
     *
     * @param beautician 美容师
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改美容师")
    @PutMapping("/modify")
    public ResponseMessage modify(@ApiParam(value = "美容师") @RequestBody StoreBeautician beautician) {
        beautician.setRegisterStatus(StoreBeautician.RegisterStatus.PENGDING);
        return this.storeBeauticianService.modify(beautician);
    }

    /**
     * 修改美容师实名
     *
     * @param beautician 美容师
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改美容师实名")
    @PutMapping("/modify/realName")
    public ResponseMessage modifyRealName(@ApiParam(value = "美容师") @RequestBody StoreBeautician beautician) {
        return this.storeBeauticianService.modify(beautician);
    }

    /**
     * 分页查询可挂靠邀请的美容师
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param canInvitationForAffiliatedVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询可挂靠邀请的美容师")
    @PostMapping("/1.1.1/findByPageByCanInvitationForAffiliated")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForAffiliatedV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                 @ApiParam(value = "条件") @RequestBody BeauticianByCanInvitationForAffiliatedVo canInvitationForAffiliatedVo) {
        return this.storeBeauticianService.findByPageByCanInvitationForAffiliatedV111(pageNo, pageSize, canInvitationForAffiliatedVo);
    }

    /**
     * 分页查询招募项目可邀请的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询招募项目可邀请的美容师")
    @PostMapping("/1.1.1/findByPageByCanInvitationForRecruit")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForRecruitV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                              @ApiParam(value = "条件") @RequestBody BeauticianByCanInvitationForRecruitVo recruitVo) {
        return this.storeBeauticianService.findByPageByCanInvitationForRecruitV111(pageNo, pageSize, recruitVo);
    }

    /**
     * 分页查询招募项目邀请的美容师（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募）
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询招募项目邀请的美容师（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募）")
    @PostMapping("/1.1.1/findByPageByInvitationForRecruit")
    public ResponseMessage<PageInfo<BeauticianByInvitationForRecruitResVo>> findByPageByInvitationForRecruitV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                                 @ApiParam(value = "条件") @RequestBody BeauticianByInvitationForRecruitVo recruitVo) {
        return this.storeBeauticianService.findByPageByInvitationForRecruitV111(pageNo, pageSize, recruitVo);
    }

    /**
     * 分页查询招募项目的美容师
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询招募项目的美容师")
    @PostMapping("/1.1.1/findByPageForRecruit")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruitV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                               @ApiParam(value = "条件") @RequestBody BeauticianByRecruitVo recruitVo) {
        return this.storeBeauticianService.findByPageForRecruitV111(pageNo, pageSize, recruitVo);
    }

    /**
     * 查询附近的美容师
     *
     * @param limit   限制数
     * @param pointVo 地图坐标条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询附近的美容师")
    @PostMapping("/1.1.1/listNearby/{limit}")
    public ResponseMessage<List<BeauticianByNearbyResVo>> listNearbyV111(@ApiParam(value = "限制数", required = true) @PathVariable(value = "limit") int limit,
                                                                         @ApiParam(value = "地图坐标条件", required = true) @RequestBody MapPointVo pointVo) {
        return this.storeBeauticianService.listNearbyV111(limit, pointVo);
    }

    /**
     * 查询美容师的距离
     *
     * @param beauticianId 美容师ID
     * @param pointVo      地图坐标条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询美容师的距离")
    @PostMapping("/1.1.1/getDistance/{beauticianId}")
    public ResponseMessage<Integer> getDistanceV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId,
                                                    @ApiParam(value = "地图坐标条件") @RequestBody MapPointVo pointVo) {
        return this.storeBeauticianService.getDistanceV111(beauticianId, pointVo);
    }

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师
     *
     * @param productIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据项目ID查询最近时间，服务星级最高的美容师")
    @PostMapping("/1.1.1/getNearestByProductId")
    public ResponseMessage<BeauticianNearestByProductIdResVo> getNearestByProductIdV111(@ApiParam(value = "条件") @RequestBody BeauticianNearestByProductIdVo productIdVo) {
        return this.storeBeauticianService.getNearestByProductIdV111(productIdVo);
    }

    /**
     * 根据项目ID查询最近时间，服务星级最高的到店美容师
     *
     * @param productIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据项目ID查询最近时间，服务星级最高的到店美容师")
    @PostMapping("/1.1.1/getStoreNearestByProductId")
    public ResponseMessage<StoreBeauticianNearestByProductIdResVo> getStoreNearestByProductIdV111(@ApiParam(value = "条件") @RequestBody BeauticianNearestByProductIdVo productIdVo) {
        return this.storeBeauticianService.getStoreNearestByProductIdV111(productIdVo);
    }

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师列表
     *
     * @param productIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据项目ID查询最近时间，服务星级最高的美容师列表")
    @PostMapping("/1.1.1/listNearestByProductId")
    public ResponseMessage<List<BeauticianNearestByProductIdResVo>> listNearestByProductIdV111(@ApiParam(value = "条件") @RequestBody BeauticianListNearestByProductIdVo productIdVo) {
        return this.storeBeauticianService.listNearestByProductIdV111(productIdVo);
    }

    /**
     * 根据美容师ID查询店长
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID查询店长")
    @GetMapping("/1.1.1/findManagerByBeauticianId/{beauticianId}")
    public ResponseMessage<StoreBeautician> findManagerByBeauticianIdV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianService.findManagerByBeauticianIdV111(beauticianId);
    }

    /**
     * 美容师成长值排行榜
     *
     * @param beauticianId 美容师ID
     * @param limit        限制数
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师成长值排行榜")
    @GetMapping("/1.1.1/listGrowthValueRanking/{beauticianId}/{limit}")
    public ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> listGrowthValueRankingV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId,
                                                                                                     @ApiParam(value = "限制数") @PathVariable(value = "limit") int limit) {
        return this.storeBeauticianService.listGrowthValueRankingV111(beauticianId, limit);
    }

    /**
     * 根据门店ID查询活动美容师
     *
     * @param beauticianId 美容师ID
     * @param limit        限制数
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询活动美容师")
    @GetMapping("/1.1.1/listActivityByStoreId/{storeId}")
    public ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> listActivityByStoreIdV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianService.listActivityByStoreIdV111(storeId);
    }

    /**
     * 根据ID查询美容师营业时间
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询美容师营业时间")
    @GetMapping(value = "/1.1.1/getBusinessHourById/{id}")
    public ResponseMessage<BeauticianByBusinessHourResVo> getBusinessHourByIdV111(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeBeauticianService.getBusinessHourByIdV111(id);
    }

    /**
     * 员工管理列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "员工管理列表")
    @PostMapping("/1.1.1/listManageByStoreId")
    public ResponseMessage<PageInfo<BeauticianListManageResVo>> listManageByStoreIdV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                        @ApiParam(value = "条件") @RequestBody BeauticianListManageVo storeIdVo) {
        return this.storeBeauticianService.listManageByStoreIdV111(pageNo, pageSize, storeIdVo);
    }

    /**
     * 美容师招募筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师招募筛选条件")
    @GetMapping("/1.1.1/getRecruitCondition/{cityId}")
    public ResponseMessage<BeauticianRecruitConditionResVo> getRecruitConditionV111(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId) {
        return this.storeBeauticianService.getRecruitConditionV111(cityId);
    }

    /**
     * 上架项目选择美容师列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param storeIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "上架项目选择美容师列表")
    @PostMapping("/1.1.1/listSelectOnSaleProduct")
    public ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProductV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                         @ApiParam(value = "条件") @RequestBody BeauticianListSelectOnSaleProductVo productVo) {
        return this.storeBeauticianService.listSelectOnSaleProductV111(pageNo, pageSize, productVo);
    }

    /**
     * 美容师详情
     *
     * @param detailVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师详情")
    @PostMapping("/1.1.1/getDetail")
    public ResponseMessage<BeauticianDetailResVo> getDetailV111(@ApiParam(value = "条件") @RequestBody BeauticianDetailVo detailVo) {
        return this.storeBeauticianService.getDetailV111(detailVo);
    }

    /**
     * 累积成长值
     *
     * @param beauticianId 美容师ID
     * @param growthValue  成长值
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "累积成长值")
    @PutMapping("/1.1.1/accumulateGrowthValue/{beauticianId}/{growthValue}")
    public ResponseMessage accumulateGrowthValueV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId,
                                                     @ApiParam(value = "成长值") @PathVariable(value = "growthValue") int growthValue) {
        return this.storeBeauticianService.accumulateGrowthValueV111(beauticianId, growthValue);
    }

    /**
     * 下单美容师服务时间
     *
     * @param beauticianId 美容师ID
     * @param orderDate    下单日期
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "下单美容师服务时间")
    @GetMapping("/1.1.1/getOrderServiceTime/{beauticianId}/{orderDate}")
    public ResponseMessage<BeauticianServiceTimeOrderResVo> getServiceTimeOrderV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId,
                                                                                    @ApiParam(value = "下单日期") @PathVariable(value = "orderDate") String orderDate) {
        return this.storeBeauticianService.getServiceTimeOrderV111(beauticianId, orderDate);
    }

    /**
     * 美容师注册
     *
     * @param registerVo 注册条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师注册")
    @PostMapping("/register")
    public ResponseMessage<StoreBeautician> register(@ApiParam(value = "美容师") @RequestBody BeauticianByRegisterVo registerVo) {
        return this.storeBeauticianService.register(registerVo);
    }

    /**
     * 美容师资料
     *
     * @param beautician 美容师
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师资料")
    @PutMapping("/info")
    public ResponseMessage<StoreBeautician> info(@ApiParam(value = "美容师") @RequestBody StoreBeautician beautician) {
        return this.storeBeauticianService.info(beautician);
    }

    /**
     * 美容师是否接单
     *
     * @param id      ID
     * @param isOrder 是否接单
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师是否接单")
    @PutMapping("/isOrder/{id}/{isOrder}")
    public ResponseMessage isOrder(@ApiParam(value = "美容师") @PathVariable(value = "id") int id,
                                   @ApiParam(value = "是否接单") @PathVariable(value = "isOrder") boolean isOrder) {
        return this.storeBeauticianService.isOrder(id, isOrder);
    }

    /**
     * 美容师是否上门
     *
     * @param id     ID
     * @param isHome 是否上门
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师是否上门")
    @PutMapping("/isHome/{id}/{isHome}")
    public ResponseMessage isHome(@ApiParam(value = "美容师") @PathVariable(value = "id") int id,
                                  @ApiParam(value = "是否上门") @PathVariable(value = "isHome") boolean isHome) {
        return this.storeBeauticianService.isHome(id, isHome);
    }

    /**
     * 美容师是否到店
     *
     * @param id      ID
     * @param isStore 是否到店
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师是否到店")
    @PutMapping("/isStore/{id}/{isStore}")
    public ResponseMessage isStore(@ApiParam(value = "美容师") @PathVariable(value = "id") int id,
                                   @ApiParam(value = "是否到店") @PathVariable(value = "isStore") boolean isStore) {
        return this.storeBeauticianService.isStore(id, isStore);
    }

    /**
     * 根据门店ID查询全职美容师
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeId  门店ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店ID查询全职美容师")
    @PostMapping("/1.1.1/listFullTimeByStoreId/{storeId}")
    public ResponseMessage<PageInfo<StoreBeautician>> listFullTimeByStoreIdV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianService.listFullTimeByStoreIdV111(pageNo, pageSize, storeId);
    }

    /**
     * 根据门店ID查询店长
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询店长")
    @GetMapping("/1.1.1/getManagerByStoreId/{storeId}")
    public ResponseMessage getManagerByStoreIdV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianService.getManagerByStoreIdV111(storeId);
    }

}