package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.ExpressCompanyFeign;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

/**
 * 快递公司信息
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-ExpressCompanyFeign")
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
        throw new ServerException(500, "网络不稳定");
    }

    /**
     * 添加快递公司信息表
     *
     * @param expressCompany
     * @return
     */
    @Override
    public int insert(ExpressCompany expressCompany) {
        return 0;
    }

    /**
     * 删除快递公司信息表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改快递公司信息表
     *
     * @param expressCompany
     * @return
     */
    @Override
    public int edit(ExpressCompany expressCompany) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnexpressCompany
     */
    @Override
    public ExpressCompany queryById(int id) {
        return null;
    }
}