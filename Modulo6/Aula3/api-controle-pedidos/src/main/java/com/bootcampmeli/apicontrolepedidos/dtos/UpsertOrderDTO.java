package com.bootcampmeli.apicontrolepedidos.dtos;

import java.util.List;

public class UpsertOrderDTO {
    
    private List<DishDTO> dishes;

    public UpsertOrderDTO() {}
    
    public UpsertOrderDTO(List<DishDTO> dishes) {
        this.dishes = dishes;
    }

    public List<DishDTO> getDishes() {
        return dishes;
    }
}
