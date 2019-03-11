package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductBeauticianRefFeign;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByAgreeVo;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByAuthVo;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByRandomVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:52
 */
@Api(tags = "项目-美容师-关联")
@RestController
@RequestMapping(value = "productBeauticianRef")
public class ProductBeauticianRefApiController {
    @Resource
    private ProductBeauticianRefFeign productBeauticianRefFeign;

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody ProductBeauticianRef productBeauticianRef) {
        return this.productBeauticianRefFeign.findByPageForFront(pageNo, pageSize, productBeauticianRef);
    }

    /**
     * 随机查询项目-美容师-关联
     *
     * @param productBeauticianRefByRandomVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "随机查询项目-美容师-关联")
    @PostMapping("/findByRandom")
    public ResponseMessage<ProductBeauticianRef> findByRandom(@ApiParam("查询条件") @RequestBody ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo) {
        return this.productBeauticianRefFeign.findByRandom(productBeauticianRefByRandomVo);
    }

    /**
     * 项目-美容师-关联（同意）
     *
     * @param agreeVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目-美容师-关联（同意）")
    @PutMapping("/agree")
    public ResponseMessage agree(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByAgreeVo agreeVo) {
        return this.productBeauticianRefFeign.agree(agreeVo);
    }

    /**
     * 项目-美容师-关联（审核）
     *
     * @param authVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目-美容师-关联（审核）")
    @PutMapping("/auth")
    public ResponseMessage auth(@ApiParam(value = "查询条件") @RequestBody ProductBeauticianRefByAuthVo authVo) {
        return this.productBeauticianRefFeign.auth(authVo);
    }

    /**
     * 根据id修改为不显示状态(V1.1.1)
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据id修改为不显示状态(V1.1.1)")
    @GetMapping("/1.1.1/deleteShowById/{id}")
    public ResponseMessage deleteShowByIdV111(@ApiParam(value = "productBeauticianRefId") @PathVariable(value = "id") int id) {
        return this.productBeauticianRefFeign.deleteShowByIdV111(id);
    }


}