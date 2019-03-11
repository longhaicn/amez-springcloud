package com.union.aimei.common.feign.app.member.hystrix;



import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberLevelUpgradeFeign;
import com.union.aimei.common.model.member.MemberLevelUpgrade;
import org.springframework.stereotype.Component;


/**
 * @author GaoWei
 * @describe
 * @time 2017/12/8,10:38
 */
@Component(value = "app-MemberLevelUpgradeFeign")
public class MemberLevelUpgradeApiHystrix implements MemberLevelUpgradeFeign {

    /**
     * 前端分页查询会员成长值规则设置
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberLevelUpgrade 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberLevelUpgrade> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevelUpgrade memberLevelUpgrade) {
        return null;
    }

    /**
     * 添加会员成长值规则设置
     *
     * @param memberLevelUpgrade
     * @return
     */
    @Override
    public int insert(MemberLevelUpgrade memberLevelUpgrade) {
        return 0;
    }

    /**
     * 删除会员成长值规则设置
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改会员成长值规则设置
     *
     * @param memberLevelUpgrade
     * @return
     */
    @Override
    public int edit(MemberLevelUpgrade memberLevelUpgrade) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberLevelUpgrade
     */
    @Override
    public MemberLevelUpgrade queryById(int id) {
        return null;
    }
}