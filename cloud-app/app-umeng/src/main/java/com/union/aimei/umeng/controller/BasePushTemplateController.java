package com.union.aimei.umeng.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.umeng.service.BasePushTemplateService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="友盟推送消息模板(新)")
@RestController
@RequestMapping(value="basePushTemplate")
public class BasePushTemplateController {
       @Resource
       private BasePushTemplateService basePushTemplateService;

       @PostMapping("/front/findByPage")
       public PageInfo<BasePushTemplate> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BasePushTemplate basePushTemplate) {
              return this.basePushTemplateService.findByPageForFront(pageNo,pageSize,basePushTemplate);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody BasePushTemplate basePushTemplate) {
              return this.basePushTemplateService.addObj(basePushTemplate);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.basePushTemplateService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody BasePushTemplate basePushTemplate) {
              return this.basePushTemplateService.modifyObj(basePushTemplate);
       }

       @GetMapping("/queryById/{id}")
       public BasePushTemplate queryById(@PathVariable (value="id") int id) {
              return this.basePushTemplateService.queryObjById(id);
       }

       @PostMapping(value="/findByBasePushTemplate")
       List<BasePushTemplate> findByBasePushTemplate(@RequestBody BasePushTemplate basePushTemplate){
              return this.basePushTemplateService.findByBasePushTemplate(basePushTemplate);
       }

       /*@PostMapping(value="/sendMessage")
       public ResponseMessage sendMessage(@RequestBody SendMsgParamVo sendMsgParamVo){
              return this.basePushTemplateService.sendMessage(sendMsgParamVo);
       }*/

       @PostMapping(value="/sendMessage")
       public ResponseMessage sendMessage(@RequestBody List<SendMsgParamVo> sendMsgParamVo){
              return this.basePushTemplateService.sendMessage(sendMsgParamVo);
       }
}