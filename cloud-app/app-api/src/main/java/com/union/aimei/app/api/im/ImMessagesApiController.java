package com.union.aimei.app.api.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.aimei.common.feign.app.im.ImMessagesFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2018/1/8 21:31
 */
@Api(tags = "IM消息")
@RestController
@RequestMapping(value = "imMessages")
public class ImMessagesApiController {
    @Resource
    private ImMessagesFeign imMessagesFeign;

    /**
     * 根据发送人集合，接收人集合分页查询IM消息
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param imMessagesVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据发送人集合，接收人集合分页查询IM消息")
    @PostMapping("/findByPageForFromToList")
    public ResponseMessage<PageInfo<ImMessages>> findByPageForFromToList(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ImMessagesVo imMessagesVo) {
        return this.imMessagesFeign.findByPageForFromToList(pageNo, pageSize, imMessagesVo);
    }

    /**
     * 根据用户名分页查询最近联系人列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param userName 用户名
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据用户名分页查询最近联系人列表")
    @PostMapping("/findByPageForRecentContactlist")
    public ResponseMessage<PageInfo<String>> findByPageForRecentContactlist(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @ApiParam(value = "查询条件") @RequestBody List<String> userNameList) {
        return this.imMessagesFeign.findByPageForRecentContactlist(pageNo, pageSize, userNameList);
    }

}