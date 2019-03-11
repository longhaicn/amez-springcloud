package com.union.aimei.pay.util;

import java.net.InetAddress;

/**
 * @author GaoWei
 * descrption: 网络相关工具类
 * time  2018/1/29 22:22
 */
public class InetUtil {
    /**
     * 获取Ip
     *
     * @return
     */
    public static String getIp() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            String localip = ia.getHostAddress();
            return localip;
        } catch (Exception e) {
            return null;
        }
    }

}
