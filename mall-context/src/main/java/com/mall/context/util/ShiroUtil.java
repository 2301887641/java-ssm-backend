package com.mall.context.util;

import com.mall.manager.context.SpringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * shiro的md5以及散列
 * @author suiguozhen on 19-2-7 上午9:04
 */
public class ShiroUtil {
    private static final int HASH_ITERATIONS = Integer.parseInt(SpringUtil.getPropertiesValue("encryption.hashIterations"));

    /**
     * shiro自带md5加密
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
        return new SimpleHash("md5", message, salt, HASH_ITERATIONS).toString();
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
        return new SimpleHash("SHA-256",message,salt,HASH_ITERATIONS).toString();
    }

    /**
     * 通过shiro获取session
     * @return 被shiro包装过的session
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取主体对象
     * @return Subject
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }
}
