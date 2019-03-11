package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 美容师-项目申请-项目详情结果
 *
 * @author liurenkai
 * @time 2018/6/1 17:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("美容师-项目申请-项目详情结果")
public class ProductByDetailByApplyForBeauticianResVo extends ProductRecruitDetailResVo {

    public ProductByDetailByApplyForBeauticianResVo(ProductRecruitDetailResVo detail) {
        this.setProductStoreRefId(detail.getProductStoreRefId());
        this.setProductId(detail.getProductId());
        this.setCoverImg(detail.getCoverImg());
        this.setServerName(detail.getServerName());
        this.setSalePrice(detail.getSalePrice());
        this.setCommission(detail.getCommission());
        this.setIsSupportStore(detail.getIsSupportStore());
        this.setIsSupportHome(detail.getIsSupportHome());
        this.setProductType(detail.getProductType());
        this.setStoreId(detail.getStoreId());
        this.setStoreName(detail.getStoreName());
        this.setStoreAddress(detail.getStoreAddress());
        this.setServerIntroduce(detail.getServerIntroduce());
    }

    @ApiModelProperty("发起方，1-美容师，2-门店，3-平台")
    private Integer sponsor;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过")
    private Integer auditStatus;

}
