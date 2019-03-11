package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.system.mapper.BaseHomeAreaMapper;
import com.union.aimei.system.service.BaseHomeAreaService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询首页区域表
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Service("baseHomeAreaService")
public class BaseHomeAreaServiceImpl implements BaseHomeAreaService {
    @Resource
    private BaseHomeAreaMapper baseHomeAreaMapper;

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
        PageHelper.startPage (pageNo, pageSize);
        List<BaseHomeArea> list = this.baseHomeAreaMapper.selectListByConditions (baseHomeArea);
        PageInfo<BaseHomeArea> page = new PageInfo<> (list);
        return page;
    }

    @Override
    public ResponseMessage<List<BaseHomeArea>> findForFrontV110(BaseHomeArea baseHomeArea) {
        ResponseMessage responseMessage = new ResponseMessage ();
        List<BaseHomeArea> list = this.baseHomeAreaMapper.selectListByConditions (baseHomeArea);
        responseMessage.setData (list);
        return responseMessage;
    }

    /**
     * 添加首页区域表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(BaseHomeArea t) {
        return this.baseHomeAreaMapper.insertSelective (t);
    }

    /**
     * 删除首页区域表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.baseHomeAreaMapper.deleteByPrimaryKey (id);
    }

    /**
     * 修改首页区域表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(BaseHomeArea t) {
        return this.baseHomeAreaMapper.updateByPrimaryKeySelective (t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeArea
     */
    @Override
    public BaseHomeArea queryObjById(int id) {
        BaseHomeArea model = this.baseHomeAreaMapper.selectByPrimaryKey (id);
        return model;
    }
}