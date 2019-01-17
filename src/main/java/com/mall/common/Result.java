package com.mall.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author suiguozhen on 19-1-17 下午9:40
 */
@Getter
@Setter
public class Result<T> implements Serializable {
    private int code;
    private String info;
    private T data;

    /**
     * 静态
     * @param code
     * @param info
     * @param data
     * @param <W>
     * @return
     */
    public static <W> Result of(int code, String info, W data) {
        return new Result<>(code, info, data);
    }

    /**
     * 成功 传递数据
     * @param data
     * @param <W>
     * @return
     */
    public static<W> Result success(W data){
        return new Result<>(RestCodeEnum.SUCCESS.getOrdinal(), RestCodeEnum.SUCCESS.getLabel(),data);
    }

    /**
     * 默认成功
     * @return
     */
    public static Result success(){
        return new Result(RestCodeEnum.SUCCESS.getOrdinal(), RestCodeEnum.SUCCESS.getLabel());
    }

    /**
     * 失败 只传递错误信息
     * @param retInfo
     * @param <w>
     * @return
     */
    public static<w> Result failed(String retInfo){
        return new Result<>(RestCodeEnum.EXCEPTION.getOrdinal(),retInfo);
    }

    /**
     * 失败 可以传递完整的状态码和信息
     * @param code
     * @param retInfo
     * @param <W>
     * @return
     */
    public static<W> Result failed(int code,String retInfo){
        return new Result<>(code,retInfo);
    }

    /**
     * 失败 可以传递完的状态码和数整据
     * @param code
     * @param retInfo
     * @param data
     * @param <W>
     * @return
     */
    public static<W> Result failed(int code,String retInfo,W data){
        return new Result<>(code,retInfo,data);
    }

    /**
     * 私有构造
     */
    private Result() {
    }

    /**
     * 构造 不传数据
     * @param retCode
     * @param retInfo
     */
    private Result(int retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }

    /**
     * 构造全参
     * @param retCode
     * @param retInfo
     * @param result
     */
    private Result(int retCode, String retInfo, T result) {
        this.retCode = retCode;
        this.retInfo = retInfo;
        this.data = result;
    }
}
