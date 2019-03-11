package com.union.aimei.app.api.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.umeng.BaseUmengPushTemplateFeign;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Api(tags="U盟第三方推送模板表")
@RestController
@RequestMapping(value="baseUmengPushTemplate")
public class BaseUmengPushTemplateApiController {
       @Resource
       private BaseUmengPushTemplateFeign baseUmengPushTemplateFeign;


       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param baseUmengPushTemplate 查询条件
     * @return ResponseMessage<BaseUmengPushTemplate>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询U盟第三方推送模板表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<BaseUmengPushTemplate> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<BaseUmengPushTemplate> page=baseUmengPushTemplateFeign.findByPageForFront(pageNo, pageSize,baseUmengPushTemplate);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加BaseUmengPushTemplate
        * @param baseUmengPushTemplate
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加U盟第三方推送模板表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseUmengPushTemplateFeign.insert(baseUmengPushTemplate);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除BaseUmengPushTemplate
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除U盟第三方推送模板表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseUmengPushTemplateFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改BaseUmengPushTemplate
        * @param baseUmengPushTemplate
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑U盟第三方推送模板表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseUmengPushTemplateFeign.edit(baseUmengPushTemplate);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询BaseUmengPushTemplate
        * @param id
        * @returnbaseUmengPushTemplate
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询U盟第三方推送模板表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<BaseUmengPushTemplate> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              BaseUmengPushTemplate model=this.baseUmengPushTemplateFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       @ApiOperation(httpMethod="POST", value="批量发送消息(同类型用户调用)")
       @PostMapping("/bg/sendMessageBatch")
       public ResponseMessage sendMessageBatch(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              this.baseUmengPushTemplateFeign.sendMessageBatch(baseUmengPushTemplate);
              return result;
       }

       @ApiOperation(httpMethod="POST", value="批量发送消息(不同类型用户调用)")
       @PostMapping("/bg/sendMessageDiffBatch")
       public ResponseMessage sendMessageDiffBatch(@RequestBody List<BaseUmengPushTemplate> list) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              this.baseUmengPushTemplateFeign.sendMessageDiffBatch(list);
              return result;
       }

       /**
        * 后台测试
        * 后台测试IOS美容师
        * 必填：美容师的deviceToken,美容师的id
        */
       @ApiOperation(httpMethod="POST", value="测试IOS推送(只能美容师端)")
       @PostMapping("/bg/testIOSBeautician")
       public void testIOSBeautician(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              this.baseUmengPushTemplateFeign.testIOSBeautician(baseUmengPushTemplate);
       }

       /**
        * 后台推送模板整体接口
        */
       @ApiOperation(httpMethod="POST", value="后台推送模板整体接口(不支持多条推送)",notes = "参数详细说明查找(PushTemplateCodeVO实体类)")
       @PostMapping("/bg/sendMessage")
       public void sendMessage(@RequestBody BaseUmengPushTemplate baseUmengPushTemplate) {
              this.baseUmengPushTemplateFeign.sendMessage(baseUmengPushTemplate);
       }




}