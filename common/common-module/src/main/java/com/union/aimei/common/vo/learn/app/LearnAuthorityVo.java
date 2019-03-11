package com.union.aimei.common.vo.learn.app;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据美容师信息查询科学系的课程vo
 *
 * @author caizhaoming
 * @create 2018-05-22 15:09
 **/
@Data
@EqualsAndHashCode
@ApiModel("根据美容师信息查询科学系的课程vo")
public class LearnAuthorityVo implements Serializable {


    @ApiModelProperty("店铺美容师")
    private StoreBeautician storeBeautician;

    @ApiModelProperty("店铺")
    private Store store;

    @ApiModelProperty("类型 0-课程 1-活动(美容师) 2-(店铺)")
    private Byte sourceType;

    /**
     * 类型 0-课程
     */
    public static final Byte SOURCE_TYPE_COURSE = 0;
    /**
     * 类型 1-活动
     */
    public static final Byte SOURCE_TYPE_ACTIVE = 1;


}
