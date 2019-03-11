package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.aimei.common.feign.pc.store.StoreLevelFeign;
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
public class StoreLevelApiController {
    @Resource
    private StoreLevelFeign storeLevelFeign;

    /**
     * 分页查询
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param storeLevel 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询店铺等级")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreLevel>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @ApiParam(value = "查询条件") @RequestBody StoreLevel storeLevel) {
        return new ResponseMessage(this.storeLevelFeign.findByPageForFront(pageNo, pageSize, storeLevel));
    }

    /**
     * 添加StoreLevel
     *
     * @param storeLevel
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺等级")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreLevel storeLevel) {
        return new ResponseMessage(this.storeLevelFeign.insert(storeLevel));
    }

    /**
     * 删除StoreLevel
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺等级")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeLevelFeign.deleteById(id));
    }

    /**
     * 修改StoreLevel
     *
     * @param storeLevel
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺等级")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreLevel storeLevel) {
        return new ResponseMessage(this.storeLevelFeign.edit(storeLevel));
    }

    /**
     * 根据ID查询StoreLevel
     *
     * @param id
     * @returnstoreLevel
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺等级")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreLevel> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeLevelFeign.queryById(id));
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
        return new ResponseMessage(this.storeLevelFeign.addByBatch(storeLevelByBatchVo));
    }

    /**
     * 查询所有店铺等级
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有店铺等级")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreLevel>> findListByAll() {
        return new ResponseMessage(this.storeLevelFeign.findListByAll());
    }

}