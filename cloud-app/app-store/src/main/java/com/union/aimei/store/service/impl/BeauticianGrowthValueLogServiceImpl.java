package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.BeauticianGrowthValueLog;
import com.union.aimei.store.mapper.BeauticianGrowthValueLogMapper;
import com.union.aimei.store.service.BeauticianGrowthValueLogService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/6/4 13:33
 */
@Service("beauticianGrowthValueLogService")
public class BeauticianGrowthValueLogServiceImpl implements BeauticianGrowthValueLogService {
    @Resource
    private BeauticianGrowthValueLogMapper beauticianGrowthValueLogMapper;

    @Override
    public ResponseMessage<BeauticianGrowthValueLog> saveV111(BeauticianGrowthValueLog beauticianGrowthValueLog) {
        ResponseMessage<BeauticianGrowthValueLog> responseMessage = new ResponseMessage<>();
        this.beauticianGrowthValueLogMapper.insertSelective(beauticianGrowthValueLog);
        responseMessage.setData(beauticianGrowthValueLog);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianGrowthValueLog>> listByBeauticianIdV111(Integer pageNo, Integer pageSize, int beauticianId) {
        ResponseMessage<PageInfo<BeauticianGrowthValueLog>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        BeauticianGrowthValueLog bgvlCond = new BeauticianGrowthValueLog();
        bgvlCond.setBeauticianId(beauticianId);
        List<BeauticianGrowthValueLog> list = this.beauticianGrowthValueLogMapper.selectListByConditions(bgvlCond);
        PageInfo<BeauticianGrowthValueLog> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

}