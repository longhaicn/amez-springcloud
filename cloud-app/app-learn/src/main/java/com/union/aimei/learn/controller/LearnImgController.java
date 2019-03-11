package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.learn.service.LearnImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags="学习图片")
@RestController
@RequestMapping(value="learnImg")
public class LearnImgController {
       @Resource
       private LearnImgService learnImgService;

       @PostMapping("/front/findByPage")
       public PageInfo<LearnImg> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody LearnImg learnImg) {
              return this.learnImgService.findByPageForFront(pageNo,pageSize,learnImg);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody LearnImg learnImg) {
              return this.learnImgService.addObj(learnImg);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.learnImgService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody LearnImg learnImg) {
              return this.learnImgService.modifyObj(learnImg);
       }

       @GetMapping("/queryById/{id}")
       public LearnImg queryById(@PathVariable (value="id") int id) {
              return this.learnImgService.queryObjById(id);
       }

       @PostMapping("/queryListByLearnImg")
       public List<String> queryListByLearnImg(@RequestBody LearnImg learnImg) {
              return this.learnImgService.queryListByLearnImg(learnImg);
       }
}