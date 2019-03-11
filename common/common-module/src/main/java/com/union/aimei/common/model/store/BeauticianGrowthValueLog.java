package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/6/4 10:42
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师成长值记录")
public class BeauticianGrowthValueLog implements Serializable {

    /**
     * 成长类型，1-课程，2-活动
     */
    public interface GrowthType {
        int COURSE = 1;
        int ACTIVITY = 2;
    }

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("成长类型，1-课程，2-活动")
    private Integer growthType;

    @ApiModelProperty("成长关联ID")
    private Integer growthRefId;

    @ApiModelProperty("成长名称")
    private String growthName;

    @ApiModelProperty("成长值")
    private Integer growthValue;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}