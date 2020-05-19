package com.eureka.a.controller;

import com.alibaba.fastjson.JSON;
import com.eureka.a.service.ASignalService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/a")
public class ASignalController {

    @Autowired
    private ASignalService aSignalService;

    @GetMapping("data")
    public String getPriData(@RequestParam(defaultValue = "1", value = "dataNum") long dataNum) {
        return JSON.toJSONString(aSignalService.getDataById(dataNum));
    }

    @HystrixCommand(fallbackMethod = "myFallback")
    @GetMapping("dataInfo")
    public String getDataInfo(@RequestParam(defaultValue = "0", value = "startIndex") int startIndex, @RequestParam(defaultValue = "10", value = "endIndex") int endIndex) {
        return JSON.toJSONString(aSignalService.getData(startIndex, endIndex));
    }

    @HystrixCommand(fallbackMethod = "myFallback")
    @GetMapping("dataPage")
    public String getPriDataPage(@RequestParam(defaultValue = "1", value = "pageNum") int pageNum, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        return JSON.toJSONString(aSignalService.getDataPage(pageNum, pageSize));
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
}
