package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.system.BaseHomeTemplateCodeConstant;
import com.union.aimei.common.constant.system.BaseHomeTemplateNameConstant;
import com.union.aimei.common.feign.pc.product.ProductCategoryFeign;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.util.system.BaseHomeTemplateUtil;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.aimei.pc.system.async.BaseHomeTemplateDateAsyncTask;
import com.union.aimei.pc.system.mapper.BaseHomeAreaMapper;
import com.union.aimei.pc.system.mapper.BaseHomeTemplateMapper;
import com.union.aimei.pc.system.service.BaseHomeAreaService;
import com.union.aimei.pc.system.service.BaseHomeFloorService;
import com.union.aimei.pc.system.service.BaseHomeTemplateService;
import com.union.aimei.pc.system.utils.Constant;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import lombok.Data;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:25
 */
@Data
@Service("baseHomeTemplateService")
public class BaseHomeTemplateServiceImpl implements BaseHomeTemplateService {

    @Resource
    private BaseHomeTemplateMapper baseHomeTemplateMapper;

    @Resource
    private BaseHomeAreaMapper baseHomeAreaMapper;

    @Resource
    private BaseHomeAreaService baseHomeAreaService;

    @Resource
    private BaseHomeFloorService baseHomeFloorService;

    @Resource
    private ProductCategoryFeign productCategoryFeign;

    @Resource
    private BaseHomeTemplateDateAsyncTask baseHomeTemplateDateAsyncTask;

