package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/4/11 14:40
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "项目城市")
public class ProductCity implements Serializable {

    /**
     * 项目标签
     */
    public interface ProductLabel {
        int DEFAUTL = 0;
        int SELECT = 1;
        int NEW = 2;
    }

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("城市名称")
    private String cityName;

    @ApiModelProperty("商品标签，0-默认，1-推荐，2-新品")
    private Integer productLabel;

    @ApiModelProperty("标签排序")
    private Integer labelSort;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}