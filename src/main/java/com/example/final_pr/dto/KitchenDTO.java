package com.example.final_pr.dto;


import com.example.final_pr.enums.FloorType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class KitchenDTO {

    private Integer area;

    private Boolean dishWash;

    private Boolean microwaveOven;

    private Boolean refrigerator;

    private Boolean oven;

    private Boolean cooker;

    @Enumerated(EnumType.STRING)
    private FloorType floor;

    private KitchenDTO(Integer area, Boolean dishWash, Boolean microwaveOven,
                       Boolean refrigerator, Boolean oven, Boolean cooker,FloorType floor){
        this.area = area;
        this.dishWash = dishWash;
        this.microwaveOven = microwaveOven;
        this.refrigerator = refrigerator;
        this.oven = oven;
        this.cooker = cooker;
        this.floor = floor;
    }

    public static KitchenDTO of(Integer area, Boolean dishWash, Boolean microwaveOven,
                                Boolean refrigerator, Boolean oven, Boolean cooker,FloorType floor){
        return new KitchenDTO(area, dishWash, microwaveOven, refrigerator, oven, cooker,floor);
    }
}
