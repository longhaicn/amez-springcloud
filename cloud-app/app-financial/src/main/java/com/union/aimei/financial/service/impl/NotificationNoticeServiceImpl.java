package com.union.aimei.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.NotificationNotice;
import com.union.aimei.financial.mapper.NotificationNoticeMapper;
import com.union.aimei.financial.service.NotificationNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
/**
 * @author liufeihua
 */
@Service
public class NotificationNoticeServiceImpl implements NotificationNoticeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private NotificationNoticeMapper notificationNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.notificationNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(NotificationNotice record) {
        record.setPublishTime(new Date());
        return this.notificationNoticeMapper.insertSelective(record);
    }

    @Override
    public NotificationNotice selectByPrimaryKey(Integer id) {
        return this.notificationNoticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NotificationNotice record) {
        return this.notificationNoticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<NotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, NotificationNotice record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(notificationNoticeMapper.selectListByConditions(record));
    }
}