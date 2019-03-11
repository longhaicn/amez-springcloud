package com.union.aimei.remote.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午4:03
  * @description
  */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayRecordVo {

    private Integer appSystem;
    private String createTime;
    private Integer creditsNum;
    private Integer id;
    private String ip;
    private Integer memberId;
    private String orderNo;
    private Integer orderType;
    private String outStatus;
    private String outTransactionNo;
    private double payCardDiscountRate;
    private Integer payCardId;
    private String payCardNo;
    private double payPrice;
    private String payRecordNo;
    private Integer payStatus;
    private String payTime;
    private Integer payType;
    private String returnOrderNo;
    private Integer shopId;
    private String updateTime;
}
