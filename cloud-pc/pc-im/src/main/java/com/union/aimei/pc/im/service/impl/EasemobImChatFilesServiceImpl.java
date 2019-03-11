package com.union.aimei.pc.im.service.impl;

import com.google.gson.Gson;
import com.union.aimei.pc.im.easemob.api.impl.EasemobFile;
import com.union.aimei.pc.im.service.EasemobImChatFilesService;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * IM聊天文件 api impl
 *
 * @author liurenkai
 * @time 2017/11/29 16:54
 */
@Service("easemobImChatFilesService")
public class EasemobImChatFilesServiceImpl implements EasemobImChatFilesService {

    @Override
    public ResponseMessage upload(CommonsMultipartFile multipartFile) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobFile easemobFile = new EasemobFile();
        DiskFileItem dfi = (DiskFileItem) multipartFile.getFileItem();
        File file = dfi.getStoreLocation();
        Object responseObject = easemobFile.uploadFile(file);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage download(String fileUUID, String shareSecret, boolean isThumbnail) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobFile easemobFile = new EasemobFile();
        Object responseObject = easemobFile.downloadFile(fileUUID, shareSecret, isThumbnail);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

}