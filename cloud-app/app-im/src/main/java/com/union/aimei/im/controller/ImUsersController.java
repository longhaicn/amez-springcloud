package com.union.aimei.im.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.im.service.ImUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:12
 */
@Api(tags = "IM用户")
@RestController
@RequestMapping(value = "imUsers")
public class ImUsersController {
    @Resource
    private ImUsersService imUsersService;

    @PostMapping("/front/findByPage")
    public PageInfo<ImUsers> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                @ApiParam(value = "查询条件") @RequestBody ImUsers imUsers) {
        return this.imUsersService.findByPageForFront(pageNo, pageSize, imUsers);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ImUsers imUsers) {
        return this.imUsersService.addObj(imUsers);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.imUsersService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ImUsers imUsers) {
        return this.imUsersService.modifyObj(imUsers);
    }

    @GetMapping("/queryById/{id}")
    public ImUsers queryById(@PathVariable(value = "id") int id) {
        return this.imUsersService.queryObjById(id);
    }
}