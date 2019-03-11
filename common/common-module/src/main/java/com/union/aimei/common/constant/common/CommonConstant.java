package com.union.aimei.common.constant.common;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 公共常量
 *
 * @author liurenkai
 * @time 2018/6/20 15:49
 */
public interface CommonConstant {

    /**
     * 公共
     */
    interface Common {
        /**
         * IP长度限制
         */
        int IP_LENGTH_LIMIT = 15;

        /**
         * 身份类型，0-游客，1-会员
         */
        interface IdentityType {
            String VISITOR = "0";
            String MEMBER = "1";
        }

    }

    /**
     * 后台用户
     */
    interface BaseUser {

    }

    /**
     * 会员
     */
    interface Member {
        String PASSWORD = RandomStringUtils.random(4);
    }

    /**
     * 门店
     */
    interface Store {
        String NAME = "门店" + RandomStringUtils.random(6);
        /**
         * 精选门店上限
         */
        int SELECT_LIMIT = 6;
    }

    /**
     * 美容师
     */
    interface Beautician {
        String BOSS_NICK_NAME = "邦主" + RandomStringUtils.randomNumeric(6);
        String MANAGER_NICK_NAME = "邦主" + RandomStringUtils.randomNumeric(6);
        String NICK_NAME = "小邦举" + RandomStringUtils.randomNumeric(6);
        String PASSWORD = RandomStringUtils.random(4);
        /**
         * 明星美容师上限
         */
        int STAR_LIMIT = 6;
    }

    /**
     * IM用户
     */
    interface ImUser {
        String PASSWORD = "amez999";
    }

}
