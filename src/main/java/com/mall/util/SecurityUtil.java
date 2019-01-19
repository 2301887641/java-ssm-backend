package com.mall.util;

import java.security.MessageDigest;
import java.util.Objects;

/**
 * 安全相关
 *
 * @author suiguozhen on 19/01/19 16:30
 */
public class SecurityUtil {

    /**
     * md5加密
     *
     * @param message 要加密的
     * @return string
     */
    public static String messageDigest(String message) {
        String result = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            result = byteArrayToHexString(messageDigest.digest(message.getBytes("utf-8")));
        } catch (Exception exception) {
            //todo 异常需要处理
        }
        return result.toUpperCase();
    }

    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(byteToHexString(b));
        }
        return result.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}
