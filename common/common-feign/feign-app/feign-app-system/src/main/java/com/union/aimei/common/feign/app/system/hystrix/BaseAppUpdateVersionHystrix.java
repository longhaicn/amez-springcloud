package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseAppUpdateVersionFeign;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.common.vo.system.BaseAppUpdateVersionVo;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-BaseAppUpdateVersionFeign")
public class BaseAppUpdateVersionHystrix implements BaseAppUpdateVersionFeign {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insertSelective(BaseAppUpdateVersion record) {
        return 0;
    }

    @Override
    public BaseAppUpdateVersion selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseAppUpdateVersion record) {
        return 0;
    }

    @Override
    public PageInfo<BaseAppUpdateVersion> selectListByConditions(Integer pageNo, Integer pageSize, BaseAppUpdateVersion record) {
        return null;
    }

    @Override
    public BaseAppUpdateVersionVo forAndroidUpdateVersion(Integer clientType) {
        return null;
    }
}