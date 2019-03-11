package com.union.aimei.common.feign.pc.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreSubordinateTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-StoreSubordinateTradeDetailFeign")
public class StoreSubordinateTradeDetailHystrix implements StoreSubordinateTradeDetailFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(StoreSubordinateTradeDetail record) {
        return 1;
    }

    @Override
    public StoreSubordinateTradeDetail selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(StoreSubordinateTradeDetail record) {
        return 1;
    }

    @Override
    public PageInfo<StoreSubordinateTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreSubordinateTradeDetail record) {
        return null;
    }
}