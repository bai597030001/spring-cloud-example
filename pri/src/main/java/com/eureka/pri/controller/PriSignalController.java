package com.eureka.pri.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.eureka.pri.exception.ExceptionUtil;
import com.eureka.pri.service.impl.PriSignalService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("pri")
public class PriSignalController {

    @Resource
    private PriSignalService priSignalService;

    @GetMapping("data")
    public String getPriData(@RequestParam(defaultValue = "1", value = "dataNum") long dataNum) {
        return JSON.toJSONString(priSignalService.getDataById(dataNum));
    }

    @HystrixCommand(fallbackMethod = "myFallback")
    @SentinelResource(value = "getPriDataInfo", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @GetMapping("dataInfo")
    public String getPriDataInfo(@RequestParam(defaultValue = "0", value = "startIndex") int startIndex, @RequestParam(defaultValue = "10", value = "endIndex") int endIndex) {
        return JSON.toJSONString(priSignalService.getData(startIndex, endIndex));
    }

    @HystrixCommand(fallbackMethod = "myFallback")
    @GetMapping("dataPage")
    public String getPriDataPage(@RequestParam(defaultValue = "1", value = "pageNum") int pageNum, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        //Thread.sleep(5000);
        //int i = 1/0;
        return JSON.toJSONString(priSignalService.getPriDataPage(pageNum, pageSize));
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
