package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;
import com.union.aimei.system.mapper.BaseHomepageGuidePageMapper;
import com.union.aimei.system.service.BaseHomepageGuidePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseHomepageGuidePageServiceImpl implements BaseHomepageGuidePageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseHomepageGuidePageMapper baseHomepageGuidePageMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseHomepageGuidePageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseHomepageGuidePage record) {
        return this.baseHomepageGuidePageMapper.insertSelective(record);
    }

    @Override
    public BaseHomepageGuidePage selectByPrimaryKey(Integer id) {
        return this.baseHomepageGuidePageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseHomepageGuidePage record) {
        return this.baseHomepageGuidePageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseHomepageGuidePage> selectListByConditions(Integer pageNo, Integer pageSize, BaseHomepageGuidePage record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseHomepageGuidePageMapper.selectListByConditions(record));
    }
}