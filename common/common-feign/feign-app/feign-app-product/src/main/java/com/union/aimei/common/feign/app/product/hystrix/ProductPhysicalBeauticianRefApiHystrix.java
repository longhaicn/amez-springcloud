package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductPhysicalBeauticianRefFeign;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.vo.product.app.PhysicalBeauticianRefListInventoryByProductIdVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByBeauticianIdResVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByRefIdVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:19
 */
@Component(value = "app-ProductPhysicalBeauticianRefFeign")
public class ProductPhysicalBeauticianRefApiHystrix implements ProductPhysicalBeauticianRefFeign {

    /**
     * 分页查询产品-美容师-关联
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param productPhysicalBeauticianRef 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int insert(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return 0;
    }

    /**
     * 删除产品-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int edit(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalBeauticianRef
     */
    @Override
    public ProductPhysicalBeauticianRef queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<ProductPhysicalBeauticianRef> findByRefId(ProductPhysicalBeauticianRefByRefIdVo refIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo>> findByPageForBeauticianId(Integer pageNo, Integer pageSize, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductPhysicalBeauticianRef>> listInventoryByProductIdV111(PhysicalBeauticianRefListInventoryByProductIdVo productIdVo) {
        return HystrixResponse.invokeFail();
    }
}