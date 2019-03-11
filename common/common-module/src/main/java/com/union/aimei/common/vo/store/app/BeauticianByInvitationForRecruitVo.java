package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师招募邀请条件
 *
 * @author liurenkai
 * @time 2018/5/24 7:11
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师招募邀请条件")
public class BeauticianByInvitationForRecruitVo implements Serializable {

    /**
     * 列表类型，1-待确认，2-招募结果，3-项目申请
     */
    public interface ListType {
        int WAIT_CONFIRM = 1;
        int AFFILATED_RESULT = 2;
        int PRODUCT_APPLY = 3;
    }

    @ApiModelProperty("列表类型，1-待确认，2-招募结果，3-项目申请")
    private Integer listType;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("项目ID")
    private Integer productId;

}
