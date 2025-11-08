package com.mini.arcade.dto;

public record WeaponDto(
        String name,
        String description,
        int level,
        int strengtheningCost,
        int price,
        double successPer) {
}
