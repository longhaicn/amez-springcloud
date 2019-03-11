package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据店铺ID查询店铺-客服-关联结果
 *
 * @author liurenkai
 * @time 2018/1/19 15:52
 */
@Data
@EqualsAndHashCode
@ApiModel("根据店铺ID查询店铺-客服-关联结果")
public class StoreServiceRefByStoreIdResultVo implements Serializable {

    @ApiModelProperty("客服类型，1-店铺，2-平台")
    private Integer serviceType;

    @ApiModelProperty("店铺美容师ID")
    private String beauticianId;

    @ApiModelProperty("昵称")
    private String beauticianNickName;

    @ApiModelProperty("姓名")
    private String beauticianName;

    @ApiModelProperty("头像")
    private String headImgUrl;
}
