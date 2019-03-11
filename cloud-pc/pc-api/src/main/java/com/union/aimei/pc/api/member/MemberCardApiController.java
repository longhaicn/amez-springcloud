package com.union.aimei.pc.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardFeign;
import com.union.aimei.common.feign.pc.member.MemberFeign;
import com.union.aimei.common.feign.pc.product.ProductStoreRefFeign;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.EditMemberCardVo;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.ReleaseMemberCardVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByStoreIdListVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houji
 */
@Api(tags="会员卡")
@RestController
@RequestMapping(value="memberCard")
public class MemberCardApiController {
       @Resource
       private MemberCardFeign memberCardFeign;
       @Resource
       private ProductStoreRefFeign productStoreRefFeign;
       @Resource
       private MemberFeign memberFeign;
       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCard 查询条件
     * @return ResponseMessage<MemberCard>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员卡")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberCard> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberCard memberCard) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberCard> page=memberCardFeign.findByPageForFront(pageNo, pageSize,memberCard);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 发布会员卡
        * @param releaseMemberCardVo
        * @return
        */
       @ApiOperation(httpMethod="POST", value="发布会员卡")
       @PostMapping("/releaseMemberCard")
       public ResponseMessage releaseMemberCard(@RequestBody ReleaseMemberCardVo releaseMemberCardVo){
              //boolean值时用1代表TRUE，0代表FALSE
              //品牌连锁
              if(!releaseMemberCardVo.getIssueType()){
                     List<Integer> storeIdList = releaseMemberCardVo.getUseAbleStoreList();
                     ProductStoreRefByStoreIdListVo listVo = new ProductStoreRefByStoreIdListVo();
                     listVo.setStoreIdList(storeIdList);
                     List<Integer> list = this.productStoreRefFeign.findByStoreIdList(listVo);
                     if(!CollectionUtils.isEmpty(list)){
                            releaseMemberCardVo.setUseAbleProductList(list);
                     }
              }
              return memberCardFeign.releaseMemberCard(releaseMemberCardVo);
       }
       /**
        * 删除MemberCard
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员卡")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberCard
        * @param memberCard
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡基本信息")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberCard memberCard) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberCardFeign.edit(memberCard);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }


       /**
        * 修改会员卡信息，包含会员卡基本信息、使用门店范围、适用服务
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员卡详情(包含门店使用范围和适用服务)")
       @PutMapping(value = "/editMemberCardInfo")
       public ResponseMessage editMemberCardInfo(@RequestBody EditMemberCardVo editMemberCardVo){
              return memberCardFeign.editMemberCardInfo(editMemberCardVo);
       }


       /**
        * 根据ID查询MemberCard
        * @param id
        * @returnmemberCard
        */
       @ApiOperation(httpMethod="GET", value="查询会员卡基本信息")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberCard> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberCard model=this.memberCardFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 根据ID查询MemberCard
        * @param id
        * @returnmemberCard
        */
       @ApiOperation(httpMethod="GET", value="查询会员卡详情")
       @GetMapping("/queryCardDetails/{id}")
       public ResponseMessage queryCardDetails(@PathVariable (value="id") int id){
              ResponseMessage result = this.memberCardFeign.queryMemberCardDetail(id);
              return result;
       }

       /**
        * 查询会员和会员卡新增统计
        */
       @ApiOperation(httpMethod="POST", value="根据时间段查询会员和会员卡新增统计")
       @PostMapping("/queryMemberAndMemberCardCount")
       public ResponseMessage queryMemberAndMemberCardCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo){
              ResponseMessage res=ResponseMessageFactory.newInstance();
              Integer  memberCardCount = memberCardFeign.queryMemberCardCount(memberAndMemberCardVo);
              Integer  memberCount = memberFeign.queryMemberCount(memberAndMemberCardVo);
              Map<String,Integer> map = new HashMap(2);
              map.put("memberCardCount",memberCardCount);
              map.put("memberCount",memberCount);
              res.setData(map);
              return res;
       }


}