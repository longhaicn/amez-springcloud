package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberLevelUpgradeFeign;
import com.union.aimei.common.model.member.MemberLevelUpgrade;
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
@Api(tags="会员成长值规则设置")
@RestController
@RequestMapping(value="memberLevelUpgrade")
public class MemberLevelUpgradeApiController {
       @Resource
       private MemberLevelUpgradeFeign memberLevelUpgradeFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberLevelUpgrade 查询条件
     * @return ResponseMessage<MemberLevelUpgrade>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员成长值规则设置")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberLevelUpgrade> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberLevelUpgrade memberLevelUpgrade) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberLevelUpgrade> page=memberLevelUpgradeFeign.findByPageForFront(pageNo, pageSize,memberLevelUpgrade);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberLevelUpgrade
        * @param memberLevelUpgrade
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员成长值规则设置")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberLevelUpgrade memberLevelUpgrade) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberLevelUpgradeFeign.insert(memberLevelUpgrade);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberLevelUpgrade
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员成长值规则设置")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberLevelUpgradeFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberLevelUpgrade
        * @param memberLevelUpgrade
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员成长值规则设置")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberLevelUpgrade memberLevelUpgrade) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberLevelUpgradeFeign.edit(memberLevelUpgrade);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberLevelUpgrade
        * @param id
        * @returnmemberLevelUpgrade
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员成长值规则设置")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberLevelUpgrade> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberLevelUpgrade model=this.memberLevelUpgradeFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}