package com.union.aimei.common.model.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@ApiModel("生成二维码实体类")
public class AliPayOrder {
    @ApiModelProperty("商户订单号(必填)")
    private String outTradeNo;
    @ApiModelProperty("商户总金额(必填)")
    private String totalAmount;
    @ApiModelProperty("商户标题(必填)")
    private String subject;
    @ApiModelProperty("交易或者商品的描述")
    private String body;
    @ApiModelProperty("商户操作员id")
    private String operatorId;
    @ApiModelProperty("商户门店编号")
    private String storeId;
    @ApiModelProperty("商户终端机编号")
    private String terminalId;
    @ApiModelProperty("该笔订单允许用户最晚付款时间")
    private String timeoutExpress = "90m";


    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
}

