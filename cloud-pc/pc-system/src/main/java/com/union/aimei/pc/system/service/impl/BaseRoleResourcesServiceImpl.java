package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.aimei.common.model.system.BaseRoleResourcesExample;
import com.union.aimei.pc.system.mapper.BaseRoleResourcesMapper;
import com.union.aimei.pc.system.service.BaseRoleResourcesService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseRoleResourcesServiceImpl implements BaseRoleResourcesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseRoleResourcesMapper baseRoleResourcesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseRoleResourcesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseRoleResources record) {
        return this.baseRoleResourcesMapper.insertSelective(record);
    }

    @Override
    public BaseRoleResources selectByPrimaryKey(Integer id) {
        return this.baseRoleResourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRoleResources record) {
        return this.baseRoleResourcesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseRoleResources> selectListByConditions(Integer pageNo, Integer pageSize, BaseRoleResources record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseRoleResourcesMapper.selectListByConditions(record));
    }

    /**
     * @param roleId       角色id
     * @param resourcesIds 权限ids数组
     *                     describe: 分配角色权限信息
     */
    @Override
    public ResponseMessage<String> distributionBaseRoleResources(Integer roleId, String resourcesIds) {
        AssertUtil.notNull(roleId, "角色id不能为空");
        AssertUtil.notNull(resourcesIds, "权限id数组不能为空");

        //1.删除角色的权限
        BaseRoleResourcesExample e = new BaseRoleResourcesExample();
        BaseRoleResourcesExample.Criteria c = e.createCriteria();
        c.andRoleIdEqualTo(roleId);
        int deleteByExample = baseRoleResourcesMapper.deleteByExample(e);
        AssertUtil.isTrue(deleteByExample >= 0, "分配权限失败");

        //2.重新添加角色的权限

        String[] ids = resourcesIds.split(",");
        for (String id : ids) {
            BaseRoleResources baseRoleResources = new BaseRoleResources();
            baseRoleResources.setRoleId(roleId);
            baseRoleResources.setMenuId(Integer.parseInt(id));
            int i = baseRoleResourcesMapper.insertSelective(baseRoleResources);
            AssertUtil.isTrue(i >= 0, "分配权限失败");
        }
        return new ResponseMessage<>();
    }
}