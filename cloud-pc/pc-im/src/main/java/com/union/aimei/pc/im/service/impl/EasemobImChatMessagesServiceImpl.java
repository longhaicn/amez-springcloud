package com.union.aimei.pc.im.service.impl;

import com.google.gson.*;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.common.vo.im.common.ImMessagesByBatchVo;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.aimei.pc.im.easemob.api.impl.EasemobChatMessage;
import com.union.aimei.pc.im.mapper.ImMessagesMapper;
import com.union.aimei.pc.im.service.EasemobImChatMessagesService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * IM聊天记录 api impl
 *
 * @author liurenkai
 * @time 2017/11/29 16:54
 */
@Service("easemobImChatMessagesService")
public class EasemobImChatMessagesServiceImpl implements EasemobImChatMessagesService {
    @Resource
    private ImMessagesMapper imMessagesMapper;

    @Override
    public ResponseMessage exportTime(String timeStr) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatMessage easemobChatMessage = new EasemobChatMessage();
        Object responseObject = easemobChatMessage.exportChatMessages(timeStr);
        if (null == responseObject) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        if (responseResult.getData() == null) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        List<Map<String, Object>> jsonArray = (List<Map<String, Object>>) responseResult.getData();
        String fileUrl = jsonArray.get(0).get("url").toString();
        try {
            readUrl(fileUrl, this.getClass().getResource("").getPath() + "\\" + timeStr + ".gz");
        } catch (IOException e) {
            responseMessage.setCode(ResponseContants.ADD);
            responseMessage.setMessage(e.getMessage());
            return responseMessage;
        }
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    /**
     * 读取URL
     *
     * @param fileUrl  文件地址
     * @param fileName 文件名
     * @throws IOException
     */
    public void readUrl(String fileUrl, String fileName) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);
        File file = new File(fileName);
        if (file.exists()) {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            addImMessages(readGzip(fileName));
        }
    }

    /**
     * 读取输入流
     *
     * @param is
     * @return
     * @throws IOException
     */
    public byte[] readInputStream(InputStream is) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    /**
     * 读取gzip文件
     *
     * @param fileName 文件名
     * @return
     * @throws IOException
     */
    public List<String> readGzip(String fileName) throws IOException {
        List<String> lines = new ArrayList<>(10);
        if (!fileName.isEmpty()) {
            InputStream in = new GZIPInputStream(new FileInputStream(fileName));
            Scanner sc = new Scanner(in, "UTF-8");
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        }
        return lines;
    }

    /**
     * 添加IM消息
     *
     * @param gzipList gzip文件内容
     */
    public void addImMessages(List<String> gzipList) {
        JsonArray jsonArray = new JsonParser().parse(gzipList.toString()).getAsJsonArray();
        Gson gson = new Gson();
        List<ImMessages> imMessagesList = new ArrayList<>(10);
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            ImMessages imMessages = new ImMessages();
            imMessages.setMsgId(jsonObject.get("msg_id").getAsString());
            imMessages.setSendTime(Long.valueOf(jsonObject.get("timestamp").getAsString()));
            imMessages.setDirection(jsonObject.get("direction").getAsString());
            imMessages.setFromName(jsonObject.get("from").getAsString());
            imMessages.setToName(jsonObject.get("to").getAsString());
            imMessages.setChatType(jsonObject.get("chat_type").getAsString());
            JsonObject payload = jsonObject.getAsJsonObject("payload");
            imMessages.setExt(gson.toJson(payload.getAsJsonObject("ext")));
            imMessages.setBodies(gson.toJson(payload.getAsJsonObject("bodies")));
            imMessagesList.add(imMessages);
        }
        this.imMessagesMapper.addBatch(new ImMessagesByBatchVo(imMessagesList));
    }

    @Override
    public ResponseMessage exportLimit(long limit, String cursor, String query) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatMessage easemobChatMessage = new EasemobChatMessage();
        Object responseObject = easemobChatMessage.exportChatMessages(limit, null, null);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

}