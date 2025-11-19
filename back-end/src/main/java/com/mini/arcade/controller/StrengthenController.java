package com.mini.arcade.controller;

import com.mini.arcade.service.StrengthenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strengthen")
@RequiredArgsConstructor
public class StrengthenController {

    @Autowired
    StrengthenService strengthenService;

    // 1. 현재 자산 및 무기 세팅
    @GetMapping("init")
    public ResponseEntity<?> initStatus() {
        return ResponseEntity.ok(strengthenService.initStatus());
    }

    // 2. 강화하기

    // 3. 판매하기

}
