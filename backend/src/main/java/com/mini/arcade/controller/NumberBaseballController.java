package com.mini.arcade.controller;

import com.mini.arcade.dto.UserRequestDto;
import com.mini.arcade.service.NumberBaseballService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/number-baseball")
@RestController
public class NumberBaseballController {

    NumberBaseballService numberBaseballService;

    // 게임이 처음 시작될 때 정보 세팅
//    @PostMapping("init")
//    public ResponseEntity<?> init(@RequestBody UserRequestDto userDto){
//        return ResponseEntity.ok(numberBasebkallService.init(userDto));
//    }
}
