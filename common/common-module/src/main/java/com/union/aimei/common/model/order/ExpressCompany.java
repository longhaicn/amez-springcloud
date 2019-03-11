package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/** 
  * @author GaoWei
  * @Date 18-8-23 下午4:38
  * @description
  */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel(value="快递公司信息表")
public class ExpressCompany implements Serializable {
       @ApiModelProperty("主键ID")
       private Integer id;

       @ApiModelProperty("快递公司名称")
       private String companyName;

       @ApiModelProperty("快递公司编码")
       private String companyCode;

       @ApiModelProperty("类型")
       private String type;

       @ApiModelProperty("国家编码")
       private String countryCode;

       @ApiModelProperty("说明")
       private String remark;

       private static final long serialVersionUID = 1L;
}