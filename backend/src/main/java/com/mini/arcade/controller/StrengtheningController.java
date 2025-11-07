package com.mini.arcade.controller;

import com.mini.arcade.dto.GameInfoDto;
import com.mini.arcade.dto.UserDto;
import com.mini.arcade.service.StrengtheningService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/strengthening")
@RestController
public class StrengtheningController {

    @Autowired
    private final StrengtheningService strengtheningService;

    // 게임이 처음 시작될 때 정보 세팅
    @PostMapping("/init")
    public ResponseEntity<?> init(@RequestBody UserDto userDto){
        return ResponseEntity.ok(strengtheningService.init(userDto));
    }

    // 게임이 처음 시작될 때 정보 세팅
    @PostMapping("/strengthening")
    public ResponseEntity<?> strengthening(@RequestBody UserDto userDto){
        return ResponseEntity.ok(strengtheningService.strengthening(userDto));
    }
}
