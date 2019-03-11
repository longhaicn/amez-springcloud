package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.aimei.store.service.StoreBeauticianLevelService;
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
public class StoreBeauticianLevelController {
    @Resource
    private StoreBeauticianLevelService storeBeauticianLevelService;

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
    public ResponseMessage<PageInfo<StoreBeauticianLevel>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody StoreBeauticianLevel storeBeauticianLevel) {
        return this.storeBeauticianLevelService.findByPageForFront(pageNo, pageSize, storeBeauticianLevel);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreBeauticianLevel storeBeauticianLevel) {
        return this.storeBeauticianLevelService.addObj(storeBeauticianLevel);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianLevelService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreBeauticianLevel storeBeauticianLevel) {
        return this.storeBeauticianLevelService.modifyObj(storeBeauticianLevel);
    }

    @GetMapping("/queryById/{id}")
    public StoreBeauticianLevel queryById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianLevelService.queryObjById(id);
    }

    /**
     * 查询所有美容师等级
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有美容师等级")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreBeauticianLevel>> findListByAll() {
        return this.storeBeauticianLevelService.findListByAll();
    }

    /**
     * 根据成长值获取美容师级别
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据成长值获取美容师级别")
    @GetMapping("/getLevelBySetionGrowup/{growup}")
    public ResponseMessage<StoreBeauticianLevel> getLevelBySetionGrowup(@ApiParam("成长值") @PathVariable("growup") Integer growup) {
        return this.storeBeauticianLevelService.getLevelBySetionGrowup(growup);
    }

}