package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseRoleResourcesHystrix;
import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseRoleResourcesHystrix.class)
public interface BaseRoleResourcesFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseRoleResources/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRoleResources/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseRoleResources record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseRoleResources/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseRoleResources selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRoleResources/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseRoleResources record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRoleResources/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseRoleResources> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseRoleResources record);

    /**
     * 分配
     * @param roleId
     * @param resourcesIds
     * @return
     */
    @GetMapping("/baseRoleResources/distributionBaseRoleResources")
    ResponseMessage<String> distributionBaseRoleResources(@RequestParam(value = "roleId") Integer roleId, @RequestParam(value = "resourcesIds") String resourcesIds);

}