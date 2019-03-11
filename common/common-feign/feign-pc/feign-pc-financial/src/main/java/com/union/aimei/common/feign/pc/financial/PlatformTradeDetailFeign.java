package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.PlatformTradeDetailHystrix;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.vo.financial.PlatformTradeDetailVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-financial-service", fallback = PlatformTradeDetailHystrix.class)
public interface PlatformTradeDetailFeign {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody PlatformTradeDetail record);

    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    PlatformTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody PlatformTradeDetail record);

    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<PlatformTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody PlatformTradeDetail record);

    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/selectPlatformListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<PlatformTradeDetail> selectPlatformListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody PlatformTradeDetailVo record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/platformTradeDetails/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage insertSelectiveV110(@RequestBody PlatformTradeDetail record);
}