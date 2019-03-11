package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreLevelFeign;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Component(value = "pc-StoreLevelFeign")
public class StoreLevelApiHystrix implements StoreLevelFeign {

    @Override
    public ResponseMessage<PageInfo<StoreLevel>> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevel storeLevel) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加店铺等级
     *
     * @param storeLevel
     * @return
     */
    @Override
    public int insert(StoreLevel storeLevel) {
        return 0;
    }

    /**
     * 删除店铺等级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺等级
     *
     * @param storeLevel
     * @return
     */
    @Override
    public int edit(StoreLevel storeLevel) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevel
     */
    @Override
    public StoreLevel queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage addByBatch(StoreLevelByBatchVo storeLevelByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreLevel>> findListByAll() {
        return HystrixResponse.invokeFail();
    }
}