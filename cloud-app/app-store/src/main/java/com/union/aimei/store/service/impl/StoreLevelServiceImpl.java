package com.union.aimei.store.service.impl;

import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.store.mapper.StoreLevelMapper;
import com.union.aimei.store.service.StoreLevelService;
import com.union.aimei.common.vo.store.app.StoreLevelVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 14:35
 */
@Service("storeLevelService")
public class StoreLevelServiceImpl implements StoreLevelService {
    @Resource
    private StoreLevelMapper storeLevelMapper;

    @Override
    public ResponseMessage add(StoreLevelVo storeLevelVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 删除原门店级别
        this.storeLevelMapper.deleteForAll();
        // 新增新门店级别
        List<StoreLevel> storeLevelList = storeLevelVo.getStoreLevelList();
        for (StoreLevel storeLevel : storeLevelList) {
            this.storeLevelMapper.insertSelective(storeLevel);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreLevel>> findList() {
        ResponseMessage<List<StoreLevel>> responseMessage = new ResponseMessage<>();
        StoreLevel storeLevelConditions = new StoreLevel();
        List<StoreLevel> storeLevelList = this.storeLevelMapper.selectListByConditions(storeLevelConditions);
        responseMessage.setData(storeLevelList);
        return responseMessage;
    }
}