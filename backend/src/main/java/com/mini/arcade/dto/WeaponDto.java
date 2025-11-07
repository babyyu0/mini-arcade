package com.mini.arcade.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WeaponDto {
    private final String name;
    private final String desc;
    private final int level;
    private final int strengtheningCost;
    private final int price;
    private final double successPer;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getLevel() {
        return level;
    }

    public int getStrengtheningCost() {
        return strengtheningCost;
    }

    public int getPrice() {
        return price;
    }

    public double getSuccessPer() {
        return successPer;
    }


}
