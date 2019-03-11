package com.union.aimei.app.api.system;

import com.union.aimei.common.feign.app.system.ImageSyncScanRequestFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图片同步检测接口
 *
 * @author liufeihua
 * @date 2018/4/26 18:02
 */
@Api(tags = "图片检测", description = "api")
@RestController
@RequestMapping("/images")
public class ImageSyncScanRequestController {

    @Autowired
    ImageSyncScanRequestFeign imageSyncScanRequestFeign;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "验证文字", notes = "建议用户处理，取值范围：[“pass”, “review”, “block”], pass:图片正常，review：需要人工审核，block：图片违规，可以直接删除或者做限制处理")
    @PostMapping("/imageAntispamScan/")
    public ResponseMessage<String> imageAntispamScan(@RequestParam(value = "imageUrl") String imageUrl) {
        return imageSyncScanRequestFeign.imageAntispamScan(imageUrl);
    }

}
