package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseQuestionTypeHystrix;
import com.union.aimei.common.model.system.BaseQuestionType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-system-service", fallback = BaseQuestionTypeHystrix.class)
public interface BaseQuestionTypeFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseQuestionTypes/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestionTypes/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseQuestionType record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseQuestionTypes/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseQuestionType selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestionTypes/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseQuestionType record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestionTypes/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseQuestionType> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseQuestionType record);
}