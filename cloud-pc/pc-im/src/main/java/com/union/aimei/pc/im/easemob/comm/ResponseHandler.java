package com.union.aimei.pc.im.easemob.comm;

import com.google.gson.Gson;
import io.swagger.client.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 返回处理
 *
 * @author liurenkai
 * @time 2018/8/13 18:59
 */
public class ResponseHandler {
    private static final Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    public static final int INVALID = 401;
    public static final int FREQUENT = 429;
    public static final int SERVER_CONNECTION_FAILED = 500;

    public Object handle(EasemobApi easemobApi) {
        Object result = null;
        try {
            result = easemobApi.invokeEasemobAPI();
        } catch (ApiException e) {
            if (e.getCode() == INVALID) {
                logger.info("The current token is invalid, re-generating token for you and calling it again");
                TokenUtil.initTokenByProp();
                try {
                    result = easemobApi.invokeEasemobAPI();
                } catch (ApiException e1) {
                    logger.error(e1.getMessage());
                }
                return result;
            }
            if (e.getCode() == FREQUENT) {
                logger.warn("The api call is too frequent");
            }
            if (e.getCode() >= SERVER_CONNECTION_FAILED) {
                logger.info("The server connection failed and is being reconnected");
                result = retry(easemobApi);
                if (result != null) {
                    return result;
                }
                System.out.println(e);
                logger.error("The server may be faulty. Please try again later");
            }
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(e.getResponseBody(), Map.class);
            logger.error("error_code:{} error_msg:{} error_desc:{}", e.getCode(), e.getMessage(), map.get("error_description"));
        }
        return result;
    }

    public Object retry(EasemobApi easemobApi) {
        Object result = null;
        long time = 5;
        int retryNumber = 3;
        for (int i = 0; i < retryNumber; i++) {
            try {
                TimeUnit.SECONDS.sleep(time);
                logger.info("Reconnection is in progress..." + i);
                result = easemobApi.invokeEasemobAPI();
                if (result != null) {
                    return result;
                }
            } catch (ApiException e1) {
                time *= 3;
            } catch (InterruptedException e1) {
                logger.error(e1.getMessage());
            }
        }
        return result;
    }
}
