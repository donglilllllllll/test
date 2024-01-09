package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kaixiang
 * date:2024/1/5 9:52
 */
@SpringBootApplication
public class Springboot0102QuickstartApplication {

    public static void main(String[] args) {

        // SpringApplication.run(Springboot0102QuickstartApplication.class, args);

        //再启动boot程序是关闭读取外部配置文件对应的入口
        SpringApplication.run(Springboot0102QuickstartApplication.class);
    }

}
