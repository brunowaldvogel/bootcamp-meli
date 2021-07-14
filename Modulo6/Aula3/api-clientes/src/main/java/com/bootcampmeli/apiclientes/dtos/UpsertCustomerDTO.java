package com.bootcampmeli.apiclientes.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpsertCustomerDTO {
    
    @NotBlank
    private String cpf;

    @NotBlank
    @Email
    private String email;

    private String cellphone;


    public UpsertCustomerDTO() {}

    public UpsertCustomerDTO(
            String cpf, 
            String email, 
            String cellphone) {
        this.cpf = cpf;
        this.email = email;
        this.cellphone = cellphone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCellphone() {
        return this.cellphone;
    }
}
