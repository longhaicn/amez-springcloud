package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseRegionHystrix;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dell
 */
@FeignClient(name = "app-system-service", fallback = BaseRegionHystrix.class)
public interface BaseRegionFeign {
    /**
     * 基本操作
     *
     * @param regionId
     * @return
     */
    @RequestMapping(value = "/baseRegions/{regionId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("regionId") Integer regionId);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRegions/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BaseRegion record);

    /**
     * 基本操作
     *
     * @param regionId
     * @return
     */
    @RequestMapping(value = "/baseRegions/{regionId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseRegion selectByPrimaryKey(@PathVariable("regionId") Integer regionId);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRegions/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseRegion record);

    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseRegions/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseRegion> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseRegion record);

    /**
     * 查看
     *
     * @return
     */
    @RequestMapping(value = "/baseRegions/findListByConditions", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    List<BaseRegion> findListByConditions();

    /**
     * 根据名称查询ID（省，市，区）
     *
     * @param nameVo 条件
     * @return
     */
    @PostMapping(value = "/baseRegions/1.1.1/getNameById")
    ResponseMessage<BaseRegionIdByNameResVo> getNameByIdV111(BaseRegionIdByNameVo nameVo);

    /**
     * 根据城市ID查询区列表
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping(value = "/baseRegions/1.1.1/listAreaByCityId/{cityId}")
    ResponseMessage<List<BaseRegion>> listAreaByCityIdV111(@PathVariable(value = "cityId") int cityId);
}