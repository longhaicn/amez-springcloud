package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.aimei.store.service.StoreOpenCityService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/12 19:02
 */
@Api(tags = "门店开通城市")
@RestController
@RequestMapping(value = "storeOpenCity")
public class StoreOpenCityController {
    @Resource
    private StoreOpenCityService storeOpenCityService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreOpenCity> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                      @ApiParam(value = "查询条件") @RequestBody StoreOpenCity storeOpenCity) {
        return this.storeOpenCityService.findByPageForFront(pageNo, pageSize, storeOpenCity);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreOpenCity storeOpenCity) {
        return this.storeOpenCityService.addObj(storeOpenCity);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeOpenCityService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreOpenCity storeOpenCity) {
        return this.storeOpenCityService.modifyObj(storeOpenCity);
    }

    @GetMapping("/queryById/{id}")
    public StoreOpenCity queryById(@PathVariable(value = "id") int id) {
        return this.storeOpenCityService.queryObjById(id);
    }

    /**
     * 查询所有门店开通城市
     *
     * @param storeOpenCity 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询所有门店开通城市")
    @PostMapping("/listAll")
    public ResponseMessage<List<StoreOpenCity>> listAll() {
        return this.storeOpenCityService.listAll();
    }

}