package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.BeauticianServiceScopeFeign;
import com.union.aimei.common.model.store.BeauticianServiceScope;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 11:06
 */
@Component(value = "app-BeauticianServiceScopeFeign")
public class BeauticianServiceScopeApiHystrix implements BeauticianServiceScopeFeign {
    @Override
    public ResponseMessage addV111(BeauticianServiceScope beauticianServiceScope) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianServiceScope>> findListByBeauticianIdV111(int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage selectV111(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteV111(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modifyV111(BeauticianServiceScope beauticianServiceScope) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianServiceScope> findByIdV111(int id) {
        return HystrixResponse.invokeFail();
    }


}