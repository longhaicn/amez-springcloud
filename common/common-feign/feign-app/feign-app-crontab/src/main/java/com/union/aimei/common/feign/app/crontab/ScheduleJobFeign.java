package com.union.aimei.common.feign.app.crontab;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.crontab.hystrix.ScheduleJobHystrix;
import com.union.aimei.common.model.crontab.ScheduleJob;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author dell
 */
@FeignClient(name = "app-crontab-service", fallback = ScheduleJobHystrix.class)
public interface ScheduleJobFeign {
    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody ScheduleJob record);

    /**
     * 查看
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ScheduleJob selectByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody ScheduleJob record);

    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<ScheduleJob> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody ScheduleJob record);
}