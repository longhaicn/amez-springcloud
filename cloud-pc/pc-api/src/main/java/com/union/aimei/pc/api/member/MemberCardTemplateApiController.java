package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardTemplateFeign;
import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.aimei.common.vo.member.MemberCardTemplateVo;
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
@Api(tags="会员卡卡面模板表")
@RestController
@RequestMapping(value="memberCardTemplate")
public class MemberCardTemplateApiController {
       @Resource
       private MemberCardTemplateFeign memberCardTemplateFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardTemplate 查询条件
     * @return ResponseMessage<MemberCardTemplate>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员卡卡面模板表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberCardTemplate> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCardTemplate memberCardTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCardTemplate> page=memberCardTemplateFeign.findByPageForFront(pageNo, pageSize,memberCardTemplate);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberCardTemplate
        * @param memberCardTemplate
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员卡卡面模板表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberCardTemplate memberCardTemplate) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardTemplateFeign.insert(memberCardTemplate);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberCardTemplate
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员卡卡面模板表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardTemplateFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberCardTemplate
        * @param memberCardTemplateVo
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡卡面模板表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberCardTemplateVo memberCardTemplateVo) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              //如果ParentGroupId为空或者0，则是编辑主题
              if(memberCardTemplateVo.getParentGroupId() == null || memberCardTemplateVo.getParentGroupId() ==0){
                     MemberCardTemplate memberCardTemplate = new MemberCardTemplate();
                     memberCardTemplate.setId(memberCardTemplateVo.getId());
                     memberCardTemplate.setParentGroupCount(memberCardTemplateVo.getParentGroupCount());
                     memberCardTemplate.setParentGroupName(memberCardTemplateVo.getParentGroupName());
                     memberCardTemplate.setBgImgUrl(memberCardTemplateVo.getBgImgUrl());
                     memberCardTemplate.setIsEnabled(memberCardTemplateVo.getIsEnabled());
                     memberCardTemplate.setCreateTime(memberCardTemplateVo.getCreateTime());
                     memberCardTemplate.setUpdateTime(memberCardTemplateVo.getUpdateTime());
                     int res=this.memberCardTemplateFeign.edit(memberCardTemplate);
                     AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              }else{
                     //编辑主题下的图片
                     this.memberCardTemplateFeign.deleteByGroupId(memberCardTemplateVo.getParentGroupId());
                     this.memberCardTemplateFeign.insertByBatch(memberCardTemplateVo);
                     result.setCode(200);
                     result.setMessage("修改成功");
              }
              return result;
       }

       /**
        * 根据ID查询MemberCardTemplate
        * @param id
        * @returnmemberCardTemplate
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员卡卡面模板表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberCardTemplate> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCardTemplate model=this.memberCardTemplateFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 批量添加会员卡卡面模板表
        * @param memberCardTemplateVo
        * @return
        */
       @ApiOperation(httpMethod="POST", value="批量添加会员卡卡面模板表")
       @PostMapping("/insertByBatch")
       public ResponseMessage insertByBatch(@RequestBody MemberCardTemplateVo memberCardTemplateVo) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              this.memberCardTemplateFeign.insertByBatch(memberCardTemplateVo);
              return result;
       }

}