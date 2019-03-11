package com.union.aimei.common.util;

import com.union.common.baidumap.util.BaiDuMapApi;
import com.union.common.baidumap.util.MapUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 百度地图
 *
 * @author liurenkai
 * @time 2018/1/15 17:10
 */
public class BaiDuMapUtil {

    /**
     * 获取坐标
     *
     * @param request
     * @return
     */
    public static BaiDuMapApi.Point getPoint(HttpServletRequest request) {
        BaiDuMapApi.Point point = new BaiDuMapApi.Point();
        // 经纬度获取不完善的时候-调用百度地图API获取当前位置
        String ipStr = IpAddressUtils.getIpAddr(request);
        BaiDuMapApi baiDuMapApi = MapUtil.getLocation(ipStr);
        if (null != baiDuMapApi) {
            // 当前位置
            point = baiDuMapApi.getContent().getPoint();
        }
        return point;
    }

}
