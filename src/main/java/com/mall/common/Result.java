package com.mall.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mall.dao.enums.RestCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 通用rest结果集返回 使用jackson 并且忽略为null的属性
 * @author suiguozhen on 19-1-17 下午9:40
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private int restCode;
    private String restInfo;
    private T data;

    public static<W> Result<W> success(){
        return new Result<W>(RestCodeEnum.SUCCESS.getOrdinal());
    }

    public static<W> Result<W> success(W data){
        return new Result<W>(RestCodeEnum.SUCCESS.getOrdinal(),data);
    }

    public static<W> Result<W> success(String restInfo,W data){
        return new Result<W>(RestCodeEnum.SUCCESS.getOrdinal(), restInfo,data);
    }

    public static <W> Result<W> success(int restCode, String restInfo, W data) {
        return new Result<W>(restCode, restInfo, data);
    }

    public static<W> Result<W> failed(){
        return new Result<W>(RestCodeEnum.ERROR.getOrdinal());
    }

    public static<W> Result<W> failed(String restInfo){
        return new Result<W>(RestCodeEnum.ERROR.getOrdinal(),restInfo);
    }

    public static<W> Result<W> failed(int code,String restInfo){
        return new Result<W>(code,restInfo);
    }

    public static<W> Result<W> failed(int code,String restInfo,W data){
        return new Result<W>(code,restInfo,data);
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