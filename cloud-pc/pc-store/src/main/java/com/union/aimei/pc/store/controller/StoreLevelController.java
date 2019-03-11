package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.pc.store.service.StoreLevelService;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺等级")
@RestController
@RequestMapping(value = "storeLevel")
public class StoreLevelController {
    @Resource
    private StoreLevelService storeLevelService;

    /**
     * 分页查询店铺等级
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param storeLevel 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询店铺等级")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreLevel>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @ApiParam(value = "查询条件") @RequestBody StoreLevel storeLevel) {
        return this.storeLevelService.findByPageForFront(pageNo, pageSize, storeLevel);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreLevel storeLevel) {
        return this.storeLevelService.addObj(storeLevel);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeLevelService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreLevel storeLevel) {
        return this.storeLevelService.modifyObj(storeLevel);
    }

    @GetMapping("/queryById/{id}")
    public StoreLevel queryById(@PathVariable(value = "id") int id) {
        return this.storeLevelService.queryObjById(id);
    }

    /**
     * 批量添加店铺等级
     *
     * @param storeLevelByBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加店铺等级")
    @PostMapping("/addByBatch")
    public ResponseMessage addByBatch(@ApiParam(value = "批量店铺等级") @RequestBody StoreLevelByBatchVo storeLevelByBatchVo) {
        return this.storeLevelService.addByBatch(storeLevelByBatchVo);
    }

    /**
     * 查询所有店铺等级
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有店铺等级")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreLevel>> findListByAll() {
        return this.storeLevelService.findListByAll();
    }

}