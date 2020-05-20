package com.example.serviceaserver.controller;

import com.example.serviceainterface.service.AService;
import com.example.serviceaserver.service.PriServicePri;
import com.example.servicepriinterface.service.PriService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true")
public class AController {

    @Resource
    private AService aService;

    @Resource
    private PriServicePri priService;

    @GetMapping("a")
    String getA(@RequestParam(defaultValue = "1", value = "start") int start, @RequestParam(defaultValue = "1", value = "end") int end){
        return priService.getPri(start, end);
    }
}
