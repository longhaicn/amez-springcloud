package com.union.aimei.common.feign.app.order.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.ExpressCompanyFeign;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 快递公司信息
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-ExpressCompanyFeign")
public class ExpressCompanyApiHystrix implements ExpressCompanyFeign {

    /**
     * 前端分页查询快递公司信息表
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param expressCompany 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(Integer pageNo, Integer pageSize, ExpressCompany expressCompany) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加快递公司信息表
     *
     * @param expressCompany
     * @return
     */
    @Override
    public ResponseMessage insert(ExpressCompany expressCompany) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 删除快递公司信息表
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage deleteById(int id) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 修改快递公司信息表
     *
     * @param expressCompany
     * @return
     */
    @Override
    public ResponseMessage edit(ExpressCompany expressCompany) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ExpressCompany> queryById(int id) {
        return HystrixResponse.invokeFail();
    }
}