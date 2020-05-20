package com.example.serviceaserver.service;

import com.example.servicepriinterface.service.PriService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-pri-server")
public interface PriServicePri extends PriService {
}
