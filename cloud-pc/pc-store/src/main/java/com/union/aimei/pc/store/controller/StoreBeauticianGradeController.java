package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import com.union.aimei.pc.store.service.StoreBeauticianGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
@Api(tags = "店铺-美容师等级")
@RestController
@RequestMapping(value = "storeBeauticianGrade")
public class StoreBeauticianGradeController {
    @Resource
    private StoreBeauticianGradeService storeBeauticianGradeService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreBeauticianGrade> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreBeauticianGrade storeBeauticianGrade) {
        return this.storeBeauticianGradeService.findByPageForFront(pageNo, pageSize, storeBeauticianGrade);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreBeauticianGrade storeBeauticianGrade) {
        return this.storeBeauticianGradeService.addObj(storeBeauticianGrade);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianGradeService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreBeauticianGrade storeBeauticianGrade) {
        return this.storeBeauticianGradeService.modifyObj(storeBeauticianGrade);
    }

    @GetMapping("/queryById/{id}")
    public StoreBeauticianGrade queryById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianGradeService.queryObjById(id);
    }
}