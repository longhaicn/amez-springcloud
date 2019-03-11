package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductVo;
import com.union.aimei.common.vo.store.pc.BeauticianByStarBatchVo;
import com.union.aimei.common.vo.store.pc.StoreBeaByFullTimeAndPartTimeVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByRecruitVo;
import com.union.aimei.pc.store.service.StoreBeauticianService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "店铺美容师")
@RestController
@RequestMapping(value = "storeBeautician")
public class StoreBeauticianController {
    @Resource
    private StoreBeauticianService storeBeauticianService;

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
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
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
     * 根据用户ID查询店铺美容师
     *
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据用户ID查询店铺美容师")
    @GetMapping("/findByUserId/{userId}")
    public ResponseMessage<StoreBeautician> findByUserId(@ApiParam(value = "用户ID") @PathVariable(value = "userId") int userId) {
        return this.storeBeauticianService.findByUserId(userId);
    }

    /**
     * 根据用户ID查询店铺美容师（正常）
     *
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据用户ID查询店铺美容师（正常）")
    @GetMapping("/findByUserIdForNormal/{userId}")
    public ResponseMessage<StoreBeautician> findByUserIdForNormal(@ApiParam(value = "用户ID") @PathVariable(value = "userId") int userId) {
        return this.storeBeauticianService.findByUserIdForNormal(userId);
    }

    /**
     * 根据手机号查询店铺美容师
     *
     * @param phone 手机号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据手机号查询店铺美容师")
    @GetMapping("/findByPhone/{phone}")
    public ResponseMessage<StoreBeautician> findByPhone(@ApiParam(value = "手机号") @PathVariable(value = "phone") String phone) {
        return this.storeBeauticianService.findByPhone(phone);
    }

    /**
     * 根据会员id查询店铺美容师
     *
     * @param memberId 手机号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据会员id查询店铺美容师")
    @GetMapping("/findByMemberId/{memberId}")
    public ResponseMessage<StoreBeautician> findByMemberId(@ApiParam(value = "会员id") @PathVariable(value = "memberId") Integer memberId) {
        return this.storeBeauticianService.findByMemberId(memberId);
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
        return this.storeBeauticianService.findByPageForRecruit(pageNo, pageSize, storeBeauticianByRecruitVo);
    }

    /**
     * 根据ID查询店铺美容师
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询店铺美容师")
    @GetMapping("/findById/{id}")
    public ResponseMessage<StoreBeautician> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeBeauticianService.findById(id);
    }

    /**
     * 根据店铺ID查询店长
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺ID查询店长")
    @GetMapping("/findByStoreIdForManager/{storeId}")
    public ResponseMessage<StoreBeautician> findByStoreIdForManager(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianService.findByStoreIdForManager(storeId);
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
        return this.storeBeauticianService.findByPageForFullTimeAndPartTime(pageNo, pageSize, fullTimeAndPartTimeVo);
    }

    /**
     * 待审核美容师统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "待审核美容师统计")
    @PostMapping("/pending/count")
    public ResponseMessage<Integer> pendingByCount(@ApiParam(value = "条件") @RequestBody StoreByDataCountVo dataCountVo) {
        return this.storeBeauticianService.pendingByCount(dataCountVo);
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
        return this.storeBeauticianService.star(id, isStar);
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
        return this.storeBeauticianService.starByBatch(starBatchVo);
    }


    /**
     * 根据店铺id 统计 工牌号相同的员工数量
     *
     * @param storeId    店铺id
     * @param workCardNo 员工工牌号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺id 统计 工牌号相同的员工数量")
    @GetMapping("/workCardNoByStoreIdCount/{storeId}/{workCardNo}")
    public ResponseMessage<StoreBeautician> workCardNoByStoreIdCount(@ApiParam(value = "店铺id") @PathVariable(value = "storeId") int storeId,
                                                                     @ApiParam(value = "员工工牌号") @PathVariable(value = "workCardNo") String workCardNo) {
        return this.storeBeauticianService.workCardNoByStoreIdCount(storeId, workCardNo, -1);
    }


    /**
     * 修改员工信息 限定 工号牌不可重复
     *
     * @param storeBeautician 数据
     * @return
     */
    @PutMapping("/editLimitWorkCardNoByStoreId")
    public ResponseMessage editLimitWorkCardNoByStoreId(@RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.editLimitWorkCardNoByStoreId(storeBeautician);
    }

    /**
     * 新增美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "美容师") @RequestBody StoreBeautician storeBeautician) {
        return this.storeBeauticianService.add(storeBeautician);
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
        return this.storeBeauticianService.modify(storeBeautician);
    }

    /**
     * 根据门店ID查询全职美容师
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询全职美容师")
    @GetMapping("/listFullTimeByStoreId/{storeId}")
    public ResponseMessage<List<StoreBeautician>> listFullTimeByStoreId(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeBeauticianService.listFullTimeByStoreId(storeId);
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
        return this.storeBeauticianService.listSelectOnSaleProduct(pageNo, pageSize, productVo);
    }

}