package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseUserFeign;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseUserFeign")
public class BaseUserHystrix implements BaseUserFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 1;
    }

    @Override
    public ResponseMessage<BaseUser> insertSelective(BaseUser record) {
        return null;
    }

    @Override
    public BaseUser selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUser record) {
        return 1;
    }

    @Override
    public PageInfo<BaseUser> selectListByConditions(Integer pageNo, Integer pageSize, BaseUser record) {
        return null;
    }

    /**
     * 添加老板,店长,者员工
     *
     * @param record
     * @return
     */
    @Override
    public ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(BaseUserVo record) {
        return null;
    }
}