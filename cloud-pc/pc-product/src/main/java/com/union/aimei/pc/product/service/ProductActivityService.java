package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.pc.ProductActivityByAddVo;
import com.union.aimei.common.vo.product.pc.ProductActivityByDetailResVo;
import com.union.aimei.common.vo.product.pc.ProductActivityBySelectBatchVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 10:38
 */
public interface ProductActivityService {

    /**
     * 分页查询项目活动
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productActivity 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductActivity>> findByPageForFront(Integer pageNo, Integer pageSize, ProductActivity productActivity);

    /**
     * 查询精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<List<ProductActivity>> findListBySelect(int cityId);

    /**
     * 项目活动详情
     *
     * @param id ID
     * @return
     */
    ResponseMessage<ProductActivityByDetailResVo> detail(int id);

    /**
     * 新增项目活动
     *
     * @param addVo 新增条件
     * @return
     */
    ResponseMessage add(ProductActivityByAddVo addVo);

    /**
     * 批量精选项目活动
     *
     * @param selectBatchVo 批量精选条件
     * @return
     */
    ResponseMessage selectByBatch(ProductActivityBySelectBatchVo selectBatchVo);

}