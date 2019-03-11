package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseDicGroupItemHystrix;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dell
 */
@FeignClient(name = "app-system-service", fallback = BaseDicGroupItemHystrix.class)
public interface BaseDicGroupItemFeign {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseDicGroupItems/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseDicGroupItems/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseDicGroupItem record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseDicGroupItems/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseDicGroupItem selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseDicGroupItems/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseDicGroupItem record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseDicGroupItems/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseDicGroupItem> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseDicGroupItem record);

    /**
     * 查看
     * @param bandCode
     * @return
     */
    @GetMapping("/baseDicGroupItems/findListByCode/{bandCode}")
    List<BaseDicGroupItem> findListByCode(@PathVariable(value = "bandCode") String bandCode);

}