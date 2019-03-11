package com.union.aimei.common.feign.app.system.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeFloorFeign;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 楼层管理表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Component(value = "app-BaseHomeFloorFeign")
public class BaseHomeFloorApiHystrix implements BaseHomeFloorFeign {

    /**
     * 前端分页查询楼层管理表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param baseHomeFloor 查询条件
     * @return
     */
    @Override
    public PageInfo<BaseHomeFloor> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeFloor baseHomeFloor) {
        return null;
    }

    @Override
    public ResponseMessage<List<BaseHomeFloor>> findForFrontV110(BaseHomeFloor baseHomeFloor) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(Integer pageNo, Integer pageSize, SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return HystrixResponse.invokeFail ();
    }


    /**
     * 添加楼层管理表
     *
     * @param baseHomeFloor
     * @return
     */
    @Override
    public int insert(BaseHomeFloor baseHomeFloor) {
        return 0;
    }

    /**
     * 删除楼层管理表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改楼层管理表
     *
     * @param baseHomeFloor
     * @return
     */
    @Override
    public int edit(BaseHomeFloor baseHomeFloor) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeFloor
     */
    @Override
    public BaseHomeFloor queryById(int id) {
        return null;
    }
}