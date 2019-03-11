package com.union.aimei.pc.crontab.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.TaskInfo;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/14 14:28
 * @description
 */
public interface TaskService {

    /**
     * 获取分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<TaskInfo> list(int pageNo, int pageSize);

    /**
     * 获取全部
     *
     * @return
     */
    List<TaskInfo> getList();

    /**
     * 添加
     *
     * @param info
     */
    void addJob(TaskInfo info);

    /**
     * 编辑
     *
     * @param info
     */
    void edit(TaskInfo info);

    /**
     * 删除
     *
     * @param jobName
     * @param jobGroup
     */
    void delete(String jobName, String jobGroup);

    /**
     * 暂停单个
     *
     * @param jobName
     * @param jobGroup
     */
    void pause(String jobName, String jobGroup);

    /**
     * 重启单个
     *
     * @param jobName
     * @param jobGroup
     */
    void resume(String jobName, String jobGroup);

    /**
     * 全部暂停
     */
    void pauseAll();

    /**
     * 全部重启
     */
    void resumeAll();

    /**
     * 查询是否存在
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    boolean checkExists(String jobName, String jobGroup) throws SchedulerException;
}
