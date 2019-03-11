package com.union.aimei.im.controller;

import com.union.aimei.im.service.EasemobImChatFilesService;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;

/**
 * IM聊天文件controller
 *
 * @author liurenkai
 * @time 2017/11/29 16:35
 */
@Api(tags = "IM聊天文件 controller")
@RestController
@RequestMapping(value = "/easemob/im/chatFiles")
public class EasemobImChatFilesController {
    @Resource
    private EasemobImChatFilesService easemobImChatFilesService;

    /**
     * 上传聊天文件
     *
     * @param multipartFile 聊天文件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "上传聊天文件")
    @PostMapping("/upload")
    public ResponseMessage<ResponseResult> upload(@ApiParam(value = "聊天文件") @RequestParam(value = "file") CommonsMultipartFile multipartFile) {
        return easemobImChatFilesService.upload(multipartFile);
    }

    /**
     * 下载聊天文件
     *
     * @param fileUUID    文件UUID
     * @param shareSecret 共享秘钥
     * @param isThumbnail 是否缩略图
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "下载聊天文件")
    @PostMapping("/download")
    public ResponseMessage<ResponseResult> download(@ApiParam(value = "文件UUID") @RequestParam(value = "fileUUID") String fileUUID, @ApiParam(value = "共享秘钥") @RequestParam(value = "shareSecret") String shareSecret, @ApiParam(value = "是否缩略图") @RequestParam(value = "isThumbnail") boolean isThumbnail) {
        return easemobImChatFilesService.download(fileUUID, shareSecret, isThumbnail);
    }

}