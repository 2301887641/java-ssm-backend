package com.mall.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 通用rest结果集返回 使用jackson 并且忽略为null的属性
 * @author suiguozhen on 19-1-17 下午9:40
 */
@Getter
@Setter
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements Serializable {
    private int restCode;
    private String restInfo;
    private T data;

    public static<T> Result<T> success(){
        return new Result<T>(RestCodeEnum.SUCCESS.getOrdinal());
    }

    public static<T> Result<T> success(T data){
        return new Result<T>(RestCodeEnum.SUCCESS.getOrdinal(),data);
    }

    public static<T> Result<T> success(String restInfo,T data){
        return new Result<T>(RestCodeEnum.SUCCESS.getOrdinal(), restInfo,data);
    }

    public static <T> Result<T> success(int restCode, String restInfo, T data) {
        return new Result<T>(restCode, restInfo, data);
    }

    public static<T> Result<T> failed(String restInfo){
        return new Result<T>(RestCodeEnum.EXCEPTION.getOrdinal(),restInfo);
    }

    public static<T> Result<T> failed(int code,String restInfo){
        return new Result<T>(code,restInfo);
    }

    public static<T> Result<T> failed(int code,String restInfo,T data){
        return new Result<T>(code,restInfo,data);
    }

    private Result(int restCode) {
        this.restCode = restCode;
    }

    private Result(int restCode, String restInfo) {
        this.restCode = restCode;
        this.restInfo = restInfo;
    }

    private Result(int restCode, T result) {
        this.restCode = restCode;
        this.data = result;
    }

    private Result(int restCode, String restInfo, T result) {
        this.restCode = restCode;
        this.restInfo = restInfo;
        this.data = result;
    }

    /**
     * 序列化的时候 忽略生成
     * @return
     */
    @JsonIgnore
    public  boolean isSuccess(){
        return RestCodeEnum.SUCCESS.getOrdinal().equals(this.restCode);
    }
}