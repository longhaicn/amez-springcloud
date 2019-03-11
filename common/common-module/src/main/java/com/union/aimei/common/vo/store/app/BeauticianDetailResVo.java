package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师详情结果
 *
 * @author liurenkai
 * @time 2018/6/26 20:31
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师详情结果")
public class BeauticianDetailResVo implements Serializable {

    @ApiModelProperty("美容师")
    private StoreBeautician beautician;

    @ApiModelProperty("是否关注，true-已关注，false-未关注")
    private Boolean isFollower;

}
