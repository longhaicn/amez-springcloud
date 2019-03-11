package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.NotificationNotice;
import com.union.aimei.pc.financial.mapper.NotificationNoticeMapper;
import com.union.aimei.pc.financial.service.NotificationNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
/**
 * @author dell
 */
@Service
public class NotificationNoticeServiceImpl implements NotificationNoticeService {

    @Autowired(required = false)
    private NotificationNoticeMapper notificationNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.notificationNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(NotificationNotice record) {
        record.setPublishTime(new Date());
        record.setNoticeStatus(0);
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