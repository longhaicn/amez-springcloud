package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseAppUpdateVersionHystrix;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-system-service", fallback = BaseAppUpdateVersionHystrix.class)
public interface BaseAppUpdateVersionFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseAppUpdateVersions/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseAppUpdateVersions/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseAppUpdateVersion record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseAppUpdateVersions/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseAppUpdateVersion selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseAppUpdateVersions/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseAppUpdateVersion record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseAppUpdateVersions/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseAppUpdateVersion> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseAppUpdateVersion record);
}