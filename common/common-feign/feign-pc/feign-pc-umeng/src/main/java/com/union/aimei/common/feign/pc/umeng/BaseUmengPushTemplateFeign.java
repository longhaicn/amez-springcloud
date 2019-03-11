package com.union.aimei.common.feign.pc.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.umeng.hystrix.BaseUmengPushTemplateApiHystrix;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId="pc-umeng-service",fallback=BaseUmengPushTemplateApiHystrix.class)
public interface BaseUmengPushTemplateFeign {
       /**
        * 添加U盟第三方推送记录表
        * @param baseUmengPushTemplate
        * @return
        */
       @PostMapping(value="/baseUmengPushTemplate/insert")
       int insert(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

       /**
        * 删除U盟第三方推送记录表
        * @param id
        * @return
        */
       @DeleteMapping(value="/baseUmengPushTemplate/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改U盟第三方推送记录表
        * @param baseUmengPushTemplate
        * @return
        */
       @PutMapping(value="/baseUmengPushTemplate/edit")
       int edit(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

       /**
        * 根据ID查询
        * @param id
        * @returnbaseUmengPushTemplate
        */
       @GetMapping(value="/baseUmengPushTemplate/queryById/{id}")
       BaseUmengPushTemplate queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询U盟第三方推送记录表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param baseUmengPushTemplate 查询条件
     * @return
     */
       @PostMapping(value="/baseUmengPushTemplate/front/findByPage")
       PageInfo<BaseUmengPushTemplate> findByPageForFront(
               @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
               @RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

       /**
        * 友盟推送消息接口
        * @param baseUmengPushTemplate
        */
       @PostMapping("/baseUmengPushTemplate/bg/sendMessage")
       public void sendMessage(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);


       /**
        * 友盟推送消息接口
        * @param baseUmengPushTemplate
        */
       @PostMapping("/baseUmengPushTemplate/bg/sendMessageBatch")
       public void sendMessageBatch(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

       /**
        * 不同类型用户批量推送消息
        * @param list
        */
       @PostMapping("/baseUmengPushTemplate/bg/sendMessageDiffBatch")
       public void sendMessageDiffBatch(@RequestBody List<BaseUmengPushTemplate> list);

       /**
        * 测试IOS推送美容师
        * @param baseUmengPushTemplate
        */
       @PostMapping("/baseUmengPushTemplate/bg/testIOSBeautician")
       public void testIOSBeautician(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate);

}