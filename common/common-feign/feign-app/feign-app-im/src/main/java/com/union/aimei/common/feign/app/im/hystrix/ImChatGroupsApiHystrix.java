package com.union.aimei.common.feign.app.im.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.im.ImChatGroupsFeign;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 19:19
 */
@Component(value = "app-ImChatGroupsFeign")
public class ImChatGroupsApiHystrix implements ImChatGroupsFeign {

    @Override
    public ResponseMessage<PageInfo<ImChatGroups>> pageByConditions(Integer pageNo, Integer pageSize, ImChatGroups imChatGroups) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ImChatGroups> add(ImChatGroups imChatGroups) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> removeById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> updateById(ImChatGroups imChatGroups) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ImChatGroups> getById(int id) {
        return HystrixResponse.invokeFail();
    }

}