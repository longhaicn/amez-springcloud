package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductVo;
import com.union.aimei.common.vo.store.pc.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "店铺美容师")
@RestController
@RequestMapping(value = "storeBeautician")
public class StoreBeauticianApiController {
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    /**
     * 分页查询店铺美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param storeBeautician 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询店铺美容师")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                 Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                 Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianFeign.findByPageForFront(pageNo, pageSize, storeBeautician);
    }

    /**
     * 添加StoreBeautician
     *
     * @param storeBeautician
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺美容师")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreBeautician storeBeautician) {
        return new ResponseMessage(this.storeBeauticianFeign.insert(storeBeautician));
    }

    /**
     * 删除StoreBeautician
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺美容师")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianFeign.deleteById(id));
    }

    /**
     * 修改StoreBeautician
     *
     * @param storeBeautician
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺美容师")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreBeautician storeBeautician) {
        return new ResponseMessage(this.storeBeauticianFeign.edit(storeBeautician));
    }

    /**
     * 根据ID查询StoreBeautician
     *
     * @param id
     * @returnstoreBeautician
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺美容师")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreBeautician> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianFeign.queryById(id));
    }

    /**
     * 根据用户ID查询店铺美容师
     *
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据用户ID查询店铺美容师")
    @GetMapping("/findByUserId/{userId}")
    public ResponseMessage<StoreBeautician> findByUserId(@ApiParam(value = "用户ID") @PathVariable(value = "userId") int userId) {
        return this.storeBeauticianFeign.findByUserId(userId);
    }


    /**
     * 分页查询店铺美容师（招募）
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页数量
     * @param storeBeauticianByRecruitVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询店铺美容师（招募）")
    @PostMapping("/findByPageForRecruit")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @ApiParam(value = "查询条件") @RequestBody StoreBeauticianByRecruitVo storeBeauticianByRecruitVo) {
        return this.storeBeauticianFeign.findByPageForRecruit(pageNo, pageSize, storeBeauticianByRecruitVo);
    }


    /**
     * 添加店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺美容师")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "店铺美容师") @RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianFeign.add(storeBeautician);
    }

    /**
     * 美容师审核
     *
     * @param auditVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师审核")
    @PutMapping("/audit")
    public ResponseMessage audit(@ApiParam(value = "参数") @RequestBody StoreBeauticianByAuditVo auditVo) {
        return this.storeBeauticianFeign.audit(auditVo);
    }

    /**
     * 分页查询美容师（正式与兼职）
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param fullTimeAndPartTimeVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师（正式与兼职）")
    @PostMapping("/findByPageForFullTimeAndPartTime")
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @ApiParam(value = "查询条件") @RequestBody StoreBeaByFullTimeAndPartTimeVo fullTimeAndPartTimeVo) {
        return this.storeBeauticianFeign.findByPageForFullTimeAndPartTime(pageNo, pageSize, fullTimeAndPartTimeVo);
    }

    /**
     * 明星美容师
     *
     * @param id     美容师ID
     * @param isStar 明星标记，1-是，0-否
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "明星美容师")
    @PutMapping(value = "/star/{id}/{isStar}")
    public ResponseMessage star(@ApiParam(value = "美容师ID") @PathVariable(value = "id") int id,
                                @ApiParam(value = "明星标记，1-是，0-否") @PathVariable(value = "isStar") boolean isStar) {
        return this.storeBeauticianFeign.star(id, isStar);
    }

    /**
     * 批量明星美容师
     *
     * @param starBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量明星美容师")
    @PutMapping(value = "/star/batch")
    public ResponseMessage starByBatch(@ApiParam(value = "批量明星美容师") @RequestBody BeauticianByStarBatchVo starBatchVo) {
        return this.storeBeauticianFeign.starByBatch(starBatchVo);
    }

    /**
     * 根据 店铺id 和 工牌号判断工牌号是否重复
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据 店铺id 和 工牌号判断工牌号是否重复")
    @GetMapping("/workCardNoByStoreIdCount/{storeId}/{workCardNo}")
    public ResponseMessage<StoreBeauticianByUserIdResultVo> workCardNoByStoreIdCount(@ApiParam(value = "店铺id") @PathVariable(value = "storeId") int storeId,
                                                                                     @ApiParam(value = "工牌号") @PathVariable(value = "workCardNo") String workCardNo) {
        return this.storeBeauticianFeign.workCardNoByStoreIdCount(storeId, workCardNo);
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
    @PostMapping("/listSelectOnSaleProduct")
    public ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProduct(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                     @ApiParam(value = "条件") @RequestBody BeauticianListSelectOnSaleProductVo productVo) {
        return this.storeBeauticianFeign.listSelectOnSaleProduct(pageNo, pageSize, productVo);
    }

}