package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseDicGroupHystrix;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "app-system-service", fallback = BaseDicGroupHystrix.class)
public interface BaseDicGroupFeign {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseDicGroups/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseDicGroups/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseDicGroup record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseDicGroups/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseDicGroup selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseDicGroups/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseDicGroup record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseDicGroups/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseDicGroup> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseDicGroup record);

    /**
     * 根据数据字典代码查询数据字典详情
     *
     * @param code 数据字典代码
     * @return
     */
    @GetMapping("/baseDicGroups/1.1.1/detailByCode/{code}")
    ResponseMessage<BaseDicGroupDeatilResVo> detailByCodeV111(@PathVariable(value = "code") String code);

}