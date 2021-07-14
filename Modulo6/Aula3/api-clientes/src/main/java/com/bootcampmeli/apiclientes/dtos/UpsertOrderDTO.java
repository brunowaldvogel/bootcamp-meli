package com.bootcampmeli.apiclientes.dtos;

import java.util.List;

public class UpsertOrderDTO {
    
    private List<ProductDTO> products;


    public UpsertOrderDTO() {}
 
    public UpsertOrderDTO(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
