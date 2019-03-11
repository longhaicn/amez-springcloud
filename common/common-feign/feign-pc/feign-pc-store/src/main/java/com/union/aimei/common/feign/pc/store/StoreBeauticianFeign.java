package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreBeauticianApiHystrix;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductVo;
import com.union.aimei.common.vo.store.pc.BeauticianByStarBatchVo;
import com.union.aimei.common.vo.store.pc.StoreBeaByFullTimeAndPartTimeVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByAuditVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByRecruitVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 店铺美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreBeauticianApiHystrix.class)
public interface StoreBeauticianFeign {
    /**
     * 添加店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @PostMapping(value = "/storeBeautician/insert")
    int insert(@RequestBody StoreBeautician storeBeautician);

    /**
     * 删除店铺美容师
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeBeautician/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @PutMapping(value = "/storeBeautician/edit")
    int edit(@RequestBody StoreBeautician storeBeautician);


    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeautician
     */
    @GetMapping(value = "/storeBeautician/queryById/{id}")
    StoreBeautician queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询店铺美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param storeBeautician 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeautician/front/findByPage")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody StoreBeautician storeBeautician);

    /**
     * 根据用户ID查询店铺美容师
     *
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/storeBeautician/findByUserId/{userId}")
    ResponseMessage<StoreBeautician> findByUserId(@ApiParam(value = "用户ID") @PathVariable(value = "userId") int userId);

    /**
     * 根据用户ID查询店铺美容师（正常）
     *
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/storeBeautician/findByUserIdForNormal/{userId}")
    ResponseMessage<StoreBeautician> findByUserIdForNormal(@ApiParam(value = "用户ID") @PathVariable(value = "userId") int userId);

    /**
     * 根据手机号查询店铺美容师
     *
     * @param phone 手机号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据手机号查询店铺美容师")
    @GetMapping("/storeBeautician/findByPhone/{phone}")
    ResponseMessage<StoreBeautician> findByPhone(@ApiParam(value = "手机号") @PathVariable(value = "phone") String phone);


    /**
     * 根据店铺id 统计 工牌号相同的员工数量
     *
     * @param storeId    店铺id
     * @param workCardNo 员工工牌号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺id 统计 工牌号相同的员工数量")
    @GetMapping("/storeBeautician/workCardNoByStoreIdCount/{storeId}/{workCardNo}")
    ResponseMessage workCardNoByStoreIdCount(@ApiParam(value = "店铺id") @PathVariable(value = "storeId") Integer storeId,
                                             @ApiParam(value = "员工工牌号") @PathVariable(value = "workCardNo") String workCardNo);

    /**
     * 根据会员id查询店铺美容师
     *
     * @param memberId 会员id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据会员id查询店铺美容师")
    @GetMapping("/storeBeautician/findByMemberId/{memberId}")
    ResponseMessage<StoreBeautician> findByMemberId(@ApiParam(value = "会员id") @PathVariable(value = "memberId") Integer memberId);

    /**
     * 分页查询店铺美容师（招募）
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页数量
     * @param storeBeauticianByRecruitVo 查询条件
     * @return
     */
    @PostMapping("/storeBeautician/findByPageForRecruit")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestBody StoreBeauticianByRecruitVo storeBeauticianByRecruitVo);

    /**
     * 根据ID查询店铺美容师
     *
     * @param id
     * @return
     */
    @GetMapping("/storeBeautician/findById/{id}")
    ResponseMessage<StoreBeautician> findById(@PathVariable(value = "id") int id);

    /**
     * 根据店铺ID查询店长
     *
     * @param storeId 店铺ID
     * @return
     */
    @GetMapping("/storeBeautician/findByStoreIdForManager/{storeId}")
    ResponseMessage<StoreBeautician> findByStoreIdForManager(@PathVariable(value = "storeId") int storeId);

    /**
     * 分页查询美容师（正式与兼职）
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param fullTimeAndPartTimeVo 查询条件
     * @return
     */
    @PostMapping("/storeBeautician/findByPageForFullTimeAndPartTime")
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @RequestBody StoreBeaByFullTimeAndPartTimeVo fullTimeAndPartTimeVo);

    /**
     * 待审核美容师统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/pending/count")
    ResponseMessage<Integer> pendingByCount(@RequestBody StoreByDataCountVo dataCountVo);

    /**
     * 明星美容师
     *
     * @param id     美容师ID
     * @param isStar 明星标记，1-是，0-否
     * @return
     */
    @PutMapping(value = "/storeBeautician/star/{id}/{isStar}")
    ResponseMessage star(@PathVariable(value = "id") int id,
                         @PathVariable(value = "isStar") boolean isStar);

    /**
     * 批量明星美容师
     *
     * @param starBatchVo
     * @return
     */
    @PutMapping(value = "/storeBeautician/star/batch")
    ResponseMessage starByBatch(@RequestBody BeauticianByStarBatchVo starBatchVo);

    /**
     * 修改员工信息 限定 工号牌不可重复
     *
     * @param storeBeautician
     * @return
     */
    @PutMapping(value = "/storeBeautician/editLimitWorkCardNoByStoreId")
    ResponseMessage editLimitWorkCardNoByStoreId(@RequestBody StoreBeautician storeBeautician);

    /**
     * 新增美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @PostMapping(value = "/storeBeautician/add")
    ResponseMessage add(@RequestBody StoreBeautician storeBeautician);

    /**
     * 修改美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    @PutMapping(value = "/storeBeautician/modify")
    ResponseMessage modify(@RequestBody StoreBeautician storeBeautician);

    /**
     * 上架项目选择美容师列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param productVo 条件
     * @return
     */
    @PostMapping("/storeBeautician/listSelectOnSaleProduct")
    ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProduct(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                              @RequestBody BeauticianListSelectOnSaleProductVo productVo);

    /**
     * 根据门店ID查询全职美容师
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/storeBeautician/listFullTimeByStoreId/{storeId}")
    ResponseMessage<List<StoreBeautician>> listFullTimeByStoreId(@PathVariable(value = "storeId") int storeId);

    /**
     * 美容师审核
     *
     * @param auditVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "美容师审核")
    @PutMapping("/storeBeautician/audit")
    ResponseMessage audit(@ApiParam(value = "参数") @RequestBody StoreBeauticianByAuditVo auditVo);

}
