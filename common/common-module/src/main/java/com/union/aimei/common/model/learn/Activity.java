package com.union.aimei.common.model.learn;

import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Data
@EqualsAndHashCode
@ApiModel(value="活动表")
public class Activity implements Serializable {
       @ApiModelProperty("主键自增")
       private Integer id;

       @ApiModelProperty("主标题")
       private String mtitle;

       @ApiModelProperty("副标题")
       private String stitle;

       @ApiModelProperty("活动类型(0-- 美容师 1--门店端)")
       private Integer type;

       @ApiModelProperty("活动小图标")
       private String icon;

       @ApiModelProperty("活动主图片list")
       private List<String> imgList;

       @ApiModelProperty("发布者(0--平台 1--门店，默认平台)")
       private Integer publisher;

       @ApiModelProperty("活动详细说明")
       private String description;

       @ApiModelProperty("置顶banner图")
       private String bannerImg;

       @ApiModelProperty("是否置顶(0--不置顶 1--置顶，默认0)")
       private Byte topStatus;

       @ApiModelProperty("置顶帖权重值")
       private Integer weightTop;

       @ApiModelProperty("省id")
       private Integer provinceId;

       @ApiModelProperty("省名称")
       private String provinceName;

       @ApiModelProperty("市id")
       private Integer cityId;

       @ApiModelProperty("市名称")
       private String cityName;

       @ApiModelProperty("区id")
       private Integer districtId;

       @ApiModelProperty("区名称")
       private String districtName;

       @ApiModelProperty("活动详细地址")
       private String address;

       @ApiModelProperty("活动报名起始时间")
       private Date enterstartTime;

       @ApiModelProperty("活动报名结束时间")
       private Date enterendTime;

       @ApiModelProperty("活动起始时间")
       private Date startTime;

       @ApiModelProperty("活动结束时间")
       private Date endTime;

       @ApiModelProperty("活动时间(周几)")
       private String weekdayStart;

       @ApiModelProperty("活动时长(天)")
       private Integer dayLength;

       @ApiModelProperty("活动时长(小时)")
       private Integer hourLength;

       @ApiModelProperty("活动费用")
       private Integer costs;

       @ApiModelProperty("注意事项")
       private String attentions;

       @ApiModelProperty("人数限制")
       private Integer limited;

       @ApiModelProperty("已经报名的人数")
       private Integer enteredSum;

       @ApiModelProperty("报名条件")
       private String conditions;

       @ApiModelProperty("活动成长值")
       private Integer growthValue;

       @ApiModelProperty("标签")
       private String tag;

       @ApiModelProperty("活动状态(0--创建未开启 1--活动报名中  2--活动进行中 3--活动结束，默认0)")
       private Integer status;

       @ApiModelProperty("创建时间")
       private Date createTime;

       @ApiModelProperty("更新时间")
       private Date updateTime;

       @ApiModelProperty("前台传参门槛集合")
       private List<LearnConditionVo> learnConditionVoList;

       @ApiModelProperty("后台逻辑门槛集合")
       private List<LearnCondition> learnConditionList;

       private static final long serialVersionUID = 1L;

       @ApiModelProperty("活动apptype 0--未报名 1--已经报名 2--活动结束")
       private Integer apptype;

       @ApiModelProperty("图片的list集合")
       private List<String> imgURLList;

       @ApiModelProperty("会员的id")
       private Integer memberId;

       @ApiModelProperty("门店的id")
       private Integer storeId;

       @ApiModelProperty("活动列表主图")
       private String mainImgURL;


       public interface Status{
              int CREATE_NOT_OPEN = 0;
              int ACTIVITY_SIGN = 1;
              int ACTIVITY_RUNING = 2;
              int ACTIVITY_END = 3;
       }

}