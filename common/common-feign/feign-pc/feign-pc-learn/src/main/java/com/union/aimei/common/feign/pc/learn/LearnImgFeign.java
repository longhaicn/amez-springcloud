package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.LearnImgApiHystrix;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgInsertBatchVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId="PC-LEARN-SERVICE",fallback=LearnImgApiHystrix.class)
public interface LearnImgFeign {
       /**
        * 添加学习图片
        * @param learnImg
        * @return
        */
       @PostMapping(value="/learnImg/insert")
       int insert(@RequestBody LearnImg learnImg);


       /**
        * 批量添加
        * @param learnImgInsertBatchVo
        */
       @PostMapping(value="/learnImg/insertBatch")
       void insertBatch(@RequestBody LearnImgInsertBatchVo learnImgInsertBatchVo);

       /**
        * 删除学习图片
        * @param id
        * @return
        */
       @DeleteMapping(value="/learnImg/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改学习图片
        * @param learnImg
        * @return
        */
       @PutMapping(value="/learnImg/edit")
       int edit(@RequestBody LearnImg learnImg);

       /**
        * 根据ID查询
        * @param id
        * @returnlearnImg
        */
       @GetMapping(value="/learnImg/queryById/{id}")
       LearnImg queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询学习图片
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param learnImg 查询条件
     * @return
     */
       @PostMapping(value="/learnImg/front/findByPage")
       PageInfo<LearnImg> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody LearnImg learnImg);

       /**
        * 根据LearnImg查询活动，课程，文章的主图片
        * @param learnImg
        * @return
        */
       @PostMapping(value="/learnImg/queryImgListByLearnImg")
       List<String> queryImgListByLearnImg(@RequestBody LearnImg learnImg);
}