package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.vo.member.IDNumberAuthVo;
import com.union.aimei.member.service.MemberRealNameAuthService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="会员卡实名认证表")
@RestController
@RequestMapping(value="memberRealNameAuth")
public class MemberRealNameAuthController {
       @Resource
       private MemberRealNameAuthService memberRealNameAuthService;

       @PostMapping("/front/findByPage")
       public PageInfo<MemberRealNameAuth> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.findByPageForFront(pageNo,pageSize,memberRealNameAuth);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.addObj(memberRealNameAuth);
       }

       @PostMapping(value="/addObj")
       public ResponseMessage addObj(@RequestBody MemberRealNameAuth memberRealNameAuth){
              return this.memberRealNameAuthService.insert(memberRealNameAuth);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.memberRealNameAuthService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.modifyObj(memberRealNameAuth);
       }

       @GetMapping("/queryById/{id}")
       public MemberRealNameAuth queryById(@PathVariable (value="id") int id) {
              return this.memberRealNameAuthService.queryObjById(id);
       }

       @PostMapping("/queryByMemberId")
       public MemberRealNameAuth queryByMemberId(@RequestBody MemberRealNameAuth memberRealNameAuth) {
              return this.memberRealNameAuthService.queryByMemberId(memberRealNameAuth);
       }
       //后台做个限制:
       //实名认证每个账号每天最多可以实名认证5次,
       //每个用户最多实名认证10次,
       //添加银行卡每人最多添加3张银行卡,
       //每个人每天最多可以调用10次这个接口,
       //每个用户最多30次这个接口

       @ApiOperation(httpMethod="POST", value="会员(美容师)提现第三方实名认证")
       @PostMapping("/authIDNumber")
       public int authIDNumber(@RequestBody IDNumberAuthVo idNumberAuthVo) {
              return this.memberRealNameAuthService.authIDNumber(idNumberAuthVo);
       }


}