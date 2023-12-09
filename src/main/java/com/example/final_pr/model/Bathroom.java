package com.example.final_pr.model;

import com.example.final_pr.dto.BathroomDTO;
import com.example.final_pr.enums.FloorType;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Bathroom {

    @Id
    @GeneratedValue
    private Long id;

    private Integer area;

    private Boolean bath;

    private Boolean shower;

    private Boolean mirror;

    private Boolean washingMachine;

    private Boolean boiler;

    @Enumerated(EnumType.STRING)
    private FloorType floor;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "private_house_id")
    private PrivateHouse privateHouse;

    private Bathroom (Integer area ,Boolean bath, Boolean shower, Boolean mirror,
                      Boolean washingMachine, Boolean boiler, FloorType floor){
        this.area = area;
        this.bath = bath;
        this.shower = shower;
        this.mirror = mirror;
        this.washingMachine = washingMachine;
        this.boiler = boiler;
        this.floor = floor;
    }

    public static Bathroom of(Integer area, Boolean bath, Boolean shower, Boolean mirror,
                              Boolean washingMachine, Boolean boiler, FloorType floor){
        return new Bathroom(area,bath,shower,mirror,washingMachine,boiler,floor);
    }

    public BathroomDTO toDTO(){
        return BathroomDTO.of(area,bath,shower,mirror,washingMachine,boiler,floor);
    }

    public static Bathroom fromDTO(BathroomDTO bathroomDTO){
        return Bathroom.of(bathroomDTO.getArea(), bathroomDTO.getBath(), bathroomDTO.getShower(),
                bathroomDTO.getMirror(), bathroomDTO.getWashingMachine(), bathroomDTO.getBoiler(), bathroomDTO.getFloor());
    }

}
