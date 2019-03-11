package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.system.SystemConstant;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.aimei.system.mapper.BaseDicGroupItemMapper;
import com.union.aimei.system.mapper.BaseDicGroupMapper;
import com.union.aimei.system.service.BaseDicGroupService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author liufeihua
 */
@Service
public class BaseDicGroupServiceImpl implements BaseDicGroupService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BaseDicGroupItemMapper baseDicGroupItemMapper;

    @Autowired(required = false)
    private BaseDicGroupMapper baseDicGroupMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseDicGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseDicGroup record) {
        return this.baseDicGroupMapper.insertSelective(record);
    }

    @Override
    public BaseDicGroup selectByPrimaryKey(Integer id) {
        return this.baseDicGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDicGroup record) {
        return this.baseDicGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseDicGroup> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroup record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseDicGroupMapper.selectListByConditions(record));
    }

    @Override
    public ResponseMessage<BaseDicGroupDeatilResVo> detailByCodeV111(String code) {
        ResponseMessage<BaseDicGroupDeatilResVo> responseMessage = new ResponseMessage<>();
        // 数据字典
        BaseDicGroup dicGroup = this.baseDicGroupMapper.getByCode(code);
        if (null == dicGroup) {
            throw new ResponseException(SystemConstant.DIC_GROUP_NULL, SystemConstant.DIC_GROUP_NULL_MSG);
        }
        // 数据字典子项
        List<BaseDicGroupItem> itemList = this.baseDicGroupItemMapper.listByGroupId(dicGroup.getId());
        if (CollectionUtils.isEmpty(itemList)) {
            throw new ResponseException(SystemConstant.DIC_GROUP_ITEM_NULL, SystemConstant.DIC_GROUP_ITEM_NULL_MSG);
        }
        BaseDicGroupDeatilResVo resVo = new BaseDicGroupDeatilResVo();
        resVo.setDicGroup(dicGroup);
        resVo.setItemList(itemList);
        responseMessage.setData(resVo);
        return responseMessage;
    }

}