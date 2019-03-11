package com.union.aimei.common.vo.im.common;

import com.union.aimei.common.model.im.ImMessages;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量IM消息
 *
 * @author liurenkai
 * @time 2018/3/19 16:51
 */
@Data
@EqualsAndHashCode
@ApiModel("批量IM消息")
public class ImMessagesByBatchVo implements Serializable {

    public ImMessagesByBatchVo() {

    }

    public ImMessagesByBatchVo(List<ImMessages> imMessagesList) {
        this.imMessagesList = imMessagesList;
    }

    @ApiModelProperty("IM消息集合")
    private List<ImMessages> imMessagesList;

}
