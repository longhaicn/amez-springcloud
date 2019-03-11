package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseRegionFeign;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-BaseRegionFeign")
public class BaseRegionHystrix implements BaseRegionFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer regionId) {
        return 1;
    }

    @Override
    public int insertSelective(BaseRegion record) {
        return 1;
    }

    @Override
    public BaseRegion selectByPrimaryKey(Integer regionId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRegion record) {
        return 1;
    }

    @Override
    public PageInfo<BaseRegion> selectListByConditions(Integer pageNo, Integer pageSize, BaseRegion record) {
        return null;
    }

    @Override
    public List<BaseRegion> findListByConditions() {
        return null;
    }

    @Override
    public ResponseMessage<BaseRegionIdByNameResVo> getNameByIdV111(BaseRegionIdByNameVo nameVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BaseRegion>> listAreaByCityIdV111(int cityId) {
        return HystrixResponse.invokeFail();
    }
}