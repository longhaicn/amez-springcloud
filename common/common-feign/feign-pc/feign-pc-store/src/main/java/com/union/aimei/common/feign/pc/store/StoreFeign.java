package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreApiHystrix;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.pc.*;
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
 * @time 2018/1/12 17:34
 */
@FeignClient(name = "PC-STORE-SERVICE", fallback = StoreApiHystrix.class)
public interface StoreFeign {
    /**
     * 添加门店
     *
     * @param store
     * @return
     */
    @PostMapping(value = "/store/insert")
    int insert(@RequestBody Store store);

    /**
     * 删除门店
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/store/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改门店
     *
     * @param store
     * @return
     */
    @PutMapping(value = "/store/edit")
    int edit(@RequestBody Store store);

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
    PageInfo<Store> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                       @RequestBody Store store);

    /**
     * 查询门店（品牌ID）
     *
     * @param storeByBrandIdVo
     * @return
     */
    @PostMapping(value = "/store/findListByBrandId")
    ResponseMessage<List<Store>> findListByBrandId(@RequestBody StoreByBrandIdVo storeByBrandIdVo);

    /**
     * 新增门店
     *
     * @param storeVo 门店vo
     * @return
     */
    @PostMapping(value = "/store/add")
    ResponseMessage<StoreVo> add(@RequestBody StoreVo storeVo);

    /**
     * 修改门店与扩展信息
     *
     * @param storeVo 门店vo
     * @return
     */
    @PutMapping(value = "/store/modify")
    ResponseMessage modify(@RequestBody StoreVo storeVo);

    /**
     * 获取门店
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "后台-获取门店与扩展信息")
    @GetMapping(value = "/store/detail/{storeId}")
    ResponseMessage<StoreVo> detail(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 修改门店软删除标记
     *
     * @param storeId   门店ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改门店软删除标记")
    @PutMapping(value = "/store/modify/isEnabled/{storeId}/{isEnabled}")
    ResponseMessage modifyIsEnabled(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                    @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled);

    /**
     * 百度地图查询地点
     *
     * @param query  关键词
     * @param region 城市
     * @return
     */
    @GetMapping("/store/findListByBaiduMapLocation/{query}/{region}")
    ResponseMessage<JSONArray> findListByBaiduMapLocation(@PathVariable(value = "query") String query,
                                                          @PathVariable(value = "region") String region);

    /**
     * 分页查询门店（会员卡）
     *
     * @param pageNo              分页索引
     * @param pageSize            每页数量
     * @param storeByMemberCardVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店（会员卡）")
    @PostMapping("/store/findByPageForMemberCard")
    ResponseMessage<PageInfo<StoreByMemberCardResultVo>> findByPageForMemberCard(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                 @ApiParam(value = "查询条件") @RequestBody StoreByMemberCardVo storeByMemberCardVo);

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
     * 根据ID查询门店
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/store/findById/{id}")
    ResponseMessage<Store> findById(@PathVariable(value = "id") int id);

    /**
     * 根据ID查询门店（开启）
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/store/findById/open/{id}")
    ResponseMessage<Store> findByIdForOpen(@PathVariable(value = "id") int id);

    /**
     * 根据ID查询门店（批量）
     *
     * @param idBatchVo
     * @return
     */
    @PostMapping("/store/findListByIdBatch")
    ResponseMessage<List<Store>> findListByIdBatch(@RequestBody IdBatchVo idBatchVo);

    /**
     * 新增门店统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @PostMapping("/store/add/count")
    ResponseMessage<Integer> addByCount(@RequestBody StoreByDataCountVo dataCountVo);

    /**
     * 精选门店
     *
     * @param id       门店ID
     * @param isSelect 是否精选标记，1-是，0-否
     * @return
     */
    @PutMapping(value = "/store/select/{id}/{isSelect}")
    ResponseMessage select(@PathVariable(value = "id") int id,
                           @PathVariable(value = "isSelect") boolean isSelect);

    /**
     * 批量精选门店
     *
     * @param selectBatchVo
     * @return
     */
    @PutMapping(value = "/store/select/batch")
    ResponseMessage selectByBatch(@RequestBody StoreBySelectBatchVo selectBatchVo);


    /**
     * 查询门店列表，可按开店时间区间查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeByDateVo 查询条件
     * @return
     */
    @PostMapping(value = "/store/front/findByPageForFrontByDate")
    PageInfo<Store> findByPageForFrontByDate(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                             @RequestBody StoreByDateVo storeByDateVo);

    /**
     * 根据老板用户ID查询门店
     *
     * @param boosUserId 老板用户ID
     * @return
     */
    @GetMapping("/store/findListByBossUserId/{boosUserId}")
    ResponseMessage<List<Store>> findListByBossUserId(@PathVariable(value = "boosUserId") int boosUserId);

    /**
     * 门店资质审核
     *
     * @param qualificationAuditVo 条件
     * @return
     */
    @PostMapping("/store/qualificationAudit")
    ResponseMessage qualificationAudit(@RequestBody StoreByQualificationAuditVo qualificationAuditVo);

    /**
     * 门店资质列表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param qualificationVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店资质列表")
    @PostMapping("/store/listQualification")
    ResponseMessage<PageInfo<StoreListQualificationResVo>> listQualification(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             @RequestBody StoreListQualificationVo qualificationVo);

    /**
     * 关闭店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "关闭店铺")
    @PutMapping(value = "/store/close/{storeId}")
    ResponseMessage close(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 开启店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "开启店铺")
    @PutMapping(value = "/store/open/{storeId}")
    ResponseMessage open(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 冻结店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "冻结店铺")
    @PutMapping(value = "/store/freeze/{storeId}")
    ResponseMessage freeze(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 店铺数据统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "店铺数据统计")
    @PostMapping("/store/data/count")
    ResponseMessage<StoreByDataCountResVo> dataCount(@ApiParam(value = "条件") @RequestBody StoreByDataCountVo dataCountVo);

}