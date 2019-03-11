package com.union.aimei.common.feign.pc.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.umeng.hystrix.BasePushTemplateApiHystrix;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dell
 */
@FeignClient(serviceId="pc-umeng-service",fallback=BasePushTemplateApiHystrix.class)
public interface BasePushTemplateFeign {
       /**
        * 添加友盟推送消息模板(新)
        * @param basePushTemplate
        * @return
        */
       @PostMapping(value="/basePushTemplate/insert")
       int insert(@RequestBody BasePushTemplate basePushTemplate);

       /**
        * 删除友盟推送消息模板(新)
        * @param id
        * @return
        */
       @DeleteMapping(value="/basePushTemplate/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改友盟推送消息模板(新)
        * @param basePushTemplate
        * @return
        */
       @PutMapping(value="/basePushTemplate/edit")
       int edit(@RequestBody BasePushTemplate basePushTemplate);

       /**
        * 根据ID查询
        * @param id
        * @returnbasePushTemplate
        */
       @GetMapping(value="/basePushTemplate/queryById/{id}")
       BasePushTemplate queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询友盟推送消息模板(新)
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param basePushTemplate 查询条件
     * @return
     */
       @PostMapping(value="/basePushTemplate/front/findByPage")
       PageInfo<BasePushTemplate> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                             Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                             Integer pageSize, @RequestBody BasePushTemplate basePushTemplate);


       /**
        * 消息推送多条
        * @param sendMsgParamVo
        * @return
        */
       @PostMapping(value="/basePushTemplate/sendMessage")
       ResponseMessage sendMessage(@RequestBody List<SendMsgParamVo> sendMsgParamVo);

       /**
        * 测试umeng通知推送
        * @param role
        * @param token
        * @param deviceType
        * @return
        */
       @GetMapping("/basePushTemplate/test/sendNotificat/{token}/{role}/{deviceType}")
       public ResponseMessage testNotificat(
               @PathVariable(value = "role") Integer role,
               @PathVariable(value = "token") String token,
               @PathVariable(value = "deviceType") Integer deviceType);
}