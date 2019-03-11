package com.union.aimei.im.easemob.comm;

import io.swagger.client.ApiException;

/**
 * 环信API
 *
 * @author liurenkai
 * @time 2018/8/13 15:12
 */
public interface EasemobApi {

    /**
     * 调用环信API
     *
     * @return
     * @throws ApiException
     */
    Object invokeEasemobAPI() throws ApiException;
}