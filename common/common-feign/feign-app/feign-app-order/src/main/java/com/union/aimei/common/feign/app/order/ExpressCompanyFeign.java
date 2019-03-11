package com.union.aimei.common.feign.app.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.ExpressCompanyApiHystrix;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 快递公司信息
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = ExpressCompanyApiHystrix.class)
public interface ExpressCompanyFeign {
    /**
     * 添加快递公司信息表
     *
     * @param expressCompany
     * @return
     */
    @PostMapping(value = "/expressCompany/insert")
    ResponseMessage insert(@RequestBody ExpressCompany expressCompany);

    /**
     * 删除快递公司信息表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/expressCompany/deleteById/{id}")
    ResponseMessage deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改快递公司信息表
     *
     * @param expressCompany
     * @return
     */
    @PutMapping(value = "/expressCompany/edit")
    ResponseMessage edit(@RequestBody ExpressCompany expressCompany);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnexpressCompany
     */
    @GetMapping(value = "/expressCompany/queryById/{id}")
    ResponseMessage<ExpressCompany> queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询快递公司信息表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param expressCompany 查询条件
     * @return
     */
    @PostMapping(value = "/expressCompany/front/findByPage")
    ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                         Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                         Integer pageSize, @RequestBody ExpressCompany expressCompany);
}