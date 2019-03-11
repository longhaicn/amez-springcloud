package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseOfficialDocumentsFeign;
import com.union.aimei.common.model.system.BaseOfficialDocuments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-BaseOfficialDocumentsFeign")
public class BaseOfficialDocumentsHystrix implements BaseOfficialDocumentsFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseOfficialDocuments record) {
        return 1;
    }

    @Override
    public BaseOfficialDocuments selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseOfficialDocuments record) {
        return 1;
    }

    @Override
    public PageInfo<BaseOfficialDocuments> selectListByConditions(Integer pageNo, Integer pageSize, BaseOfficialDocuments record) {
        return null;
    }
}