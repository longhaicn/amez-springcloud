package com.union.aimei.pc.system.utils;

import com.union.common.utils.encryption.Md5Util;

import java.security.MessageDigest;

/**
 * Md5Utils
 *
 * @author liufeihua
 * @date 2018/3/12 15:43
 */
public class Md5Utils {

    public static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] hes;
        hes = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(hes[(bytes[i] >> 4) & 0x0f]);
            ret.append(hes[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.md5("123456"));
    }
}
