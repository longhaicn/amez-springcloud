package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianLevelFeign;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "app-StoreBeauticianLevelFeign")
public class StoreBeauticianLevelApiHystrix implements StoreBeauticianLevelFeign {

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianLevel>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevel storeBeauticianLevel) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加美容师等级
     *
     * @param storeBeauticianLevel
     * @return
     */
    @Override
    public int insert(StoreBeauticianLevel storeBeauticianLevel) {
        return 0;
    }

    /**
     * 删除美容师等级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改美容师等级
     *
     * @param storeBeauticianLevel
     * @return
     */
    @Override
    public int edit(StoreBeauticianLevel storeBeauticianLevel) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevel
     */
    @Override
    public StoreBeauticianLevel queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreBeauticianLevel>> findListByAll() {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreBeauticianLevel> getLevelBySetionGrowup(Integer growup) {
        return HystrixResponse.invokeFail();
    }

}