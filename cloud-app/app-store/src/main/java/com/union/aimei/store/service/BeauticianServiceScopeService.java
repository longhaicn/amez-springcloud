package com.union.aimei.store.service;

import com.union.aimei.common.model.store.BeauticianServiceScope;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 11:02
 */
public interface BeauticianServiceScopeService {

    /**
     * 新增美容师服务范围
     *
     * @param beauticianServiceScope 美容师服务范围
     * @return
     */
    ResponseMessage addV111(BeauticianServiceScope beauticianServiceScope);

    /**
     * 根据美容师ID查询美容师服务范围
     *
     * @param beauticianId 美容师ID
     * @return
     */
    ResponseMessage<List<BeauticianServiceScope>> findListByBeauticianIdV111(int beauticianId);

    /**
     * 选择美容师服务范围
     *
     * @param id ID
     * @return
     */
    ResponseMessage selectV111(int id);

    /**
     * 删除美容师服务范围
     *
     * @param id ID
     * @return
     */
    ResponseMessage deleteV111(int id);

    /**
     * 修改美容师服务范围
     *
     * @param beauticianServiceScope 美容师服务范围
     * @return
     */
    ResponseMessage modifyV111(BeauticianServiceScope beauticianServiceScope);

    /**
     * 根据ID查询美容师服务范围
     *
     * @param id ID
     * @return
     */
    ResponseMessage<BeauticianServiceScope> findByIdV111(int id);

}