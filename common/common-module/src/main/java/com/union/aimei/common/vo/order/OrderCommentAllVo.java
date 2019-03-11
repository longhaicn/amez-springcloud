package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderComment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 订单评论VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "订单评论VO")
public class OrderCommentAllVo{

    @ApiModelProperty(value = "订单评论")
    private OrderComment orderComment;
    @ApiModelProperty(value = "评论图片")
    private List<String> imgList;
}
