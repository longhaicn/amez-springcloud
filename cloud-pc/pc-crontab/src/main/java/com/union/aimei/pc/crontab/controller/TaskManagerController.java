package com.union.aimei.pc.crontab.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.TaskInfo;
import com.union.aimei.pc.crontab.service.TaskService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/14 14:34
 * @description 任务管理Controller
 */
@RestController
@RequestMapping(value = "/task")
@Api(tags = "quratz定时任务管理")
public class TaskManagerController {

    @Resource
    private TaskService taskService;

    /**
     * 任务列表
     * @return
     */
    @GetMapping(value="/list")
    public ResponseMessage<PageInfo<TaskInfo>> list(@RequestParam(value = "pageNo",defaultValue = "0")int pageNo,
                                                    @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        ResponseMessage<PageInfo<TaskInfo>> res=new ResponseMessage<>();
        res.setData(taskService.list(pageNo, pageSize));
        return res;
    }

    /**
     * 保存定时任务
     * @param info
     */
    @PostMapping(value="/save")
    public ResponseMessage save(@RequestBody TaskInfo info){
        try {
            taskService.addJob(info);
        } catch (Exception e) {
            throw new ServerException(500,"保存任务失败");
        }
        return new ResponseMessage();
    }

    /**
     * 编辑定时任务
     * @param info
     */
    @PostMapping(value="/edit")
    public ResponseMessage edit(@RequestBody TaskInfo info){
        try {
            taskService.edit(info);
        } catch (Exception e) {
            throw new ServerException(500,"修改任务失败");
        }
        return new ResponseMessage();
    }

    /**
     * 删除定时任务
     * @param jobName
     * @param jobGroup
     */
    @GetMapping(value="/delete/{jobName}/{jobGroup}")
    public ResponseMessage delete(@PathVariable(value = "jobName") String jobName, @PathVariable(value = "jobGroup") String jobGroup){
        try {
            taskService.delete(jobName, jobGroup);
        } catch (Exception e) {
            throw new ServerException(500,"删除任务失败");
        }
        return new ResponseMessage();
    }

    /**
     * 暂停定时任务
     * @param jobName
     * @param jobGroup
     */
    @GetMapping(value="/pause/{jobName}/{jobGroup}")
    public ResponseMessage pause(@PathVariable(value = "jobName") String jobName, @PathVariable(value = "jobGroup") String jobGroup){
        try {
            taskService.pause(jobName, jobGroup);
        } catch (Exception e) {
            throw new ServerException(500,"暂停任务失败");
        }
        return new ResponseMessage();
    }

    /**
     * 暂停全部
     * @return
     */
    @GetMapping(value="/pauseAll")
    public ResponseMessage pauseAll(){
        try {
            taskService.pauseAll();
        } catch (Exception e) {
            throw new ServerException(500,"暂停任务失败");
        }
        return new ResponseMessage();
    }

    /**
     * 重启全部
     * @return
     */
    @GetMapping(value="/resumeAll")
    public ResponseMessage resumeAll(){
        try {
            taskService.resumeAll();
        } catch (Exception e) {
            throw new ServerException(500,"暂停任务失败");
        }
        return new ResponseMessage();
    }

    /**
     * 重新开始定时任务
     * @param jobName
     * @param jobGroup
     */
    @GetMapping(value="/resume/{jobName}/{jobGroup}")
    public ResponseMessage resume(@PathVariable(value = "jobName") String jobName, @PathVariable(value = "jobGroup") String jobGroup){
        try {
            taskService.resume(jobName, jobGroup);
        } catch (Exception e) {
            throw new ServerException(500,"暂停任务失败");
        }
        return new ResponseMessage();
    }

}
