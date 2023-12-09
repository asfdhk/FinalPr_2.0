package com.example.final_pr.model;

import com.example.final_pr.dto.RoomDTO;
import com.example.final_pr.enums.FloorType;
import com.example.final_pr.enums.RoomType;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private Integer area;

    private Boolean tv;

    private Boolean board;

    @Enumerated(EnumType.STRING)
    private FloorType floor;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "private_house_id")
    private PrivateHouse privateHouse;

    private Room(Integer area, Boolean tv, Boolean board, FloorType floor, RoomType type){
        this.area = area;
        this.tv = tv;
        this.board = board;
        this.floor = floor;
        this.type = type;
    }

    public static Room of(Integer area, Boolean tv, Boolean board, FloorType floor, RoomType type){
        return new Room(area,tv,board,floor,type);
    }

    public RoomDTO toDTO(){
        return RoomDTO.of(area,tv,board,floor,type);
    }

    public static Room fromDTO(RoomDTO roomDTO){
        return Room.of(roomDTO.getArea(), roomDTO.getTv(), roomDTO.getBoard(),
                roomDTO.getFloor(), roomDTO.getType());
    }
}
