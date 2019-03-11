package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.pc.store.mapper.StoreLevelMapper;
import com.union.aimei.pc.store.service.StoreLevelService;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 店铺等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Service("storeLevelService")
public class StoreLevelServiceImpl implements StoreLevelService {
    @Resource
    private StoreLevelMapper storeLevelMapper;

    @Override
    public ResponseMessage<PageInfo<StoreLevel>> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevel storeLevel) {
        ResponseMessage<PageInfo<StoreLevel>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreLevel> list = this.storeLevelMapper.selectListByConditions(storeLevel);
        PageInfo<StoreLevel> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加店铺等级
     *
     * @param storeLevel
     * @return
     */
    @Override
    public int addObj(StoreLevel storeLevel) {
        return this.storeLevelMapper.insertSelective(storeLevel);
    }

    /**
     * 删除店铺等级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeLevelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺等级
     *
     * @param storeLevel
     * @return
     */
    @Override
    public int modifyObj(StoreLevel storeLevel) {
        return this.storeLevelMapper.updateByPrimaryKeySelective(storeLevel);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevel
     */
    @Override
    public StoreLevel queryObjById(int id) {
        StoreLevel model = this.storeLevelMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage addByBatch(StoreLevelByBatchVo storeLevelByBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 删除所有店铺等级
        this.storeLevelMapper.deleteByAll();
        // 批量添加店铺等级
        if (!storeLevelByBatchVo.getStoreLevelList().isEmpty()) {
            this.storeLevelMapper.addByBatch(storeLevelByBatchVo);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreLevel>> findListByAll() {
        ResponseMessage<List<StoreLevel>> responseMessage = new ResponseMessage<>();
        StoreLevel storeLevelCond = new StoreLevel();
        storeLevelCond.setIsEnabled(true);
        List<StoreLevel> storeLevelList = this.storeLevelMapper.selectListByConditions(storeLevelCond);
        storeLevelList = storeLevelList.stream().sorted(Comparator.comparing(StoreLevel::getSort)).collect(Collectors.toList());
        responseMessage.setData(storeLevelList);
        return responseMessage;
    }

}