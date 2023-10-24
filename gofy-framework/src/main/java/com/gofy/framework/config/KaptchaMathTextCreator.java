package com.gofy.framework.config;

import com.google.code.kaptcha.text.impl.DefaultTextCreator;

import java.security.SecureRandom;
import java.util.Random;
import java.util.RandomAccess;

public class KaptchaMathTextCreator extends DefaultTextCreator {

    @Override
    public String getText(){

        Random random = new SecureRandom();
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        int randomoperands = (int) Math.round(Math.random() * 2);

        StringBuilder result = new StringBuilder();

        if(randomoperands == 0){
            int calResult = x * y;
            result.append(x).append("*").append(y).append("=?").append(calResult);
        }else if(randomoperands == 1){
            if(y == 0 || x % y != 0){
                int calResult = x + y;
                result.append(x).append("+").append(y).append("=?").append(calResult);
            }else {
                int calResult = x / y;
                result.append(x).append("/").append(y).append("=?").append(calResult);
            }
        }else{
            if(x >= y){
                int calResult = x - y;
                result.append(x).append("-").append(y).append("=?").append(calResult);
            }else{
                int calResult = y - x;
                result.append(y).append("-").append(x).append("=?").append(calResult);
            }
        }
        return result.toString();
    }
}
