package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseNotificationNoticeFeign;
import com.union.aimei.common.model.system.BaseNotificationNotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseNotificationNoticeFeign")
public class BaseNotificationNoticeHystrix implements BaseNotificationNoticeFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insertSelective(BaseNotificationNotice record) {
        return 0;
    }

    @Override
    public BaseNotificationNotice selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseNotificationNotice record) {
        return 0;
    }

    @Override
    public PageInfo<BaseNotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, BaseNotificationNotice record) {
        return null;
    }
}