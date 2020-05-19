package com.demo.cloudeurekaserver;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class CloudEurekaServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() throws IOException {
        String command = "dir C:";
        String output;

        // 检查是否为Windows操作系统，Windows系统下参数做特殊处理
        if (System.getProperty("os.name").startsWith("Windows")) {
            command = "cmd /c " + command;
            //output = " > %TEMP%/" + "cloud-eureka" + "-" + System.nanoTime() + ".log";
            output = "> E:/temp/cloud-eureka.log";
        } else {
            output = " > /dev/null";
        }
        command += output; //追加重定向信息
        Runtime.getRuntime().exec(command);
    }
}
