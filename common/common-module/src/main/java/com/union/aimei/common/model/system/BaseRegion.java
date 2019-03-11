package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "全球地区表")
public class BaseRegion implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 地区类型，0-国家，1-省份，2-城市，3-区县
     */
    public interface RegionType {
        int COUNTRY = 0;
        int PROVINCE = 1;
        int CITY = 2;
        int AREA = 3;
    }

    List<BaseRegion> childrens = new ArrayList<>(10);
    private Integer regionId;
    private Integer parentId;
    private String regionName;
    private Integer regionType;
    private Short agencyId;
    private String regionSn;
    @ApiModelProperty("是否系统内建")
    private Boolean buildin;
    private Date lastchanged;
}