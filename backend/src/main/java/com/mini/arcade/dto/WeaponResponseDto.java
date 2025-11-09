package com.mini.arcade.dto;

public record WeaponResponseDto(
        long id,
        String name,
        String description,
        long energy,
        int strengtheningCost,
        int price,
        double successPer) {
}
