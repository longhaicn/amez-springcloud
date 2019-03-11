package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.FreightTemplateApiHystrix;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.vo.product.pc.FreightTemplateByAddVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDetailResVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:53
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = FreightTemplateApiHystrix.class)
public interface FreightTemplateFeign {
    /**
     * 添加运费模板
     *
     * @param freightTemplate
     * @return
     */
    @PostMapping(value = "/freightTemplate/insert")
    int insert(@RequestBody FreightTemplate freightTemplate);

    /**
     * 删除运费模板
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/freightTemplate/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改运费模板
     *
     * @param freightTemplate
     * @return
     */
    @PutMapping(value = "/freightTemplate/edit")
    int edit(@RequestBody FreightTemplate freightTemplate);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnfreightTemplate
     */
    @GetMapping(value = "/freightTemplate/queryById/{id}")
    FreightTemplate queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询运费模板
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    @PostMapping(value = "/freightTemplate/front/findByPage")
    ResponseMessage<PageInfo<FreightTemplate>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody FreightTemplate freightTemplate);

    /**
     * 分页查询运费模板（模板）
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    @PostMapping(value = "/freightTemplate/findByPageForDefault")
    ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> findByPageForDefault(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                  @RequestBody FreightTemplate freightTemplate);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/freightTemplate/detail/{id}")
    ResponseMessage<FreightTemplateByDetailResVo> detail(@PathVariable(value = "id") int id);

    /**
     * 添加
     *
     * @param addVo
     * @return
     */
    @PostMapping("/freightTemplate/add")
    ResponseMessage add(@ApiParam("添加") @RequestBody FreightTemplateByAddVo addVo);

    /**
     * 修改
     *
     * @param addVo
     * @return
     */
    @PostMapping("/freightTemplate/modify")
    ResponseMessage modify(@ApiParam("修改") @RequestBody FreightTemplateByAddVo addVo);

    /**
     * 根据条件统计模版数量
     *
     * @param templateName
     * @param notId
     * @return
     */
    @PostMapping("/freightTemplate/selectCountByTemplateName")
    ResponseMessage selectCountByTemplateName(@RequestParam(value = "templateName") String templateName,
                                              @RequestParam(value = "notId") Integer notId);

}