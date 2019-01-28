package com.mall.dto;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 验证码
 * @author suiguozhen on 19/01/24 11:00
 */
@Getter
public class VerifyCodeDto extends BaseDto {
    private Integer id;
    private Integer count;
}
