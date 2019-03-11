package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.StoreLevelFeign;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.app.StoreLevelVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 16:06
 */
@Component(value = "app-StoreLevelFeign")
public class StoreLevelApiHystrix implements StoreLevelFeign {

    @Override
    public ResponseMessage add(StoreLevelVo storeLevelVo) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreLevel>> findList() {
        return null;
    }
}