package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 根据分类代码查询常见问题结果
 *
 * @author liurenkai
 * @time 2018/5/9 16:24
 */
@Data
@EqualsAndHashCode
@ApiModel("根据分类代码查询常见问题结果")
public class FaqByCategoryCodeResVo implements Serializable {

    @ApiModelProperty("分类代码")
    private String categoryCode;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("0-顶级分类")
    private Integer pid;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("问题")
    private String question;

    @ApiModelProperty("答案")
    private String answer;

    @ApiModelProperty("1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

}
