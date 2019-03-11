package com.union.aimei.app.api.crontab.feign;

import com.github.pagehelper.PageInfo;
import com.union.aimei.app.api.crontab.feign.hystrix.ScheduleJobHystrix;
import com.union.aimei.common.model.crontab.ScheduleJob;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaowei
 */
@FeignClient(name = "app-crontab-service", fallback = ScheduleJobHystrix.class)
public interface ScheduleJobFeign {
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 添加
      * @param record
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody ScheduleJob record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ScheduleJob selectByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody ScheduleJob record);

    /**
     * 选择列表的条件
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<ScheduleJob> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody ScheduleJob record);
}