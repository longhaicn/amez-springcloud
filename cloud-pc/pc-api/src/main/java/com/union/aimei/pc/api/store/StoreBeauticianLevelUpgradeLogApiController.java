package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeLog;
import com.union.aimei.common.feign.pc.store.StoreBeauticianLevelUpgradeLogFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "美容师成长值记录")
@RestController
@RequestMapping(value = "storeBeauticianLevelUpgradeLog")
public class StoreBeauticianLevelUpgradeLogApiController {
    @Resource
    private StoreBeauticianLevelUpgradeLogFeign storeBeauticianLevelUpgradeLogFeign;

    /**
     * 分页查询
     *
     * @param pageNo                         分页索引
     * @param pageSize                       每页显示数量
     * @param storeBeauticianLevelUpgradeLog 查询条件
     * @return ResponseMessage<StoreBeauticianLevelUpgradeLog>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询美容师成长值记录")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreBeauticianLevelUpgradeLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                      Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                      Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeLogFeign.findByPageForFront(pageNo, pageSize, storeBeauticianLevelUpgradeLog));
    }

    /**
     * 添加StoreBeauticianLevelUpgradeLog
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加美容师成长值记录")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeLogFeign.insert(storeBeauticianLevelUpgradeLog));
    }

    /**
     * 删除StoreBeauticianLevelUpgradeLog
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除美容师成长值记录")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeLogFeign.deleteById(id));
    }

    /**
     * 修改StoreBeauticianLevelUpgradeLog
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑美容师成长值记录")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeLogFeign.edit(storeBeauticianLevelUpgradeLog));
    }

    /**
     * 根据ID查询StoreBeauticianLevelUpgradeLog
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeLog
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询美容师成长值记录")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreBeauticianLevelUpgradeLog> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeLogFeign.queryById(id));
    }
}