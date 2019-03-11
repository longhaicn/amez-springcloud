package com.union.aimei.store.controller;

import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.store.service.StoreLevelService;
import com.union.aimei.common.vo.store.app.StoreLevelVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 15:50
 */
@Api(tags = "门店级别", description = "api")
@RestController
@RequestMapping(value = "storeLevel")
public class StoreLevelController {
    @Resource
    private StoreLevelService storeLevelService;

    /**
     * 新增门店级别
     *
     * @param storeLevelVo 门店级别vo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增门店级别")
    @PostMapping("/add")
    public ResponseMessage add(@RequestBody StoreLevelVo storeLevelVo) {
        return this.storeLevelService.add(storeLevelVo);
    }

    /**
     * 查询门店级别
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询门店级别")
    @GetMapping("/findList")
    public ResponseMessage<List<StoreLevel>> findList() {
        return this.storeLevelService.findList();
    }
}