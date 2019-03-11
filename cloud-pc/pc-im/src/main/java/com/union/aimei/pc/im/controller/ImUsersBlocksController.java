package com.union.aimei.pc.im.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersBlocks;
import com.union.aimei.pc.im.service.ImUsersBlocksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM用户黑名单
 *
 * @author liurenkai
 * @time 2017/12/25 19:12
 */
@Api(tags = "IM用户黑名单")
@RestController
@RequestMapping(value = "imUsersBlocks")
public class ImUsersBlocksController {
    @Resource
    private ImUsersBlocksService imUsersBlocksService;

    @PostMapping("/front/findByPage")
    public PageInfo<ImUsersBlocks> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                      @ApiParam(value = "查询条件") @RequestBody ImUsersBlocks imUsersBlocks) {
        return this.imUsersBlocksService.findByPageForFront(pageNo, pageSize, imUsersBlocks);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ImUsersBlocks imUsersBlocks) {
        return this.imUsersBlocksService.addObj(imUsersBlocks);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.imUsersBlocksService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ImUsersBlocks imUsersBlocks) {
        return this.imUsersBlocksService.modifyObj(imUsersBlocks);
    }

    @GetMapping("/queryById/{id}")
    public ImUsersBlocks queryById(@PathVariable(value = "id") int id) {
        return this.imUsersBlocksService.queryObjById(id);
    }
}