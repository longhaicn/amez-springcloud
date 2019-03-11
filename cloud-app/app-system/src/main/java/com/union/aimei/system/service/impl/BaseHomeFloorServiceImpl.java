package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.aimei.system.mapper.BaseHomeAreaMapper;
import com.union.aimei.system.mapper.BaseHomeFloorMapper;
import com.union.aimei.system.service.BaseHomeFloorListService;
import com.union.aimei.system.service.BaseHomeFloorService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 楼层管理表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Service("baseHomeFloorService")
public class BaseHomeFloorServiceImpl implements BaseHomeFloorService {

    @Resource
    private BaseHomeFloorMapper baseHomeFloorMapper;

    @Resource
    private BaseHomeAreaMapper baseHomeAreaMapper;

    @Resource
    private BaseHomeFloorListService baseHomeFloorListService;

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
        PageHelper.startPage(pageNo, pageSize);
        List<BaseHomeFloor> list = this.baseHomeFloorMapper.selectListByConditions(baseHomeFloor);
        PageInfo<BaseHomeFloor> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<List<BaseHomeFloor>> findForFrontV110(BaseHomeFloor baseHomeFloor) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<BaseHomeFloor> baseHomeFloorList = this.baseHomeFloorMapper.selectListByConditions(baseHomeFloor);
        responseMessage.setData(baseHomeFloorList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(Integer pageNo, Integer pageSize, SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {

        ResponseMessage responseMessage = new ResponseMessage();
        //查询区域
        BaseHomeArea baseHomeArea = selectBaseHomeTemplateVo.getBaseHomeArea();
        baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
        baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_FLOOR);
        List<BaseHomeArea> baseHomeAreaList = this.baseHomeAreaMapper.selectListByConditions(baseHomeArea);
        if (!CollectionUtils.isEmpty(baseHomeAreaList)) {
            //查询楼层
            BaseHomeFloor baseHomeFloor = new BaseHomeFloor();
            baseHomeFloor.setAreaId(baseHomeAreaList.get(0).getId());
            baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_FLOOR);
            baseHomeFloor.setIsEnabled(BaseHomeFloor.IS_ENABLED_TURE);
            PageHelper.startPage(pageNo, pageSize);
            List<BaseHomeFloorPageVo> list = this.baseHomeFloorMapper.selectVoListByConditions(baseHomeFloor);
            BaseHomeFloorListVo baseHomeFloorListVo = new BaseHomeFloorListVo();
            for (BaseHomeFloorPageVo baseHomeFloorPageVo : list) {
                baseHomeFloorListVo.setFloorId(baseHomeFloorPageVo.getId());
                baseHomeFloorListVo.setIsEnabled(BaseHomeFloorList.IS_ENABLED_TURE);
                ResponseMessage<PageInfo<BaseHomeFloorListVo>> responseMessage1 = this.baseHomeFloorListService.findByVoPageForFrontV110(0, 6, baseHomeFloorListVo);
                ResponseUtil.isFailThrowException(responseMessage1);
                if (null != responseMessage1.getData() && responseMessage1.getData().getList().size() > 0) {
                    baseHomeFloorPageVo.setBaseHomeFloorListVoList(responseMessage1.getData().getList());
                }
            }
            PageInfo<BaseHomeFloorPageVo> page = new PageInfo<>(list);
            responseMessage.setData(page);
        } else {
            List<BaseHomeFloorPageVo> list = new ArrayList<>(0);
            PageInfo<BaseHomeFloorPageVo> page = new PageInfo<>(list);
            responseMessage.setData(page);
        }
        return responseMessage;
    }



    /**
     * 添加楼层管理表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(BaseHomeFloor t) {
        return this.baseHomeFloorMapper.insertSelective(t);
    }

    /**
     * 删除楼层管理表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.baseHomeFloorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改楼层管理表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(BaseHomeFloor t) {
        return this.baseHomeFloorMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeFloor
     */
    @Override
    public BaseHomeFloor queryObjById(int id) {
        BaseHomeFloor model = this.baseHomeFloorMapper.selectByPrimaryKey(id);
        return model;
    }
}