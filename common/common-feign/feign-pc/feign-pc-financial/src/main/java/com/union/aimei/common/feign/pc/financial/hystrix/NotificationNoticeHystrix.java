package com.union.aimei.common.feign.pc.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.NotificationNoticeFeign;
import com.union.aimei.common.model.financial.NotificationNotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-NotificationNoticeFeign")
public class NotificationNoticeHystrix implements NotificationNoticeFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(NotificationNotice record) {
        return 1;
    }

    @Override
    public NotificationNotice selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(NotificationNotice record) {
        return 1;
    }

    @Override
    public PageInfo<NotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, NotificationNotice record) {
        return null;
    }
}