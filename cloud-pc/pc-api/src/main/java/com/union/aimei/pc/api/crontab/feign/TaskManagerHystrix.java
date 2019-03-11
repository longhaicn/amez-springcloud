package com.union.aimei.pc.api.crontab.feign;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.TaskInfo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @time 2018/6/14 15:34
 * @description
 */
@Component
public class TaskManagerHystrix implements TaskManagerFeign{

    @Override
    public ResponseMessage<PageInfo<TaskInfo>> list(int pageNo, int pageSize) {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage save(TaskInfo info) {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage delete(String jobName, String jobGroup) {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage pause(String jobName, String jobGroup) {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage resume(String jobName, String jobGroup) {
        throw new ServerException(500,"服务或网络不稳定");
    }


    @Override
    public ResponseMessage pauseAll() {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage resumeAll() {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage edit(TaskInfo info) {
        throw new ServerException(500,"服务或网络不稳定");
    }
}
