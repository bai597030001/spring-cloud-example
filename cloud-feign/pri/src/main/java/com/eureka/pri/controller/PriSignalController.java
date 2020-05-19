package com.eureka.pri.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.eureka.pri.exception.ExceptionUtil;
import com.eureka.pri.service.impl.PriSignalService;
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
    public String getPriData(@RequestParam(defaultValue = "1", value = "dataNum") long dataNum) throws InterruptedException {
        Thread.sleep(3000);
        return JSON.toJSONString(priSignalService.getDataById(dataNum));
    }

    @SentinelResource(value = "getPriDataInfo", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @GetMapping("dataInfo")
    public String getPriDataInfo(@RequestParam(defaultValue = "0", value = "startIndex") int startIndex, @RequestParam(defaultValue = "10", value = "endIndex") int endIndex) {
        return JSON.toJSONString(priSignalService.getData(startIndex, endIndex));
    }

    @GetMapping("dataPage")
    public String getPriDataPage(@RequestParam(defaultValue = "1", value = "pageNum") int pageNum, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        return JSON.toJSONString(priSignalService.getPriDataPage(pageNum, pageSize));
    }

}
