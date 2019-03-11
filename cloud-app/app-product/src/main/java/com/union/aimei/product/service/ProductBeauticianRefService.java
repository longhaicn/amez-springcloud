package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.app.productbeauticianref.RemoveStoreByBeauticianIdVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:14
 */
public interface ProductBeauticianRefService {

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef);

    /**
     * 随机查询项目-美容师-关联
     *
     * @param productBeauticianRefByRandomVo
     * @return
     */
    ResponseMessage<ProductBeauticianRef> findByRandom(ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo);

    /**
     * 分页查询项目-美容师-关联（招募）
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductBeauticianRefByRecruitResVo>> findByPageForRecruit(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef);

    /**
     * 项目-美容师-关联详情（招募）
     *
     * @param id
     * @return
     */
    ResponseMessage<ProductBeauticianRefByDetailForRecruitResVo> detailByRecruit(int id);

    /**
     * 项目-美容师-关联（同意）
     *
     * @param agreeVo
     * @return
     */
    ResponseMessage agree(ProductBeauticianRefByAgreeVo agreeVo);

    /**
     * 项目-美容师-关联（审核）
     *
     * @param authVo
     * @return
     */
    ResponseMessage auth(ProductBeauticianRefByAuthVo authVo);

    /**
     * 查询美容师（订单）
     *
     * @param orderVo
     * @return
     */
    ResponseMessage<List<ProductBeauticianRef>> findListByOrder(StoreBeauticianByOrderVo orderVo);

    /**
     * 新增项目-美容师-关联
     *
     * @param productBeauticianRef 项目-美容师-关联
     * @return
     */
    ResponseMessage add(ProductBeauticianRef productBeauticianRef);

    /**
     * 修改项目-美容师-关联
     *
     * @param productBeauticianRef 项目-美容师-关联
     * @return
     */
    ResponseMessage modify(ProductBeauticianRef productBeauticianRef);

    /**
     * 根据ID查询项目-美容师-关联
     *
     * @param id ID
     * @return
     */
    ResponseMessage<ProductBeauticianRef> findById(int id);

    /**
     * 根据关联ID查询项目-美容师-关联
     *
     * @param refIdVo 条件
     * @return
     */
    ResponseMessage<ProductBeauticianRef> findByRefIdV111(ProductBeauticianRefByRefIdVo refIdVo);

    /**
     * 更新审核状态
     *
     * @param productBeauticianRef 条件
     * @return
     */
    ResponseMessage updateAuditStatusV111(ProductBeauticianRef productBeauticianRef);

    /**
     * 根据id修改为不显示状态(V1.1.1)
     *
     * @param id
     * @return
     */
    ResponseMessage deleteShowByIdV111(Integer id);

    /**
     * 根据美容师ID删除门店项目条件
     *
     * @param beauticianIdVo 条件
     * @return
     */
    ResponseMessage removeStoreByBeauticianIdV111(RemoveStoreByBeauticianIdVo beauticianIdVo);

}