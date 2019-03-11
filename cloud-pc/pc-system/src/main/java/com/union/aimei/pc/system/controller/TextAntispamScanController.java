package com.union.aimei.pc.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.green.model.v20170825.TextScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.union.aimei.pc.system.utils.BaseAntispam;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * TextAntispamScanController
 *
 * @author liufeihua
 * @date 2018/4/26 16:39
 */
@Api(tags = "内容检查", description = "api")
@RestController
@RequestMapping("/text")
public class TextAntispamScanController extends BaseAntispam {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "验证文字", notes = "建议用户处理，取值范围：[“pass”, “review”, “block”], pass:文本正常，review：需要人工审核，block：文本违规，可以直接删除或者做限制处理")
    @GetMapping("/textAntispamScan/{textContent}")
    public ResponseMessage<String> textAntispamScan(@PathVariable("textContent") String textContent) throws ClientException, UnsupportedEncodingException {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(getEndPointName(), regionId, "Green", getDomain());

        IAcsClient client = new DefaultAcsClient(profile);

        TextScanRequest textScanRequest = new TextScanRequest();
        textScanRequest.setAcceptFormat(FormatType.JSON);
        textScanRequest.setMethod(com.aliyuncs.http.MethodType.POST);
        textScanRequest.setEncoding("UTF-8");
        textScanRequest.setRegionId(regionId);

        List<Map<String, Object>> tasks = new ArrayList<>(10);
        Map<String, Object> task1 = new LinkedHashMap<>(16);
        task1.put("dataId", UUID.randomUUID().toString());
        task1.put("content", textContent);

        tasks.add(task1);

        JSONObject data = new JSONObject();
        data.put("scenes", Arrays.asList("antispam"));
        data.put("tasks", tasks);

        textScanRequest.setHttpContent(data.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        textScanRequest.setConnectTimeout(3000);
        textScanRequest.setReadTimeout(6000);
        HttpResponse httpResponse = client.doAction(textScanRequest);

        if (httpResponse.isSuccess()) {
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
            logger.debug(JSON.toJSONString(scrResponse, true));
            int i = 200;
            String code = "code";
            if (i == scrResponse.getInteger(code)) {
                JSONArray taskResults = scrResponse.getJSONArray("data");
                for (Object taskResult : taskResults) {
                    if (i == ((JSONObject) taskResult).getInteger("code")) {
                        JSONArray sceneResults = ((JSONObject) taskResult).getJSONArray("results");
                        for (Object sceneResult : sceneResults) {
                            String scene = ((JSONObject) sceneResult).getString("scene");
                            String suggestion = ((JSONObject) sceneResult).getString("suggestion");
                            //根据scene和suggetion做相关的处理
                            //do something
                            logger.debug("args = [" + scene + "]");
                            logger.debug("args = [" + suggestion + "]");
                            ResponseMessage<String> responseMessage = null;
                            switch (suggestion) {
                                case "pass":
                                    responseMessage = new ResponseMessage<>(i, "符合要求!");
                                    break;
                                case "review":
                                    responseMessage = new ResponseMessage<>(201, "需要人工审核!");
                                    break;
                                case "block":
                                    responseMessage = new ResponseMessage<>(202, "文本违规!");
                                    break;
                                default:
                            }
                            return responseMessage;
                        }
                    } else {
                        logger.debug("task process fail:" + ((JSONObject) taskResult).getInteger("code"));
                    }
                }
            } else {
                logger.debug("detect not success. code:" + scrResponse.getInteger("code"));
            }
        } else {
            logger.debug("response not success. status:" + httpResponse.getStatus());
        }

        return new ResponseMessage<>();
    }
}
