package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.ArticleApiHystrix;
import com.union.aimei.common.model.learn.Article;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId="PC-LEARN-SERVICE",fallback=ArticleApiHystrix.class)
public interface ArticleFeign {
       /**
        * 添加文章
        * @param article
        * @return
        */
       @PostMapping(value="/article/insert")
       int insert(@RequestBody Article article);

       /**
        * 删除文章
        * @param id
        * @return
        */
       @DeleteMapping(value="/article/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改文章
        * @param article
        * @return
        */
       @PutMapping(value="/article/edit")
       int edit(@RequestBody Article article);

       /**
        * 根据ID查询
        * @param id
        * @returnarticle
        */
       @GetMapping(value="/article/queryById/{id}")
       Article queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询文章
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param article 查询条件
     * @return
     */
       @PostMapping(value="/article/front/findByPage")
       PageInfo<Article> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                    Integer pageSize, @RequestBody Article article);
}