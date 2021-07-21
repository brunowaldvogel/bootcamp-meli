package com.bootcampmeli.apicontrolepedidos.interfaces;

import java.math.BigDecimal;

import com.bootcampmeli.apicontrolepedidos.entities.Register;

public interface IRegisterService {
    
    public Register getTotalRegisterValue();
    public void addToRegister(BigDecimal value);
}
