package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.pc.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@SuppressWarnings("ALL")
@Api(tags = "店铺")
@RestController
@RequestMapping(value = "store")
public class StoreApiController {
    @Resource
    private StoreFeign storeFeign;

    /**
     * 分页查询
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param store    查询条件
     * @return ResponseMessage<Store>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺")
    @PostMapping("/front/findByPage")
    public ResponseMessage<Store> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @ApiParam(value = "查询条件") @RequestBody Store store) {
        return new ResponseMessage(this.storeFeign.findByPageForFront(pageNo, pageSize, store));
    }

    /**
     * 添加Store
     *
     * @param store
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody Store store) {
        return new ResponseMessage(this.storeFeign.insert(store));
    }

    /**
     * 删除Store
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeFeign.deleteById(id));
    }

    /**
     * 修改Store
     *
     * @param store
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody Store store) {
        return new ResponseMessage(this.storeFeign.edit(store));
    }

    /**
     * 根据ID查询Store
     *
     * @param id
     * @returnstore
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<Store> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeFeign.queryById(id));
    }

    /**
     * 查询店铺（品牌ID）
     *
     * @param storeByBrandIdVo
     * @return
     */
    @GetMapping("/findListByBrandId")
    public ResponseMessage<List<Store>> findListByBrandId(@ApiParam(value = "查询条件") @RequestBody StoreByBrandIdVo storeByBrandIdVo) {
        return this.storeFeign.findListByBrandId(storeByBrandIdVo);
    }

    /**
     * 新增店铺
     *
     * @param storeVo 店铺vo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "后台-新增店铺与扩展信息")
    @PostMapping(value = "/add")
    public ResponseMessage<StoreVo> add(@RequestBody StoreVo storeVo) {
        return this.storeFeign.add(storeVo);
    }

    /**
     * 修改店铺
     *
     * @param storeVo 店铺vo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "后台-修改店铺与扩展信息")
    @PutMapping(value = "/modify")
    public ResponseMessage modify(@RequestBody StoreVo storeVo) {
        return this.storeFeign.modify(storeVo);
    }

    /**
     * 获取店铺
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "后台-获取店铺与扩展信息")
    @GetMapping(value = "/detail/{storeId}")
    public ResponseMessage<StoreVo> detail(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeFeign.detail(storeId);
    }

    /**
     * 修改店铺软删除标记
     *
     * @param storeId   店铺ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改店铺软删除标记")
    @PutMapping(value = "/modify/isEnabled/{storeId}/{isEnabled}")
    public ResponseMessage modifyIsEnabled(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId, @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.storeFeign.modifyIsEnabled(storeId, isEnabled);
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
        return this.storeFeign.close(storeId);
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
        return this.storeFeign.open(storeId);
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
        return this.storeFeign.freeze(storeId);
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
     * 分页查询店铺（会员卡）
     *
     * @param pageNo              分页索引
     * @param pageSize            每页数量
     * @param storeByMemberCardVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询店铺（会员卡）")
    @PostMapping("/findByPageForMemberCard")
    public ResponseMessage<PageInfo<StoreByMemberCardResultVo>> findByPageForMemberCard(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                        @ApiParam(value = "查询条件") @RequestBody StoreByMemberCardVo storeByMemberCardVo) {
        return this.storeFeign.findByPageForMemberCard(pageNo, pageSize, storeByMemberCardVo);
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
        return this.storeFeign.dataCount(dataCountVo);
    }

    /**
     * 精选店铺
     *
     * @param id       店铺ID
     * @param isSelect 是否精选标记，1-是，0-否
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "精选店铺")
    @PutMapping(value = "/select/{id}/{isSelect}")
    public ResponseMessage select(@ApiParam(value = "店铺ID") @PathVariable(value = "id") int id,
                                  @ApiParam(value = "是否精选标记，1-是，0-否") @PathVariable(value = "isSelect") boolean isSelect) {
        return this.storeFeign.select(id, isSelect);
    }

    /**
     * 批量精选店铺
     *
     * @param selectBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量精选店铺")
    @PutMapping(value = "/select/batch")
    public ResponseMessage selectByBatch(@ApiParam(value = "批量精选店铺") @RequestBody StoreBySelectBatchVo selectBatchVo) {
        return this.storeFeign.selectByBatch(selectBatchVo);
    }

    /**
     * 查询店铺列表，可按开店时间区间查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeByDateVo 查询条件
     * @return ResponseMessage<Store>
     */
    @ApiOperation(httpMethod = "POST", value = "查询店铺列表，可按开店时间区间查询")
    @PostMapping("/front/findByPageForFrontByDate")
    public ResponseMessage<Store> findByPageForFrontByDate(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @ApiParam(value = "查询条件") @RequestBody StoreByDateVo storeByDateVo) {
        return new ResponseMessage(this.storeFeign.findByPageForFrontByDate(pageNo, pageSize, storeByDateVo));
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
        return this.storeFeign.qualificationAudit(qualificationAuditVo);
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
        return this.storeFeign.listQualification(pageNo, pageSize, qualificationVo);
    }

}