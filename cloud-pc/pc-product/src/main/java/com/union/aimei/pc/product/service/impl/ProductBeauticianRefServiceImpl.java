package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.*;
import com.union.aimei.pc.product.mapper.ProductBeauticianRefMapper;
import com.union.aimei.pc.product.mapper.ProductMapper;
import com.union.aimei.pc.product.service.ProductBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/26 14:58
 */
@SuppressWarnings("ALL")
@Service("productBeauticianRefService")
public class ProductBeauticianRefServiceImpl implements ProductBeauticianRefService {
    @Resource
    private ProductBeauticianRefMapper productBeauticianRefMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef) {
        ResponseMessage<PageInfo<ProductBeauticianRef>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductBeauticianRef> list = this.productBeauticianRefMapper.selectListByConditions(productBeauticianRef);
        PageInfo<ProductBeauticianRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加项目-美容师-关联
     *
     * @param productBeauticianRef
     * @return
     */
    @Override
    public int addObj(ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefMapper.insertSelective(productBeauticianRef);
    }

    /**
     * 删除项目-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productBeauticianRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改项目-美容师-关联
     *
     * @param productBeauticianRef
     * @return
     */
    @Override
    public int modifyObj(ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return productBeauticianRef
     */
    @Override
    public ProductBeauticianRef queryObjById(int id) {
        ProductBeauticianRef model = this.productBeauticianRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productBeauticianRefMapper.deleteByProductId(productId);
        return responseMessage;
    }

    @Override
    public ResponseMessage addBatch(ProductBeauticianRefByBatchVo productBeauticianRefByBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productBeauticianRefMapper.addBatch(productBeauticianRefByBatchVo.getProductBeauticianRefList());
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductBeauticianRefByDetailResVo> detail(int id) {
        ResponseMessage<ProductBeauticianRefByDetailResVo> responseMessage = new ResponseMessage<>();
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(id);
        // 商品
        Product product = this.productMapper.selectByPrimaryKey(productBeauticianRef.getProductId());
        // 结果
        ProductBeauticianRefByDetailResVo detailResVo = new ProductBeauticianRefByDetailResVo();
        detailResVo.setProductBeauticianRef(productBeauticianRef);
        detailResVo.setProduct(product);
        responseMessage.setData(detailResVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRefByResVo>> findByPage(Integer pageNo, Integer pageSize, ProductBeauticianRefVo productBeauticianRefVo) {
        ResponseMessage<PageInfo<ProductBeauticianRefByResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductBeauticianRefByResVo> list = this.productBeauticianRefMapper.selectList(productBeauticianRefVo);
        PageInfo<ProductBeauticianRefByResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage agree(ProductBeauticianRefByAgreeVo agreeVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(agreeVo.getId());
        if (productBeauticianRef == null) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
            return responseMessage;
        }
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> auth(ProductBeauticianRefByAuthVo authVo) {
        ResponseMessage<ProductBeauticianRef> responseMessage = new ResponseMessage<>();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(authVo.getId());
        if (productBeauticianRef == null) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
            return responseMessage;
        }
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        responseMessage.setData(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage beauticianStatus(ProductBeauticianRefByBeauticianStatusVo beauticianStatusVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productBeauticianRefMapper.updateByBeauticianStatus(beauticianStatusVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage coursePass(ProductBeauticianRefCoursePassVo coursePassVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<CoursePassProductVo> productList = coursePassVo.getProductList();
        if (CollectionUtils.isNotEmpty(productList)) {
            List<ProductBeauticianRef> productBeauticianRefList = new ArrayList<>(10);
            productList.forEach(product -> {
                List<Integer> beauticianIdList = new ArrayList<>(10);
                beauticianIdList.addAll(coursePassVo.getBeauticianIdList());
                // 移除重复数据
                Map<String, Object> condMap = new HashMap<>(16);
                condMap.put("productId", product.getProductId());
                condMap.put("serverType", product.getServerType());
                condMap.put("beauticianIdList", beauticianIdList);
                List<Integer> deduplicationList = this.productBeauticianRefMapper.deduplication(condMap);
                beauticianIdList.removeAll(deduplicationList);
                if (CollectionUtils.isNotEmpty(beauticianIdList)) {
                    beauticianIdList.forEach(beauticianId -> {
                        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
                        productBeauticianRef.setSponsor(ProductBeauticianRef.Sponsor.BEAUTICIAN);
                        productBeauticianRef.setProductId(product.getProductId());
                        productBeauticianRef.setBeauticianId(beauticianId);
                        productBeauticianRef.setServerType(product.getServerType());
                        productBeauticianRef.setIsRecruit(false);
                        productBeauticianRef.setAuditStatus(ProductBeauticianRef.AuditStatus.PASS);
                        productBeauticianRef.setIsSelect(true);
                        productBeauticianRef.setIsOrder(true);
                        productBeauticianRefList.add(productBeauticianRef);
                    });
                }
            });
            if (CollectionUtils.isNotEmpty(productBeauticianRefList)) {
                this.productBeauticianRefMapper.addBatch(productBeauticianRefList);
            }
        }
        return responseMessage;
    }

}