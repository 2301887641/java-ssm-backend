package com.mall.common;

/**
 * @author suiguozhen on 19/01/19 16:23
 */
public interface ConstantsPool {
    /**
     * 用户的session name
     */
    String USER_SESSION_NAME = "user_login_session";

    /**
     * 主体
     */
    interface Subject {
        /**
         * 用户名
         */
        String SUBJECT_USERNAME = "username";
        /**
         * 邮箱
         */
        String SUBJECT_EMAIL = "email";
        /**
         * 手机
         */
        String SUBJECT_PHONE = "phone";
    }
}
