package com.mall.core.util;

/**
 * 前台工具类
 *
 * @author suiguozhen on 19/01/26 10:30
 */
public class FrontUtil {
    /**
     * 获取模板路径
     *
     * @param dir          目录
     * @param templateName 模板名称
     * @return String
     */
    public static String getTemplatePath(String dir, String templateName) {
        return "/front/" + dir + "/" + templateName;
    }
}
