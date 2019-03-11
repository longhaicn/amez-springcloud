package com.union.aimei.app.api.member;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberCardTradeRecodeFeign;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
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
 * @time 2017/12/19,14:36
 */
@Api(tags = "会员卡交易记录")
@RestController
@RequestMapping(value = "memberCardTradeRecode")
public class MemberCardTradeRecodeApiController {
    @Resource
    private MemberCardTradeRecodeFeign memberCardTradeRecodeFeign;

    /**
     * 分页查询
     *
     * @param pageNo                分页索引
     * @param pageSize              每页显示数量
     * @param memberCardTradeRecode 查询条件
     * @return ResponseMessage<MemberCardTradeRecode>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询会员卡交易记录")
    @PostMapping("/front/findByPage")
    public ResponseMessage<MemberCardTradeRecode> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                             Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                             Integer pageSize, @ApiParam(value = "查询条件")@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<MemberCardTradeRecode> page = memberCardTradeRecodeFeign.findByPageForFront(pageNo, pageSize, memberCardTradeRecode);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加MemberCardTradeRecode
     *
     * @param memberCardTradeRecode
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加会员卡交易记录")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberCardTradeRecodeFeign.insert(memberCardTradeRecode);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除MemberCardTradeRecode
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除会员卡交易记录")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberCardTradeRecodeFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 修改MemberCardTradeRecode
     *
     * @param memberCardTradeRecode
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑会员卡交易记录")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody MemberCardTradeRecode memberCardTradeRecode) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.memberCardTradeRecodeFeign.edit(memberCardTradeRecode);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 根据ID查询MemberCardTradeRecode
     *
     * @param id
     * @returnmemberCardTradeRecode
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询会员卡交易记录")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<MemberCardTradeRecode> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        MemberCardTradeRecode model = this.memberCardTradeRecodeFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }
}