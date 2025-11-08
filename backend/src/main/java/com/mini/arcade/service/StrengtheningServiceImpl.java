package com.mini.arcade.service;

import com.mini.arcade.dto.GameInfoDto;
import com.mini.arcade.dto.UserDto;
import com.mini.arcade.dto.WeaponDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class StrengtheningServiceImpl implements StrengtheningService {
    // DB 구성 전 임의의 무기 리스트
    private final List<WeaponDto> weaponList = new ArrayList<>();
    private final Map<String, GameInfoDto> gameInfoMap = new HashMap<>();

    @Override
    public GameInfoDto init(UserDto userDto) {
        // 무기 리스트 저장
        if (weaponList.isEmpty()) {
            setWeaponList();
        }

        WeaponDto weapon = weaponList.getFirst();
        // TO DO : 추후 기본 금액 static 상수로 바꾸기
        UserDto user = new UserDto(userDto.getIp(), 100000);
        GameInfoDto gameInfoDto = new GameInfoDto(user, weapon);
        gameInfoMap.put(user.getIp(), gameInfoDto);

        return gameInfoDto;
    }

    @Override
    public GameInfoDto strengthen(UserDto userDto) {
        GameInfoDto gameInfoDto = getGameInfoDto(userDto);
        if(gameInfoDto == null || weaponList.isEmpty()) {
            return null;
        }

        // 강화 비용 결제
        long payMoney = userDto.getMoney() - gameInfoDto.getWeapon().getStrengtheningCost();
        UserDto user = new UserDto(userDto.getIp(), payMoney);

        // 1부터  100까지의 숫자
        short randomNumber = (short) (Math.random() * 100 + 1);
        WeaponDto nextWeapon;
        if(randomNumber <= gameInfoDto.getWeapon().getSuccessPer()) {
            nextWeapon = weaponList.get(gameInfoDto.getWeapon().getLevel() + 1);
        } else {
            nextWeapon = weaponList.getFirst();
        }
        gameInfoDto = new GameInfoDto(user, nextWeapon);
        gameInfoMap.put(gameInfoDto.getUser().getIp(), gameInfoDto);

        return gameInfoDto;
    }

    @Override
    public GameInfoDto sell(UserDto userDto) {
        GameInfoDto gameInfoDto = getGameInfoDto(userDto);
        if(gameInfoDto == null || weaponList.isEmpty()) {
            return null;
        }

        // 판매 비용 결산
        long payMoney = userDto.getMoney() + gameInfoDto.getWeapon().getPrice();
        UserDto user = new UserDto(userDto.getIp(), payMoney);
        WeaponDto weapon = weaponList.getFirst();

        gameInfoDto = new GameInfoDto(user, weapon);
        gameInfoMap.put(gameInfoDto.getUser().getIp(), gameInfoDto);

        return gameInfoDto;
    }

    private GameInfoDto getGameInfoDto(UserDto userDto) {
        String userIp = userDto.getIp();
        if(!gameInfoMap.containsKey(userIp)) {
            return null;
        }

        return gameInfoMap.get(userIp);
    }

    private void setWeaponList() {
        if (weaponList.isEmpty()) {
            weaponList.add(new WeaponDto("원시 점액", "사육장에 막 방출된 불안정한 유기물 덩어리", 0, 100, 0, 100));
            weaponList.add(new WeaponDto("편모 생성", "스스로 움직이기 위해 작은 꼬리가 생겨났다", 1, 300, 50, 90));
            weaponList.add(new WeaponDto("안점 발현", "빛을 감지하는 원시적인 눈(점)이 생겨났다", 2, 700, 200, 85));
            weaponList.add(new WeaponDto("다중 감각", "주변을 감지하는 더듬이 같은 돌기가 돋아났다", 3, 900, 900, 80));
            weaponList.add(new WeaponDto("기묘한 아가미", "물이 아닌 공기 중에서 기괴한 소리를 낸다", 4, 1100, 1500, 70));
            weaponList.add(new WeaponDto("과잉 사지", "필요 이상으로 많은 다리가 몸을 뒤덮기 시작한다", 5, 1300, 2000, 65));
            weaponList.add(new WeaponDto("결정화 피부", "피부 일부가 단단한 수정 결정체로 변이했다", 6, 1600, 4300, 60));
            weaponList.add(new WeaponDto("제3의 눈", "이마에 불길한 기운의 세 번째 눈이 개안했다", 7, 1800, 6500, 50));
            weaponList.add(new WeaponDto("포자 방출체", "걸어 다닐 때마다 기괴한 색의 포자를 퍼뜨린다", 8, 2000, 8000, 45));
            weaponList.add(new WeaponDto("불안정한 융합", "주변의 다른 생물을 흡수하려는 본능이 생겼다", 9, 2200, 10000, 40));
            weaponList.add(new WeaponDto("유령 상태", "몸이 반투명해지며 벽을 통과하려 한다.", 10, 26000, 20000, 10));
        }
    }
}
