package com.mini.arcade.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
public class UserDto {
    private final String ip;
    private final long money;
}
