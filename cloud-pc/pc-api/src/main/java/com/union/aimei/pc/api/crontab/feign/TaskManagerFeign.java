package com.union.aimei.pc.api.crontab.feign;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.TaskInfo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author GaoWei
 * @time 2018/6/14 15:33
 * @description
 */
@FeignClient(name = "pc-crontab-service", fallback = TaskManagerHystrix.class)
public interface TaskManagerFeign {

    /**
     * 任务列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping(value = "/task/list")
    ResponseMessage<PageInfo<TaskInfo>> list(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize);


    /**
     * 保存定时任务
     *
     * @param info
     * @return
     */
    @PostMapping(value = "/task/save")
    ResponseMessage save(@RequestBody TaskInfo info);


    /**
     * 保存定时任务
     *
     * @param info
     * @return
     */
    @PostMapping(value = "/task/edit")
    public ResponseMessage edit(@RequestBody TaskInfo info);

    /**
     * 删除定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @GetMapping(value = "/task/delete/{jobName}/{jobGroup}")
    ResponseMessage delete(@PathVariable(value = "jobName") String jobName, @PathVariable(value = "jobGroup") String jobGroup);


    /**
     * 暂停定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @GetMapping(value = "/task/pause/{jobName}/{jobGroup}")
    ResponseMessage pause(@PathVariable(value = "jobName") String jobName, @PathVariable(value = "jobGroup") String jobGroup);

    /**
     * 暂停全部
     *
     * @return
     */
    @GetMapping(value = "/task/pauseAll")
    ResponseMessage pauseAll();


    /**
     * 重启全部
     *
     * @return
     */
    @GetMapping(value = "/task/resumeAll")
    ResponseMessage resumeAll();

    /**
     * 重新开始定时任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @GetMapping(value = "/task/resume/{jobName}/{jobGroup}")
    ResponseMessage resume(@PathVariable(value = "jobName") String jobName, @PathVariable(value = "jobGroup") String jobGroup);

}
