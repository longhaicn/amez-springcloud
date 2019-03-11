package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreOpenCityFeign;
import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/13 14:07
 */
@Component(value = "app-StoreOpenCityFeign")
public class StoreOpenCityApiHystrix implements StoreOpenCityFeign {

    /**
     * 前端分页查询门店开通城市
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeOpenCity 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreOpenCity> findByPageForFront(Integer pageNo, Integer pageSize, StoreOpenCity storeOpenCity) {
        return null;
    }

    /**
     * 添加门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @Override
    public int insert(StoreOpenCity storeOpenCity) {
        return 0;
    }

    /**
     * 删除门店开通城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @Override
    public int edit(StoreOpenCity storeOpenCity) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreOpenCity
     */
    @Override
    public StoreOpenCity queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreOpenCity>> listAll() {
        return HystrixResponse.invokeFail();
    }

}