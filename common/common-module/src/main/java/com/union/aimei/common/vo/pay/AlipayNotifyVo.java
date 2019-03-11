package com.union.aimei.common.vo.pay;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @author GaoWei
 * @time 2018/6/5 17:51
 * @description
 */
@Data
@Builder
public class AlipayNotifyVo {

    private Map<String,String> map;
    private String appId;
    private String outTradeNo;
    private String tradeNo;
    private String tradeType;
    private int totalAmount;

}
