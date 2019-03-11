package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseAppUpdateVersionFeign;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.common.vo.system.BaseAppUpdateVersionVo;
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
@Api(tags = "app版本升级", description = "api")
@RestController
@RequestMapping("/baseAppUpdateVersions")
public class BaseAppUpdateVersionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseAppUpdateVersionFeign baseAppUpdateVersionFeign;

    @ApiOperation("根据ID删除base_app_update_version")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseAppUpdateVersionFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加base_app_update_version")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseAppUpdateVersion record) {
        int resultCount = this.baseAppUpdateVersionFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新base_app_update_version")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseAppUpdateVersion record) {
        int resultCount = this.baseAppUpdateVersionFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询base_app_update_version")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseAppUpdateVersion> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseAppUpdateVersion baseAppUpdateVersion = this.baseAppUpdateVersionFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseAppUpdateVersion);
    }

    @ApiOperation("分页和条件查询base_app_update_version")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseAppUpdateVersion>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseAppUpdateVersion record) {
        PageInfo<BaseAppUpdateVersion> result = this.baseAppUpdateVersionFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("android升级接口")
    @GetMapping("/forAndroidUpdateVersion/{clientType}")
    public ResponseMessage<BaseAppUpdateVersionVo> forAndroidUpdateVersion(@PathVariable("clientType") Integer clientType) {
        BaseAppUpdateVersionVo result = this.baseAppUpdateVersionFeign.forAndroidUpdateVersion(clientType);
        return new ResponseMessage<>(result);
    }
}