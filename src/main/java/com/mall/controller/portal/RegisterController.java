package com.mall.controller.portal;

import com.google.code.kaptcha.Producer;
import com.mall.common.ConstantsPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author suiguozhen on 19/01/25 16:10
 */
@Controller
public class RegisterController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/register.do")
    public String toRegister(HttpServletRequest request) {
        return "/front/index";
    }

    @GetMapping("/captcha.do")
    public void captcha(HttpSession session, HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        session.setAttribute(ConstantsPool.Session.CAPTCHA_SESSION_NAME, text);
        ImageIO.write(image, "jpg", jpegOutputStream);
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
