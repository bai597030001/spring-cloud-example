package com.example.serviceabis;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
@RestController
@CrossOrigin(allowCredentials = "true")
public class ServiceAbisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAbisApplication.class, args);
    }

    @HystrixCommand(fallbackMethod = "myFallback")
    @GetMapping("/abis")
    public String getAbis(@RequestParam(defaultValue = "1", value = "pageNum") int pageNum, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize){
        return "this is abis service get! pageNum = " + pageNum + ", " + "pageSize = " + pageSize;
    }

    /**
     * 方法simpleHystrixClientCall的回退方法，可以指定将hystrix执行失败异常传入到方法中
     * @param start ystrix执行失败的传入方法的请求
     * @param end hystrix执行失败的异常对象
     * @return
     */
    String myFallback(int start, int end) {
        return "Execute raw fallback: access service fail , start = " + start + " end = " + end;
    }

    /**
     * 这里我指定的urlMapping 是/test/hystrix.stream 那么我在monitor stream 的时候填写的地址就是:
     * http://ip:port/actuator/hystrix.stream
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");  // 这里指定的urlMapping 就是我们在仪表盘中monitor Stream 的地址后缀
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
