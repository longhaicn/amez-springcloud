package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.pc.product.mapper.ProductPhysicalBeauticianRefMapper;
import com.union.aimei.pc.product.service.ProductPhysicalBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:51
 */
@Service("productPhysicalBeauticianRefService")
public class ProductPhysicalBeauticianRefServiceImpl implements ProductPhysicalBeauticianRefService {
    @Resource
    private ProductPhysicalBeauticianRefMapper productPhysicalBeauticianRefMapper;
    
    @Override
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductPhysicalBeauticianRef> list = this.productPhysicalBeauticianRefMapper.selectListByConditions(productPhysicalBeauticianRef);
        PageInfo<ProductPhysicalBeauticianRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int addObj(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefMapper.insertSelective(productPhysicalBeauticianRef);
    }

    /**
     * 删除产品-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productPhysicalBeauticianRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int modifyObj(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefMapper.updateByPrimaryKeySelective(productPhysicalBeauticianRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalBeauticianRef
     */
    @Override
    public ProductPhysicalBeauticianRef queryObjById(int id) {
        ProductPhysicalBeauticianRef model = this.productPhysicalBeauticianRefMapper.selectByPrimaryKey(id);
        return model;
    }
}