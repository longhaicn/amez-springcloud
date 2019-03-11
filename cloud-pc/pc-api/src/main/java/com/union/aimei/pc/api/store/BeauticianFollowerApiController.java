package com.union.aimei.pc.api.store;

import com.union.aimei.common.feign.pc.store.BeauticianFollowerFeign;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "美容师粉丝")
@RestController
@RequestMapping(value = "beauticianFollower")
public class BeauticianFollowerApiController {
    @Resource
    private BeauticianFollowerFeign beauticianFollowerFeign;

    /**
     * 分页查询
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param beauticianFollower 查询条件
     * @return ResponseMessage<BeauticianFollower>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询美容师粉丝")
    @PostMapping("/front/findByPage")
    public ResponseMessage<BeauticianFollower> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                          Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                          Integer pageSize, @ApiParam(value = "查询条件") @RequestBody BeauticianFollower beauticianFollower) {
        return new ResponseMessage(this.beauticianFollowerFeign.findByPageForFront(pageNo, pageSize, beauticianFollower));
    }

    /**
     * 添加BeauticianFollower
     *
     * @param beauticianFollower
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加美容师粉丝")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody BeauticianFollower beauticianFollower) {
        return new ResponseMessage(this.beauticianFollowerFeign.insert(beauticianFollower));
    }

    /**
     * 删除BeauticianFollower
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除美容师粉丝")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.beauticianFollowerFeign.deleteById(id));
    }

    /**
     * 修改BeauticianFollower
     *
     * @param beauticianFollower
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑美容师粉丝")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody BeauticianFollower beauticianFollower) {
        return new ResponseMessage(this.beauticianFollowerFeign.edit(beauticianFollower));
    }

    /**
     * 根据ID查询BeauticianFollower
     *
     * @param id
     * @returnbeauticianFollower
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询美容师粉丝")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<BeauticianFollower> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.beauticianFollowerFeign.queryById(id));
    }
}