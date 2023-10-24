package com.gofy.web.controller.common;

import com.gofy.common.core.domain.AjaxResult;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CaptchaController {

    @Resource(name = "kaptchaMathProducer")
    private DefaultKaptcha kaptchaMathProducer;

    @GetMapping("/captchaImage")
    public AjaxResult getCode(){
        AjaxResult ajaxResult = AjaxResult.success();

        //验证码开关是否打开
        ajaxResult.put("captchaEnabled",true);

        //生成验证码
        String text = kaptchaMathProducer.createText();
        text = text.substring(0, text.indexOf("?") + 1);

        BufferedImage image = kaptchaMathProducer.createImage(text);
        //验证码图片信息写出
        FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", fastByteArrayOutputStream);
        } catch (IOException e) {
            AjaxResult.error("验证码图片生成错误");
        }

        ajaxResult.put("img", Base64.encode(fastByteArrayOutputStream.toByteArray()));
        return ajaxResult;
    }
}
