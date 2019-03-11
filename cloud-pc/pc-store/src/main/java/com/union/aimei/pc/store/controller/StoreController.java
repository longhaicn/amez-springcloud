package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.pc.*;
import com.union.aimei.pc.store.service.StoreService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "门店")
@RestController
@RequestMapping(value = "store")
public class StoreController {
    @Resource
    private StoreService storeService;

    @PostMapping("/front/findByPage")
    public PageInfo<Store> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @ApiParam(value = "查询条件") @RequestBody Store store) {
        return this.storeService.findByPageForFront(pageNo, pageSize, store);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Store store) {
        return this.storeService.addObj(store);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody Store store) {
        return this.storeService.modifyObj(store);
    }

    @GetMapping("/queryById/{id}")
    public Store queryById(@PathVariable(value = "id") int id) {
        return this.storeService.queryObjById(id);
    }

    /**
     * 查询门店（品牌ID）
     *
     * @param storeByBrandIdVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询门店（品牌ID）")
    @PostMapping("/findListByBrandId")
    public ResponseMessage<List<Store>> findListByBrandId(@ApiParam(value = "查询条件") @RequestBody StoreByBrandIdVo storeByBrandIdVo) {
        return this.storeService.findListByBrandId(storeByBrandIdVo);
    }

    /**
     * 新增门店
     *
     * @param storeVo 门店条件
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseMessage<StoreVo> add(@RequestBody StoreVo storeVo) {
        return this.storeService.add(storeVo);
    }

    /**
     * 修改门店
     *
     * @param storeVo 门店条件
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改门店")
    @PutMapping(value = "/modify")
    public ResponseMessage modify(@ApiParam(value = "修改门店") @RequestBody StoreVo storeVo) {
        return this.storeService.modify(storeVo);
    }

    /**
     * 获取门店
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "后台-获取门店与扩展信息")
    @GetMapping(value = "/detail/{storeId}")
    public ResponseMessage<StoreVo> detail(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeService.detail(storeId);
    }

    /**
     * 修改门店软删除标记
     *
     * @param storeId   门店ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改门店软删除标记")
    @PutMapping(value = "/modify/isEnabled/{storeId}/{isEnabled}")
    public ResponseMessage modifyIsEnabled(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId,
                                           @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.storeService.modifyIsEnabled(storeId, isEnabled);
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
     * 分页查询门店（会员卡）
     *
     * @param pageNo              分页索引
     * @param pageSize            每页数量
     * @param storeByMemberCardVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店（会员卡）")
    @PostMapping("/findByPageForMemberCard")
    public ResponseMessage<PageInfo<StoreByMemberCardResultVo>> findByPageForMemberCard(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                        @ApiParam(value = "查询条件") @RequestBody StoreByMemberCardVo storeByMemberCardVo) {
        return this.storeService.findByPageForMemberCard(pageNo, pageSize, storeByMemberCardVo);
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
     * 位置搜索
     *
     * @param placeSearchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "位置搜索")
    @PostMapping("/findListByPlaceSearch")
    public ResponseMessage<JSONArray> findListByPlaceSearch(@ApiParam(value = "查询条件") @RequestBody PlaceSearchVo placeSearchVo) {
        return this.storeService.findListByPlaceSearch(placeSearchVo);
    }

    /**
     * 根据ID查询门店
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据ID查询门店")
    @GetMapping("/findById/{id}")
    public ResponseMessage<Store> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeService.findById(id);
    }

    /**
     * 根据ID查询门店（开启）
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据ID查询门店（开启）")
    @GetMapping("/findById/open/{id}")
    public ResponseMessage<Store> findByIdForOpen(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeService.findByIdForOpen(id);
    }

    /**
     * 根据ID查询门店（批量）
     *
     * @param idBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据ID查询门店（批量）")
    @PostMapping("/findListByIdBatch")
    public ResponseMessage<List<Store>> findListByIdBatch(@ApiParam(value = "查询条件") @RequestBody IdBatchVo idBatchVo) {
        return this.storeService.findListByIdBatch(idBatchVo);
    }

    /**
     * 新增门店统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增门店统计")
    @PostMapping("/add/count")
    public ResponseMessage<Integer> addByCount(@ApiParam("条件") @RequestBody StoreByDataCountVo dataCountVo) {
        return this.storeService.addByCount(dataCountVo);
    }

    /**
     * 精选门店
     *
     * @param id       门店ID
     * @param isSelect 是否精选标记，1-是，0-否
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "精选门店")
    @PutMapping(value = "/select/{id}/{isSelect}")
    public ResponseMessage select(@ApiParam(value = "门店ID") @PathVariable(value = "id") int id,
                                  @ApiParam(value = "是否精选标记，1-是，0-否") @PathVariable(value = "isSelect") boolean isSelect) {
        return this.storeService.select(id, isSelect);
    }

    /**
     * 批量精选门店
     *
     * @param selectBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量精选门店")
    @PutMapping(value = "/select/batch")
    public ResponseMessage selectByBatch(@ApiParam(value = "批量精选门店") @RequestBody StoreBySelectBatchVo selectBatchVo) {
        return this.storeService.selectByBatch(selectBatchVo);
    }

    /**
     * 查询门店列表，可按开店时间区间查询
     *
     * @param pageNo      每页数量
     * @param pageSize    查询条件
     * @param storeByDate 分页索引
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询门店列表，可按开店时间区间查询")
    @PostMapping("/front/findByPageForFrontByDate")
    public PageInfo<Store> findByPageForFrontByDate(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                    @ApiParam(value = "查询条件") @RequestBody StoreByDateVo storeByDate) {
        return this.storeService.findByPageForFrontByDate(pageNo, pageSize, storeByDate);
    }

    /**
     * 根据老板用户ID查询门店
     *
     * @param boosUserId 老板用户ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据老板用户ID查询门店")
    @GetMapping("/findListByBossUserId/{boosUserId}")
    public ResponseMessage<List<Store>> findListByBossUserId(@ApiParam(value = "老板用户ID") @PathVariable(value = "boosUserId") int boosUserId) {
        return this.storeService.findListByBossUserId(boosUserId);
    }

    /**
     * 门店资质审核
     *
     * @param qualificationAuditVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店资质审核")
    @PostMapping("/qualificationAudit")
    public ResponseMessage qualificationAudit(@ApiParam(value = "条件") @RequestBody StoreByQualificationAuditVo qualificationAuditVo) {
        return this.storeService.qualificationAudit(qualificationAuditVo);
    }

    /**
     * 门店资质列表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param qualificationVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店资质列表")
    @PostMapping("/listQualification")
    public ResponseMessage<PageInfo<StoreListQualificationResVo>> listQualification(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                    @ApiParam(value = "条件") @RequestBody StoreListQualificationVo qualificationVo) {
        return this.storeService.listQualification(pageNo, pageSize, qualificationVo);
    }

    /**
     * 关闭店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "关闭店铺")
    @PutMapping(value = "/close/{storeId}")
    public ResponseMessage close(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeService.close(storeId);
    }

    /**
     * 开启店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "开启店铺")
    @PutMapping(value = "/open/{storeId}")
    public ResponseMessage open(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeService.open(storeId);
    }

    /**
     * 冻结店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "冻结店铺")
    @PutMapping(value = "/freeze/{storeId}")
    public ResponseMessage freeze(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeService.freeze(storeId);
    }

    /**
     * 店铺数据统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "店铺数据统计")
    @PostMapping("/data/count")
    public ResponseMessage<StoreByDataCountResVo> dataCount(@ApiParam(value = "条件") @RequestBody StoreByDataCountVo dataCountVo) {
        return this.storeService.dataCount(dataCountVo);
    }

}