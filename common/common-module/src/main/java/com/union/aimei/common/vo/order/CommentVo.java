package com.union.aimei.common.vo.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GaoWei
 * @describe 评价VO
 * @time 2018/3/15,10:23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    @ApiModelProperty(value = "全部评论条数")
    private int allCount;
    @ApiModelProperty(value = "有图评论条数")
    private int hasImgCount;
    @ApiModelProperty(value = "好评数量")
    private int praiseCount;
    @ApiModelProperty(value = "中评数量")
    private int mediateCount;
    @ApiModelProperty(value = "差评数量")
    private int negativeCount;
    @ApiModelProperty(value = "评论分页对象")
    PageInfo<OrderComment> voPageInfo;


}
