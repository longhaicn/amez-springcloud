package com.union.aimei.pc.system.async;

import com.union.aimei.common.constant.system.BaseHomeTemplateConstant;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.util.system.BaseHomeTemplateUtil;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.aimei.pc.system.service.BaseHomeAreaService;
import com.union.aimei.pc.system.service.BaseHomeFloorService;
import com.union.aimei.pc.system.service.BaseHomeTemplateService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.exception.ServerException;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 首页模版数据异步保存类
 *
 * @author caizhaoming
 * @create 2018-08-16 17:37
 **/
@Lazy
@Component
public class BaseHomeTemplateDateAsyncTask {

    @Resource
    private BaseHomeTemplateService baseHomeTemplateService;

    @Resource
    private BaseHomeFloorService baseHomeFloorService;

    @Resource
    private BaseHomeAreaService baseHomeAreaService;

    @Resource
    private BaseHomeTemplateUtil baseHomeTemplateUtil;


    /**
     * 异步查询所有城市数据保存到redis
     */
    @Async
    public void saveBaseHomeTemplateByRedis() {
        //查询所有城市集合
        BaseHomeArea baseHomeArea = new BaseHomeArea();
        baseHomeArea.setIsEnabled(BaseHomeArea.IS_ENABLED_TURE);
        baseHomeArea.setDataType(BaseHomeArea.DATA_TYPE_BASE);
        ResponseMessage<List<BaseHomeArea>> responseMessage = this.baseHomeAreaService.findForFrontV110(baseHomeArea);
        ResponseUtil.isFailThrowException(responseMessage);
        SelectBaseHomeTemplateVo selectBaseHomeTemplateVo = new SelectBaseHomeTemplateVo();
        BaseHomeArea baseHomeArea1 = new BaseHomeArea();
        responseMessage.getData().forEach(x -> {
            //保存
            baseHomeArea1.setCityId(x.getCityId());
            selectBaseHomeTemplateVo.setBaseHomeArea(baseHomeArea1);
            selectBaseHomeTemplateVo.setUseType(SelectBaseHomeTemplateVo.USER_TYPE_USER);
            this.saveBaseHomeTemplateByCityIdAndUseTypeFromRedis(selectBaseHomeTemplateVo);
        });
    }

    /**
     * 根据城市id，使用类型异步查询 首页基础 数据保存到redis
     *
     * @param selectBaseHomeTemplateVo
     */
    @Async
    public void saveBaseHomeTemplateByCityIdAndUseTypeFromRedis(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        BaseHomeArea baseHomeArea = selectBaseHomeTemplateVo.getBaseHomeArea();
        BaseHomeTemplateVo baseHomeTemplateVo = new BaseHomeTemplateVo();
        BaseHomeTemplate baseHomeTemplate = new BaseHomeTemplate();
        BaseHomeFloor baseHomeFloor = new BaseHomeFloor();
        //帮女郎 和 门店端
        if (SelectBaseHomeTemplateVo.USER_TYPE_USER != selectBaseHomeTemplateVo.getUseType()) {
            //获取基础模版的数据
            baseHomeTemplate.setUseType(selectBaseHomeTemplateVo.getUseType());
            baseHomeTemplate.setIsEnabled(BaseHomeTemplate.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeTemplate>> responseMessageBaseHomeTemplate = this.baseHomeTemplateService.findForFrontV110(baseHomeTemplate);
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
            if (null == baseHomeAreaList || baseHomeAreaList.size() == 0) {
                throw new ServerException(BaseHomeTemplateConstant.Query.NOT_TEMPALTE_CODE, BaseHomeTemplateConstant.Query.NOT_TEMPALTE_MESSAGE);
            }
            baseHomeTemplateVo.setBaseHomeArea(baseHomeAreaList.get(0));
            //获取基础模版的数据
            baseHomeTemplate.setAreaId(baseHomeTemplateVo.getBaseHomeArea().getId());
            baseHomeTemplate.setUseType(selectBaseHomeTemplateVo.getUseType());
            baseHomeTemplate.setIsEnabled(BaseHomeTemplate.IS_ENABLED_TURE);
            ResponseMessage<List<BaseHomeTemplate>> responseMessageBaseHomeTemplate = this.baseHomeTemplateService.findForFrontV110(baseHomeTemplate);
            ResponseUtil.isFailThrowException(responseMessageBaseHomeTemplate);
            List<BaseHomeTemplate> baseHomeTemplateList = responseMessageBaseHomeTemplate.getData();
            //判断是否有导航栏数据，有的话需要获取产品分类的图片
            this.baseHomeTemplateService.setProductCategoryDate(baseHomeTemplateList);
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
        //保存到redis
        this.baseHomeTemplateUtil.saveBaseHomeTemplateByRedis(selectBaseHomeTemplateVo.getUseType(), baseHomeTemplateRo, baseHomeTemplateVo.getBaseHomeArea() == null ? null : baseHomeTemplateVo.getBaseHomeArea().getCityId());
    }


    /**
     * 根据城市id，使用类型异步查询 首页楼层 数据保存的mongo
     *
     * @param cityId
     */
    @Async
    public void saveBaseHomeFloorDataByCityIdAndUserTypeFromMongo(List<BaseHomeFloorPageVo> baseHomeFloorPageVoList, Integer cityId) {
        List<BaseHomeFloorPageRo> baseHomeFloorPageRoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(baseHomeFloorPageVoList)) {
            baseHomeFloorPageVoList.forEach(x -> {
                //vo转ro 并保存到mongo
                BaseHomeFloorPageRo baseHomeFloorPageRo = BaseHomeTemplateUtil.packedToRo(x);
                baseHomeFloorPageRoList.add(baseHomeFloorPageRo);
            });
            this.baseHomeTemplateUtil.saveBaseHomeFloorDataByMongo(baseHomeFloorPageRoList, cityId);
        }
    }

}
