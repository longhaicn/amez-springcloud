package com.union.aimei.store.service.impl;

import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.app.system.BaseRegionFeign;
import com.union.aimei.common.model.store.BeauticianServiceScope;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameVo;
import com.union.aimei.store.mapper.BeauticianServiceScopeMapper;
import com.union.aimei.store.mapper.StoreBeauticianMapper;
import com.union.aimei.store.service.BeauticianServiceScopeService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 11:03
 */
@Service("beauticianServiceScopeService")
public class BeauticianServiceScopeServiceImpl implements BeauticianServiceScopeService {
    @Resource
    private BeauticianServiceScopeMapper beauticianServiceScopeMapper;
    @Resource
    private BaseRegionFeign baseRegionFeign;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;

    @Override
    public ResponseMessage addV111(BeauticianServiceScope beauticianServiceScope) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (null != beauticianServiceScope.getIsSelect() && beauticianServiceScope.getIsSelect()) {
            // 根据美容师ID取消选择
            this.beauticianServiceScopeMapper.cancelSelectByBeauticianId(beauticianServiceScope.getBeauticianId());
        }
        BaseRegionIdByNameVo nameVo = new BaseRegionIdByNameVo();
        nameVo.setProvinceName(beauticianServiceScope.getProvinceName());
        nameVo.setCityName(beauticianServiceScope.getCityName());
        nameVo.setAreaName(beauticianServiceScope.getAreaName());
        ResponseMessage<BaseRegionIdByNameResVo> baseRegionRes = this.baseRegionFeign.getNameByIdV111(nameVo);
        ResponseUtil.isFailThrowException(baseRegionRes);
        BaseRegionIdByNameResVo nameResVo = baseRegionRes.getData();
        beauticianServiceScope.setProvinceId(nameResVo.getProvinceId());
        beauticianServiceScope.setCityId(nameResVo.getCityId());
        beauticianServiceScope.setAreaId(nameResVo.getAreaId());
        this.beauticianServiceScopeMapper.insertSelective(beauticianServiceScope);
        if (null != beauticianServiceScope.getIsSelect() && beauticianServiceScope.getIsSelect()) {
            // 美容师
            StoreBeautician beautician = new StoreBeautician();
            beautician.setId(beauticianServiceScope.getBeauticianId());
            beautician.setServiceCityId(beauticianServiceScope.getCityId());
            beautician.setServiceCityName(beauticianServiceScope.getCityName());
            beautician.setServiceAreaId(beauticianServiceScope.getAreaId());
            beautician.setServiceAreaName(beauticianServiceScope.getAreaName());
            beautician.setServiceAddress(beauticianServiceScope.getAddress());
            beautician.setServiceLongitude(beauticianServiceScope.getLongitude());
            beautician.setServiceLatitude(beauticianServiceScope.getLatitude());
            beautician.setServiceRadius(beauticianServiceScope.getRadius());
            this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        }
        responseMessage.setData(beauticianServiceScope);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<BeauticianServiceScope>> findListByBeauticianIdV111(int beauticianId) {
        ResponseMessage<List<BeauticianServiceScope>> responseMessage = new ResponseMessage<>();
        BeauticianServiceScope borCond = new BeauticianServiceScope();
        borCond.setBeauticianId(beauticianId);
        List<BeauticianServiceScope> list = this.beauticianServiceScopeMapper.selectListByConditions(borCond);
        if (list.isEmpty()) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_SERVICE_SCOPE_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_SERVICE_SCOPE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage selectV111(int id) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 美容师服务范围
        BeauticianServiceScope beauticianServiceScope = this.beauticianServiceScopeMapper.selectByPrimaryKey(id);
        if (null == beauticianServiceScope) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_SERVICE_SCOPE_NULL, StoreConstant.Query.BEAUTICIAN_SERVICE_SCOPE_NULL_MSG);
        }
        // 根据美容师ID取消选择
        this.beauticianServiceScopeMapper.cancelSelectByBeauticianId(beauticianServiceScope.getBeauticianId());
        // 选择
        beauticianServiceScope.setIsSelect(true);
        this.beauticianServiceScopeMapper.updateByPrimaryKeySelective(beauticianServiceScope);
        // 美容师
        StoreBeautician beautician = new StoreBeautician();
        beautician.setId(beauticianServiceScope.getBeauticianId());
        beautician.setServiceCityId(beauticianServiceScope.getCityId());
        beautician.setServiceCityName(beauticianServiceScope.getCityName());
        beautician.setServiceAreaId(beauticianServiceScope.getAreaId());
        beautician.setServiceAreaName(beauticianServiceScope.getAreaName());
        beautician.setServiceAddress(beauticianServiceScope.getAddress());
        beautician.setServiceLongitude(beauticianServiceScope.getLongitude());
        beautician.setServiceLatitude(beauticianServiceScope.getLatitude());
        beautician.setServiceRadius(beauticianServiceScope.getRadius());
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteV111(int id) {
        ResponseMessage responseMessage = new ResponseMessage();
        BeauticianServiceScope beauticianServiceScope = new BeauticianServiceScope();
        beauticianServiceScope.setId(id);
        beauticianServiceScope.setIsEnabled(false);
        int result = this.beauticianServiceScopeMapper.updateByPrimaryKeySelective(beauticianServiceScope);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyV111(BeauticianServiceScope beauticianServiceScope) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.beauticianServiceScopeMapper.updateByPrimaryKeySelective(beauticianServiceScope);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BeauticianServiceScope> findByIdV111(int id) {
        ResponseMessage<BeauticianServiceScope> responseMessage = new ResponseMessage<>();
        BeauticianServiceScope beauticianServiceScope = this.beauticianServiceScopeMapper.selectByPrimaryKey(id);
        if (null == beauticianServiceScope) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_SERVICE_SCOPE_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_SERVICE_SCOPE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(beauticianServiceScope);
        return responseMessage;
    }
}