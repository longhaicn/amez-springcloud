package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.BeauticianBusinessHour;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量美容师营业时间条件
 *
 * @author liurenkai
 * @time 2018/6/8 16:02
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel("批量美容师营业时间条件")
public class BeauticianBusinessHourByBatchVo implements Serializable {

    public BeauticianBusinessHourByBatchVo(List<BeauticianBusinessHour> beauticianBusinessHourList) {
        this.beauticianBusinessHourList = beauticianBusinessHourList;
    }

    @ApiModelProperty("美容师营业时间集合")
    private List<BeauticianBusinessHour> beauticianBusinessHourList;

}
