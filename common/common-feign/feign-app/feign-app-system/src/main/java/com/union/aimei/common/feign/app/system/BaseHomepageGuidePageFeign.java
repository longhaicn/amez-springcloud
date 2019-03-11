package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseHomepageGuidePageHystrix;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "app-system-service", fallback = BaseHomepageGuidePageHystrix.class)
public interface BaseHomepageGuidePageFeign {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseHomepageGuidePages/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseHomepageGuidePages/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseHomepageGuidePage record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseHomepageGuidePages/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseHomepageGuidePage selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseHomepageGuidePages/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseHomepageGuidePage record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseHomepageGuidePages/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseHomepageGuidePage> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseHomepageGuidePage record);
}