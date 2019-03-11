package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.aimei.app.api.order.mapper.OrderReturnMapper;
import com.union.aimei.app.api.order.service.OrderReturnService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
  * @description
  */
@Service("orderReturnService")
public class OrderReturnServiceImpl implements OrderReturnService {
    @Resource
    private OrderReturnMapper orderReturnMapper;

    /**
     * 前端分页查询退换货单
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param orderReturn 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<OrderReturn>> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturn orderReturn) {
        PageHelper.startPage(pageNo, pageSize);
        List<OrderReturn> list = this.orderReturnMapper.selectListByConditions(orderReturn);
        PageInfo<OrderReturn> page = new PageInfo<>(list);
        ResponseMessage<PageInfo<OrderReturn>> res=new ResponseMessage<>();
        res.setData(page);
        return res;
    }

    /**
     * 添加退换货单
     *
     * @param orderReturn
     * @return
     */
    @Override
    public int addObj(OrderReturn orderReturn) {
        return this.orderReturnMapper.insertSelective(orderReturn);
    }

    /**
     * 删除退换货单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.orderReturnMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改退换货单
     *
     * @param orderReturn
     * @return
     */
    @Override
    public int modifyObj(OrderReturn orderReturn) {
        return this.orderReturnMapper.updateByPrimaryKeySelective(orderReturn);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderReturn
     */
    @Override
    public OrderReturn queryObjById(int id) {
        OrderReturn model = this.orderReturnMapper.selectByPrimaryKey(id);
        return model;
    }


    @Override
    public ResponseMessage<OrderReturn> queryByOrderNo(String orderNo) {
        ResponseMessage<OrderReturn> res=new ResponseMessage<>();
        OrderReturn orderReturn=orderReturnMapper.selectByOrderNo(orderNo);
        if(orderReturn==null){
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }else{
            res.setData(orderReturn);
        }
        return res;
    }

    @Override
    public ResponseMessage<RefundObject> queryRefundObject(String orderNo) {
        ResponseMessage<RefundObject> res=new ResponseMessage<>();
        RefundObject obj=orderReturnMapper.queryApplyRefundObjct(orderNo);
        if(obj==null){
            throw new ServerException(1004,"查询未空");
        }else{
            res.setData(obj);
        }
        return res;
    }
}