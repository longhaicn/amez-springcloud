package com.union.aimei.pc.api.umeng;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.umeng.BaseMemberDeviceFeign;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
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
 */
@Api(tags="会员设备码表")
@RestController
@RequestMapping(value="baseMemberDevice")
public class BaseMemberDeviceApiController {
       @Resource
       private BaseMemberDeviceFeign baseMemberDeviceFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param baseMemberDevice 查询条件
     * @return ResponseMessage<BaseMemberDevice>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员设备码表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<BaseMemberDevice> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BaseMemberDevice baseMemberDevice) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<BaseMemberDevice> page=baseMemberDeviceFeign.findByPageForFront(pageNo, pageSize,baseMemberDevice);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加BaseMemberDevice
        * @param baseMemberDevice
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员设备码表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody BaseMemberDevice baseMemberDevice) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseMemberDeviceFeign.insert(baseMemberDevice);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除BaseMemberDevice
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员设备码表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseMemberDeviceFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改BaseMemberDevice
        * @param baseMemberDevice
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员设备码表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody BaseMemberDevice baseMemberDevice) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.baseMemberDeviceFeign.edit(baseMemberDevice);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询BaseMemberDevice
        * @param id
        * @returnbaseMemberDevice
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员设备码表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<BaseMemberDevice> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              BaseMemberDevice model=this.baseMemberDeviceFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}