package com.eureka.a.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.eureka.a.service.ASignalService;
import com.lj.a.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @SentinelResource(value = "getDataInfo", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @GetMapping("dataInfo")
    public String getDataInfo(@RequestParam(defaultValue = "0", value = "startIndex") int startIndex, @RequestParam(defaultValue = "10", value = "endIndex") int endIndex) {
        return JSON.toJSONString(aSignalService.getData(startIndex, endIndex));
    }

    @GetMapping("dataPage")
    public String getPriDataPage(@RequestParam(defaultValue = "1", value = "pageNum") int pageNum, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        return JSON.toJSONString(aSignalService.getDataPage(pageNum, pageSize));
    }
}
