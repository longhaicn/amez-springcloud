package com.union.aimei.app.api.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
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
@Api(tags="友盟推送消息模板(新)")
@RestController
@RequestMapping(value="basePushTemplate")
public class BasePushTemplateApiController {
       @Resource
       private BasePushTemplateFeign basePushTemplateFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param basePushTemplate 查询条件
     * @return ResponseMessage<BasePushTemplate>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询友盟推送消息模板(新)")
       @PostMapping("/front/findByPage")
       public ResponseMessage<BasePushTemplate> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BasePushTemplate basePushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<BasePushTemplate> page=basePushTemplateFeign.findByPageForFront(pageNo, pageSize,basePushTemplate);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加BasePushTemplate
        * @param basePushTemplate
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加友盟推送消息模板(新)")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody BasePushTemplate basePushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.basePushTemplateFeign.insert(basePushTemplate);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除BasePushTemplate
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除友盟推送消息模板(新)")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.basePushTemplateFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改BasePushTemplate
        * @param basePushTemplate
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑友盟推送消息模板(新)")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody BasePushTemplate basePushTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.basePushTemplateFeign.edit(basePushTemplate);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询BasePushTemplate
        * @param id
        * @returnbasePushTemplate
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询友盟推送消息模板(新)")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<BasePushTemplate> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              BasePushTemplate model=this.basePushTemplateFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 后台推送模板整体接口
        */
       @ApiOperation(httpMethod="POST", value="后台推送消息整体接口")
       @PostMapping("/bg/sendMessage")
       public ResponseMessage sendMessage(@RequestBody List<SendMsgParamVo> sendMsgParamVoList) {
              return this.basePushTemplateFeign.sendMessage(sendMsgParamVoList);
       }
}