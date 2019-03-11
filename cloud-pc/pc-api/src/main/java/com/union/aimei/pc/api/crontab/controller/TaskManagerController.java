package com.union.aimei.pc.api.crontab.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.TaskInfo;
import com.union.aimei.pc.api.crontab.feign.TaskManagerFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/14 15:32
 * @description
 */
@RestController
@Api(tags = "quartz定时任务")
@RequestMapping(value = "/task")
public class TaskManagerController {


    @Resource
    private TaskManagerFeign taskManagerFeign;


    /**
     * 任务列表
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "查询任务列表")
    @GetMapping(value="/list")
    public ResponseMessage<PageInfo<TaskInfo>> list(@RequestParam(value = "pageNo",defaultValue = "0")int pageNo,
                                                    @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return taskManagerFeign.list(pageNo, pageSize);
    }

    /**
     * 保存定时任务
     * @param info
     */
    @ApiOperation(httpMethod = "POST",value = "保存任务列表")
    @PostMapping(value="/save")
    public ResponseMessage save(@RequestBody TaskInfo info){
        return taskManagerFeign.save(info);
    }

    /**
     * 编辑定时任务
     * @param info
     */
    @ApiOperation(httpMethod = "POST",value = "修改任务列表")
    @PostMapping(value="/edit")
    public ResponseMessage edit(@RequestBody TaskInfo info){
        return taskManagerFeign.edit(info);
    }

    /**
     * 删除定时任务
     * @param jobName
     * @param jobGroup
     */
    @ApiOperation(httpMethod = "GET",value = "删除定时任务")
    @GetMapping(value="/delete/{jobName}/{jobGroup}")
    public ResponseMessage delete(@PathVariable String jobName, @PathVariable String jobGroup){
        return taskManagerFeign.delete(jobName, jobGroup);
    }

    /**
     * 暂停定时任务
     * @param jobName
     * @param jobGroup
     */
    @ApiOperation(httpMethod = "GET",value = "暂停单个定时任务")
    @GetMapping(value="/pause/{jobName}/{jobGroup}")
    public ResponseMessage pause(@PathVariable String jobName, @PathVariable String jobGroup){
        return taskManagerFeign.pause(jobName, jobGroup);
    }

    /**
     * 重新开始定时任务
     * @param jobName
     * @param jobGroup
     */
    @ApiOperation(httpMethod = "GET",value = "重新开始单个定时任务")
    @GetMapping(value="/resume/{jobName}/{jobGroup}")
    public ResponseMessage resume(@PathVariable String jobName, @PathVariable String jobGroup){
        return taskManagerFeign.resume(jobName, jobGroup);
    }


    /**
     * 暂停全部
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "暂停全部定时任务")
    @GetMapping(value="/pauseAll")
    public ResponseMessage pauseAll(){
        return taskManagerFeign.pauseAll();
    }

    /**
     * 重启全部
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "重新开始全部定时任务")
    @GetMapping(value="/resumeAll")
    public ResponseMessage resumeAll(){
        return taskManagerFeign.resumeAll();
    }
}
