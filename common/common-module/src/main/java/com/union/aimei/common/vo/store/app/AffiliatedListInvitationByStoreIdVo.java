package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据门店ID查询挂靠邀请列表条件
 *
 * @author liurenkai
 * @time 2018/5/22 10:26
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID查询挂靠邀请列表条件")
public class AffiliatedListInvitationByStoreIdVo implements Serializable {

    /**
     * 列表类型，1-待确认，2-邀请结果，3-挂靠申请，4-挂靠解除申请
     */
    public interface ListType {
        int WAIT_CONFIRM = 1;
        int INVITATION_RESULT = 2;
        int AFFILATED_APPLY = 3;
        int AFFILATED_REMOVE_APPLY = 4;
    }

    @ApiModelProperty("列表类型，1-待确认，2-邀请结果，3-挂靠申请，4-挂靠解除申请")
    private Integer listType;

    @ApiModelProperty("门店ID")
    private Integer storeId;

}