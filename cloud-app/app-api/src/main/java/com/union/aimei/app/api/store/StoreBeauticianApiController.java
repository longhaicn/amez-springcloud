package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.common.MapPointVo;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.store.app.*;
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
 * @time 2018/1/12 14:23
 */
@Api(tags = "美容师", description = "api")
@RestController
@RequestMapping(value = "storeBeautician")
public class StoreBeauticianApiController {
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    /**
     * 新增美容师
     *
     * @param storeBeautician
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师")
    @PostMapping("/add")
    public ResponseMessage add(@RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianFeign.add(storeBeautician);
    }

    /**
     * 根据美容师ID查询美容师
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID查询美容师（用户-首页-附近的邦女郎-邦女郎详情）")
    @GetMapping("/findById/{beauticianId}")
    public ResponseMessage<StoreBeautician> findById(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.storeBeauticianFeign.findById(beauticianId);
    }


    /**
     * 分页查询美容师（预约时间）
     *
     * @param pageNo                         分页索引
     * @param pageSize                       每页显示数量
     * @param storeBeauticianByAppointmentVo 查询条件
     * @return ResponseMessage<StoreBeautician>
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师（预约时间）")
    @PostMapping("/findByPageForAppointment")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForAppointment(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                               @ApiParam(value = "查询条件") @RequestBody StoreBeauticianByAppointmentVo storeBeauticianByAppointmentVo) {
        return this.storeBeauticianFeign.findByPageForAppointment(pageNo, pageSize, storeBeauticianByAppointmentVo);
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
        return this.storeBeauticianFeign.findByPhoneForStore(phone);
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
        return this.storeBeauticianFeign.findByPhone(phone);
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
        return this.storeBeauticianFeign.setServiceByStoreId(storeBeauticianByStoreIdForSetServiceVo);
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
        return this.storeBeauticianFeign.chooseServiceByStoreId(storeId);
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
        return this.storeBeauticianFeign.accumulateByPreIncomeAmount(preIncomeAmountVo);
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
        return this.storeBeauticianFeign.accumulateByAccountBalance(accountBalanceVo);
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
        return this.storeBeauticianFeign.findListByImUsernameBatch(imUsernameBatchVo);
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
        return this.storeBeauticianFeign.findByPageForRecruit(pageNo, pageSize, storeId);
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
        return this.storeBeauticianFeign.findByPageForFullTimeAndPartTime(pageNo, pageSize, storeId);
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
        return this.storeBeauticianFeign.findByPageForStar(pageNo, pageSize, starVo);
    }

    /**
     * 修改美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改美容师")
    @PutMapping("/modify")
    public ResponseMessage modify(@ApiParam(value = "美容师") @RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianFeign.modify(storeBeautician);
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
        return this.storeBeauticianFeign.register(registerVo);
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
        return this.storeBeauticianFeign.info(beautician);
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
    public ResponseMessage isOrder(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                   @ApiParam(value = "是否接单") @PathVariable(value = "isOrder") boolean isOrder) {
        return this.storeBeauticianFeign.isOrder(id, isOrder);
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
    public ResponseMessage isHome(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                  @ApiParam(value = "是否上门") @PathVariable(value = "isHome") boolean isHome) {
        return this.storeBeauticianFeign.isHome(id, isHome);
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
    public ResponseMessage isStore(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                   @ApiParam(value = "是否到店") @PathVariable(value = "isStore") boolean isStore) {
        return this.storeBeauticianFeign.isStore(id, isStore);
    }

    /**
     * 分页查询可挂靠邀请的美容师（门店-首页-招募挂靠-挂靠管理-挂靠管理（挂靠邀请））
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param affiliatedVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询可挂靠邀请的美容师（门店-首页-招募挂靠-挂靠管理-挂靠管理（挂靠邀请））")
    @PostMapping("/1.1.1/findByPageByCanInvitationForAffiliatedV111")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForAffiliatedV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                 @ApiParam(value = "条件") @RequestBody BeauticianByCanInvitationForAffiliatedVo affiliatedVo) {
        return this.storeBeauticianFeign.findByPageByCanInvitationForAffiliatedV111(pageNo, pageSize, affiliatedVo);
    }

    /**
     * 分页查询招募项目可邀请的美容师（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募（人员选择））
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param recruitVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询招募项目可邀请的美容师（门店-首页-招募挂靠-项目招募-项目招募管理-项目招募（人员选择））")
    @PostMapping("/1.1.1/findByPageByCanInvitationForRecruit")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageByCanInvitationForRecruitV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                              @ApiParam(value = "条件") @RequestBody BeauticianByCanInvitationForRecruitVo recruitVo) {
        return this.storeBeauticianFeign.findByPageByCanInvitationForRecruitV111(pageNo, pageSize, recruitVo);
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
        return this.storeBeauticianFeign.findByPageByInvitationForRecruitV111(pageNo, pageSize, recruitVo);
    }

    /**
     * 查询附近的美容师（用户-首页-附近的邦女郎）
     *
     * @param limit   限制数
     * @param pointVo 地图坐标条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询附近的美容师（用户-首页-附近的邦女郎）", notes = "{\n" +
            "\t\"cityId\": 440300,\n" +
            "\t\"point\": {\n" +
            "\t\t\"x\": \"113.9493255615234\",\n" +
            "\t\t\"y\": \"22.55147552490234\"\n" +
            "\t}\n" +
            "}")
    @PostMapping("/1.1.1/listNearby/{limit}")
    public ResponseMessage<List<BeauticianByNearbyResVo>> listNearbyV111(@ApiParam(value = "限制数", required = true) @PathVariable(value = "limit") int limit,
                                                                         @ApiParam(value = "地图坐标条件", required = true) @RequestBody MapPointVo pointVo) {
        return this.storeBeauticianFeign.listNearbyV111(limit, pointVo);
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
    public ResponseMessage<List<BeauticianByListGrowthValueRankingResVo>> listGrowthValueRankingV111(@ApiParam(value = "美容师ID", required = true) @PathVariable(value = "beauticianId") int beauticianId,
                                                                                                     @ApiParam(value = "限制数", required = true) @PathVariable(value = "limit") int limit) {
        return this.storeBeauticianFeign.listGrowthValueRankingV111(beauticianId, limit);
    }

    /**
     * 根据门店ID查询活动美容师
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询活动美容师")
    @GetMapping("/1.1.1/listActivityByStoreId/{storeId}")
    public ResponseMessage<List<BeauticianByStoreIdForActivityResVo>> listActivityByStoreIdV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianFeign.listActivityByStoreIdV111(storeId);
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
        return this.storeBeauticianFeign.getBusinessHourByIdV111(id);
    }

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师列表
     *
     * @param productIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据项目ID查询最近时间，服务星级最高的美容师列表（用户-首页-上门项目列表-项目详情-邦女郎（全部））", notes = "{\n" +
            "\t\"cityId\": 440300,\n" +
            "\t\"point\": {\n" +
            "\t\t\"x\": \"20\",\n" +
            "\t\t\"y\": \"100\"\n" +
            "\t},\n" +
            "\t\"productId\": 418,\n" +
            "\t\"serverNeedTime\": 30\n" +
            "}")
    @PostMapping("/1.1.1/listNearestByProductId")
    public ResponseMessage<List<BeauticianNearestByProductIdResVo>> listNearestByProductIdV111(@ApiParam(value = "条件") @RequestBody BeauticianListNearestByProductIdVo productIdVo) {
        return this.storeBeauticianFeign.listNearestByProductIdV111(productIdVo);
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
        return this.storeBeauticianFeign.getNearestByProductIdV111(productIdVo);
    }

    /**
     * 根据项目ID查询最近时间，服务星级最高的美容师
     *
     * @param productIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据项目ID查询最近时间，服务星级最高的到店美容师")
    @PostMapping("/1.1.1/getStoreNearestByProductId")
    public ResponseMessage<StoreBeauticianNearestByProductIdResVo> getStoreNearestByProductIdV111(@ApiParam(value = "条件") @RequestBody BeauticianNearestByProductIdVo productIdVo) {
        return this.storeBeauticianFeign.getStoreNearestByProductIdV111(productIdVo);
    }

    /**
     * 美容师管理列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师管理列表（门店-首页-员工管理）")
    @PostMapping("/1.1.1/listManageByStoreId")
    public ResponseMessage<PageInfo<BeauticianListManageResVo>> listManageByStoreIdV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                        @ApiParam(value = "条件") @RequestBody BeauticianListManageVo manageVo) {
        return this.storeBeauticianFeign.listManageByStoreIdV111(pageNo, pageSize, manageVo);
    }

    /**
     * 美容师招募筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师招募筛选条件（门店-首页-招募挂靠-挂靠管理-挂靠管理（挂靠邀请））")
    @GetMapping("/1.1.1/getRecruitCondition/{cityId}")
    public ResponseMessage<BeauticianRecruitConditionResVo> getRecruitConditionV111(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId) {
        return this.storeBeauticianFeign.getRecruitConditionV111(cityId);
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
        return this.storeBeauticianFeign.listSelectOnSaleProductV111(pageNo, pageSize, productVo);
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
        return this.storeBeauticianFeign.getDetailV111(detailVo);
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
        return this.storeBeauticianFeign.accumulateGrowthValueV111(beauticianId, growthValue);
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
        return this.storeBeauticianFeign.getServiceTimeOrderV111(beauticianId, orderDate);
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
        return this.storeBeauticianFeign.listFullTimeByStoreIdV111(pageNo, pageSize, storeId);
    }

}