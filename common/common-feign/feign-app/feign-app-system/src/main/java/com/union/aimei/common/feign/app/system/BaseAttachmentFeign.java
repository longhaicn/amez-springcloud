package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseAttachmentHystrix;
import com.union.aimei.common.model.system.BaseAttachment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "app-system-service", fallback = BaseAttachmentHystrix.class)
public interface BaseAttachmentFeign {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseAttachments/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseAttachments/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseAttachment record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/baseAttachments/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseAttachment selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseAttachments/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseAttachment record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseAttachments/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseAttachment> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseAttachment record);
}