package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductActivityFeign;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.pc.ProductActivityByAddVo;
import com.union.aimei.common.vo.product.pc.ProductActivityByDetailResVo;
import com.union.aimei.common.vo.product.pc.ProductActivityBySelectBatchVo;
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
@Component(value = "pc-ProductActivityFeign")
public class ProductActivityApiHystrix implements ProductActivityFeign {

    @Override
    public ResponseMessage<PageInfo<ProductActivity>> findByPageForFront(Integer pageNo, Integer pageSize, ProductActivity productActivity) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ProductActivity>> findListBySelect(int cityId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductActivityByDetailResVo> detail(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage add(ProductActivityByAddVo addVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage selectByBatch(ProductActivityBySelectBatchVo selectBatchVo) {
        return HystrixResponse.invokeFail();
    }
}