package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreFollowerFeign;
import com.union.aimei.common.model.store.StoreByMemberIdLongitudeLatitude;
import com.union.aimei.common.model.store.StoreByMemberIdLongitudeLatitudeResult;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/4/11 14:28
 */
@Api(tags = "店铺粉丝表", description = "api")
@RestController
@RequestMapping(value = "storeFollower")
public class StoreFollowerApiController {
    @Resource
    private StoreFollowerFeign storeFollowerFeign;

    /**
     * 根据用户id和经纬度查询收藏的店铺
     *
     * @param pageNo                           分页索引
     * @param pageSize                         每页显示数量
     * @param storeByMemberIdLongitudeLatitude 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据用户id和经纬度查询收藏的店铺")
    @PostMapping("/selectListPageByMemberIdAndLongitudeLatitude")
    public ResponseMessage<PageInfo<StoreByMemberIdLongitudeLatitudeResult>> selectListPageByMemberIdAndLongitudeLatitude(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                                                                  Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreByMemberIdLongitudeLatitude storeByMemberIdLongitudeLatitude) {
        return this.storeFollowerFeign.selectListPageByMemberIdAndLongitudeLatitude(pageNo, pageSize, storeByMemberIdLongitudeLatitude);
    }


}