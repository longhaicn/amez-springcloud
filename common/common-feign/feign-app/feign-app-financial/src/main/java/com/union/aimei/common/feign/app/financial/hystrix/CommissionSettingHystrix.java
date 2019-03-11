package com.union.aimei.common.feign.app.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.CommissionSettingFeign;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author liufeihua
 */
@Component
public class CommissionSettingHystrix implements CommissionSettingFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(CommissionSetting record) {
        return 1;
    }

    @Override
    public CommissionSetting selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CommissionSetting record) {
        return 1;
    }

    @Override
    public PageInfo<CommissionSetting> selectListByConditions(Integer pageNo, Integer pageSize, CommissionSetting record) {
        return null;
    }

    @Override
    public ResponseMessage<CommissionSetting> selectByCommissionCode(String commissionCode) {
        return HystrixResponse.invokeFail();
    }
}