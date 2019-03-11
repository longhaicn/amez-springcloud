package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomeAreaFeign;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 区域表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Component(value = "pc-BaseHomeAreaFeign")
public class BaseHomeAreaApiHystrix implements BaseHomeAreaFeign {

    /**
     * 前端分页查询首页区域表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param baseHomeArea 查询条件
     * @return
     */
    @Override
    public PageInfo<BaseHomeArea> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeArea baseHomeArea) {
        return null;
    }

    @Override
    public ResponseMessage insertBasehomeAreaV110(BaseHomeArea baseHomeArea) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<List<BaseHomeArea>> findForFrontV110(BaseHomeArea baseHomeArea) {
        return HystrixResponse.invokeFail ();
    }

    /**
     * 添加首页区域表
     *
     * @param baseHomeArea
     * @return
     */
    @Override
    public ResponseMessage insert(BaseHomeArea baseHomeArea) {
        return HystrixResponse.invokeFail ();
    }

    /**
     * 删除首页区域表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改首页区域表
     *
     * @param baseHomeArea
     * @return
     */
    @Override
    public int edit(BaseHomeArea baseHomeArea) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeArea
     */
    @Override
    public BaseHomeArea queryById(int id) {
        return null;
    }
}