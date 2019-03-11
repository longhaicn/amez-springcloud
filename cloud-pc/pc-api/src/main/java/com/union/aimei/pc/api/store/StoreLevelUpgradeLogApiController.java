package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import com.union.aimei.common.feign.pc.store.StoreLevelUpgradeLogFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Api(tags = "店铺成长值记录")
@RestController
@RequestMapping(value = "storeLevelUpgradeLog")
public class StoreLevelUpgradeLogApiController {
    @Resource
    private StoreLevelUpgradeLogFeign storeLevelUpgradeLogFeign;

    /**
     * 分页查询
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeLevelUpgradeLog 查询条件
     * @return ResponseMessage<StoreLevelUpgradeLog>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺成长值记录")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreLevelUpgradeLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return new ResponseMessage(this.storeLevelUpgradeLogFeign.findByPageForFront(pageNo, pageSize, storeLevelUpgradeLog));
    }

    /**
     * 添加StoreLevelUpgradeLog
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺成长值记录")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return new ResponseMessage(this.storeLevelUpgradeLogFeign.insert(storeLevelUpgradeLog));
    }

    /**
     * 删除StoreLevelUpgradeLog
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺成长值记录")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeLevelUpgradeLogFeign.deleteById(id));
    }

    /**
     * 修改StoreLevelUpgradeLog
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺成长值记录")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog) {
        return new ResponseMessage(this.storeLevelUpgradeLogFeign.edit(storeLevelUpgradeLog));
    }

    /**
     * 根据ID查询StoreLevelUpgradeLog
     *
     * @param id
     * @returnstoreLevelUpgradeLog
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺成长值记录")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreLevelUpgradeLog> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeLevelUpgradeLogFeign.queryById(id));
    }
}