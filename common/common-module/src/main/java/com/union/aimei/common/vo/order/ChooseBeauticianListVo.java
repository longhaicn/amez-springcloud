package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


/**
*@author GaoWei
*descrption:
*time  2018/1/12 22:20
*/
@Data
@EqualsAndHashCode
public class ChooseBeauticianListVo {
    @ApiModelProperty(value = "选择时间")
    private String chooseTime;
    @ApiModelProperty(value = "美容师ID集合")
    private List<Integer> beauticianIdList=new ArrayList<>(10);

}
