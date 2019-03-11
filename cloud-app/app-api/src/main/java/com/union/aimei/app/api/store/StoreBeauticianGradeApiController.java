package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianGradeFeign;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
@Api(tags = "店铺-美容师等级")
@RestController
@RequestMapping(value = "storeBeauticianGrade")
public class StoreBeauticianGradeApiController {
    @Resource
    private StoreBeauticianGradeFeign storeBeauticianGradeFeign;

    /**
     * 分页查询
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeBeauticianGrade 查询条件
     * @return ResponseMessage<StoreBeauticianGrade>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺-美容师等级")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianGrade>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreBeauticianGrade storeBeauticianGrade) {
        return new ResponseMessage<>(this.storeBeauticianGradeFeign.findByPageForFront(pageNo, pageSize, storeBeauticianGrade));
    }

    /**
     * 添加StoreBeauticianGrade
     *
     * @param storeBeauticianGrade
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺-美容师等级")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreBeauticianGrade storeBeauticianGrade) {
        Optional.ofNullable(storeBeauticianGrade.getStoreId())
                .filter(u -> u != null)
                .orElseThrow(() -> new ClientException(500, "storeId不能为空"));
        return new ResponseMessage(this.storeBeauticianGradeFeign.insert(storeBeauticianGrade));
    }


    /**
     * 修改StoreBeauticianGrade
     *
     * @param storeBeauticianGrade
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺-美容师等级")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreBeauticianGrade storeBeauticianGrade) {
        Optional.ofNullable(storeBeauticianGrade.getStoreId())
                .filter(u -> u != null)
                .orElseThrow(() -> new ClientException(500, "storeId不能为空"));
        Optional.ofNullable(storeBeauticianGrade.getId())
                .filter(u -> u != null)
                .orElseThrow(() -> new ClientException(500, "id不能为空"));
        return new ResponseMessage(this.storeBeauticianGradeFeign.edit(storeBeauticianGrade));
    }

    /**
     * 根据ID查询StoreBeauticianGrade
     *
     * @param id
     * @returnstoreBeauticianGrade
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺-美容师等级")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreBeauticianGrade> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage<>(this.storeBeauticianGradeFeign.queryById(id));
    }

    @ApiOperation(httpMethod = "DELETE", value = "根据id删除数据v1.1.1")
    @DeleteMapping("/1.1.1/deleteByStoreBeauticianGrade/{id}")
    public ResponseMessage deleteByStoreBeauticianGradeV111(@PathVariable(value = "id") int id) {
        Optional.ofNullable(id)
                .filter(u -> u != null)
                .orElseThrow(() -> new ClientException(500, "id不能为空"));
        return this.storeBeauticianGradeFeign.deleteByStoreBeauticianGradeV111(id);
    }


}