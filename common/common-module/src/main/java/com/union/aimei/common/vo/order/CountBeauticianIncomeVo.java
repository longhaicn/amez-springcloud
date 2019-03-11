package com.union.aimei.common.vo.order;


import lombok.Data;

/**
 * @author GaoWei
 * @describe 统计美容师预收入VO
 * @time 2018/4/12,12:04
*/
@Data
public class CountBeauticianIncomeVo {

    private Integer id;
    private Integer  type;
    private Integer amountPay;
    private Integer freight;
    private Integer beauticianCommission;

}
