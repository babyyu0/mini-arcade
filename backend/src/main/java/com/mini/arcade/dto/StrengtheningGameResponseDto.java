package com.mini.arcade.dto;

public record StrengtheningGameResponseDto(
        UserResponseDto user,
        WeaponResponseDto weapon,
        int successStatus) {
}
