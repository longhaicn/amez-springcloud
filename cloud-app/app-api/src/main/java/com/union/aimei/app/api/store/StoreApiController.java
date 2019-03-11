package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/10 14:53
 */
@Api(tags = "门店", description = "api")
@RestController
@RequestMapping(value = "store")
public class StoreApiController {
    @Resource
    private StoreFeign storeFeign;

    /**
     * 收藏门店
     *
     * @param storeFollower 门店粉丝
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "收藏门店")
    @PostMapping("/collection")
    public ResponseMessage collection(@ApiParam(value = "门店粉丝") @RequestBody StoreFollower storeFollower) {
        return this.storeFeign.collection(storeFollower);
    }

    /**
     * 百度地图查询地点
     *
     * @param query  关键词
     * @param region 城市
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "百度地图查询地点")
    @GetMapping("/findListByBaiduMapLocation/{query}/{region}")
    public ResponseMessage<JSONArray> findListByBaiduMapLocation(@ApiParam(value = "关键词") @PathVariable(value = "query") String query,
                                                                 @ApiParam(value = "城市") @PathVariable(value = "region") String region) {
        return this.storeFeign.findListByBaiduMapLocation(query, region);
    }

    /**
     * 分页查询门店（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店（名称）")
    @PostMapping("/findByPageForName")
    public ResponseMessage<PageInfo<StoreByNameResultVo>> findByPageForName(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                            @ApiParam(value = "筛选条件") @RequestBody ProductStoreByNameVo productStoreByNameVo) {
        return this.storeFeign.findByPageForName(pageNo, pageSize, productStoreByNameVo);
    }

    /**
     * 门店详情
     *
     * @param storeByDetailVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店详情")
    @PostMapping(value = "/detail")
    public ResponseMessage<StoreByDetailResultVo> detail(@ApiParam(value = "查询条件") @RequestBody StoreByDetailVo storeByDetailVo) {
        return this.storeFeign.detail(storeByDetailVo);
    }

    /**
     * 修改门店
     *
     * @param modifyVo 修改条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改门店")
    @PutMapping(value = "/modify")
    public ResponseMessage modify(@ApiParam(value = "门店") @RequestBody StoreByModifyVo modifyVo) {
        return this.storeFeign.modify(modifyVo);
    }

    /**
     * 累积预收入金额
     *
     * @param preIncomeAmountVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积预收入金额")
    @PostMapping("/accumulateByPreIncomeAmount")
    public ResponseMessage accumulateByPreIncomeAmount(@ApiParam(value = "预收入金额") @RequestBody StoreByPreIncomeAmountVo preIncomeAmountVo) {
        return this.storeFeign.accumulateByPreIncomeAmount(preIncomeAmountVo);
    }

    /**
     * 累积账户余额
     *
     * @param accountBalanceVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积账户余额")
    @PostMapping("/accumulateByAccountBalance")
    public ResponseMessage accumulateByAccountBalance(@ApiParam(value = "账户余额") @RequestBody StoreByAccountBalanceVo accountBalanceVo) {
        return this.storeFeign.accumulateByAccountBalance(accountBalanceVo);
    }

    /**
     * 累积销量
     *
     * @param storeByStoreSalesVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积销量")
    @PostMapping("/accumulateByStoreSales")
    public ResponseMessage accumulateByStoreSales(@ApiParam(value = "销量") @RequestBody StoreByStoreSalesVo storeByStoreSalesVo) {
        return this.storeFeign.accumulateByStoreSales(storeByStoreSalesVo);
    }

    /**
     * 分页查询门店（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店（精选）")
    @PostMapping("/findByPageForSelect")
    public ResponseMessage<PageInfo<Store>> findByPageForSelect(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                @ApiParam(value = "条件") @RequestBody StoreBySelectVo selectVo) {
        return this.storeFeign.findByPageForSelect(pageNo, pageSize, selectVo);
    }

    /**
     * 门店入驻
     *
     * @param settledVo 入驻条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "门店入驻（美容师-我的-门店入驻）")
    @PutMapping("/1.1.1/settled")
    public ResponseMessage<Store> settledV111(@ApiParam(value = "入驻条件") @RequestBody StoreBySettledVo settledVo) {
        return this.storeFeign.settledV111(settledVo);
    }

    /**
     * 分页查询可挂靠申请的门店（美容师-首页-我的-门店挂靠申请-挂靠申请）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param affiliatedVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询可挂靠申请的门店（美容师-首页-我的-门店挂靠申请-挂靠申请）")
    @PostMapping("/1.1.1/listAffiliatedByCanApply")
    public ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> listAffiliatedByCanApplyV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @ApiParam(value = "条件") @RequestBody StoreAffiliatedByCanApplyVo affiliatedVo) {
        return this.storeFeign.listAffiliatedByCanApplyV111(pageNo, pageSize, affiliatedVo);
    }

    /**
     * 订单门店列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param orderVo  条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "订单门店列表")
    @PostMapping("/1.1.1/listOrder")
    public ResponseMessage<PageInfo<Store>> listOrderV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @ApiParam(value = "条件") @RequestBody StoreListOrderVo orderVo) {
        return this.storeFeign.listOrderV111(pageNo, pageSize, orderVo);
    }

    /**
     * 美店筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美店筛选条件")
    @GetMapping("/1.1.1/getIndexCondition/{cityId}")
    public ResponseMessage<StoreIndexConditionResVo> getIndexConditionV111(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId) {
        return this.storeFeign.getIndexConditionV111(cityId);
    }

    /**
     * 美店列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param indexVo  条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美店列表")
    @PostMapping("/1.1.1/listIndex")
    public ResponseMessage<PageInfo<Store>> listIndexV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @ApiParam(value = "条件") @RequestBody StoreListIndexVo indexVo) {
        return this.storeFeign.listIndexV111(pageNo, pageSize, indexVo);
    }

    /**
     * 完善门店资料
     *
     * @param modifyVo 修改条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "完善门店资料（门店-账号-完善门店资料）")
    @PutMapping(value = "/1.1.1/infoImprove")
    public ResponseMessage infoImproveV111(@ApiParam(value = "门店") @RequestBody StoreByModifyVo modifyVo) {
        modifyVo.getStore().setSettledStatus(Store.SettledStatus.PENDING);
        return this.storeFeign.modify(modifyVo);
    }

    /**
     * 资质提交
     *
     * @param modifyVo 修改条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "资质提交（门店-账号-资质认证）")
    @PutMapping(value = "/1.1.1/qualificationCommit")
    public ResponseMessage qualificationCommitV111(@ApiParam(value = "门店") @RequestBody StoreByModifyVo modifyVo) {
        modifyVo.getStore().setQualificationStatus(Store.QualificationStatus.PENDING);
        modifyVo.getStore().setQualificationCommitTime(new Date());
        return this.storeFeign.modify(modifyVo);
    }

    /**
     * 累积成长值
     *
     * @param storeId     门店ID
     * @param growthValue 成长值
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "累积成长值")
    @PutMapping("/1.1.1/accumulateGrowthValue/{storeId}/{growthValue}")
    public ResponseMessage accumulateGrowthValueV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                                     @ApiParam(value = "成长值") @PathVariable(value = "growthValue") int growthValue) {
        return this.storeFeign.accumulateGrowthValueV111(storeId, growthValue);
    }

    /**
     * 根据店长手机号查询门店
     *
     * @param sellerPhone 店长手机号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店长手机号查询门店")
    @GetMapping("/1.1.1/getBySellerPhone/{sellerPhone}")
    public ResponseMessage<Store> getBySellerPhoneV111(@ApiParam(value = "店长手机号") @PathVariable(value = "sellerPhone") String sellerPhone) {
        return this.storeFeign.getBySellerPhoneV111(sellerPhone);
    }

}