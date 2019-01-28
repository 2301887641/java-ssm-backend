package com.mall.constant;

/**
 * 常量池 包含以下内容:
 * 英文、正则等信息 不含有中文信息
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
        String CODE_TEMPLATE_NOT_EXIST="验证码模板不存在";
    }

    /**
     * 图片相关
     */
    interface Img {
        String IMG_JPG = "jpg";
    }

    /**
     * 正则表达式
     */
    interface Regexp{
        String PHONE_PATTERN="^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$";
    }
}