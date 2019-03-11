package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseRoleHystrix;
import com.union.aimei.common.model.system.BaseRole;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseRoleHystrix.class)
public interface BaseRoleFeign {
    /**
     * 基本操作
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/baseRoles/{roleId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("roleId") Integer roleId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRoles/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseRole record);
    /**
     * 基本操作
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/baseRoles/{roleId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseRole selectByPrimaryKey(@PathVariable("roleId") Integer roleId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRoles/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseRole record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRoles/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseRole> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseRole record);
}