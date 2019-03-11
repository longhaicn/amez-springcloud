package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductActivityApiHystrix;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.pc.ProductActivityByAddVo;
import com.union.aimei.common.vo.product.pc.ProductActivityByDetailResVo;
import com.union.aimei.common.vo.product.pc.ProductActivityBySelectBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 11:29
 */
@FeignClient(name = "PC-PRODUCT-SERVICE", fallback = ProductActivityApiHystrix.class)
public interface ProductActivityFeign {

    /**
     * 分页查询项目活动
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productActivity 查询条件
     * @return
     */
    @PostMapping("/productActivity/front/findByPage")
    ResponseMessage<PageInfo<ProductActivity>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody ProductActivity productActivity);

    /**
     * 查询精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping("/productActivity/findListBySelect/{cityId}")
    ResponseMessage<List<ProductActivity>> findListBySelect(@PathVariable(value = "cityId") int cityId);

    /**
     * 项目活动详情
     *
     * @param id ID
     * @return
     */
    @GetMapping("/productActivity/detail/{id}")
    ResponseMessage<ProductActivityByDetailResVo> detail(@PathVariable(value = "id") int id);

    /**
     * 新增项目活动
     *
     * @param addVo 新增条件
     * @return
     */
    @PostMapping("/productActivity/add")
    ResponseMessage add(@RequestBody ProductActivityByAddVo addVo);

    /**
     * 批量精选项目活动
     *
     * @param selectBatchVo 批量精选条件
     * @return
     */
    @PutMapping("/productActivity/select/batch")
    ResponseMessage selectByBatch(@RequestBody ProductActivityBySelectBatchVo selectBatchVo);

}