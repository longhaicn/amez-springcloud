package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomepageGuidePageFeign;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags="首页引导页", description = "api")
@RestController
@RequestMapping("/baseHomepageGuidePages")
public class BaseHomepageGuidePageController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseHomepageGuidePageFeign baseHomepageGuidePageFeign;

    @ApiOperation("根据ID删除首页引导页")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseHomepageGuidePageFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加首页引导页")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseHomepageGuidePage record) {
        int resultCount = this.baseHomepageGuidePageFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新首页引导页")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseHomepageGuidePage record) {
        int resultCount = this.baseHomepageGuidePageFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询首页引导页")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseHomepageGuidePage> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseHomepageGuidePage baseHomepageGuidePage = this.baseHomepageGuidePageFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseHomepageGuidePage);
    }

    @ApiOperation("分页和条件查询首页引导页")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseHomepageGuidePage>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseHomepageGuidePage record) {
        PageInfo<BaseHomepageGuidePage> result = this.baseHomepageGuidePageFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}