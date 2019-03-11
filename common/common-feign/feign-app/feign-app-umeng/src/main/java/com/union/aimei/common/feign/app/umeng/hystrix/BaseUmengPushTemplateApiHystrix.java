package com.union.aimei.common.feign.app.umeng.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.umeng.BaseUmengPushTemplateFeign;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component(value = "app-BaseUmengPushTemplateFeign")
public class BaseUmengPushTemplateApiHystrix implements BaseUmengPushTemplateFeign {

       /**
        * 前端分页查询U盟第三方推送记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseUmengPushTemplate 查询条件
        * @return 
        */
       @Override
       public PageInfo<BaseUmengPushTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BaseUmengPushTemplate baseUmengPushTemplate) {
              return null;
       }

       @Override
       public void testIOSBeautician(BaseUmengPushTemplate baseUmengPushTemplate) {

       }

       @Override
       public void sendMessage(BaseUmengPushTemplate baseUmengPushTemplate) {

       }

       @Override
       public void sendMessageBatch(BaseUmengPushTemplate baseUmengPushTemplate) {

       }

       @Override
       public void sendMessageDiffBatch(List<BaseUmengPushTemplate> list) {

       }

       /**
        * 添加U盟第三方推送记录表
        * @param baseUmengPushTemplate
        * @return
        */
       @Override
       public int insert(BaseUmengPushTemplate baseUmengPushTemplate) {
              return 0;
       }

       /**
        * 删除U盟第三方推送记录表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改U盟第三方推送记录表
        * @param baseUmengPushTemplate
        * @return
        */
       @Override
       public int edit(BaseUmengPushTemplate baseUmengPushTemplate) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbaseUmengPushTemplate
        */
       @Override
       public BaseUmengPushTemplate queryById(int id) {
              return null;
       }
}