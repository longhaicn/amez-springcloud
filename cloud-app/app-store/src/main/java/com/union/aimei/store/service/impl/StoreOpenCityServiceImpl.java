package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.RedisConstant;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.aimei.store.mapper.StoreOpenCityMapper;
import com.union.aimei.store.service.StoreOpenCityService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.redis.RedisService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/12 19:02
 */
@Service("storeOpenCityService")
public class StoreOpenCityServiceImpl implements StoreOpenCityService {
    @Resource
    private StoreOpenCityMapper storeOpenCityMapper;
    @Resource
    private RedisService redisService;

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
        PageHelper.startPage(pageNo, pageSize);
        List<StoreOpenCity> list = this.storeOpenCityMapper.selectListByConditions(storeOpenCity);
        PageInfo<StoreOpenCity> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @Override
    public int addObj(StoreOpenCity storeOpenCity) {
        return this.storeOpenCityMapper.insertSelective(storeOpenCity);
    }

    /**
     * 删除门店开通城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeOpenCityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @Override
    public int modifyObj(StoreOpenCity storeOpenCity) {
        return this.storeOpenCityMapper.updateByPrimaryKeySelective(storeOpenCity);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreOpenCity
     */
    @Override
    public StoreOpenCity queryObjById(int id) {
        StoreOpenCity model = this.storeOpenCityMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<List<StoreOpenCity>> listAll() {
        ResponseMessage<List<StoreOpenCity>> responseMessage = new ResponseMessage<>();
        // redis
        List<StoreOpenCity> list;
        if (redisService.exists(RedisConstant.Store.STORE_OPEN_CITY)) {
            list = (List<StoreOpenCity>) redisService.get(RedisConstant.Store.STORE_OPEN_CITY);
        } else {
            list = this.storeOpenCityMapper.listAll();
            if (CollectionUtils.isEmpty(list)) {
                throw new ResponseException(StoreConstant.Query.STORE_OPEN_CITY_NULL, StoreConstant.Query.STORE_OPEN_CITY_NULL_MSG);
            }
            redisService.set(RedisConstant.Store.STORE_OPEN_CITY, list);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

}