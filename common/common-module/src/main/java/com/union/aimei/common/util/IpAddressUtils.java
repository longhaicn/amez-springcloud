package com.union.aimei.common.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liurenkai
 * @time 2018/8/13 19:06
 */
public class IpAddressUtils {
    /**
     * 获取访问者IP
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     * <p>
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        String unknown = "unknown";
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String regex = ",";
        if (null != ip && ip.indexOf(regex) != -1) {
            String[] ips = ip.split(regex);
            for (int i = 0; i < ips.length; i++) {
                if (null != ips[i] && !unknown.equalsIgnoreCase(ips[i])) {
                    ip = ips[i];
                    break;
                }
            }
            String deaIp = "0:0:0:0:0:0:1";
            if (deaIp.equals(ip)) {
                ip = "127.0.0.1";
            }
        }
        return ip;
    }

    /**
     * 获取来访者的浏览器版本
     *
     * @param request
     * @return
     */
    public static String getRequestBrowserInfo(HttpServletRequest request) {
        String browserVersion = null;
        String header = request.getHeader("user-agent");
        if (header == null || "".equals(header)) {
            return "";
        }
        String msie = "MSIE";
        String firefox = "Firefox";
        String chrome = "Chrome";
        String safari = "Safari";
        String camino = "Camino";
        String konqueror = "Konqueror";
        if (header.indexOf(msie) > 0) {
            browserVersion = msie;
        } else if (header.indexOf(firefox) > 0) {
            browserVersion = firefox;
        } else if (header.indexOf(chrome) > 0) {
            browserVersion = chrome;
        } else if (header.indexOf(safari) > 0) {
            browserVersion = safari;
        } else if (header.indexOf(camino) > 0) {
            browserVersion = camino;
        } else if (header.indexOf(konqueror) > 0) {
            browserVersion = konqueror;
        }
        return browserVersion;
    }

    /**
     * 命令获取mac地址
     *
     * @param cmd
     * @return
     */
    private static String callCmd(String[] cmd) {
        String result = "";
        String line = "";
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader(is);
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param cmd     第一个命令
     * @param another 第二个命令
     * @return 第二个命令的执行结果
     */
    private static String callCmd(String[] cmd, String[] another) {
        String result = "";
        String line = "";
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            proc.waitFor();
            // 已经执行完第一个命令，准备执行第二个命令
            proc = rt.exec(another);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader(is);
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param ip           目标ip,一般在局域网内
     * @param sourceString 命令处理的结果字符串
     * @param macSeparator mac分隔符号
     * @return mac地址，用上面的分隔符号表示
     */
    private static String filterMacAddress(final String ip, final String sourceString, final String macSeparator) {
        String result = "";
        String regExp = "((([0-9,A-F,a-f]{1,2}" + macSeparator + "){1,5})[0-9,A-F,a-f]{1,2})";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(sourceString);
        while (matcher.find()) {
            result = matcher.group(1);
            if (sourceString.indexOf(ip) <= sourceString.lastIndexOf(matcher.group(1))) {
                break; // 如果有多个IP,只匹配本IP对应的Mac.
            }
        }
        return result;
    }

    /**
     * @param ip 目标ip
     * @return Mac Address
     */
    private static String getMacInWindows(final String ip) {
        String result = "";
        String[] cmd = {"cmd", "/c", "ping " + ip};
        String[] another = {"cmd", "/c", "arp -a"};
        String cmdResult = callCmd(cmd, another);
        result = filterMacAddress(ip, cmdResult, "-");
        return result;
    }

    /**
     * @param ip 目标ip
     * @return Mac Address
     */
    private static String getMacInLinux(final String ip) {
        String result = "";
        String[] cmd = {"/bin/sh", "-c", "ping " + ip + " -c 2 && arp -a"};
        String cmdResult = callCmd(cmd);
        result = filterMacAddress(ip, cmdResult, ":");
        return result;
    }

    /**
     * 获取MAC地址
     *
     * @return 返回MAC地址
     */
    public static String getMacAddress(String ip) {
        String macAddress = "";
        macAddress = getMacInWindows(ip).trim();
        if (macAddress == null || "".equals(macAddress)) {
            macAddress = getMacInLinux(ip).trim();
        }
        return macAddress;
    }
}
