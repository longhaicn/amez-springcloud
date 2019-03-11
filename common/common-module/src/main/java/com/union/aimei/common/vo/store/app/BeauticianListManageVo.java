package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * 美容师管理列表条件
 *
 * @author liurenkai
 * @time 2018/6/13 19:06
 */
@Data
@EnableAutoConfiguration
@ApiModel("美容师管理列表条件")
public class BeauticianListManageVo implements Serializable {
    /**
     * 员工类型，1-门店员工，2-挂靠员工
     */
    public interface EmployeeType {
        int STORE = 1;
        int AFFILIATED = 2;
    }

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("员工类型，1-门店员工，2-挂靠员工")
    private Integer employeeType;

}
