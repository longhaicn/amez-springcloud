package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.member.StoreByRegisterVo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.store.service.StoreService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/10 14:47
 */
@Api(tags = "门店", description = "api")
@RestController
@RequestMapping(value = "store")
public class StoreController {
    @Resource
    private StoreService storeService;

    /**
     * 通过ID查询门店
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询门店")
    @GetMapping("/queryById/{id}")
    public Store queryById(@PathVariable(value = "id") int id) {
        return this.storeService.queryObjById(id);
    }

    /**
     * 分页查询门店
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param store    查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<Store>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                               @ApiParam(value = "查询条件") @RequestBody Store store) {
        return this.storeService.findByPageForFront(pageNo, pageSize, store);
    }

    /**
     * 收藏门店
     *
     * @param storeFollower 门店粉丝
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "收藏门店")
    @PostMapping("/collection")
    public ResponseMessage storeCollection(@ApiParam(value = "门店粉丝") @RequestBody StoreFollower storeFollower) {
        return this.storeService.collection(storeFollower);
    }

    /**
     * 批量根据cityId查询门店
     *
     * @param cityId
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据城市ID门店集合")
    @PostMapping("/findListByCityId")
    ResponseMessage<List<Integer>> findListByCityId(@RequestParam(name = "cityId") Integer cityId) {
        return this.storeService.findListByCityId(cityId);
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
        return this.storeService.findListByBaiduMapLocation(query, region);
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
        return this.storeService.findByPageForName(pageNo, pageSize, productStoreByNameVo);
    }

    /**
     * 根据ID查询门店详情
     *
     * @param storeByDetailVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据ID查询门店详情")
    @PostMapping(value = "/detail")
    public ResponseMessage<StoreByDetailResultVo> detail(@ApiParam(value = "查询条件") @RequestBody StoreByDetailVo storeByDetailVo) {
        return this.storeService.detail(storeByDetailVo);
    }

    /**
     * 修改门店
     *
     * @param modifyVo 修改条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改门店")
    @PutMapping(value = "/modify")
    public ResponseMessage modify(@ApiParam("修改条件") @RequestBody StoreByModifyVo modifyVo) {
        return this.storeService.modify(modifyVo);
    }

    /**
     * 根据商品ID查询门店（提交订单）
     *
     * @param storeByProductIdForOrderVo 查询条件
     * @param request                    请求
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品ID查询门店（提交订单）")
    @PostMapping("/findListByProductIdForOrder")
    public ResponseMessage<List<Store>> findListByProductIdForOrder(@ApiParam(value = "筛选条件") @RequestBody StoreByProductIdForOrderVo storeByProductIdForOrderVo,
                                                                    HttpServletRequest request) {
        return this.storeService.findListByProductIdForOrder(storeByProductIdForOrderVo, request);
    }

    /**
     * 批量根据ID查询门店
     *
     * @param idBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询门店")
    @PostMapping("/findListByIdBatch")
    public ResponseMessage<List<Store>> findListByIdBatch(@ApiParam(value = "查询条件") @RequestBody IdBatchVo idBatchVo) {
        return this.storeService.findListByIdBatch(idBatchVo);
    }

    /**
     * 根据门店id和经纬度得获取门店距离
     *
     * @param storeByIdVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据门店id和经纬度来获取门店距离")
    @PostMapping("/queryDistanceById")
    public Store queryDistanceById(@RequestBody StoreByIdVo storeByIdVo) {
        return this.storeService.queryDistanceById(storeByIdVo);
    }

    /**
     * 累积预收入金额
     *
     * @param storeByPreIncomeAmountVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积预收入金额")
    @PostMapping("/accumulateByPreIncomeAmount")
    public ResponseMessage accumulateByPreIncomeAmount(@ApiParam(value = "预收入金额") @RequestBody StoreByPreIncomeAmountVo storeByPreIncomeAmountVo) {
        return this.storeService.accumulateByPreIncomeAmount(storeByPreIncomeAmountVo);
    }

    /**
     * 累积账户余额
     *
     * @param storeByAccountBalanceVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "累积账户余额")
    @PostMapping("/accumulateByAccountBalance")
    public ResponseMessage accumulateByAccountBalance(@ApiParam(value = "账户余额") @RequestBody StoreByAccountBalanceVo storeByAccountBalanceVo) {
        return this.storeService.accumulateByAccountBalance(storeByAccountBalanceVo);
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
        return this.storeService.accumulateByStoreSales(storeByStoreSalesVo);
    }

    /**
     * 分页查询门店（精选）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param selectVo 条件
     * @param request  请求
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店（精选）")
    @PostMapping("/findByPageForSelect")
    public ResponseMessage<PageInfo<Store>> findByPageForSelect(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                @ApiParam(value = "门店") @RequestBody StoreBySelectVo selectVo,
                                                                HttpServletRequest request) {
        return this.storeService.findByPageForSelect(pageNo, pageSize, selectVo, request);
    }

    /**
     * 根据ID查询门店
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询门店")
    @GetMapping("/findById/{id}")
    public ResponseMessage<Store> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeService.findById(id);
    }

    /**
     * 根据入驻码查询门店
     *
     * @param settledCode 入驻码
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据入驻码查询门店")
    @GetMapping("/1.1.1/findBySettledCode/{settledCode}")
    public ResponseMessage<Store> findBySettledCode(@ApiParam(value = "入驻码") @PathVariable(value = "settledCode") String settledCode) {
        return this.storeService.findBySettledCodeV111(settledCode);
    }

    /**
     * 分页查询可挂靠申请的店铺（美容师-首页-我的-门店挂靠申请-挂靠申请）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param affiliatedVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询可挂靠申请的店铺（美容师-首页-我的-门店挂靠申请-挂靠申请）")
    @PostMapping("/1.1.1/listAffiliatedByCanApply")
    public ResponseMessage<PageInfo<StoreAffiliatedByCanApplyResVo>> listAffiliatedByCanApplyV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @ApiParam(value = "条件") @RequestBody StoreAffiliatedByCanApplyVo affiliatedVo) {
        return this.storeService.listAffiliatedByCanApplyV111(pageNo, pageSize, affiliatedVo);
    }

    /**
     * 注册门店
     *
     * @param registerVo 注册条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "注册门店")
    @PostMapping(value = "/1.1.1/register")
    public ResponseMessage registerV111(@ApiParam("注册条件") @RequestBody StoreByRegisterVo registerVo) {
        return this.storeService.registerV111(registerVo);
    }

    /**
     * 根据门店ID查询企业收款账号
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询企业收款账号")
    @GetMapping("/1.1.1/findEnterpriseReceivingAccountByStoreId/{storeId}")
    public ResponseMessage<StoreByEnterpriseReceivingAccountResVo> findEnterpriseReceivingAccountByStoreIdV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeService.findEnterpriseReceivingAccountByStoreIdV111(storeId);
    }

    /**
     * 根据门店ID查询个人收款账号
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询个人收款账号")
    @GetMapping("/1.1.1/findPersonageReceivingAccountByStoreId/{storeId}")
    public ResponseMessage<StoreByPersonageReceivingAccountResVo> findPersonageReceivingAccountByStoreIdV111(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeService.findPersonageReceivingAccountByStoreIdV111(storeId);
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
        return this.storeService.listOrderV111(pageNo, pageSize, orderVo);
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
        return this.storeService.getIndexConditionV111(cityId);
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
        return this.storeService.listIndexV111(pageNo, pageSize, indexVo);
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
        return this.storeService.accumulateGrowthValueV111(storeId, growthValue);
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
        return this.storeService.settledV111(settledVo);
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
        return this.storeService.getBySellerPhoneV111(sellerPhone);
    }

}