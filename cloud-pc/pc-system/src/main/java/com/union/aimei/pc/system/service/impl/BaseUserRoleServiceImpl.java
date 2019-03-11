package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRole;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.aimei.common.model.system.BaseUserRoleExample;
import com.union.aimei.pc.system.mapper.BaseRoleMapper;
import com.union.aimei.pc.system.mapper.BaseUserRoleMapper;
import com.union.aimei.pc.system.service.BaseUserRoleService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufeihua
 */
@Service
public class BaseUserRoleServiceImpl implements BaseUserRoleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseUserRoleMapper baseUserRoleMapper;

    @Autowired(required = false)
    private BaseRoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Integer rightId) {
        return this.baseUserRoleMapper.deleteByPrimaryKey(rightId);
    }

    @Override
    public int insertSelective(BaseUserRole record) {
        return this.baseUserRoleMapper.insertSelective(record);
    }

    @Override
    public BaseUserRole selectByPrimaryKey(Integer rightId) {
        return this.baseUserRoleMapper.selectByPrimaryKey(rightId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUserRole record) {
        return this.baseUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseUserRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseUserRole record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseUserRoleMapper.selectListByConditions(record));
    }

    /**
     * param:userId 用户id
     * param:roleIds 角色id数组
     * describe: 给用户分配角色
     * create_by: liufeihua in 2017/12/11 10:28
     */
    @Override
    public ResponseMessage<String> distributionBaseUserRole(Integer userId, String roleIds) {

        AssertUtil.notNull(userId, "用户id不能为空!");

        String[] ids = roleIds.split(",");

        //1.先清除用户的所有角色关糸
        BaseUserRoleExample baseUserRoleExample = new BaseUserRoleExample();
        BaseUserRoleExample.Criteria criteria = baseUserRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        int deleteByExample = baseUserRoleMapper.deleteByExample(baseUserRoleExample);
        AssertUtil.isTrue(deleteByExample >= 0, "分配角色失败");

        //2.重新添加用户的角色关糸
        for (String id : ids) {
            BaseUserRole userRole = new BaseUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(Integer.parseInt(id));
            int insertSelective = baseUserRoleMapper.insertSelective(userRole);
            AssertUtil.isTrue(insertSelective >= 0, "分配角色失败");
        }

        return new ResponseMessage<>();
    }

    /**
     * @param userId 用户id
     * @return
     */
    @Override
    public ResponseMessage<Map<String, Object>> findBaseUserRoles(Integer userId) {
        //查询全部的角色
        List<BaseRole> baseRoles = roleMapper.selectListByConditions(null);

        //查询已分配的角色
        BaseUserRole userRole = new BaseUserRole();
        userRole.setUserId(userId);
        List<BaseUserRole> baseUserRoles = baseUserRoleMapper.selectListByConditions(userRole);

        //返回的已分配的
        List<BaseRole> baseRolesUsed = new ArrayList<>(10);

        //去除已分配的角色
        if (baseUserRoles.size() > 0) {
            for (BaseUserRole role : baseUserRoles) {
                if (baseRoles.size() > 0) {
                    for (BaseRole baseRole : baseRoles) {
                        if (baseRole.getRoleId().equals(role.getRoleId())) {
                            baseRolesUsed.add(baseRole);
                        }
                    }
                }
            }
        }

        baseRoles.removeAll(baseRolesUsed);
        Map<String, Object> response = new HashMap<>(2);
        response.put("all", baseRoles);
        response.put("used", baseRolesUsed);

        return new ResponseMessage<>(response);
    }
}