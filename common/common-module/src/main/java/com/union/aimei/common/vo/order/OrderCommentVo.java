package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author GaoWei
 * @describe  订单评论vo
 * @time 2018/1/19,14:23
*/
@Data
@EqualsAndHashCode
public class OrderCommentVo {
    @ApiModelProperty(value = "订单评论")
    private OrderComment orderComment;
    @ApiModelProperty(value = "订单评论图片")
    private List<String> commentImgList=new ArrayList<>(10);

}
