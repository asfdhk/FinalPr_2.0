package com.example.final_pr.model;

import com.example.final_pr.dto.KitchenDTO;
import com.example.final_pr.enums.FloorType;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Kitchen {

    @Id
    @GeneratedValue
    private Long id;

    private Integer area;

    private Boolean dishWash;

    private Boolean microwaveOven;

    private Boolean refrigerator;

    private Boolean oven;

    private Boolean cooker;

    @Enumerated(EnumType.STRING)
    private FloorType floor;

    @OneToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @OneToOne
    @JoinColumn(name = "private_house_id")
    private PrivateHouse privateHouse;

    private Kitchen(Integer area , Boolean dishWash, Boolean microwaveOven,
                    Boolean refrigerator, Boolean oven, Boolean cooker, FloorType floor){
        this.area = area;
        this.dishWash = dishWash;
        this.microwaveOven = microwaveOven;
        this.refrigerator = refrigerator;
        this.oven = oven;
        this.cooker = cooker;
        this.floor = floor;
    }

    public static Kitchen of(Integer area , Boolean dishWash, Boolean microwaveOven,
                             Boolean refrigerator, Boolean oven, Boolean cooker, FloorType floor){
        return new Kitchen(area,dishWash,microwaveOven,refrigerator,oven,cooker,floor);
    }

    public KitchenDTO toDTO(){
        return KitchenDTO.of(area,dishWash,microwaveOven,refrigerator,oven,cooker,floor);
    }

    public static Kitchen fromDTO(KitchenDTO kitchenDTO){
        return Kitchen.of(kitchenDTO.getArea(), kitchenDTO.getDishWash(), kitchenDTO.getMicrowaveOven(),
                kitchenDTO.getRefrigerator(), kitchenDTO.getOven(), kitchenDTO.getCooker(), kitchenDTO.getFloor());
    }


}
