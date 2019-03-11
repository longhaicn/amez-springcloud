package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseUserRoleHystrix;
import com.union.aimei.common.model.system.BaseUserRole;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "app-system-service", fallback = BaseUserRoleHystrix.class)
public interface BaseUserRoleFeign {
    /**
     * 基本操作
     *
     * @param rightId
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/{rightId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("rightId") Integer rightId);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseUserRole record);

    /**
     * 基本操作
     *
     * @param rightId
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/{rightId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseUserRole selectByPrimaryKey(@PathVariable("rightId") Integer rightId);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseUserRole record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseUserRole> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseUserRole record);
}