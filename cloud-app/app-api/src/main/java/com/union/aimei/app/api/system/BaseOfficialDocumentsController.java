package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseOfficialDocumentsFeign;
import com.union.aimei.common.model.system.BaseOfficialDocuments;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags="文案", description = "api")
@RestController
@RequestMapping("/baseOfficialDocuments")
public class BaseOfficialDocumentsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseOfficialDocumentsFeign baseOfficialDocumentsFeign;

    @ApiOperation("根据ID删除文案")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseOfficialDocumentsFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加文案")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseOfficialDocuments record) {
        int resultCount = this.baseOfficialDocumentsFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新文案")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseOfficialDocuments record) {
        int resultCount = this.baseOfficialDocumentsFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询文案")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseOfficialDocuments> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseOfficialDocuments baseOfficialDocuments = this.baseOfficialDocumentsFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseOfficialDocuments);
    }

    @ApiOperation("分页和条件查询文案")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseOfficialDocuments>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseOfficialDocuments record) {
        PageInfo<BaseOfficialDocuments> result = this.baseOfficialDocumentsFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}