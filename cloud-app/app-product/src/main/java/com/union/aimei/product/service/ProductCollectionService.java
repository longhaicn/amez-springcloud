package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.product.app.ProductCollectionResultVo;
import com.union.aimei.common.vo.product.app.ProductCollectionVo;
import com.union.common.utils.ResponseMessage;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:08
 */
public interface ProductCollectionService {

    /**
     * 根据用户id查询该用户所收藏的项目
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param productCollectionVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductCollectionResultVo>> selectListPageCollectionByMemberId(Integer pageNo, Integer pageSize, ProductCollectionVo productCollectionVo);

    /**
     * 项目收藏
     *
     * @param productId    项目ID
     * @param memberId     会员ID
     * @param isCollection 是否收藏，1-是，0-否
     * @return
     */
    ResponseMessage<ProductCollection> collection(int productId, int memberId, boolean isCollection);

    /**
     * 是否收藏
     *
     * @param productId 项目ID
     * @param memberId  会员ID
     * @return
     */
    ResponseMessage<Boolean> isCollection(int productId, int memberId);

}