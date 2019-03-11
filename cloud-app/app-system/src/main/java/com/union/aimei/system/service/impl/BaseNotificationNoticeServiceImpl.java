package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseNotificationNotice;
import com.union.aimei.system.mapper.BaseNotificationNoticeMapper;
import com.union.aimei.system.service.BaseNotificationNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseNotificationNoticeServiceImpl implements BaseNotificationNoticeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseNotificationNoticeMapper baseNotificationNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseNotificationNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseNotificationNotice record) {
        return this.baseNotificationNoticeMapper.insertSelective(record);
    }

    @Override
    public BaseNotificationNotice selectByPrimaryKey(Integer id) {
        return this.baseNotificationNoticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseNotificationNotice record) {
        return this.baseNotificationNoticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseNotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, BaseNotificationNotice record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseNotificationNoticeMapper.selectListByConditions(record));
    }
}