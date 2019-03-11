package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Article;
import com.union.aimei.learn.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="文章")
@RestController
@RequestMapping(value="article")
public class ArticleController {
       @Resource
       private ArticleService articleService;

       @PostMapping("/front/findByPage")
       public PageInfo<Article> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody Article article) {
              return this.articleService.findByPageForFront(pageNo,pageSize,article);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody Article article) {
              return this.articleService.addObj(article);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.articleService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody Article article) {
              return this.articleService.modifyObj(article);
       }

       @GetMapping("/queryById/{id}")
       public Article queryById(@PathVariable (value="id") int id) {
              return this.articleService.queryObjById(id);
       }
}