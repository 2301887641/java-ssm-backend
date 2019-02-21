package com.mall.core.constant;

/**
 * 常量池 包含以下内容:
 * 英文、正则等信息 不含有中文信息
 *
 * @author suiguozhen on 19/01/19 16:23
 */
public interface ConstantsPool {
    /**
     * session相关
     */
    interface Session {

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
        String CAPTCHA_CREATE_ERROR = "图片验证码生成失败";
        String VERIFY_CODE_TEMPLATE_NOT_EXIST = "验证码模板不存在";
        String MESSAGE_DIGEST_CREATE_ERROR="md5生成失败";
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
    interface Regexp {
        String PHONE_PATTERN = "^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$";
        String PASSWORD_PATTERN = "^(?![A-Za-z]+$)(?!\\d+$)(?![\\W_]+$).{6,20}$";
    }
}
