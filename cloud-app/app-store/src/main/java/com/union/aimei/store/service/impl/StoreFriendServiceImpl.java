package com.union.aimei.store.service.impl;

import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.StoreFriend;
import com.union.aimei.store.mapper.StoreFriendMapper;
import com.union.aimei.store.service.StoreFriendService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店朋友
 *
 * @author liurenkai
 * @time 2018/6/7 14:53
 */
@Service("storeFriendService")
public class StoreFriendServiceImpl implements StoreFriendService {
    @Resource
    private StoreFriendMapper storeFriendMapper;

    @Override
    public ResponseMessage<StoreFriend> saveV111(StoreFriend storeFriend) {
        ResponseMessage<StoreFriend> responseMessage = new ResponseMessage<>();
        this.storeFriendMapper.insertSelective(storeFriend);
        responseMessage.setData(storeFriend);
        return responseMessage;
    }

    @Override
    public ResponseMessage removeByIdV111(int id) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreFriend storeFriend = new StoreFriend();
        storeFriend.setId(id);
        storeFriend.setIsEnabled(false);
        this.storeFriendMapper.updateByPrimaryKeySelective(storeFriend);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreFriend> getByIdV111(int id) {
        ResponseMessage<StoreFriend> responseMessage = new ResponseMessage<>();
        StoreFriend storeFriend = this.storeFriendMapper.selectByPrimaryKey(id);
        if (null == storeFriend) {
            throw new ResponseException(StoreConstant.Query.FRIEND_NULL, StoreConstant.Query.FRIEND_NULL_MSG);
        }
        responseMessage.setData(storeFriend);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreFriend>> listByStoreIdV111(int storeId) {
        ResponseMessage<List<StoreFriend>> responseMessage = new ResponseMessage<>();
        StoreFriend storeFriend = new StoreFriend();
        storeFriend.setStoreId(storeId);
        List<StoreFriend> list = this.storeFriendMapper.selectListByConditions(storeFriend);
        if (CollectionUtils.isEmpty(list)) {
            throw new ResponseException(StoreConstant.Query.STORE_FRIEND_NULL, StoreConstant.Query.STORE_FRIEND_NULL_MSG);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

}