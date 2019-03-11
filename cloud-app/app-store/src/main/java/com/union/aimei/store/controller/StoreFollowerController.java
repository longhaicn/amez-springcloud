package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.store.service.StoreFollowerService;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeResultVo;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeVo;
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
 * @time 2018/4/11 14:40
 */
@Api(tags = "店铺粉丝表", description = "api")
@RestController
@RequestMapping(value = "storeFollower")
public class StoreFollowerController {
    @Resource
    private StoreFollowerService storeFollowerService;

    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺粉丝表")
    @PostMapping("/front/findByPage")
    public PageInfo<StoreFollower> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                              Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                              Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreFollower storeFollower) {
        return this.storeFollowerService.findByPageForFront(pageNo, pageSize, storeFollower);
    }

    @ApiOperation(httpMethod = "POST", value = "添加店铺粉丝表")
    @PostMapping("/insert")
    public int insert(@RequestBody StoreFollower storeFollower) {
        return this.storeFollowerService.addObj(storeFollower);
    }

    @ApiOperation(httpMethod = "GET", value = "删除店铺粉丝表")
    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id) {
        return this.storeFollowerService.deleteObjById(id);
    }

    @ApiOperation(httpMethod = "POST", value = "编辑店铺粉丝表")
    @PutMapping("/edit")
    public int edit(@RequestBody StoreFollower storeFollower) {
        return this.storeFollowerService.modifyObj(storeFollower);
    }

    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺粉丝表")
    @GetMapping("/queryById/{id}")
    public StoreFollower queryById(@PathVariable int id) {
        return this.storeFollowerService.queryObjById(id);
    }

    /**
     * 根据用户id和经纬度查询收藏的店铺
     *
     * @param pageNo                             分页索引
     * @param pageSize                           每页显示数量
     * @param storeByMemberIdLongitudeLatitudeVo 查询条件
     * @return
     */
    @PostMapping("/selectListPageByMemberIdAndLongitudeLatitude")
    public ResponseMessage<PageInfo<StoreByMemberIdLongitudeLatitudeResultVo>> selectListPageByMemberIdAndLongitudeLatitude(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreByMemberIdLongitudeLatitudeVo storeByMemberIdLongitudeLatitudeVo) {
        return this.storeFollowerService.selectListPageByMemberIdAndLongitudeLatitude (pageNo, pageSize, storeByMemberIdLongitudeLatitudeVo);
    }
}