package com.mall.controller.portal;

import com.google.code.kaptcha.Producer;
import com.mall.context.util.ShiroUtil;
import com.mall.context.util.SpringUtil;
import com.mall.core.constant.ConstantsPool;
import com.mall.core.exception.ConsoleLogException;
import com.mall.core.foundation.Result;
import com.mall.core.util.FrontUtil;
import com.mall.core.util.StringUtil;
import com.mall.sender.api.VerifyCodeRecordService;
import com.mall.sender.api.VerifyCodeService;
import com.mall.sender.dto.VerifyCodeRecordDto;
import com.mall.sender.enums.VerifyCodeBusinessEnum;
import com.mall.sender.enums.VerifyCodeTypeEnum;
import com.mall.service.api.UserService;
import com.mall.service.dto.UserDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * 注册
 * @author suiguozhen on 19/01/25 16:10
 */
@Controller
@Validated
public class RegisterController {
    /*** 目录*/
    private static final String TEMPLATE_DIR = "register";
    private static final String TEMPLATE_NAME = "index";

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private VerifyCodeRecordService verifyCodeRecordService;

    @GetMapping("/register.jspx")
    public String toRegister() {
        return FrontUtil.getTemplatePath(TEMPLATE_DIR, TEMPLATE_NAME);
    }

    @PostMapping("/register.jspx")
    @ResponseBody
    public Result<Void> doRegister(@NotNull(message = "{phone.required}") @Pattern(message = "{phone.incorrect.format}", regexp = ConstantsPool.Regexp.PHONE_PATTERN) String phone,
                                   @Pattern(message = "{password.incorrect.format}",regexp= ConstantsPool.Regexp.PASSWORD_PATTERN )String password,
                                   @NotBlank(message = "{verifyCode.required}")String verifyCode) {
        VerifyCodeRecordDto verifyCodeRecordDto = verifyCodeRecordService.getTodayLastRecord(VerifyCodeRecordDto.of(phone, VerifyCodeBusinessEnum.REGISTER));
        Result<Void> result = verifyCodeService.validate(VerifyCodeTypeEnum.SMS,verifyCodeRecordDto, verifyCode);
        if(!result.isSuccess()){
               return result;
        }
        userService.save(UserDto.of(phone,StringUtil.createFullName()+RandomStringUtils.randomNumeric(Integer.parseInt(SpringUtil.getPropertiesValue("nickname.random.length"))), ShiroUtil.sha256(password,phone)));
        return Result.success();
    }

    /**
     * 验证码
     * @param response 响应对象
     */
    @GetMapping("/captcha.jspx")
    public void captcha(HttpServletResponse response) {
        String text = captchaProducer.createText();
        ShiroUtil.getSession().setAttribute(VerifyCodeService.CAPTCHA_SESSION_NAME,VerifyCodeRecordDto.of(text, LocalDateTime.now().plusSeconds(Long.parseLong(SpringUtil.getPropertiesValue("captchaCode.expire.time")))));
        try {
            ImageIO.write(captchaProducer.createImage(text), ConstantsPool.Img.IMG_JPG, response.getOutputStream());
        } catch (Exception e) {
            throw new ConsoleLogException(ConstantsPool.Exception.CAPTCHA_CREATE_ERROR);
        }
    }
}
