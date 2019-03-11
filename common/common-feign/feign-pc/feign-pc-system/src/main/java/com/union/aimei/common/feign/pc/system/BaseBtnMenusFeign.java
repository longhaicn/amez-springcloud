package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseBtnMenusHystrix;
import com.union.aimei.common.model.system.BaseBtnMenus;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseBtnMenusHystrix.class)
public interface BaseBtnMenusFeign {

    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseBtnMenus/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseBtnMenus/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseBtnMenus record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseBtnMenus/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseBtnMenus selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseBtnMenus/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseBtnMenus record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseBtnMenus/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseBtnMenus> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseBtnMenus record);
}