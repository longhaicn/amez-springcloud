package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.app.ProductByCategoryRefVo;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.aimei.system.mapper.BaseHomeFloorListMapper;
import com.union.aimei.system.service.BaseHomeFloorListService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 楼层列表数据表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Service("baseHomeFloorListService")
public class BaseHomeFloorListServiceImpl implements BaseHomeFloorListService {

    @Resource
    private BaseHomeFloorListMapper baseHomeFloorListMapper;

    @Resource
    private ProductFeign productFeign;

    /**
     * 前端分页查询楼层列表数据表
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param baseHomeFloorList 查询条件
     * @return
     */
    @Override
    public PageInfo<BaseHomeFloorList> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeFloorList baseHomeFloorList) {
        PageHelper.startPage(pageNo, pageSize);
        List<BaseHomeFloorList> list = this.baseHomeFloorListMapper.selectListByConditions(baseHomeFloorList);
        PageInfo<BaseHomeFloorList> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(Integer pageNo, Integer pageSize, BaseHomeFloorListVo baseHomeFloorListVo) {
        //获取该楼层的的所有id
        List<Integer> idList = this.baseHomeFloorListMapper.findProductIdListByFront(baseHomeFloorListVo);
        //获取该楼层下允许展示的商品id
        Map<Integer, ProductByCategoryRefVo> idMap = null;
        //根据idList获取允许展示的商品
        if (null != idList && idList.size() > 0) {
            IdBatchVo idBatchVo = new IdBatchVo();
            idBatchVo.setIdList(idList);
            ResponseMessage<List<com.union.aimei.common.vo.product.app.ProductByCategoryRefVo>> responseMessageProduct = this.productFeign.findProductCategoryRefListByIdBatchForStoreBeauticianV110(idBatchVo);
            ResponseUtil.isFailThrowException(responseMessageProduct);
            idMap = responseMessageProduct.getData().stream().collect(Collectors.toMap(com.union.aimei.common.vo.product.app.ProductByCategoryRefVo::getId, Function.identity()));
            if (null != idMap && idMap.size() > 0) {
                baseHomeFloorListVo.setProductIdList(new ArrayList<>(idMap.keySet()));
            }
        }
        //查询
        PageHelper.startPage(pageNo, pageSize);
        List<BaseHomeFloorListVo> list = this.baseHomeFloorListMapper.findByVoPageForFront(baseHomeFloorListVo);
        //插入项目名字、项目类型到集合内
        for (BaseHomeFloorListVo baseHomeFloorListVoEach : list) {
            if (idMap.containsKey(baseHomeFloorListVoEach.getProductId())) {
                com.union.aimei.common.vo.product.app.ProductByCategoryRefVo productByCategoryRefVo = idMap.get(baseHomeFloorListVoEach.getProductId());
                baseHomeFloorListVoEach.setProductName(productByCategoryRefVo.getServerName());
                baseHomeFloorListVoEach.setProductClass(productByCategoryRefVo.getCategoryName());
                baseHomeFloorListVoEach.setSalePrice(productByCategoryRefVo.getSalePrice());
                baseHomeFloorListVoEach.setOriginalPrice(productByCategoryRefVo.getOriginalPrice());
                baseHomeFloorListVoEach.setCoverImg(productByCategoryRefVo.getCoverImg());
                baseHomeFloorListVoEach.setIsSupportHome(productByCategoryRefVo.getIsSupportHome());
                baseHomeFloorListVoEach.setIsSupportStore(productByCategoryRefVo.getIsSupportStore());
            }
        }
        PageInfo<BaseHomeFloorListVo> page = new PageInfo<>(list);
        return new ResponseMessage<>(page);
    }

    /**
     * 添加楼层列表数据表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(BaseHomeFloorList t) {
        return this.baseHomeFloorListMapper.insertSelective(t);
    }

    /**
     * 删除楼层列表数据表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.baseHomeFloorListMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改楼层列表数据表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(BaseHomeFloorList t) {
        return this.baseHomeFloorListMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeFloorList
     */
    @Override
    public BaseHomeFloorList queryObjById(int id) {
        BaseHomeFloorList model = this.baseHomeFloorListMapper.selectByPrimaryKey(id);
        return model;
    }
}