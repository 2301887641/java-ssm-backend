package com.mall.manager.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * shiro的md5以及散列
 * @author suiguozhen on 19-2-7 上午9:04
 */
public class ShiroUtil {
    private static final int hashIterations = 1024;

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
     * sha256散列加密
     * @param message 要加密的信息
     * @param salt 盐值
     * @param hashIterations 散列次数
     * @return String
     */
    public static String sha256(String message,String salt,int hashIterations){
        return new SimpleHash("SHA-256",message,salt,hashIterations).toString();
    }

    /**
     * sha256散列加密
     * @param message 要加密的信息
     * @param salt 盐值
     * @return String
     */
    public static String sha256(String message,String salt){
        return new SimpleHash("SHA-256",message,salt,hashIterations).toString();
    }
}
