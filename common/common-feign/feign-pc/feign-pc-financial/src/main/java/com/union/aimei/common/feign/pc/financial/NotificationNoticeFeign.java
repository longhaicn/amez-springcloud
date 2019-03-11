package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.NotificationNoticeHystrix;
import com.union.aimei.common.model.financial.NotificationNotice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-financial-service", fallback = NotificationNoticeHystrix.class)
public interface NotificationNoticeFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/notificationNotices/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/notificationNotices/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody NotificationNotice record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/notificationNotices/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    NotificationNotice selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/notificationNotices/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody NotificationNotice record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/notificationNotices/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<NotificationNotice> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody NotificationNotice record);
}