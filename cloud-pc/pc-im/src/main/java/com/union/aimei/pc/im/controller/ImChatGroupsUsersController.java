package com.union.aimei.pc.im.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroupsUsers;
import com.union.aimei.pc.im.service.ImChatGroupsUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:10
 */
@Api(tags = "IM群组用户")
@RestController
@RequestMapping(value = "imChatGroupsUsers")
public class ImChatGroupsUsersController {
    @Resource
    private ImChatGroupsUsersService imChatGroupsUsersService;

    @PostMapping("/front/findByPage")
    public PageInfo<ImChatGroupsUsers> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @ApiParam(value = "查询条件") @RequestBody ImChatGroupsUsers imChatGroupsUsers) {
        return this.imChatGroupsUsersService.findByPageForFront(pageNo, pageSize, imChatGroupsUsers);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ImChatGroupsUsers imChatGroupsUsers) {
        return this.imChatGroupsUsersService.addObj(imChatGroupsUsers);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.imChatGroupsUsersService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ImChatGroupsUsers imChatGroupsUsers) {
        return this.imChatGroupsUsersService.modifyObj(imChatGroupsUsers);
    }

    @GetMapping("/queryById/{id}")
    public ImChatGroupsUsers queryById(@PathVariable(value = "id") int id) {
        return this.imChatGroupsUsersService.queryObjById(id);
    }
}