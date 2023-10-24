package com.gofy.framework.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.google.code.kaptcha.Constants.*;

@Configuration
public class CaptchaConfig {

    @Bean(name = "kaptchaStringProducer")
    public DefaultKaptcha getKaptchaBean(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put(KAPTCHA_BORDER,"true");
        properties.put(KAPTCHA_BORDER_COLOR,"black");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }

    @Bean(name = "kaptchaMathProducer")
    public DefaultKaptcha getKaptchaBeanMath(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put(KAPTCHA_BORDER,"yes");
        properties.put(KAPTCHA_IMAGE_WIDTH, "160");
        properties.put(KAPTCHA_IMAGE_HEIGHT, "60");
        properties.put(KAPTCHA_TEXTPRODUCER_IMPL,"com.gofy.framework.config.KaptchaMathTextCreator");
        properties.setProperty(KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty(KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial,Courier");
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        properties.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "3"); //文本字符间距

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
