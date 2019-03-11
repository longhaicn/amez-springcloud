package com.union.aimei.common.feign.pc.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberCardUseProductApiHystrix;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberCardUseProductApiHystrix.class)
public interface MemberCardUseProductFeign {
       /**
        * 添加会员卡适用服务表
        * @param memberCardUseProduct
        * @return
        */
       @PostMapping(value="/memberCardUseProduct/insert")
       int insert(@RequestBody MemberCardUseProduct memberCardUseProduct);


       /**
        * 删除会员卡适用服务表
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberCardUseProduct/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改会员卡适用服务表
        * @param memberCardUseProduct
        * @return
        */
       @PutMapping(value="/memberCardUseProduct/edit")
       int edit(@RequestBody MemberCardUseProduct memberCardUseProduct);

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardUseProduct
        */
       @GetMapping(value="/memberCardUseProduct/queryById/{id}")
       MemberCardUseProduct queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员卡适用服务表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardUseProduct 查询条件
     * @return
     */
       @PostMapping(value="/memberCardUseProduct/front/findByPage")
       PageInfo<MemberCardUseProduct> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                 Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                 Integer pageSize, @RequestBody MemberCardUseProduct memberCardUseProduct);

       /**
        * 当品牌发布得商品在品牌所属门店上架，添加会员卡支付
        * @param newProductGroundVo
        * @return
        */
       @PostMapping("/memberCardUseProduct/insertMemberCardByProductId")
       public ResponseMessage insertMemberCardByProductId(@RequestBody NewProductGroundVo newProductGroundVo);
}