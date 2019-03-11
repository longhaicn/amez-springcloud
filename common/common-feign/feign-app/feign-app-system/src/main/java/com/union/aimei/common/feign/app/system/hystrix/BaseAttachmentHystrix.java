package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseAttachmentFeign;
import com.union.aimei.common.model.system.BaseAttachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseAttachmentFeign")
public class BaseAttachmentHystrix implements BaseAttachmentFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseAttachment record) {
        return 1;
    }

    @Override
    public BaseAttachment selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseAttachment record) {
        return 1;
    }

    @Override
    public PageInfo<BaseAttachment> selectListByConditions(Integer pageNo, Integer pageSize, BaseAttachment record) {
        return null;
    }
}