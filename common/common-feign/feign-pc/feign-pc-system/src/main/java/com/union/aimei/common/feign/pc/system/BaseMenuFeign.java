package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseMenuHystrix;
import com.union.aimei.common.model.system.BaseMenu;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseMenuHystrix.class)
public interface BaseMenuFeign {
    /**
     * 基本操作
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/baseMenus/{menuId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("menuId") Integer menuId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseMenus/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseMenu record);
    /**
     * 基本操作
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/baseMenus/{menuId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseMenu selectByPrimaryKey(@PathVariable("menuId") Integer menuId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseMenus/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseMenu record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseMenus/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseMenu> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseMenu record);
}