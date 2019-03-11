package com.union.aimei.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.financial.mapper.StoreshipWithdrawalMapper;
import com.union.aimei.financial.service.StoreshipWithdrawalService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author liufeihua
 */
@Service
public class StoreshipWithdrawalServiceImpl implements StoreshipWithdrawalService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private StoreshipWithdrawalMapper storeshipWithdrawalMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeshipWithdrawalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(StoreshipWithdrawal record) {
        return this.storeshipWithdrawalMapper.insertSelective(record);
    }

    @Override
    public StoreshipWithdrawal selectByPrimaryKey(Integer id) {
        return this.storeshipWithdrawalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreshipWithdrawal record) {
        return this.storeshipWithdrawalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<StoreshipWithdrawal> selectListByConditions(Integer pageNo, Integer pageSize, StoreshipWithdrawal record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeshipWithdrawalMapper.selectListByConditions(record));
    }

    @Override
    public ResponseMessage<List<StoreshipWithdrawal>> selectListByConditionsV110(StoreshipWithdrawal record) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<StoreshipWithdrawal> storeshipWithdrawalList = this.storeshipWithdrawalMapper.selectListByConditions(record);
        if (CollectionUtils.isEmpty(storeshipWithdrawalList)) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SELECT_NULL);
        }
        responseMessage.setData(storeshipWithdrawalList);
        return responseMessage;
    }
}