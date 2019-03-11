package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 解除挂靠列表结果
 *
 * @author liurenkai
 * @time 2018/6/5 18:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("解除挂靠列表结果")
public class AffiliatedListRemoveResVo extends StoreBeauticianAffiliated {
    
    @ApiModelProperty("昵称")
    private String beauticianNickName;

}
