package com.example.cloudconfigclient1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@SpringBootApplication
public class CloudConfigClient1Application {

    @Value("${key}")
    private String configData;

    @Autowired
    private Environment environment;

    @GetMapping(value = "showWord")
    public String getConfigData(){
        System.out.println(configData);
        System.out.println("environment property: " +  environment.getProperty("key"));
        return configData;
        //return environment.getProperty("test.world");
    }
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient1Application.class, args);
    }

}
