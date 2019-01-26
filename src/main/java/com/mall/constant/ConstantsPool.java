package com.mall.constant;

/**
 * @author suiguozhen on 19/01/19 16:23
 */
public interface ConstantsPool {
    /**
     * session相关
     */
    interface Session {
        /**
         * 用户的session name
         */
        String USER_SESSION_NAME = "user_login_session";
        /**
         * 验证码session name
         */
        String CAPTCHA_SESSION_NAME = "captcha_show";
    }

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

    /**
     * 异常相关
     */
    interface Exception {
        String CREATE_CAPTCHA_ERROR = "验证码生成失败";
    }

    /**
     * 图片相关
     */
    interface Img {
        String IMG_JPG = "jpg";
    }
}
