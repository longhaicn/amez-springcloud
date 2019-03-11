package com.union.aimei.common.feign.app.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.PlatformTradeDetailFeign;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author liufeihua
 */
@Component
public class PlatformTradeDetailHystrix implements PlatformTradeDetailFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(PlatformTradeDetail record) {
        return 1;
    }

    @Override
    public PlatformTradeDetail selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformTradeDetail record) {
        return 1;
    }

    @Override
    public PageInfo<PlatformTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetail record) {
        return null;
    }

    @Override
    public ResponseMessage insertSelectiveV110(PlatformTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelectiveV110(PlatformTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PlatformTradeDetail> findByOrderNo(String orderNo, Integer tradeType) {
        return HystrixResponse.invokeFail();
    }
}