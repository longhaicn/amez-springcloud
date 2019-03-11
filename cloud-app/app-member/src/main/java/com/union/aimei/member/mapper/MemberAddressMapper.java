package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberAddress;
import com.union.common.utils.base.BaseMapper;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,18:55
*/
public interface MemberAddressMapper extends BaseMapper<MemberAddress> {

    /**
     * 将会员地址全部设置为默认
     * @param memberId
     */
    void updateMemberAddressIsDefault(Integer memberId);
}