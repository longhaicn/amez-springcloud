package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.learn.service.LearnTradeRecodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags = "交易记录表")
@RestController
@RequestMapping(value = "learnTradeRecode")
public class LearnTradeRecodeController {
    @Resource
    private LearnTradeRecodeService learnTradeRecodeService;

    @PostMapping("/1.1.0/front/findByPageV110")
    public PageInfo<LearnTradeRecode> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.findByPageForFront(pageNo, pageSize, learnTradeRecode);
    }

    @PostMapping("/1.1.0/insertV110")
    public int insertV110(@RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.addObj(learnTradeRecode);
    }

    @DeleteMapping("/1.1.0/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.learnTradeRecodeService.deleteObjById(id);
    }

    @PutMapping("/1.1.0/editV110")
    public int editV110(@RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.modifyObj(learnTradeRecode);
    }

    @GetMapping("/1.1.0/queryById/{id}")
    public LearnTradeRecode queryById(@PathVariable(value = "id") int id) {
        return this.learnTradeRecodeService.queryObjById(id);
    }

    @PostMapping("/queryTradeRecode")
    List<LearnTradeRecode> queryTradeRecode(@RequestBody LearnTradeRecode learnTradeRecode){
        return this.learnTradeRecodeService.queryTradeRecode(learnTradeRecode);
    }
}