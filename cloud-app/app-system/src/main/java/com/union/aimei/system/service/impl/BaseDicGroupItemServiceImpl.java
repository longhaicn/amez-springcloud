package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupExample;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.model.system.BaseDicGroupItemExample;
import com.union.aimei.system.mapper.BaseDicGroupItemMapper;
import com.union.aimei.system.mapper.BaseDicGroupMapper;
import com.union.aimei.system.service.BaseDicGroupItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author liufeihua
 */
@Service
public class BaseDicGroupItemServiceImpl implements BaseDicGroupItemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseDicGroupItemMapper baseDicGroupItemMapper;

    @Autowired(required = false)
    private BaseDicGroupMapper baseDicGroupMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseDicGroupItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseDicGroupItem record) {
        return this.baseDicGroupItemMapper.insertSelective(record);
    }

    @Override
    public BaseDicGroupItem selectByPrimaryKey(Integer id) {
        return this.baseDicGroupItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDicGroupItem record) {
        return this.baseDicGroupItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseDicGroupItem> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroupItem record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseDicGroupItemMapper.selectListByConditions(record));
    }

    /**
     * 根据字典code来查询子项
     *
     * @param bandCode
     * @return
     */
    @Override
    public List<BaseDicGroupItem> findListByCode(String bandCode) {
        BaseDicGroupExample baseDicGroupExample = new BaseDicGroupExample();
        BaseDicGroupExample.Criteria criteria = baseDicGroupExample.createCriteria();
        criteria.andCodeEqualTo(bandCode);
        List<BaseDicGroup> baseDicGroups = baseDicGroupMapper.selectByExample(baseDicGroupExample);

        BaseDicGroupItemExample e = new BaseDicGroupItemExample();
        BaseDicGroupItemExample.Criteria c = e.createCriteria();
        c.andGroupIdEqualTo(baseDicGroups.get(0).getId());

        List<BaseDicGroupItem> list = baseDicGroupItemMapper.selectByExample(e);
        //PageInfo<BaseDicGroupItem> pageInfo = new PageInfo<>(list);
        return list;
    }
}