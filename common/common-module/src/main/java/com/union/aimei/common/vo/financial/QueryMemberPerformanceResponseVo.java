package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel(value = "app门店端的营业统计中的员工业绩返回Vo")
public class QueryMemberPerformanceResponseVo {

    @ApiModelProperty(value = "美容师id")
    private Integer beauticianId;

    @ApiModelProperty(value = "项目名字、美容师名字")
    private String beauticianName;

    @ApiModelProperty(value = "金额")
    private Integer amount;

    @ApiModelProperty(value = "单数")
    private Integer oderNumber;

    @ApiModelProperty("头像")
    private String headImgUrl;

    @ApiModelProperty("员工类型 2-全职员工，3-兼职员工")
    private Integer beauticianType;

}
