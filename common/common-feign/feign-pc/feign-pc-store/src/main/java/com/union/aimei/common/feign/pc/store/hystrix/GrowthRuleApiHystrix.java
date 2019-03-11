package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.GrowthRuleFeign;
import com.union.aimei.common.model.store.GrowthRule;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Component(value = "pc-GrowthRuleFeign")
public class GrowthRuleApiHystrix implements GrowthRuleFeign {

    /**
     * 前端分页查询成长规则
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param growthRule 查询条件
     * @return
     */
    @Override
    public PageInfo<GrowthRule> findByPageForFront(Integer pageNo, Integer pageSize, GrowthRule growthRule) {
        return null;
    }

    @Override
    public ResponseMessage checkCode(byte ruleType, String code) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage saveGrowthRule(GrowthRule growthRule) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage editGrowthRule(GrowthRule growthRule) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage saveGrowthRuleV111(GrowthRuleVo growthRuleVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage saveBatchGrowthRuleV111(List<GrowthRuleVo> growthRuleVoList) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加成长规则
     *
     * @param growthRule
     * @return
     */
    @Override
    public int insert(GrowthRule growthRule) {
        return 0;
    }

    /**
     * 删除成长规则
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改成长规则
     *
     * @param growthRule
     * @return
     */
    @Override
    public int edit(GrowthRule growthRule) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returngrowthRule
     */
    @Override
    public GrowthRule queryById(int id) {
        return null;
    }
}