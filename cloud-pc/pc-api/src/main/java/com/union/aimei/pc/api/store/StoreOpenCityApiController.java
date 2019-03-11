package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.aimei.common.feign.pc.store.StoreOpenCityFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/13 14:07
 */
@Api(tags = "门店开通城市")
@RestController
@RequestMapping(value = "storeOpenCity")
public class StoreOpenCityApiController {
    @Resource
    private StoreOpenCityFeign storeOpenCityFeign;

    /**
     * 分页查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeOpenCity 查询条件
     * @return ResponseMessage<StoreOpenCity>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询门店开通城市")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreOpenCity> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreOpenCity storeOpenCity) {
        return new ResponseMessage(this.storeOpenCityFeign.findByPageForFront(pageNo, pageSize, storeOpenCity));
    }

    /**
     * 添加门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加门店开通城市")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreOpenCity storeOpenCity) {
        return new ResponseMessage(this.storeOpenCityFeign.insert(storeOpenCity));
    }

    /**
     * 删除门店开通城市
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除门店开通城市")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeOpenCityFeign.deleteById(id));
    }

    /**
     * 修改门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑门店开通城市")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreOpenCity storeOpenCity) {
        return new ResponseMessage(this.storeOpenCityFeign.edit(storeOpenCity));
    }

    /**
     * 根据ID查询门店开通城市
     *
     * @param id
     * @returnstoreOpenCity
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询门店开通城市")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreOpenCity> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeOpenCityFeign.queryById(id));
    }
}