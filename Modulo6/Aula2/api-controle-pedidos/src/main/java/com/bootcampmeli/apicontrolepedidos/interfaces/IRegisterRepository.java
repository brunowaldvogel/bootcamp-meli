package com.bootcampmeli.apicontrolepedidos.interfaces;

import java.math.BigDecimal;

import com.bootcampmeli.apicontrolepedidos.entities.Register;

public interface IRegisterRepository {
    
    public Register getRegister();
    public void addToRegister(BigDecimal value);
}
