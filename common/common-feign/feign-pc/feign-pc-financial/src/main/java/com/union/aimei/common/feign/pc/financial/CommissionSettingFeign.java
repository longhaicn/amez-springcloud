package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.CommissionSettingHystrix;
import com.union.aimei.common.model.financial.CommissionSetting;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-financial-service", fallback = CommissionSettingHystrix.class)
public interface CommissionSettingFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/commissionSettings/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/commissionSettings/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody CommissionSetting record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/commissionSettings/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    CommissionSetting selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/commissionSettings/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody CommissionSetting record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/commissionSettings/updateList", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelectiveByList(@RequestBody List<CommissionSetting> record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/commissionSettings/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<CommissionSetting> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody CommissionSetting record);
}