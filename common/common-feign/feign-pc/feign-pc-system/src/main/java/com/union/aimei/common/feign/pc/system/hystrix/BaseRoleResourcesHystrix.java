package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseRoleResourcesFeign;
import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseRoleResourcesFeign")
public class BaseRoleResourcesHystrix implements BaseRoleResourcesFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseRoleResources record) {
        return 1;
    }

    @Override
    public BaseRoleResources selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRoleResources record) {
        return 1;
    }

    @Override
    public PageInfo<BaseRoleResources> selectListByConditions(Integer pageNo, Integer pageSize, BaseRoleResources record) {
        return null;
    }

    @Override
    public ResponseMessage<String> distributionBaseRoleResources(Integer roleId, String resourcesIds) {
        return null;
    }
}