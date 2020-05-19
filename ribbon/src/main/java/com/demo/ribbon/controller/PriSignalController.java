package com.demo.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
public class PriSignalController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @HystrixCommand(fallbackMethod="hystrixFallback")
    @GetMapping("data")
    public String data() {
        Object results = restTemplate.getForObject("http://EUREKA-PRI/pri/data?dataNum=5359812", Object.class);
        if (results != null) {
            return results.toString();
        }
        return "empty results";
    }

    @HystrixCommand(fallbackMethod="hystrixFallback")
    @GetMapping("list")
    public String test() throws Exception {
        List results = restTemplate.getForObject("http://EUREKA-PRI/pri/dataPage?pageNum=1&pageSize=10", List.class);
        return results.toString();
    }

    //这个方法是上面的方法发生错误的时候调用
    //回调方法参数与上面的一模一样。
    public String hystrixFallback(){
        System.out.println("hystrixFallback error");
        return "hystrixFallback error";
    }
}
