package com.union.aimei.common.feign.pc.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberCardTemplateApiHystrix;
import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.aimei.common.vo.member.MemberCardTemplateVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId="pc-member-service",fallback=MemberCardTemplateApiHystrix.class)
public interface MemberCardTemplateFeign {
       /**
        * 批量添加会员卡卡面模板表
        * @param memberCardTemplateVo
        * @return
        */
       @PostMapping(value="/memberCardTemplate/insertByBatch")
       void insertByBatch(@RequestBody MemberCardTemplateVo memberCardTemplateVo);

       /**
        * 添加会员卡卡面模板表
        * @param memberCardTemplate
        * @return
        */
       @PostMapping(value="/memberCardTemplate/insert")
       int insert(@RequestBody MemberCardTemplate memberCardTemplate);

       /**
        * 删除会员卡卡面模板表
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberCardTemplate/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /**
        * 根据parent_group_id删除模板
        * @param id
        * @return
        */
       @DeleteMapping(value="/memberCardTemplate/deleteByGroupId/{id}")
       int deleteByGroupId(@PathVariable(value = "id") int id);

       /** 
        * 修改会员卡卡面模板表
        * @param memberCardTemplate
        * @return
        */
       @PutMapping(value="/memberCardTemplate/edit")
       int edit(@RequestBody MemberCardTemplate memberCardTemplate);



       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardTemplate
        */
       @GetMapping(value="/memberCardTemplate/queryById/{id}")
       MemberCardTemplate queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询会员卡卡面模板表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberCardTemplate 查询条件
     * @return
     */
       @PostMapping(value="/memberCardTemplate/front/findByPage")
       PageInfo<MemberCardTemplate> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                               Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                               Integer pageSize, @RequestBody MemberCardTemplate memberCardTemplate);
}