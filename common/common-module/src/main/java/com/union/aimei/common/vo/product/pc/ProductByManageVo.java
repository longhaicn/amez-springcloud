package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目管理条件
 *
 * @author liurenkai
 * @time 2018/6/5 16:07
 */
@Data
@EqualsAndHashCode
@ApiModel("项目管理条件")
public class ProductByManageVo implements Serializable {

    @ApiModelProperty("项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("城市ID")
    private Integer cityId;

}
