package com.union.aimei.pc.im.easemob.api.impl;

import com.union.aimei.pc.im.easemob.api.AuthTokenApi;
import com.union.aimei.pc.im.easemob.comm.TokenUtil;

/**
 * 环信认证令牌
 *
 * @author liurenkai
 * @time 2018/8/13 19:29
 */
public class EasemobAuthToken implements AuthTokenApi {

    @Override
    public Object getAuthToken() {
        return TokenUtil.getAccessToken();
    }
}
