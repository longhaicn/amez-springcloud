package com.union.aimei.common.feign.app.system;

import com.union.aimei.common.feign.app.system.hystrix.TextAntispamScanHystrix;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TextAntispamScanController
 *
 * @author liufeihua
 * @date 2018/4/26 16:39
 */
@FeignClient(name = "app-system-service", fallback = TextAntispamScanHystrix.class)
public interface TextAntispamScanFeign {


    /**
     * 检验
     *
     * @param textContent
     * @return
     */
    @GetMapping("/text/textAntispamScan/{textContent}")
    ResponseMessage<String> textAntispamScan(@PathVariable("textContent") String textContent);

}
