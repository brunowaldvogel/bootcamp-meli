package com.bootcampmeli.apicontrolepedidos.services;

import java.math.BigDecimal;

import com.bootcampmeli.apicontrolepedidos.entities.Register;
import com.bootcampmeli.apicontrolepedidos.interfaces.IRegisterRepository;
import com.bootcampmeli.apicontrolepedidos.interfaces.IRegisterService;

import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    
    private final IRegisterRepository registerRepository;


    public RegisterService(IRegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public void addToRegister(BigDecimal value) {
        this.registerRepository.addToRegister(value);
    }

    @Override
    public Register getTotalRegisterValue() {
        return this.registerRepository.getRegister();
    }
}
