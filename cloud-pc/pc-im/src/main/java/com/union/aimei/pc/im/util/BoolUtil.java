package com.union.aimei.pc.im.util;

import com.union.aimei.pc.im.common.Constants;

/**
 * 布尔
 *
 * @author liurenkai
 * @time 2017/11/30 14:03
 */
public class BoolUtil {

    /**
     * 转换为字符值
     *
     * @param value 值
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:09
     */
    public static String toChar(boolean value) {
        return value ? Constants.Bool.TRUE : Constants.Bool.FALSE;
    }

    /**
     * 转换为布尔值
     *
     * @param value 值
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:09
     */
    public static boolean toBool(String value) {
        return (value.equals(Constants.Bool.TRUE)) ? true : false;
    }
}
