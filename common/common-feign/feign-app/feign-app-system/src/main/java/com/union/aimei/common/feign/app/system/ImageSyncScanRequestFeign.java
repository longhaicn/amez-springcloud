package com.union.aimei.common.feign.app.system;

import com.union.aimei.common.feign.app.system.hystrix.ImageSyncScanRequestHystrix;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 图片同步检测接口
 *
 * @author liufeihua
 * @date 2018/4/26 18:02
 */
@FeignClient(name = "app-system-service", fallback = ImageSyncScanRequestHystrix.class)
public interface ImageSyncScanRequestFeign {

    /**
     * 检验
     * @param imageUrl
     * @return
     */
    @PostMapping("/images/imageAntispamScan/")
    ResponseMessage<String> imageAntispamScan(@RequestParam(value = "imageUrl") String imageUrl);

}
