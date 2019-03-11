package com.union.aimei.im.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.aimei.im.service.ImChatGroupsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 19:10
 */
@Api(tags = "IM群组")
@RestController
@RequestMapping(value = "imChatGroups")
public class ImChatGroupsController {
    @Resource
    private ImChatGroupsService imChatGroupsService;

    @PostMapping("/front/findByPage")
    public PageInfo<ImChatGroups> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                     @ApiParam(value = "查询条件") @RequestBody ImChatGroups imChatGroups) {
        return this.imChatGroupsService.findByPageForFront(pageNo, pageSize, imChatGroups);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ImChatGroups imChatGroups) {
        return this.imChatGroupsService.addObj(imChatGroups);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.imChatGroupsService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ImChatGroups imChatGroups) {
        return this.imChatGroupsService.modifyObj(imChatGroups);
    }

    @GetMapping("/queryById/{id}")
    public ImChatGroups queryById(@PathVariable(value = "id") int id) {
        return this.imChatGroupsService.queryObjById(id);
    }
}