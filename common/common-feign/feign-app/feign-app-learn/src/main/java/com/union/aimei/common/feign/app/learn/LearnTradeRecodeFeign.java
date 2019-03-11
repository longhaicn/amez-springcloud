package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.LearnTradeRecodeApiHystrix;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.vo.learn.app.TradeRecodeCallBackVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId = "APP-LEARN-SERVICE", fallback = LearnTradeRecodeApiHystrix.class)
public interface LearnTradeRecodeFeign {
    /**
     * 添加交易记录表
     *
     * @param learnTradeRecode
     * @return
     */
    @PostMapping(value = "/learnTradeRecode/insert")
    int insert(@RequestBody LearnTradeRecode learnTradeRecode);


    /**
     * 添加交易记录(活动或者课程)
     * @param learnTradeRecode
     * @return
     */
    @PostMapping(value = "/learnTradeRecode/addObj")
    ResponseMessage<LearnTradeRecode> addObj(@RequestBody LearnTradeRecode learnTradeRecode);

    /**
     * 删除交易记录表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/learnTradeRecode/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改交易记录表
     *
     * @param learnTradeRecode
     * @return
     */
    @PutMapping(value = "/learnTradeRecode/edit")
    int edit(@RequestBody LearnTradeRecode learnTradeRecode);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnTradeRecode
     */
    @GetMapping(value = "/learnTradeRecode/queryById/{id}")
    LearnTradeRecode queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询交易记录表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param learnTradeRecode 查询条件
     * @return
     */
    @PostMapping(value = "/learnTradeRecode/front/findByPage")
    PageInfo<LearnTradeRecode> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                          Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                          Integer pageSize, @RequestBody LearnTradeRecode learnTradeRecode);

    /**
     *根据属性查询交易记录
     * @param learnTradeRecode
     * @return
     */
    @PostMapping("/learnTradeRecode/queryTradeRecode")
    List<LearnTradeRecode> queryTradeRecode(@RequestBody LearnTradeRecode learnTradeRecode);

    /**
     *根据订单编号查询交易记录
     * @param orderNo
     * @return
     */
    @GetMapping("/learnTradeRecode/queryTradeRecodeByOrderNo/{orderNo}")
    ResponseMessage<LearnTradeRecode> queryTradeRecodeByOrderNo(@PathVariable(value = "orderNo") String orderNo);

    /**
     *交易回掉接口
     * @param tradeRecodeCallBackVo
     * @return
     */
    @PostMapping("/learnTradeRecode/tradeRecodeCallBack")
    ResponseMessage tradeRecodeCallBack(@RequestBody TradeRecodeCallBackVo tradeRecodeCallBackVo);

}