package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单评论
 *
 * @author gaowei
 * @time 2018/8/24 10:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "订单评论")
public class OrderComment implements Serializable {

    /**
     * 会员评论
     */
    public static final int MEMBER_COMMENT = 1;
    /**
     * 美容师回复
     */
    public static final int BEAUTICIAN_REPLY = 2;

    /**
     * 评价星星等级
     */
    public static class StarNum {

        /**
         * 一星
         */
        public static final int ONE_STAR = 1;
        /**
         * 二星
         */
        public static final int TWO_STAR = 2;
        /**
         * 三星
         */
        public static final int THREE_STAR = 3;
        /**
         * 四星
         */
        public static final int FOUR_STAR = 4;
        /**
         * 五星
         */
        public static final int FIVE_STAR = 5;

    }

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("是否已删除过评论(0:没有删除，1：已删除)")
    private Boolean hasCancel;

    @ApiModelProperty("订单ID")
    private Integer orderId;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("订单美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("商品名")
    private String procutName;

    @ApiModelProperty("商品图片")
    private String productImg;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("会员名称")
    private String memberName;

    @ApiModelProperty("会员头像")
    private String memberImgUrl;

    @ApiModelProperty("回复的评论ID")
    private Integer parentCommentId;

    @ApiModelProperty("回复评论的美容师id")
    private Integer parentBeauticianId;

    @ApiModelProperty("回复评论的美容师名称")
    private String parentBeauticianName;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("美容师回复内容")
    private String replyContent;

    @ApiModelProperty("美容师回复时间")
    private Date replyTime;

    @ApiModelProperty("服务描述相符,1-5对应页面的星星")
    private Integer servicecredit;

    @ApiModelProperty("美容院环境,1-5对应页面的星星")
    private Integer storeEnvironment;

    @ApiModelProperty("美容师服务质量,1-5对应页面的星星")
    private Integer beauticianServerQuality;

    @ApiModelProperty("评论标签编码")
    private String labelCode;

    @ApiModelProperty("操作类型,1为评论，2为回复")
    private Integer operType;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("审核标识，1为已审核,0为未审核")
    private Boolean isChecked;

    @ApiModelProperty("是否匿名，1为不匿名,0为匿名")
    private Boolean isAnonymity;

    @ApiModelProperty("回复数")
    private Integer commentNum;

    @ApiModelProperty("点赞数")
    private Integer likeNum;

    @ApiModelProperty("项目评价等级(0:未评价，1：差评，2：中评,3：好评，4:系统自动好评)默认0")
    private Byte productEvaluationGrade;

    @ApiModelProperty("美容师评价等级(0：未评价，1：差评，2：中评，3：好评，4：系统默认好评)")
    private Byte beauticianEvaluationGrade;

    @ApiModelProperty("店铺评价等级(0:未评价，1：差评，2：中评,3：好评，4:系统自动好评)默认0")
    private Byte storeEvaluationGrade;

    @ApiModelProperty("是否有图(0:没有，1:有)")
    private Boolean hasImg;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "评论图片")
    private List<String> orderCommentImgList;

    private static final long serialVersionUID = 1L;


}