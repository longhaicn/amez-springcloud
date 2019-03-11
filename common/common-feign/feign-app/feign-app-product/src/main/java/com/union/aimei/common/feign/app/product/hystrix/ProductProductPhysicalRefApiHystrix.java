package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductProductPhysicalRefFeign;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByBatchVo;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByProductIdReturnVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:19
 */
@Component(value = "app-ProductProductPhysicalRefFeign")
public class ProductProductPhysicalRefApiHystrix implements ProductProductPhysicalRefFeign {

    /**
     * 前端分页查询项目-产品-关联
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param productProductPhysicalRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductProductPhysicalRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductProductPhysicalRef productProductPhysicalRef) {
        return null;
    }

    /**
     * 添加项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @Override
    public int insert(ProductProductPhysicalRef productProductPhysicalRef) {
        return 0;
    }

    /**
     * 删除项目-产品-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @Override
    public int edit(ProductProductPhysicalRef productProductPhysicalRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductProductPhysicalRef
     */
    @Override
    public ProductProductPhysicalRef queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatch(ProductProductPhysicalRefByBatchVo productProductPhysicalRefByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductProductPhysicalRefByProductIdReturnVo>> findListByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductProductPhysicalRef> getByProductIdV111(int productId) {
        return HystrixResponse.invokeFail();
    }

}