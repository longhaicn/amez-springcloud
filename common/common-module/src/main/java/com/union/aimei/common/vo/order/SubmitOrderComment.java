package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe  提交订单评论
 * @time 2017/12/22,17:08
*/
@Data
@EqualsAndHashCode
public class SubmitOrderComment{
       @ApiModelProperty(value = "评论图片,最多只能传6张，每张以；分隔")
       private String commentImgUrlList;
       @ApiModelProperty(value = "订单评论")
       private OrderComment orderComment;
}
