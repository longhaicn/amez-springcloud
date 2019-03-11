package com.union.aimei.common.feign.pc.system.hystrix;

import com.union.aimei.common.feign.pc.system.ImageSyncScanRequestFeign;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * ImageSyncScanRequestHystrix
 *
 * @author liufeihua
 * @date 2018/4/27 9:23
 */
@Component(value = "pc-ImageSyncScanRequestFeign")
public class ImageSyncScanRequestHystrix implements ImageSyncScanRequestFeign {
    @Override
    public ResponseMessage<String> imageAntispamScan(String imageUrl) {
        return null;
    }
}
