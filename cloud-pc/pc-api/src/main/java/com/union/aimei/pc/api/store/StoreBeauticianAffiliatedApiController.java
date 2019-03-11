package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianAffiliatedFeign;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveResVo;
import com.union.aimei.common.vo.store.pc.AffiliatedListRemoveVo;
import com.union.aimei.common.vo.store.pc.AffiliatedPlatformAuditVo;
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
public class StoreBeauticianAffiliatedApiController {
    @Resource
    private StoreBeauticianAffiliatedFeign storeBeauticianAffiliatedFeign;

    /**
     * 分页查询挂靠
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页数量
     * @param storeBeauticianAffiliated 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询挂靠")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianAffiliated>> findByPageForFrontV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @ApiParam(value = "查询条件") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedFeign.findByPageForFrontV111(pageNo, pageSize, storeBeauticianAffiliated);
    }

    /**
     * 新增挂靠
     *
     * @param storeBeauticianAffiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增挂靠")
    @PostMapping("/add")
    public ResponseMessage addV111(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedFeign.addV111(storeBeauticianAffiliated);
    }

    /**
     * 修改挂靠
     *
     * @param storeBeauticianAffiliated 挂靠
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改挂靠")
    @PutMapping("/modify")
    public ResponseMessage modifyV111(@ApiParam(value = "挂靠") @RequestBody StoreBeauticianAffiliated storeBeauticianAffiliated) {
        return this.storeBeauticianAffiliatedFeign.modifyV111(storeBeauticianAffiliated);
    }

    /**
     * 根据ID查询挂靠
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询挂靠")
    @GetMapping("/findById/{id}")
    public ResponseMessage<StoreBeauticianAffiliated> findByIdV111(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.storeBeauticianAffiliatedFeign.findByIdV111(id);
    }

    /**
     * 平台审核挂靠
     *
     * @param platformAuditVo 平台审核条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "平台审核挂靠")
    @PostMapping("/platformAudit")
    public ResponseMessage platformAuditV111(@ApiParam(value = "门店ID") @RequestBody AffiliatedPlatformAuditVo platformAuditVo) {
        return this.storeBeauticianAffiliatedFeign.platformAuditV111(platformAuditVo);
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
        return this.storeBeauticianAffiliatedFeign.listRemove(pageNo, pageSize, removeVo);
    }

}