package com.union.aimei.common.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量ID
 *
 * @author liurenkai
 * @time 2018/5/2 16:30
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel("批量ID")
public class IdBatchVo implements Serializable {

    public IdBatchVo(List<Integer> idList) {
        this.idList = idList;
    }

    @ApiModelProperty("ID集合")
    private List<Integer> idList;

}
