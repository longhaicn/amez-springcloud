package com.union.aimei.pc.im.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.pc.im.service.ImMessagesService;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2017/12/25 19:11
 */
@Api(tags = "IM消息")
@RestController
@RequestMapping(value = "imMessages")
public class ImMessagesController {
    @Resource
    private ImMessagesService imMessagesService;

    @PostMapping("/front/findByPage")
    public PageInfo<ImMessages> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @ApiParam(value = "查询条件") @RequestBody ImMessages imMessages) {
        return this.imMessagesService.findByPageForFront(pageNo, pageSize, imMessages);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ImMessages imMessages) {
        return this.imMessagesService.addObj(imMessages);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.imMessagesService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ImMessages imMessages) {
        return this.imMessagesService.modifyObj(imMessages);
    }

    @GetMapping("/queryById/{id}")
    public ImMessages queryById(@PathVariable(value = "id") int id) {
        return this.imMessagesService.queryObjById(id);
    }

    /**
     * 根据发送人集合，接收人集合分页查询IM消息
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param imMessagesVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据发送人集合，接收人集合分页查询IM消息")
    @PostMapping("/findByPageForFromToList")
    public ResponseMessage<PageInfo<ImMessages>> findByPageForFromToList(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ImMessagesVo imMessagesVo) {
        return this.imMessagesService.findByPageForFromToList(pageNo, pageSize, imMessagesVo);
    }

    /**
     * 根据用户名分页查询最近联系人列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param userNameList 用户名集合
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据用户名分页查询最近联系人列表")
    @PostMapping("/findByPageForRecentContactlist")
    public ResponseMessage<PageInfo<String>> findByPageForRecentContactlist(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @ApiParam(value = "查询条件") @RequestBody List<String> userNameList) {
        return this.imMessagesService.findByPageForRecentContactlist(pageNo, pageSize, userNameList);
    }

}