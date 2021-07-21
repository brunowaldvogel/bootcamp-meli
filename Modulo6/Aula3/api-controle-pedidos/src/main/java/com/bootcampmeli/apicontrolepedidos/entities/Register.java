package com.bootcampmeli.apicontrolepedidos.entities;

import java.math.BigDecimal;

public class Register {

    private BigDecimal revenue;

    
    public Register() {
        this.revenue = new BigDecimal(0);
    }

    public Register(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }
}
