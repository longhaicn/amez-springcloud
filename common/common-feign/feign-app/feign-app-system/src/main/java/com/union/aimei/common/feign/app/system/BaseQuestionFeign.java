package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseQuestionHystrix;
import com.union.aimei.common.model.system.BaseQuestion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * @author dell
 */
@FeignClient(name = "app-system-service", fallback = BaseQuestionHystrix.class)
public interface BaseQuestionFeign {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseQuestions/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestions/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseQuestion record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseQuestions/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseQuestion selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestions/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseQuestion record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestions/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseQuestion> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseQuestion record);

    /**
     * 分页和条件查询常见问题-前台
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseQuestions/selectListByConditionsForBg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<Map<String,Object>> selectListByConditionsForBg(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseQuestion record);
}