package com.union.aimei.app.api.system;

import com.union.aimei.common.feign.app.system.TextAntispamScanFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TextAntispamScanController
 *
 * @author liufeihua
 * @date 2018/4/26 16:39
 */
@Api(tags = "内容检查", description = "api")
@RestController
@RequestMapping("/text")
public class TextAntispamScanController {

    @Autowired
    TextAntispamScanFeign textAntispamScanFeign;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "验证文字", notes = "建议用户处理，取值范围：[“pass”, “review”, “block”], pass:文本正常，review：需要人工审核，block：文本违规，可以直接删除或者做限制处理")
    @GetMapping("/textAntispamScan/{textContent}")
    public ResponseMessage<String> textAntispamScan(@PathVariable("textContent") String textContent) {
        return textAntispamScanFeign.textAntispamScan(textContent);
    }

}
