package com.union.aimei.umeng.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.aimei.umeng.service.BaseUmengPushTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="U盟第三方推送模板表")
@RestController
@RequestMapping(value="baseUmengPushTemplate")
public class BaseUmengPushTemplateController {
       @Resource
       private BaseUmengPushTemplateService baseUmengPushTemplateService;

       @PostMapping("/front/findByPage")
       public PageInfo<BaseUmengPushTemplate> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              return this.baseUmengPushTemplateService.findByPageForFront(pageNo,pageSize,baseUmengPushTemplate);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              return this.baseUmengPushTemplateService.addObj(baseUmengPushTemplate);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.baseUmengPushTemplateService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              return this.baseUmengPushTemplateService.modifyObj(baseUmengPushTemplate);
       }

       @GetMapping("/queryById/{id}")
       public BaseUmengPushTemplate queryById(@PathVariable (value="id") int id) {
              return this.baseUmengPushTemplateService.queryObjById(id);
       }

       @PostMapping("/bg/testIOSBeautician")
       public void testIOSBeautician(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              this.baseUmengPushTemplateService.testIOSBeautician(baseUmengPushTemplate);
       }

       @PostMapping("/bg/sendMessage")
       public void sendMessage(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              this.baseUmengPushTemplateService.sendMessage(baseUmengPushTemplate);
       }

       @PostMapping("/bg/sendMessageBatch")
       public void sendMessageBatch(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              this.baseUmengPushTemplateService.sendMessageBatch(baseUmengPushTemplate);
       }

       @PostMapping("/bg/sendMessageDiffBatch")
       public void sendMessageDiffBatch(@RequestBody List<BaseUmengPushTemplate> list){
              this.baseUmengPushTemplateService.sendMessageDiffBatch(list);
       }


}