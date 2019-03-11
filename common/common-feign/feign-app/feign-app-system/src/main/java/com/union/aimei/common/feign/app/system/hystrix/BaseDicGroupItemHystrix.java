package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseDicGroupItemFeign;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author dell
 */
@Component(value = "app-BaseDicGroupItemFeign")
public class BaseDicGroupItemHystrix implements BaseDicGroupItemFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseDicGroupItem record) {
        return 1;
    }

    @Override
    public BaseDicGroupItem selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDicGroupItem record) {
        return 1;
    }

    @Override
    public PageInfo<BaseDicGroupItem> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroupItem record) {
        return null;
    }

    /**
     * describe: 查询
     * create_by: liufeihua in 2017/11/29 16:22
     *
     * @param bandCode
     */
    @Override
    public List<BaseDicGroupItem> findListByCode(String bandCode) {
        return null;
    }
}