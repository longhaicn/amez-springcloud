package com.union.aimei.store.service;

import com.union.aimei.common.model.store.StoreFriend;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 门店朋友
 *
 * @author liurenkai
 * @time 2018/6/7 14:52
 */
public interface StoreFriendService {

    /**
     * 保存门店朋友
     *
     * @param storeFriend 门店朋友
     * @return
     */
    ResponseMessage<StoreFriend> saveV111(StoreFriend storeFriend);

    /**
     * 根据ID删除门店朋友
     *
     * @param id ID
     * @return
     */
    ResponseMessage removeByIdV111(int id);

    /**
     * 根据ID查询门店朋友
     *
     * @param id ID
     * @return
     */
    ResponseMessage<StoreFriend> getByIdV111(int id);

    /**
     * 根据门店ID查询门店朋友
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<List<StoreFriend>> listByStoreIdV111(int storeId);

}