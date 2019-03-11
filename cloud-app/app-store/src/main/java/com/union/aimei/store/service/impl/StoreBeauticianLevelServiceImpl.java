package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.aimei.store.mapper.StoreBeauticianLevelMapper;
import com.union.aimei.store.service.StoreBeauticianLevelService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:41
 */
@Service("storeBeauticianLevelService")
public class StoreBeauticianLevelServiceImpl implements StoreBeauticianLevelService {
    @Resource
    private StoreBeauticianLevelMapper storeBeauticianLevelMapper;

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianLevel>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevel storeBeauticianLevel) {
        ResponseMessage<PageInfo<StoreBeauticianLevel>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBeauticianLevel> list = this.storeBeauticianLevelMapper.selectListByConditions(storeBeauticianLevel);
        PageInfo<StoreBeauticianLevel> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加美容师等级
     *
     * @param storeBeauticianLevel
     * @return
     */
    @Override
    public int addObj(StoreBeauticianLevel storeBeauticianLevel) {
        return this.storeBeauticianLevelMapper.insertSelective(storeBeauticianLevel);
    }

    /**
     * 删除美容师等级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBeauticianLevelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改美容师等级
     *
     * @param storeBeauticianLevel
     * @return
     */
    @Override
    public int modifyObj(StoreBeauticianLevel storeBeauticianLevel) {
        return this.storeBeauticianLevelMapper.updateByPrimaryKeySelective(storeBeauticianLevel);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevel
     */
    @Override
    public StoreBeauticianLevel queryObjById(int id) {
        StoreBeauticianLevel model = this.storeBeauticianLevelMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<List<StoreBeauticianLevel>> findListByAll() {
        ResponseMessage<List<StoreBeauticianLevel>> responseMessage = new ResponseMessage<>();
        StoreBeauticianLevel storeBeauticianLevelCond = new StoreBeauticianLevel();
        storeBeauticianLevelCond.setIsEnabled(true);
        List<StoreBeauticianLevel> storeBeauticianLevelList = this.storeBeauticianLevelMapper.selectListByConditions(storeBeauticianLevelCond);
        storeBeauticianLevelList = storeBeauticianLevelList.stream().sorted(Comparator.comparing(StoreBeauticianLevel::getSort)).collect(Collectors.toList());
        responseMessage.setData(storeBeauticianLevelList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeauticianLevel> getLevelBySetionGrowup(Integer growup) {
        return new ResponseMessage<>(this.storeBeauticianLevelMapper.getLevelBySetionGrowup(growup));
    }
}