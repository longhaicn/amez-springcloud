package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductFeign;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.ProductByCategoryRefVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
import com.union.aimei.pc.system.mapper.BaseHomeFloorListMapper;
import com.union.aimei.pc.system.service.BaseHomeFloorListService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(Integer pageNo, Integer pageSize, Integer floorId) {
        BaseHomeFloorListVo baseHomeFloorListVo = new BaseHomeFloorListVo();
        IdBatchVo idBatchVo = new IdBatchVo();
        //获取该楼层下所有的productId
        baseHomeFloorListVo.setIsEnabled(BaseHomeFloorList.IS_ENABLED_TURE);
        baseHomeFloorListVo.setFloorId(floorId);
        List<Integer> idList = this.baseHomeFloorListMapper.findProductIdListByFront(baseHomeFloorListVo);
        if (!CollectionUtils.isEmpty(idList)) {
            idBatchVo.setIdList(idList);
            //查询未删除的项目
            ResponseMessage<List<Integer>> responseMessage = this.productFeign.findIsEnableIdListByIdBatchV110(idBatchVo);
            ResponseUtil.isFailThrowException(responseMessage);
            List<Integer> inIdList = responseMessage.getData();
            //限制只允许查询出来未删除的楼层项目
            if (0 != inIdList.size()) {
                baseHomeFloorListVo.setProductIdList(inIdList);
            }
        }
        PageHelper.startPage(pageNo, pageSize);
        List<BaseHomeFloorListVo> list = this.baseHomeFloorListMapper.findByVoPageForBaseHomeFloorListVo(baseHomeFloorListVo);
        PageInfo<BaseHomeFloorListVo> page = new PageInfo<>(list);
        if (0 != page.getList().size()) {
            List<Integer> idListPage = page.getList().stream().map(BaseHomeFloorListVo::getProductId).collect(Collectors.toList());
            if (null != idListPage && 0 != idListPage.size()) {
                //查询项目数据
                IdBatchVo idBatchVoPage = new IdBatchVo();
                idBatchVoPage.setIdList(idListPage);
                ResponseMessage<List<ProductByCategoryRefVo>> responseMessageProduct = this.productFeign.findProductCategoryRefListByIdBatchV110(idBatchVoPage);
                if (ResponseUtil.isFail(responseMessageProduct)) {
                    return (ResponseMessage) responseMessageProduct;
                }
                Map<Integer, ProductByCategoryRefVo> idMap = responseMessageProduct.getData().stream().collect(Collectors.toMap(ProductByCategoryRefVo::getId, Function.identity()));
                //插入项目名字、项目类型到集合内
                for (BaseHomeFloorListVo baseHomeFloorListVoFor : page.getList()) {
                    if (idMap.containsKey(baseHomeFloorListVoFor.getProductId())) {
                        ProductByCategoryRefVo productByCategoryRefVo = idMap.get(baseHomeFloorListVoFor.getProductId());
                        baseHomeFloorListVoFor.setProductName(productByCategoryRefVo.getServerName());
                        baseHomeFloorListVoFor.setProductClass(productByCategoryRefVo.getCategoryName());
                        baseHomeFloorListVoFor.setSalePrice(productByCategoryRefVo.getSalePrice());
                        baseHomeFloorListVoFor.setOriginalPrice(productByCategoryRefVo.getOriginalPrice());
                        baseHomeFloorListVoFor.setCoverImg(productByCategoryRefVo.getCoverImg());
                    }
                }
            }
        }
        return new ResponseMessage<>(page);
    }

    @Override
    public ResponseMessage updateByFloorIdV110(BaseHomeFloorList baseHomeFloorList) {
        ResponseMessage responseMessage = new ResponseMessage();
        int total = this.baseHomeFloorListMapper.updateByFloorId(baseHomeFloorList);
        responseMessage.setData(total);
        return responseMessage;
    }

    @Override
    public ResponseMessage addBatchV110(List<BaseHomeFloorList> list) {
        return new ResponseMessage(this.baseHomeFloorListMapper.addBatch(list));
    }

    @Override
    public ResponseMessage<List<BaseHomeFloorList>> findByFloorIdV110(Integer floorId, Integer productType) {
        BaseHomeFloorList baseHomeFloorList = new BaseHomeFloorList();
        baseHomeFloorList.setFloorId(floorId);
        baseHomeFloorList.setIsEnabled(BaseHomeFloorList.IS_ENABLED_TURE);
        baseHomeFloorList.setProductType(Byte.valueOf(String.valueOf(productType)));
        return new ResponseMessage<>(this.baseHomeFloorListMapper.selectListByConditions(baseHomeFloorList));
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