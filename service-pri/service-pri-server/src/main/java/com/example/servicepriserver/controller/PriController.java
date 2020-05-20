package com.example.servicepriserver.controller;

import com.example.servicepriinterface.service.PriService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true")
public class PriController {

    @Resource
    private PriService priService;

    @GetMapping("pri")
    public String getPri(@RequestParam(defaultValue = "1", value = "start") int start, @RequestParam(defaultValue = "1", value = "end") int end){
        return priService.getPri(start, end);
    }

}
