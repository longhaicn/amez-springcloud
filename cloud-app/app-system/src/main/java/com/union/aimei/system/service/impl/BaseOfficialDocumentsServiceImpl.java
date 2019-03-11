package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOfficialDocuments;
import com.union.aimei.system.mapper.BaseOfficialDocumentsMapper;
import com.union.aimei.system.service.BaseOfficialDocumentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseOfficialDocumentsServiceImpl implements BaseOfficialDocumentsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseOfficialDocumentsMapper baseOfficialDocumentsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseOfficialDocumentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseOfficialDocuments record) {
        return this.baseOfficialDocumentsMapper.insertSelective(record);
    }

    @Override
    public BaseOfficialDocuments selectByPrimaryKey(Integer id) {
        return this.baseOfficialDocumentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseOfficialDocuments record) {
        return this.baseOfficialDocumentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseOfficialDocuments> selectListByConditions(Integer pageNo, Integer pageSize, BaseOfficialDocuments record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseOfficialDocumentsMapper.selectListByConditions(record));
    }
}