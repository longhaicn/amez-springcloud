package com.union.aimei.pc.api.system;

import com.union.aimei.common.constant.system.Constant;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.*;

/**
 * AliOssController
 *
 * @author liufeihua
 * @date 2018/3/26 9:15
 */
@Api(tags = "啊里云OSS上传文件", description = "api")
@RefreshScope
@RestController
@RequestMapping("/system/api/file/")
public class AliOssController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OssClientUtil ossClientUtil;

    /**
     *
     * @param filedata
     * @return
     */
    @ApiOperation("上传文件")
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public ResponseMessage<String> uploadFile(@ApiParam("上传的文件") @RequestParam(value = "file") MultipartFile filedata) {
        ResponseMessage<String> message = new ResponseMessage<>();
        if (filedata != null && !filedata.isEmpty()) {
            try {

                String name = ossClientUtil.uploadImg2Oss(filedata);
                String path=ossClientUtil.getImgUrl(name);

                message.setData(path);
                message.setMessage("上传成功");
            } catch (Exception e) {
                e.printStackTrace();
                message.setMessage("上传失败");
            }
        } else {
            message.setMessage("参数丢失");
        }
        return message;

    }

    /**
     * 上传附件
     *
     * @param request
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "上传附件(针对kindeditor)", httpMethod = "POST")
    @PostMapping(value = "uploadForKindeditor")
    public Map<String, Object> uploadForKindeditor(MultipartHttpServletRequest request) throws Exception {
        Map<String, MultipartFile> fileMap = request.getFileMap();

        Map<String, Object> result = new Hashtable<>();

        if (MapUtils.isEmpty(fileMap)) {
            result.put("error", "上传的文件不能为空");
            return result;
        }

        List<String> urlList = new ArrayList<>(10);
        StringBuilder titleName = new StringBuilder();
        Iterator<String> keyIterator = fileMap.keySet().iterator();
        while (keyIterator.hasNext()) {
            MultipartFile file = fileMap.get(keyIterator.next());
            urlList.add(ossClientUtil.getImgUrl(ossClientUtil.uploadImg2Oss(file)));

            titleName = titleName.append(",").append(file.getOriginalFilename());
        }

        if (urlList.size() == 1) {
            result.put("url", urlList.get(0));
        } else {
            result.put("url", urlList);
        }

        result.put("title", titleName);
        result.put("error", 0);


        return result;
    }


    @ApiOperation(value = "一次上传多张图片", httpMethod = "POST")
    @RequestMapping("/someFile")
    public ResponseMessage<List<String>> threeFileUpload(@RequestParam("file") MultipartFile[] files) {

        List<String> list = new ArrayList<>(10);

        AssertUtil.isTrue(files.length>0,"上传文件不能为空", Constant.FILE_IS_NULL);

        for (MultipartFile file : files) {
            // 获得原始文件名
            String fileName = file.getOriginalFilename();
            logger.debug("原始文件名:" + fileName);

            String path = ossClientUtil.getImgUrl(ossClientUtil.uploadImg2Oss(file));

            logger.debug(path);
            list.add(path);

        }
        // 保存文件地址，用于JSP页面回显
        return new ResponseMessage<>(list);

    }
}
