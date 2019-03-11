package com.union.aimei.store.controller;

import com.union.aimei.common.model.store.BeauticianServiceScope;
import com.union.aimei.store.service.BeauticianServiceScopeService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 11:04
 */
@Api(tags = "美容师服务范围")
@RestController
@RequestMapping(value = "beauticianServiceScope")
public class BeauticianServiceScopeController {
    @Resource
    private BeauticianServiceScopeService beauticianServiceScopeService;

    /**
     * 新增美容师服务范围
     *
     * @param beauticianServiceScope 美容师服务范围
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师服务范围")
    @PostMapping("/1.1.1/add")
    public ResponseMessage addV111(@ApiParam(value = "美容师服务范围") @RequestBody BeauticianServiceScope beauticianServiceScope) {
        return this.beauticianServiceScopeService.addV111(beauticianServiceScope);
    }

    /**
     * 根据美容师ID查询美容师服务范围
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID查询美容师服务范围")
    @GetMapping("/1.1.1/findListByBeauticianId/{beauticianId}")
    public ResponseMessage<List<BeauticianServiceScope>> findListByBeauticianIdV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.beauticianServiceScopeService.findListByBeauticianIdV111(beauticianId);
    }

    /**
     * 选择美容师服务范围（美容师-我的-服务设置-服务范围）
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "选择美容师服务范围（美容师-我的-服务设置-服务范围）")
    @PutMapping("/1.1.1/select/{id}")
    public ResponseMessage selectV111(@ApiParam(value = "条件") @PathVariable(value = "id") int id) {
        return this.beauticianServiceScopeService.selectV111(id);
    }

    /**
     * 删除美容师服务范围（美容师-我的-服务设置-服务范围）
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "删除美容师服务范围（美容师-我的-服务设置-服务范围）")
    @PutMapping("/1.1.1/delete/{id}")
    public ResponseMessage deleteV111(@ApiParam(value = "条件") @PathVariable(value = "id") int id) {
        return this.beauticianServiceScopeService.deleteV111(id);
    }

    /**
     * 修改美容师服务范围
     *
     * @param beauticianServiceScope 美容师服务范围
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改美容师服务范围")
    @PutMapping("/1.1.1/modify")
    public ResponseMessage<List<BeauticianServiceScope>> modifyV111(@ApiParam(value = "美容师服务范围") @RequestBody BeauticianServiceScope beauticianServiceScope) {
        return this.beauticianServiceScopeService.modifyV111(beauticianServiceScope);
    }

    /**
     * 根据ID查询美容师服务范围
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询美容师服务范围")
    @GetMapping("/1.1.1/findById/{id}")
    public ResponseMessage<BeauticianServiceScope> findByIdV111(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.beauticianServiceScopeService.findByIdV111(id);
    }

}