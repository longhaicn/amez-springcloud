package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseDicGroupFeign;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseDicGroupFeign")
public class BaseDicGroupHystrix implements BaseDicGroupFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseDicGroup record) {
        return 1;
    }

    @Override
    public BaseDicGroup selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDicGroup record) {
        return 1;
    }

    @Override
    public PageInfo<BaseDicGroup> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroup record) {
        return null;
    }

    @Override
    public ResponseMessage<BaseDicGroupDeatilResVo> detailByCodeV111(String code) {
        return HystrixResponse.invokeFail();
    }

}