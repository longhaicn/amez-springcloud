package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductCityFeign;
import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.common.vo.product.pc.ProductCityByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/26 15:07
 */
@Component(value = "pc-ProductCityFeign")
public class ProductCityApiHystrix implements ProductCityFeign {

    /**
     * 前端分页查询项目城市
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param productCity 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductCity> findByPageForFront(Integer pageNo, Integer pageSize, ProductCity productCity) {
        return null;
    }

    /**
     * 添加项目城市
     *
     * @param productCity
     * @return
     */
    @Override
    public int insert(ProductCity productCity) {
        return 0;
    }

    /**
     * 删除项目城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改项目城市
     *
     * @param productCity
     * @return
     */
    @Override
    public int edit(ProductCity productCity) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCity
     */
    @Override
    public ProductCity queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatch(ProductCityByBatchVo productCityByBatchVo) {
        return HystrixResponse.invokeFail();
    }

}