package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.vo.member.MemberWithdrawsVo;
import com.union.aimei.member.service.MemberWithdrawsService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags = "会员提现申请表")
@RestController
@RequestMapping(value = "memberWithdraws")
public class MemberWithdrawsController {
    @Resource
    private MemberWithdrawsService memberWithdrawsService;

    @PostMapping("/front/findByPage")
    public PageInfo<MemberWithdraws> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                Integer pageSize, @ApiParam(value = "查询条件") @RequestBody MemberWithdraws memberWithdraws) {
        return this.memberWithdrawsService.findByPageForFront(pageNo, pageSize, memberWithdraws);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody MemberWithdraws memberWithdraws) {
        return this.memberWithdrawsService.addObj(memberWithdraws);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.memberWithdrawsService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody MemberWithdraws memberWithdraws) {
        return this.memberWithdrawsService.modifyObj(memberWithdraws);
    }

    @GetMapping("/queryById/{id}")
    public MemberWithdraws queryById(@PathVariable(value = "id") int id) {
        return this.memberWithdrawsService.queryObjById(id);
    }

    @PostMapping("/front/findByPageManager")
    public PageInfo<MemberWithdraws> findByPageForManager(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
            @ApiParam(value = "查询条件") @RequestBody MemberWithdrawsVo memberWithdrawsVo) {
        return this.memberWithdrawsService.findByPageForManager(pageNo, pageSize, memberWithdrawsVo);
    }

    @PostMapping("/updateBatch")
    public void updateBatch(@RequestBody List<Integer> id) {
        this.memberWithdrawsService.updateBatch(id);
    }


    @ApiOperation("批量打款")
    @RequestMapping(value = "/batchMoney/{ids}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> batchMoney(@PathVariable("ids") String ids) {
        return this.memberWithdrawsService.batchMoney(ids);
    }

}