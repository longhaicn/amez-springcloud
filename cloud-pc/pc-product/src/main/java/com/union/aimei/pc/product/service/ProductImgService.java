package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.common.vo.product.pc.ProductImgByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/5 19:34
 */
public interface ProductImgService extends SpringCloudBaseService<ProductImg> {
    /**
     * 前端分页查询商品图片
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param productImg 查询条件
     * @return
     */
    PageInfo<ProductImg> findByPageForFront(Integer pageNo, Integer pageSize, ProductImg productImg);

    /**
     * 根据商品ID删除商品图片
     *
     * @param productId 商品ID
     * @return
     */
    ResponseMessage deleteByProductId(int productId);

    /**
     * 批量新增商品图片
     *
     * @param batchVo 批量商品图片
     * @return
     */
    ResponseMessage addBatch(ProductImgByBatchVo batchVo);

    /**
     * 新增商品图片
     *
     * @param productImg 商品图片
     * @return
     */
    ResponseMessage add(ProductImg productImg);

}