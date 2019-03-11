package com.union.aimei.common.feign.pc.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberCardUseRangeApiHystrix;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId = "pc-member-service", fallback = MemberCardUseRangeApiHystrix.class)
public interface MemberCardUseRangeFeign {
    /**
     * 添加会员卡使用范围
     *
     * @param memberCardUseRange
     * @return
     */
    @PostMapping(value = "/memberCardUseRange/insert")
    int insert(@RequestBody MemberCardUseRange memberCardUseRange);

    /**
     * 删除会员卡使用范围
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/memberCardUseRange/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改会员卡使用范围
     *
     * @param memberCardUseRange
     * @return
     */
    @PutMapping(value = "/memberCardUseRange/edit")
    int edit(@RequestBody MemberCardUseRange memberCardUseRange);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCardUseRange
     */
    @GetMapping(value = "/memberCardUseRange/queryById/{id}")
    MemberCardUseRange queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询会员卡使用范围
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberCardUseRange 查询条件
     * @return
     */
    @PostMapping(value = "/memberCardUseRange/front/findByPage")
    PageInfo<MemberCardUseRange> findByPageForFront(
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestBody MemberCardUseRange memberCardUseRange);

    /**
     * 根据storeId来修改会员卡使用门店
     *
     * @param storeId
     */
    @GetMapping("/memberCardUseRange/updateBatch/{storeId}")
    public void updateBatch(@PathVariable(value = "storeId") int storeId);



    /**
     * 会员卡 冻结或者解冻
     *
     * @param storeId 店铺ID
     * @param type    状态：0-冻结，1-正常
     * @return
     */
    @PutMapping("/memberCardUseRange/memberCardStatusByStoreId/{storeId}/{type}")
    ResponseMessage memberCardStatusByStoreId(@PathVariable(value = "storeId") int storeId, @PathVariable(value = "type") int type);


}