package com.mall.core.util;

import com.mall.core.constant.ConstantsPool;
import com.mall.core.exception.NetworkException;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.MessageDigest;
import java.util.Objects;

/**
 * 安全相关
 *
 * @author suiguozhen on 19/01/19 16:30
 */
public class SecurityUtil {

    private static final int hashIterations = 1024;

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

    /**
     * shiro自带md5加密
     *
     * @param message        要加密的信息
     * @param salt           盐值
     * @param hashIterations 散列次数 比如2次:messageDigest(messageDigest(xxx))
     * @return string
     */
    public static String messageDigest(String message, String salt, int hashIterations) {
        return new SimpleHash("md5", message, salt, hashIterations).toString();
    }

    /**
     * shiro自带md5加密
     * @param message 要加密的信息
     * @param salt  盐值
     * @return  string
     */
    public static String messageDigest(String message, String salt) {
        return new SimpleHash("md5", message, salt, hashIterations).toString();
    }

    /**
     *  sha256散列加密
     * @param message 要加密的信息
     * @param salt 盐值
     * @param hashIterations 散列次数
     * @return String
     */
    public static String sha256(String message,String salt,int hashIterations){
        return new SimpleHash("sha256",message,salt,hashIterations).toString();
    }
}
