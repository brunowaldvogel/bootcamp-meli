package com.bootcampmeli.apicontrolepedidos.repositories;

import java.math.BigDecimal;

import com.bootcampmeli.apicontrolepedidos.entities.Register;
import com.bootcampmeli.apicontrolepedidos.interfaces.IRegisterRepository;

import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository implements IRegisterRepository {

    private Register register;


    public RegisterRepository() {
        this.register = new Register();
    }

    @Override
    public void addToRegister(BigDecimal value) {
        this.register.setRevenue(this.register.getRevenue().add(value));
    }

    @Override
    public Register getRegister() {
        return this.register;
    }
}
