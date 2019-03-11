package com.union.aimei.im.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersFriends;
import com.union.aimei.im.service.ImUsersFriendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2017/12/25 19:12
 */
@Api(tags = "IM用户好友")
@RestController
@RequestMapping(value = "imUsersFriends")
public class ImUsersFriendsController {
    @Resource
    private ImUsersFriendsService imUsersFriendsService;

    @PostMapping("/front/findByPage")
    public PageInfo<ImUsersFriends> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                       @ApiParam(value = "查询条件") @RequestBody ImUsersFriends imUsersFriends) {
        return this.imUsersFriendsService.findByPageForFront(pageNo, pageSize, imUsersFriends);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ImUsersFriends imUsersFriends) {
        return this.imUsersFriendsService.addObj(imUsersFriends);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.imUsersFriendsService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ImUsersFriends imUsersFriends) {
        return this.imUsersFriendsService.modifyObj(imUsersFriends);
    }

    @GetMapping("/queryById/{id}")
    public ImUsersFriends queryById(@PathVariable(value = "id") int id) {
        return this.imUsersFriendsService.queryObjById(id);
    }
}