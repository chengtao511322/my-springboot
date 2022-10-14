package com.ct;

import chentao.springboot.annotation.ChentaoApplication;
import chentao.springboot.core.ChentaoSpringbootApplication;

/**
 * 模拟springboot的功能
 */
@ChentaoApplication
public class MainApplication {

    public static void main(String[] args) {

        ChentaoSpringbootApplication.run(MainApplication.class);
    }
}
