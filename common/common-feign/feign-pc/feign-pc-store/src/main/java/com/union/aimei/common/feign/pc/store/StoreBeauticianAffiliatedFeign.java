package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreBeauticianAffiliatedApiHystrix;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveVo;
import com.union.aimei.common.vo.store.pc.AffiliatedPlatformAuditVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:14
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreBeauticianAffiliatedApiHystrix.class)
public interface StoreBeauticianAffiliatedFeign {

    /**
     * 分页查询挂靠
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param affiliated 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianAffiliated/front/findByPage")
    ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @RequestBody StoreBeauticianAffiliated affiliated);

    /**
     * 新增挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/add")
    ResponseMessage<StoreBeauticianAffiliated> addV111(@RequestBody StoreBeauticianAffiliated affiliated);

    /**
     * 修改挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    @PutMapping("/storeBeauticianAffiliated/modify")
    ResponseMessage modifyV111(@RequestBody StoreBeauticianAffiliated affiliated);

    /**
     * 根据ID查询挂靠
     *
     * @param id ID
     * @return
     */
    @GetMapping("/storeBeauticianAffiliated/findById/{id}")
    ResponseMessage<StoreBeauticianAffiliated> findByIdV111(@PathVariable(value = "id") int id);

    /**
     * 平台审核挂靠
     *
     * @param platformAuditVo 平台审核条件
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/platformAudit")
    ResponseMessage platformAuditV111(@RequestBody AffiliatedPlatformAuditVo platformAuditVo);

    /**
     * 解除挂靠列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param removeVo 条件
     * @return
     */
    @PostMapping("/storeBeauticianAffiliated/listRemove")
    ResponseMessage<PageInfo<AffiliatedListRemoveResVo>> listRemove(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestBody AffiliatedListRemoveVo removeVo);

}