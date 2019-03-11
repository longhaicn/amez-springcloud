package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseRegionHystrix;
import com.union.aimei.common.model.system.BaseRegion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseRegionHystrix.class)
public interface BaseRegionFeign {
    /**
     * 基本操作
     * @param regionId
     * @return
     */
    @RequestMapping(value = "/baseRegions/{regionId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("regionId") Integer regionId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRegions/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseRegion record);
    /**
     * 基本操作
     * @param regionId
     * @return
     */
    @RequestMapping(value = "/baseRegions/{regionId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseRegion selectByPrimaryKey(@PathVariable("regionId") Integer regionId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRegions/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseRegion record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRegions/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseRegion> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseRegion record);
}