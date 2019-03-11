package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.StoreFriendFeign;
import com.union.aimei.common.model.store.StoreFriend;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 门店朋友
 *
 * @author liurenkai
 * @time 2018/6/7 16:07
 */
@Component(value = "app-StoreFriendFeign")
public class StoreFriendApiHystrix implements StoreFriendFeign {

    @Override
    public ResponseMessage<StoreFriend> saveV111(StoreFriend storeFriend) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreFriend> getById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreFriend>> listByStoreId(int storeId) {
        return HystrixResponse.invokeFail();
    }

}