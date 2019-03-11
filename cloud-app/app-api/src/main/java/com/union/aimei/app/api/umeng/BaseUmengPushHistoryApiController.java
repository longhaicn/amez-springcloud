package com.union.aimei.app.api.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.umeng.BaseUmengPushHistoryFeign;
import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.aimei.common.vo.umeng.UmengPushCategory;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Api(tags="友盟消息推送记录表")
@RestController
@RequestMapping(value="baseUmengPushHistory")
public class BaseUmengPushHistoryApiController {
       @Resource
       private BaseUmengPushHistoryFeign baseUmengPushHistoryFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param baseUmengPushHistory 查询条件
     * @return ResponseMessage<BaseUmengPushHistory>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询友盟消息推送记录表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<BaseUmengPushHistory> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BaseUmengPushHistory baseUmengPushHistory) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<BaseUmengPushHistory> page=baseUmengPushHistoryFeign.findByPageForFront(pageNo, pageSize,baseUmengPushHistory);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加BaseUmengPushHistory
        * @param baseUmengPushHistory
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加友盟消息推送记录表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody BaseUmengPushHistory baseUmengPushHistory) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseUmengPushHistoryFeign.insert(baseUmengPushHistory);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除BaseUmengPushHistory
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除友盟消息推送记录表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseUmengPushHistoryFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改BaseUmengPushHistory
        * @param baseUmengPushHistory
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑友盟消息推送记录表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody BaseUmengPushHistory baseUmengPushHistory) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseUmengPushHistoryFeign.edit(baseUmengPushHistory);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询BaseUmengPushHistory
        * @param id
        * @returnbaseUmengPushHistory
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询友盟消息推送记录表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<BaseUmengPushHistory> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              BaseUmengPushHistory model=this.baseUmengPushHistoryFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

    /**
     * 获取所有未读消息分类列表
     * @param umengPushCategory
     * @return
     */
    @ApiOperation(httpMethod="POST", value="手机app端获取所有类型得消息")
       @PostMapping("/front/findCategoryList")
       public ResponseMessage findCategoryList(@RequestBody UmengPushCategory umengPushCategory) {
           return this.baseUmengPushHistoryFeign.findCategoryList(umengPushCategory);
    }
}