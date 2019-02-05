package com.mall.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * dto基类
 * @author suiguozhen on 19-1-20 下午3:01
 */
@Getter
@Setter
public class BaseDto implements Serializable {
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}