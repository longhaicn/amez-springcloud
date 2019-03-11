package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.MemberCardDetailsVo;
import com.union.aimei.common.vo.member.SubmitMemberCard;
import com.union.aimei.member.service.MemberCardService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags = "会员卡")
@RestController
@RequestMapping(value = "memberCard")
public class MemberCardController {
    @Resource
    private MemberCardService memberCardService;


    @PostMapping("/front/findByPage")
    public PageInfo<MemberCard> findByPageForFront(
            @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value = "pageNo",defaultValue="0")Integer pageNo,
            @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value = "pageSize",defaultValue="10")Integer pageSize,
            @ApiParam(value="查询条件") @RequestBody MemberCard memberCard) {
        return this.memberCardService.findByPageForFront(pageNo,pageSize,memberCard);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody SubmitMemberCard submitMemberCard) {
        return memberCardService.insert(submitMemberCard);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.memberCardService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody MemberCard memberCard) {
        return this.memberCardService.modifyObj(memberCard);
    }

    @GetMapping("/queryById/{id}")
    public MemberCard queryById(@PathVariable(value = "id") int id) {
        return this.memberCardService.queryObjById(id);
    }


   @GetMapping(value = "queryDetailsByMemAndCardId")
   public ResponseMessage queryDetailsByCardId(@RequestParam(value = "memberId") Integer memberId,
                                               @RequestParam(value = "cardId") Integer cardId){
         return memberCardService.queryDetailsByCardId(memberId,cardId);
   }

    @GetMapping("/queryDetailById/{id}")
    public ResponseMessage queryDetailById(@PathVariable(value = "id") int id) {
        return this.memberCardService.queryDetailById(id);
    }

    @PostMapping("/queryDetailsById")
    public ResponseMessage queryDetailsById(@RequestBody MemberCardDetailsVo memberCardDetailsVo){
        return this.memberCardService.queryDetailsById(memberCardDetailsVo);
    }


}