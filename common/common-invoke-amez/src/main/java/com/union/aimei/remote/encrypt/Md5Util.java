package com.union.aimei.remote.encrypt;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @author GaoWei
 * @time 2018/6/8 16:08
 * @description
 */
public class Md5Util {

    /**
     * 获取32位随机数
     *
     * @return
     */
    public static String getRandom(Integer length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        String data = sb.toString();
        return data;
    }


    /**
     * 获取加密数据
     * @param accesskey
     * @param noneceStr
     * @param time
     * @param security
     * @return
     */
    public static String getEncrypteStr(String accesskey, String noneceStr, long time, String security) {
        StringBuilder sb = new StringBuilder();
        sb.append(accesskey);
        sb.append(noneceStr);
        sb.append(time);
        sb.append(security);
        return getMD5(sb.toString());
    }

    /**
     * 生成md5
     *
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        String md5str = "";
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2 将消息变成byte数组
            byte[] input = message.getBytes();

            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

}
