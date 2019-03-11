package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.StoreFriendFeign;
import com.union.aimei.common.model.store.StoreFriend;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店朋友
 *
 * @author liurenkai
 * @time 2018/6/7 16:14
 */
@Api(tags = "门店朋友")
@RestController
@RequestMapping(value = "storeFriend")
public class StoreFriendApiController {
    @Resource
    private StoreFriendFeign storeFriendFeign;

    /**
     * 保存门店朋友
     *
     * @param storeFriend 门店朋友
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存门店朋友")
    @PostMapping("/1.1.1/save")
    public ResponseMessage<StoreFriend> saveV111(@ApiParam(value = "条件") @RequestBody StoreFriend storeFriend) {
        return this.storeFriendFeign.saveV111(storeFriend);
    }

    /**
     * 根据ID删除门店朋友
     *
     * @param friendId ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据ID删除门店朋友")
    @DeleteMapping("/1.1.1/removeById/{id}")
    public ResponseMessage removeById(@ApiParam(value = "ID", required = true) @PathVariable(value = "id") int id) {
        return this.storeFriendFeign.removeById(id);
    }

    /**
     * 根据ID查询门店朋友
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询门店朋友")
    @GetMapping("/1.1.1/getById/{id}")
    public ResponseMessage<StoreFriend> getById(@ApiParam(value = "ID", required = true) @PathVariable(value = "id") int id) {
        return this.storeFriendFeign.getById(id);
    }

    /**
     * 根据门店ID查询门店朋友
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询门店朋友")
    @GetMapping("/1.1.1/listByStoreId/{storeId}")
    public ResponseMessage<List<StoreFriend>> listByStoreId(@ApiParam(value = "门店ID", required = true) @PathVariable(value = "storeId") int storeId) {
        return this.storeFriendFeign.listByStoreId(storeId);
    }

}