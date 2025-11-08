package com.mini.arcade.entity;

import com.mini.arcade.dto.WeaponDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Weapon {
    private String name;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int level;
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

    public WeaponDto toDto() {
        return new WeaponDto(name, description, level, strengtheningCost, price, successPer);
    }
}
