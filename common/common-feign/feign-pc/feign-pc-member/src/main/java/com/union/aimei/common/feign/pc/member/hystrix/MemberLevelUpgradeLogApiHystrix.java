package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberLevelUpgradeLogFeign;
import com.union.aimei.common.model.member.MemberLevelUpgradeLog;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberLevelUpgradeLogFeign")
public class MemberLevelUpgradeLogApiHystrix implements MemberLevelUpgradeLogFeign {

       /**
        * 前端分页查询会员成长值记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevelUpgradeLog 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberLevelUpgradeLog> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevelUpgradeLog memberLevelUpgradeLog) {
              return null;
       }

       /**
        * 添加会员成长值记录
        * @param memberLevelUpgradeLog
        * @return
        */
       @Override
       public int insert(MemberLevelUpgradeLog memberLevelUpgradeLog) {
              return 0;
       }

       /**
        * 删除会员成长值记录
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员成长值记录
        * @param memberLevelUpgradeLog
        * @return
        */
       @Override
       public int edit(MemberLevelUpgradeLog memberLevelUpgradeLog) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevelUpgradeLog
        */
       @Override
       public MemberLevelUpgradeLog queryById(int id) {
              return null;
       }
}