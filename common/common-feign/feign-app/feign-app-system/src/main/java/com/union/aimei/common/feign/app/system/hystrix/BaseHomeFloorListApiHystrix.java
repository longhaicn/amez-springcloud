package com.union.aimei.common.feign.app.system.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeFloorListFeign;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 楼层列表数据表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Component(value = "app-BaseHomeFloorListFeign")
public class BaseHomeFloorListApiHystrix implements BaseHomeFloorListFeign {

    /**
     * 前端分页查询楼层列表数据表
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param baseHomeFloorList 查询条件
     * @return
     */
    @Override
    public PageInfo<BaseHomeFloorList> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeFloorList baseHomeFloorList) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(Integer pageNo, Integer pageSize, BaseHomeFloorListVo baseHomeFloorListVo) {
        return HystrixResponse.invokeFail();
    }


    /**
     * 添加楼层列表数据表
     *
     * @param baseHomeFloorList
     * @return
     */
    @Override
    public int insert(BaseHomeFloorList baseHomeFloorList) {
        return 0;
    }

    /**
     * 删除楼层列表数据表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改楼层列表数据表
     *
     * @param baseHomeFloorList
     * @return
     */
    @Override
    public int edit(BaseHomeFloorList baseHomeFloorList) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeFloorList
     */
    @Override
    public BaseHomeFloorList queryById(int id) {
        return null;
    }
}