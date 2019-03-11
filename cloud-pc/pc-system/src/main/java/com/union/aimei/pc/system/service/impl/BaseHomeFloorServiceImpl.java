package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductFeign;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.util.system.BaseHomeTemplateUtil;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.ProductByCategoryRefVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.aimei.pc.system.mapper.BaseHomeAreaMapper;
import com.union.aimei.pc.system.mapper.BaseHomeFloorListMapper;
import com.union.aimei.pc.system.mapper.BaseHomeFloorMapper;
import com.union.aimei.pc.system.service.BaseHomeFloorListService;
import com.union.aimei.pc.system.service.BaseHomeFloorService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private BaseHomeFloorListMapper baseHomeFloorListMapper;

    @Resource
    private BaseHomeAreaMapper baseHomeAreaMapper;

    @Resource
    private ProductFeign productFeign;

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
    public ResponseMessage deleteByFrontV110(BaseHomeFloor baseHomeFloor) {
        ResponseMessage responseMessage = new ResponseMessage();
        int total = this.baseHomeFloorMapper.deleteByFront(baseHomeFloor);
        responseMessage.setData(total);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BaseHomeFloor>> addBatchV110(List<BaseHomeFloor> list) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.baseHomeFloorMapper.addBatch(list);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BaseHomeFloor>> findForFrontV110(BaseHomeFloor baseHomeFloor) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<BaseHomeFloor> baseHomeFloorList = this.baseHomeFloorMapper.selectListByConditions(baseHomeFloor);
        responseMessage.setData(baseHomeFloorList);
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
     * @param baseHomeFloor
     * @return
     */
    @Override
    public int modifyObj(BaseHomeFloor baseHomeFloor) {
        int resut = this.baseHomeFloorMapper.updateByPrimaryKeySelective(baseHomeFloor);
        if (BaseHomeFloor.IS_ENABLED_FALSE == baseHomeFloor.getIsEnabled()) {
            //去删除楼层绑定的商品
            BaseHomeFloorList baseHomeFloorList = new BaseHomeFloorList();
            baseHomeFloorList.setFloorId(baseHomeFloor.getId());
            baseHomeFloorList.setIsEnabled(BaseHomeFloorList.IS_ENABLED_FALSE);
            this.baseHomeFloorListService.updateByFloorIdV110(baseHomeFloorList);
        }
        return resut;
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

    @Override
    public ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(Integer pageNo, Integer pageSize, SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        //查询区域
        BaseHomeArea baseHomeArea = selectBaseHomeTemplateVo.getBaseHomeArea();
        baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
        baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_FLOOR);
        List<BaseHomeArea> baseHomeAreaList = this.baseHomeAreaMapper.selectListByConditions(baseHomeArea);
        if (null != baseHomeAreaList && baseHomeAreaList.size() > 0) {
            //查询楼层
            BaseHomeFloor baseHomeFloor = new BaseHomeFloor();
            baseHomeFloor.setAreaId(baseHomeAreaList.get(0).getId());
            baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_FLOOR);
            baseHomeFloor.setIsEnabled(BaseHomeFloor.IS_ENABLED_TURE);
            if (null != pageNo && null != pageSize) {
                PageHelper.startPage(pageNo, pageSize);
            }
            List<BaseHomeFloorPageVo> list = this.baseHomeFloorMapper.selectVoListByConditions(baseHomeFloor);
            if (null != list && list.size() > 0) {
                PageInfo<BaseHomeFloorPageVo> page = new PageInfo<>(list);
                responseMessage.setData(page);
                //查询每个楼层下对应的前6个商品
                BaseHomeFloorList baseHomeFloorList = new BaseHomeFloorList();
                for (BaseHomeFloorPageVo baseHomeFloorPageVo : list) {
                    baseHomeFloorList.setFloorId(baseHomeFloorPageVo.getId());
                    baseHomeFloorList.setIsEnabled(BaseHomeFloorList.IS_ENABLED_TURE);
                    PageHelper.startPage(0, 6);
                    List<BaseHomeFloorListVo> baseHomeFloorListVoList = this.baseHomeFloorListMapper.findByVoPageForFront(baseHomeFloorList);
                    baseHomeFloorPageVo.setBaseHomeFloorListVoList(baseHomeFloorListVoList);
                }
                //获取楼层的所有项目id
                Set<Integer> productIdSet = BaseHomeTemplateUtil.getProductIdByFloorVo(list);
                //查询项目数据
                if (null != productIdSet && productIdSet.size() > 0) {
                    IdBatchVo idBatchVo = new IdBatchVo();
                    idBatchVo.setIdList(new ArrayList<>(productIdSet));
                    ResponseMessage<List<ProductByCategoryRefVo>> responseMessageProduct = this.productFeign.findProductCategoryRefListByIdBatchV110(idBatchVo);
                    ResponseUtil.isFailThrowException(responseMessageProduct);
                    //根据商品list 设置楼层list里面所有商品的商品数据
                    BaseHomeTemplateUtil.setProductInfoByFloorPageList(list, responseMessageProduct.getData());
                }
                return responseMessage;
            }
        }
        List<BaseHomeFloorPageVo> list = new ArrayList<>(0);
        PageInfo<BaseHomeFloorPageVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BaseHomeFloor>> editBatchV110(List<BaseHomeFloor> baseHomeFloorList) {
        ResponseMessage responseMessage = new ResponseMessage();
        for (BaseHomeFloor baseHomeFloor : baseHomeFloorList) {
            this.baseHomeFloorMapper.updateByPrimaryKeySelective(baseHomeFloor);
        }
        responseMessage.setData(baseHomeFloorList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BaseHomeFloor>> floorDateInsertV110(BaseHomeFloorVo baseHomeFloorVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        BaseHomeArea baseHomeArea = baseHomeFloorVo.getBaseHomeArea();
        Integer areaId = null;
        //判断是否有重复提交省市区的数据
        baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
        baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_FLOOR);
        List<BaseHomeArea> baseHomeAreaList = this.baseHomeAreaMapper.selectListByConditions(baseHomeArea);
        if (null == baseHomeAreaList || baseHomeAreaList.size() == 0) {
            //保存区域
            areaId = this.baseHomeAreaMapper.insertSelective(baseHomeArea);
        } else {
            areaId = Integer.parseInt(String.valueOf(baseHomeAreaList.get(0).getId()));
        }
        //批量添加
        for (BaseHomeFloor baseHomeFloor : baseHomeFloorVo.getBaseHomeFloorList()) {
            baseHomeFloor.setAreaId(areaId);
            baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_FLOOR);
        }
        responseMessage = this.addBatchV110(baseHomeFloorVo.getBaseHomeFloorList());
        return responseMessage;
    }
}