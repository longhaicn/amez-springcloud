package com.union.aimei.app.api.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.member.MemberCardConstant;
import com.union.aimei.common.feign.app.member.MemberCardFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.MemberCardDetailsVo;
import com.union.aimei.common.vo.member.SubmitMemberCard;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Api(tags = "会员卡")
@RestController
@RequestMapping(value = "memberCard")
public class MemberCardApiController {
    private static final Logger logger = LoggerFactory.getLogger(MemberCardApiController.class);

    @Resource
    private MemberCardFeign memberCardFeign;

    @Resource
    private StoreFeign storeFeign;




    /**
     * 分页查询
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param memberCard 查询条件
     * @return ResponseMessage<MemberCard>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询会员卡")
    @PostMapping("/front/findByPage")
    public PageInfo<MemberCard> findByPageForFront(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize,
            @ApiParam(value = "查询条件")@RequestBody MemberCard memberCard) {

        if(memberCard.getCityId() !=null){
            ResponseMessage<List<Integer>> res = storeFeign.findListByCityId(memberCard.getCityId());
            if(res.getCode() == MemberCardConstant.Request.SUCCESS_STATUS){
                List<Integer> storeIdList = res.getData();
                if(storeIdList.size() > 0 && storeIdList != null){
                    memberCard.setUseCityIdStoreList(storeIdList);
                }
            }
        }
        return memberCardFeign.findByPageForFront(pageNo,pageSize,memberCard);
    }


    @ApiOperation(httpMethod = "POST", value = "添加会员卡")
    @PostMapping("/insertMemberCard")
    public ResponseMessage saveMemberCard(@RequestBody SubmitMemberCard submitMemberCard){
        ResponseMessage responseMessage=new ResponseMessage();
        int result=memberCardFeign.insert(submitMemberCard);
        if(result!=1){
            responseMessage.setCode(ResponseContants.ADD);
            responseMessage.setMessage(ResponseContants.ADD_MESSAGE);
        }
        return responseMessage;
    }

    /**
     * 删除MemberCard
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除会员卡")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberCardFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改MemberCard
     *
     * @param memberCard
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑会员卡")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody MemberCard memberCard) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberCardFeign.edit(memberCard);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询MemberCard
     *
     * @param id
     * @returnmemberCard
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询会员卡")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<MemberCard> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        MemberCard model = this.memberCardFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }



    /**
     * 根据会员id和经纬度查询会员卡详情
     * @param memberCardDetailsVo
     * @returnmemberCard
     */
    @ApiOperation(httpMethod="POST", value="根据会员id和经纬度查询会员卡详情")
    @PostMapping("/queryDetailsById")
    public ResponseMessage queryDetailsById(@RequestBody MemberCardDetailsVo memberCardDetailsVo){
        return this.memberCardFeign.queryDetailsById(memberCardDetailsVo);
    }




}