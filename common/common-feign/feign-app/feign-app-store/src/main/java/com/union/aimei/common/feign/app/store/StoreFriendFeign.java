package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.StoreFriendApiHystrix;
import com.union.aimei.common.model.store.StoreFriend;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门店朋友
 *
 * @author liurenkai
 * @time 2018/6/7 16:06
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreFriendApiHystrix.class)
public interface StoreFriendFeign {

    /**
     * 保存门店朋友
     *
     * @param storeFriend 门店朋友
     * @return
     */
    @PostMapping("/storeFriend/1.1.1/save")
    ResponseMessage<StoreFriend> saveV111(@RequestBody StoreFriend storeFriend);

    /**
     * 根据ID删除门店朋友
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/storeFriend/1.1.1/removeById/{id}")
    ResponseMessage removeById(@PathVariable(value = "id") int id);

    /**
     * 根据ID查询门店朋友
     *
     * @param id ID
     * @return
     */
    @GetMapping("/storeFriend/1.1.1/getById/{id}")
    ResponseMessage<StoreFriend> getById(@PathVariable(value = "id") int id);

    /**
     * 根据门店ID查询门店朋友
     *
     * @param storeId 门店ID
     * @return
     */
    @GetMapping("/storeFriend/1.1.1/listByStoreId/{storeId}")
    ResponseMessage<List<StoreFriend>> listByStoreId(@PathVariable(value = "storeId") int storeId);

}