package com.union.aimei.pc.im.common;

/**
 * 常量类
 *
 * @author liurenkai
 * @time 2017/11/30 14:04
 */
public class Constants {

    /**
     * 布尔
     */
    public interface Bool {
        /**
         * 是
         */
        public static final String TRUE = "1";
        /**
         * 否
         */
        public static final String FALSE = "0";
    }

    /**
     * 消息类型
     */
    public interface MsgType {
        /**
         * 文本消息
         */
        public static final String TXT = "txt";
        /**
         * 图片消息
         */
        public static final String IMG = "img";
        /**
         * 语音消息
         */
        public static final String AUDIO = "audio";
        /**
         * 视频消息
         */
        public static final String VIDEO = "video";
        /**
         * 透传消息
         */
        public static final String CMD = "cmd";
        /**
         * 地址位置消息
         */
        public static final String LOC = "loc";
        /**
         * 文件消息
         */
        public static final String FILE = "file";
    }

}
