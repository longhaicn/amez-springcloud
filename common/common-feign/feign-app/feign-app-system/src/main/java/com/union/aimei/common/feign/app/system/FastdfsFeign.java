package com.union.aimei.common.feign.app.system;//package com.union.aimei.app.api.system.feigin;
//
//import com.union.aimei.common.feign.app.system.hystrix.FastdfsFeignHystrix;
//import com.union.common.utils.ResponseMessage;
//import feign.codec.Encoder;
//import feign.form.spring.SpringFormEncoder;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.okhttp.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import java.util.Map;
//
///**
// * describe: TODO
// * creat_by: liufeihua in ${date} ${time}
// */
//@FeignClient(name = "app-system-service", configuration = FastdfsFeign.MultipartSupportConfig.class, fallback = FastdfsFeignHystrix.class)
//public interface FastdfsFeign {
//
//    public class MultipartSupportConfig {
//
//        @Bean
//        public Encoder feignFormEncoder() {
//            return new SpringFormEncoder();
//        }
//    }
//
//    /**
//     * param: [filedata]
//     * describe: 上传文件
//     * create_by: liufeihua in 2017/12/19 16:49
//     */
//    @PostMapping(value = "/system/api/file/uploadFile", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    ResponseMessage<String> uploadFile(MultipartFile filedata);
//
//    /**
//     * 上传附件
//     *
//     * @param request
//     * @param request
//     * @return
//     * @throws exception
//     */
//    @PostMapping(value = {"/system/api/file/uploadForKindeditor"})
//    Map<String, Object> uploadForKindeditor(@RequestParam(value = "file") MultipartHttpServletRequest request) throws exception;
//}
