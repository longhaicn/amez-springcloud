package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.ArticleFeign;
import com.union.aimei.common.feign.pc.learn.LearnImgFeign;
import com.union.aimei.common.model.learn.Article;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgInsertBatchVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author houji
 */
@Api(tags="文章")
@RestController
@RequestMapping(value="article")
public class ArticleApiController {
    @Resource
    private ArticleFeign articleFeign;
    @Resource
    private LearnImgFeign learnImgFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param article 查询条件
     * @return ResponseMessage<Article>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询文章")
       @PostMapping("/1.1.0/front/findByPageV110")
       public ResponseMessage<Article> findByPageForFrontV110(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody Article article) {
           ResponseMessage result = ResponseMessageFactory.newInstance();
           PageInfo<Article> page=articleFeign.findByPageForFront(pageNo, pageSize,article);
           if(page!=null){
               result.setData(page);
           }else{
               result.setCode(ResponseContants.QUERY_EMPTY);
               result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
           }
           return result;
       }

       /**
        * 添加Article
        * @param article
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加文章")
       @PostMapping("/1.1.0/insertV110")
       public ResponseMessage insertV110(@RequestBody Article article) {
           ResponseMessage result = ResponseMessageFactory.newInstance();
           int res=this.articleFeign.insert(article);
           if(res > 0 ){
               LearnImgInsertBatchVo learnImgInsertBatchVo = new LearnImgInsertBatchVo();
               learnImgInsertBatchVo.setSourceType(2);
               learnImgInsertBatchVo.setSourceId(res);
               learnImgInsertBatchVo.setImgUrlList(article.getImgURLList());
               this.learnImgFeign.insertBatch(learnImgInsertBatchVo);
           }
           AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
           return result;
       }

       /**
        * 删除Article
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除文章")
       @DeleteMapping("/1.1.0/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
           ResponseMessage result = ResponseMessageFactory.newInstance();
           int res=this.articleFeign.deleteById(id);
           AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
           return result;
       }

       /** 
        * 修改Article
        * @param article
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑文章")
       @PutMapping("/1.1.0/editV110")
       public ResponseMessage editV110(@RequestBody Article article) {
           ResponseMessage result = ResponseMessageFactory.newInstance();
           int res=this.articleFeign.edit(article);
           AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
           return result;
       }

       /**
        * 根据ID查询Article
        * @param id
        * @returnarticle
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询文章")
       @GetMapping("/1.1.0/queryById/{id}")
       public ResponseMessage<Article> queryById(@PathVariable (value="id") int id) {
           ResponseMessage result = ResponseMessageFactory.newInstance();
           Article model=this.articleFeign.queryById(id);
           //当model不为空的情况下，活动主图查询出来
           if(model != null) {
               //插入活动主图
               LearnImg learnImg = new LearnImg();
               learnImg.setSourceId(id);
               learnImg.setSourceType(2);
               List<String> mainImgList = this.learnImgFeign.queryImgListByLearnImg(learnImg);
               if (!CollectionUtils.isEmpty(mainImgList)) {
                   model.setImgURLList(mainImgList);
               }
           }
           AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
           result.setData(model);
           return result;
       }
}