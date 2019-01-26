package com.mall.controller.portal;

import com.google.code.kaptcha.Producer;
import com.mall.constant.ConstantsPool;
import com.mall.common.Result;
import com.mall.exception.ConsoleLogException;
import com.mall.util.FrontUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * @author suiguozhen on 19/01/25 16:10
 */
@Controller
public class RegisterController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/register.do")
    public String toRegister(HttpServletRequest request) {
        return FrontUtil.getTemplatePath("register","index");
    }

    @PostMapping("/register.do")
    @Validated
    public Result<Void> doRegister(@NotNull(message = "不能为空") String phone, String captcha){
        return Result.success();
    }

    @GetMapping("/captcha.do")
    public void captcha(HttpSession session, HttpServletResponse response){
        String text = captchaProducer.createText();
        session.setAttribute(ConstantsPool.Session.CAPTCHA_SESSION_NAME, text);
        try {
            ImageIO.write(captchaProducer.createImage(text), ConstantsPool.Img.IMG_JPG, response.getOutputStream());
        } catch (Exception e) {
            throw new ConsoleLogException(ConstantsPool.Exception.CREATE_CAPTCHA_ERROR);
        }
    }
}
