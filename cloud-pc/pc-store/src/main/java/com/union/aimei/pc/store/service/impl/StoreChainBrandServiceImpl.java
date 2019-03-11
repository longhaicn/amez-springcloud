package com.union.aimei.pc.store.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.aimei.pc.store.mapper.StoreChainBrandMapper;
import com.union.aimei.pc.store.service.StoreChainBrandService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Service("storeChainBrandService")
public class StoreChainBrandServiceImpl implements StoreChainBrandService {
    @Resource
    private StoreChainBrandMapper storeChainBrandMapper;

    /**
     * 前端分页查询门店连锁品牌
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeChainBrand 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreChainBrand> findByPageForFront(Integer pageNo, Integer pageSize, StoreChainBrand storeChainBrand) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreChainBrand> list = this.storeChainBrandMapper.selectListByConditions(storeChainBrand);
        PageInfo<StoreChainBrand> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加门店连锁品牌
     *
     * @param storeChainBrand
     * @return
     */
    @Override
    public int addObj(StoreChainBrand storeChainBrand) {
        return this.storeChainBrandMapper.insertSelective(storeChainBrand);
    }

    /**
     * 删除门店连锁品牌
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeChainBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门店连锁品牌
     *
     * @param storeChainBrand
     * @return
     */
    @Override
    public int modifyObj(StoreChainBrand storeChainBrand) {
        return this.storeChainBrandMapper.updateByPrimaryKeySelective(storeChainBrand);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreChainBrand
     */
    @Override
    public StoreChainBrand queryObjById(int id) {
        StoreChainBrand model = this.storeChainBrandMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage accumStoreTotalByBrandId(int brandId, int number) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("brandId", brandId);
        condMap.put("number", number);
        this.storeChainBrandMapper.accumStoreTotalByByBrandId(condMap);
        return responseMessage;
    }

    @Override
    public ResponseMessage accumProductTotalByBrandId(int brandId, int number) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("brandId", brandId);
        condMap.put("number", number);
        this.storeChainBrandMapper.accumProductTotalByByBrandId(condMap);
        return responseMessage;
    }

    @Override
    public ResponseMessage insertLimitBrandOwnershipCompany(StoreChainBrand storeChainBrand) {
        ResponseMessage res = new ResponseMessage();
        Integer total = null;
        //查询  品牌所属公司下的所有品牌名称不可重复
        Map<String, Object> map = new HashMap<>(16);
        map.put("brandOwnershipCompany", storeChainBrand.getBrandOwnershipCompany());
        map.put("brandName", storeChainBrand.getBrandName());
        total = this.storeChainBrandMapper.selectListByConditionsCount(map);
        if (total == 0) {
            total = this.storeChainBrandMapper.insertSelective(storeChainBrand);
            res.setData(total);
        } else {
            res.setCode(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST);
            res.setMessage(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST_MSG);
        }
        return res;
    }

    @Override
    public ResponseMessage editLimitBrandOwnershipCompany(StoreChainBrand storeChainBrand) {
        ResponseMessage res = new ResponseMessage();
        Integer total = null;
        //查询  品牌所属公司下的所有品牌名称不可重复
        Map<String, Object> map = new HashMap<>(16);
        map.put("brandOwnershipCompany", storeChainBrand.getBrandOwnershipCompany());
        map.put("brandName", storeChainBrand.getBrandName());
        map.put("notId", storeChainBrand.getId());
        total = this.storeChainBrandMapper.selectListByConditionsCount(map);
        if (total == 0) {
            total = this.storeChainBrandMapper.updateByPrimaryKeySelective(storeChainBrand);
            res.setData(total);
        } else {
            res.setCode(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST);
            res.setMessage(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST_MSG);
        }
        return res;
    }

    @Override
    public ResponseMessage findLimitBrandCompany(String brandName, Integer brandId) {
        ResponseMessage res = new ResponseMessage();
        Integer total = null;
        Map<String, Object> map = new HashMap<>(16);
        map.put("brandName", brandName);
        if (null != brandId && brandId != 0) {
            map.put("notId", brandId);
        }
        total = this.storeChainBrandMapper.selectListByConditionsCount(map);
        if (total != 0) {
            res.setCode(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST);
            res.setMessage(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST_MSG);
        }
        return res;
    }

}