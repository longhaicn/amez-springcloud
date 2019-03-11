package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.pc.product.mapper.ProductImgMapper;
import com.union.aimei.pc.product.service.ProductImgService;
import com.union.aimei.common.vo.product.pc.ProductImgByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/5 19:03
 */
@Service("productImgService")
public class ProductImgServiceImpl implements ProductImgService {
    @Resource
    private ProductImgMapper productImgMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<ProductImg> list = this.productImgMapper.selectListByConditions(productImg);
        PageInfo<ProductImg> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加商品图片
     *
     * @param productImg
     * @return
     */
    @Override
    public int addObj(ProductImg t) {
        return this.productImgMapper.insertSelective(t);
    }

    /**
     * 删除商品图片
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productImgMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改商品图片
     *
     * @param productImg
     * @return
     */
    @Override
    public int modifyObj(ProductImg t) {
        return this.productImgMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductImg
     */
    @Override
    public ProductImg queryObjById(int id) {
        ProductImg model = this.productImgMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productImgMapper.deleteByProductId(productId);
        return responseMessage;
    }

    @Override
    public ResponseMessage addBatch(ProductImgByBatchVo batchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.productImgMapper.addBatch(batchVo);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage add(ProductImg productImg) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.productImgMapper.insertSelective(productImg);
        responseMessage.setData(result);
        return responseMessage;
    }

}