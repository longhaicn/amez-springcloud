package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.BeauticianGrowthValueLogFeign;
import com.union.aimei.common.model.store.BeauticianGrowthValueLog;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/6/4 13:35
 */
@Component(value = "app-BeauticianGrowthValueLogFeign")
public class BeauticianGrowthValueLogApiHystrix implements BeauticianGrowthValueLogFeign {


    @Override
    public ResponseMessage<BeauticianGrowthValueLog> saveV111(BeauticianGrowthValueLog beauticianGrowthValueLog) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianGrowthValueLog>> listByBeauticianIdV111(Integer pageNo, Integer pageSize, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

}