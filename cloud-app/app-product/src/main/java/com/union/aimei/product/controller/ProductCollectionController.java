package com.union.aimei.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.product.app.ProductCollectionResultVo;
import com.union.aimei.common.vo.product.app.ProductCollectionVo;
import com.union.aimei.product.service.ProductCollectionService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:09
 */
@Api(tags = "项目收藏")
@RestController
@RequestMapping(value = "productCollection")
public class ProductCollectionController {
    @Resource
    private ProductCollectionService productCollectionService;

    /**
     * 根据用户id查询该用户所收藏的项目
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param productCollectionVo 查询条件
     * @return
     */
    @PostMapping("/selectListPageCollectionByMemberId")
    public ResponseMessage<PageInfo<ProductCollectionResultVo>> selectListPageCollectionByMemberId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                                   @ApiParam(value = "查询条件") @RequestBody ProductCollectionVo productCollectionVo) {
        return this.productCollectionService.selectListPageCollectionByMemberId(pageNo, pageSize, productCollectionVo);
    }

    /**
     * 项目收藏
     *
     * @param productId    项目ID
     * @param memberId     会员ID
     * @param isCollection 是否收藏，1-是，0-否
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目收藏")
    @PostMapping("/collection/{productId}/{memberId}/{isCollection}")
    public ResponseMessage<ProductCollection> collection(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId,
                                                         @ApiParam(value = "会员ID") @PathVariable(value = "memberId") int memberId,
                                                         @ApiParam(value = "是否收藏") @PathVariable(value = "isCollection") boolean isCollection) {
        return this.productCollectionService.collection(productId, memberId, isCollection);
    }

    /**
     * 是否收藏
     *
     * @param productId 项目ID
     * @param memberId  会员ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "是否收藏")
    @GetMapping("/isCollection/{productId}/{memberId}")
    public ResponseMessage<Boolean> isCollection(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId,
                                                 @ApiParam(value = "会员ID") @PathVariable(value = "memberId") int memberId) {
        return this.productCollectionService.isCollection(productId, memberId);
    }

}