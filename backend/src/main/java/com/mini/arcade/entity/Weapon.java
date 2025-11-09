package com.mini.arcade.entity;

import com.mini.arcade.dto.WeaponResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private long energy;
    private int strengtheningCost;
    private int price;
    private double successPer;

    @OneToMany(mappedBy = "weapon")
    private List<User> userList = new ArrayList<>();

    public Weapon(String name, String description, int strengtheningCost, int price, double successPer) {
        this.name = name;
        this.description = description;
        this.strengtheningCost = strengtheningCost;
        this.price = price;
        this.successPer = successPer;
    }

    public WeaponResponseDto toResponseDto() {
        return new WeaponResponseDto(id, name, description, energy, strengtheningCost, price, successPer);
    }
}
