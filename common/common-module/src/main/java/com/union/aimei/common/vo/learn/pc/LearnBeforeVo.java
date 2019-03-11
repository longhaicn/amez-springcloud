package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 前置课程数据vo
 *
 * @author caizhaoming
 * @create 2018-05-21 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("前置课程数据vo")
public class LearnBeforeVo implements Serializable {


    @ApiModelProperty("源集集合")
    private Map<Integer, String> srcMap;
    @ApiModelProperty("目标集合")
    private List<Integer> target;

}
