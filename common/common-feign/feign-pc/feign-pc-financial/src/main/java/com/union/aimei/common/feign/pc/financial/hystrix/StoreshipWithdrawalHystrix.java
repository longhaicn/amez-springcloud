package com.union.aimei.common.feign.pc.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreshipWithdrawalFeign;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-StoreshipWithdrawalFeign")
public class StoreshipWithdrawalHystrix implements StoreshipWithdrawalFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(StoreshipWithdrawal record) {
        return 1;
    }

    @Override
    public StoreshipWithdrawal selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(StoreshipWithdrawal record) {
        return 1;
    }

    @Override
    public PageInfo<StoreshipWithdrawal> selectListByConditions(Integer pageNo, Integer pageSize, StoreshipWithdrawal record) {
        return null;
    }
}