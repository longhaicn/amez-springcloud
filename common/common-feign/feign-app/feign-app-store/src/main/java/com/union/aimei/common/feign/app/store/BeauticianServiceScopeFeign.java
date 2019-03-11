package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.BeauticianServiceScopeApiHystrix;
import com.union.aimei.common.model.store.BeauticianServiceScope;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 11:05
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = BeauticianServiceScopeApiHystrix.class)
public interface BeauticianServiceScopeFeign {

    /**
     * 新增美容师服务范围
     *
     * @param beauticianServiceScope 美容师服务范围
     * @return
     */
    @PostMapping("/beauticianServiceScope/1.1.1/add")
    ResponseMessage addV111(@RequestBody BeauticianServiceScope beauticianServiceScope);

    /**
     * 根据美容师ID查询美容师服务范围
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/beauticianServiceScope/1.1.1/findListByBeauticianId/{beauticianId}")
    ResponseMessage<List<BeauticianServiceScope>> findListByBeauticianIdV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 选择美容师服务范围
     *
     * @param id ID
     * @return
     */
    @PutMapping("/beauticianServiceScope/1.1.1/select/{id}")
    ResponseMessage selectV111(@PathVariable(value = "id") int id);

    /**
     * 删除美容师服务范围
     *
     * @param id ID
     * @return
     */
    @PutMapping("/beauticianServiceScope/1.1.1/delete/{id}")
    ResponseMessage deleteV111(@PathVariable(value = "id") int id);

    /**
     * 修改美容师服务范围
     *
     * @param beauticianServiceScope 美容师服务范围
     * @return
     */
    @PutMapping("/beauticianServiceScope/1.1.1/modify")
    ResponseMessage modifyV111(@RequestBody BeauticianServiceScope beauticianServiceScope);

    /**
     * 根据ID查询美容师服务范围
     *
     * @param id ID
     * @return
     */
    @GetMapping("/beauticianServiceScope/1.1.1/findById/{id}")
    ResponseMessage<BeauticianServiceScope> findByIdV111(@PathVariable(value = "id") int id);

}