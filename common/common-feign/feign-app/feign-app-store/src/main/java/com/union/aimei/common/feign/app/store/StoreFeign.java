package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreApiHystrix;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.member.StoreByRegisterVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/10 14:52
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreApiHystrix.class)
public interface StoreFeign {

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstore
     */
    @GetMapping(value = "/store/queryById/{id}")
    Store queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询门店
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param store    查询条件
     * @return
     */
    @PostMapping(value = "/store/front/findByPage")
    ResponseMessage<PageInfo<Store>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                Integer pageSize, Store store);

    /**
     * 收藏门店
     *
     * @param storeFollower 门店粉丝
     * @return
     */
    @PostMapping(value = "/store/collection")
    ResponseMessage collection(@ApiParam("门店粉丝") @RequestBody StoreFollower storeFollower);

    /**
     * 百度地图查询地点
     *
     * @param query  关键词
     * @param region 城市
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "百度地图查询地点")
    @GetMapping("/store/findListByBaiduMapLocation/{query}/{region}")
    ResponseMessage<JSONArray> findListByBaiduMapLocation(@ApiParam(value = "关键词") @PathVariable(value = "query") String query,
                                                          @ApiParam(value = "城市") @PathVariable(value = "region") String region);

    /**
     * 关闭门店
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "关闭门店")
    @PutMapping(value = "/store/close/{storeId}")
    ResponseMessage close(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 开启门店
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "开启门店")
    @PutMapping(value = "/store/open/{storeId}")
    ResponseMessage open(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 冻结门店
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "冻结门店")
    @PutMapping(value = "/store/freeze/{storeId}")
    ResponseMessage freeze(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId);


    /**
     * 分页查询门店（名称）
     *
     * @param pageNo               分页索引
     * @param pageSize             分页数量
     * @param productStoreByNameVo 查询条件
     * @return
     */
    @PostMapping("/store/findByPageForName")
    ResponseMessage<PageInfo<StoreByNameResultVo>> findByPageForName(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @RequestBody ProductStoreByNameVo productStoreByNameVo);

    /**
     * 门店详情
     *
     * @param storeByDetailVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店详情")
    @PostMapping(value = "/store/detail")
    ResponseMessage<StoreByDetailResultVo> detail(@ApiParam(value = "查询条件") @RequestBody StoreByDetailVo storeByDetailVo);

    /**
     * 修改门店
     *
     * @param modifyVo 修改条件
     * @return
     */
    @PutMapping(value = "/store/modify")
    ResponseMessage modify(@RequestBody StoreByModifyVo modifyVo);

    /**
     * 根据商品ID查询门店（提交订单）
     *
     * @param storeByProductIdForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品ID查询门店（提交订单）")
    @PostMapping("/store/findListByProductIdForOrder")
    ResponseMessage<List<Store>> findListByProductIdForOrder(@ApiParam(value = "查询条件") @RequestBody StoreByProductIdForOrderVo storeByProductIdForOrderVo);


    /**
     * 根据商品ID查询距离最近门店（提交订单）
     *
     * @param storeByProductIdForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品ID查询距离最近门店（提交订单）")
    @PostMapping("/store/findListByProductIdForRecentForOrder")
    ResponseMessage<StoreByProductIdForRecentForOrderResultVo> findListByProductIdForRecentForOrder(@ApiParam(value = "查询条件") @RequestBody StoreByProductIdForOrderVo storeByProductIdForOrderVo);

    /**
     * 批量根据ID查询门店
     *
     * @param idBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询门店")
    @PostMapping("/store/findListByIdBatch")
    ResponseMessage<List<Store>> findListByIdBatch(@RequestBody IdBatchVo idBatchVo);

    /**
     * 批量根据cityId查询门店
     *
     * @param cityId
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据城市ID门店集合")
    @PostMapping("/store/findListByCityId")
    ResponseMessage<List<Integer>> findListByCityId(@RequestParam(name = "cityId") Integer cityId);


    /**
     * 根据门店id和经纬度得获取门店距离
     *
     * @param storeByIdVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店id和经纬度得获取门店距离")
    @PostMapping(value = "/store/queryDistanceById")
    Store queryDistanceById(@RequestBody StoreByIdVo storeByIdVo);

    /**
     * 累积预收入金额
     *
     * @param storeByPreIncomeAmountVo
     * @return
     */
    @PostMapping("/store/accumulateByPreIncomeAmount")
    ResponseMessage accumulateByPreIncomeAmount(@RequestBody StoreByPreIncomeAmountVo storeByPreIncomeAmountVo);

    /**
     * 累积账户余额
     *
     * @param storeByAccountBalanceVo
     * @return
     */
    @PostMapping("/store/accumulateByAccountBalance")
    ResponseMessage accumulateByAccountBalance(@RequestBody StoreByAccountBalanceVo storeByAccountBalanceVo);

    /**
     * 累积销量
     *
     * @param storeByStoreSalesVo
     * @return
     */
    @PostMapping("/store/accumulateByStoreSales")
    ResponseMessage accumulateByStoreSales(@RequestBody StoreByStoreSalesVo storeByStoreSalesVo);

    /**
     * 分页查询门店（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @return
     */
    @PostMapping("/store/findByPageForSelect")
    ResponseMessage<PageInfo<Store>> findByPageForSelect(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestBody StoreBySelectVo selectVo);

    /**
     * 根据ID查询门店
     *
     * @param id ID
     * @returnstore
     */
    @GetMapping("/store/findById/{id}")
    ResponseMessage<Store> findById(@PathVariable(value = "id") int id);

    /**
     * 根据入驻码查询门店
     *
     * @param settledCode 入驻码
     * @returnstore
     */
    @GetMapping("/store/1.1.1/findBySettledCode/{settledCode}")
    ResponseMessage<Store> findBySettledCodeV111(@PathVariable(value = "settledCode") String settledCode);

    /**
     * 根据美容师ID查询门店挂靠邀请
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping("/store/1.1.1/findByPageForAffiliatedInvitation/{beauticianId}")
    ResponseMessage<PageInfo<Store>> findByPageForAffiliatedInvitationV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 分页查询可挂靠申请的门店
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param affiliatedVo 条件
     * @return
     */
    @PostMapping("/store/1.1.1/listAffiliatedByCanApply")
    ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> listAffiliatedByCanApplyV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                           @RequestBody StoreAffiliatedByCanApplyVo affiliatedVo);

    /**
     * 注册门店
     *
     * @param registerVo 注册条件
     * @return
     */
    @PostMapping("/store/1.1.1/register")
    ResponseMessage<StoreByRegisterResVo> registerV111(@RequestBody StoreByRegisterVo registerVo);

    /**
     * 根据门店ID查询企业收款账号
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/store/1.1.1/findEnterpriseReceivingAccountByStoreId/{storeId}")
    ResponseMessage<StoreByEnterpriseReceivingAccountResVo> findEnterpriseReceivingAccountByStoreIdV111(@PathVariable(value = "storeId") int storeId);

    /**
     * 根据门店ID查询个人收款账号
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/store/1.1.1/findPersonageReceivingAccountByStoreId/{storeId}")
    ResponseMessage<StoreByPersonageReceivingAccountResVo> findPersonageReceivingAccountByStoreIdV111(@PathVariable(value = "storeId") int storeId);

    /**
     * 订单门店列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param orderVo  条件
     * @return
     */
    @PostMapping("/store/1.1.1/listOrder")
    ResponseMessage<PageInfo<Store>> listOrderV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @RequestBody StoreListOrderVo orderVo);

    /**
     * 美店筛选条件
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping("/store/1.1.1/getIndexCondition/{cityId}")
    ResponseMessage<StoreIndexConditionResVo> getIndexConditionV111(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId);

    /**
     * 美店列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param indexVo  查询条件
     * @return
     */
    @PostMapping("/store/1.1.1/listIndex")
    ResponseMessage<PageInfo<Store>> listIndexV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @RequestBody StoreListIndexVo indexVo);

    /**
     * 累积成长值
     *
     * @param storeId     门店ID
     * @param growthValue 成长值
     * @return
     */
    @PutMapping("/store/1.1.1/accumulateGrowthValue/{storeId}/{growthValue}")
    ResponseMessage accumulateGrowthValueV111(@PathVariable(value = "storeId") int storeId,
                                              @PathVariable(value = "growthValue") int growthValue);

    /**
     * 门店入驻
     *
     * @param settledVo 入驻条件
     * @return
     */
    @PutMapping("/store/1.1.1/settled")
    ResponseMessage<Store> settledV111(@RequestBody StoreBySettledVo settledVo);

    /**
     * 根据店长手机号查询门店
     *
     * @param sellerPhone 店长手机号
     * @return
     */
    @GetMapping("/store/1.1.1/getBySellerPhone/{sellerPhone}")
    ResponseMessage<Store> getBySellerPhoneV111(@PathVariable(value = "sellerPhone") String sellerPhone);

}