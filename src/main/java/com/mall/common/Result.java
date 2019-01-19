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
    private int restCode;
    private String restInfo;
    private T data;

    /**
     * 静态
     * @param restCode
     * @param restInfo
     * @param data
     * @param <W>
     * @return
     */
    public static <W> Result of(int restCode, String restInfo, W data) {
        return new Result<>(restCode, restInfo, data);
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
     * @param restInfo
     * @return
     */
    public static Result failed(String restInfo){
        return new Result<>(RestCodeEnum.ERROR.getOrdinal(),restInfo);
    }

    /**
     * 失败 可以传递完整的状态码和信息
     * @param code
     * @param restInfo
     * @return
     */
    public static Result failed(int code,String restInfo){
        return new Result<>(code,restInfo);
    }

    /**
     * 失败 可以传递完的状态码和数整据
     * @param code
     * @param restInfo
     * @param data
     * @param <W>
     * @return
     */
    public static<W> Result failed(int code,String restInfo,W data){
        return new Result<>(code,restInfo,data);
    }

    /**
     * 私有构造
     */
    private Result() {
    }

    /**
     * 构造 不传数据
     * @param restCode
     * @param restInfo
     */
    private Result(int restCode, String restInfo) {
        this.restCode = restCode;
        this.restInfo = restInfo;
    }

    /**
     * 构造全参
     * @param restCode
     * @param restInfo
     * @param result
     */
    private Result(int restCode, String restInfo, T result) {
        this.restCode = restCode;
        this.restInfo = restInfo;
        this.data = result;
    }
}
