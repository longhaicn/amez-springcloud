package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseOperatorHystrix;
import com.union.aimei.common.model.system.BaseOperator;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-system-service", fallback = BaseOperatorHystrix.class)
public interface BaseOperatorFeign {
    /**
     * 基本操作
     * @param operId
     * @return
     */
    @RequestMapping(value = "/baseOperators/{operId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("operId") Integer operId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseOperators/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseOperator record);
    /**
     * 基本操作
     * @param operId
     * @return
     */
    @RequestMapping(value = "/baseOperators/{operId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseOperator selectByPrimaryKey(@PathVariable("operId") Integer operId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseOperators/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseOperator record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseOperators/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseOperator> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseOperator record);
}