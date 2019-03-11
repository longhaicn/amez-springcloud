package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseUserHystrix;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.UserVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-system-service", fallback = BaseUserHystrix.class)
public interface BaseUserFeign {
    /**
     * 基本操作
     * @param userId
     * @return
     */
    @RequestMapping(value = "/baseUsers/{userId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("userId") Integer userId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUsers/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<BaseUser> insertSelective(@RequestBody BaseUser record);
    /**
     * 基本操作
     * @param userId
     * @return
     */
    @RequestMapping(value = "/baseUsers/{userId}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BaseUser selectByPrimaryKey(@PathVariable("userId") Integer userId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUsers/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BaseUser record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/baseUsers/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BaseUser> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BaseUser record);

    /**
     *  用户登录
     * @param userVo
     * @return
     */
    @PostMapping("/baseUsers/userLogin")
    ResponseMessage<Map<String, Object>> userLogin(@RequestBody UserVo userVo);

    /**
     * 添加老板,店长,者员工
     *
     * @param record
     * @return
     */
    @PostMapping("/baseUsers/insertBbossAndShopkeeperAndMember")
    ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(@RequestBody BaseUserVo record);


    /**
     * 闭店铺的时候禁用用户登录
     * @param phone
     * @param flag
     * @return
     */
    @RequestMapping(value = "/baseUsers/{phone}/{flag}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Integer> updateUserSatuts(@PathVariable("phone") String phone, @PathVariable("flag") Integer flag);
}