package com.bootcampmeli.apicontrolepedidos.controllers;

import com.bootcampmeli.apicontrolepedidos.entities.Register;
import com.bootcampmeli.apicontrolepedidos.interfaces.IRegisterService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {
    
    private final IRegisterService registerService;

    
    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public Register getTotalRegisterValue() {
        return this.registerService.getTotalRegisterValue();
    }
}
