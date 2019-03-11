package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.vo.learn.app.TradeRecodeCallBackVo;
import com.union.aimei.learn.service.LearnTradeRecodeService;
import com.union.common.utils.ResponseMessage;
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

    @PostMapping("/front/findByPage")
    public PageInfo<LearnTradeRecode> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.findByPageForFront(pageNo, pageSize, learnTradeRecode);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.addObj(learnTradeRecode);
    }

    @PostMapping("/addObj")
    public ResponseMessage<LearnTradeRecode> addObj(@RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.insert(learnTradeRecode);
    }


    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.learnTradeRecodeService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeService.modifyObj(learnTradeRecode);
    }

    @GetMapping("/queryById/{id}")
    public LearnTradeRecode queryById(@PathVariable(value = "id") int id) {
        return this.learnTradeRecodeService.queryObjById(id);
    }

    @PostMapping("/queryTradeRecode")
    List<LearnTradeRecode> queryTradeRecode(@RequestBody LearnTradeRecode learnTradeRecode){
        return this.learnTradeRecodeService.queryTradeRecode(learnTradeRecode);
    }

    @GetMapping("/queryTradeRecodeByOrderNo/{orderNo}")
    ResponseMessage<LearnTradeRecode> queryTradeRecodeByOrderNo(@PathVariable(value = "orderNo") String orderNo){
        return this.learnTradeRecodeService.queryTradeRecodeByOrderNo(orderNo);
    }

    /**
     *交易回掉接口
     * @param tradeRecodeBackVo
     * @return
     */
    @PostMapping("/tradeRecodeCallBack")
    ResponseMessage tradeRecodeCallBack(@RequestBody TradeRecodeCallBackVo tradeRecodeBackVo){
        return this.learnTradeRecodeService.tradeRecodeCallBack(tradeRecodeBackVo);
    }
}