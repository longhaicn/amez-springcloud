package com.union.aimei.pc.api.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.BeauticianGrowthRuleEnum;
import com.union.aimei.common.feign.pc.member.MemberRealNameAuthFeign;
import com.union.aimei.common.feign.pc.store.GrowthRuleFeign;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author houji
 */
@Api(tags = "会员卡实名认证表")
@RestController
@RequestMapping(value = "memberRealNameAuth")
public class MemberRealNameAuthApiController {
    @Resource
    private MemberRealNameAuthFeign memberRealNameAuthFeign;

    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;

    @Resource
    private GrowthRuleFeign growthRuleFeign;

    /**
     * 分页查询
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberRealNameAuth 查询条件
     * @return ResponseMessage<MemberRealNameAuth>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询会员卡实名认证表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<MemberRealNameAuth> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                          Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                          Integer pageSize, @ApiParam(value = "查询条件") @RequestBody MemberRealNameAuth memberRealNameAuth) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<MemberRealNameAuth> page = memberRealNameAuthFeign.findByPageForFront(pageNo, pageSize, memberRealNameAuth);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 分页查询
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberRealNameAuth 查询条件
     * @return ResponseMessage<MemberRealNameAuth>
     */
    @ApiOperation(httpMethod = "POST", value = "后台分页查询会员卡实名认证表展示不操作")
    @PostMapping("/bg/findByPageForBg")
    public ResponseMessage<MemberRealNameAuth> findByPageForBg(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam(value = "查询条件") @RequestBody MemberRealNameAuth memberRealNameAuth) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<MemberRealNameAuth> page = memberRealNameAuthFeign.findByPageForFront(pageNo, pageSize, memberRealNameAuth);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加MemberRealNameAuth
     *
     * @param memberRealNameAuth
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加会员卡实名认证表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody MemberRealNameAuth memberRealNameAuth) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberRealNameAuthFeign.insert(memberRealNameAuth);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除MemberRealNameAuth
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除会员卡实名认证表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberRealNameAuthFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改MemberRealNameAuth
     *
     * @param memberRealNameAuth
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑会员卡实名认证表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody MemberRealNameAuth memberRealNameAuth) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberRealNameAuthFeign.edit(memberRealNameAuth);
        //当会员实名认证审核通过，修改店铺美容师实名认证状态
        if (memberRealNameAuth.getAuditStatus().equals(MemberRealNameAuth.AuditStatus.PASS_AUDIT) || memberRealNameAuth.getAuditStatus().equals(MemberRealNameAuth.AuditStatus.NOT_PASS_AUDIT)) {
            memberRealNameAuth = this.memberRealNameAuthFeign.queryById(memberRealNameAuth.getId());
            ResponseMessage<StoreBeautician> sbMsg = this.storeBeauticianFeign.findByMemberId(memberRealNameAuth.getMemberId());
            ResponseUtil.isFailThrowException(sbMsg);
            StoreBeautician upSb = new StoreBeautician();
            upSb.setId(sbMsg.getData().getId());
            if (memberRealNameAuth.getAuditStatus().equals(MemberRealNameAuth.AuditStatus.PASS_AUDIT)) {
                upSb.setRealNameStatus(StoreBeautician.RealNameStatus.PASS);
                upSb.setAuditStatus(StoreBeautician.AuditStatus.PASS);
            } else if (memberRealNameAuth.getAuditStatus().equals(MemberRealNameAuth.AuditStatus.NOT_PASS_AUDIT)) {
                upSb.setRealNameStatus(StoreBeautician.RealNameStatus.NOT_PASS);
                upSb.setAuditStatus(StoreBeautician.AuditStatus.NOT_PASS);
            }
            upSb.setBeauticianName(memberRealNameAuth.getRealName());
            ResponseMessage resUpSb = this.storeBeauticianFeign.modify(upSb);
            //美容师实名认证审核通过，后台添加成长值
            if (memberRealNameAuth.getAuditStatus() == 1) {
                ResponseUtil.isFailThrowException(resUpSb);
                GrowthRuleVo growthRuleVo = new GrowthRuleVo();
                growthRuleVo.setCode(BeauticianGrowthRuleEnum.VERIFIED.getCode());
                growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.BEAUTICIAN);
                growthRuleVo.setSourceId(upSb.getId());
                this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
            }
        }
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询MemberRealNameAuth
     *
     * @param id
     * @returnmemberRealNameAuth
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询会员卡实名认证表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<MemberRealNameAuth> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        MemberRealNameAuth model = this.memberRealNameAuthFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}