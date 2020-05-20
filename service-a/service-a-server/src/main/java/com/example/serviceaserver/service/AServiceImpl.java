package com.example.serviceaserver.service;

import com.example.serviceainterface.service.AService;
import org.springframework.stereotype.Service;

@Service
public class AServiceImpl implements AService {
    @Override
    public String getA(int start, int end) {
        return "a service getA()";
    }
}
