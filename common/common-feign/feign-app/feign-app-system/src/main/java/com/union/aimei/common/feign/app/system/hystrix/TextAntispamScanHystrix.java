package com.union.aimei.common.feign.app.system.hystrix;

import com.union.aimei.common.feign.app.system.TextAntispamScanFeign;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * TextAntispamScanHystrix
 *
 * @author liufeihua
 * @date 2018/4/27 9:23
 */
@Component(value = "app-TextAntispamScanFeign")
public class TextAntispamScanHystrix implements TextAntispamScanFeign{
    @Override
    public ResponseMessage<String> textAntispamScan(String textContent) {
        return null;
    }
}
