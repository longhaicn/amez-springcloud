package com.union.aimei.common.feign.pc.system;

import com.union.aimei.common.feign.pc.system.hystrix.TextAntispamScanHystrix;
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
@FeignClient(name = "pc-system-service", fallback = TextAntispamScanHystrix.class)
public interface TextAntispamScanFeign {


    /**
     * 查看
     *
     * @param textContent
     * @return
     */
    @GetMapping("/text/textAntispamScan/{textContent}")
    ResponseMessage<String> textAntispamScan(@PathVariable("textContent") String textContent);

}
