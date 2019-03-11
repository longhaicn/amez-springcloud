package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.product.app.ProductCollectionResultVo;
import com.union.aimei.common.vo.product.app.ProductCollectionVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:06
 */
public interface ProductCollectionMapper extends BaseMapper<ProductCollection> {

    /**
     * 根据用户id查询该用户所收藏的项目
     *
     * @param productCollectionVo 条件
     * @return
     */
    List<ProductCollectionResultVo> selectListPageCollectionByMemberId(ProductCollectionVo productCollectionVo);

    /**
     * 是否收藏
     *
     * @param condMap 条件
     * @return
     */
    boolean isCollection(Map<String, Object> condMap);

    /**
     * 根据会员id 跟 服务id查询数据
     *
     * @param productCollection
     * @return
     */
    List<ProductCollection> selectListByMemberIdProductId(ProductCollection productCollection);

}