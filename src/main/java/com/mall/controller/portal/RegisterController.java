package com.mall.controller.portal;

import com.google.code.kaptcha.Producer;
import com.mall.annotation.DoValid;
import com.mall.common.Result;
import com.mall.constant.ConstantsPool;
import com.mall.dto.UserDto;
import com.mall.exception.ConsoleLogException;
import com.mall.group.userDto.ValidationUserDto;
import com.mall.service.api.VerifyCodeService;
import com.mall.util.FrontUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author suiguozhen on 19/01/25 16:10
 */
@Controller
@Validated
public class RegisterController {

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @GetMapping("/register.do")
    public String toRegister(HttpServletRequest request) {
        return FrontUtil.getTemplatePath("register", "index");
    }

//    @PostMapping("/register.do")
//    @ResponseBody
//    @DoValid
//    public Result<Void> doRegister(@Validated({ValidationUserDto.ValidationFrontUserRegister.class}) UserDto userDto, BindingResult result) {
//        return verifyCodeService.sendSmsCode(userDto.getPhone(), VerifyCodeEnum.REGISTER);
//    }

    @PostMapping("/register.do")
    @ResponseBody
    @DoValid
    public Result<Void> doRegister(@NotNull @Pattern(message="{validation.phone.regexp}",regexp = ConstantsPool.Regexp.PHONE_PATTERN) String phone,
                                   @Validated({ValidationUserDto.ValidationFrontUserLogin.class}) UserDto userDto, BindingResult result) {
        return Result.success();
//        return verifyCodeService.sendSmsCode(userDto.getPhone(), VerifyCodeEnum.REGISTER);
    }

    @GetMapping("/captcha.do")
    public void captcha(HttpSession session, HttpServletResponse response) {
        String text = captchaProducer.createText();
        session.setAttribute(ConstantsPool.Session.CAPTCHA_SESSION_NAME, text);
        try {
            ImageIO.write(captchaProducer.createImage(text), ConstantsPool.Img.IMG_JPG, response.getOutputStream());
        } catch (Exception e) {
            throw new ConsoleLogException(ConstantsPool.Exception.CREATE_CAPTCHA_ERROR);
        }
    }
}
