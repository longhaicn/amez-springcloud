package com.union.aimei.umeng.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.aimei.umeng.service.BaseMemberDeviceService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员设备码表")
@RestController
@RequestMapping(value="baseMemberDevice")
public class BaseMemberDeviceController {
       @Resource
       private BaseMemberDeviceService baseMemberDeviceService;

       @PostMapping("/front/findByPage")
       public PageInfo<BaseMemberDevice> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody BaseMemberDevice baseMemberDevice) {
              return this.baseMemberDeviceService.findByPageForFront(pageNo,pageSize,baseMemberDevice);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody BaseMemberDevice baseMemberDevice) {
              return this.baseMemberDeviceService.addObj(baseMemberDevice);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.baseMemberDeviceService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody BaseMemberDevice baseMemberDevice) {
              return this.baseMemberDeviceService.modifyObj(baseMemberDevice);
       }

       @GetMapping("/queryById/{id}")
       public BaseMemberDevice queryById(@PathVariable (value="id") int id) {
              return this.baseMemberDeviceService.queryObjById(id);
       }

       /**
        * 根据设备参数查询设备信息
        * @param baseMemberDevice
        * @return
        */
       @PostMapping("/queryByInfo")
       public ResponseMessage queryByInfo(@RequestBody BaseMemberDevice baseMemberDevice) {
              return this.baseMemberDeviceService.queryByInfo(baseMemberDevice);
       }
}