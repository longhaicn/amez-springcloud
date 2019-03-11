package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.pc.CheckConditionVo;
import com.union.aimei.common.vo.learn.pc.LearnBeforeVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionMessageVo;
import com.union.aimei.common.vo.learn.pc.LearnConditionVo;
import com.union.aimei.learn.service.LearnConditionService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "门槛条件表")
@RestController
@RequestMapping(value = "learnCondition")
public class LearnConditionController {
    @Resource
    private LearnConditionService learnConditionService;

    @PostMapping("/front/findByPage")
    public PageInfo<LearnCondition> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                               Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                               Integer pageSize, @ApiParam(value = "查询条件") @RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.findByPageForFront (pageNo, pageSize, learnCondition);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.addObj (learnCondition);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.learnConditionService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody LearnCondition learnCondition) {
        return this.learnConditionService.modifyObj (learnCondition);
    }

    @GetMapping("/queryById/{id}")
    public LearnCondition queryById(@PathVariable(value = "id") int id) {
        return this.learnConditionService.queryObjById (id);
    }

    /**
     * 将后台learnConditionList数据转化 为 LearnConditionVoList实体类(v1.1.0)
     *
     * @param learnConditionList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "将后台learnConditionList数据转化 为 LearnConditionVoList实体类(v1.1.0)")
    @PostMapping("/1.1.0/setLearnConditionVoList")
    public ResponseMessage<List<LearnConditionVo>> setLearnConditionVoListV110(@ApiParam(value = "参数") @RequestBody List<LearnCondition> learnConditionList){
        return this.learnConditionService.setLearnConditionVoListV110 (learnConditionList);
    }

    /**
     * 将前台定义传递的数据 转换为 learnCondition 实体类(v1.1.0)
     *
     * @param learnConditionVoList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "将前台定义传递的数据 转换为 learnCondition 实体类(v1.1.0)")
    @PostMapping("/1.1.0/setLearnConditionList")
    public ResponseMessage<List<LearnCondition>> setLearnConditionListV110(@ApiParam(value = "参数") @RequestBody List<LearnConditionVo> learnConditionVoList){
        return this.learnConditionService.setLearnConditionListV110 (learnConditionVoList);
    }

    /**
     * 根据美容师、店铺 数据以及门口数据 校验是否具备报名资格(v1.1.0)
     *
     * @param checkConditionVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据美容师、店铺 数据以及门口数据 校验是否具备报名资格(v1.1.0)")
    @PostMapping("/1.1.0/checkConditionBeautician")
    public ResponseMessage<LearnConditionMessageVo> checkConditionBeauticianV110(@ApiParam(value = "参数") @RequestBody CheckConditionVo checkConditionVo){
        return this.learnConditionService.checkConditionBeauticianV110 (checkConditionVo);
    }


    /**
     * 判断前置课程是否满足(v1.1.0)
     *
     * @param learnBeforeVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "判断前置课程是否满足(v1.1.0)")
    @PostMapping("/1.1.0/learnBeforePermission")
    public ResponseMessage<LearnConditionMessageVo> learnBeforePermissionV110(@ApiParam(value = "参数") @RequestBody LearnBeforeVo learnBeforeVo){
        return this.learnConditionService.learnBeforePermissionV110 (learnBeforeVo);
    }

    /**
     * 根据条件查询门槛集合
     * @param learnCondition
     * @return
     */
    @PostMapping("/queryListByLearnCondition")
    List<LearnCondition> queryListByLearnCondition(@RequestBody LearnCondition learnCondition){
        return this.learnConditionService.queryListByLearnCondition(learnCondition);
    }

}