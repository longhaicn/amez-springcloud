package com.union.aimei.umeng.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BasePushTemplateService extends SpringCloudBaseService<BasePushTemplate> {
       /**
        * 前端分页查询友盟推送消息模板(新)
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param basePushTemplate 查询条件
        * @return 
        */
       PageInfo<BasePushTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BasePushTemplate basePushTemplate);


    /**
     * 推送消息
     * @param sendMsgParamVo
     * @return
     */
    ResponseMessage sendMessage(List<SendMsgParamVo> sendMsgParamVo);

    /**
     * ios测试通知的
     * @param role
     * @param token
     * @param deviceType
     * @return
     */
    ResponseMessage testNotificat(Integer role,String token,Integer deviceType);

}