package com.mini.arcade.service;

import com.mini.arcade.dto.GameInfoDto;
import com.mini.arcade.dto.UserDto;

public interface StrengtheningService {
    GameInfoDto init(UserDto userDto);
    GameInfoDto strengthen(UserDto userDto);
    GameInfoDto sell(UserDto userDto);
}
