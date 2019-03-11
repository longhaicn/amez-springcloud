package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.common.vo.product.pc.FreightTemplateByAddVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDetailResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateCityByBatchVo;
import com.union.aimei.pc.product.mapper.FreightTemplateCityMapper;
import com.union.aimei.pc.product.mapper.FreightTemplateMapper;
import com.union.aimei.pc.product.service.FreightTemplateService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:35
 */
@Service("freightTemplateService")
public class FreightTemplateServiceImpl implements FreightTemplateService {
    @Resource
    private FreightTemplateMapper freightTemplateMapper;
    @Resource
    private FreightTemplateCityMapper freightTemplateCityMapper;

    @Override
    public ResponseMessage<PageInfo<FreightTemplate>> findByPageForFront(Integer pageNo, Integer pageSize, FreightTemplate freightTemplate) {
        ResponseMessage<PageInfo<FreightTemplate>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<FreightTemplate> list = this.freightTemplateMapper.selectListByConditions(freightTemplate);
        PageInfo<FreightTemplate> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加运费模板
     *
     * @param freightTemplate
     * @return
     */
    @Override
    public int addObj(FreightTemplate freightTemplate) {
        return this.freightTemplateMapper.insertSelective(freightTemplate);
    }

    /**
     * 删除运费模板
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.freightTemplateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改运费模板
     *
     * @param freightTemplate
     * @return
     */
    @Override
    public int modifyObj(FreightTemplate freightTemplate) {
        return this.freightTemplateMapper.updateByPrimaryKeySelective(freightTemplate);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnfreightTemplate
     */
    @Override
    public FreightTemplate queryObjById(int id) {
        FreightTemplate model = this.freightTemplateMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> findByPageForDefault(Integer pageNo, Integer pageSize, FreightTemplate freightTemplate) {
        ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<FreightTemplateByDefaultResVo> list = this.freightTemplateMapper.selectListByDefault(freightTemplate);
        PageInfo<FreightTemplateByDefaultResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<FreightTemplateByDetailResVo> detail(int id) {
        ResponseMessage<FreightTemplateByDetailResVo> responseMessage = new ResponseMessage<>();
        // 运费模板
        FreightTemplate freightTemplate = this.freightTemplateMapper.selectByPrimaryKey(id);
        // 运费模板城市集合
        FreightTemplateCity freightTemplateCityCond = new FreightTemplateCity();
        freightTemplateCityCond.setTemplateId(id);
        freightTemplateCityCond.setIsEnabled(true);
        List<FreightTemplateCity> freightTemplateCityList = this.freightTemplateCityMapper.selectListByConditions(freightTemplateCityCond);
        // 结果
        FreightTemplateByDetailResVo detailResVo = new FreightTemplateByDetailResVo();
        detailResVo.setFreightTemplate(freightTemplate);
        detailResVo.setFreightTemplateCityList(freightTemplateCityList);
        responseMessage.setData(detailResVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage add(FreightTemplateByAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 运费模板
        FreightTemplate freightTemplate = addVo.getFreightTemplate();
        // 判断名称是否存在
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("templateName", freightTemplate.getTemplateName());
        int count = this.freightTemplateMapper.selectCountByTemplateName(condMap);
        if (count > 0) {
            responseMessage.setCode(ProductConstant.Query.FREIGHT_TEMPLATE_NAME_EXISTED);
            responseMessage.setMessage(ProductConstant.Query.FREIGHT_TEMPLATE_NAME_EXISTED_MSG);
            return responseMessage;
        }
        // 运费模版添加
        this.freightTemplateMapper.insertSelective(freightTemplate);
        // 运费模板城市
        List<FreightTemplateCity> cityList = addVo.getCityList();
        if (!cityList.isEmpty()) {
            cityList.forEach(freightTemplateCity -> {
                freightTemplateCity.setTemplateId(freightTemplate.getId());
            });
            this.freightTemplateCityMapper.addBatch(new FreightTemplateCityByBatchVo(addVo.getCityList()));
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(FreightTemplateByAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 运费模板
        FreightTemplate freightTemplate = addVo.getFreightTemplate();
        // 判断名称是否存在
        Map<String, Object> templateMap = new HashMap<>(16);
        templateMap.put("templateName", freightTemplate.getTemplateName());
        templateMap.put("notId", freightTemplate.getId());
        int count = this.freightTemplateMapper.selectCountByTemplateName(templateMap);
        if (count > 0) {
            responseMessage.setCode(ProductConstant.Query.FREIGHT_TEMPLATE_NAME_EXISTED);
            responseMessage.setMessage(ProductConstant.Query.FREIGHT_TEMPLATE_NAME_EXISTED_MSG);
            return responseMessage;
        }
        // 运费模版更新
        this.freightTemplateMapper.updateByPrimaryKeySelective(freightTemplate);
        // 运费模板城市
        this.freightTemplateCityMapper.deleteByTemplateId(freightTemplate.getId());
        List<FreightTemplateCity> cityList = addVo.getCityList();
        if (!cityList.isEmpty()) {
            cityList.forEach(freightTemplateCity -> {
                freightTemplateCity.setTemplateId(freightTemplate.getId());
            });
            this.freightTemplateCityMapper.addBatch(new FreightTemplateCityByBatchVo(addVo.getCityList()));
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage selectCountByTemplateName(String templateName, Integer notId) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> templateMap = new HashMap<>(16);
        templateMap.put("templateName", templateName);
        templateMap.put("notId", notId);
        int count = this.freightTemplateMapper.selectCountByTemplateName(templateMap);
        if (count > 0) {
            responseMessage.setCode(ProductConstant.Query.FREIGHT_TEMPLATE_NAME_EXISTED);
            responseMessage.setMessage(ProductConstant.Query.FREIGHT_TEMPLATE_NAME_EXISTED_MSG);
            return responseMessage;
        }
        return responseMessage;
    }

}