package com.mini.arcade.controller;

import com.mini.arcade.dto.UserDto;
import com.mini.arcade.service.StrengtheningService;
import lombok.RequiredArgsConstructor;
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
    @PostMapping("init")
    public ResponseEntity<?> init(@RequestBody UserDto userDto){
        return ResponseEntity.ok(strengtheningService.init(userDto));
    }

    // 무기 강화하기
    @PostMapping("strengthen")
    public ResponseEntity<?> strengthen(@RequestBody UserDto userDto){
        return ResponseEntity.ok(strengtheningService.strengthen(userDto));
    }

    // 무기 강화하기
    @PostMapping("sell")
    public ResponseEntity<?> sell(@RequestBody UserDto userDto){
        return ResponseEntity.ok(strengtheningService.sell(userDto));
    }
}
