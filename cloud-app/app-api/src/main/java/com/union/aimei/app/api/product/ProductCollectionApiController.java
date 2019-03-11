package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductCollectionFeign;
import com.union.aimei.common.model.product.ProductCollectionParam;
import com.union.aimei.common.model.product.ProductCollectionResult;
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
 * @time 2018/1/26 11:15
 */
@Api(tags = "项目收藏")
@RestController
@RequestMapping(value = "productCollection")
public class ProductCollectionApiController {
    @Resource
    private ProductCollectionFeign productCollectionFeign;


    /**
     * 根据用户id查询该用户所收藏的项目
     *
     * @param pageNo                 分页索引
     * @param pageSize               每页显示数量
     * @param productCollectionParam 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据用户id查询该用户所收藏的项目")
    @PostMapping("/selectListPageCollectionByMemberId")
    public ResponseMessage<PageInfo<ProductCollectionResult>> selectListPageCollectionByMemberId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                 @ApiParam(value = "查询条件") @RequestBody ProductCollectionParam productCollectionParam) {
        return this.productCollectionFeign.selectListPageCollectionByMemberId(pageNo, pageSize, productCollectionParam);
    }

}