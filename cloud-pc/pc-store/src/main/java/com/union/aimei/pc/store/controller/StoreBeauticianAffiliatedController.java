package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveVo;
import com.union.aimei.common.vo.store.pc.AffiliatedPlatformAuditVo;
import com.union.aimei.pc.store.service.StoreBeauticianAffiliatedService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 挂靠
 *
 * @author liurenkai
 * @time 2018/5/10 17:11
 */
@Api(tags = "挂靠")
@RestController
@RequestMapping(value = "storeBeauticianAffiliated")
public class StoreBeauticianAffiliatedController {
    @Resource
    private StoreBeauticianAffiliatedService storeBeauticianAffiliatedService;

    /**
     * 分页查询挂靠
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param affiliated 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询挂靠")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @ApiParam(value = "查询条件") @RequestBody StoreBeauticianAffiliated affiliated) {
        return this.storeBeauticianAffiliatedService.findByPageForFront(pageNo, pageSize, affiliated);
    }

    /**
     * 新增挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增挂靠")
    @PostMapping("/add")
    public ResponseMessage<StoreBeauticianAffiliated> addV111(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated affiliated) {
        return this.storeBeauticianAffiliatedService.add(affiliated);
    }

    /**
     * 修改挂靠
     *
     * @param affiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改挂靠")
    @PutMapping("/modify")
    public ResponseMessage modify(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated affiliated) {
        return this.storeBeauticianAffiliatedService.modify(affiliated);
    }

    /**
     * 根据ID查询挂靠
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询挂靠")
    @GetMapping("/findById/{id}")
    public ResponseMessage<StoreBeauticianAffiliated> findById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeBeauticianAffiliatedService.findById(id);
    }

    /**
     * 平台审核挂靠
     *
     * @param platformAuditVo 平台审核条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "平台审核挂靠")
    @PostMapping("/platformAudit")
    public ResponseMessage platformAudit(@ApiParam(value = "门店ID") @RequestBody AffiliatedPlatformAuditVo platformAuditVo) {
        return this.storeBeauticianAffiliatedService.platformAudit(platformAuditVo);
    }

    /**
     * 解除挂靠列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param removeVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "解除挂靠列表")
    @PostMapping("/listRemove")
    public ResponseMessage<PageInfo<AffiliatedListRemoveResVo>> listRemove(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @ApiParam(value = "条件") @RequestBody AffiliatedListRemoveVo removeVo) {
        return this.storeBeauticianAffiliatedService.listRemove(pageNo, pageSize, removeVo);
    }

}