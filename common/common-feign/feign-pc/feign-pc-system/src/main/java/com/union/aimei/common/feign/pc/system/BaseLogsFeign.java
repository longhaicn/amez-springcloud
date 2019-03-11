package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseLogsHystrix;
import com.union.aimei.common.model.system.BaseLogs;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseLogsHystrix.class)
public interface BaseLogsFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseLogs/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseLogs/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseLogs record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseLogs/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseLogs selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseLogs/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseLogs record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseLogs/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseLogs> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseLogs record);
}