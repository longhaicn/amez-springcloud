package com.union.aimei.pc.product.service.impl;

import com.union.aimei.pc.product.mapper.ActivityProductRefMapper;
import com.union.aimei.pc.product.service.ActivityProductRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 活动-项目-关联
 *
 * @author liurenkai
 * @time 2018/5/14 11:25
 */
@Service("activityProductRefService")
public class ActivityProductRefServiceImpl implements ActivityProductRefService {
    @Resource
    private ActivityProductRefMapper activityProductRefMapper;

}