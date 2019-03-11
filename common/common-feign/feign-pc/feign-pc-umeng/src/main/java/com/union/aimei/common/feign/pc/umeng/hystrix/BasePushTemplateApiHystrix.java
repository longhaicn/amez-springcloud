package com.union.aimei.common.feign.pc.umeng.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.umeng.BasePushTemplate;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author dell
 */
@Component(value = "pc-BasePushTemplateFeign")
public class BasePushTemplateApiHystrix implements BasePushTemplateFeign {

       /**
        * 前端分页查询友盟推送消息模板(新)
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param basePushTemplate 查询条件
        * @return 
        */
       @Override
       public PageInfo<BasePushTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BasePushTemplate basePushTemplate) {
              return null;
       }

       /**
        * 添加友盟推送消息模板(新)
        * @param basePushTemplate
        * @return
        */
       @Override
       public int insert(BasePushTemplate basePushTemplate) {
              return 0;
       }

       /**
        * 删除友盟推送消息模板(新)
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改友盟推送消息模板(新)
        * @param basePushTemplate
        * @return
        */
       @Override
       public int edit(BasePushTemplate basePushTemplate) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbasePushTemplate
        */
       @Override
       public BasePushTemplate queryById(int id) {
              return null;
       }


       @Override
       public ResponseMessage sendMessage(List<SendMsgParamVo> sendMsgParamVo) {
              return null;
       }

       @Override
       public ResponseMessage testNotificat(Integer role, String token,Integer deviceType) {
              return null;
       }

}