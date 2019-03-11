package com.union.aimei.common.feign.pc.system.hystrix;

import com.union.aimei.common.feign.pc.system.TextAntispamScanFeign;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * TextAntispamScanHystrix
 *
 * @author liufeihua
 * @date 2018/4/27 9:23
 */
@Component(value = "pc-TextAntispamScanFeign")
public class TextAntispamScanHystrix implements TextAntispamScanFeign {
    @Override
    public ResponseMessage<String> textAntispamScan(String textContent) {
        return null;
    }
}