    /**
     * 前端分页查询首页模板
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseHomeTemplate 查询条件
     * @return
     */
    @Override
    public PageInfo<BaseHomeTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeTemplate baseHomeTemplate) {
        PageHelper.startPage(pageNo, pageSize);
        List<BaseHomeTemplate> list = this.baseHomeTemplateMapper.selectListByConditions(baseHomeTemplate);
        PageInfo<BaseHomeTemplate> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @Override
    public int addObj(BaseHomeTemplate baseHomeTemplate) {
        return this.baseHomeTemplateMapper.insertSelective(baseHomeTemplate);
    }

    /**
     * 删除首页模板
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.baseHomeTemplateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @Override
    public int modifyObj(BaseHomeTemplate baseHomeTemplate) {
        return this.baseHomeTemplateMapper.updateByPrimaryKeySelective(baseHomeTemplate);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeTemplate
     */
    @Override
    public BaseHomeTemplate queryObjById(int id) {
        BaseHomeTemplate model = this.baseHomeTemplateMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        BaseHomeTemplate baseHomeTemplate = new BaseHomeTemplate();
        baseHomeTemplate.setId(id);
        baseHomeTemplate.setIsEnabled(Constant.YES_INT == isEnabled ? true : false);
        this.baseHomeTemplateMapper.updateByPrimaryKeySelective(baseHomeTemplate);
        return responseMessage;

    }

    @Override
    public ResponseMessage addBatchV110(List<BaseHomeTemplate> baseHomeTemplateList) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.baseHomeTemplateMapper.addBatch(baseHomeTemplateList);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteByAreaIdV110(Integer areaId) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.baseHomeTemplateMapper.deleteByAreaId(areaId);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteByUseTypeIdV110(Integer useType) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.baseHomeTemplateMapper.deleteByUseTypeId(useType);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<BaseHomeTemplate> list = this.baseHomeTemplateMapper.selectListByConditions(baseHomeTemplate);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        ResponseMessage<BaseHomeTemplateVo> responseMessage = new ResponseMessage();
        BaseHomeArea baseHomeArea = selectBaseHomeTemplateVo.getBaseHomeArea();
        BaseHomeTemplateVo baseHomeTemplateVo = new BaseHomeTemplateVo();
        BaseHomeTemplate baseHomeTemplate = new BaseHomeTemplate();
        BaseHomeFloor baseHomeFloor = new BaseHomeFloor();
        //帮女郎 和 门店端
        if (SelectBaseHomeTemplateVo.USER_TYPE_USER != selectBaseHomeTemplateVo.getUseType()) {
            //获取基础模版的数据
            baseHomeTemplate.setUseType(selectBaseHomeTemplateVo.getUseType());
            baseHomeTemplate.setIsEnabled(BaseHomeTemplate.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeTemplate>> responseMessageBaseHomeTemplate = this.findForFrontV110(baseHomeTemplate);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeTemplate);
            baseHomeTemplateVo.setBaseHomeTemplateList(responseMessageBaseHomeTemplate.getData());
        } else {
            //用户端
            //获取区域的数据
            baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
            baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_BASE);
            ResponseMessage<List<BaseHomeArea>> responseMessageBaseHomeArea = this.baseHomeAreaService.findForFrontV110(baseHomeArea);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeArea);
            //判断是否有设置过城市的数据
            List<BaseHomeArea> baseHomeAreaList = responseMessageBaseHomeArea.getData();
            if (null == baseHomeAreaList || baseHomeAreaList.size() == 0) {
                BaseHomeTemplateVo baseHomeTemplateVoResult = new BaseHomeTemplateVo();
                baseHomeTemplateVoResult.setBaseHomeArea(new BaseHomeArea());
                baseHomeTemplateVoResult.setBaseHomeFloorList(new ArrayList<BaseHomeFloor>());
                baseHomeTemplateVoResult.setBaseHomeTemplateList(new ArrayList<BaseHomeTemplate>());
                responseMessage.setData(baseHomeTemplateVoResult);
                return responseMessage;
            }
            baseHomeTemplateVo.setBaseHomeArea(baseHomeAreaList.get(0));
            //获取基础模版的数据
            baseHomeTemplate.setAreaId(baseHomeTemplateVo.getBaseHomeArea().getId());
            baseHomeTemplate.setUseType(selectBaseHomeTemplateVo.getUseType());
            baseHomeTemplate.setIsEnabled(BaseHomeTemplate.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeTemplate>> responseMessageBaseHomeTemplate = this.findForFrontV110(baseHomeTemplate);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeTemplate);
            List<BaseHomeTemplate> baseHomeTemplateList = responseMessageBaseHomeTemplate.getData();
            //判断是否有导航栏数据，有的话需要获取产品分类的图片
            this.setProductCategoryDate(baseHomeTemplateList);
            baseHomeTemplateVo.setBaseHomeTemplateList(baseHomeTemplateList);
            //获取活动楼层的数据
            baseHomeFloor.setAreaId(baseHomeTemplateVo.getBaseHomeArea().getId());
            baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_ACTIVE);
            baseHomeFloor.setIsEnabled(BaseHomeFloor.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeFloor>> responseMessageBaseHomeFloor = this.baseHomeFloorService.findForFrontV110(baseHomeFloor);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeFloor);
            baseHomeTemplateVo.setBaseHomeFloorList(responseMessageBaseHomeFloor.getData());
        }
        responseMessage.setData(baseHomeTemplateVo);
        return responseMessage;

    }

    @Override
    public ResponseMessage templateDateInsertUpdateV110(BaseHomeTemplateVo baseHomeTemplateVo) {
        ResponseMessage responseMessage;
        baseHomeTemplateVo.getBaseHomeArea().setId(null);
        BaseHomeArea baseHomeArea = baseHomeTemplateVo.getBaseHomeArea();
        List<BaseHomeTemplate> baseHomeTemplateList = baseHomeTemplateVo.getBaseHomeTemplateList();
        List<BaseHomeFloor> baseHomeFloorList = baseHomeTemplateVo.getBaseHomeFloorList();
        Integer areaId = null;

        //判断是否需要删除区域以及模版基础数据
        if (BaseHomeTemplateVo.USER_TYPE_USER == baseHomeTemplateVo.getUseType()) {
            baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_BASE);
            //判断是否有重复提交省市区的数据
            List<BaseHomeArea> baseHomeAreaList = this.baseHomeAreaMapper.selectListByConditions(baseHomeArea);
            baseHomeAreaList.forEach(x -> {
                this.baseHomeAreaService.deleteObjById(x.getId());
                this.deleteByAreaIdV110(x.getId());
            });
            //保存区域
            responseMessage = this.baseHomeAreaService.insertBasehomeAreaV110(baseHomeArea);
            ResponseUtil.isFailThrowException(responseMessage);
            areaId = Integer.parseInt(String.valueOf(responseMessage.getData()));
        } else if (BaseHomeTemplateVo.USER_TYPE_HELP_GIRL == baseHomeTemplateVo.getUseType() ||
                BaseHomeTemplateVo.USER_TYPE_STORE_SIDE == baseHomeTemplateVo.getUseType()) {
            this.deleteByUseTypeIdV110(baseHomeTemplateVo.getUseType());
        }

        //保存模板基础数据
        for (BaseHomeTemplate baseHomeTemplate : baseHomeTemplateList) {
            baseHomeTemplate.setAreaId(areaId);
            baseHomeTemplate.setUseType(baseHomeTemplateVo.getUseType());
            baseHomeTemplate.setTemplateCode(BaseHomeTemplateCodeConstant.getName(baseHomeTemplate.getTemplateType()));
            baseHomeTemplate.setTemplateName(BaseHomeTemplateNameConstant.getName(baseHomeTemplate.getTemplateType()));
        }
        responseMessage = this.addBatchV110(baseHomeTemplateList);
        ResponseUtil.isFailThrowException(responseMessage);

        //保存活动楼层数据
        List<BaseHomeFloor> saveFloor = new ArrayList<>(10);
        //修改活动楼层数据
        List<BaseHomeFloor> updateFloor = new ArrayList<>(10);
        if (null != baseHomeFloorList) {
            for (BaseHomeFloor baseHomeFloor : baseHomeFloorList) {
                baseHomeFloor.setAreaId(areaId);
                baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_ACTIVE);
                if (null == baseHomeFloor.getId()) {
                    saveFloor.add(baseHomeFloor);
                } else {
                    updateFloor.add(baseHomeFloor);
                }
            }
        }
        if (saveFloor.size() > 0) {
            responseMessage = this.baseHomeFloorService.addBatchV110(baseHomeFloorList);
        }
        if (updateFloor.size() > 0) {
            responseMessage = this.baseHomeFloorService.editBatchV110(baseHomeFloorList);
        }

        //重新查询app的数据保存到redis内
        SelectBaseHomeTemplateVo selectBaseHomeTemplateVo = new SelectBaseHomeTemplateVo();
        BaseHomeArea baseHomeArea1 = new BaseHomeArea();
        baseHomeArea1.setCityId(baseHomeTemplateVo.getBaseHomeArea().getCityId());
        selectBaseHomeTemplateVo.setBaseHomeArea(baseHomeArea1);
        selectBaseHomeTemplateVo.setUseType(baseHomeTemplateVo.getUseType());
        this.baseHomeTemplateDateAsyncTask.saveBaseHomeTemplateByCityIdAndUseTypeFromRedis(selectBaseHomeTemplateVo);
        return responseMessage;
    }


    /**
     * 装配商品类型的数据
     *
     * @param baseHomeTemplateList
     * @return
     */
    @Override
    public void setProductCategoryDate(List<BaseHomeTemplate> baseHomeTemplateList) {
        try {
            for (BaseHomeTemplate baseHomeTemplateFor : baseHomeTemplateList) {
                if (BaseHomeTemplate.TEMPLATE_TYPE_CODE_XX.equals(baseHomeTemplateFor.getTemplateType())) {
                    JSONArray jsonArray = JSONArray.fromObject(baseHomeTemplateFor.getTemplateContent());
                    Set<Integer> categorySet = BaseHomeTemplateUtil.getCategoryByJsonArray(jsonArray);
                    if (null != categorySet && categorySet.size() > 0) {
                        IdBatchVo idBatchVo = new IdBatchVo();
                        idBatchVo.setIdList(new ArrayList<>(categorySet));
                        ResponseMessage<List<ProductCategory>> responseMessage1 = this.productCategoryFeign.findListByIdBatchV110(idBatchVo);
                        ResponseUtil.isFailThrowException(responseMessage1);
                        JSONArray newJSONArray = BaseHomeTemplateUtil.getNewProductCategoryByJsonArray(jsonArray, responseMessage1.getData());
                        if (null != newJSONArray) {
                            baseHomeTemplateFor.setTemplateContent(newJSONArray.toString());
                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseMessage saveBaseHomeFloorDataByCityIdAnd(Integer cityId, Integer useType) {
        //异步保存数据到mongo
        SelectBaseHomeTemplateVo selectBaseHomeTemplateVo = new SelectBaseHomeTemplateVo();
        BaseHomeArea baseHomeArea = new BaseHomeArea();
        baseHomeArea.setCityId(cityId);
        selectBaseHomeTemplateVo.setUseType(Integer.parseInt(String.valueOf(BaseHomeArea.DATA_TYPE_BASE)));
        selectBaseHomeTemplateVo.setBaseHomeArea(baseHomeArea);
        ResponseMessage<PageInfo<BaseHomeFloorPageVo>> responseMessage1 = this.baseHomeFloorService.findPageFloorDateV110(null, null, selectBaseHomeTemplateVo);
        if (null != responseMessage1.getData()) {
            List<BaseHomeFloorPageVo> baseHomeFloorPageVoList = responseMessage1.getData().getList();
            this.baseHomeTemplateDateAsyncTask.saveBaseHomeFloorDataByCityIdAndUserTypeFromMongo(baseHomeFloorPageVoList, cityId);
        }
        return new ResponseMessage();
    }


}