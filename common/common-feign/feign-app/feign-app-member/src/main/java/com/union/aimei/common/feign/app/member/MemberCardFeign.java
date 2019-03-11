package com.union.aimei.common.feign.app.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberCardApiHystrix;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.MemberCardDetailsVo;
import com.union.aimei.common.vo.member.SubmitMemberCard;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,11:04
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberCardApiHystrix.class)
public interface MemberCardFeign {
    /**
     * 添加会员卡
     * @param submitMemberCard
     * @return
     */
    @PostMapping(value = "/memberCard/insert")
    int insert(@RequestBody SubmitMemberCard submitMemberCard);

    /**
     * 删除会员卡
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/memberCard/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改会员卡
     *
     * @param memberCard
     * @return
     */
    @PutMapping(value = "/memberCard/edit")
    int edit(@RequestBody MemberCard memberCard);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCard
     */
    @GetMapping(value = "/memberCard/queryById/{id}")
    MemberCard queryById(@PathVariable(value = "id") int id);

    /**
     * 查询购卡分页卡列表
     * @param pageNo
     * @param pageSize
     * @param memberCard
     * @return
     */
    @PostMapping("/memberCard/front/findByPage")
    PageInfo<MemberCard> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody MemberCard memberCard);


    /**
     * 根据会员ID和会员卡ID查询会员卡详情
     * @param memberId
     * @param cardId
     * @return
     */
    @GetMapping(value = "/memberCard/queryDetailsByMemAndCardId")
    ResponseMessage queryDetailsByCardId(@RequestParam(value = "memberId") Integer memberId,
                                         @RequestParam(value = "cardId") Integer cardId);


    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCard
     */
    @GetMapping(value = "/memberCard/queryDetailById/{id}")
    ResponseMessage queryDetailById(@PathVariable(value = "id") int id);

    /**
     * 根据会员id和经纬度查询会员卡详情
     * @param memberCardDetailsVo
     * @returnmemberCard
     */
    @PostMapping("/memberCard/queryDetailsById")
    ResponseMessage queryDetailsById(MemberCardDetailsVo memberCardDetailsVo);


}