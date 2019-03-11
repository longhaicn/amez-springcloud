package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomepageGuidePageFeign;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseHomepageGuidePageFeign")
public class BaseHomepageGuidePageHystrix implements BaseHomepageGuidePageFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseHomepageGuidePage record) {
        return 1;
    }

    @Override
    public BaseHomepageGuidePage selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseHomepageGuidePage record) {
        return 1;
    }

    @Override
    public PageInfo<BaseHomepageGuidePage> selectListByConditions(Integer pageNo, Integer pageSize, BaseHomepageGuidePage record) {
        return null;
    }
}