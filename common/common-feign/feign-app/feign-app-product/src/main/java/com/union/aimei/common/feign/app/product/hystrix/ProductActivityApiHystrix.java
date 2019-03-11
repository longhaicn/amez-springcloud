package com.union.aimei.common.feign.app.product.hystrix;

import com.union.aimei.common.feign.app.product.ProductActivityFeign;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.app.ProductActivityByDetailResVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 11:29
 */
@Component(value = "app-ProductActivityFeign")
public class ProductActivityApiHystrix implements ProductActivityFeign {

    @Override
    public ResponseMessage<List<ProductActivity>> findListBySelectV111(int cityId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductActivityByDetailResVo> detailV111(int id) {
        return HystrixResponse.invokeFail();
    }
}