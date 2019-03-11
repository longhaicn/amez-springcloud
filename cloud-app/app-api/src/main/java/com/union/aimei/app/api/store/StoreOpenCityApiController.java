package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreOpenCityFeign;
import com.union.aimei.common.model.store.StoreOpenCity;
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
 * @time 2018/1/13 14:07
 */
@Api(tags = "门店开通城市")
@RestController
@RequestMapping(value = "storeOpenCity")
public class StoreOpenCityApiController {
    @Resource
    private StoreOpenCityFeign storeOpenCityFeign;

    /**
     * 分页查询门店开通城市
     *
     * @param pageNo        分页索引
     * @param pageSize      每页数量
     * @param storeOpenCity 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询门店开通城市")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreOpenCity>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       @ApiParam(value = "查询条件") @RequestBody StoreOpenCity storeOpenCity) {
        return new ResponseMessage<>(this.storeOpenCityFeign.findByPageForFront(pageNo, pageSize, storeOpenCity));
    }

    /**
     * 查询所有门店开通城市
     *
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询所有门店开通城市")
    @PostMapping("/listAll")
    public ResponseMessage<List<StoreOpenCity>> listAll() {
        return this.storeOpenCityFeign.listAll();
    }

}