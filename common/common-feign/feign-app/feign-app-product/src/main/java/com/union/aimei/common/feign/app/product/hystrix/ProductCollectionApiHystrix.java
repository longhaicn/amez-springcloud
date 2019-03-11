package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductCollectionFeign;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.model.product.ProductCollectionParam;
import com.union.aimei.common.model.product.ProductCollectionResult;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:13
 */
@Component(value = "app-ProductCollectionFeign")
public class ProductCollectionApiHystrix implements ProductCollectionFeign {

    @Override
    public ResponseMessage<PageInfo<ProductCollectionResult>> selectListPageCollectionByMemberId(Integer pageNo, Integer pageSize, ProductCollectionParam productCollectionParam) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductCollection> collection(int productId, int memberId, boolean isCollection) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Boolean> isCollection(int productId, int memberId) {
        return HystrixResponse.invokeFail();
    }

}