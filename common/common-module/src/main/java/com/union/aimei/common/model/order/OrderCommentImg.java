package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@ApiModel(value="订单评论图片表")
/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/11,17:39
*/
public class OrderCommentImg implements Serializable {
       private Integer id;

       @ApiModelProperty("订单评论ID")
       private Integer commentId;

       @ApiModelProperty("订单评论图片地址")
       private String commentImgUrl;

       @ApiModelProperty("添加时间")
       private Date addTime;

       @ApiModelProperty("修改时间")
       private Date updateTime;

       private static final long serialVersionUID = 1L;
}