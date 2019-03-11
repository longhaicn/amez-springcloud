package com.union.aimei.pay.settle.rule;

import com.union.aimei.common.feign.app.financial.CommissionSettingFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:48
  * @description
  */
@Component
@CommonsLog
public class RateComponent {

    @Resource
    private ProductFeign productFeign;
    @Resource
    private CommissionSettingFeign commissionSettingFeign;
    /**
     * 获取美容师佣金比例
     * @param beauticianId
     * @param productId
     * @return
     */
    public int getBeauticianRate(int beauticianId,int productId){
         int rate=0;
         ResponseMessage<Integer> res=productFeign.getCommissionRatioV111(productId,beauticianId);
         AssertUtil.isRemoteInvokeSuccess(res);
         rate=res.getData().intValue();
         return rate;
    }

    /**
     * 获取平台抽成比例
     * @param rateType
     * @return
     */
    public int getPlatformRate(String rateType){
        ResponseMessage<CommissionSetting> res= commissionSettingFeign.selectByCommissionCode(rateType);
        AssertUtil.isRemoteInvokeSuccess(res);
        CommissionSetting setting=res.getData();
        int rate=setting.getCommissionRate();
        return rate;
    }
}
