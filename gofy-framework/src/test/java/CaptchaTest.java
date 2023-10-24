import com.gofy.common.core.domain.AjaxResult;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.nio.ch.IOUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import static com.google.code.kaptcha.Constants.*;

public class CaptchaTest {

    @Test
    public void kaptcha() throws IOException {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put(KAPTCHA_BORDER,"no");
//        properties.put(Constants.KAPTCHA_TEXTPRODUCER_IMPL,"com.google.code.kaptcha.text.impl.ChineseTextProducer");
        properties.setProperty(KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.setProperty(KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);
        File file = new File("D:/kaptcha.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ImageIO.write(image, "jpg", fileOutputStream);
        IOUtils.closeQuietly(fileOutputStream);
        System.out.println(text);

    }

    @Test
    public void getTime(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(1693425622998L);
        String dateStr1 = dateformat.format(1693426243412L);

        System.out.println(dateStr + "----" + dateStr1);

        double random = Math.random();
        System.out.println(random + "------" + Math.round(random * 2));
    }
}
