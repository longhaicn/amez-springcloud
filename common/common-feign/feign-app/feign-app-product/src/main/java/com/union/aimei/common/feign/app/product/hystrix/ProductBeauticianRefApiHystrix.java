package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductBeauticianRefFeign;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.app.productbeauticianref.RemoveStoreByBeauticianIdVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:41
 */
@Component(value = "app-ProductBeauticianRefFeign")
public class ProductBeauticianRefApiHystrix implements ProductBeauticianRefFeign {

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> findByRandom(ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductBeauticianRef>> findListByOrder(StoreBeauticianByOrderVo orderVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRefByRecruitResVo>> findByPageForRecruit(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage agree(ProductBeauticianRefByAgreeVo agreeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage auth(ProductBeauticianRefByAuthVo authVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage add(ProductBeauticianRef productBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(ProductBeauticianRef productBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> findByRefIdV111(ProductBeauticianRefByRefIdVo refIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateAuditStatusV111(ProductBeauticianRef productBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteShowByIdV111(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeStoreByBeauticianIdV111(RemoveStoreByBeauticianIdVo beauticianIdVo) {
        return HystrixResponse.invokeFail();
    }

}