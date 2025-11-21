package com.mini.arcade.entity;

import com.mini.arcade.dto.WeaponResDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double percent;
    private int price;
    private String desc;

    public Weapon(int id, String name, double percent, int price, String desc) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.price = price;
        this.desc = desc;
    }

    public WeaponResDto toDto() {
        return new WeaponResDto(id, name, percent, price, desc);
    }
}
