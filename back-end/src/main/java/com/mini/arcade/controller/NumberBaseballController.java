package com.mini.arcade.controller;

import com.mini.arcade.service.NumberBaseballService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number-baseball")
@RequiredArgsConstructor
public class NumberBaseballController {

    @Autowired
    private final NumberBaseballService numberBaseballService;

    // 1. 난수 번호 생성
    @GetMapping("create")
    public ResponseEntity<?> createRandomNumber(@RequestParam int numCount) {
        numberBaseballService.createRandomNumber(numCount);
        return ResponseEntity.ok().build();
    }

    // 2. 번호에 따른 정답 확인
    @GetMapping("submit")
    public ResponseEntity<?> submitCorrection(@RequestParam String submitNum) {
        return ResponseEntity.ok(numberBaseballService.submitCorrection(submitNum));
    }
}
