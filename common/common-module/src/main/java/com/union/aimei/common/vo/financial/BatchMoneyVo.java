package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "美容师批量打款vo")
public class BatchMoneyVo {

    @ApiModelProperty("交易流水id")
    private String ids;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("美容师手机")
    private String phones;

    @ApiModelProperty("发关给短信的内容")
    private String smsContent;

//    @ApiModelProperty("提现的额度")
//    private Integer accounts;
//
//    @ApiModelProperty("提现的尾号")
//    private String bank_card_no;
}
