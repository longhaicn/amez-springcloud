package com.union.aimei.common.feign.app.product.hystrix;

import com.union.aimei.common.feign.app.product.ProductImgFeign;
import com.union.aimei.common.model.product.ProductImg;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 项目图片
 *
 * @author liurenkai
 * @time 2018/2/27 14:43
 */
@Component(value = "app-ProductImgFeign")
public class ProductImgApiHystrix implements ProductImgFeign {

    @Override
    public ResponseMessage<ProductImg> findByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }
    
}