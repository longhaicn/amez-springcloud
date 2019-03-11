package com.union.aimei.pc.im.easemob.comm;

import io.swagger.client.ApiException;

/**
 * 环信API
 *
 * @author liurenkai
 * @time 2018/8/13 10:55
 */
public interface EasemobApi {

    /**
     * 调起环信API
     *
     * @return
     * @throws ApiException
     */
    Object invokeEasemobAPI() throws ApiException;
}