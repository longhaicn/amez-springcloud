package com.union.aimei.common.feign.app.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberCardRefApiHystrix;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,11:04
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberCardRefApiHystrix.class)
public interface MemberCardRefFeign {
    /**
     * 添加用户会员卡表
     *
     * @param memberCardRef
     * @return
     */
    @PostMapping(value = "/memberCardRef/insert")
    int insert(@RequestBody MemberCardRef memberCardRef);

    /**
     * 删除用户会员卡表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/memberCardRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改用户会员卡表
     *
     * @param memberCardRef
     * @return
     */
    @PutMapping(value = "/memberCardRef/edit")
    int edit(@RequestBody MemberCardRef memberCardRef);

    /**
     * 根据ID查询我的会员卡信息和节省金额
     *
     * @param id
     * @returnmemberCardRef
     */
    @GetMapping(value = "/memberCardRef/queryById/{id}")
    ResponseMessage queryById(@PathVariable(value = "id") int id);

    /**
     * 根据ID查询我的会员卡信息和节省金额
     *
     * @param id
     * @returnmemberCardRef
     */
    @GetMapping(value = "/memberCardRef/queryByRefId/{id}")
    ResponseMessage<MemberCardRef> queryByRefId(@PathVariable(value = "id") int id);


    /**
     * 前端分页查询用户会员卡表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param memberCardRef 查询条件
     * @return
     */
    @PostMapping(value = "/memberCardRef/front/findByPage")
    PageInfo<MemberCardRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                       Integer pageSize, @RequestBody MemberCardRef memberCardRef);

    /**
     * 通过会员Id和会员卡ID查询
     * @param map
     * @return
     */
    @PostMapping(value = "/memberCardRef/queryMemberCardInfo")
    ResponseMessage<MemberCardRef> queryByIdAndCardId(@RequestBody Map<String, Object> map);

    /**
     * 查询我的会员卡信息
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @param isEnabled
     * @return
     */
    @GetMapping(value = "/memberCardRef/queryByMemberId")
    ResponseMessage<PageInfo<Map<String,Object>>> queryByMemberId(
            @RequestParam(value = "pageNo") Integer pageNo,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "memberId") Integer memberId,
            @RequestParam(value = "isEnabled") Byte isEnabled);


    /**
     *  提交订单查询可以使用的会员卡
     * @param pageNo
     * @param pageSize
     * @param memberId
     * @param productId
     * @return
     */
    @GetMapping(value = "/memberCardRef/queryUserdByMemberId")
    ResponseMessage<PageInfo<Map<String,Object>>> queryUserdByMemberId(
            @RequestParam(value = "pageNo") Integer pageNo,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "memberId") Integer memberId,
            @RequestParam(value = "productId") Integer productId);

    /**
     * 查询会员卡消费
     * @param amount
     * @param memberId
     * @param memberCardRefId
     * @return
     */
    @PostMapping(value = "/memberCardRef/memberCardConsume")
    ResponseMessage memberCardConsume(@RequestParam(value = "amount") Integer amount,
                                      @RequestParam(value = "memberId") Integer memberId,
                                      @RequestParam(value = "memberCardRefId") Integer memberCardRefId);


    /**
     * 查询用户最新购买的会员卡信息
     * @param memberId
     * @return
     */
    @GetMapping(value = "/memberCardRef/queryMemberNewestCard/{memberId}")
    ResponseMessage queryMemberNewestCard(@PathVariable(value = "memberId") Integer memberId);



    /**
     * 添加用户购卡记录
     * @param memberCardTradeRecode
     * @return
     */
    @PostMapping(value = "/memberCardRef/insertBuyCardRecord")
    ResponseMessage insertBuyCardRecord(@RequestBody MemberCardTradeRecode memberCardTradeRecode);


    /**
     * 更新会员卡余额
     * @param memberCardTradeRecode
     * @return
     */
    @PostMapping(value = "/memberCardRef/updateMemberCardBalance")
    ResponseMessage updateMemberCardBalance(@RequestBody MemberCardTradeRecode memberCardTradeRecode);

}