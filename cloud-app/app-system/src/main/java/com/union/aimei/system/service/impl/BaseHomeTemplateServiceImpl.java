package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.system.BaseHomeTemplateConstant;
import com.union.aimei.common.feign.app.product.ProductCategoryFeign;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.util.system.BaseHomeTemplateUtil;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.aimei.system.mapper.BaseHomeTemplateMapper;
import com.union.aimei.system.service.BaseHomeAreaService;
import com.union.aimei.system.service.BaseHomeFloorService;
import com.union.aimei.system.service.BaseHomeTemplateService;
import com.union.aimei.system.utils.Constant;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.exception.ServerException;
import lombok.extern.apachecommons.CommonsLog;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:25
 */
@Service("baseHomeTemplateService")
@CommonsLog
public class BaseHomeTemplateServiceImpl implements BaseHomeTemplateService {

    @Resource
    private BaseHomeTemplateMapper baseHomeTemplateMapper;

    @Resource
    private BaseHomeAreaService baseHomeAreaService;

    @Resource
    private BaseHomeFloorService baseHomeFloorService;

    @Resource
    private ProductCategoryFeign productCategoryFeign;

    @Autowired
    private BaseHomeTemplateUtil baseHomeTemplateUtil;

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
    public ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<BaseHomeTemplate> list = this.baseHomeTemplateMapper.selectListByConditions(baseHomeTemplate);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return getBaseHomeTemplateVoByRedis(selectBaseHomeTemplateVo);
    }

    @Override
    public ResponseMessage<BaseHomeTemplateRo> getTemplateDateV111(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return getBaseHomeTemplateRoByRedis(selectBaseHomeTemplateVo);
    }


    /**
     * 获取楼层基本数据
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    private ResponseMessage<BaseHomeTemplateVo> getBaseHomeTemplateVoByRedis(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        ResponseMessage<BaseHomeTemplateVo> responseMessage = new ResponseMessage();
        //先从redis拿，如果没有再去查
        BaseHomeTemplateVo baseHomeTemplateVo = null;
        if (null == baseHomeTemplateVo) {
            BaseHomeArea baseHomeArea = selectBaseHomeTemplateVo.getBaseHomeArea();
            baseHomeTemplateVo = new BaseHomeTemplateVo();
            BaseHomeTemplate baseHomeTemplate = new BaseHomeTemplate();
            BaseHomeFloor baseHomeFloor = new BaseHomeFloor();
            //帮女郎 和 门店端
            if (SelectBaseHomeTemplateVo.USER_TYPE_USER != selectBaseHomeTemplateVo.getUseType()) {
                //获取基础模版的数据
                baseHomeTemplate.setUseType(selectBaseHomeTemplateVo.getUseType());
                baseHomeTemplate.setIsEnabled(BaseHomeTemplate.IS_ENABLED_TURE);
                ResponseMessage<List<BaseHomeTemplate>> responseMessageBaseHomeTemplate = this.findForFrontV110(baseHomeTemplate);
                ResponseUtil.isFailThrowException(responseMessageBaseHomeTemplate);
                baseHomeTemplateVo.setBaseHomeTemplateMap(responseMessageBaseHomeTemplate.getData().stream().collect(Collectors.toMap(BaseHomeTemplate::getTemplateCode, Function.identity())));
            } else {
                //用户端
                //获取区域的数据
                baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_BASE);
                baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
                ResponseMessage<List<BaseHomeArea>> responseMessageBaseHomeArea = this.baseHomeAreaService.findForFrontV110(baseHomeArea);
                ResponseUtil.isFailThrowException(responseMessageBaseHomeArea);
                //判断是否有设置过城市的数据
                List<BaseHomeArea> baseHomeAreaList = responseMessageBaseHomeArea.getData();
                if (CollectionUtils.isEmpty(baseHomeAreaList)) {
                    throw new ServerException(BaseHomeTemplateConstant.Query.NOT_TEMPALTE_CODE, BaseHomeTemplateConstant.Query.NOT_TEMPALTE_MESSAGE);
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
                setProductCategoryDate(baseHomeTemplateList);
                baseHomeTemplateVo.setBaseHomeTemplateMap(responseMessageBaseHomeTemplate.getData().stream().collect(Collectors.toMap(BaseHomeTemplate::getTemplateCode, Function.identity())));
                //获取活动楼层的数据
                baseHomeFloor.setAreaId(baseHomeTemplateVo.getBaseHomeArea().getId());
                baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_ACTIVE);
                baseHomeFloor.setIsEnabled(BaseHomeFloor.IS_ENABLED_TURE);
                ResponseMessage<List<BaseHomeFloor>> responseMessageBaseHomeFloor = this.baseHomeFloorService.findForFrontV110(baseHomeFloor);
                ResponseUtil.isFailThrowException(responseMessageBaseHomeFloor);
                baseHomeTemplateVo.setBaseHomeFloorList(responseMessageBaseHomeFloor.getData());
                //重新查询app的数据保存到redis内
                //this.baseHomeTemplateUtil.saveBaseHomeTemplateByRedis(selectBaseHomeTemplateVo.getUseType(), baseHomeTemplateVo);
            }
        }
        responseMessage.setData(baseHomeTemplateVo);
        return responseMessage;
    }


    /**
     * 获取楼层基本数据ro
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    private ResponseMessage<BaseHomeTemplateRo> getBaseHomeTemplateRoByRedis(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        ResponseMessage<BaseHomeTemplateRo> responseMessage = new ResponseMessage();
        BaseHomeTemplateVo baseHomeTemplateVo = new BaseHomeTemplateVo();
        BaseHomeArea baseHomeArea = selectBaseHomeTemplateVo.getBaseHomeArea();
        BaseHomeTemplate baseHomeTemplate = new BaseHomeTemplate();
        BaseHomeFloor baseHomeFloor = new BaseHomeFloor();
        //帮女郎 和 门店端
        if (SelectBaseHomeTemplateVo.USER_TYPE_USER != selectBaseHomeTemplateVo.getUseType()) {
            //获取基础模版的数据
            baseHomeTemplate.setUseType(selectBaseHomeTemplateVo.getUseType());
            baseHomeTemplate.setIsEnabled(BaseHomeTemplate.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeTemplate>> responseMessageBaseHomeTemplate = this.findForFrontV110(baseHomeTemplate);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeTemplate);
            baseHomeTemplateVo.setBaseHomeTemplateMap(responseMessageBaseHomeTemplate.getData().stream().collect(Collectors.toMap(BaseHomeTemplate::getTemplateCode, Function.identity())));
        } else {
            //用户端
            //获取区域的数据
            baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_BASE);
            baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeArea>> responseMessageBaseHomeArea = this.baseHomeAreaService.findForFrontV110(baseHomeArea);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeArea);
            //判断是否有设置过城市的数据
            List<BaseHomeArea> baseHomeAreaList = responseMessageBaseHomeArea.getData();
            if (CollectionUtils.isEmpty(baseHomeAreaList)) {
                throw new ServerException(BaseHomeTemplateConstant.Query.NOT_TEMPALTE_CODE, BaseHomeTemplateConstant.Query.NOT_TEMPALTE_MESSAGE);
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
            setProductCategoryDate(baseHomeTemplateList);
            baseHomeTemplateVo.setBaseHomeTemplateMap(responseMessageBaseHomeTemplate.getData().stream().collect(Collectors.toMap(BaseHomeTemplate::getTemplateCode, Function.identity())));
            //获取活动楼层的数据
            baseHomeFloor.setAreaId(baseHomeTemplateVo.getBaseHomeArea().getId());
            baseHomeFloor.setFloorType(BaseHomeFloor.FLOOR_TYPE_ACTIVE);
            baseHomeFloor.setIsEnabled(BaseHomeFloor.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeFloor>> responseMessageBaseHomeFloor = this.baseHomeFloorService.findForFrontV110(baseHomeFloor);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeFloor);
            baseHomeTemplateVo.setBaseHomeFloorList(responseMessageBaseHomeFloor.getData());
        }
        //VO转RO
        BaseHomeTemplateRo baseHomeTemplateRo = BaseHomeTemplateUtil.packedToRo(baseHomeTemplateVo);
        //重新查询app的数据保存到redis内
        this.baseHomeTemplateUtil.saveBaseHomeTemplateByRedis(selectBaseHomeTemplateVo.getUseType(), baseHomeTemplateRo, baseHomeTemplateVo.getBaseHomeArea() == null ? null : baseHomeTemplateVo.getBaseHomeArea().getCityId());
        responseMessage.setData(baseHomeTemplateRo);
        return responseMessage;
    }

    /**
     * 装配商品类型的数据
     *
     * @param baseHomeTemplateList
     * @return
     */
    private void setProductCategoryDate(List<BaseHomeTemplate> baseHomeTemplateList) {
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

}