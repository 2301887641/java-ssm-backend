package com.mall.core.foundation;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基类pojo
 * @author suiguozhen on 19-1-20 下午3:04
 */
@Getter
@Setter
public class BasePojo implements Serializable {
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}