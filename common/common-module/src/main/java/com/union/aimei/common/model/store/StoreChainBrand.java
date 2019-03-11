package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2017/12/25 15:39
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店连锁品牌")
public class StoreChainBrand implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌LOGO")
    private String brandLogo;

    @ApiModelProperty("品牌所属公司")
    private String brandOwnershipCompany;

    @ApiModelProperty("门店总数")
    private Integer storeTotal;

    @ApiModelProperty("服务项目总数")
    private Integer productTotal;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 总数加1
     */
    public final static int TOTAL_ADD = 1;
    /**
     * 总数减1
     */
    public final static int TOTAL_SUBTRACT = -1;

    private static final long serialVersionUID = 1L;
}