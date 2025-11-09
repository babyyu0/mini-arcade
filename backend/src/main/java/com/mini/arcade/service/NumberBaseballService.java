package com.mini.arcade.service;

import com.mini.arcade.dto.NumberBaseballGameResponseDto;
import com.mini.arcade.dto.UserRequestDto;

public interface NumberBaseballService {
    NumberBaseballGameResponseDto init(UserRequestDto userDto);
}
