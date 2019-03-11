package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelByBatchVo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianLevelFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "美容师等级")
@RestController
@RequestMapping(value = "storeBeauticianLevel")
public class StoreBeauticianLevelApiController {
    @Resource
    private StoreBeauticianLevelFeign storeBeauticianLevelFeign;

    /**
     * 分页查询美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param storeBeauticianLevel 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师等级")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianLevel>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody StoreBeauticianLevel storeBeauticianLevel) {
        return new ResponseMessage(this.storeBeauticianLevelFeign.findByPageForFront(pageNo, pageSize, storeBeauticianLevel));
    }

    /**
     * 添加StoreBeauticianLevel
     *
     * @param storeBeauticianLevel
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加美容师等级")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreBeauticianLevel storeBeauticianLevel) {
        return new ResponseMessage(this.storeBeauticianLevelFeign.insert(storeBeauticianLevel));
    }

    /**
     * 删除StoreBeauticianLevel
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除美容师等级")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianLevelFeign.deleteById(id));
    }

    /**
     * 修改StoreBeauticianLevel
     *
     * @param storeBeauticianLevel
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑美容师等级")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreBeauticianLevel storeBeauticianLevel) {
        return new ResponseMessage(this.storeBeauticianLevelFeign.edit(storeBeauticianLevel));
    }

    /**
     * 根据ID查询StoreBeauticianLevel
     *
     * @param id
     * @returnstoreBeauticianLevel
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询美容师等级")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreBeauticianLevel> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianLevelFeign.queryById(id));
    }

    /**
     * 批量添加美容师等级
     *
     * @param storeBeauticianLevelByBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加美容师等级")
    @PostMapping("/addByBatch")
    public ResponseMessage addByBatch(@ApiParam(value = "批量美容师等级") @RequestBody StoreBeauticianLevelByBatchVo storeBeauticianLevelByBatchVo) {
        return new ResponseMessage(this.storeBeauticianLevelFeign.addByBatch(storeBeauticianLevelByBatchVo));
    }

    /**
     * 查询所有美容师等级
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有美容师等级")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreBeauticianLevel>> findListByAll() {
        return new ResponseMessage(this.storeBeauticianLevelFeign.findListByAll());
    }

}