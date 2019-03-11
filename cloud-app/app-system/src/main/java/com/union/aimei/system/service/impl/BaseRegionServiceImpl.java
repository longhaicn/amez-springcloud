package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.system.SystemConstant;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameVo;
import com.union.aimei.system.mapper.BaseRegionMapper;
import com.union.aimei.system.service.BaseRegionService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
 */
@Service
public class BaseRegionServiceImpl implements BaseRegionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseRegionMapper baseRegionMapper;

    @Override
    public int deleteByPrimaryKey(Integer regionId) {
        return this.baseRegionMapper.deleteByPrimaryKey(regionId);
    }

    @Override
    public int insertSelective(BaseRegion record) {
        return this.baseRegionMapper.insertSelective(record);
    }

    @Override
    public BaseRegion selectByPrimaryKey(Integer regionId) {
        return this.baseRegionMapper.selectByPrimaryKey(regionId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRegion record) {
        return this.baseRegionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseRegion> selectListByConditions(Integer pageNo, Integer pageSize, BaseRegion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseRegionMapper.selectListByConditions(record));
    }

    /**
     * 一次性查询全部全球地区表
     *
     * @return
     */
    @Override
    public List<BaseRegion> findListByConditions() {

        //全部
        List<BaseRegion> baseRegions = baseRegionMapper.selectListByConditions(new BaseRegion());

        //第一级:中国的省
        List<BaseRegion> countrys = new ArrayList<>(10);
        for (BaseRegion baseRegion : baseRegions) {
            if (baseRegion.getParentId().equals(new Integer(1))) {
                countrys.add(baseRegion);
            }
        }
        //第二级:市
        for (BaseRegion country : countrys) {
            for (BaseRegion baseRegion : baseRegions) {
                if (baseRegion.getParentId().equals(country.getRegionId())) {
                    country.getChildrens().add(baseRegion);
                }
            }
        }
        //第三级:区
        for (BaseRegion country : countrys) {
            //获取每个省的市
            for (BaseRegion baseRegion : country.getChildrens()) {
                for (BaseRegion region : baseRegions) {
                    if (region.getParentId().equals(baseRegion.getRegionId())) {
                        baseRegion.getChildrens().add(region);
                    }
                }
            }
        }

        return countrys;
    }

//    /**
//            * 一次性查询全部全球地区表
//     *
//             * @return
//             */
//    @Override
//    public List<BaseRegion> findListByConditions() {
//
//        List<BaseRegion> baseRegions = baseRegionMapper.selectListByConditions(new BaseRegion());
//
//        //第一级:国
//        List<BaseRegion> countrys = new ArrayList<>(10);
//        for (BaseRegion baseRegion : baseRegions) {
//            if (baseRegion.getParentId().equals(new Integer(1))) {
//                countrys.add(baseRegion);
//            }
//        }
//        //第二级:省
//        List<BaseRegion> province = new ArrayList<>(10);
//        for (BaseRegion country : countrys) {
//            for (BaseRegion baseRegion : baseRegions) {
//                if (baseRegion.getParentId().equals(country.getRegionId())) {
//                    country.getChildrens().add(baseRegion);
//                }
//            }
//        }
//        //第三级:市
//        List<BaseRegion> city = new ArrayList<>(10);
//        for (BaseRegion country : countrys) {
//            for (BaseRegion baseRegion : country.getChildrens()) {
//                for (BaseRegion region : baseRegions) {
//                    if (region.getParentId().equals(baseRegion.getRegionId())) {
//                        baseRegion.getChildrens().add(region);
//                    }
//                }
//            }
//        }
//        //第四级:县
//        List<BaseRegion> county = new ArrayList<>(10);
//        for (BaseRegion country : countrys) {
//            for (BaseRegion baseRegion : country.getChildrens()) {
//                for (BaseRegion region : baseRegion.getChildrens()) {
//                    for (BaseRegion region4 : baseRegions) {
//                        if (region4.getParentId().equals(region.getRegionId())) {
//                            country.getChildrens().add(baseRegion);
//                        }
//                    }
//                }
//
//            }
//        }
//        return countrys;
//    }

    @Override
    public ResponseMessage<BaseRegionIdByNameResVo> getNameByIdV111(BaseRegionIdByNameVo nameVo) {
        ResponseMessage<BaseRegionIdByNameResVo> responseMessage = new ResponseMessage<>();
        BaseRegionIdByNameResVo resVo = new BaseRegionIdByNameResVo();
        // 省
        if (StringUtils.isNotEmpty(nameVo.getProvinceName())) {
            BaseRegion provinceCondition = new BaseRegion();
            provinceCondition.setRegionType(BaseRegion.RegionType.PROVINCE);
            provinceCondition.setRegionName(nameVo.getProvinceName());
            provinceCondition.setParentId(1);
            List<BaseRegion> provinceList = this.baseRegionMapper.selectListByConditions(provinceCondition);
            if (CollectionUtils.isNotEmpty(provinceList)) {
                BaseRegion provinceBaseRegion = provinceList.get(0);
                resVo.setProvinceId(provinceBaseRegion.getRegionId());
                // 市
                if (StringUtils.isNotEmpty(nameVo.getCityName())) {
                    BaseRegion cityCondition = new BaseRegion();
                    cityCondition.setRegionType(BaseRegion.RegionType.CITY);
                    cityCondition.setRegionName(nameVo.getCityName());
                    cityCondition.setParentId(provinceBaseRegion.getRegionId());
                    List<BaseRegion> cityList = this.baseRegionMapper.selectListByConditions(cityCondition);
                    if (CollectionUtils.isNotEmpty(cityList)) {
                        BaseRegion cityBaseRegion = cityList.get(0);
                        resVo.setCityId(cityBaseRegion.getRegionId());
                        // 区
                        if (StringUtils.isNotEmpty(nameVo.getAreaName())) {
                            BaseRegion areaCondition = new BaseRegion();
                            areaCondition.setRegionType(BaseRegion.RegionType.AREA);
                            areaCondition.setRegionName(nameVo.getAreaName());
                            areaCondition.setParentId(cityBaseRegion.getRegionId());
                            List<BaseRegion> areaList = this.baseRegionMapper.selectListByConditions(areaCondition);
                            if (CollectionUtils.isNotEmpty(areaList)) {
                                BaseRegion areaBaseRegion = areaList.get(0);
                                resVo.setAreaId(areaBaseRegion.getRegionId());
                            }
                        }
                    }
                }
            }
        }
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BaseRegion>> listAreaByCityIdV111(int cityId) {
        ResponseMessage<List<BaseRegion>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(2);
        condMap.put("regionType", BaseRegion.RegionType.AREA);
        condMap.put("cityId", cityId);
        List<BaseRegion> regionList = this.baseRegionMapper.listAreaByCityId(condMap);
        if (CollectionUtils.isEmpty(regionList)) {
            throw new ResponseException(SystemConstant.REGION_NULL, SystemConstant.REGION_NULL_MSG);
        }
        responseMessage.setData(regionList);
        return responseMessage;
    }

}