package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAttachment;
import com.union.aimei.system.mapper.BaseAttachmentMapper;
import com.union.aimei.system.service.BaseAttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseAttachmentServiceImpl implements BaseAttachmentService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseAttachmentMapper baseAttachmentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseAttachmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseAttachment record) {
        return this.baseAttachmentMapper.insertSelective(record);
    }

    @Override
    public BaseAttachment selectByPrimaryKey(Integer id) {
        return this.baseAttachmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseAttachment record) {
        return this.baseAttachmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseAttachment> selectListByConditions(Integer pageNo, Integer pageSize, BaseAttachment record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseAttachmentMapper.selectListByConditions(record));
    }
}