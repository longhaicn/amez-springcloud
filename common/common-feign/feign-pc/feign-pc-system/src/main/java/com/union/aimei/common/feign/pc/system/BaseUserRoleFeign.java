package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseUserRoleHystrix;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-system-service", fallback = BaseUserRoleHystrix.class)
public interface BaseUserRoleFeign {
    /**
     * 基本操作
     * @param rightId
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/{rightId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("rightId") Integer rightId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseUserRole record);
    /**
     * 基本操作
     * @param rightId
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/{rightId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseUserRole selectByPrimaryKey(@PathVariable("rightId") Integer rightId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseUserRole record);

    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUserRoles/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseUserRole> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseUserRole record);

    /**
     * 分配
     * @param userId
     * @param roleIds
     * @return
     */
    @GetMapping("baseUserRoles/distributionBaseUserRole")
    ResponseMessage<String> distributionBaseUserRole(@RequestParam(value = "userId", defaultValue = "0") Integer userId,
                                                     @RequestParam(value = "roleIds", defaultValue = "0") String roleIds);

    /**
     * 查看
     * @param userId
     * @return
     */
    @GetMapping("/baseUserRoles/findBaseUserRoles/{userId}")
    ResponseMessage<Map<String, Object>> findBaseUserRoles(@ApiParam(value = "userId用户id") @PathVariable(value = "userId") Integer userId);
}