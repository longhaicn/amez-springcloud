package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalFreightTemplateRef;
import com.union.aimei.pc.product.mapper.PhysicalFreightTemplateRefMapper;
import com.union.aimei.pc.product.service.PhysicalFreightTemplateRefService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 16:36
 */
@Service("physicalFreightTemplateRefService")
public class PhysicalFreightTemplateRefServiceImpl implements PhysicalFreightTemplateRefService {
    @Resource
    private PhysicalFreightTemplateRefMapper physicalFreightTemplateRefMapper;

    @Override
    public ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<PhysicalFreightTemplateRef> list = this.physicalFreightTemplateRefMapper.selectListByConditions(physicalFreightTemplateRef);
        PageInfo<PhysicalFreightTemplateRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加产品-运费模板-关联
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @Override
    public int addObj(PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return this.physicalFreightTemplateRefMapper.insertSelective(physicalFreightTemplateRef);
    }

    /**
     * 删除产品-运费模板-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.physicalFreightTemplateRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改产品-运费模板-关联
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @Override
    public int modifyObj(PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return this.physicalFreightTemplateRefMapper.updateByPrimaryKeySelective(physicalFreightTemplateRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalFreightTemplateRef
     */
    @Override
    public PhysicalFreightTemplateRef queryObjById(int id) {
        PhysicalFreightTemplateRef model = this.physicalFreightTemplateRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage add(PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        ResponseMessage<PhysicalFreightTemplateRef> responseMessage = new ResponseMessage<>();
        if (physicalFreightTemplateRef.getId() == null) {
            PhysicalFreightTemplateRef physicalFreightTemplateRefCond = new PhysicalFreightTemplateRef();
            physicalFreightTemplateRefCond.setPhysicalId(physicalFreightTemplateRef.getPhysicalId());
            physicalFreightTemplateRefCond.setTemplateId(physicalFreightTemplateRef.getTemplateId());
            List<PhysicalFreightTemplateRef> physicalFreightTemplateRefList = this.physicalFreightTemplateRefMapper.selectListByConditions(physicalFreightTemplateRefCond);
            if (physicalFreightTemplateRefList.isEmpty()) {
                this.physicalFreightTemplateRefMapper.insertSelective(physicalFreightTemplateRef);
            } else {
                physicalFreightTemplateRef.setId(physicalFreightTemplateRefList.get(0).getId());
                this.physicalFreightTemplateRefMapper.updateByPrimaryKeySelective(physicalFreightTemplateRef);
            }
        } else {
            this.physicalFreightTemplateRefMapper.updateByPrimaryKeySelective(physicalFreightTemplateRef);
        }
        responseMessage.setData(physicalFreightTemplateRef);
        return responseMessage;
    }

}