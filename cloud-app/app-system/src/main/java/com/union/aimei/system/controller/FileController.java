//package com.union.aimei.system.controller;
//
//import com.union.common.utils.ResponseMessage;
//import io.swagger.annotations.*;
//import org.apache.commons.collections.MapUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import java.util.*;
//
///**
// * FileController
// *
// * @author liufeihua
// * @date 2017/12/19 16:48
// */
//@Api(tags = "fastdfs上传文件", description = "api")
//@RefreshScope
//@RestController
//@RequestMapping("/system/api/file/")
//public class FileController {
//
//    @Value("${fastdfs.address}")
//    private String fastdfsAddress;
//
//    @Autowired
//    private FastDFSClient fastDFSClient;
//
//    /**
//     * param: [filedata]
//     * describe: 上传文件
//     * create_by: liufeihua in 2017/12/19 16:49
//     */
//    @ApiOperation("上传文件")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "form", name = "filedata", dataType = "MultipartFile", value = "上传的文件", defaultValue = ""),
//    })
//    @ApiResponses({
//            @ApiResponse(code = 400, message = "请求参数没填好"),
//            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
//    })
//    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
//    public ResponseMessage<String> uploadFile(@RequestParam(value = "file") MultipartFile filedata) {
//        ResponseMessage<String> message = new ResponseMessage<>();
//        if (filedata != null && !filedata.isEmpty()) {
//            try {
//                String path = fastDFSClient.uploadFile(fastdfsAddress, filedata, filedata.getOriginalFilename());
//
//                message.setData(path);
//                message.setMessage("上传成功");
//            } catch (Exception e) {
//                e.printStackTrace();
//                message.setMessage("上传失败");
//            }
//        } else {
//            message.setMessage("参数丢失");
//        }
//        return message;
//
//    }
//
//    /**
//     * 上传附件
//     *
//     * @param request
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "上传附件(针对kindeditor)", httpMethod = "POST")
//    @PostMapping(value = "uploadForKindeditor")
//    public Map<String, Object> uploadForKindeditor(MultipartHttpServletRequest request) throws Exception {
//        Map<String, MultipartFile> fileMap = request.getFileMap();
//
//        Map<String, Object> result = new Hashtable<>();
//
//        if (MapUtils.isEmpty(fileMap)) {
//            result.put("error", "上传的文件不能为空");
//            return result;
//        }
//
//        List<String> urlList = new ArrayList<>(10);
//        StringBuilder titleName = new StringBuilder();
//        Iterator<String> keyIterator = fileMap.keySet().iterator();
//        while (keyIterator.hasNext()) {
//            MultipartFile file = fileMap.get(keyIterator.next());
//            urlList.add(fastDFSClient.uploadFile(fastdfsAddress, file, file.getOriginalFilename()));
//
//            titleName = titleName.append(",").append(file.getOriginalFilename());
//        }
//
//        if (urlList.size() == 1) {
//            result.put("url", urlList.get(0));
//        } else {
//            result.put("url", urlList);
//        }
//
//        result.put("title", titleName);
//        result.put("error", 0);
//
//
//        return result;
//    }
//}
