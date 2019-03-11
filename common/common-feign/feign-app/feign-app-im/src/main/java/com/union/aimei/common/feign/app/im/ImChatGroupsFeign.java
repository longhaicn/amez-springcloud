package com.union.aimei.common.feign.app.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.im.hystrix.ImChatGroupsApiHystrix;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 19:25
 */
@FeignClient(serviceId = "APP-IM-SERVICE", fallback = ImChatGroupsApiHystrix.class)
public interface ImChatGroupsFeign {
    /**
     * 分页查询IM群组
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imChatGroups 查询条件
     * @return
     */
    @PostMapping("//imChatGroups/pageByConditions")
    ResponseMessage<PageInfo<ImChatGroups>> pageByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                             @RequestBody ImChatGroups imChatGroups);

    /**
     * 新增IM群组
     *
     * @param imChatGroups IM群组
     * @return
     */
    @PostMapping("//imChatGroups/add")
    ResponseMessage<ImChatGroups> add(@RequestBody ImChatGroups imChatGroups);


    /**
     * 根据ID删除IM群组
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("//imChatGroups/removeById/{id}")
    ResponseMessage<Integer> removeById(@PathVariable(value = "id") int id);

    /**
     * 根据ID更新IM群组
     *
     * @param imChatGroups IM群组
     * @return
     */
    @PutMapping("//imChatGroups/updateById")
    ResponseMessage<Integer> updateById(@RequestBody ImChatGroups imChatGroups);

    /**
     * 根据ID查询IM群组
     *
     * @param id ID
     * @return
     */
    @GetMapping("//imChatGroups/getById/{id}")
    ResponseMessage<ImChatGroups> getById(@PathVariable(value = "id") int id);

}