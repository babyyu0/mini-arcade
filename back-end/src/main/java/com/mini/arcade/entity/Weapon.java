package com.mini.arcade.entity;

import com.mini.arcade.dto.WeaponResDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Weapon {
    private final int id;
    private final String name;
    private final double percent;
    private final int price;
    private final String desc;

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
