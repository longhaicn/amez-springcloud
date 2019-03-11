package com.union.aimei.common.feign.im.pc;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.hystrix.ImMessagesApiHystrix;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2017/12/25 19:26
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = ImMessagesApiHystrix.class)
public interface ImMessagesFeign {
    /**
     * 添加IM消息
     *
     * @param imMessages
     * @return
     */
    @PostMapping(value = "/imMessages/insert")
    int insert(@RequestBody ImMessages imMessages);

    /**
     * 删除IM消息
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/imMessages/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改IM消息
     *
     * @param imMessages
     * @return
     */
    @PutMapping(value = "/imMessages/edit")
    int edit(@RequestBody ImMessages imMessages);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimMessages
     */
    @GetMapping(value = "/imMessages/queryById/{id}")
    ImMessages queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询IM消息
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param imMessages 查询条件
     * @return
     */
    @PostMapping(value = "/imMessages/front/findByPage")
    PageInfo<ImMessages> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                            @RequestBody ImMessages imMessages);

    /**
     * 根据发送人集合，接收人集合分页查询IM消息
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param imMessagesVo 查询条件
     * @return
     */
    @PostMapping("/imMessages/findByPageForFromToList")
    ResponseMessage<PageInfo<ImMessages>> findByPageForFromToList(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @ApiParam(value = "查询条件") @RequestBody ImMessagesVo imMessagesVo);

    /**
     * 根据用户名分页查询最近联系人列表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param userNameList 用户名集合
     * @return
     */
    @PostMapping("/imMessages/findByPageForRecentContactlist")
    ResponseMessage<PageInfo<String>> findByPageForRecentContactlist(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @ApiParam(value = "查询条件") @RequestBody List<String> userNameList);


}