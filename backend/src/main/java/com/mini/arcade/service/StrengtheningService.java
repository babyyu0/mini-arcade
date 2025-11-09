package com.mini.arcade.service;

import com.mini.arcade.dto.StrengtheningGameResponseDto;
import com.mini.arcade.dto.UserRequestDto;

public interface StrengtheningService {
    StrengtheningGameResponseDto init(UserRequestDto userDto);
    StrengtheningGameResponseDto strengthen(UserRequestDto userDto);
    StrengtheningGameResponseDto sell(UserRequestDto userDto);
}
