package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseUserFeign;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.UserVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liufeihua
 */
@Api(tags = "用户表", description = "api")
@RestController
@RequestMapping("/baseUsers")
public class BaseUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseUserFeign baseUserFeign;

    @ApiOperation("根据ID删除用户表")
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("userId") Integer userId) {
        int resultCount = this.baseUserFeign.deleteByPrimaryKey(userId);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("关闭店铺的时候禁用用户登录--0启用 1禁用")
    @RequestMapping(value = "/{phone}/{flag}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateUserSatuts(@PathVariable("phone") String userId,@PathVariable("flag") Integer flag) {
        return this.baseUserFeign.updateUserSatuts(userId,flag);
    }


    @ApiOperation("添加用户表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseUser> insertSelective(@RequestBody BaseUser record) {
        return this.baseUserFeign.insertSelective(record);
    }

    @ApiOperation("通过ID更新用户表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseUser record) {
        int resultCount = this.baseUserFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询用户表")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseUser> selectByPrimaryKey(@PathVariable("userId") Integer userId) {
        BaseUser baseUser = this.baseUserFeign.selectByPrimaryKey(userId);
        return new ResponseMessage<>(baseUser);
    }

    @ApiOperation("分页和条件查询用户表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseUser>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseUser record) {
        PageInfo<BaseUser> result = this.baseUserFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    /**
     * param:userName用户名
     * param:password密码
     * describe: 用户登录
     * create_by: liufeihua in 2017/12/1 11:10
     */
    @ApiOperation("用户登录")
    @PostMapping("/userLogin")
    public ResponseMessage<Map<String,Object>> userLogin(@RequestBody UserVo userVo) {
        return baseUserFeign.userLogin(userVo);
    }


    @ApiOperation("添加老板,店长,者员工")
    @RequestMapping(value = "/insertBbossAndShopkeeperAndMember", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(@RequestBody BaseUserVo record) {
        return this.baseUserFeign.insertBbossAndShopkeeperAndMember(record);
    }

}