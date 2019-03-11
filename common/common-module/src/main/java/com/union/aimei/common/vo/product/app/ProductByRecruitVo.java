package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 招募项目条件
 *
 * @author liurenkai
 * @time 2018/5/17 14:51
 */
@Data
@EqualsAndHashCode
@ApiModel("招募项目条件")
public class ProductByRecruitVo implements Serializable {

    /**
     * 列表类型，1-项目管理，2-项目申请，3-待门店审核，4-申请结果，5-项目邀请，6-已接收的邀请
     */
    public interface ListType {
        int PRODUCT_MANAGE = 1;
        int PRODUCT_APPLY = 2;
        int WAIT_STORE_AUDIT = 3;
        int APPLY_RESULT = 4;
        int PRODUCT_INVINATION = 5;
        int ACCEPTED_INVINATION = 6;
    }

    @ApiModelProperty("列表类型，1-项目管理，2-项目申请，3-待门店审核，4-申请结果，5-项目邀请，6-已接收的邀请")
    private Integer listType;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("输入条件（门店/项目名称）")
    private String inputCond;

    @ApiModelProperty("项目类型")
    private Integer categoryId;

    @ApiModelProperty("位置区域")
    private Integer areaId;

    @ApiModelProperty("分成比例")
    private String commissionRatio;

    @ApiModelProperty("最低分成比例")
    private Integer minCommissionRatio;

    @ApiModelProperty("最高分成比例")
    private Integer maxCommissionRatio;

    @ApiModelProperty("价格范围")
    private String priceRange;

    @ApiModelProperty("最低价格")
    private Integer minSalePirce;

    @ApiModelProperty("最高价格")
    private Integer maxSalePrice;

}
