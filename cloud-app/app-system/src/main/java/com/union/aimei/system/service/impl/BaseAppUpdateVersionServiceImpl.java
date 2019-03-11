package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.common.model.system.BaseAppUpdateVersionExample;
import com.union.aimei.common.vo.system.BaseAppUpdateVersionVo;
import com.union.aimei.system.mapper.BaseAppUpdateVersionMapper;
import com.union.aimei.system.service.BaseAppUpdateVersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@Service
public class BaseAppUpdateVersionServiceImpl implements BaseAppUpdateVersionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseAppUpdateVersionMapper baseAppUpdateVersionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseAppUpdateVersionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseAppUpdateVersion record) {
        record.setCreateTime(new Date());
        return this.baseAppUpdateVersionMapper.insertSelective(record);
    }

    @Override
    public BaseAppUpdateVersion selectByPrimaryKey(Integer id) {
        return this.baseAppUpdateVersionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseAppUpdateVersion record) {
        record.setUpdateTime(new Date());
        return this.baseAppUpdateVersionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseAppUpdateVersion> selectListByConditions(Integer pageNo, Integer pageSize, BaseAppUpdateVersion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseAppUpdateVersionMapper.selectListByConditions(record));
    }

    @Override
    public BaseAppUpdateVersionVo forAndroidUpdateVersion(Integer clientType) {
        BaseAppUpdateVersionExample e = new BaseAppUpdateVersionExample();
        e.setOrderByClause("update_time desc");
        BaseAppUpdateVersionExample.Criteria criteria = e.createCriteria();
        criteria.andAppSystemTypeEqualTo(1);
        criteria.andAppClientTypeEqualTo(clientType);

        List<BaseAppUpdateVersion> baseAppUpdateVersions = baseAppUpdateVersionMapper.selectByExample(e);

        BaseAppUpdateVersion b = baseAppUpdateVersions.get(0);

        BaseAppUpdateVersionVo vo = new BaseAppUpdateVersionVo();
        vo.setVersionCode(b.getVersionCode());
        vo.setVersionName(b.getVersionName());
        vo.setUpdateUrl(b.getUpdateUrl());
        vo.setUpdateContent(b.getUpdateContent());
        vo.setMd5(b.getMd5());
        vo.setForced(b.getForced() == 1);
        vo.setIgnore(b.getIgnoreUpdate() == 1);
        return vo;
    }
}