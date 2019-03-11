package com.union.aimei.common.feign.im.pc;

import com.union.aimei.common.feign.im.pc.hystrix.EasemobImChatFilesFeignHystrix;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * IM聊天文件 service
 *
 * @author liurenkai
 * @time 2017/11/30 16:39
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = EasemobImChatFilesFeignHystrix.class)
public interface EasemobImChatFilesFeign {

    /**
     * 上传语音/图片文件
     *
     * @param multipartFile 文件
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "上传聊天文件")
    @PostMapping("/easemob/im/chatFiles/upload")
    ResponseMessage<ResponseResult> upload(@ApiParam(value = "聊天文件") @RequestParam(value = "file") CommonsMultipartFile multipartFile);

    /**
     * 下载语音/图片文件
     *
     * @param fileUUID    文件UUID
     * @param shareSecret 共享秘钥
     * @param isThumbnail 是否缩略图
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "下载聊天文件")
    @PostMapping("/easemob/im/chatFiles/download")
    ResponseMessage<ResponseResult> download(@ApiParam(value = "文件UUID") @RequestParam(value = "fileUUID") String fileUUID, @ApiParam(value = "共享秘钥") @RequestParam(value = "shareSecret") String shareSecret, @ApiParam(value = "是否缩略图") @RequestParam(value = "isThumbnail") boolean isThumbnail);
}
