package com.mini.arcade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
public class GameInfoDto {
    private final UserDto user;
    private final WeaponDto weapon;
}
