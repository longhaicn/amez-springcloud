package com.union.aimei.app.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberLevelUpgradeLogFeign;
import com.union.aimei.common.model.member.MemberLevelUpgradeLog;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/8,10:38
 */
@Api(tags = "会员成长值记录")
@RestController
@RequestMapping(value = "memberLevelUpgradeLog")
public class MemberLevelUpgradeLogApiController {

    @Resource
    private MemberLevelUpgradeLogFeign memberLevelUpgradeLogFeign;

    /**
     * 分页查询
     *
     * @param pageNo                分页索引
     * @param pageSize              每页显示数量
     * @param memberLevelUpgradeLog 查询条件
     * @return ResponseMessage<MemberLevelUpgradeLog>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询会员成长值记录")
    @PostMapping("/front/findByPage")
    public ResponseMessage<MemberLevelUpgradeLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                             Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                             Integer pageSize, @ApiParam(value = "查询条件") @RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<MemberLevelUpgradeLog> page = memberLevelUpgradeLogFeign.findByPageForFront(pageNo, pageSize, memberLevelUpgradeLog);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加MemberLevelUpgradeLog
     *
     * @param memberLevelUpgradeLog
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加会员成长值记录")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberLevelUpgradeLogFeign.insert(memberLevelUpgradeLog);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除MemberLevelUpgradeLog
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除会员成长值记录")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberLevelUpgradeLogFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改MemberLevelUpgradeLog
     *
     * @param memberLevelUpgradeLog
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑会员成长值记录")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody MemberLevelUpgradeLog memberLevelUpgradeLog) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberLevelUpgradeLogFeign.edit(memberLevelUpgradeLog);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询MemberLevelUpgradeLog
     *
     * @param id
     * @returnmemberLevelUpgradeLog
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询会员成长值记录")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<MemberLevelUpgradeLog> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        MemberLevelUpgradeLog model = this.memberLevelUpgradeLogFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}