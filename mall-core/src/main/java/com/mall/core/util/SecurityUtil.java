package com.mall.core.util;

import com.mall.core.constant.ConstantsPool;
import com.mall.core.exception.NetworkException;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.MessageDigest;

/**
 * 安全相关
 *  原始md5和shiro的md5以及散列
 *
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
            throw new NetworkException(ConstantsPool.Exception.MESSAGE_DIGEST_CREATE_ERROR);
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
        return HEX_DIGIT[d1] + HEX_DIGIT[d2];
    }

    private static final String[] HEX_DIGIT = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}
