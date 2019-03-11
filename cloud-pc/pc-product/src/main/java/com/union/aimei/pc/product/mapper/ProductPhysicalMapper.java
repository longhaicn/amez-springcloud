package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.pc.PhyByManageResVo;
import com.union.aimei.common.vo.product.pc.PhyByManageVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 15:44
 */
public interface ProductPhysicalMapper extends BaseMapper<ProductPhysical> {

    /**
     * 查询产品（产品管理）
     *
     * @param manageVo
     * @return
     */
    List<PhyByManageResVo> selectListByManage(PhyByManageVo manageVo);

}