package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductImgFeign;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.common.vo.product.pc.ProductImgByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/5 19:19
 */
@Component(value = "pc-ProductImgFeign")
public class ProductImgApiHystrix implements ProductImgFeign {

    /**
     * 前端分页查询商品图片
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param productImg 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductImg> findByPageForFront(Integer pageNo, Integer pageSize, ProductImg productImg) {
        return null;
    }

    /**
     * 添加商品图片
     *
     * @param productImg
     * @return
     */
    @Override
    public int insert(ProductImg productImg) {
        return 0;
    }

    /**
     * 删除商品图片
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改商品图片
     *
     * @param productImg
     * @return
     */
    @Override
    public int edit(ProductImg productImg) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductImg
     */
    @Override
    public ProductImg queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatch(ProductImgByBatchVo productImgByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage add(ProductImg productImg) {
        return HystrixResponse.invokeFail();
    }
    
}