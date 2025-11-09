package com.mini.arcade.service;

import com.mini.arcade.dto.StrengtheningGameResponseDto;
import com.mini.arcade.dto.UserRequestDto;
import com.mini.arcade.entity.User;
import com.mini.arcade.entity.Weapon;
import com.mini.arcade.enums.SuccessStatus;
import com.mini.arcade.repository.UserRepository;
import com.mini.arcade.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class StrengtheningServiceImpl implements StrengtheningService {

    private final WeaponRepository weaponRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public StrengtheningGameResponseDto init(UserRequestDto userDto) {
        // 강화 단계를 처음으로 설정
        Weapon weapon = weaponRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("무기를 찾을 수 없습니다!"));

        User user = new User(userDto.ip(), 100000, weapon);
        userRepository.saveAndFlush(user);

        return new StrengtheningGameResponseDto(user.toResponseDto(), weapon.toResponseDto(), SuccessStatus.NONE.value());
    }

    @Override
    @Transactional
    public StrengtheningGameResponseDto strengthen(UserRequestDto userDto) {
        User user = userRepository.findById(userDto.ip())
                .orElseThrow(() -> new IllegalArgumentException("무기를 찾을 수 없습니다!"));
        Weapon weapon = user.getWeapon();

        // 강화 비용 결제
        long payMoney = user.getMoney() - weapon.getStrengtheningCost();
        user.setMoney(payMoney);

        // 1부터  100까지의 숫자
        short randomNumber = (short) (Math.random() * 100 + 1);
        log.info("Selected random number is {}", randomNumber);

        Optional<Weapon> nextWeapon;
        SuccessStatus successStatus =  SuccessStatus.NONE;
        if(randomNumber <= weapon.getSuccessPer()) {
            nextWeapon = weaponRepository.findById(weapon.getId() + 1L);
            successStatus = SuccessStatus.SUCCEED;
        } else {
            nextWeapon = weaponRepository.findById(1L);
            successStatus = SuccessStatus.FAIL;
        }

        log.info("success status is {}", successStatus);

        user.setWeapon(nextWeapon.orElseThrow());
        userRepository.saveAndFlush(user);

        return new StrengtheningGameResponseDto(user.toResponseDto(), nextWeapon.get().toResponseDto(), successStatus.value());
    }

    @Override
    public StrengtheningGameResponseDto sell(UserRequestDto userDto) {
        User user = userRepository.findById(userDto.ip())
                .orElseThrow(() -> new IllegalArgumentException("무기를 찾을 수 없습니다!"));
        Weapon weapon = user.getWeapon();

        // 판매 비용 결산
        long payMoney = user.getMoney() + weapon.getPrice();
        user.setMoney(payMoney);

        Weapon nextWeapon = weaponRepository.findById(1L).orElseThrow();
        user.setWeapon(nextWeapon);
        userRepository.saveAndFlush(user);

        return new StrengtheningGameResponseDto(user.toResponseDto(), nextWeapon.toResponseDto(), SuccessStatus.NONE.value());
    }
}
