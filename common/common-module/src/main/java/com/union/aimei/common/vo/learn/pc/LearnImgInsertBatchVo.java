package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author houji
 * @date 2018/5/15  17:17
 */
@Data
@EqualsAndHashCode
@ApiModel("批量添加主图片")
public class LearnImgInsertBatchVo implements Serializable {

    @ApiModelProperty("学习图片的类型 0--活动 1--课程，默认0")
    private Integer sourceType;

    @ApiModelProperty("来源id")
    private Integer sourceId;

    @ApiModelProperty("主图片集合")
    private List<String> imgUrlList;

    private static final long serialVersionUID = 1L;
}
