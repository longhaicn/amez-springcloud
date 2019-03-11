package com.union.aimei.pc.im.service;

import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * IM聊天文件 api
 *
 * @author liurenkai
 * @time 2017/11/30 16:39
 */
public interface EasemobImChatFilesService {

    /**
     * 上传语音/图片文件
     *
     * @param multipartFile 文件
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> upload(CommonsMultipartFile multipartFile);

    /**
     * 下载语音/图片文件
     *
     * @param fileUUID    文件UUID
     * @param shareSecret 共享秘钥
     * @param isThumbnail 是否缩略图
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> download(String fileUUID, String shareSecret, boolean isThumbnail);

}
